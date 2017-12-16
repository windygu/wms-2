package org.dddml.wms.domain.shipmentitem;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class ShipmentItemStateEventDto extends AbstractStateEvent
{

    private ShipmentItemStateEventIdDto stateEventId;

    ShipmentItemStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new ShipmentItemStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(ShipmentItemStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public ShipmentItemIdDto getShipmentItemId() {
        return getStateEventId().getShipmentItemId();
    }

    public void setShipmentItemId(ShipmentItemIdDto shipmentItemId) {
        getStateEventId().setShipmentItemId(shipmentItemId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String productId;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private String shipmentContentDescription;

    public String getShipmentContentDescription() {
        return this.shipmentContentDescription;
    }

    public void setShipmentContentDescription(String shipmentContentDescription) {
        this.shipmentContentDescription = shipmentContentDescription;
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

    private Boolean isPropertyProductIdRemoved;

    public Boolean getIsPropertyProductIdRemoved() {
        return this.isPropertyProductIdRemoved;
    }

    public void setIsPropertyProductIdRemoved(Boolean removed) {
        this.isPropertyProductIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyShipmentContentDescriptionRemoved;

    public Boolean getIsPropertyShipmentContentDescriptionRemoved() {
        return this.isPropertyShipmentContentDescriptionRemoved;
    }

    public void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed) {
        this.isPropertyShipmentContentDescriptionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class ShipmentItemStateCreatedDto extends ShipmentItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ShipmentItemStateMergePatchedDto extends ShipmentItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ShipmentItemStateDeletedDto extends ShipmentItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

