package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderShipGroupMvoCommand extends Command
{
    OrderShipGroupId getOrderShipGroupId();

    void setOrderShipGroupId(OrderShipGroupId orderShipGroupId);

    Long getOrderVersion();

    void setOrderVersion(Long orderVersion);

    static void throwOnInvalidStateTransition(OrderShipGroupMvoState state, Command c) {
        if (state.getOrderVersion() == null)
        {
            if (isCommandCreate((OrderShipGroupMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((OrderShipGroupMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrderShipGroupMvoCommand c) {
        return ((c instanceof OrderShipGroupMvoCommand.CreateOrderShipGroupMvo) 
            && c.getOrderVersion().equals(OrderShipGroupMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrderShipGroupMvo extends OrderShipGroupMvoCommand
    {
        String getShipmentMethodTypeId();

        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        String getSupplierPartyId();

        void setSupplierPartyId(String supplierPartyId);

        String getVendorPartyId();

        void setVendorPartyId(String vendorPartyId);

        String getCarrierPartyId();

        void setCarrierPartyId(String carrierPartyId);

        String getCarrierRoleTypeId();

        void setCarrierRoleTypeId(String carrierRoleTypeId);

        String getFacilityId();

        void setFacilityId(String facilityId);

        String getContactMechId();

        void setContactMechId(String contactMechId);

        String getTelecomContactMechId();

        void setTelecomContactMechId(String telecomContactMechId);

        String getTrackingNumber();

        void setTrackingNumber(String trackingNumber);

        String getShippingInstructions();

        void setShippingInstructions(String shippingInstructions);

        String getMaySplit();

        void setMaySplit(String maySplit);

        String getGiftMessage();

        void setGiftMessage(String giftMessage);

        String getIsGift();

        void setIsGift(String isGift);

        java.sql.Timestamp getShipAfterDate();

        void setShipAfterDate(java.sql.Timestamp shipAfterDate);

        java.sql.Timestamp getShipByDate();

        void setShipByDate(java.sql.Timestamp shipByDate);

        java.sql.Timestamp getEstimatedShipDate();

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        java.sql.Timestamp getEstimatedDeliveryDate();

        void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate);

        Long getPickwaveId();

        void setPickwaveId(Long pickwaveId);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getOrderOrderTypeId();

        void setOrderOrderTypeId(String orderOrderTypeId);

        String getOrderOrderName();

        void setOrderOrderName(String orderOrderName);

        String getOrderExternalId();

        void setOrderExternalId(String orderExternalId);

        String getOrderSalesChannelEnumId();

        void setOrderSalesChannelEnumId(String orderSalesChannelEnumId);

        java.sql.Timestamp getOrderOrderDate();

        void setOrderOrderDate(java.sql.Timestamp orderOrderDate);

        String getOrderPriority();

        void setOrderPriority(String orderPriority);

        java.sql.Timestamp getOrderEntryDate();

        void setOrderEntryDate(java.sql.Timestamp orderEntryDate);

        java.sql.Timestamp getOrderPickSheetPrintedDate();

        void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate);

        String getOrderStatusId();

        void setOrderStatusId(String orderStatusId);

        String getOrderCurrencyUom();

        void setOrderCurrencyUom(String orderCurrencyUom);

        String getOrderSyncStatusId();

        void setOrderSyncStatusId(String orderSyncStatusId);

        String getOrderBillingAccountId();

        void setOrderBillingAccountId(String orderBillingAccountId);

        String getOrderOriginFacilityId();

        void setOrderOriginFacilityId(String orderOriginFacilityId);

        String getOrderWebSiteId();

        void setOrderWebSiteId(String orderWebSiteId);

        String getOrderProductStoreId();

        void setOrderProductStoreId(String orderProductStoreId);

        String getOrderTerminalId();

        void setOrderTerminalId(String orderTerminalId);

        String getOrderTransactionId();

        void setOrderTransactionId(String orderTransactionId);

        String getOrderAutoOrderShoppingListId();

        void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId);

        String getOrderNeedsInventoryIssuance();

        void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance);

        String getOrderIsRushOrder();

        void setOrderIsRushOrder(String orderIsRushOrder);

        String getOrderInternalCode();

        void setOrderInternalCode(String orderInternalCode);

        java.math.BigDecimal getOrderRemainingSubTotal();

        void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal);

        java.math.BigDecimal getOrderGrandTotal();

        void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal);

        String getOrderInvoicePerShipment();

        void setOrderInvoicePerShipment(String orderInvoicePerShipment);

        String getOrderCreatedBy();

        void setOrderCreatedBy(String orderCreatedBy);

        Date getOrderCreatedAt();

        void setOrderCreatedAt(Date orderCreatedAt);

        String getOrderUpdatedBy();

        void setOrderUpdatedBy(String orderUpdatedBy);

        Date getOrderUpdatedAt();

        void setOrderUpdatedAt(Date orderUpdatedAt);

        Boolean getOrderActive();

        void setOrderActive(Boolean orderActive);

    }

    interface CreateOrderShipGroupMvo extends CreateOrMergePatchOrderShipGroupMvo
    {
    }

    interface MergePatchOrderShipGroupMvo extends CreateOrMergePatchOrderShipGroupMvo
    {
        Boolean getIsPropertyShipmentMethodTypeIdRemoved();

        void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed);

        Boolean getIsPropertySupplierPartyIdRemoved();

        void setIsPropertySupplierPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyVendorPartyIdRemoved();

        void setIsPropertyVendorPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyCarrierPartyIdRemoved();

        void setIsPropertyCarrierPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyCarrierRoleTypeIdRemoved();

        void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyFacilityIdRemoved();

        void setIsPropertyFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyContactMechIdRemoved();

        void setIsPropertyContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTelecomContactMechIdRemoved();

        void setIsPropertyTelecomContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTrackingNumberRemoved();

        void setIsPropertyTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyShippingInstructionsRemoved();

        void setIsPropertyShippingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyMaySplitRemoved();

        void setIsPropertyMaySplitRemoved(Boolean removed);

        Boolean getIsPropertyGiftMessageRemoved();

        void setIsPropertyGiftMessageRemoved(Boolean removed);

        Boolean getIsPropertyIsGiftRemoved();

        void setIsPropertyIsGiftRemoved(Boolean removed);

        Boolean getIsPropertyShipAfterDateRemoved();

        void setIsPropertyShipAfterDateRemoved(Boolean removed);

        Boolean getIsPropertyShipByDateRemoved();

        void setIsPropertyShipByDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipDateRemoved();

        void setIsPropertyEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedDeliveryDateRemoved();

        void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed);

        Boolean getIsPropertyPickwaveIdRemoved();

        void setIsPropertyPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderTypeIdRemoved();

        void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderNameRemoved();

        void setIsPropertyOrderOrderNameRemoved(Boolean removed);

        Boolean getIsPropertyOrderExternalIdRemoved();

        void setIsPropertyOrderExternalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderSalesChannelEnumIdRemoved();

        void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderDateRemoved();

        void setIsPropertyOrderOrderDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderPriorityRemoved();

        void setIsPropertyOrderPriorityRemoved(Boolean removed);

        Boolean getIsPropertyOrderEntryDateRemoved();

        void setIsPropertyOrderEntryDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderPickSheetPrintedDateRemoved();

        void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderStatusIdRemoved();

        void setIsPropertyOrderStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderCurrencyUomRemoved();

        void setIsPropertyOrderCurrencyUomRemoved(Boolean removed);

        Boolean getIsPropertyOrderSyncStatusIdRemoved();

        void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderBillingAccountIdRemoved();

        void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOriginFacilityIdRemoved();

        void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderWebSiteIdRemoved();

        void setIsPropertyOrderWebSiteIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderProductStoreIdRemoved();

        void setIsPropertyOrderProductStoreIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderTerminalIdRemoved();

        void setIsPropertyOrderTerminalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderTransactionIdRemoved();

        void setIsPropertyOrderTransactionIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved();

        void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved();

        void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed);

        Boolean getIsPropertyOrderIsRushOrderRemoved();

        void setIsPropertyOrderIsRushOrderRemoved(Boolean removed);

        Boolean getIsPropertyOrderInternalCodeRemoved();

        void setIsPropertyOrderInternalCodeRemoved(Boolean removed);

        Boolean getIsPropertyOrderRemainingSubTotalRemoved();

        void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed);

        Boolean getIsPropertyOrderGrandTotalRemoved();

        void setIsPropertyOrderGrandTotalRemoved(Boolean removed);

        Boolean getIsPropertyOrderInvoicePerShipmentRemoved();

        void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed);

        Boolean getIsPropertyOrderCreatedByRemoved();

        void setIsPropertyOrderCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderCreatedAtRemoved();

        void setIsPropertyOrderCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderUpdatedByRemoved();

        void setIsPropertyOrderUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderUpdatedAtRemoved();

        void setIsPropertyOrderUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderActiveRemoved();

        void setIsPropertyOrderActiveRemoved(Boolean removed);

    }

	interface DeleteOrderShipGroupMvo extends OrderShipGroupMvoCommand
	{
	}

}

