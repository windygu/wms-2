package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class ShipmentMethodTypeStateEventDto extends AbstractEvent
{

    private ShipmentMethodTypeEventId shipmentMethodTypeEventId;

    ShipmentMethodTypeEventId getShipmentMethodTypeEventId() {
        if (shipmentMethodTypeEventId == null) { shipmentMethodTypeEventId = new ShipmentMethodTypeEventId(); }
        return shipmentMethodTypeEventId;
    }

    void setShipmentMethodTypeEventId(ShipmentMethodTypeEventId eventId) {
        this.shipmentMethodTypeEventId = eventId;
    }

    public String getShipmentMethodTypeId() {
        return getShipmentMethodTypeEventId().getShipmentMethodTypeId();
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId) {
        getShipmentMethodTypeEventId().setShipmentMethodTypeId(shipmentMethodTypeId);
    }

    public Long getVersion() {
        return getShipmentMethodTypeEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getShipmentMethodTypeEventId().setVersion(version);
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Long sequenceNum;

    public Long getSequenceNum() {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum) {
        this.sequenceNum = sequenceNum;
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

    private Boolean isPropertySequenceNumRemoved;

    public Boolean getIsPropertySequenceNumRemoved() {
        return this.isPropertySequenceNumRemoved;
    }

    public void setIsPropertySequenceNumRemoved(Boolean removed) {
        this.isPropertySequenceNumRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class ShipmentMethodTypeStateCreatedDto extends ShipmentMethodTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ShipmentMethodTypeStateMergePatchedDto extends ShipmentMethodTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ShipmentMethodTypeStateDeletedDto extends ShipmentMethodTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

