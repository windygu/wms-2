package org.dddml.wms.domain.inoutnotice;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class InOutNoticeStateEventDto extends AbstractEvent
{

    private InOutNoticeEventId inOutNoticeEventId;

    InOutNoticeEventId getInOutNoticeEventId() {
        if (inOutNoticeEventId == null) { inOutNoticeEventId = new InOutNoticeEventId(); }
        return inOutNoticeEventId;
    }

    void setInOutNoticeEventId(InOutNoticeEventId eventId) {
        this.inOutNoticeEventId = eventId;
    }

    public String getInOutNoticeId() {
        return getInOutNoticeEventId().getInOutNoticeId();
    }

    public void setInOutNoticeId(String inOutNoticeId) {
        getInOutNoticeEventId().setInOutNoticeId(inOutNoticeId);
    }

    public Long getVersion() {
        return getInOutNoticeEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getInOutNoticeEventId().setVersion(version);
    }

    private String warehouseId;

    public String getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    private String inOutNoticeType;

    public String getInOutNoticeType() {
        return this.inOutNoticeType;
    }

    public void setInOutNoticeType(String inOutNoticeType) {
        this.inOutNoticeType = inOutNoticeType;
    }

    private String telecomContactMechId;

    public String getTelecomContactMechId() {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId) {
        this.telecomContactMechId = telecomContactMechId;
    }

    private String trackingNumber;

    public String getTrackingNumber() {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    private String contactPartyId;

    public String getContactPartyId() {
        return this.contactPartyId;
    }

    public void setContactPartyId(String contactPartyId) {
        this.contactPartyId = contactPartyId;
    }

    private String vehiclePlateNumber;

    public String getVehiclePlateNumber() {
        return this.vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    private String shippingInstructions;

    public String getShippingInstructions() {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate() {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate) {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate() {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private Boolean isScheduleNeeded;

    public Boolean getIsScheduleNeeded() {
        return this.isScheduleNeeded;
    }

    public void setIsScheduleNeeded(Boolean isScheduleNeeded) {
        this.isScheduleNeeded = isScheduleNeeded;
    }

    private String statusId;

    public String getStatusId() {
        return this.statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyWarehouseIdRemoved;

    public Boolean getIsPropertyWarehouseIdRemoved() {
        return this.isPropertyWarehouseIdRemoved;
    }

    public void setIsPropertyWarehouseIdRemoved(Boolean removed) {
        this.isPropertyWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyInOutNoticeTypeRemoved;

    public Boolean getIsPropertyInOutNoticeTypeRemoved() {
        return this.isPropertyInOutNoticeTypeRemoved;
    }

    public void setIsPropertyInOutNoticeTypeRemoved(Boolean removed) {
        this.isPropertyInOutNoticeTypeRemoved = removed;
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

    private Boolean isPropertyContactPartyIdRemoved;

    public Boolean getIsPropertyContactPartyIdRemoved() {
        return this.isPropertyContactPartyIdRemoved;
    }

    public void setIsPropertyContactPartyIdRemoved(Boolean removed) {
        this.isPropertyContactPartyIdRemoved = removed;
    }

    private Boolean isPropertyVehiclePlateNumberRemoved;

    public Boolean getIsPropertyVehiclePlateNumberRemoved() {
        return this.isPropertyVehiclePlateNumberRemoved;
    }

    public void setIsPropertyVehiclePlateNumberRemoved(Boolean removed) {
        this.isPropertyVehiclePlateNumberRemoved = removed;
    }

    private Boolean isPropertyShippingInstructionsRemoved;

    public Boolean getIsPropertyShippingInstructionsRemoved() {
        return this.isPropertyShippingInstructionsRemoved;
    }

    public void setIsPropertyShippingInstructionsRemoved(Boolean removed) {
        this.isPropertyShippingInstructionsRemoved = removed;
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

    private Boolean isPropertyIsScheduleNeededRemoved;

    public Boolean getIsPropertyIsScheduleNeededRemoved() {
        return this.isPropertyIsScheduleNeededRemoved;
    }

    public void setIsPropertyIsScheduleNeededRemoved(Boolean removed) {
        this.isPropertyIsScheduleNeededRemoved = removed;
    }

    private Boolean isPropertyStatusIdRemoved;

    public Boolean getIsPropertyStatusIdRemoved() {
        return this.isPropertyStatusIdRemoved;
    }

    public void setIsPropertyStatusIdRemoved(Boolean removed) {
        this.isPropertyStatusIdRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class InOutNoticeStateCreatedDto extends InOutNoticeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InOutNoticeStateMergePatchedDto extends InOutNoticeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InOutNoticeStateDeletedDto extends InOutNoticeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

