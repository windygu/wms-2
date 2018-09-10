package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderShipGroupDto extends AbstractOrderShipGroupCommandDto
{
    /**
     * Shipment Method Type Id
     */
    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    /**
     * Supplier Party Id
     */
    private String supplierPartyId;

    public String getSupplierPartyId()
    {
        return this.supplierPartyId;
    }

    public void setSupplierPartyId(String supplierPartyId)
    {
        this.supplierPartyId = supplierPartyId;
    }

    /**
     * For use with multi-vendor stores, order will be split so that each ship group is associated with only one vendor (only if applicable)
     */
    private String vendorPartyId;

    public String getVendorPartyId()
    {
        return this.vendorPartyId;
    }

    public void setVendorPartyId(String vendorPartyId)
    {
        this.vendorPartyId = vendorPartyId;
    }

    /**
     * Carrier Party Id
     */
    private String carrierPartyId;

    public String getCarrierPartyId()
    {
        return this.carrierPartyId;
    }

    public void setCarrierPartyId(String carrierPartyId)
    {
        this.carrierPartyId = carrierPartyId;
    }

    /**
     * Carrier Role Type Id
     */
    private String carrierRoleTypeId;

    public String getCarrierRoleTypeId()
    {
        return this.carrierRoleTypeId;
    }

    public void setCarrierRoleTypeId(String carrierRoleTypeId)
    {
        this.carrierRoleTypeId = carrierRoleTypeId;
    }

    /**
     * Facility Id
     */
    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    /**
     * Destination Facility Id
     */
    private String destinationFacilityId;

    public String getDestinationFacilityId()
    {
        return this.destinationFacilityId;
    }

    public void setDestinationFacilityId(String destinationFacilityId)
    {
        this.destinationFacilityId = destinationFacilityId;
    }

    /**
     * Contact Mech Id
     */
    private String contactMechId;

    public String getContactMechId()
    {
        return this.contactMechId;
    }

    public void setContactMechId(String contactMechId)
    {
        this.contactMechId = contactMechId;
    }

    /**
     * Telecom Contact Mech Id
     */
    private String telecomContactMechId;

    public String getTelecomContactMechId()
    {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId)
    {
        this.telecomContactMechId = telecomContactMechId;
    }

    /**
     * Tracking Number
     */
    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    /**
     * Contact Party Id
     */
    private String contactPartyId;

    public String getContactPartyId()
    {
        return this.contactPartyId;
    }

    public void setContactPartyId(String contactPartyId)
    {
        this.contactPartyId = contactPartyId;
    }

    /**
     * Vehicle Plate Number
     */
    private String vehiclePlateNumber;

    public String getVehiclePlateNumber()
    {
        return this.vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber)
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    /**
     * Shipping Instructions
     */
    private String shippingInstructions;

    public String getShippingInstructions()
    {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions)
    {
        this.shippingInstructions = shippingInstructions;
    }

    /**
     * May Split
     */
    private String maySplit;

    public String getMaySplit()
    {
        return this.maySplit;
    }

    public void setMaySplit(String maySplit)
    {
        this.maySplit = maySplit;
    }

    /**
     * Gift Message
     */
    private String giftMessage;

    public String getGiftMessage()
    {
        return this.giftMessage;
    }

    public void setGiftMessage(String giftMessage)
    {
        this.giftMessage = giftMessage;
    }

    /**
     * Is Gift
     */
    private String isGift;

    public String getIsGift()
    {
        return this.isGift;
    }

    public void setIsGift(String isGift)
    {
        this.isGift = isGift;
    }

    /**
     * Ship After Date
     */
    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate()
    {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
    {
        this.shipAfterDate = shipAfterDate;
    }

    /**
     * Ship By Date
     */
    private java.sql.Timestamp shipByDate;

    public java.sql.Timestamp getShipByDate()
    {
        return this.shipByDate;
    }

    public void setShipByDate(java.sql.Timestamp shipByDate)
    {
        this.shipByDate = shipByDate;
    }

    /**
     * Estimated Ship Date
     */
    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    /**
     * Estimated Delivery Date
     */
    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    /**
     * Pickwave Id
     */
    private Long pickwaveId;

    public Long getPickwaveId()
    {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId)
    {
        this.pickwaveId = pickwaveId;
    }

    /**
     * Number Of Packages
     */
    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    /**
     * Number Of Containers
     */
    private Integer numberOfContainers;

    public Integer getNumberOfContainers()
    {
        return this.numberOfContainers;
    }

    public void setNumberOfContainers(Integer numberOfContainers)
    {
        this.numberOfContainers = numberOfContainers;
    }

    /**
     * Number Of Pakages Per Container
     */
    private Integer numberOfPakagesPerContainer;

    public Integer getNumberOfPakagesPerContainer()
    {
        return this.numberOfPakagesPerContainer;
    }

    public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
    {
        this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private CreateOrMergePatchOrderItemShipGroupAssociationDto[] orderItemShipGroupAssociations;

    public CreateOrMergePatchOrderItemShipGroupAssociationDto[] getOrderItemShipGroupAssociations()
    {
        return this.orderItemShipGroupAssociations;
    }

    public void setOrderItemShipGroupAssociations(CreateOrMergePatchOrderItemShipGroupAssociationDto[] orderItemShipGroupAssociations)
    {
        this.orderItemShipGroupAssociations = orderItemShipGroupAssociations;
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

    private Boolean isPropertyDestinationFacilityIdRemoved;

    public Boolean getIsPropertyDestinationFacilityIdRemoved()
    {
        return this.isPropertyDestinationFacilityIdRemoved;
    }

    public void setIsPropertyDestinationFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyDestinationFacilityIdRemoved = removed;
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

    private Boolean isPropertyTrackingNumberRemoved;

    public Boolean getIsPropertyTrackingNumberRemoved()
    {
        return this.isPropertyTrackingNumberRemoved;
    }

    public void setIsPropertyTrackingNumberRemoved(Boolean removed)
    {
        this.isPropertyTrackingNumberRemoved = removed;
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

    private Boolean isPropertyVehiclePlateNumberRemoved;

    public Boolean getIsPropertyVehiclePlateNumberRemoved()
    {
        return this.isPropertyVehiclePlateNumberRemoved;
    }

    public void setIsPropertyVehiclePlateNumberRemoved(Boolean removed)
    {
        this.isPropertyVehiclePlateNumberRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractOrderShipGroupCommand.AbstractCreateOrMergePatchOrderShipGroup command)
    {
        ((AbstractOrderShipGroupCommandDto) this).copyTo(command);
        command.setShipmentMethodTypeId(this.getShipmentMethodTypeId());
        command.setSupplierPartyId(this.getSupplierPartyId());
        command.setVendorPartyId(this.getVendorPartyId());
        command.setCarrierPartyId(this.getCarrierPartyId());
        command.setCarrierRoleTypeId(this.getCarrierRoleTypeId());
        command.setFacilityId(this.getFacilityId());
        command.setDestinationFacilityId(this.getDestinationFacilityId());
        command.setContactMechId(this.getContactMechId());
        command.setTelecomContactMechId(this.getTelecomContactMechId());
        command.setTrackingNumber(this.getTrackingNumber());
        command.setContactPartyId(this.getContactPartyId());
        command.setVehiclePlateNumber(this.getVehiclePlateNumber());
        command.setShippingInstructions(this.getShippingInstructions());
        command.setMaySplit(this.getMaySplit());
        command.setGiftMessage(this.getGiftMessage());
        command.setIsGift(this.getIsGift());
        command.setShipAfterDate(this.getShipAfterDate());
        command.setShipByDate(this.getShipByDate());
        command.setEstimatedShipDate(this.getEstimatedShipDate());
        command.setEstimatedDeliveryDate(this.getEstimatedDeliveryDate());
        command.setPickwaveId(this.getPickwaveId());
        command.setNumberOfPackages(this.getNumberOfPackages());
        command.setNumberOfContainers(this.getNumberOfContainers());
        command.setNumberOfPakagesPerContainer(this.getNumberOfPakagesPerContainer());
        command.setActive(this.getActive());
    }

    public OrderShipGroupCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup command = new AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup();
            copyTo((AbstractOrderShipGroupCommand.AbstractCreateOrderShipGroup) command);
            if (this.getOrderItemShipGroupAssociations() != null) {
                for (CreateOrMergePatchOrderItemShipGroupAssociationDto cmd : this.getOrderItemShipGroupAssociations()) {
                    command.getOrderItemShipGroupAssociations().add((OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup command = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
            copyTo((AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup) command);
            if (this.getOrderItemShipGroupAssociations() != null) {
                for (CreateOrMergePatchOrderItemShipGroupAssociationDto cmd : this.getOrderItemShipGroupAssociations()) {
                    command.getOrderItemShipGroupAssociationCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup command = new AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup();
            ((AbstractOrderShipGroupCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderShipGroupCommand.AbstractCreateOrderShipGroup command)
    {
        copyTo((AbstractOrderShipGroupCommand.AbstractCreateOrMergePatchOrderShipGroup) command);
    }

    public void copyTo(AbstractOrderShipGroupCommand.AbstractMergePatchOrderShipGroup command)
    {
        copyTo((AbstractOrderShipGroupCommand.AbstractCreateOrMergePatchOrderShipGroup) command);
        command.setIsPropertyShipmentMethodTypeIdRemoved(this.getIsPropertyShipmentMethodTypeIdRemoved());
        command.setIsPropertySupplierPartyIdRemoved(this.getIsPropertySupplierPartyIdRemoved());
        command.setIsPropertyVendorPartyIdRemoved(this.getIsPropertyVendorPartyIdRemoved());
        command.setIsPropertyCarrierPartyIdRemoved(this.getIsPropertyCarrierPartyIdRemoved());
        command.setIsPropertyCarrierRoleTypeIdRemoved(this.getIsPropertyCarrierRoleTypeIdRemoved());
        command.setIsPropertyFacilityIdRemoved(this.getIsPropertyFacilityIdRemoved());
        command.setIsPropertyDestinationFacilityIdRemoved(this.getIsPropertyDestinationFacilityIdRemoved());
        command.setIsPropertyContactMechIdRemoved(this.getIsPropertyContactMechIdRemoved());
        command.setIsPropertyTelecomContactMechIdRemoved(this.getIsPropertyTelecomContactMechIdRemoved());
        command.setIsPropertyTrackingNumberRemoved(this.getIsPropertyTrackingNumberRemoved());
        command.setIsPropertyContactPartyIdRemoved(this.getIsPropertyContactPartyIdRemoved());
        command.setIsPropertyVehiclePlateNumberRemoved(this.getIsPropertyVehiclePlateNumberRemoved());
        command.setIsPropertyShippingInstructionsRemoved(this.getIsPropertyShippingInstructionsRemoved());
        command.setIsPropertyMaySplitRemoved(this.getIsPropertyMaySplitRemoved());
        command.setIsPropertyGiftMessageRemoved(this.getIsPropertyGiftMessageRemoved());
        command.setIsPropertyIsGiftRemoved(this.getIsPropertyIsGiftRemoved());
        command.setIsPropertyShipAfterDateRemoved(this.getIsPropertyShipAfterDateRemoved());
        command.setIsPropertyShipByDateRemoved(this.getIsPropertyShipByDateRemoved());
        command.setIsPropertyEstimatedShipDateRemoved(this.getIsPropertyEstimatedShipDateRemoved());
        command.setIsPropertyEstimatedDeliveryDateRemoved(this.getIsPropertyEstimatedDeliveryDateRemoved());
        command.setIsPropertyPickwaveIdRemoved(this.getIsPropertyPickwaveIdRemoved());
        command.setIsPropertyNumberOfPackagesRemoved(this.getIsPropertyNumberOfPackagesRemoved());
        command.setIsPropertyNumberOfContainersRemoved(this.getIsPropertyNumberOfContainersRemoved());
        command.setIsPropertyNumberOfPakagesPerContainerRemoved(this.getIsPropertyNumberOfPakagesPerContainerRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
    {
        public CreateOrderShipGroupDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderShipGroupCommand.CreateOrderShipGroup toCreateOrderShipGroup()
        {
            return (OrderShipGroupCommand.CreateOrderShipGroup) toCommand();
        }

    }

    public static class MergePatchOrderShipGroupDto extends CreateOrMergePatchOrderShipGroupDto
    {
        public MergePatchOrderShipGroupDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderShipGroupCommand.MergePatchOrderShipGroup toMergePatchOrderShipGroup()
        {
            return (OrderShipGroupCommand.MergePatchOrderShipGroup) toCommand();
        }

    }

}

