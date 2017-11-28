package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryItemEventTypeStateEvent extends AbstractStateEvent implements InventoryItemEventTypeStateEvent 
{
    private InventoryItemEventTypeStateEventId stateEventId;

    public InventoryItemEventTypeStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(InventoryItemEventTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getInventoryItemEventTypeId() {
        return getStateEventId().getInventoryItemEventTypeId();
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId) {
        getStateEventId().setInventoryItemEventTypeId(inventoryItemEventTypeId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    protected AbstractInventoryItemEventTypeStateEvent() {
    }

    protected AbstractInventoryItemEventTypeStateEvent(InventoryItemEventTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryItemEventTypeStateCreated extends AbstractInventoryItemEventTypeStateEvent implements InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated
    {
        public AbstractInventoryItemEventTypeStateCreated() {
            this(new InventoryItemEventTypeStateEventId());
        }

        public AbstractInventoryItemEventTypeStateCreated(InventoryItemEventTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractInventoryItemEventTypeStateMergePatched extends AbstractInventoryItemEventTypeStateEvent implements InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched
    {
        public AbstractInventoryItemEventTypeStateMergePatched() {
            this(new InventoryItemEventTypeStateEventId());
        }

        public AbstractInventoryItemEventTypeStateMergePatched(InventoryItemEventTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
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


    public static abstract class AbstractInventoryItemEventTypeStateDeleted extends AbstractInventoryItemEventTypeStateEvent implements InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted
    {
        public AbstractInventoryItemEventTypeStateDeleted() {
            this(new InventoryItemEventTypeStateEventId());
        }

        public AbstractInventoryItemEventTypeStateDeleted(InventoryItemEventTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleInventoryItemEventTypeStateCreated extends AbstractInventoryItemEventTypeStateCreated
    {
        public SimpleInventoryItemEventTypeStateCreated() {
        }

        public SimpleInventoryItemEventTypeStateCreated(InventoryItemEventTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleInventoryItemEventTypeStateMergePatched extends AbstractInventoryItemEventTypeStateMergePatched
    {
        public SimpleInventoryItemEventTypeStateMergePatched() {
        }

        public SimpleInventoryItemEventTypeStateMergePatched(InventoryItemEventTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleInventoryItemEventTypeStateDeleted extends AbstractInventoryItemEventTypeStateDeleted
    {
        public SimpleInventoryItemEventTypeStateDeleted() {
        }

        public SimpleInventoryItemEventTypeStateDeleted(InventoryItemEventTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

