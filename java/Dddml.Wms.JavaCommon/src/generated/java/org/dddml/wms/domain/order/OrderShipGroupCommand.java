package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderShipGroupCommand extends Command
{
    String getShipGroupSeqId();

    void setShipGroupSeqId(String shipGroupSeqId);

    String getOrderId();

    void setOrderId(String orderId);

    interface CreateOrMergePatchOrderShipGroup extends OrderShipGroupCommand
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

        String getDestinationFacilityId();

        void setDestinationFacilityId(String destinationFacilityId);

        String getContactMechId();

        void setContactMechId(String contactMechId);

        String getTelecomContactMechId();

        void setTelecomContactMechId(String telecomContactMechId);

        String getTrackingNumber();

        void setTrackingNumber(String trackingNumber);

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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrderShipGroup extends CreateOrMergePatchOrderShipGroup
    {
        CreateOrderItemShipGroupAssociationCommands getOrderItemShipGroupAssociations();

        OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation newCreateOrderItemShipGroupAssociation();

    }

    interface MergePatchOrderShipGroup extends CreateOrMergePatchOrderShipGroup
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

        Boolean getIsPropertyDestinationFacilityIdRemoved();

        void setIsPropertyDestinationFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyContactMechIdRemoved();

        void setIsPropertyContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTelecomContactMechIdRemoved();

        void setIsPropertyTelecomContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTrackingNumberRemoved();

        void setIsPropertyTrackingNumberRemoved(Boolean removed);

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

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        OrderItemShipGroupAssociationCommands getOrderItemShipGroupAssociationCommands();

        OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation newCreateOrderItemShipGroupAssociation();

        OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation newMergePatchOrderItemShipGroupAssociation();

        OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation newRemoveOrderItemShipGroupAssociation();

    }

	interface RemoveOrderShipGroup extends OrderShipGroupCommand
	{
	}

    interface CreateOrderItemShipGroupAssociationCommands extends Iterable<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation>
    {
        void add(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c);

        void remove(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c);

        void clear();
    }

    interface OrderItemShipGroupAssociationCommands extends Iterable<OrderItemShipGroupAssociationCommand>
    {
        void add(OrderItemShipGroupAssociationCommand c);

        void remove(OrderItemShipGroupAssociationCommand c);

        void clear();
    }

}

