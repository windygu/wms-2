package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractAttributeSetInstanceExtensionFieldEvent extends AbstractEvent implements AttributeSetInstanceExtensionFieldEvent 
{
    private AttributeSetInstanceExtensionFieldEventId attributeSetInstanceExtensionFieldEventId;

    public AttributeSetInstanceExtensionFieldEventId getAttributeSetInstanceExtensionFieldEventId() {
        return this.attributeSetInstanceExtensionFieldEventId;
    }

    public void setAttributeSetInstanceExtensionFieldEventId(AttributeSetInstanceExtensionFieldEventId eventId) {
        this.attributeSetInstanceExtensionFieldEventId = eventId;
    }
    
    public String getName() {
        return getAttributeSetInstanceExtensionFieldEventId().getName();
    }

    public void setName(String name) {
        getAttributeSetInstanceExtensionFieldEventId().setName(name);
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

    protected AbstractAttributeSetInstanceExtensionFieldEvent() {
    }

    protected AbstractAttributeSetInstanceExtensionFieldEvent(AttributeSetInstanceExtensionFieldEventId eventId) {
        this.attributeSetInstanceExtensionFieldEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateEvent extends AbstractAttributeSetInstanceExtensionFieldEvent implements AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateEvent {
        private String type;

        public String getType()
        {
            return this.type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        private Integer length;

        public Integer getLength()
        {
            return this.length;
        }

        public void setLength(Integer length)
        {
            this.length = length;
        }

        private String alias;

        public String getAlias()
        {
            return this.alias;
        }

        public void setAlias(String alias)
        {
            this.alias = alias;
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

        private String groupId;

        public String getGroupId()
        {
            return this.groupId;
        }

        public void setGroupId(String groupId)
        {
            this.groupId = groupId;
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

        protected AbstractAttributeSetInstanceExtensionFieldStateEvent(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateCreated extends AbstractAttributeSetInstanceExtensionFieldStateEvent implements AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated
    {
        public AbstractAttributeSetInstanceExtensionFieldStateCreated() {
            this(new AttributeSetInstanceExtensionFieldEventId());
        }

        public AbstractAttributeSetInstanceExtensionFieldStateCreated(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateMergePatched extends AbstractAttributeSetInstanceExtensionFieldStateEvent implements AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched
    {
        public AbstractAttributeSetInstanceExtensionFieldStateMergePatched() {
            this(new AttributeSetInstanceExtensionFieldEventId());
        }

        public AbstractAttributeSetInstanceExtensionFieldStateMergePatched(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyTypeRemoved;

        public Boolean getIsPropertyTypeRemoved() {
            return this.isPropertyTypeRemoved;
        }

        public void setIsPropertyTypeRemoved(Boolean removed) {
            this.isPropertyTypeRemoved = removed;
        }

        private Boolean isPropertyLengthRemoved;

        public Boolean getIsPropertyLengthRemoved() {
            return this.isPropertyLengthRemoved;
        }

        public void setIsPropertyLengthRemoved(Boolean removed) {
            this.isPropertyLengthRemoved = removed;
        }

        private Boolean isPropertyAliasRemoved;

        public Boolean getIsPropertyAliasRemoved() {
            return this.isPropertyAliasRemoved;
        }

        public void setIsPropertyAliasRemoved(Boolean removed) {
            this.isPropertyAliasRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyGroupIdRemoved;

        public Boolean getIsPropertyGroupIdRemoved() {
            return this.isPropertyGroupIdRemoved;
        }

        public void setIsPropertyGroupIdRemoved(Boolean removed) {
            this.isPropertyGroupIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateDeleted extends AbstractAttributeSetInstanceExtensionFieldStateEvent implements AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted
    {
        public AbstractAttributeSetInstanceExtensionFieldStateDeleted() {
            this(new AttributeSetInstanceExtensionFieldEventId());
        }

        public AbstractAttributeSetInstanceExtensionFieldStateDeleted(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleAttributeSetInstanceExtensionFieldStateCreated extends AbstractAttributeSetInstanceExtensionFieldStateCreated
    {
        public SimpleAttributeSetInstanceExtensionFieldStateCreated() {
        }

        public SimpleAttributeSetInstanceExtensionFieldStateCreated(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeSetInstanceExtensionFieldStateMergePatched extends AbstractAttributeSetInstanceExtensionFieldStateMergePatched
    {
        public SimpleAttributeSetInstanceExtensionFieldStateMergePatched() {
        }

        public SimpleAttributeSetInstanceExtensionFieldStateMergePatched(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeSetInstanceExtensionFieldStateDeleted extends AbstractAttributeSetInstanceExtensionFieldStateDeleted
    {
        public SimpleAttributeSetInstanceExtensionFieldStateDeleted() {
        }

        public SimpleAttributeSetInstanceExtensionFieldStateDeleted(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }
    }

}

