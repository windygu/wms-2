package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipGroupCommand extends AbstractCommand implements OrderShipGroupCommand
{
    private String shipGroupSeqId;

    public String getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(String shipGroupSeqId)
    {
        this.shipGroupSeqId = shipGroupSeqId;
    }

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }


    public static abstract class AbstractCreateOrMergePatchOrderShipGroup extends AbstractOrderShipGroupCommand implements CreateOrMergePatchOrderShipGroup
    {
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        public OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation newCreateOrderItemShipGroupAssociation()
        {
            AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation c = new AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation();
            c.setOrderId(this.getOrderId());

            c.setOrderShipGroupShipGroupSeqId(this.getShipGroupSeqId());

            return c;
        }

        public OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation newMergePatchOrderItemShipGroupAssociation()
        {
            AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation c = new AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation();
            c.setOrderId(this.getOrderId());

            c.setOrderShipGroupShipGroupSeqId(this.getShipGroupSeqId());

            return c;
        }

        public OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation newRemoveOrderItemShipGroupAssociation()
        {
            AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation c = new AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation();
            c.setOrderId(this.getOrderId());

            c.setOrderShipGroupShipGroupSeqId(this.getShipGroupSeqId());

            return c;
        }

    }

    public static abstract class AbstractCreateOrderShipGroup extends AbstractCreateOrMergePatchOrderShipGroup implements CreateOrderShipGroup
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateOrderItemShipGroupAssociationCommandCollection createOrderItemShipGroupAssociationCommands = new SimpleCreateOrderItemShipGroupAssociationCommandCollection();

        public CreateOrderItemShipGroupAssociationCommandCollection getCreateOrderItemShipGroupAssociationCommands() {
            return this.createOrderItemShipGroupAssociationCommands;
        }

        public CreateOrderItemShipGroupAssociationCommandCollection getOrderItemShipGroupAssociations() {
            return this.createOrderItemShipGroupAssociationCommands; //orderItemShipGroupAssociations;
        }

    }

    public static abstract class AbstractMergePatchOrderShipGroup extends AbstractCreateOrMergePatchOrderShipGroup implements MergePatchOrderShipGroup
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private String orderShipGroupAction;
 
        public String getOrderShipGroupAction() {
            return this.orderShipGroupAction;
        }

        public void setOrderShipGroupAction(String orderShipGroupAction) {
            this.orderShipGroupAction = orderShipGroupAction;
        }
                
        private Boolean isPropertyShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyShipmentMethodTypeIdRemoved()
        {
            return this.isPropertyShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed)
        {
            this.isPropertyShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertySupplierPartyIdRemoved;

        public Boolean getIsPropertySupplierPartyIdRemoved()
        {
            return this.isPropertySupplierPartyIdRemoved;
        }

        public void setIsPropertySupplierPartyIdRemoved(Boolean removed)
        {
            this.isPropertySupplierPartyIdRemoved = removed;
        }

        private Boolean isPropertyVendorPartyIdRemoved;

        public Boolean getIsPropertyVendorPartyIdRemoved()
        {
            return this.isPropertyVendorPartyIdRemoved;
        }

        public void setIsPropertyVendorPartyIdRemoved(Boolean removed)
        {
            this.isPropertyVendorPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierPartyIdRemoved;

        public Boolean getIsPropertyCarrierPartyIdRemoved()
        {
            return this.isPropertyCarrierPartyIdRemoved;
        }

        public void setIsPropertyCarrierPartyIdRemoved(Boolean removed)
        {
            this.isPropertyCarrierPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierRoleTypeIdRemoved;

        public Boolean getIsPropertyCarrierRoleTypeIdRemoved()
        {
            return this.isPropertyCarrierRoleTypeIdRemoved;
        }

        public void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed)
        {
            this.isPropertyCarrierRoleTypeIdRemoved = removed;
        }

        private Boolean isPropertyFacilityIdRemoved;

        public Boolean getIsPropertyFacilityIdRemoved()
        {
            return this.isPropertyFacilityIdRemoved;
        }

        public void setIsPropertyFacilityIdRemoved(Boolean removed)
        {
            this.isPropertyFacilityIdRemoved = removed;
        }

        private Boolean isPropertyContactMechIdRemoved;

        public Boolean getIsPropertyContactMechIdRemoved()
        {
            return this.isPropertyContactMechIdRemoved;
        }

        public void setIsPropertyContactMechIdRemoved(Boolean removed)
        {
            this.isPropertyContactMechIdRemoved = removed;
        }

        private Boolean isPropertyTelecomContactMechIdRemoved;

        public Boolean getIsPropertyTelecomContactMechIdRemoved()
        {
            return this.isPropertyTelecomContactMechIdRemoved;
        }

        public void setIsPropertyTelecomContactMechIdRemoved(Boolean removed)
        {
            this.isPropertyTelecomContactMechIdRemoved = removed;
        }

        private Boolean isPropertyMaySplitRemoved;

        public Boolean getIsPropertyMaySplitRemoved()
        {
            return this.isPropertyMaySplitRemoved;
        }

        public void setIsPropertyMaySplitRemoved(Boolean removed)
        {
            this.isPropertyMaySplitRemoved = removed;
        }

        private Boolean isPropertyGiftMessageRemoved;

        public Boolean getIsPropertyGiftMessageRemoved()
        {
            return this.isPropertyGiftMessageRemoved;
        }

        public void setIsPropertyGiftMessageRemoved(Boolean removed)
        {
            this.isPropertyGiftMessageRemoved = removed;
        }

        private Boolean isPropertyIsGiftRemoved;

        public Boolean getIsPropertyIsGiftRemoved()
        {
            return this.isPropertyIsGiftRemoved;
        }

        public void setIsPropertyIsGiftRemoved(Boolean removed)
        {
            this.isPropertyIsGiftRemoved = removed;
        }

        private Boolean isPropertyShipAfterDateRemoved;

        public Boolean getIsPropertyShipAfterDateRemoved()
        {
            return this.isPropertyShipAfterDateRemoved;
        }

        public void setIsPropertyShipAfterDateRemoved(Boolean removed)
        {
            this.isPropertyShipAfterDateRemoved = removed;
        }

        private Boolean isPropertyShipByDateRemoved;

        public Boolean getIsPropertyShipByDateRemoved()
        {
            return this.isPropertyShipByDateRemoved;
        }

        public void setIsPropertyShipByDateRemoved(Boolean removed)
        {
            this.isPropertyShipByDateRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private OrderItemShipGroupAssociationCommandCollection orderItemShipGroupAssociationCommands = new SimpleOrderItemShipGroupAssociationCommandCollection();

        public OrderItemShipGroupAssociationCommandCollection getOrderItemShipGroupAssociationCommands()
        {
            return this.orderItemShipGroupAssociationCommands;
        }

    }

    public static class SimpleCreateOrderShipGroup extends AbstractCreateOrderShipGroup
    {
    }

    
    public static class SimpleMergePatchOrderShipGroup extends AbstractMergePatchOrderShipGroup
    {
    }

    
	public static class SimpleRemoveOrderShipGroup extends AbstractOrderShipGroupCommand implements RemoveOrderShipGroup
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    
    public static class SimpleCreateOrderItemShipGroupAssociationCommandCollection implements CreateOrderItemShipGroupAssociationCommandCollection {
        private List<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation> innerCommands = new ArrayList<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation>();

        public void add(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c) {
            innerCommands.add(c);
        }

        public void remove(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleOrderItemShipGroupAssociationCommandCollection implements OrderItemShipGroupAssociationCommandCollection {
        private List<OrderItemShipGroupAssociationCommand> innerCommands = new ArrayList<OrderItemShipGroupAssociationCommand>();

        public void add(OrderItemShipGroupAssociationCommand c) {
            innerCommands.add(c);
        }

        public void remove(OrderItemShipGroupAssociationCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderItemShipGroupAssociationCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

