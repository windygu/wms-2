package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractGoodIdentificationTypeEvent extends AbstractEvent implements GoodIdentificationTypeEvent.SqlGoodIdentificationTypeEvent 
{
    private GoodIdentificationTypeEventId goodIdentificationTypeEventId;

    public GoodIdentificationTypeEventId getGoodIdentificationTypeEventId() {
        return this.goodIdentificationTypeEventId;
    }

    public void setGoodIdentificationTypeEventId(GoodIdentificationTypeEventId eventId) {
        this.goodIdentificationTypeEventId = eventId;
    }
    
    public String getGoodIdentificationTypeId() {
        return getGoodIdentificationTypeEventId().getGoodIdentificationTypeId();
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId) {
        getGoodIdentificationTypeEventId().setGoodIdentificationTypeId(goodIdentificationTypeId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getGoodIdentificationTypeEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getGoodIdentificationTypeEventId().setVersion(version);
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

    protected AbstractGoodIdentificationTypeEvent() {
    }

    protected AbstractGoodIdentificationTypeEvent(GoodIdentificationTypeEventId eventId) {
        this.goodIdentificationTypeEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractGoodIdentificationTypeStateEvent extends AbstractGoodIdentificationTypeEvent implements GoodIdentificationTypeEvent.GoodIdentificationTypeStateEvent {
        private String parentTypeId;

        public String getParentTypeId()
        {
            return this.parentTypeId;
        }

        public void setParentTypeId(String parentTypeId)
        {
            this.parentTypeId = parentTypeId;
        }

        private String hasTable;

        public String getHasTable()
        {
            return this.hasTable;
        }

        public void setHasTable(String hasTable)
        {
            this.hasTable = hasTable;
        }

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
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

        protected AbstractGoodIdentificationTypeStateEvent(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractGoodIdentificationTypeStateCreated extends AbstractGoodIdentificationTypeStateEvent implements GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated
    {
        public AbstractGoodIdentificationTypeStateCreated() {
            this(new GoodIdentificationTypeEventId());
        }

        public AbstractGoodIdentificationTypeStateCreated(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractGoodIdentificationTypeStateMergePatched extends AbstractGoodIdentificationTypeStateEvent implements GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched
    {
        public AbstractGoodIdentificationTypeStateMergePatched() {
            this(new GoodIdentificationTypeEventId());
        }

        public AbstractGoodIdentificationTypeStateMergePatched(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyParentTypeIdRemoved;

        public Boolean getIsPropertyParentTypeIdRemoved() {
            return this.isPropertyParentTypeIdRemoved;
        }

        public void setIsPropertyParentTypeIdRemoved(Boolean removed) {
            this.isPropertyParentTypeIdRemoved = removed;
        }

        private Boolean isPropertyHasTableRemoved;

        public Boolean getIsPropertyHasTableRemoved() {
            return this.isPropertyHasTableRemoved;
        }

        public void setIsPropertyHasTableRemoved(Boolean removed) {
            this.isPropertyHasTableRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractGoodIdentificationTypeStateDeleted extends AbstractGoodIdentificationTypeStateEvent implements GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted
    {
        public AbstractGoodIdentificationTypeStateDeleted() {
            this(new GoodIdentificationTypeEventId());
        }

        public AbstractGoodIdentificationTypeStateDeleted(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleGoodIdentificationTypeStateCreated extends AbstractGoodIdentificationTypeStateCreated
    {
        public SimpleGoodIdentificationTypeStateCreated() {
        }

        public SimpleGoodIdentificationTypeStateCreated(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleGoodIdentificationTypeStateMergePatched extends AbstractGoodIdentificationTypeStateMergePatched
    {
        public SimpleGoodIdentificationTypeStateMergePatched() {
        }

        public SimpleGoodIdentificationTypeStateMergePatched(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleGoodIdentificationTypeStateDeleted extends AbstractGoodIdentificationTypeStateDeleted
    {
        public SimpleGoodIdentificationTypeStateDeleted() {
        }

        public SimpleGoodIdentificationTypeStateDeleted(GoodIdentificationTypeEventId eventId) {
            super(eventId);
        }
    }

}

