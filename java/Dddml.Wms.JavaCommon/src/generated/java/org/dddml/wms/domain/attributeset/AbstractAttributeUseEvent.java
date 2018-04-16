package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractAttributeUseEvent extends AbstractEvent implements AttributeUseEvent 
{
    private AttributeUseEventId attributeUseEventId;

    public AttributeUseEventId getAttributeUseEventId() {
        return this.attributeUseEventId;
    }

    public void setAttributeUseEventId(AttributeUseEventId eventId) {
        this.attributeUseEventId = eventId;
    }
    
    public String getAttributeId() {
        return getAttributeUseEventId().getAttributeId();
    }

    public void setAttributeId(String attributeId) {
        getAttributeUseEventId().setAttributeId(attributeId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractAttributeUseEvent() {
    }

    protected AbstractAttributeUseEvent(AttributeUseEventId eventId) {
        this.attributeUseEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractAttributeUseStateEvent extends AbstractAttributeUseEvent implements AttributeUseEvent.AttributeUseStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private Integer sequenceNumber;

        public Integer getSequenceNumber()
        {
            return this.sequenceNumber;
        }

        public void setSequenceNumber(Integer sequenceNumber)
        {
            this.sequenceNumber = sequenceNumber;
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

        protected AbstractAttributeUseStateEvent(AttributeUseEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractAttributeUseStateCreated extends AbstractAttributeUseStateEvent implements AttributeUseEvent.AttributeUseStateCreated
    {
        public AbstractAttributeUseStateCreated() {
            this(new AttributeUseEventId());
        }

        public AbstractAttributeUseStateCreated(AttributeUseEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractAttributeUseStateMergePatched extends AbstractAttributeUseStateEvent implements AttributeUseEvent.AttributeUseStateMergePatched
    {
        public AbstractAttributeUseStateMergePatched() {
            this(new AttributeUseEventId());
        }

        public AbstractAttributeUseStateMergePatched(AttributeUseEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertySequenceNumberRemoved;

        public Boolean getIsPropertySequenceNumberRemoved() {
            return this.isPropertySequenceNumberRemoved;
        }

        public void setIsPropertySequenceNumberRemoved(Boolean removed) {
            this.isPropertySequenceNumberRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractAttributeUseStateRemoved extends AbstractAttributeUseStateEvent implements AttributeUseEvent.AttributeUseStateRemoved
    {
        public AbstractAttributeUseStateRemoved() {
            this(new AttributeUseEventId());
        }

        public AbstractAttributeUseStateRemoved(AttributeUseEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleAttributeUseStateCreated extends AbstractAttributeUseStateCreated
    {
        public SimpleAttributeUseStateCreated() {
        }

        public SimpleAttributeUseStateCreated(AttributeUseEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeUseStateMergePatched extends AbstractAttributeUseStateMergePatched
    {
        public SimpleAttributeUseStateMergePatched() {
        }

        public SimpleAttributeUseStateMergePatched(AttributeUseEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeUseStateRemoved extends AbstractAttributeUseStateRemoved
    {
        public SimpleAttributeUseStateRemoved() {
        }

        public SimpleAttributeUseStateRemoved(AttributeUseEventId eventId) {
            super(eventId);
        }
    }

}

