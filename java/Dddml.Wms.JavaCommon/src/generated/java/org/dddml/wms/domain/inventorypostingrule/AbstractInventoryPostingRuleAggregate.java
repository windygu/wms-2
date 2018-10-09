package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryPostingRuleAggregate extends AbstractAggregate implements InventoryPostingRuleAggregate
{
    private InventoryPostingRuleState.MutableInventoryPostingRuleState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryPostingRuleAggregate(InventoryPostingRuleState state)
    {
        this.state = (InventoryPostingRuleState.MutableInventoryPostingRuleState)state;
    }

    public InventoryPostingRuleState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryPostingRuleCommand.CreateInventoryPostingRule c)
    {
        if (c.getVersion() == null) { c.setVersion(InventoryPostingRuleState.VERSION_NULL); }
        InventoryPostingRuleEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c)
    {
        InventoryPostingRuleEvent e = map(c);
        apply(e);
    }

    public void delete(InventoryPostingRuleCommand.DeleteInventoryPostingRule c)
    {
        InventoryPostingRuleEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InventoryPostingRuleCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryPostingRuleEvent map(InventoryPostingRuleCommand.CreateInventoryPostingRule c) {
        InventoryPostingRuleEventId stateEventId = new InventoryPostingRuleEventId(c.getInventoryPostingRuleId(), c.getVersion());
        InventoryPostingRuleEvent.InventoryPostingRuleStateCreated e = newInventoryPostingRuleStateCreated(stateEventId);
        e.setTriggerInventoryItemId(c.getTriggerInventoryItemId());
        e.setOutputInventoryItemId(c.getOutputInventoryItemId());
        e.setTriggerAccountName(c.getTriggerAccountName());
        e.setOutputAccountName(c.getOutputAccountName());
        e.setIsOutputNegated(c.getIsOutputNegated());
        e.setActive(c.getActive());
        ((AbstractInventoryPostingRuleEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleEvent map(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c) {
        InventoryPostingRuleEventId stateEventId = new InventoryPostingRuleEventId(c.getInventoryPostingRuleId(), c.getVersion());
        InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched e = newInventoryPostingRuleStateMergePatched(stateEventId);
        e.setTriggerInventoryItemId(c.getTriggerInventoryItemId());
        e.setOutputInventoryItemId(c.getOutputInventoryItemId());
        e.setTriggerAccountName(c.getTriggerAccountName());
        e.setOutputAccountName(c.getOutputAccountName());
        e.setIsOutputNegated(c.getIsOutputNegated());
        e.setActive(c.getActive());
        e.setIsPropertyTriggerInventoryItemIdRemoved(c.getIsPropertyTriggerInventoryItemIdRemoved());
        e.setIsPropertyOutputInventoryItemIdRemoved(c.getIsPropertyOutputInventoryItemIdRemoved());
        e.setIsPropertyTriggerAccountNameRemoved(c.getIsPropertyTriggerAccountNameRemoved());
        e.setIsPropertyOutputAccountNameRemoved(c.getIsPropertyOutputAccountNameRemoved());
        e.setIsPropertyIsOutputNegatedRemoved(c.getIsPropertyIsOutputNegatedRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractInventoryPostingRuleEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleEvent map(InventoryPostingRuleCommand.DeleteInventoryPostingRule c) {
        InventoryPostingRuleEventId stateEventId = new InventoryPostingRuleEventId(c.getInventoryPostingRuleId(), c.getVersion());
        InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted e = newInventoryPostingRuleStateDeleted(stateEventId);
        ((AbstractInventoryPostingRuleEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryPostingRuleEvent.InventoryPostingRuleStateCreated newInventoryPostingRuleStateCreated(Long version, String commandId, String requesterId) {
        InventoryPostingRuleEventId stateEventId = new InventoryPostingRuleEventId(this.state.getInventoryPostingRuleId(), version);
        InventoryPostingRuleEvent.InventoryPostingRuleStateCreated e = newInventoryPostingRuleStateCreated(stateEventId);
        ((AbstractInventoryPostingRuleEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched newInventoryPostingRuleStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryPostingRuleEventId stateEventId = new InventoryPostingRuleEventId(this.state.getInventoryPostingRuleId(), version);
        InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched e = newInventoryPostingRuleStateMergePatched(stateEventId);
        ((AbstractInventoryPostingRuleEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted newInventoryPostingRuleStateDeleted(Long version, String commandId, String requesterId) {
        InventoryPostingRuleEventId stateEventId = new InventoryPostingRuleEventId(this.state.getInventoryPostingRuleId(), version);
        InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted e = newInventoryPostingRuleStateDeleted(stateEventId);
        ((AbstractInventoryPostingRuleEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleEvent.InventoryPostingRuleStateCreated newInventoryPostingRuleStateCreated(InventoryPostingRuleEventId stateEventId) {
        return new AbstractInventoryPostingRuleEvent.SimpleInventoryPostingRuleStateCreated(stateEventId);
    }

    protected InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched newInventoryPostingRuleStateMergePatched(InventoryPostingRuleEventId stateEventId) {
        return new AbstractInventoryPostingRuleEvent.SimpleInventoryPostingRuleStateMergePatched(stateEventId);
    }

    protected InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted newInventoryPostingRuleStateDeleted(InventoryPostingRuleEventId stateEventId)
    {
        return new AbstractInventoryPostingRuleEvent.SimpleInventoryPostingRuleStateDeleted(stateEventId);
    }

    public static class SimpleInventoryPostingRuleAggregate extends AbstractInventoryPostingRuleAggregate
    {
        public SimpleInventoryPostingRuleAggregate(InventoryPostingRuleState state) {
            super(state);
        }

    }

}

