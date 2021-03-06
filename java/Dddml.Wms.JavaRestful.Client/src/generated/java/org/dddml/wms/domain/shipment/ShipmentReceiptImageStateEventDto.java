package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class ShipmentReceiptImageStateEventDto extends AbstractEvent
{

    private ShipmentReceiptImageEventId shipmentReceiptImageEventId;

    ShipmentReceiptImageEventId getShipmentReceiptImageEventId() {
        if (shipmentReceiptImageEventId == null) { shipmentReceiptImageEventId = new ShipmentReceiptImageEventId(); }
        return shipmentReceiptImageEventId;
    }

    void setShipmentReceiptImageEventId(ShipmentReceiptImageEventId eventId) {
        this.shipmentReceiptImageEventId = eventId;
    }

    public String getSequenceId() {
        return getShipmentReceiptImageEventId().getSequenceId();
    }

    public void setSequenceId(String sequenceId) {
        getShipmentReceiptImageEventId().setSequenceId(sequenceId);
    }

    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean isPropertyUrlRemoved;

    public Boolean getIsPropertyUrlRemoved() {
        return this.isPropertyUrlRemoved;
    }

    public void setIsPropertyUrlRemoved(Boolean removed) {
        this.isPropertyUrlRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class ShipmentReceiptImageStateCreatedDto extends ShipmentReceiptImageStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ShipmentReceiptImageStateMergePatchedDto extends ShipmentReceiptImageStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ShipmentReceiptImageStateRemovedDto extends ShipmentReceiptImageStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

