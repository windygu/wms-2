package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractAttributeValueEvent extends AbstractEvent implements AttributeValueEvent 
{
    private AttributeValueEventId attributeValueEventId;

    public AttributeValueEventId getAttributeValueEventId() {
        return this.attributeValueEventId;
    }

    public void setAttributeValueEventId(AttributeValueEventId eventId) {
        this.attributeValueEventId = eventId;
    }
    
    public String getValue() {
        return getAttributeValueEventId().getValue();
    }

    public void setValue(String value) {
        getAttributeValueEventId().setValue(value);
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

    protected AbstractAttributeValueEvent() {
    }

    protected AbstractAttributeValueEvent(AttributeValueEventId eventId) {
        this.attributeValueEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractAttributeValueStateEvent extends AbstractAttributeValueEvent implements AttributeValueEvent.AttributeValueStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String attributeValueName;

        public String getAttributeValueName()
        {
            return this.attributeValueName;
        }

        public void setAttributeValueName(String attributeValueName)
        {
            this.attributeValueName = attributeValueName;
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

        private String referenceId;

        public String getReferenceId()
        {
            return this.referenceId;
        }

        public void setReferenceId(String referenceId)
        {
            this.referenceId = referenceId;
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

        protected AbstractAttributeValueStateEvent(AttributeValueEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractAttributeValueStateCreated extends AbstractAttributeValueStateEvent implements AttributeValueEvent.AttributeValueStateCreated
    {
        public AbstractAttributeValueStateCreated() {
            this(new AttributeValueEventId());
        }

        public AbstractAttributeValueStateCreated(AttributeValueEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractAttributeValueStateMergePatched extends AbstractAttributeValueStateEvent implements AttributeValueEvent.AttributeValueStateMergePatched
    {
        public AbstractAttributeValueStateMergePatched() {
            this(new AttributeValueEventId());
        }

        public AbstractAttributeValueStateMergePatched(AttributeValueEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyAttributeValueNameRemoved;

        public Boolean getIsPropertyAttributeValueNameRemoved() {
            return this.isPropertyAttributeValueNameRemoved;
        }

        public void setIsPropertyAttributeValueNameRemoved(Boolean removed) {
            this.isPropertyAttributeValueNameRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyReferenceIdRemoved;

        public Boolean getIsPropertyReferenceIdRemoved() {
            return this.isPropertyReferenceIdRemoved;
        }

        public void setIsPropertyReferenceIdRemoved(Boolean removed) {
            this.isPropertyReferenceIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractAttributeValueStateRemoved extends AbstractAttributeValueStateEvent implements AttributeValueEvent.AttributeValueStateRemoved
    {
        public AbstractAttributeValueStateRemoved() {
            this(new AttributeValueEventId());
        }

        public AbstractAttributeValueStateRemoved(AttributeValueEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleAttributeValueStateCreated extends AbstractAttributeValueStateCreated
    {
        public SimpleAttributeValueStateCreated() {
        }

        public SimpleAttributeValueStateCreated(AttributeValueEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeValueStateMergePatched extends AbstractAttributeValueStateMergePatched
    {
        public SimpleAttributeValueStateMergePatched() {
        }

        public SimpleAttributeValueStateMergePatched(AttributeValueEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeValueStateRemoved extends AbstractAttributeValueStateRemoved
    {
        public SimpleAttributeValueStateRemoved() {
        }

        public SimpleAttributeValueStateRemoved(AttributeValueEventId eventId) {
            super(eventId);
        }
    }

}

