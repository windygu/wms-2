package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderShipmentEvent extends AbstractEvent implements OrderShipmentEvent.SqlOrderShipmentEvent 
{
    private OrderShipmentEventId orderShipmentEventId;

    public OrderShipmentEventId getOrderShipmentEventId() {
        return this.orderShipmentEventId;
    }

    public void setOrderShipmentEventId(OrderShipmentEventId eventId) {
        this.orderShipmentEventId = eventId;
    }
    
    public OrderShipmentId getOrderShipmentId() {
        return getOrderShipmentEventId().getOrderShipmentId();
    }

    public void setOrderShipmentId(OrderShipmentId orderShipmentId) {
        getOrderShipmentEventId().setOrderShipmentId(orderShipmentId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getOrderShipmentEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getOrderShipmentEventId().setVersion(version);
    //}

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderShipmentEvent() {
    }

    protected AbstractOrderShipmentEvent(OrderShipmentEventId eventId) {
        this.orderShipmentEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderShipmentStateEvent extends AbstractOrderShipmentEvent implements OrderShipmentEvent.OrderShipmentStateEvent {
        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
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

        protected AbstractOrderShipmentStateEvent(OrderShipmentEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderShipmentStateCreated extends AbstractOrderShipmentStateEvent implements OrderShipmentEvent.OrderShipmentStateCreated
    {
        public AbstractOrderShipmentStateCreated() {
            this(new OrderShipmentEventId());
        }

        public AbstractOrderShipmentStateCreated(OrderShipmentEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderShipmentStateMergePatched extends AbstractOrderShipmentStateEvent implements OrderShipmentEvent.OrderShipmentStateMergePatched
    {
        public AbstractOrderShipmentStateMergePatched() {
            this(new OrderShipmentEventId());
        }

        public AbstractOrderShipmentStateMergePatched(OrderShipmentEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
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

    }


    public static class SimpleOrderShipmentStateCreated extends AbstractOrderShipmentStateCreated
    {
        public SimpleOrderShipmentStateCreated() {
        }

        public SimpleOrderShipmentStateCreated(OrderShipmentEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipmentStateMergePatched extends AbstractOrderShipmentStateMergePatched
    {
        public SimpleOrderShipmentStateMergePatched() {
        }

        public SimpleOrderShipmentStateMergePatched(OrderShipmentEventId eventId) {
            super(eventId);
        }
    }

}

