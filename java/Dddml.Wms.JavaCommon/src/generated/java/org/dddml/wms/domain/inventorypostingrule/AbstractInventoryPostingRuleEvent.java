package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInventoryPostingRuleEvent extends AbstractEvent implements InventoryPostingRuleEvent 
{
    private InventoryPostingRuleEventId inventoryPostingRuleEventId;

    public InventoryPostingRuleEventId getInventoryPostingRuleEventId() {
        return this.inventoryPostingRuleEventId;
    }

    public void setInventoryPostingRuleEventId(InventoryPostingRuleEventId eventId) {
        this.inventoryPostingRuleEventId = eventId;
    }
    
    public String getInventoryPostingRuleId() {
        return getInventoryPostingRuleEventId().getInventoryPostingRuleId();
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId) {
        getInventoryPostingRuleEventId().setInventoryPostingRuleId(inventoryPostingRuleId);
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

    protected AbstractInventoryPostingRuleEvent() {
    }

    protected AbstractInventoryPostingRuleEvent(InventoryPostingRuleEventId eventId) {
        this.inventoryPostingRuleEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractInventoryPostingRuleStateEvent extends AbstractInventoryPostingRuleEvent implements InventoryPostingRuleEvent.InventoryPostingRuleStateEvent {
        private InventoryItemId triggerInventoryItemId;

        public InventoryItemId getTriggerInventoryItemId()
        {
            return this.triggerInventoryItemId;
        }

        public void setTriggerInventoryItemId(InventoryItemId triggerInventoryItemId)
        {
            this.triggerInventoryItemId = triggerInventoryItemId;
        }

        private InventoryItemId outputInventoryItemId;

        public InventoryItemId getOutputInventoryItemId()
        {
            return this.outputInventoryItemId;
        }

        public void setOutputInventoryItemId(InventoryItemId outputInventoryItemId)
        {
            this.outputInventoryItemId = outputInventoryItemId;
        }

        private String triggerAccountName;

        public String getTriggerAccountName()
        {
            return this.triggerAccountName;
        }

        public void setTriggerAccountName(String triggerAccountName)
        {
            this.triggerAccountName = triggerAccountName;
        }

        private String outputAccountName;

        public String getOutputAccountName()
        {
            return this.outputAccountName;
        }

        public void setOutputAccountName(String outputAccountName)
        {
            this.outputAccountName = outputAccountName;
        }

        private Boolean isOutputNegated;

        public Boolean getIsOutputNegated()
        {
            return this.isOutputNegated;
        }

        public void setIsOutputNegated(Boolean isOutputNegated)
        {
            this.isOutputNegated = isOutputNegated;
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

        protected AbstractInventoryPostingRuleStateEvent(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractInventoryPostingRuleStateCreated extends AbstractInventoryPostingRuleStateEvent implements InventoryPostingRuleEvent.InventoryPostingRuleStateCreated
    {
        public AbstractInventoryPostingRuleStateCreated() {
            this(new InventoryPostingRuleEventId());
        }

        public AbstractInventoryPostingRuleStateCreated(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractInventoryPostingRuleStateMergePatched extends AbstractInventoryPostingRuleStateEvent implements InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched
    {
        public AbstractInventoryPostingRuleStateMergePatched() {
            this(new InventoryPostingRuleEventId());
        }

        public AbstractInventoryPostingRuleStateMergePatched(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyTriggerInventoryItemIdRemoved;

        public Boolean getIsPropertyTriggerInventoryItemIdRemoved() {
            return this.isPropertyTriggerInventoryItemIdRemoved;
        }

        public void setIsPropertyTriggerInventoryItemIdRemoved(Boolean removed) {
            this.isPropertyTriggerInventoryItemIdRemoved = removed;
        }

        private Boolean isPropertyOutputInventoryItemIdRemoved;

        public Boolean getIsPropertyOutputInventoryItemIdRemoved() {
            return this.isPropertyOutputInventoryItemIdRemoved;
        }

        public void setIsPropertyOutputInventoryItemIdRemoved(Boolean removed) {
            this.isPropertyOutputInventoryItemIdRemoved = removed;
        }

        private Boolean isPropertyTriggerAccountNameRemoved;

        public Boolean getIsPropertyTriggerAccountNameRemoved() {
            return this.isPropertyTriggerAccountNameRemoved;
        }

        public void setIsPropertyTriggerAccountNameRemoved(Boolean removed) {
            this.isPropertyTriggerAccountNameRemoved = removed;
        }

        private Boolean isPropertyOutputAccountNameRemoved;

        public Boolean getIsPropertyOutputAccountNameRemoved() {
            return this.isPropertyOutputAccountNameRemoved;
        }

        public void setIsPropertyOutputAccountNameRemoved(Boolean removed) {
            this.isPropertyOutputAccountNameRemoved = removed;
        }

        private Boolean isPropertyIsOutputNegatedRemoved;

        public Boolean getIsPropertyIsOutputNegatedRemoved() {
            return this.isPropertyIsOutputNegatedRemoved;
        }

        public void setIsPropertyIsOutputNegatedRemoved(Boolean removed) {
            this.isPropertyIsOutputNegatedRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractInventoryPostingRuleStateDeleted extends AbstractInventoryPostingRuleStateEvent implements InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted
    {
        public AbstractInventoryPostingRuleStateDeleted() {
            this(new InventoryPostingRuleEventId());
        }

        public AbstractInventoryPostingRuleStateDeleted(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleInventoryPostingRuleStateCreated extends AbstractInventoryPostingRuleStateCreated
    {
        public SimpleInventoryPostingRuleStateCreated() {
        }

        public SimpleInventoryPostingRuleStateCreated(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInventoryPostingRuleStateMergePatched extends AbstractInventoryPostingRuleStateMergePatched
    {
        public SimpleInventoryPostingRuleStateMergePatched() {
        }

        public SimpleInventoryPostingRuleStateMergePatched(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInventoryPostingRuleStateDeleted extends AbstractInventoryPostingRuleStateDeleted
    {
        public SimpleInventoryPostingRuleStateDeleted() {
        }

        public SimpleInventoryPostingRuleStateDeleted(InventoryPostingRuleEventId eventId) {
            super(eventId);
        }
    }

}

