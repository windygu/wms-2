package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutNoticeCommand extends AbstractCommand implements InOutNoticeCommand
{
    private String inOutNoticeId;

    public String getInOutNoticeId()
    {
        return this.inOutNoticeId;
    }

    public void setInOutNoticeId(String inOutNoticeId)
    {
        this.inOutNoticeId = inOutNoticeId;
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


    public static abstract class AbstractCreateOrMergePatchInOutNotice extends AbstractInOutNoticeCommand implements CreateOrMergePatchInOutNotice
    {
        private String warehouseId;

        public String getWarehouseId()
        {
            return this.warehouseId;
        }

        public void setWarehouseId(String warehouseId)
        {
            this.warehouseId = warehouseId;
        }

        private String inOutNoticeType;

        public String getInOutNoticeType()
        {
            return this.inOutNoticeType;
        }

        public void setInOutNoticeType(String inOutNoticeType)
        {
            this.inOutNoticeType = inOutNoticeType;
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

        private String contactPartyId;

        public String getContactPartyId()
        {
            return this.contactPartyId;
        }

        public void setContactPartyId(String contactPartyId)
        {
            this.contactPartyId = contactPartyId;
        }

        private String vehiclePlateNumber;

        public String getVehiclePlateNumber()
        {
            return this.vehiclePlateNumber;
        }

        public void setVehiclePlateNumber(String vehiclePlateNumber)
        {
            this.vehiclePlateNumber = vehiclePlateNumber;
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

        private Boolean isScheduleNeeded;

        public Boolean getIsScheduleNeeded()
        {
            return this.isScheduleNeeded;
        }

        public void setIsScheduleNeeded(Boolean isScheduleNeeded)
        {
            this.isScheduleNeeded = isScheduleNeeded;
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

    }

    public static abstract class AbstractCreateInOutNotice extends AbstractCreateOrMergePatchInOutNotice implements CreateInOutNotice
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchInOutNotice extends AbstractCreateOrMergePatchInOutNotice implements MergePatchInOutNotice
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private Boolean isPropertyIsScheduleNeededRemoved;

        public Boolean getIsPropertyIsScheduleNeededRemoved()
        {
            return this.isPropertyIsScheduleNeededRemoved;
        }

        public void setIsPropertyIsScheduleNeededRemoved(Boolean removed)
        {
            this.isPropertyIsScheduleNeededRemoved = removed;
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

    }

    public static class SimpleCreateInOutNotice extends AbstractCreateInOutNotice
    {
    }

    
    public static class SimpleMergePatchInOutNotice extends AbstractMergePatchInOutNotice
    {
    }

    
	public static class SimpleDeleteInOutNotice extends AbstractInOutNoticeCommand implements DeleteInOutNotice
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

