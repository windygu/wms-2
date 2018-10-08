package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractGoodIdentificationEvent extends AbstractEvent implements GoodIdentificationEvent.SqlGoodIdentificationEvent 
{
    private GoodIdentificationEventId goodIdentificationEventId;

    public GoodIdentificationEventId getGoodIdentificationEventId() {
        return this.goodIdentificationEventId;
    }

    public void setGoodIdentificationEventId(GoodIdentificationEventId eventId) {
        this.goodIdentificationEventId = eventId;
    }
    
    public String getGoodIdentificationTypeId() {
        return getGoodIdentificationEventId().getGoodIdentificationTypeId();
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId) {
        getGoodIdentificationEventId().setGoodIdentificationTypeId(goodIdentificationTypeId);
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

    protected AbstractGoodIdentificationEvent() {
    }

    protected AbstractGoodIdentificationEvent(GoodIdentificationEventId eventId) {
        this.goodIdentificationEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractGoodIdentificationStateEvent extends AbstractGoodIdentificationEvent implements GoodIdentificationEvent.GoodIdentificationStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String idValue;

        public String getIdValue()
        {
            return this.idValue;
        }

        public void setIdValue(String idValue)
        {
            this.idValue = idValue;
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

        protected AbstractGoodIdentificationStateEvent(GoodIdentificationEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractGoodIdentificationStateCreated extends AbstractGoodIdentificationStateEvent implements GoodIdentificationEvent.GoodIdentificationStateCreated
    {
        public AbstractGoodIdentificationStateCreated() {
            this(new GoodIdentificationEventId());
        }

        public AbstractGoodIdentificationStateCreated(GoodIdentificationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractGoodIdentificationStateMergePatched extends AbstractGoodIdentificationStateEvent implements GoodIdentificationEvent.GoodIdentificationStateMergePatched
    {
        public AbstractGoodIdentificationStateMergePatched() {
            this(new GoodIdentificationEventId());
        }

        public AbstractGoodIdentificationStateMergePatched(GoodIdentificationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyIdValueRemoved;

        public Boolean getIsPropertyIdValueRemoved() {
            return this.isPropertyIdValueRemoved;
        }

        public void setIsPropertyIdValueRemoved(Boolean removed) {
            this.isPropertyIdValueRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractGoodIdentificationStateRemoved extends AbstractGoodIdentificationStateEvent implements GoodIdentificationEvent.GoodIdentificationStateRemoved
    {
        public AbstractGoodIdentificationStateRemoved() {
            this(new GoodIdentificationEventId());
        }

        public AbstractGoodIdentificationStateRemoved(GoodIdentificationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleGoodIdentificationStateCreated extends AbstractGoodIdentificationStateCreated
    {
        public SimpleGoodIdentificationStateCreated() {
        }

        public SimpleGoodIdentificationStateCreated(GoodIdentificationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleGoodIdentificationStateMergePatched extends AbstractGoodIdentificationStateMergePatched
    {
        public SimpleGoodIdentificationStateMergePatched() {
        }

        public SimpleGoodIdentificationStateMergePatched(GoodIdentificationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleGoodIdentificationStateRemoved extends AbstractGoodIdentificationStateRemoved
    {
        public SimpleGoodIdentificationStateRemoved() {
        }

        public SimpleGoodIdentificationStateRemoved(GoodIdentificationEventId eventId) {
            super(eventId);
        }
    }

}

