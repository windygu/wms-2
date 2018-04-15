package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class ShipmentPackageContentStateEventDto extends AbstractEvent
{

    private ShipmentPackageContentEventId shipmentPackageContentEventId;

    ShipmentPackageContentEventId getStateEventId() {
        if (shipmentPackageContentEventId == null) { shipmentPackageContentEventId = new ShipmentPackageContentEventId(); }
        return shipmentPackageContentEventId;
    }

    void setShipmentPackageContentEventId(ShipmentPackageContentEventId eventId) {
        this.shipmentPackageContentEventId = eventId;
    }

    public String getShipmentItemSeqId() {
        return getStateEventId().getShipmentItemSeqId();
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        getStateEventId().setShipmentItemSeqId(shipmentItemSeqId);
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private String subProductId;

    public String getSubProductId() {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId) {
        this.subProductId = subProductId;
    }

    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity() {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity) {
        this.subProductQuantity = subProductQuantity;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertySubProductIdRemoved;

    public Boolean getIsPropertySubProductIdRemoved() {
        return this.isPropertySubProductIdRemoved;
    }

    public void setIsPropertySubProductIdRemoved(Boolean removed) {
        this.isPropertySubProductIdRemoved = removed;
    }

    private Boolean isPropertySubProductQuantityRemoved;

    public Boolean getIsPropertySubProductQuantityRemoved() {
        return this.isPropertySubProductQuantityRemoved;
    }

    public void setIsPropertySubProductQuantityRemoved(Boolean removed) {
        this.isPropertySubProductQuantityRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class ShipmentPackageContentStateCreatedDto extends ShipmentPackageContentStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ShipmentPackageContentStateMergePatchedDto extends ShipmentPackageContentStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ShipmentPackageContentStateRemovedDto extends ShipmentPackageContentStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

