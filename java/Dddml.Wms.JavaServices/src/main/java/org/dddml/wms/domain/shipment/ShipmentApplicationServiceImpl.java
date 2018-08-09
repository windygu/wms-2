package org.dddml.wms.domain.shipment;

import org.apache.commons.beanutils.ConvertUtils;
import org.dddml.wms.domain.attributesetinstance.AbstractAttributeSetInstanceCommand;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceCommand;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceUtils;
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

import java.math.BigDecimal;
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


        Optional<Object> itemIdNotFound = shipmentItemDict.keySet().stream()
                .filter((i -> !shipmentReceiptDict.containsKey((String) i))).findFirst();
        if (itemIdNotFound.isPresent()) {
            throw new IllegalArgumentException(String.format("Shipment item NOT received. ShipmentItemSeqId.: %1$s", itemIdNotFound.get()));
        }
        // /////////////////////////////
        Optional<ShipmentReceiptState> receiptUnknown = shipmentReceiptDict.values().stream()
                .filter(i -> !shipmentItemDict.containsKey(((ShipmentReceiptState) i).getShipmentItemSeqId())).findFirst();
        if (receiptUnknown.isPresent()) {
            throw new IllegalArgumentException(String.format("Shipment receipt has unknown ShipmentItemSeqId.: %1$s", receiptUnknown.get().getShipmentItemSeqId()));
        }

        List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries =
                confirmAllItemsReceivedCreateInventoryItemEntries(shipment, shipmentReceiptDict.values(), c.getDestinationLocatorId());
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
        assertReceiptQuantities(shipmentItem.getQuantity(), c.getAcceptedQuantity(), c.getRejectedQuantity());
        // ////////////////////////////////////////////////////
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = createOrUpdateShipmentReceipt(
                c, shipment,
                c.getShipmentItemSeqId(),
                shipmentItem.getProductId(),
                c.getAttributeSetInstance(),
                c.getAcceptedQuantity(),
                c.getRejectedQuantity(),
                c.getDamagedQuantity(), c.getDamageStatusId(), c.getDamageReasonId()
                );
        // ////////////////////////////////////////////////////
        updateShipment(c, updateReceipt);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.AddItemAndReceipt c) {
        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.PURCH_SHIP_SHIPPED);
        String shipmentItemSeqId = c.getReceiptSeqId();
        ShipmentItemCommand.CreateShipmentItem createShipmentItem = createShipmentItem(c, shipmentItemSeqId);
        assertReceiptQuantities(createShipmentItem.getQuantity(), c.getAcceptedQuantity(), c.getRejectedQuantity());
        // ////////////////////////////////////////////////////
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = createOrUpdateShipmentReceipt(
                c, shipment,
                shipmentItemSeqId,
                c.getProductId(),
                c.getAttributeSetInstance(),
                c.getAcceptedQuantity(),
                c.getRejectedQuantity(),
                c.getDamagedQuantity(), c.getDamageStatusId(), c.getDamageReasonId()
                );
        // ////////////////////////////////////////////////////
        updateShipment(c, updateReceipt, createShipmentItem);
    }

    private ShipmentItemCommand.CreateShipmentItem createShipmentItem(ShipmentCommands.AddItemAndReceipt c,
                                                                      String shipmentItemSeqId) {
        ShipmentItemCommand.CreateShipmentItem createShipmentItem = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
        createShipmentItem.setShipmentItemSeqId(shipmentItemSeqId);
        createShipmentItem.setProductId(c.getProductId());
        createShipmentItem.setQuantity(BigDecimal.ZERO);//???
        createShipmentItem.setAttributeSetInstanceId(InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);//???
        createShipmentItem.setActive(true);
        return createShipmentItem;
    }

    private static void assertReceiptQuantities(BigDecimal shipmentItemQuantity, BigDecimal acceptedQuantity, BigDecimal rejectedQuantity) {
        if (shipmentItemQuantity.equals(acceptedQuantity) && rejectedQuantity == null) {
            return;
        }
        // ////////////////////////////////////////
        // todo Is this OK?
        if (shipmentItemQuantity.compareTo(BigDecimal.ZERO) > 0 && acceptedQuantity.equals(BigDecimal.ZERO)
                && (rejectedQuantity == null || rejectedQuantity.equals(BigDecimal.ZERO))) {
            return;
        }
        if (shipmentItemQuantity.equals(BigDecimal.ZERO) && acceptedQuantity.compareTo(BigDecimal.ZERO) > 0
                && (rejectedQuantity == null || rejectedQuantity.equals(BigDecimal.ZERO))) {
            return;
        }
        // ////////////////////////////////////////
        if (shipmentItemQuantity.equals(acceptedQuantity.add(rejectedQuantity))) {
            return;
        }

        throw new IllegalArgumentException(String.format(
                "shipmentItem.Quantity != acceptedQuantity + rejectedQuantity. %1$s != %2$s + %3$s",
                shipmentItemQuantity, acceptedQuantity, rejectedQuantity));
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
        // 提单号
        shipment.setBolNumber(c.getBolNumber());
        // 集装箱号
        shipment.setVehicleId(c.getVehicleId());
        // 铅封号码
        shipment.setSealNumber(c.getSealNumber());
        shipment.setPoNumber(c.getPoNumber());
        shipment.setCarrier(c.getCarrier());
        // DOS
        shipment.setDateShipped(c.getDateShipped());
        shipment.setEstimatedReadyDate(c.getEstimatedReadyDate());
        shipment.setEstimatedShipDate(c.getEstimatedShipDate());
        //shipment.setEstimatedShipWorkEffId()
        shipment.setEstimatedArrivalDate(c.getEstimatedArrivalDate());
        shipment.setLatestCancelDate(c.getLatestCancelDate());
        shipment.setEstimatedShipCost(c.getEstimatedShipCost());
        shipment.setCurrencyUomId(c.getCurrencyUomId());
        shipment.setHandlingInstructions(c.getHandlingInstructions());
        shipment.setAdditionalShippingCharge(c.getAdditionalShippingCharge());
        shipment.setAddtlShippingChargeDesc(c.getAddtlShippingChargeDesc());
        //todo More properties ???

        int i = 0;
        for (ImportingShipmentItem d : c.getShipmentItems()) {
            ShipmentItemCommand.CreateShipmentItem shipItem = createShipmentItem(i, d);
            shipment.getShipmentItems().add(shipItem);
            i++;
        }
        when(shipment);
    }


    protected List<InventoryItemEntryCommand.CreateInventoryItemEntry> confirmAllItemsReceivedCreateInventoryItemEntries(ShipmentState shipment, Iterable<ShipmentReceiptState> receipts, String destinationLocatorId) {
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> entries = new ArrayList<>();
        for (ShipmentReceiptState d : receipts) {
            InventoryItemEntryCommand.CreateInventoryItemEntry e = createInventoryItemEntry(shipment, d, destinationLocatorId);
            entries.add(e);
        }
        return entries;
    }

    protected InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(ShipmentState shipment, ShipmentReceiptState lineReceipt, String destinationLocatorId) {
        //String targetLocatorId = WarehouseUtils.getReceivingLocatorId();//shipment.getDestinationFacilityId()?
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        String attrSetInstId = lineReceipt.getAttributeSetInstanceId();
        if(attrSetInstId == null || attrSetInstId.isEmpty()) {
            attrSetInstId = InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID;
        }
        //entry.setInventoryItemId(new InventoryItemId(lineReceipt.getProductId(), targetLocatorId, attrSetInstId));
        entry.setInventoryItemId(new InventoryItemId(lineReceipt.getProductId(), destinationLocatorId, attrSetInstId));
        entry.setEntrySeqId(getSeqIdGenerator().getNextId()); //DateTime.Now.Ticks;
        entry.setOnHandQuantity(lineReceipt.getAcceptedQuantity()); // *signum;
        entry.setSource(new InventoryItemSourceInfo(DocumentTypeIds.SHIPMENT, shipment.getShipmentId(),
                lineReceipt.getReceiptSeqId(), 0));
        return entry;
    }

    private ShipmentItemCommand.CreateShipmentItem createShipmentItem(int i, ImportingShipmentItem d) {
        ShipmentItemCommand.CreateShipmentItem shipItem = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
        ProductState prdState = getProductState(d.getProductId());

        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(
                getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                prdState.getAttributeSetId(), d.getAttributeSetInstance());
        //        if (_log.IsDebugEnabled) {
        //            _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //        }

        shipItem.setShipmentItemSeqId((new Integer(i)).toString());
        shipItem.setProductId(prdState.getProductId());
        shipItem.setAttributeSetInstanceId(attrSetInstId);
        shipItem.setQuantity(d.getQuantity());
        shipItem.setActive(true);
        shipItem.setShipmentContentDescription(d.getShipmentContentDescription());
        //todo More proerties???
        return shipItem;
    }

    private void updateShipment(ShipmentCommand c,
                                ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt) {
        updateShipment(c, updateReceipt, null);
    }

    private void updateShipment(ShipmentCommand c,
                                ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt,
                                ShipmentItemCommand.CreateOrMergePatchShipmentItem updateItem) {
        ShipmentCommand.MergePatchShipment updateShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
        // //////////////////////////////////////////////////////
        if (updateItem != null) {
            updateShipment.getShipmentItemCommands().add(updateItem);
        }
        updateShipment.getShipmentReceiptCommands().add(updateReceipt);
        // /////////////////////////////////////////////////////
        updateShipment.setShipmentId(c.getShipmentId());
        updateShipment.setVersion(c.getVersion());
        updateShipment.setCommandId(c.getCommandId());
        updateShipment.setRequesterId(c.getRequesterId());
        when(updateShipment);
    }

    private ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt createOrUpdateShipmentReceipt(
            ShipmentCommand c,
            ShipmentState shipment,
            String shipmentItemSeqId,
            String productId,
            Map<String, Object> attributeSetInstance,
            BigDecimal acceptedQuantity,
            BigDecimal rejectedQuantity,
            BigDecimal damagedQuantity, String damageStatusId, String damageReasonId
            ) {
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = null;
        String receiptSeqId = shipmentItemSeqId;
        ShipmentReceiptState receipt = shipment.getShipmentReceipts().get(receiptSeqId, false, true);
        if (receipt == null) {
            updateReceipt = new AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt();
        } else {
            updateReceipt = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
        }

        ProductState prdState = getProductState(productId);

        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(
                getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                prdState.getAttributeSetId(), attributeSetInstance);
        //        if (_log.IsDebugEnabled) {
        //            _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //        }
        updateReceipt.setAttributeSetInstanceId(attrSetInstId);
        updateReceipt.setReceiptSeqId(receiptSeqId);
        updateReceipt.setShipmentItemSeqId(shipmentItemSeqId);
        updateReceipt.setProductId(productId);
        updateReceipt.setAcceptedQuantity(acceptedQuantity);
        updateReceipt.setRejectedQuantity(rejectedQuantity);
        updateReceipt.setDamagedQuantity(damagedQuantity);
        updateReceipt.setDamageStatusId(damageStatusId);
        updateReceipt.setDamageReasonId(damageReasonId);
        updateReceipt.setReceivedBy(c.getRequesterId());
        return updateReceipt;
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

            ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            if (Objects.equals(getState().getShipmentTypeId().toLowerCase(), ShipmentTypeIds.INCOMING_SHIPMENT.toLowerCase())
                    || Objects.equals(ShipmentTypeIds.getParentTypeId(getState().getShipmentTypeId()).toLowerCase(), ShipmentTypeIds.INCOMING_SHIPMENT.toLowerCase())) {
                e.setStatusId(StatusItemIds.PURCH_SHIP_SHIPPED);
            } else {
                e.setStatusId(StatusItemIds.SHIPMENT_SHIPPED);
            }
            apply(e);
        }

        @Override
        public void confirmAllItemsReceived(String destinationLocatorId, Long version, String commandId, String requesterId) {
            boolean isStatusOk = false;
            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.PURCH_SHIP_SHIPPED.toLowerCase())) {
                isStatusOk = true;
            }
            if (!isStatusOk) {
                throw new IllegalArgumentException(String.format("Error shipment status: %1$s.", getState().getStatusId()));
            }
            ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            e.setStatusId(StatusItemIds.PURCH_SHIP_RECEIVED);
            apply(e);
        }

    }
}
