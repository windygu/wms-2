package org.dddml.wms.domain.picklist;

import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class PicklistStateEventDto extends AbstractStateEvent
{

    private PicklistEventId picklistEventId;

    PicklistEventId getStateEventId() {
        if (picklistEventId == null) { picklistEventId = new PicklistEventId(); }
        return picklistEventId;
    }

    void setPicklistEventId(PicklistEventId eventId) {
        this.picklistEventId = eventId;
    }

    public String getPicklistId() {
        return getStateEventId().getPicklistId();
    }

    public void setPicklistId(String picklistId) {
        getStateEventId().setPicklistId(picklistId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String facilityId;

    public String getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId() {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId) {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    private String statusId;

    public String getStatusId() {
        return this.statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    private java.sql.Timestamp picklistDate;

    public java.sql.Timestamp getPicklistDate() {
        return this.picklistDate;
    }

    public void setPicklistDate(java.sql.Timestamp picklistDate) {
        this.picklistDate = picklistDate;
    }

    private Long pickwaveId;

    public Long getPickwaveId() {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId) {
        this.pickwaveId = pickwaveId;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyFacilityIdRemoved;

    public Boolean getIsPropertyFacilityIdRemoved() {
        return this.isPropertyFacilityIdRemoved;
    }

    public void setIsPropertyFacilityIdRemoved(Boolean removed) {
        this.isPropertyFacilityIdRemoved = removed;
    }

    private Boolean isPropertyShipmentMethodTypeIdRemoved;

    public Boolean getIsPropertyShipmentMethodTypeIdRemoved() {
        return this.isPropertyShipmentMethodTypeIdRemoved;
    }

    public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed) {
        this.isPropertyShipmentMethodTypeIdRemoved = removed;
    }

    private Boolean isPropertyStatusIdRemoved;

    public Boolean getIsPropertyStatusIdRemoved() {
        return this.isPropertyStatusIdRemoved;
    }

    public void setIsPropertyStatusIdRemoved(Boolean removed) {
        this.isPropertyStatusIdRemoved = removed;
    }

    private Boolean isPropertyPicklistDateRemoved;

    public Boolean getIsPropertyPicklistDateRemoved() {
        return this.isPropertyPicklistDateRemoved;
    }

    public void setIsPropertyPicklistDateRemoved(Boolean removed) {
        this.isPropertyPicklistDateRemoved = removed;
    }

    private Boolean isPropertyPickwaveIdRemoved;

    public Boolean getIsPropertyPickwaveIdRemoved() {
        return this.isPropertyPickwaveIdRemoved;
    }

    public void setIsPropertyPickwaveIdRemoved(Boolean removed) {
        this.isPropertyPickwaveIdRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private PicklistRoleStateEventDto[] picklistRoleEvents;

    public PicklistRoleStateEventDto[] getPicklistRoleEvents() {
        return this.picklistRoleEvents;
    }

    public void setPicklistRoleEvents(PicklistRoleStateEventDto[] events) {
        this.picklistRoleEvents = events;
    }


	public static class PicklistStateCreatedDto extends PicklistStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PicklistStateMergePatchedDto extends PicklistStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PicklistStateDeletedDto extends PicklistStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

