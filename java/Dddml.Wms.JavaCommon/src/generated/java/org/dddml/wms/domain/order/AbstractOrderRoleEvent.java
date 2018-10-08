package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderRoleEvent extends AbstractEvent implements OrderRoleEvent.SqlOrderRoleEvent 
{
    private OrderRoleEventId orderRoleEventId;

    public OrderRoleEventId getOrderRoleEventId() {
        return this.orderRoleEventId;
    }

    public void setOrderRoleEventId(OrderRoleEventId eventId) {
        this.orderRoleEventId = eventId;
    }
    
    public PartyRoleId getPartyRoleId() {
        return getOrderRoleEventId().getPartyRoleId();
    }

    public void setPartyRoleId(PartyRoleId partyRoleId) {
        getOrderRoleEventId().setPartyRoleId(partyRoleId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

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

    protected AbstractOrderRoleEvent() {
    }

    protected AbstractOrderRoleEvent(OrderRoleEventId eventId) {
        this.orderRoleEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderRoleStateEvent extends AbstractOrderRoleEvent implements OrderRoleEvent.OrderRoleStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
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

        protected AbstractOrderRoleStateEvent(OrderRoleEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderRoleStateCreated extends AbstractOrderRoleStateEvent implements OrderRoleEvent.OrderRoleStateCreated
    {
        public AbstractOrderRoleStateCreated() {
            this(new OrderRoleEventId());
        }

        public AbstractOrderRoleStateCreated(OrderRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderRoleStateMergePatched extends AbstractOrderRoleStateEvent implements OrderRoleEvent.OrderRoleStateMergePatched
    {
        public AbstractOrderRoleStateMergePatched() {
            this(new OrderRoleEventId());
        }

        public AbstractOrderRoleStateMergePatched(OrderRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrderRoleStateRemoved extends AbstractOrderRoleStateEvent implements OrderRoleEvent.OrderRoleStateRemoved
    {
        public AbstractOrderRoleStateRemoved() {
            this(new OrderRoleEventId());
        }

        public AbstractOrderRoleStateRemoved(OrderRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleOrderRoleStateCreated extends AbstractOrderRoleStateCreated
    {
        public SimpleOrderRoleStateCreated() {
        }

        public SimpleOrderRoleStateCreated(OrderRoleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderRoleStateMergePatched extends AbstractOrderRoleStateMergePatched
    {
        public SimpleOrderRoleStateMergePatched() {
        }

        public SimpleOrderRoleStateMergePatched(OrderRoleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderRoleStateRemoved extends AbstractOrderRoleStateRemoved
    {
        public SimpleOrderRoleStateRemoved() {
        }

        public SimpleOrderRoleStateRemoved(OrderRoleEventId eventId) {
            super(eventId);
        }
    }

}

