package org.dddml.wms.domain.shipment;

import org.apache.commons.beanutils.ConvertUtils;
import org.dddml.wms.domain.attributesetinstance.AbstractAttributeSetInstanceCommand;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceCommand;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.domain.shipmenttype.ShipmentTypeIds;
import org.dddml.wms.domain.statusitem.StatusItemIds;
import org.dddml.wms.domain.warehouse.WarehouseUtils;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by yangjiefeng on 2018/2/1.
 */
public class ShipmentApplicationServiceImpl extends AbstractShipmentApplicationService.SimpleShipmentApplicationService {

    ProductApplicationService getProductApplicationService() {
        return (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }

    AttributeSetInstanceApplicationService getAttributeSetInstanceApplicationService() {
        return (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
    }

    AttributeSetService getAttributeSetService() {
        return (AttributeSetService) ApplicationContext.current.get("attributeSetService");
    }

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public final IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public final void setSeqIdGenerator(IdGenerator<Long, Object, Object> value) {
        seqIdGenerator = value;
    }

    public ShipmentApplicationServiceImpl(EventStore eventStore, ShipmentStateRepository stateRepository, ShipmentStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ConfirmAllItemsReceived c) {

        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.PURCH_SHIP_SHIPPED);

        Map<Object, ShipmentReceiptState> shipmentReceiptDict = StreamSupport.stream(
                shipment.getShipmentReceipts().spliterator(), false)
                .collect(Collectors.toMap(i -> i.getShipmentItemSeqId(), i -> i));

        Map<Object, ShipmentItemState> shipmentItemDict = StreamSupport.stream(
                shipment.getShipmentItems().spliterator(), false)
                .collect(Collectors.toMap(i -> i.getShipmentItemSeqId(), i -> i));


        Optional<Object> itemIdNotFound = StreamSupport.stream(shipmentItemDict.keySet().spliterator(), false)
                .filter((i -> !shipmentReceiptDict.containsKey((String) i))).findFirst();
        if (itemIdNotFound.isPresent()) {
            throw new IllegalArgumentException(String.format("Shipment item NOT received. ShipmentItemSeqId.: %1$s", itemIdNotFound.get()));
        }
        // /////////////////////////////
        Optional<ShipmentReceiptState> receiptUnknown = StreamSupport.stream(shipmentReceiptDict.values().spliterator(), false)
                .filter(i -> !shipmentItemDict.containsKey(((ShipmentItemState) i).getShipmentItemSeqId())).findFirst();
        if (receiptUnknown.isPresent()) {
            throw new IllegalArgumentException(String.format("Shipment receipt has unknown ShipmentItemSeqId.: %1$s", receiptUnknown.get().getShipmentItemSeqId()));
        }

        List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries = confirmAllItemsReceivedCreateInventoryItemEntries(shipment, shipmentReceiptDict.values());
        InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);

        super.when(c);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ReceiveItem c) {
        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.PURCH_SHIP_SHIPPED);
        ShipmentItemState shipmentItem = shipment.getShipmentItems().get(c.getShipmentItemSeqId());
        if (shipmentItem == null) {
            throw new IllegalArgumentException(String.format(
                    "CANNOT get shipment item. ShipmentItemSeqId: %1$s", c.getShipmentItemSeqId()));
        }
        if (!shipmentItem.getQuantity().equals(c.getAcceptedQuantity().add(c.getRejectedQuantity()))) {
            throw new IllegalArgumentException(String.format(
                    "shipmentItem.Quantity != c.AcceptedQuantity + c.RejectedQuantity. %1$s != %2$s + %3$s",
                    shipmentItem.getQuantity(), c.getAcceptedQuantity(), c.getRejectedQuantity()));
        }
        // ////////////////////////////////////////////////////
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = createOrUpdateShipmentReceipt(c, shipment, shipmentItem);
        // ////////////////////////////////////////////////////
        updateShipment(c, updateReceipt);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.Import c) {
        ShipmentCommand.CreateShipment shipment = new AbstractShipmentCommand.SimpleCreateShipment();
        shipment.setShipmentId(c.getShipmentId());
        shipment.setShipmentTypeId(c.getShipmentTypeId());
        shipment.setOriginFacilityId(c.getOriginFacilityId());
        shipment.setDestinationFacilityId(c.getDestinationFacilityId());
        shipment.setPartyIdFrom(c.getPartyIdFrom());
        shipment.setPartyIdTo(c.getPartyIdTo());
        if (Objects.equals(c.getShipmentTypeId(), ShipmentTypeIds.PURCHASE_SHIPMENT)
                || Objects.equals(c.getShipmentTypeId(), ShipmentTypeIds.INCOMING_SHIPMENT)) {
            shipment.setStatusId(StatusItemIds.PURCH_SHIP_CREATED);
        } else {
            shipment.setStatusId(StatusItemIds.SHIPMENT_INPUT);
        }
        //todo More properties...

        List<ShipmentItemCommand.CreateShipmentItem> shipItems = new ArrayList<ShipmentItemCommand.CreateShipmentItem>();
        int i = 0;
        for (ImportingShipmentItem d : c.getShipmentItems()) {
            ShipmentItemCommand.CreateShipmentItem shipItem = createShipmentItem(i, d);

            shipment.getShipmentItems().add(shipItem);
            i++;
        }
        when(shipment);
    }


    protected List<InventoryItemEntryCommand.CreateInventoryItemEntry> confirmAllItemsReceivedCreateInventoryItemEntries(ShipmentState shipment, Iterable<ShipmentReceiptState> receipts) {
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> entries = new ArrayList<>();
        for (ShipmentReceiptState d : receipts) {
            InventoryItemEntryCommand.CreateInventoryItemEntry e = createInventoryItemEntry(shipment, d);
            entries.add(e);
        }
        return entries;
    }

    protected InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(ShipmentState shipment, ShipmentReceiptState lineReceipt) {
        String targetLocatorId = WarehouseUtils.getReceivingLocatorId(shipment.getDestinationFacilityId());
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        entry.setInventoryItemId(new InventoryItemId(lineReceipt.getProductId(), targetLocatorId, lineReceipt.getAttributeSetInstanceId()));
        entry.setEntrySeqId(getSeqIdGenerator().getNextId()); //DateTime.Now.Ticks;
        entry.setOnHandQuantity(lineReceipt.getAcceptedQuantity()); // *signum;
        entry.setSource(new InventoryItemSourceInfo(DocumentTypeIds.SHIPMENT, shipment.getShipmentId(),
                lineReceipt.getReceiptSeqId(), 0));
        return entry;
    }

    private ShipmentItemCommand.CreateShipmentItem createShipmentItem(int i, ImportingShipmentItem d) {
        ShipmentItemCommand.CreateShipmentItem shipItem = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
        ProductState prdState = getProductState(d.getProductId());

        String attrSetInstId = createAttributeSetInstance(prdState.getAttributeSetId(), d.getAttributeSetInstance());
        //        if (_log.IsDebugEnabled) {
        //            _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //        }

        shipItem.setShipmentItemSeqId((new Integer(i)).toString());
        shipItem.setProductId(prdState.getProductId());
        shipItem.setAttributeSetInstanceId(attrSetInstId);
        shipItem.setQuantity(d.getQuantity());
        shipItem.setActive(true);
        //todo More proerties???
        return shipItem;
    }

    private void updateShipment(ShipmentCommands.ReceiveItem c, ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt) {
        ShipmentCommand.MergePatchShipment updateShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
        updateShipment.getShipmentReceiptCommands().add(updateReceipt);
        updateShipment.setShipmentId(c.getShipmentId());
        updateShipment.setVersion(c.getVersion());
        updateShipment.setCommandId(c.getCommandId());
        updateShipment.setRequesterId(c.getRequesterId());
        when(updateShipment);
    }

    private ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt createOrUpdateShipmentReceipt(ShipmentCommands.ReceiveItem c, ShipmentState shipment, ShipmentItemState shipmentItem) {
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = null;
        String receiptSeqId = c.getShipmentItemSeqId();
        ShipmentReceiptState receipt = shipment.getShipmentReceipts().get(receiptSeqId, false, true);
        if (receipt == null) {
            updateReceipt = new AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt();
        } else {
            updateReceipt = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
        }

        ProductState prdState = getProductState(shipmentItem.getProductId());

        String attrSetInstId = createAttributeSetInstance(prdState.getAttributeSetId(), c.getAttributeSetInstance());
        //        if (_log.IsDebugEnabled) {
        //            _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //        }

        updateReceipt.setAttributeSetInstanceId(attrSetInstId);
        updateReceipt.setReceiptSeqId(receiptSeqId);
        updateReceipt.setShipmentItemSeqId(shipmentItem.getShipmentItemSeqId());
        updateReceipt.setProductId(shipmentItem.getProductId());
        updateReceipt.setAcceptedQuantity(c.getAcceptedQuantity());
        updateReceipt.setRejectedQuantity(c.getRejectedQuantity());
        updateReceipt.setDamagedQuantity(c.getDamagedQuantity());
        updateReceipt.setDamageStatusId(c.getDamageStatusId());
        updateReceipt.setDamageReasonId(c.getDamageReasonId());
        updateReceipt.setReceivedBy(c.getRequesterId());
        return updateReceipt;
    }

    private String createAttributeSetInstance(String attrSetId, Map<String, Object> attrSetInstDict) {
        if (attrSetId == null) {
            return null;
        }
        Map<String, String> nameDict = getAttributeSetService().getPropertyExtensionFieldDictionary(attrSetId);

        AttributeSetInstanceCommand.CreateAttributeSetInstance createAttrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        for (Map.Entry<String, Object> kv : attrSetInstDict.entrySet()) {
            String fname = nameDict.containsKey(kv.getKey()) ? nameDict.get(kv.getKey()) : kv.getKey();
            // createAttrSetInst.AirDryMetricTon = (decimal)kv.Value;
            boolean b = ReflectUtils.trySetPropertyValue(fname, createAttrSetInst, kv.getValue(),
                    (o, t) -> {
                        return ConvertUtils.convert(o, t);
                    });
            if (!b) {
                String fmt = "Set property error. Property name: %1$s";
                //                if (_log.IsInfoEnabled) {
                //                    _log.Info(String.format(fmt, fname));
                //                }
                throw new DomainError(fmt, fname);
            }
            // //////////////////////////////////////////
        }
        String attrSetInstId = getAttributeSetInstanceApplicationService().createWithoutId(createAttrSetInst);
        return attrSetInstId;
    }

    private ProductState getProductState(String productId) {
        ProductState prdState = getProductApplicationService().get(productId);
        if (prdState == null) {
            throw new IllegalArgumentException(String.format("Product NOT found. Product Id.: %1$s", productId));
        }
        return prdState;
    }

    private ShipmentState assertShipmentStatus(String shipmentId, String status) {
        ShipmentState shipment = getStateRepository().get(shipmentId, true);
        if (shipment == null) {
            throw new IllegalArgumentException(String.format("Error shipment Id.: %1$s", shipmentId));
        } else {
            if (!Objects.equals(shipment.getStatusId().toLowerCase(), status.toLowerCase())) {
                throw new IllegalArgumentException(String.format("Error shipment status: %1$s", shipment.getStatusId()));
            }
        }
        return shipment;
    }

    @Override
    public ShipmentAggregate getShipmentAggregate(ShipmentState state) {
        return new ShipmentAggregateImpl(state);
    }
    public static class ShipmentAggregateImpl extends AbstractShipmentAggregate.SimpleShipmentAggregate{

        public ShipmentAggregateImpl(ShipmentState state) {
            super(state);
        }

        @Override
        public void ship(Long version, String commandId, String requesterId) {
            boolean isStatusOk = false;
            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.PURCH_SHIP_CREATED.toLowerCase())) {
                isStatusOk = true;
            } else if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_INPUT.toLowerCase())
                    || Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_PICKED.toLowerCase())
                    || Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_PACKED.toLowerCase())
                    ) //?? - ??
            {
                isStatusOk = true;
            }
            if (!isStatusOk) {
                throw new IllegalArgumentException(String.format("Error shipment status: %1$s.", getState().getStatusId()));
            }

            ShipmentStateEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            if (Objects.equals(getState().getShipmentTypeId().toLowerCase(), ShipmentTypeIds.INCOMING_SHIPMENT.toLowerCase())
                    || Objects.equals(ShipmentTypeIds.getParentTypeId(getState().getShipmentTypeId()).toLowerCase(), ShipmentTypeIds.INCOMING_SHIPMENT.toLowerCase())) {
                e.setStatusId(StatusItemIds.PURCH_SHIP_SHIPPED);
            } else {
                e.setStatusId(StatusItemIds.SHIPMENT_SHIPPED);
            }
            apply(e);
        }

        @Override
        public void confirmAllItemsReceived(Long version, String commandId, String requesterId) {
            boolean isStatusOk = false;
            if (getState().getStatusId().toLowerCase() == StatusItemIds.PURCH_SHIP_SHIPPED.toLowerCase()) {
                isStatusOk = true;
            }
            if (!isStatusOk) {
                throw new IllegalArgumentException(String.format("Error shipment status: %1$s.", getState().getStatusId()));
            }
            ShipmentStateEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            e.setStatusId(StatusItemIds.PURCH_SHIP_RECEIVED);
            apply(e);
        }

    }
}
