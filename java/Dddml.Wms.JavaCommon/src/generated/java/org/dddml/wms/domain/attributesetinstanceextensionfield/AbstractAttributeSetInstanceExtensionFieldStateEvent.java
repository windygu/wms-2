package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractAttributeSetInstanceExtensionFieldStateEvent extends AbstractStateEvent implements AttributeSetInstanceExtensionFieldStateEvent 
{
    private AttributeSetInstanceExtensionFieldEventId stateEventId;

    public AttributeSetInstanceExtensionFieldEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(AttributeSetInstanceExtensionFieldEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public String getName() {
        return getStateEventId().getName();
    }

    public void setName(String name) {
        getStateEventId().setName(name);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractAttributeSetInstanceExtensionFieldStateEvent() {
    }

    protected AbstractAttributeSetInstanceExtensionFieldStateEvent(AttributeSetInstanceExtensionFieldEventId eventId) {
        this.stateEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateCreated extends AbstractAttributeSetInstanceExtensionFieldStateEvent implements AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated
    {
        public AbstractAttributeSetInstanceExtensionFieldStateCreated() {
            this(new AttributeSetInstanceExtensionFieldEventId());
        }

        public AbstractAttributeSetInstanceExtensionFieldStateCreated(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateMergePatched extends AbstractAttributeSetInstanceExtensionFieldStateEvent implements AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched
    {
        public AbstractAttributeSetInstanceExtensionFieldStateMergePatched() {
            this(new AttributeSetInstanceExtensionFieldEventId());
        }

        public AbstractAttributeSetInstanceExtensionFieldStateMergePatched(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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


    public static abstract class AbstractAttributeSetInstanceExtensionFieldStateDeleted extends AbstractAttributeSetInstanceExtensionFieldStateEvent implements AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted
    {
        public AbstractAttributeSetInstanceExtensionFieldStateDeleted() {
            this(new AttributeSetInstanceExtensionFieldEventId());
        }

        public AbstractAttributeSetInstanceExtensionFieldStateDeleted(AttributeSetInstanceExtensionFieldEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

