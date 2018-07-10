package org.dddml.wms.domain.ordershipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class OrderShipmentStateEventDto extends AbstractEvent
{

    private OrderShipmentEventId orderShipmentEventId;

    OrderShipmentEventId getOrderShipmentEventId() {
        if (orderShipmentEventId == null) { orderShipmentEventId = new OrderShipmentEventId(); }
        return orderShipmentEventId;
    }

    void setOrderShipmentEventId(OrderShipmentEventId eventId) {
        this.orderShipmentEventId = eventId;
    }

    public OrderShipmentId getOrderShipmentId() {
        return getOrderShipmentEventId().getOrderShipmentId();
    }

    public void setOrderShipmentId(OrderShipmentId orderShipmentId) {
        getOrderShipmentEventId().setOrderShipmentId(orderShipmentId);
    }

    public Long getVersion() {
        return getOrderShipmentEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getOrderShipmentEventId().setVersion(version);
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class OrderShipmentStateCreatedDto extends OrderShipmentStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderShipmentStateMergePatchedDto extends OrderShipmentStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderShipmentStateDeletedDto extends OrderShipmentStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

