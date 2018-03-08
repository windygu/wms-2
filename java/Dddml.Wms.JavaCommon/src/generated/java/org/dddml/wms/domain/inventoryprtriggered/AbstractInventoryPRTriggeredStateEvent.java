package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryPRTriggeredStateEvent extends AbstractStateEvent implements InventoryPRTriggeredStateEvent 
{
    private InventoryPRTriggeredEventId stateEventId;

    public InventoryPRTriggeredEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(InventoryPRTriggeredEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public InventoryPRTriggeredId getInventoryPRTriggeredId() {
        return getStateEventId().getInventoryPRTriggeredId();
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId) {
        getStateEventId().setInventoryPRTriggeredId(inventoryPRTriggeredId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private Boolean isProcessed;

    public Boolean getIsProcessed()
    {
        return this.isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed)
    {
        this.isProcessed = isProcessed;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractInventoryPRTriggeredStateEvent() {
    }

    protected AbstractInventoryPRTriggeredStateEvent(InventoryPRTriggeredEventId eventId) {
        this.stateEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryPRTriggeredStateCreated extends AbstractInventoryPRTriggeredStateEvent implements InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated
    {
        public AbstractInventoryPRTriggeredStateCreated() {
            this(new InventoryPRTriggeredEventId());
        }

        public AbstractInventoryPRTriggeredStateCreated(InventoryPRTriggeredEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractInventoryPRTriggeredStateMergePatched extends AbstractInventoryPRTriggeredStateEvent implements InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched
    {
        public AbstractInventoryPRTriggeredStateMergePatched() {
            this(new InventoryPRTriggeredEventId());
        }

        public AbstractInventoryPRTriggeredStateMergePatched(InventoryPRTriggeredEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyIsProcessedRemoved;

        public Boolean getIsPropertyIsProcessedRemoved() {
            return this.isPropertyIsProcessedRemoved;
        }

        public void setIsPropertyIsProcessedRemoved(Boolean removed) {
            this.isPropertyIsProcessedRemoved = removed;
        }

    }


    public static class SimpleInventoryPRTriggeredStateCreated extends AbstractInventoryPRTriggeredStateCreated
    {
        public SimpleInventoryPRTriggeredStateCreated() {
        }

        public SimpleInventoryPRTriggeredStateCreated(InventoryPRTriggeredEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInventoryPRTriggeredStateMergePatched extends AbstractInventoryPRTriggeredStateMergePatched
    {
        public SimpleInventoryPRTriggeredStateMergePatched() {
        }

        public SimpleInventoryPRTriggeredStateMergePatched(InventoryPRTriggeredEventId eventId) {
            super(eventId);
        }
    }

}

