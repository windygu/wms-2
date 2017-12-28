package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractAttributeAliasStateEvent extends AbstractStateEvent implements AttributeAliasStateEvent 
{
    private AttributeAliasStateEventId stateEventId;

    public AttributeAliasStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(AttributeAliasStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getCode() {
        return getStateEventId().getCode();
    }

    public void setCode(String code) {
        getStateEventId().setCode(code);
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

    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    protected AbstractAttributeAliasStateEvent() {
    }

    protected AbstractAttributeAliasStateEvent(AttributeAliasStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeAliasStateCreated extends AbstractAttributeAliasStateEvent implements AttributeAliasStateEvent.AttributeAliasStateCreated
    {
        public AbstractAttributeAliasStateCreated() {
            this(new AttributeAliasStateEventId());
        }

        public AbstractAttributeAliasStateCreated(AttributeAliasStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractAttributeAliasStateMergePatched extends AbstractAttributeAliasStateEvent implements AttributeAliasStateEvent.AttributeAliasStateMergePatched
    {
        public AbstractAttributeAliasStateMergePatched() {
            this(new AttributeAliasStateEventId());
        }

        public AbstractAttributeAliasStateMergePatched(AttributeAliasStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyNameRemoved;

        public Boolean getIsPropertyNameRemoved() {
            return this.isPropertyNameRemoved;
        }

        public void setIsPropertyNameRemoved(Boolean removed) {
            this.isPropertyNameRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractAttributeAliasStateRemoved extends AbstractAttributeAliasStateEvent implements AttributeAliasStateEvent.AttributeAliasStateRemoved
    {
        public AbstractAttributeAliasStateRemoved() {
            this(new AttributeAliasStateEventId());
        }

        public AbstractAttributeAliasStateRemoved(AttributeAliasStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleAttributeAliasStateCreated extends AbstractAttributeAliasStateCreated
    {
        public SimpleAttributeAliasStateCreated() {
        }

        public SimpleAttributeAliasStateCreated(AttributeAliasStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleAttributeAliasStateMergePatched extends AbstractAttributeAliasStateMergePatched
    {
        public SimpleAttributeAliasStateMergePatched() {
        }

        public SimpleAttributeAliasStateMergePatched(AttributeAliasStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleAttributeAliasStateRemoved extends AbstractAttributeAliasStateRemoved
    {
        public SimpleAttributeAliasStateRemoved() {
        }

        public SimpleAttributeAliasStateRemoved(AttributeAliasStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

