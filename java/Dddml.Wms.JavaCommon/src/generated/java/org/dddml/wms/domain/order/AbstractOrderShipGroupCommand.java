package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipGroupCommand extends AbstractCommand implements OrderShipGroupCommand
{
    private Long shipGroupSeqId;

    public Long getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(Long shipGroupSeqId)
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

        private String contactPartyId;

        public String getContactPartyId()
        {
            return this.contactPartyId;
        }

        public void setContactPartyId(String contactPartyId)
        {
            this.contactPartyId = contactPartyId;
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

        private Integer numberOfPackages;

        public Integer getNumberOfPackages()
        {
            return this.numberOfPackages;
        }

        public void setNumberOfPackages(Integer numberOfPackages)
        {
            this.numberOfPackages = numberOfPackages;
        }

        private Integer numberOfContainers;

        public Integer getNumberOfContainers()
        {
            return this.numberOfContainers;
        }

        public void setNumberOfContainers(Integer numberOfContainers)
        {
            this.numberOfContainers = numberOfContainers;
        }

        private Integer numberOfPakagesPerContainer;

        public Integer getNumberOfPakagesPerContainer()
        {
            return this.numberOfPakagesPerContainer;
        }

        public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
        {
            this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
        }

        private String statusId;

        public String getStatusId()
        {
            return this.statusId;
        }

        public void setStatusId(String statusId)
        {
            this.statusId = statusId;
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

        private CreateOrderItemShipGroupAssociationCommands orderItemShipGroupAssociations = new SimpleCreateOrderItemShipGroupAssociationCommands();

        public CreateOrderItemShipGroupAssociationCommands getOrderItemShipGroupAssociations()
        {
            return this.orderItemShipGroupAssociations;
        }

    }

    public static abstract class AbstractMergePatchOrderShipGroup extends AbstractCreateOrMergePatchOrderShipGroup implements MergePatchOrderShipGroup
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private Boolean isPropertyContactPartyIdRemoved;

        public Boolean getIsPropertyContactPartyIdRemoved()
        {
            return this.isPropertyContactPartyIdRemoved;
        }

        public void setIsPropertyContactPartyIdRemoved(Boolean removed)
        {
            this.isPropertyContactPartyIdRemoved = removed;
        }

        private Boolean isPropertyTrackingNumberRemoved;

        public Boolean getIsPropertyTrackingNumberRemoved()
        {
            return this.isPropertyTrackingNumberRemoved;
        }

        public void setIsPropertyTrackingNumberRemoved(Boolean removed)
        {
            this.isPropertyTrackingNumberRemoved = removed;
        }

        private Boolean isPropertyShippingInstructionsRemoved;

        public Boolean getIsPropertyShippingInstructionsRemoved()
        {
            return this.isPropertyShippingInstructionsRemoved;
        }

        public void setIsPropertyShippingInstructionsRemoved(Boolean removed)
        {
            this.isPropertyShippingInstructionsRemoved = removed;
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

        private Boolean isPropertyEstimatedShipDateRemoved;

        public Boolean getIsPropertyEstimatedShipDateRemoved()
        {
            return this.isPropertyEstimatedShipDateRemoved;
        }

        public void setIsPropertyEstimatedShipDateRemoved(Boolean removed)
        {
            this.isPropertyEstimatedShipDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedDeliveryDateRemoved;

        public Boolean getIsPropertyEstimatedDeliveryDateRemoved()
        {
            return this.isPropertyEstimatedDeliveryDateRemoved;
        }

        public void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed)
        {
            this.isPropertyEstimatedDeliveryDateRemoved = removed;
        }

        private Boolean isPropertyPickwaveIdRemoved;

        public Boolean getIsPropertyPickwaveIdRemoved()
        {
            return this.isPropertyPickwaveIdRemoved;
        }

        public void setIsPropertyPickwaveIdRemoved(Boolean removed)
        {
            this.isPropertyPickwaveIdRemoved = removed;
        }

        private Boolean isPropertyNumberOfPackagesRemoved;

        public Boolean getIsPropertyNumberOfPackagesRemoved()
        {
            return this.isPropertyNumberOfPackagesRemoved;
        }

        public void setIsPropertyNumberOfPackagesRemoved(Boolean removed)
        {
            this.isPropertyNumberOfPackagesRemoved = removed;
        }

        private Boolean isPropertyNumberOfContainersRemoved;

        public Boolean getIsPropertyNumberOfContainersRemoved()
        {
            return this.isPropertyNumberOfContainersRemoved;
        }

        public void setIsPropertyNumberOfContainersRemoved(Boolean removed)
        {
            this.isPropertyNumberOfContainersRemoved = removed;
        }

        private Boolean isPropertyNumberOfPakagesPerContainerRemoved;

        public Boolean getIsPropertyNumberOfPakagesPerContainerRemoved()
        {
            return this.isPropertyNumberOfPakagesPerContainerRemoved;
        }

        public void setIsPropertyNumberOfPakagesPerContainerRemoved(Boolean removed)
        {
            this.isPropertyNumberOfPakagesPerContainerRemoved = removed;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved()
        {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed)
        {
            this.isPropertyStatusIdRemoved = removed;
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

        private OrderItemShipGroupAssociationCommands orderItemShipGroupAssociationCommands = new SimpleOrderItemShipGroupAssociationCommands();

        public OrderItemShipGroupAssociationCommands getOrderItemShipGroupAssociationCommands()
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

    
    public static class SimpleCreateOrderItemShipGroupAssociationCommands implements CreateOrderItemShipGroupAssociationCommands
    {
        private List<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation> innerCommands = new ArrayList<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation>();

        public void add(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleOrderItemShipGroupAssociationCommands implements OrderItemShipGroupAssociationCommands
    {
        private List<OrderItemShipGroupAssociationCommand> innerCommands = new ArrayList<OrderItemShipGroupAssociationCommand>();

        public void add(OrderItemShipGroupAssociationCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderItemShipGroupAssociationCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderItemShipGroupAssociationCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

