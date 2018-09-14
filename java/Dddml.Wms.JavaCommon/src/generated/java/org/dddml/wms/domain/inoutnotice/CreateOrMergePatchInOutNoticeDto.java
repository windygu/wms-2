package org.dddml.wms.domain.inoutnotice;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInOutNoticeDto extends AbstractInOutNoticeCommandDto
{
    /**
     * Warehouse Id
     */
    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    /**
     * In Out Notice Type
     */
    private String inOutNoticeType;

    public String getInOutNoticeType()
    {
        return this.inOutNoticeType;
    }

    public void setInOutNoticeType(String inOutNoticeType)
    {
        this.inOutNoticeType = inOutNoticeType;
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

    private Boolean isPropertyWarehouseIdRemoved;

    public Boolean getIsPropertyWarehouseIdRemoved()
    {
        return this.isPropertyWarehouseIdRemoved;
    }

    public void setIsPropertyWarehouseIdRemoved(Boolean removed)
    {
        this.isPropertyWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyInOutNoticeTypeRemoved;

    public Boolean getIsPropertyInOutNoticeTypeRemoved()
    {
        return this.isPropertyInOutNoticeTypeRemoved;
    }

    public void setIsPropertyInOutNoticeTypeRemoved(Boolean removed)
    {
        this.isPropertyInOutNoticeTypeRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractInOutNoticeCommand.AbstractCreateOrMergePatchInOutNotice command)
    {
        ((AbstractInOutNoticeCommandDto) this).copyTo(command);
        command.setWarehouseId(this.getWarehouseId());
        command.setInOutNoticeType(this.getInOutNoticeType());
        command.setTelecomContactMechId(this.getTelecomContactMechId());
        command.setTrackingNumber(this.getTrackingNumber());
        command.setContactPartyId(this.getContactPartyId());
        command.setVehiclePlateNumber(this.getVehiclePlateNumber());
        command.setShippingInstructions(this.getShippingInstructions());
        command.setEstimatedShipDate(this.getEstimatedShipDate());
        command.setEstimatedDeliveryDate(this.getEstimatedDeliveryDate());
        command.setActive(this.getActive());
    }

    public InOutNoticeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInOutNoticeCommand.SimpleCreateInOutNotice command = new AbstractInOutNoticeCommand.SimpleCreateInOutNotice();
            copyTo((AbstractInOutNoticeCommand.AbstractCreateInOutNotice) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInOutNoticeCommand.SimpleMergePatchInOutNotice command = new AbstractInOutNoticeCommand.SimpleMergePatchInOutNotice();
            copyTo((AbstractInOutNoticeCommand.SimpleMergePatchInOutNotice) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInOutNoticeCommand.AbstractCreateInOutNotice command)
    {
        copyTo((AbstractInOutNoticeCommand.AbstractCreateOrMergePatchInOutNotice) command);
    }

    public void copyTo(AbstractInOutNoticeCommand.AbstractMergePatchInOutNotice command)
    {
        copyTo((AbstractInOutNoticeCommand.AbstractCreateOrMergePatchInOutNotice) command);
        command.setIsPropertyWarehouseIdRemoved(this.getIsPropertyWarehouseIdRemoved());
        command.setIsPropertyInOutNoticeTypeRemoved(this.getIsPropertyInOutNoticeTypeRemoved());
        command.setIsPropertyTelecomContactMechIdRemoved(this.getIsPropertyTelecomContactMechIdRemoved());
        command.setIsPropertyTrackingNumberRemoved(this.getIsPropertyTrackingNumberRemoved());
        command.setIsPropertyContactPartyIdRemoved(this.getIsPropertyContactPartyIdRemoved());
        command.setIsPropertyVehiclePlateNumberRemoved(this.getIsPropertyVehiclePlateNumberRemoved());
        command.setIsPropertyShippingInstructionsRemoved(this.getIsPropertyShippingInstructionsRemoved());
        command.setIsPropertyEstimatedShipDateRemoved(this.getIsPropertyEstimatedShipDateRemoved());
        command.setIsPropertyEstimatedDeliveryDateRemoved(this.getIsPropertyEstimatedDeliveryDateRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInOutNoticeDto extends CreateOrMergePatchInOutNoticeDto
    {
        public CreateInOutNoticeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InOutNoticeCommand.CreateInOutNotice toCreateInOutNotice()
        {
            return (InOutNoticeCommand.CreateInOutNotice) toCommand();
        }

    }

    public static class MergePatchInOutNoticeDto extends CreateOrMergePatchInOutNoticeDto
    {
        public MergePatchInOutNoticeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InOutNoticeCommand.MergePatchInOutNotice toMergePatchInOutNotice()
        {
            return (InOutNoticeCommand.MergePatchInOutNotice) toCommand();
        }

    }

}

