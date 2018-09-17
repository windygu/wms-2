package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.PurchaseShipmentAction;
import org.dddml.wms.domain.SalesShipmentAction;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
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
import java.sql.Timestamp;
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
    public void when(ShipmentCommands.PurchaseShipmentAction c) {
        if (Objects.equals(c.getValue(), PurchaseShipmentAction.SHIP)) {
            ShipmentState shipmentState = assertShipmentStatus(c.getShipmentId(), StatusItemIds.PURCH_SHIP_CREATED);
            if (shipmentState.getPrimaryOrderId() != null && !shipmentState.getPrimaryOrderId().trim().isEmpty()
                && shipmentState.getPrimaryShipGroupSeqId() != null && !shipmentState.getPrimaryShipGroupSeqId().trim().isEmpty()) {
                super.when(c);
            } else {
                throw new UnsupportedOperationException();
            }
        } else if (Objects.equals(c.getValue(), PurchaseShipmentAction.RECEIVE)) {
            throw new UnsupportedOperationException("Need Destination Locator Id.");
            //            ShipmentCommands.ConfirmAllItemsReceived receive = new ShipmentCommands.ConfirmAllItemsReceived();
            //            receive.setShipmentId(c.getShipmentId());
            //            receive.setDestinationLocatorId(WarehouseUtils.getReceivingLocatorId(xxx));
            //            receive.setVersion(c.getVersion());
            //            receive.setCommandId(c.getCommandId());
            //            receive.setRequesterId(c.getRequesterId());
            //            when(receive);
        } else {
            super.when(c);
        }
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.SalesShipmentAction c) {
        if (Objects.equals(c.getValue(), SalesShipmentAction.SHIP)) {
            ShipmentCommands.ConfirmAllItemsIssued ship = new ShipmentCommands.ConfirmAllItemsIssued();
            ship.setShipmentId(c.getShipmentId());
            ship.setVersion(c.getVersion());
            ship.setCommandId(c.getCommandId());
            ship.setRequesterId(c.getRequesterId());
            when(ship);
        } else {
            super.when(c);
        }
    }

    //    @Override
    //    @Transactional
    //    public void when(ShipmentCommands.Ship c) {
    //        // check shipment type??
    //        super.when(c);
    //    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ConfirmAllItemsReceived c) {
        // /////////////////////////////////////////////////////////////////
        // 目前要确认收货，必须把单据置到“采购装运已发货”的状态
        // /////////////////////////////////////////////////////////////////
        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.PURCH_SHIP_SHIPPED);
        // check shipment type??

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
        if (c.getReceiptSeqId() == null || c.getReceiptSeqId().trim().isEmpty()) {
            throw new IllegalArgumentException("receiptSeqId is null.");
        }
        assertReceiptQuantities(shipmentItem.getQuantity(), c.getAcceptedQuantity(), c.getRejectedQuantity());
        // ////////////////////////////////////////////////////
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = createOrUpdateShipmentReceipt(
                c, shipment,
                c.getReceiptSeqId(),
                c.getShipmentItemSeqId(),
                shipmentItem.getProductId(),
                c.getAttributeSetInstance(),
                c.getAcceptedQuantity(),
                c.getRejectedQuantity(),
                c.getDamagedQuantity(), c.getDamageStatusIds(), c.getDamageReasonId()
                );
        // ////////////////////////////////////////////////////
        updateShipment(c, updateReceipt);
    }
    //
    //    @Override
    //    @Transactional
    //    public void when(ShipmentCommands.AddItemAndReceipt c) {
    //        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.PURCH_SHIP_SHIPPED);
    //        String shipmentItemSeqId = c.getReceiptSeqId();
    //        ShipmentItemCommand.CreateShipmentItem createShipmentItem = createShipmentItem(c, shipmentItemSeqId);
    //        assertReceiptQuantities(createShipmentItem.getQuantity(), c.getAcceptedQuantity(), c.getRejectedQuantity());
    //        // ////////////////////////////////////////////////////
    //        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = createOrUpdateShipmentReceipt(
    //                c, shipment,
    //                shipmentItemSeqId,
    //                c.getProductId(),
    //                c.getAttributeSetInstance(),
    //                c.getAcceptedQuantity(),
    //                c.getRejectedQuantity(),
    //                c.getDamagedQuantity(), c.getDamageStatusIds(), c.getDamageReasonId()
    //                );
    //        // ////////////////////////////////////////////////////
    //        updateShipment(c, updateReceipt, createShipmentItem);
    //    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ConfirmAllItemsIssued c) {
        // /////////////////////////////////////////////////////////////////
        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.SHIPMENT_INPUT);
        // /////////////////////////////////////////////////////////////////
        // check shipment type??

        Map<Object, ItemIssuanceState> itemIssuanceMap = StreamSupport.stream(
                shipment.getItemIssuances().spliterator(), false)
                .collect(Collectors.toMap(i -> i.getShipmentItemSeqId(), i -> i));

        Map<Object, ShipmentItemState> shipmentItemDict = StreamSupport.stream(
                shipment.getShipmentItems().spliterator(), false)
                .collect(Collectors.toMap(i -> i.getShipmentItemSeqId(), i -> i));


        Optional<Object> itemIdNotFound = shipmentItemDict.keySet().stream()
                .filter((i -> !itemIssuanceMap.containsKey((String) i))).findFirst();
        if (itemIdNotFound.isPresent()) {
            throw new IllegalArgumentException(String.format("Shipment item NOT issued. ShipmentItemSeqId.: %1$s", itemIdNotFound.get()));
        }
        // /////////////////////////////
        Optional<ItemIssuanceState> itemIssuanceUnknown = itemIssuanceMap.values().stream()
                .filter(i -> !shipmentItemDict.containsKey(((ItemIssuanceState) i).getShipmentItemSeqId())).findFirst();
        if (itemIssuanceUnknown.isPresent()) {
            throw new IllegalArgumentException(String.format("Item issuance has unknown ShipmentItemSeqId.: %1$s", itemIssuanceUnknown.get().getShipmentItemSeqId()));
        }

        List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries =
                confirmAllItemsIssuedCreateInventoryItemEntries(shipment, itemIssuanceMap.values());
        InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);

        super.when(c);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.IssueItem c) {
        if (c.getLocatorId() == null) {
            throw new IllegalArgumentException("locatorId is null.");
        }
        if (c.getItemIssuanceSeqId() == null || c.getItemIssuanceSeqId().trim().isEmpty()) {
            throw new IllegalArgumentException("itemIssuanceSeqId is null.");
        }
        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.SHIPMENT_INPUT);
        ShipmentItemState shipmentItem = shipment.getShipmentItems().get(c.getShipmentItemSeqId());
        if (shipmentItem == null) {
            throw new IllegalArgumentException(String.format(
                    "CANNOT get shipment item. ShipmentItemSeqId: %1$s", c.getShipmentItemSeqId()));
        }
        assertIssuanceQuantities(shipmentItem.getQuantity(), c.getQuantity(), c.getCancelQuantity());
        // ////////////////////////////////////////////////////
        ItemIssuanceCommand.CreateOrMergePatchItemIssuance updateItemIssuance = createOrUpdateItemIssuance(
                c, shipment,
                c.getItemIssuanceSeqId(),
                c.getShipmentItemSeqId(),
                shipmentItem.getProductId(),
                c.getLocatorId(),
                c.getAttributeSetInstance(),
                c.getQuantity(),
                c.getCancelQuantity()
        );
        // ////////////////////////////////////////////////////

        updateShipment(c, updateItemIssuance);
    }

    //    @Override
    //    @Transactional
    //    public void when(ShipmentCommands.AddItemAndIssuance c) {
    //        if (c.getLocatorId() == null) {
    //            throw new IllegalArgumentException("locatorId is null.");
    //        }
    //        ShipmentState shipment = assertShipmentStatus(c.getShipmentId(), StatusItemIds.SHIPMENT_INPUT);
    //        String shipmentItemSeqId = c.getItemIssuanceSeqId();
    //        ShipmentItemCommand.CreateShipmentItem createShipmentItem = createShipmentItem(c, shipmentItemSeqId);
    //        assertIssuanceQuantities(createShipmentItem.getQuantity(), c.getQuantity(), c.getCancelQuantity());
    //        // ////////////////////////////////////////////////////
    //        ItemIssuanceCommand.CreateOrMergePatchItemIssuance updateItemIssuance = createOrUpdateItemIssuance(
    //                c, shipment,
    //                shipmentItemSeqId,
    //                c.getProductId(),
    //                c.getLocatorId(),
    //                c.getAttributeSetInstance(),
    //                c.getQuantity(),
    //                c.getCancelQuantity()
    //        );
    //        // ////////////////////////////////////////////////////
    //        updateShipment(c, updateItemIssuance, createShipmentItem);
    //    }
    //
    //    private ShipmentItemCommand.CreateShipmentItem createShipmentItem(ShipmentCommands.AddItemAndReceipt c,
    //                                                                      String shipmentItemSeqId) {
    //        ShipmentItemCommand.CreateShipmentItem createShipmentItem = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
    //        createShipmentItem.setShipmentItemSeqId(shipmentItemSeqId);
    //        createShipmentItem.setProductId(c.getProductId());
    //        createShipmentItem.setQuantity(BigDecimal.ZERO);//todo ???
    //        createShipmentItem.setAttributeSetInstanceId(InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);//???
    //        createShipmentItem.setActive(true);
    //        return createShipmentItem;
    //    }
    //
    //    private ShipmentItemCommand.CreateShipmentItem createShipmentItem(ShipmentCommands.AddItemAndIssuance c,
    //                                                                      String shipmentItemSeqId) {
    //        ShipmentItemCommand.CreateShipmentItem createShipmentItem = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
    //        createShipmentItem.setShipmentItemSeqId(shipmentItemSeqId);
    //        createShipmentItem.setProductId(c.getProductId());
    //        createShipmentItem.setQuantity(c.getQuantity());//todo ???
    //        createShipmentItem.setAttributeSetInstanceId(InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);//???
    //        createShipmentItem.setActive(true);
    //        return createShipmentItem;
    //    }

    private static void assertReceiptQuantities(BigDecimal shipmentItemQuantity, BigDecimal acceptedQuantity, BigDecimal rejectedQuantity) {
        if (shipmentItemQuantity.compareTo(acceptedQuantity) == 0 && rejectedQuantity == null) {
            return;
        }
        if (shipmentItemQuantity.compareTo(acceptedQuantity.add(rejectedQuantity)) == 0) {
            return;
        }
        // todo Is this OK?
        if (true) { return; }

        // ////////////////////////////////////////
        if (shipmentItemQuantity.compareTo(BigDecimal.ZERO) > 0 && acceptedQuantity.compareTo(BigDecimal.ZERO) == 0
                && (rejectedQuantity == null || rejectedQuantity.compareTo(BigDecimal.ZERO) == 0)) {
            return;
        }
        if (shipmentItemQuantity.compareTo(BigDecimal.ZERO) == 0 && acceptedQuantity.compareTo(BigDecimal.ZERO) > 0
                && (rejectedQuantity == null || rejectedQuantity.compareTo(BigDecimal.ZERO) == 0)) {
            return;
        }
        // ////////////////////////////////////////
        throw new IllegalArgumentException(String.format(
                "shipmentItem.Quantity != acceptedQuantity + rejectedQuantity. %1$s != %2$s + %3$s",
                shipmentItemQuantity, acceptedQuantity, rejectedQuantity));
    }

    private static void assertIssuanceQuantities(BigDecimal shipmentItemQuantity, BigDecimal quantity, BigDecimal cancelledQuantity ) {
        if (shipmentItemQuantity.compareTo(quantity) == 0 && cancelledQuantity == null) {
            return;
        }
        if (shipmentItemQuantity.compareTo(quantity.add(cancelledQuantity)) == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                "shipmentItem.Quantity != quantity + cancelledQuantity. %1$s != %2$s + %3$s",
                shipmentItemQuantity, quantity, cancelledQuantity));
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
        if (shipment.getShipmentTypeId() == null) {
            shipment.setShipmentTypeId(ShipmentTypeIds.PURCHASE_SHIPMENT);
        }
        if (!Objects.equals(c.getShipmentTypeId(), ShipmentTypeIds.PURCHASE_SHIPMENT)) {
            throw new IllegalArgumentException("c.getShipmentTypeId()");
        }
        //        if (Objects.equals(c.getShipmentTypeId(), ShipmentTypeIds.PURCHASE_SHIPMENT)
        //                || Objects.equals(c.getShipmentTypeId(), ShipmentTypeIds.INCOMING_SHIPMENT)) {
        //            shipment.setStatusId(StatusItemIds.PURCH_SHIP_CREATED);
        //        } else {
        //            shipment.setStatusId(StatusItemIds.SHIPMENT_INPUT);
        //        }
        // 主订单 Id
        shipment.setPrimaryOrderId(c.getPrimaryOrderId());
        // 提单号
        shipment.setBolNumber(c.getBolNumber());
        // 集装箱号
        shipment.setVehicleId(c.getVehicleId());
        // 铅封号码
        shipment.setSealNumber(c.getSealNumber());
        // 外部订单号
        shipment.setExternalOrderNumber(c.getExternalOrderNumber());
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
        //标记为从“码单”导入
        shipment.setIsCreatedFromPackingList(true);
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
        if (destinationLocatorId == null || destinationLocatorId.isEmpty()) {
            throw new IllegalArgumentException("Null destinationLocatorId.");
        }
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> entries = new ArrayList<>();
        for (ShipmentReceiptState d : receipts) {
            InventoryItemEntryCommand.CreateInventoryItemEntry e = createInventoryItemEntry(shipment, d, destinationLocatorId);
            entries.add(e);
        }
        return entries;
    }

    protected List<InventoryItemEntryCommand.CreateInventoryItemEntry> confirmAllItemsIssuedCreateInventoryItemEntries(ShipmentState shipment, Iterable<ItemIssuanceState> itemIssuances) {
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> entries = new ArrayList<>();
        for (ItemIssuanceState d : itemIssuances) {
            InventoryItemEntryCommand.CreateInventoryItemEntry e = createInventoryItemEntry(shipment, d);
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
                lineReceipt.getReceiptSeqId(), -1));
        if (lineReceipt.getDatetimeReceived() != null) {
            entry.setOccurredAt(new Timestamp(lineReceipt.getDatetimeReceived().getTime()));
        } else {
            entry.setOccurredAt((Timestamp) ApplicationContext.current.getTimestampService().now(Timestamp.class));
        }
        return entry;
    }

    protected InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(ShipmentState shipment, ItemIssuanceState itemIssuance) {
        //String targetLocatorId = WarehouseUtils.getReceivingLocatorId();//shipment.getDestinationFacilityId()?
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        String attrSetInstId = itemIssuance.getAttributeSetInstanceId();
        if (attrSetInstId == null || attrSetInstId.isEmpty()) {
            attrSetInstId = InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID;
        }
        //entry.setInventoryItemId(new InventoryItemId(lineReceipt.getProductId(), targetLocatorId, attrSetInstId));
        entry.setInventoryItemId(new InventoryItemId(itemIssuance.getProductId(), itemIssuance.getLocatorId(), attrSetInstId));
        entry.setEntrySeqId(getSeqIdGenerator().getNextId()); //DateTime.Now.Ticks;
        // //////////////////////////////////////////////////////////////////////////
        entry.setOnHandQuantity(itemIssuance.getQuantity().negate()); // *signum;
        // //////////////////////////////////////////////////////////////////////////
        entry.setSource(new InventoryItemSourceInfo(DocumentTypeIds.SHIPMENT, shipment.getShipmentId(),
                itemIssuance.getItemIssuanceSeqId(), 0));
        if (itemIssuance.getIssuedDateTime() != null) {
            entry.setOccurredAt(new Timestamp(itemIssuance.getIssuedDateTime().getTime()));
        } else {
            entry.setOccurredAt((Timestamp) ApplicationContext.current.getTimestampService().now(Timestamp.class));
        }
        return entry;
    }

    private ShipmentItemCommand.CreateShipmentItem createShipmentItem(int i, ImportingShipmentItem d) {
        ShipmentItemCommand.CreateShipmentItem shipItem = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
        ProductState productState = getProductState(d.getProductId());
        //todo 应该对 AttributeSetInstancd 做检查？
        // assertAttributeSetInstance(prodcutState, attrSetInstMap)???
        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(
                getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                productState.getAttributeSetId(), d.getAttributeSetInstance());
        //        if (_log.IsDebugEnabled) {
        //            _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //        }

        shipItem.setShipmentItemSeqId((new Integer(i)).toString());
        shipItem.setProductId(productState.getProductId());
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

    private void updateShipment(ShipmentCommand c,
                                ItemIssuanceCommand.CreateOrMergePatchItemIssuance updateItemIssuance) {
        updateShipment(c, updateItemIssuance, null);
    }

    private void updateShipment(ShipmentCommand c,
                                ItemIssuanceCommand.CreateOrMergePatchItemIssuance updateItemIssuance,
                                ShipmentItemCommand.CreateOrMergePatchShipmentItem updateItem) {
        ShipmentCommand.MergePatchShipment updateShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
        // //////////////////////////////////////////////////////
        if (updateItem != null) {
            updateShipment.getShipmentItemCommands().add(updateItem);
        }
        updateShipment.getItemIssuanceCommands().add(updateItemIssuance);
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
            String receiptSeqId,
            String shipmentItemSeqId,
            String productId,
            Map<String, Object> attributeSetInstance,
            BigDecimal acceptedQuantity,
            BigDecimal rejectedQuantity,
            BigDecimal damagedQuantity, List<String> damageStatusIds, String damageReasonId
    ) {
        ShipmentReceiptCommand.CreateOrMergePatchShipmentReceipt updateReceipt = null;
        //String receiptSeqId = shipmentItemSeqId;
        if (receiptSeqId == null) {
            throw new NullPointerException("receiptSeqId is null.");
        }
        ShipmentReceiptState receipt = shipment.getShipmentReceipts().get(receiptSeqId, false, true);
        if (receipt == null) {
            updateReceipt = new AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt();
        } else {
            updateReceipt = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
        }

        ProductState productState = getProductState(productId);
        //todo 应该对 AttributeSetInstancd 做检查？
        // assertAttributeSetInstance(prodcutState, attrSetInstMap)???
        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(
                getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                productState.getAttributeSetId(), attributeSetInstance);
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
        updateReceipt.setDamageStatusIds(damageStatusIds == null ? null : new HashSet<>(damageStatusIds));
        updateReceipt.setDamageReasonId(damageReasonId);
        updateReceipt.setReceivedBy(c.getRequesterId());
        return updateReceipt;
    }

    private ItemIssuanceCommand.CreateOrMergePatchItemIssuance createOrUpdateItemIssuance(
            ShipmentCommand c,
            ShipmentState shipment,
            String itemIssuanceSeqId,
            String shipmentItemSeqId,
            String productId,
            String locatorId,
            Map<String, Object> attributeSetInstance,
            BigDecimal quantity,
            BigDecimal cancelledQuantity
    ) {
        if (locatorId == null) {
            throw new IllegalArgumentException("locatorId is null.");
        }
        ItemIssuanceCommand.CreateOrMergePatchItemIssuance udpateItemIssuance = null;
        //String itemIssuanceSeqId = shipmentItemSeqId;
        if (itemIssuanceSeqId == null) {
            throw new NullPointerException("itemIssuanceSeqId is null.");
        }
        ItemIssuanceState itemIssuanceState = shipment.getItemIssuances().get(itemIssuanceSeqId, false, true);
        if (itemIssuanceState == null) {
            udpateItemIssuance = new AbstractItemIssuanceCommand.SimpleCreateItemIssuance();
        } else {
            udpateItemIssuance = new AbstractItemIssuanceCommand.SimpleMergePatchItemIssuance();
        }

        ProductState productState = getProductState(productId);
        //todo 应该对 AttributeSetInstancd 做检查？
        // assertAttributeSetInstance(prodcutState, attrSetInstMap)???
        String attrSetInstId = AttributeSetInstanceUtils.createAttributeSetInstance(
                getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                productState.getAttributeSetId(), attributeSetInstance);
        //        if (_log.IsDebugEnabled) {
        //            _log.Debug("Create attribute set instance, id: " + attrSetInstId);
        //        }
        udpateItemIssuance.setAttributeSetInstanceId(attrSetInstId);
        udpateItemIssuance.setItemIssuanceSeqId(itemIssuanceSeqId);
        udpateItemIssuance.setShipmentItemSeqId(shipmentItemSeqId);
        udpateItemIssuance.setProductId(productId);
        udpateItemIssuance.setQuantity(quantity);
        udpateItemIssuance.setCancelQuantity(cancelledQuantity);
        udpateItemIssuance.setLocatorId(locatorId);
        // todo ???
        //udpateItemIssuance.setOrderId();
        //udpateItemIssuance.setOrderItemSeqId();
        //udpateItemIssuance.setShipGroupSeqId();
        return udpateItemIssuance;
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

        //@Override
        //public void ship(Long version, String commandId, String requesterId) {
        //    purchaseShipmentAction(PurchaseShipmentAction.SHIP, version, commandId, requesterId);
            //            boolean isStatusOk = false;
            //            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.PURCH_SHIP_CREATED.toLowerCase())) {
            //                isStatusOk = true;
            //            } else if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_INPUT.toLowerCase())
            //                    || Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_PICKED.toLowerCase())
            //                    || Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_PACKED.toLowerCase())
            //                    ) //?? - ??
            //            {
            //                isStatusOk = true;
            //            }
            //            if (!isStatusOk) {
            //                throw new IllegalArgumentException(String.format("Error shipment status: %1$s.", getState().getStatusId()));
            //            }
            //ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            //            // //////////////////////////////////////
            //            // 先让所有“入站”的装运单都在确认“发出”后置于同一个状态，方便后面的业务逻辑判断
            //            // //////////////////////////////////////
            //            if (Objects.equals(getState().getShipmentTypeId().toLowerCase(), ShipmentTypeIds.INCOMING_SHIPMENT.toLowerCase())
            //                    || Objects.equals(getState().getShipmentTypeId().toLowerCase(), ShipmentTypeIds.PURCHASE_RETURN.toLowerCase())
            //                    || Objects.equals(ShipmentTypeIds.getParentTypeId(getState().getShipmentTypeId()).toLowerCase(),
            //                        ShipmentTypeIds.INCOMING_SHIPMENT.toLowerCase())) {
            //                e.setStatusId(StatusItemIds.PURCH_SHIP_SHIPPED);
            //            } else {
            //                e.setStatusId(StatusItemIds.SHIPMENT_SHIPPED);
            //            }
            //apply(e);
        //}

        @Override
        public void confirmAllItemsReceived(String destinationLocatorId, Long version, String commandId, String requesterId) {
            purchaseShipmentAction(PurchaseShipmentAction.RECEIVE, version, commandId, requesterId);
            //            boolean isStatusOk = false;
            //            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.PURCH_SHIP_SHIPPED.toLowerCase())) {
            //                isStatusOk = true;
            //            }
            //            if (!isStatusOk) {
            //                throw new IllegalArgumentException(String.format("Error shipment status: %1$s.", getState().getStatusId()));
            //            }
            //            ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            //            e.setStatusId(StatusItemIds.PURCH_SHIP_RECEIVED);
            //            apply(e);
        }

        @Override
        public void confirmAllItemsIssued(Long version, String commandId, String requesterId) {
            salesShipmentAction(SalesShipmentAction.SHIP, version, commandId, requesterId);
            //            boolean isStatusOk = false;
            //            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_INPUT.toLowerCase())) {
            //                isStatusOk = true;
            //            }
            //            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_PICKED.toLowerCase())) {
            //                isStatusOk = true;
            //            }
            //            if (Objects.equals(getState().getStatusId().toLowerCase(), StatusItemIds.SHIPMENT_PACKED.toLowerCase())) {
            //                isStatusOk = true;
            //            }
            //            if (!isStatusOk) {
            //                throw new IllegalArgumentException(String.format("Error shipment status: %1$s.", getState().getStatusId()));
            //            }
            //            ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(version, commandId, requesterId);
            //            e.setStatusId(StatusItemIds.SHIPMENT_SHIPPED);
            //            apply(e);
        }

    }
}
