package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.ordershipgroupmvo.OrderShipGroupMvoStateEvent.*;

public abstract class AbstractOrderShipGroupMvoState implements OrderShipGroupMvoState
{

    private OrderShipGroupId orderShipGroupId;

    public OrderShipGroupId getOrderShipGroupId()
    {
        return this.orderShipGroupId;
    }

    public void setOrderShipGroupId(OrderShipGroupId orderShipGroupId)
    {
        this.orderShipGroupId = orderShipGroupId;
    }

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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
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

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
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

    public boolean isStateUnsaved() 
    {
        return this.getOrderVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractOrderShipGroupMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderShipGroupId(((OrderShipGroupMvoStateEvent) events.get(0)).getOrderShipGroupMvoEventId().getOrderShipGroupId());
            for (Event e : events) {
                mutate(e);
                this.setOrderVersion(this.getOrderVersion() + 1);
            }
        }
    }


    public AbstractOrderShipGroupMvoState() {
        this(false);
    }

    public AbstractOrderShipGroupMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderShipGroupMvoStateCreated) {
            when((OrderShipGroupMvoStateCreated) e);
        } else if (e instanceof OrderShipGroupMvoStateMergePatched) {
            when((OrderShipGroupMvoStateMergePatched) e);
        } else if (e instanceof OrderShipGroupMvoStateDeleted) {
            when((OrderShipGroupMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderShipGroupMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        this.setSupplierPartyId(e.getSupplierPartyId());
        this.setVendorPartyId(e.getVendorPartyId());
        this.setCarrierPartyId(e.getCarrierPartyId());
        this.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        this.setFacilityId(e.getFacilityId());
        this.setContactMechId(e.getContactMechId());
        this.setTelecomContactMechId(e.getTelecomContactMechId());
        this.setTrackingNumber(e.getTrackingNumber());
        this.setShippingInstructions(e.getShippingInstructions());
        this.setMaySplit(e.getMaySplit());
        this.setGiftMessage(e.getGiftMessage());
        this.setIsGift(e.getIsGift());
        this.setShipAfterDate(e.getShipAfterDate());
        this.setShipByDate(e.getShipByDate());
        this.setEstimatedShipDate(e.getEstimatedShipDate());
        this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setOrderOrderTypeId(e.getOrderOrderTypeId());
        this.setOrderOrderName(e.getOrderOrderName());
        this.setOrderExternalId(e.getOrderExternalId());
        this.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        this.setOrderOrderDate(e.getOrderOrderDate());
        this.setOrderPriority(e.getOrderPriority());
        this.setOrderEntryDate(e.getOrderEntryDate());
        this.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        this.setOrderStatusId(e.getOrderStatusId());
        this.setOrderCurrencyUom(e.getOrderCurrencyUom());
        this.setOrderSyncStatusId(e.getOrderSyncStatusId());
        this.setOrderBillingAccountId(e.getOrderBillingAccountId());
        this.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        this.setOrderWebSiteId(e.getOrderWebSiteId());
        this.setOrderProductStoreId(e.getOrderProductStoreId());
        this.setOrderTerminalId(e.getOrderTerminalId());
        this.setOrderTransactionId(e.getOrderTransactionId());
        this.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        this.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        this.setOrderIsRushOrder(e.getOrderIsRushOrder());
        this.setOrderInternalCode(e.getOrderInternalCode());
        this.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        this.setOrderGrandTotal(e.getOrderGrandTotal());
        this.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        this.setOrderCreatedBy(e.getOrderCreatedBy());
        this.setOrderCreatedAt(e.getOrderCreatedAt());
        this.setOrderUpdatedBy(e.getOrderUpdatedBy());
        this.setOrderUpdatedAt(e.getOrderUpdatedAt());
        this.setOrderActive(e.getOrderActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrderShipGroupMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getShipmentMethodTypeId() == null)
        {
            if (e.getIsPropertyShipmentMethodTypeIdRemoved() != null && e.getIsPropertyShipmentMethodTypeIdRemoved())
            {
                this.setShipmentMethodTypeId(null);
            }
        }
        else
        {
            this.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        }
        if (e.getSupplierPartyId() == null)
        {
            if (e.getIsPropertySupplierPartyIdRemoved() != null && e.getIsPropertySupplierPartyIdRemoved())
            {
                this.setSupplierPartyId(null);
            }
        }
        else
        {
            this.setSupplierPartyId(e.getSupplierPartyId());
        }
        if (e.getVendorPartyId() == null)
        {
            if (e.getIsPropertyVendorPartyIdRemoved() != null && e.getIsPropertyVendorPartyIdRemoved())
            {
                this.setVendorPartyId(null);
            }
        }
        else
        {
            this.setVendorPartyId(e.getVendorPartyId());
        }
        if (e.getCarrierPartyId() == null)
        {
            if (e.getIsPropertyCarrierPartyIdRemoved() != null && e.getIsPropertyCarrierPartyIdRemoved())
            {
                this.setCarrierPartyId(null);
            }
        }
        else
        {
            this.setCarrierPartyId(e.getCarrierPartyId());
        }
        if (e.getCarrierRoleTypeId() == null)
        {
            if (e.getIsPropertyCarrierRoleTypeIdRemoved() != null && e.getIsPropertyCarrierRoleTypeIdRemoved())
            {
                this.setCarrierRoleTypeId(null);
            }
        }
        else
        {
            this.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        }
        if (e.getFacilityId() == null)
        {
            if (e.getIsPropertyFacilityIdRemoved() != null && e.getIsPropertyFacilityIdRemoved())
            {
                this.setFacilityId(null);
            }
        }
        else
        {
            this.setFacilityId(e.getFacilityId());
        }
        if (e.getContactMechId() == null)
        {
            if (e.getIsPropertyContactMechIdRemoved() != null && e.getIsPropertyContactMechIdRemoved())
            {
                this.setContactMechId(null);
            }
        }
        else
        {
            this.setContactMechId(e.getContactMechId());
        }
        if (e.getTelecomContactMechId() == null)
        {
            if (e.getIsPropertyTelecomContactMechIdRemoved() != null && e.getIsPropertyTelecomContactMechIdRemoved())
            {
                this.setTelecomContactMechId(null);
            }
        }
        else
        {
            this.setTelecomContactMechId(e.getTelecomContactMechId());
        }
        if (e.getTrackingNumber() == null)
        {
            if (e.getIsPropertyTrackingNumberRemoved() != null && e.getIsPropertyTrackingNumberRemoved())
            {
                this.setTrackingNumber(null);
            }
        }
        else
        {
            this.setTrackingNumber(e.getTrackingNumber());
        }
        if (e.getShippingInstructions() == null)
        {
            if (e.getIsPropertyShippingInstructionsRemoved() != null && e.getIsPropertyShippingInstructionsRemoved())
            {
                this.setShippingInstructions(null);
            }
        }
        else
        {
            this.setShippingInstructions(e.getShippingInstructions());
        }
        if (e.getMaySplit() == null)
        {
            if (e.getIsPropertyMaySplitRemoved() != null && e.getIsPropertyMaySplitRemoved())
            {
                this.setMaySplit(null);
            }
        }
        else
        {
            this.setMaySplit(e.getMaySplit());
        }
        if (e.getGiftMessage() == null)
        {
            if (e.getIsPropertyGiftMessageRemoved() != null && e.getIsPropertyGiftMessageRemoved())
            {
                this.setGiftMessage(null);
            }
        }
        else
        {
            this.setGiftMessage(e.getGiftMessage());
        }
        if (e.getIsGift() == null)
        {
            if (e.getIsPropertyIsGiftRemoved() != null && e.getIsPropertyIsGiftRemoved())
            {
                this.setIsGift(null);
            }
        }
        else
        {
            this.setIsGift(e.getIsGift());
        }
        if (e.getShipAfterDate() == null)
        {
            if (e.getIsPropertyShipAfterDateRemoved() != null && e.getIsPropertyShipAfterDateRemoved())
            {
                this.setShipAfterDate(null);
            }
        }
        else
        {
            this.setShipAfterDate(e.getShipAfterDate());
        }
        if (e.getShipByDate() == null)
        {
            if (e.getIsPropertyShipByDateRemoved() != null && e.getIsPropertyShipByDateRemoved())
            {
                this.setShipByDate(null);
            }
        }
        else
        {
            this.setShipByDate(e.getShipByDate());
        }
        if (e.getEstimatedShipDate() == null)
        {
            if (e.getIsPropertyEstimatedShipDateRemoved() != null && e.getIsPropertyEstimatedShipDateRemoved())
            {
                this.setEstimatedShipDate(null);
            }
        }
        else
        {
            this.setEstimatedShipDate(e.getEstimatedShipDate());
        }
        if (e.getEstimatedDeliveryDate() == null)
        {
            if (e.getIsPropertyEstimatedDeliveryDateRemoved() != null && e.getIsPropertyEstimatedDeliveryDateRemoved())
            {
                this.setEstimatedDeliveryDate(null);
            }
        }
        else
        {
            this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getOrderOrderTypeId() == null)
        {
            if (e.getIsPropertyOrderOrderTypeIdRemoved() != null && e.getIsPropertyOrderOrderTypeIdRemoved())
            {
                this.setOrderOrderTypeId(null);
            }
        }
        else
        {
            this.setOrderOrderTypeId(e.getOrderOrderTypeId());
        }
        if (e.getOrderOrderName() == null)
        {
            if (e.getIsPropertyOrderOrderNameRemoved() != null && e.getIsPropertyOrderOrderNameRemoved())
            {
                this.setOrderOrderName(null);
            }
        }
        else
        {
            this.setOrderOrderName(e.getOrderOrderName());
        }
        if (e.getOrderExternalId() == null)
        {
            if (e.getIsPropertyOrderExternalIdRemoved() != null && e.getIsPropertyOrderExternalIdRemoved())
            {
                this.setOrderExternalId(null);
            }
        }
        else
        {
            this.setOrderExternalId(e.getOrderExternalId());
        }
        if (e.getOrderSalesChannelEnumId() == null)
        {
            if (e.getIsPropertyOrderSalesChannelEnumIdRemoved() != null && e.getIsPropertyOrderSalesChannelEnumIdRemoved())
            {
                this.setOrderSalesChannelEnumId(null);
            }
        }
        else
        {
            this.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        }
        if (e.getOrderOrderDate() == null)
        {
            if (e.getIsPropertyOrderOrderDateRemoved() != null && e.getIsPropertyOrderOrderDateRemoved())
            {
                this.setOrderOrderDate(null);
            }
        }
        else
        {
            this.setOrderOrderDate(e.getOrderOrderDate());
        }
        if (e.getOrderPriority() == null)
        {
            if (e.getIsPropertyOrderPriorityRemoved() != null && e.getIsPropertyOrderPriorityRemoved())
            {
                this.setOrderPriority(null);
            }
        }
        else
        {
            this.setOrderPriority(e.getOrderPriority());
        }
        if (e.getOrderEntryDate() == null)
        {
            if (e.getIsPropertyOrderEntryDateRemoved() != null && e.getIsPropertyOrderEntryDateRemoved())
            {
                this.setOrderEntryDate(null);
            }
        }
        else
        {
            this.setOrderEntryDate(e.getOrderEntryDate());
        }
        if (e.getOrderPickSheetPrintedDate() == null)
        {
            if (e.getIsPropertyOrderPickSheetPrintedDateRemoved() != null && e.getIsPropertyOrderPickSheetPrintedDateRemoved())
            {
                this.setOrderPickSheetPrintedDate(null);
            }
        }
        else
        {
            this.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        }
        if (e.getOrderStatusId() == null)
        {
            if (e.getIsPropertyOrderStatusIdRemoved() != null && e.getIsPropertyOrderStatusIdRemoved())
            {
                this.setOrderStatusId(null);
            }
        }
        else
        {
            this.setOrderStatusId(e.getOrderStatusId());
        }
        if (e.getOrderCurrencyUom() == null)
        {
            if (e.getIsPropertyOrderCurrencyUomRemoved() != null && e.getIsPropertyOrderCurrencyUomRemoved())
            {
                this.setOrderCurrencyUom(null);
            }
        }
        else
        {
            this.setOrderCurrencyUom(e.getOrderCurrencyUom());
        }
        if (e.getOrderSyncStatusId() == null)
        {
            if (e.getIsPropertyOrderSyncStatusIdRemoved() != null && e.getIsPropertyOrderSyncStatusIdRemoved())
            {
                this.setOrderSyncStatusId(null);
            }
        }
        else
        {
            this.setOrderSyncStatusId(e.getOrderSyncStatusId());
        }
        if (e.getOrderBillingAccountId() == null)
        {
            if (e.getIsPropertyOrderBillingAccountIdRemoved() != null && e.getIsPropertyOrderBillingAccountIdRemoved())
            {
                this.setOrderBillingAccountId(null);
            }
        }
        else
        {
            this.setOrderBillingAccountId(e.getOrderBillingAccountId());
        }
        if (e.getOrderOriginFacilityId() == null)
        {
            if (e.getIsPropertyOrderOriginFacilityIdRemoved() != null && e.getIsPropertyOrderOriginFacilityIdRemoved())
            {
                this.setOrderOriginFacilityId(null);
            }
        }
        else
        {
            this.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        }
        if (e.getOrderWebSiteId() == null)
        {
            if (e.getIsPropertyOrderWebSiteIdRemoved() != null && e.getIsPropertyOrderWebSiteIdRemoved())
            {
                this.setOrderWebSiteId(null);
            }
        }
        else
        {
            this.setOrderWebSiteId(e.getOrderWebSiteId());
        }
        if (e.getOrderProductStoreId() == null)
        {
            if (e.getIsPropertyOrderProductStoreIdRemoved() != null && e.getIsPropertyOrderProductStoreIdRemoved())
            {
                this.setOrderProductStoreId(null);
            }
        }
        else
        {
            this.setOrderProductStoreId(e.getOrderProductStoreId());
        }
        if (e.getOrderTerminalId() == null)
        {
            if (e.getIsPropertyOrderTerminalIdRemoved() != null && e.getIsPropertyOrderTerminalIdRemoved())
            {
                this.setOrderTerminalId(null);
            }
        }
        else
        {
            this.setOrderTerminalId(e.getOrderTerminalId());
        }
        if (e.getOrderTransactionId() == null)
        {
            if (e.getIsPropertyOrderTransactionIdRemoved() != null && e.getIsPropertyOrderTransactionIdRemoved())
            {
                this.setOrderTransactionId(null);
            }
        }
        else
        {
            this.setOrderTransactionId(e.getOrderTransactionId());
        }
        if (e.getOrderAutoOrderShoppingListId() == null)
        {
            if (e.getIsPropertyOrderAutoOrderShoppingListIdRemoved() != null && e.getIsPropertyOrderAutoOrderShoppingListIdRemoved())
            {
                this.setOrderAutoOrderShoppingListId(null);
            }
        }
        else
        {
            this.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        }
        if (e.getOrderNeedsInventoryIssuance() == null)
        {
            if (e.getIsPropertyOrderNeedsInventoryIssuanceRemoved() != null && e.getIsPropertyOrderNeedsInventoryIssuanceRemoved())
            {
                this.setOrderNeedsInventoryIssuance(null);
            }
        }
        else
        {
            this.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        }
        if (e.getOrderIsRushOrder() == null)
        {
            if (e.getIsPropertyOrderIsRushOrderRemoved() != null && e.getIsPropertyOrderIsRushOrderRemoved())
            {
                this.setOrderIsRushOrder(null);
            }
        }
        else
        {
            this.setOrderIsRushOrder(e.getOrderIsRushOrder());
        }
        if (e.getOrderInternalCode() == null)
        {
            if (e.getIsPropertyOrderInternalCodeRemoved() != null && e.getIsPropertyOrderInternalCodeRemoved())
            {
                this.setOrderInternalCode(null);
            }
        }
        else
        {
            this.setOrderInternalCode(e.getOrderInternalCode());
        }
        if (e.getOrderRemainingSubTotal() == null)
        {
            if (e.getIsPropertyOrderRemainingSubTotalRemoved() != null && e.getIsPropertyOrderRemainingSubTotalRemoved())
            {
                this.setOrderRemainingSubTotal(null);
            }
        }
        else
        {
            this.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        }
        if (e.getOrderGrandTotal() == null)
        {
            if (e.getIsPropertyOrderGrandTotalRemoved() != null && e.getIsPropertyOrderGrandTotalRemoved())
            {
                this.setOrderGrandTotal(null);
            }
        }
        else
        {
            this.setOrderGrandTotal(e.getOrderGrandTotal());
        }
        if (e.getOrderInvoicePerShipment() == null)
        {
            if (e.getIsPropertyOrderInvoicePerShipmentRemoved() != null && e.getIsPropertyOrderInvoicePerShipmentRemoved())
            {
                this.setOrderInvoicePerShipment(null);
            }
        }
        else
        {
            this.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        }
        if (e.getOrderCreatedBy() == null)
        {
            if (e.getIsPropertyOrderCreatedByRemoved() != null && e.getIsPropertyOrderCreatedByRemoved())
            {
                this.setOrderCreatedBy(null);
            }
        }
        else
        {
            this.setOrderCreatedBy(e.getOrderCreatedBy());
        }
        if (e.getOrderCreatedAt() == null)
        {
            if (e.getIsPropertyOrderCreatedAtRemoved() != null && e.getIsPropertyOrderCreatedAtRemoved())
            {
                this.setOrderCreatedAt(null);
            }
        }
        else
        {
            this.setOrderCreatedAt(e.getOrderCreatedAt());
        }
        if (e.getOrderUpdatedBy() == null)
        {
            if (e.getIsPropertyOrderUpdatedByRemoved() != null && e.getIsPropertyOrderUpdatedByRemoved())
            {
                this.setOrderUpdatedBy(null);
            }
        }
        else
        {
            this.setOrderUpdatedBy(e.getOrderUpdatedBy());
        }
        if (e.getOrderUpdatedAt() == null)
        {
            if (e.getIsPropertyOrderUpdatedAtRemoved() != null && e.getIsPropertyOrderUpdatedAtRemoved())
            {
                this.setOrderUpdatedAt(null);
            }
        }
        else
        {
            this.setOrderUpdatedAt(e.getOrderUpdatedAt());
        }
        if (e.getOrderActive() == null)
        {
            if (e.getIsPropertyOrderActiveRemoved() != null && e.getIsPropertyOrderActiveRemoved())
            {
                this.setOrderActive(null);
            }
        }
        else
        {
            this.setOrderActive(e.getOrderActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(OrderShipGroupMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderShipGroupMvoStateEvent stateEvent)
    {
        OrderShipGroupId stateEntityId = this.getOrderShipGroupId(); // Aggregate Id
        OrderShipGroupId eventEntityId = stateEvent.getOrderShipGroupMvoEventId().getOrderShipGroupId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getOrderVersion();
        Long eventVersion = stateEvent.getOrderShipGroupMvoEventId().getOrderVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getOrderShipGroupMvoEventId().getOrderVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderShipGroupMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderShipGroupMvoState extends AbstractOrderShipGroupMvoState
    {

        public SimpleOrderShipGroupMvoState() {
        }

        public SimpleOrderShipGroupMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderShipGroupMvoState(List<Event> events) {
            super(events);
        }

    }


}

