package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractAttributeUseStateEvent extends AbstractStateEvent implements AttributeUseStateEvent 
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

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractAttributeUseStateEvent() {
    }

    protected AbstractAttributeUseStateEvent(AttributeUseEventId eventId) {
        this.attributeUseEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeUseStateCreated extends AbstractAttributeUseStateEvent implements AttributeUseStateEvent.AttributeUseStateCreated
    {
        public AbstractAttributeUseStateCreated() {
            this(new AttributeUseEventId());
        }

        public AbstractAttributeUseStateCreated(AttributeUseEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractAttributeUseStateMergePatched extends AbstractAttributeUseStateEvent implements AttributeUseStateEvent.AttributeUseStateMergePatched
    {
        public AbstractAttributeUseStateMergePatched() {
            this(new AttributeUseEventId());
        }

        public AbstractAttributeUseStateMergePatched(AttributeUseEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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


    public static abstract class AbstractAttributeUseStateRemoved extends AbstractAttributeUseStateEvent implements AttributeUseStateEvent.AttributeUseStateRemoved
    {
        public AbstractAttributeUseStateRemoved() {
            this(new AttributeUseEventId());
        }

        public AbstractAttributeUseStateRemoved(AttributeUseEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

