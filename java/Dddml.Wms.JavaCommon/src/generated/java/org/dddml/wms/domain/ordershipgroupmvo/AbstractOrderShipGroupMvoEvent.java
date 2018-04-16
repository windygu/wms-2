package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderShipGroupMvoEvent extends AbstractEvent implements OrderShipGroupMvoEvent 
{
    private OrderShipGroupMvoEventId orderShipGroupMvoEventId;

    public OrderShipGroupMvoEventId getOrderShipGroupMvoEventId() {
        return this.orderShipGroupMvoEventId;
    }

    public void setOrderShipGroupMvoEventId(OrderShipGroupMvoEventId eventId) {
        this.orderShipGroupMvoEventId = eventId;
    }
    
    public OrderShipGroupId getOrderShipGroupId() {
        return getOrderShipGroupMvoEventId().getOrderShipGroupId();
    }

    public void setOrderShipGroupId(OrderShipGroupId orderShipGroupId) {
        getOrderShipGroupMvoEventId().setOrderShipGroupId(orderShipGroupId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderShipGroupMvoEvent() {
    }

    protected AbstractOrderShipGroupMvoEvent(OrderShipGroupMvoEventId eventId) {
        this.orderShipGroupMvoEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderShipGroupMvoStateEvent extends AbstractOrderShipGroupMvoEvent implements OrderShipGroupMvoEvent.OrderShipGroupMvoStateEvent {
        private String shipmentMethodTypeId;

        public String getShipmentMethodTypeId()
        {
            return this.shipmentMethodTypeId;
        }

        public void setShipmentMethodTypeId(String shipmentMethodTypeId)
        {
            this.shipmentMethodTypeId = shipmentMethodTypeId;
        }

        private String supplierPartyId;

        public String getSupplierPartyId()
        {
            return this.supplierPartyId;
        }

        public void setSupplierPartyId(String supplierPartyId)
        {
            this.supplierPartyId = supplierPartyId;
        }

        private String vendorPartyId;

        public String getVendorPartyId()
        {
            return this.vendorPartyId;
        }

        public void setVendorPartyId(String vendorPartyId)
        {
            this.vendorPartyId = vendorPartyId;
        }

        private String carrierPartyId;

        public String getCarrierPartyId()
        {
            return this.carrierPartyId;
        }

        public void setCarrierPartyId(String carrierPartyId)
        {
            this.carrierPartyId = carrierPartyId;
        }

        private String carrierRoleTypeId;

        public String getCarrierRoleTypeId()
        {
            return this.carrierRoleTypeId;
        }

        public void setCarrierRoleTypeId(String carrierRoleTypeId)
        {
            this.carrierRoleTypeId = carrierRoleTypeId;
        }

        private String facilityId;

        public String getFacilityId()
        {
            return this.facilityId;
        }

        public void setFacilityId(String facilityId)
        {
            this.facilityId = facilityId;
        }

        private String contactMechId;

        public String getContactMechId()
        {
            return this.contactMechId;
        }

        public void setContactMechId(String contactMechId)
        {
            this.contactMechId = contactMechId;
        }

        private String telecomContactMechId;

        public String getTelecomContactMechId()
        {
            return this.telecomContactMechId;
        }

        public void setTelecomContactMechId(String telecomContactMechId)
        {
            this.telecomContactMechId = telecomContactMechId;
        }

        private String trackingNumber;

        public String getTrackingNumber()
        {
            return this.trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber)
        {
            this.trackingNumber = trackingNumber;
        }

        private String shippingInstructions;

        public String getShippingInstructions()
        {
            return this.shippingInstructions;
        }

        public void setShippingInstructions(String shippingInstructions)
        {
            this.shippingInstructions = shippingInstructions;
        }

        private String maySplit;

        public String getMaySplit()
        {
            return this.maySplit;
        }

        public void setMaySplit(String maySplit)
        {
            this.maySplit = maySplit;
        }

        private String giftMessage;

        public String getGiftMessage()
        {
            return this.giftMessage;
        }

        public void setGiftMessage(String giftMessage)
        {
            this.giftMessage = giftMessage;
        }

        private String isGift;

        public String getIsGift()
        {
            return this.isGift;
        }

        public void setIsGift(String isGift)
        {
            this.isGift = isGift;
        }

        private java.sql.Timestamp shipAfterDate;

        public java.sql.Timestamp getShipAfterDate()
        {
            return this.shipAfterDate;
        }

        public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
        {
            this.shipAfterDate = shipAfterDate;
        }

        private java.sql.Timestamp shipByDate;

        public java.sql.Timestamp getShipByDate()
        {
            return this.shipByDate;
        }

        public void setShipByDate(java.sql.Timestamp shipByDate)
        {
            this.shipByDate = shipByDate;
        }

        private java.sql.Timestamp estimatedShipDate;

        public java.sql.Timestamp getEstimatedShipDate()
        {
            return this.estimatedShipDate;
        }

        public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
        {
            this.estimatedShipDate = estimatedShipDate;
        }

        private java.sql.Timestamp estimatedDeliveryDate;

        public java.sql.Timestamp getEstimatedDeliveryDate()
        {
            return this.estimatedDeliveryDate;
        }

        public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
        {
            this.estimatedDeliveryDate = estimatedDeliveryDate;
        }

        private Long pickwaveId;

        public Long getPickwaveId()
        {
            return this.pickwaveId;
        }

        public void setPickwaveId(Long pickwaveId)
        {
            this.pickwaveId = pickwaveId;
        }

        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        private String orderOrderTypeId;

        public String getOrderOrderTypeId()
        {
            return this.orderOrderTypeId;
        }

        public void setOrderOrderTypeId(String orderOrderTypeId)
        {
            this.orderOrderTypeId = orderOrderTypeId;
        }

        private String orderOrderName;

        public String getOrderOrderName()
        {
            return this.orderOrderName;
        }

        public void setOrderOrderName(String orderOrderName)
        {
            this.orderOrderName = orderOrderName;
        }

        private String orderExternalId;

        public String getOrderExternalId()
        {
            return this.orderExternalId;
        }

        public void setOrderExternalId(String orderExternalId)
        {
            this.orderExternalId = orderExternalId;
        }

        private String orderSalesChannelEnumId;

        public String getOrderSalesChannelEnumId()
        {
            return this.orderSalesChannelEnumId;
        }

        public void setOrderSalesChannelEnumId(String orderSalesChannelEnumId)
        {
            this.orderSalesChannelEnumId = orderSalesChannelEnumId;
        }

        private java.sql.Timestamp orderOrderDate;

        public java.sql.Timestamp getOrderOrderDate()
        {
            return this.orderOrderDate;
        }

        public void setOrderOrderDate(java.sql.Timestamp orderOrderDate)
        {
            this.orderOrderDate = orderOrderDate;
        }

        private String orderPriority;

        public String getOrderPriority()
        {
            return this.orderPriority;
        }

        public void setOrderPriority(String orderPriority)
        {
            this.orderPriority = orderPriority;
        }

        private java.sql.Timestamp orderEntryDate;

        public java.sql.Timestamp getOrderEntryDate()
        {
            return this.orderEntryDate;
        }

        public void setOrderEntryDate(java.sql.Timestamp orderEntryDate)
        {
            this.orderEntryDate = orderEntryDate;
        }

        private java.sql.Timestamp orderPickSheetPrintedDate;

        public java.sql.Timestamp getOrderPickSheetPrintedDate()
        {
            return this.orderPickSheetPrintedDate;
        }

        public void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate)
        {
            this.orderPickSheetPrintedDate = orderPickSheetPrintedDate;
        }

        private String orderStatusId;

        public String getOrderStatusId()
        {
            return this.orderStatusId;
        }

        public void setOrderStatusId(String orderStatusId)
        {
            this.orderStatusId = orderStatusId;
        }

        private String orderCurrencyUom;

        public String getOrderCurrencyUom()
        {
            return this.orderCurrencyUom;
        }

        public void setOrderCurrencyUom(String orderCurrencyUom)
        {
            this.orderCurrencyUom = orderCurrencyUom;
        }

        private String orderSyncStatusId;

        public String getOrderSyncStatusId()
        {
            return this.orderSyncStatusId;
        }

        public void setOrderSyncStatusId(String orderSyncStatusId)
        {
            this.orderSyncStatusId = orderSyncStatusId;
        }

        private String orderBillingAccountId;

        public String getOrderBillingAccountId()
        {
            return this.orderBillingAccountId;
        }

        public void setOrderBillingAccountId(String orderBillingAccountId)
        {
            this.orderBillingAccountId = orderBillingAccountId;
        }

        private String orderOriginFacilityId;

        public String getOrderOriginFacilityId()
        {
            return this.orderOriginFacilityId;
        }

        public void setOrderOriginFacilityId(String orderOriginFacilityId)
        {
            this.orderOriginFacilityId = orderOriginFacilityId;
        }

        private String orderWebSiteId;

        public String getOrderWebSiteId()
        {
            return this.orderWebSiteId;
        }

        public void setOrderWebSiteId(String orderWebSiteId)
        {
            this.orderWebSiteId = orderWebSiteId;
        }

        private String orderProductStoreId;

        public String getOrderProductStoreId()
        {
            return this.orderProductStoreId;
        }

        public void setOrderProductStoreId(String orderProductStoreId)
        {
            this.orderProductStoreId = orderProductStoreId;
        }

        private String orderTerminalId;

        public String getOrderTerminalId()
        {
            return this.orderTerminalId;
        }

        public void setOrderTerminalId(String orderTerminalId)
        {
            this.orderTerminalId = orderTerminalId;
        }

        private String orderTransactionId;

        public String getOrderTransactionId()
        {
            return this.orderTransactionId;
        }

        public void setOrderTransactionId(String orderTransactionId)
        {
            this.orderTransactionId = orderTransactionId;
        }

        private String orderAutoOrderShoppingListId;

        public String getOrderAutoOrderShoppingListId()
        {
            return this.orderAutoOrderShoppingListId;
        }

        public void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId)
        {
            this.orderAutoOrderShoppingListId = orderAutoOrderShoppingListId;
        }

        private String orderNeedsInventoryIssuance;

        public String getOrderNeedsInventoryIssuance()
        {
            return this.orderNeedsInventoryIssuance;
        }

        public void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance)
        {
            this.orderNeedsInventoryIssuance = orderNeedsInventoryIssuance;
        }

        private String orderIsRushOrder;

        public String getOrderIsRushOrder()
        {
            return this.orderIsRushOrder;
        }

        public void setOrderIsRushOrder(String orderIsRushOrder)
        {
            this.orderIsRushOrder = orderIsRushOrder;
        }

        private String orderInternalCode;

        public String getOrderInternalCode()
        {
            return this.orderInternalCode;
        }

        public void setOrderInternalCode(String orderInternalCode)
        {
            this.orderInternalCode = orderInternalCode;
        }

        private java.math.BigDecimal orderRemainingSubTotal;

        public java.math.BigDecimal getOrderRemainingSubTotal()
        {
            return this.orderRemainingSubTotal;
        }

        public void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal)
        {
            this.orderRemainingSubTotal = orderRemainingSubTotal;
        }

        private java.math.BigDecimal orderGrandTotal;

        public java.math.BigDecimal getOrderGrandTotal()
        {
            return this.orderGrandTotal;
        }

        public void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal)
        {
            this.orderGrandTotal = orderGrandTotal;
        }

        private String orderInvoicePerShipment;

        public String getOrderInvoicePerShipment()
        {
            return this.orderInvoicePerShipment;
        }

        public void setOrderInvoicePerShipment(String orderInvoicePerShipment)
        {
            this.orderInvoicePerShipment = orderInvoicePerShipment;
        }

        private String orderCreatedBy;

        public String getOrderCreatedBy()
        {
            return this.orderCreatedBy;
        }

        public void setOrderCreatedBy(String orderCreatedBy)
        {
            this.orderCreatedBy = orderCreatedBy;
        }

        private Date orderCreatedAt;

        public Date getOrderCreatedAt()
        {
            return this.orderCreatedAt;
        }

        public void setOrderCreatedAt(Date orderCreatedAt)
        {
            this.orderCreatedAt = orderCreatedAt;
        }

        private String orderUpdatedBy;

        public String getOrderUpdatedBy()
        {
            return this.orderUpdatedBy;
        }

        public void setOrderUpdatedBy(String orderUpdatedBy)
        {
            this.orderUpdatedBy = orderUpdatedBy;
        }

        private Date orderUpdatedAt;

        public Date getOrderUpdatedAt()
        {
            return this.orderUpdatedAt;
        }

        public void setOrderUpdatedAt(Date orderUpdatedAt)
        {
            this.orderUpdatedAt = orderUpdatedAt;
        }

        private Boolean orderActive;

        public Boolean getOrderActive()
        {
            return this.orderActive;
        }

        public void setOrderActive(Boolean orderActive)
        {
            this.orderActive = orderActive;
        }

        protected AbstractOrderShipGroupMvoStateEvent(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderShipGroupMvoStateCreated extends AbstractOrderShipGroupMvoStateEvent implements OrderShipGroupMvoEvent.OrderShipGroupMvoStateCreated
    {
        public AbstractOrderShipGroupMvoStateCreated() {
            this(new OrderShipGroupMvoEventId());
        }

        public AbstractOrderShipGroupMvoStateCreated(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderShipGroupMvoStateMergePatched extends AbstractOrderShipGroupMvoStateEvent implements OrderShipGroupMvoEvent.OrderShipGroupMvoStateMergePatched
    {
        public AbstractOrderShipGroupMvoStateMergePatched() {
            this(new OrderShipGroupMvoEventId());
        }

        public AbstractOrderShipGroupMvoStateMergePatched(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyShipmentMethodTypeIdRemoved() {
            return this.isPropertyShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed) {
            this.isPropertyShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertySupplierPartyIdRemoved;

        public Boolean getIsPropertySupplierPartyIdRemoved() {
            return this.isPropertySupplierPartyIdRemoved;
        }

        public void setIsPropertySupplierPartyIdRemoved(Boolean removed) {
            this.isPropertySupplierPartyIdRemoved = removed;
        }

        private Boolean isPropertyVendorPartyIdRemoved;

        public Boolean getIsPropertyVendorPartyIdRemoved() {
            return this.isPropertyVendorPartyIdRemoved;
        }

        public void setIsPropertyVendorPartyIdRemoved(Boolean removed) {
            this.isPropertyVendorPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierPartyIdRemoved;

        public Boolean getIsPropertyCarrierPartyIdRemoved() {
            return this.isPropertyCarrierPartyIdRemoved;
        }

        public void setIsPropertyCarrierPartyIdRemoved(Boolean removed) {
            this.isPropertyCarrierPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierRoleTypeIdRemoved;

        public Boolean getIsPropertyCarrierRoleTypeIdRemoved() {
            return this.isPropertyCarrierRoleTypeIdRemoved;
        }

        public void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed) {
            this.isPropertyCarrierRoleTypeIdRemoved = removed;
        }

        private Boolean isPropertyFacilityIdRemoved;

        public Boolean getIsPropertyFacilityIdRemoved() {
            return this.isPropertyFacilityIdRemoved;
        }

        public void setIsPropertyFacilityIdRemoved(Boolean removed) {
            this.isPropertyFacilityIdRemoved = removed;
        }

        private Boolean isPropertyContactMechIdRemoved;

        public Boolean getIsPropertyContactMechIdRemoved() {
            return this.isPropertyContactMechIdRemoved;
        }

        public void setIsPropertyContactMechIdRemoved(Boolean removed) {
            this.isPropertyContactMechIdRemoved = removed;
        }

        private Boolean isPropertyTelecomContactMechIdRemoved;

        public Boolean getIsPropertyTelecomContactMechIdRemoved() {
            return this.isPropertyTelecomContactMechIdRemoved;
        }

        public void setIsPropertyTelecomContactMechIdRemoved(Boolean removed) {
            this.isPropertyTelecomContactMechIdRemoved = removed;
        }

        private Boolean isPropertyTrackingNumberRemoved;

        public Boolean getIsPropertyTrackingNumberRemoved() {
            return this.isPropertyTrackingNumberRemoved;
        }

        public void setIsPropertyTrackingNumberRemoved(Boolean removed) {
            this.isPropertyTrackingNumberRemoved = removed;
        }

        private Boolean isPropertyShippingInstructionsRemoved;

        public Boolean getIsPropertyShippingInstructionsRemoved() {
            return this.isPropertyShippingInstructionsRemoved;
        }

        public void setIsPropertyShippingInstructionsRemoved(Boolean removed) {
            this.isPropertyShippingInstructionsRemoved = removed;
        }

        private Boolean isPropertyMaySplitRemoved;

        public Boolean getIsPropertyMaySplitRemoved() {
            return this.isPropertyMaySplitRemoved;
        }

        public void setIsPropertyMaySplitRemoved(Boolean removed) {
            this.isPropertyMaySplitRemoved = removed;
        }

        private Boolean isPropertyGiftMessageRemoved;

        public Boolean getIsPropertyGiftMessageRemoved() {
            return this.isPropertyGiftMessageRemoved;
        }

        public void setIsPropertyGiftMessageRemoved(Boolean removed) {
            this.isPropertyGiftMessageRemoved = removed;
        }

        private Boolean isPropertyIsGiftRemoved;

        public Boolean getIsPropertyIsGiftRemoved() {
            return this.isPropertyIsGiftRemoved;
        }

        public void setIsPropertyIsGiftRemoved(Boolean removed) {
            this.isPropertyIsGiftRemoved = removed;
        }

        private Boolean isPropertyShipAfterDateRemoved;

        public Boolean getIsPropertyShipAfterDateRemoved() {
            return this.isPropertyShipAfterDateRemoved;
        }

        public void setIsPropertyShipAfterDateRemoved(Boolean removed) {
            this.isPropertyShipAfterDateRemoved = removed;
        }

        private Boolean isPropertyShipByDateRemoved;

        public Boolean getIsPropertyShipByDateRemoved() {
            return this.isPropertyShipByDateRemoved;
        }

        public void setIsPropertyShipByDateRemoved(Boolean removed) {
            this.isPropertyShipByDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipDateRemoved;

        public Boolean getIsPropertyEstimatedShipDateRemoved() {
            return this.isPropertyEstimatedShipDateRemoved;
        }

        public void setIsPropertyEstimatedShipDateRemoved(Boolean removed) {
            this.isPropertyEstimatedShipDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedDeliveryDateRemoved;

        public Boolean getIsPropertyEstimatedDeliveryDateRemoved() {
            return this.isPropertyEstimatedDeliveryDateRemoved;
        }

        public void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed) {
            this.isPropertyEstimatedDeliveryDateRemoved = removed;
        }

        private Boolean isPropertyPickwaveIdRemoved;

        public Boolean getIsPropertyPickwaveIdRemoved() {
            return this.isPropertyPickwaveIdRemoved;
        }

        public void setIsPropertyPickwaveIdRemoved(Boolean removed) {
            this.isPropertyPickwaveIdRemoved = removed;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved() {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed) {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Boolean isPropertyOrderOrderTypeIdRemoved;

        public Boolean getIsPropertyOrderOrderTypeIdRemoved() {
            return this.isPropertyOrderOrderTypeIdRemoved;
        }

        public void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed) {
            this.isPropertyOrderOrderTypeIdRemoved = removed;
        }

        private Boolean isPropertyOrderOrderNameRemoved;

        public Boolean getIsPropertyOrderOrderNameRemoved() {
            return this.isPropertyOrderOrderNameRemoved;
        }

        public void setIsPropertyOrderOrderNameRemoved(Boolean removed) {
            this.isPropertyOrderOrderNameRemoved = removed;
        }

        private Boolean isPropertyOrderExternalIdRemoved;

        public Boolean getIsPropertyOrderExternalIdRemoved() {
            return this.isPropertyOrderExternalIdRemoved;
        }

        public void setIsPropertyOrderExternalIdRemoved(Boolean removed) {
            this.isPropertyOrderExternalIdRemoved = removed;
        }

        private Boolean isPropertyOrderSalesChannelEnumIdRemoved;

        public Boolean getIsPropertyOrderSalesChannelEnumIdRemoved() {
            return this.isPropertyOrderSalesChannelEnumIdRemoved;
        }

        public void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed) {
            this.isPropertyOrderSalesChannelEnumIdRemoved = removed;
        }

        private Boolean isPropertyOrderOrderDateRemoved;

        public Boolean getIsPropertyOrderOrderDateRemoved() {
            return this.isPropertyOrderOrderDateRemoved;
        }

        public void setIsPropertyOrderOrderDateRemoved(Boolean removed) {
            this.isPropertyOrderOrderDateRemoved = removed;
        }

        private Boolean isPropertyOrderPriorityRemoved;

        public Boolean getIsPropertyOrderPriorityRemoved() {
            return this.isPropertyOrderPriorityRemoved;
        }

        public void setIsPropertyOrderPriorityRemoved(Boolean removed) {
            this.isPropertyOrderPriorityRemoved = removed;
        }

        private Boolean isPropertyOrderEntryDateRemoved;

        public Boolean getIsPropertyOrderEntryDateRemoved() {
            return this.isPropertyOrderEntryDateRemoved;
        }

        public void setIsPropertyOrderEntryDateRemoved(Boolean removed) {
            this.isPropertyOrderEntryDateRemoved = removed;
        }

        private Boolean isPropertyOrderPickSheetPrintedDateRemoved;

        public Boolean getIsPropertyOrderPickSheetPrintedDateRemoved() {
            return this.isPropertyOrderPickSheetPrintedDateRemoved;
        }

        public void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed) {
            this.isPropertyOrderPickSheetPrintedDateRemoved = removed;
        }

        private Boolean isPropertyOrderStatusIdRemoved;

        public Boolean getIsPropertyOrderStatusIdRemoved() {
            return this.isPropertyOrderStatusIdRemoved;
        }

        public void setIsPropertyOrderStatusIdRemoved(Boolean removed) {
            this.isPropertyOrderStatusIdRemoved = removed;
        }

        private Boolean isPropertyOrderCurrencyUomRemoved;

        public Boolean getIsPropertyOrderCurrencyUomRemoved() {
            return this.isPropertyOrderCurrencyUomRemoved;
        }

        public void setIsPropertyOrderCurrencyUomRemoved(Boolean removed) {
            this.isPropertyOrderCurrencyUomRemoved = removed;
        }

        private Boolean isPropertyOrderSyncStatusIdRemoved;

        public Boolean getIsPropertyOrderSyncStatusIdRemoved() {
            return this.isPropertyOrderSyncStatusIdRemoved;
        }

        public void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed) {
            this.isPropertyOrderSyncStatusIdRemoved = removed;
        }

        private Boolean isPropertyOrderBillingAccountIdRemoved;

        public Boolean getIsPropertyOrderBillingAccountIdRemoved() {
            return this.isPropertyOrderBillingAccountIdRemoved;
        }

        public void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed) {
            this.isPropertyOrderBillingAccountIdRemoved = removed;
        }

        private Boolean isPropertyOrderOriginFacilityIdRemoved;

        public Boolean getIsPropertyOrderOriginFacilityIdRemoved() {
            return this.isPropertyOrderOriginFacilityIdRemoved;
        }

        public void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed) {
            this.isPropertyOrderOriginFacilityIdRemoved = removed;
        }

        private Boolean isPropertyOrderWebSiteIdRemoved;

        public Boolean getIsPropertyOrderWebSiteIdRemoved() {
            return this.isPropertyOrderWebSiteIdRemoved;
        }

        public void setIsPropertyOrderWebSiteIdRemoved(Boolean removed) {
            this.isPropertyOrderWebSiteIdRemoved = removed;
        }

        private Boolean isPropertyOrderProductStoreIdRemoved;

        public Boolean getIsPropertyOrderProductStoreIdRemoved() {
            return this.isPropertyOrderProductStoreIdRemoved;
        }

        public void setIsPropertyOrderProductStoreIdRemoved(Boolean removed) {
            this.isPropertyOrderProductStoreIdRemoved = removed;
        }

        private Boolean isPropertyOrderTerminalIdRemoved;

        public Boolean getIsPropertyOrderTerminalIdRemoved() {
            return this.isPropertyOrderTerminalIdRemoved;
        }

        public void setIsPropertyOrderTerminalIdRemoved(Boolean removed) {
            this.isPropertyOrderTerminalIdRemoved = removed;
        }

        private Boolean isPropertyOrderTransactionIdRemoved;

        public Boolean getIsPropertyOrderTransactionIdRemoved() {
            return this.isPropertyOrderTransactionIdRemoved;
        }

        public void setIsPropertyOrderTransactionIdRemoved(Boolean removed) {
            this.isPropertyOrderTransactionIdRemoved = removed;
        }

        private Boolean isPropertyOrderAutoOrderShoppingListIdRemoved;

        public Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved() {
            return this.isPropertyOrderAutoOrderShoppingListIdRemoved;
        }

        public void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed) {
            this.isPropertyOrderAutoOrderShoppingListIdRemoved = removed;
        }

        private Boolean isPropertyOrderNeedsInventoryIssuanceRemoved;

        public Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved() {
            return this.isPropertyOrderNeedsInventoryIssuanceRemoved;
        }

        public void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed) {
            this.isPropertyOrderNeedsInventoryIssuanceRemoved = removed;
        }

        private Boolean isPropertyOrderIsRushOrderRemoved;

        public Boolean getIsPropertyOrderIsRushOrderRemoved() {
            return this.isPropertyOrderIsRushOrderRemoved;
        }

        public void setIsPropertyOrderIsRushOrderRemoved(Boolean removed) {
            this.isPropertyOrderIsRushOrderRemoved = removed;
        }

        private Boolean isPropertyOrderInternalCodeRemoved;

        public Boolean getIsPropertyOrderInternalCodeRemoved() {
            return this.isPropertyOrderInternalCodeRemoved;
        }

        public void setIsPropertyOrderInternalCodeRemoved(Boolean removed) {
            this.isPropertyOrderInternalCodeRemoved = removed;
        }

        private Boolean isPropertyOrderRemainingSubTotalRemoved;

        public Boolean getIsPropertyOrderRemainingSubTotalRemoved() {
            return this.isPropertyOrderRemainingSubTotalRemoved;
        }

        public void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed) {
            this.isPropertyOrderRemainingSubTotalRemoved = removed;
        }

        private Boolean isPropertyOrderGrandTotalRemoved;

        public Boolean getIsPropertyOrderGrandTotalRemoved() {
            return this.isPropertyOrderGrandTotalRemoved;
        }

        public void setIsPropertyOrderGrandTotalRemoved(Boolean removed) {
            this.isPropertyOrderGrandTotalRemoved = removed;
        }

        private Boolean isPropertyOrderInvoicePerShipmentRemoved;

        public Boolean getIsPropertyOrderInvoicePerShipmentRemoved() {
            return this.isPropertyOrderInvoicePerShipmentRemoved;
        }

        public void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed) {
            this.isPropertyOrderInvoicePerShipmentRemoved = removed;
        }

        private Boolean isPropertyOrderCreatedByRemoved;

        public Boolean getIsPropertyOrderCreatedByRemoved() {
            return this.isPropertyOrderCreatedByRemoved;
        }

        public void setIsPropertyOrderCreatedByRemoved(Boolean removed) {
            this.isPropertyOrderCreatedByRemoved = removed;
        }

        private Boolean isPropertyOrderCreatedAtRemoved;

        public Boolean getIsPropertyOrderCreatedAtRemoved() {
            return this.isPropertyOrderCreatedAtRemoved;
        }

        public void setIsPropertyOrderCreatedAtRemoved(Boolean removed) {
            this.isPropertyOrderCreatedAtRemoved = removed;
        }

        private Boolean isPropertyOrderUpdatedByRemoved;

        public Boolean getIsPropertyOrderUpdatedByRemoved() {
            return this.isPropertyOrderUpdatedByRemoved;
        }

        public void setIsPropertyOrderUpdatedByRemoved(Boolean removed) {
            this.isPropertyOrderUpdatedByRemoved = removed;
        }

        private Boolean isPropertyOrderUpdatedAtRemoved;

        public Boolean getIsPropertyOrderUpdatedAtRemoved() {
            return this.isPropertyOrderUpdatedAtRemoved;
        }

        public void setIsPropertyOrderUpdatedAtRemoved(Boolean removed) {
            this.isPropertyOrderUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyOrderActiveRemoved;

        public Boolean getIsPropertyOrderActiveRemoved() {
            return this.isPropertyOrderActiveRemoved;
        }

        public void setIsPropertyOrderActiveRemoved(Boolean removed) {
            this.isPropertyOrderActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrderShipGroupMvoStateDeleted extends AbstractOrderShipGroupMvoStateEvent implements OrderShipGroupMvoEvent.OrderShipGroupMvoStateDeleted
    {
        public AbstractOrderShipGroupMvoStateDeleted() {
            this(new OrderShipGroupMvoEventId());
        }

        public AbstractOrderShipGroupMvoStateDeleted(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrderShipGroupMvoStateCreated extends AbstractOrderShipGroupMvoStateCreated
    {
        public SimpleOrderShipGroupMvoStateCreated() {
        }

        public SimpleOrderShipGroupMvoStateCreated(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipGroupMvoStateMergePatched extends AbstractOrderShipGroupMvoStateMergePatched
    {
        public SimpleOrderShipGroupMvoStateMergePatched() {
        }

        public SimpleOrderShipGroupMvoStateMergePatched(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipGroupMvoStateDeleted extends AbstractOrderShipGroupMvoStateDeleted
    {
        public SimpleOrderShipGroupMvoStateDeleted() {
        }

        public SimpleOrderShipGroupMvoStateDeleted(OrderShipGroupMvoEventId eventId) {
            super(eventId);
        }
    }

}

