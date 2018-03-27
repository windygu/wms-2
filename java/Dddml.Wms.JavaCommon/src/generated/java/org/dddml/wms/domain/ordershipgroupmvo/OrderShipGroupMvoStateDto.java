package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrderShipGroupMvoStateDto
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

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public OrderShipGroupMvoStateDto[] toOrderShipGroupMvoStateDtoArray(Iterable<OrderShipGroupMvoState> states) 
        {
            ArrayList<OrderShipGroupMvoStateDto> stateDtos = new ArrayList();
            for (OrderShipGroupMvoState s : states) {
                OrderShipGroupMvoStateDto dto = toOrderShipGroupMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new OrderShipGroupMvoStateDto[0]);
        }

        public OrderShipGroupMvoStateDto toOrderShipGroupMvoStateDto(OrderShipGroupMvoState state)
        {
            if(state == null) {
                return null;
            }
            OrderShipGroupMvoStateDto dto = new OrderShipGroupMvoStateDto();
            if (returnedFieldsContains("OrderShipGroupId")) {
                dto.setOrderShipGroupId(state.getOrderShipGroupId());
            }
            if (returnedFieldsContains("ShipmentMethodTypeId")) {
                dto.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
            }
            if (returnedFieldsContains("SupplierPartyId")) {
                dto.setSupplierPartyId(state.getSupplierPartyId());
            }
            if (returnedFieldsContains("VendorPartyId")) {
                dto.setVendorPartyId(state.getVendorPartyId());
            }
            if (returnedFieldsContains("CarrierPartyId")) {
                dto.setCarrierPartyId(state.getCarrierPartyId());
            }
            if (returnedFieldsContains("CarrierRoleTypeId")) {
                dto.setCarrierRoleTypeId(state.getCarrierRoleTypeId());
            }
            if (returnedFieldsContains("FacilityId")) {
                dto.setFacilityId(state.getFacilityId());
            }
            if (returnedFieldsContains("ContactMechId")) {
                dto.setContactMechId(state.getContactMechId());
            }
            if (returnedFieldsContains("TelecomContactMechId")) {
                dto.setTelecomContactMechId(state.getTelecomContactMechId());
            }
            if (returnedFieldsContains("TrackingNumber")) {
                dto.setTrackingNumber(state.getTrackingNumber());
            }
            if (returnedFieldsContains("ShippingInstructions")) {
                dto.setShippingInstructions(state.getShippingInstructions());
            }
            if (returnedFieldsContains("MaySplit")) {
                dto.setMaySplit(state.getMaySplit());
            }
            if (returnedFieldsContains("GiftMessage")) {
                dto.setGiftMessage(state.getGiftMessage());
            }
            if (returnedFieldsContains("IsGift")) {
                dto.setIsGift(state.getIsGift());
            }
            if (returnedFieldsContains("ShipAfterDate")) {
                dto.setShipAfterDate(state.getShipAfterDate());
            }
            if (returnedFieldsContains("ShipByDate")) {
                dto.setShipByDate(state.getShipByDate());
            }
            if (returnedFieldsContains("EstimatedShipDate")) {
                dto.setEstimatedShipDate(state.getEstimatedShipDate());
            }
            if (returnedFieldsContains("EstimatedDeliveryDate")) {
                dto.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
            }
            if (returnedFieldsContains("PickwaveId")) {
                dto.setPickwaveId(state.getPickwaveId());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("OrderOrderTypeId")) {
                dto.setOrderOrderTypeId(state.getOrderOrderTypeId());
            }
            if (returnedFieldsContains("OrderOrderName")) {
                dto.setOrderOrderName(state.getOrderOrderName());
            }
            if (returnedFieldsContains("OrderExternalId")) {
                dto.setOrderExternalId(state.getOrderExternalId());
            }
            if (returnedFieldsContains("OrderSalesChannelEnumId")) {
                dto.setOrderSalesChannelEnumId(state.getOrderSalesChannelEnumId());
            }
            if (returnedFieldsContains("OrderOrderDate")) {
                dto.setOrderOrderDate(state.getOrderOrderDate());
            }
            if (returnedFieldsContains("OrderPriority")) {
                dto.setOrderPriority(state.getOrderPriority());
            }
            if (returnedFieldsContains("OrderEntryDate")) {
                dto.setOrderEntryDate(state.getOrderEntryDate());
            }
            if (returnedFieldsContains("OrderPickSheetPrintedDate")) {
                dto.setOrderPickSheetPrintedDate(state.getOrderPickSheetPrintedDate());
            }
            if (returnedFieldsContains("OrderStatusId")) {
                dto.setOrderStatusId(state.getOrderStatusId());
            }
            if (returnedFieldsContains("OrderCurrencyUom")) {
                dto.setOrderCurrencyUom(state.getOrderCurrencyUom());
            }
            if (returnedFieldsContains("OrderSyncStatusId")) {
                dto.setOrderSyncStatusId(state.getOrderSyncStatusId());
            }
            if (returnedFieldsContains("OrderBillingAccountId")) {
                dto.setOrderBillingAccountId(state.getOrderBillingAccountId());
            }
            if (returnedFieldsContains("OrderOriginFacilityId")) {
                dto.setOrderOriginFacilityId(state.getOrderOriginFacilityId());
            }
            if (returnedFieldsContains("OrderWebSiteId")) {
                dto.setOrderWebSiteId(state.getOrderWebSiteId());
            }
            if (returnedFieldsContains("OrderProductStoreId")) {
                dto.setOrderProductStoreId(state.getOrderProductStoreId());
            }
            if (returnedFieldsContains("OrderTerminalId")) {
                dto.setOrderTerminalId(state.getOrderTerminalId());
            }
            if (returnedFieldsContains("OrderTransactionId")) {
                dto.setOrderTransactionId(state.getOrderTransactionId());
            }
            if (returnedFieldsContains("OrderAutoOrderShoppingListId")) {
                dto.setOrderAutoOrderShoppingListId(state.getOrderAutoOrderShoppingListId());
            }
            if (returnedFieldsContains("OrderNeedsInventoryIssuance")) {
                dto.setOrderNeedsInventoryIssuance(state.getOrderNeedsInventoryIssuance());
            }
            if (returnedFieldsContains("OrderIsRushOrder")) {
                dto.setOrderIsRushOrder(state.getOrderIsRushOrder());
            }
            if (returnedFieldsContains("OrderInternalCode")) {
                dto.setOrderInternalCode(state.getOrderInternalCode());
            }
            if (returnedFieldsContains("OrderRemainingSubTotal")) {
                dto.setOrderRemainingSubTotal(state.getOrderRemainingSubTotal());
            }
            if (returnedFieldsContains("OrderGrandTotal")) {
                dto.setOrderGrandTotal(state.getOrderGrandTotal());
            }
            if (returnedFieldsContains("OrderInvoicePerShipment")) {
                dto.setOrderInvoicePerShipment(state.getOrderInvoicePerShipment());
            }
            if (returnedFieldsContains("OrderCreatedBy")) {
                dto.setOrderCreatedBy(state.getOrderCreatedBy());
            }
            if (returnedFieldsContains("OrderCreatedAt")) {
                dto.setOrderCreatedAt(state.getOrderCreatedAt());
            }
            if (returnedFieldsContains("OrderUpdatedBy")) {
                dto.setOrderUpdatedBy(state.getOrderUpdatedBy());
            }
            if (returnedFieldsContains("OrderUpdatedAt")) {
                dto.setOrderUpdatedAt(state.getOrderUpdatedAt());
            }
            if (returnedFieldsContains("OrderActive")) {
                dto.setOrderActive(state.getOrderActive());
            }
            if (returnedFieldsContains("OrderVersion")) {
                dto.setOrderVersion(state.getOrderVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

