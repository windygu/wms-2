package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryPostingRuleAggregate extends AbstractAggregate implements InventoryPostingRuleAggregate
{
    private InventoryPostingRuleState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryPostingRuleAggregate(InventoryPostingRuleState state)
    {
        this.state = state;
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
        InventoryPostingRuleStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c)
    {
        InventoryPostingRuleStateEvent e = map(c);
        apply(e);
    }

    public void delete(InventoryPostingRuleCommand.DeleteInventoryPostingRule c)
    {
        InventoryPostingRuleStateEvent e = map(c);
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

    protected InventoryPostingRuleStateEvent map(InventoryPostingRuleCommand.CreateInventoryPostingRule c) {
        InventoryPostingRuleStateEventId stateEventId = new InventoryPostingRuleStateEventId(c.getInventoryPostingRuleId(), c.getVersion());
        InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated e = newInventoryPostingRuleStateCreated(stateEventId);
        e.setTriggerInventoryItemId(c.getTriggerInventoryItemId());
        e.setOutputInventoryItemId(c.getOutputInventoryItemId());
        e.setTriggerAccountName(c.getTriggerAccountName());
        e.setOutputAccountName(c.getOutputAccountName());
        e.setIsOutputNegated(c.getIsOutputNegated());
        e.setActive(c.getActive());
        ((AbstractInventoryPostingRuleStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleStateEvent map(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c) {
        InventoryPostingRuleStateEventId stateEventId = new InventoryPostingRuleStateEventId(c.getInventoryPostingRuleId(), c.getVersion());
        InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched e = newInventoryPostingRuleStateMergePatched(stateEventId);
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
        ((AbstractInventoryPostingRuleStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleStateEvent map(InventoryPostingRuleCommand.DeleteInventoryPostingRule c) {
        InventoryPostingRuleStateEventId stateEventId = new InventoryPostingRuleStateEventId(c.getInventoryPostingRuleId(), c.getVersion());
        InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted e = newInventoryPostingRuleStateDeleted(stateEventId);
        ((AbstractInventoryPostingRuleStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated newInventoryPostingRuleStateCreated(Long version, String commandId, String requesterId) {
        InventoryPostingRuleStateEventId stateEventId = new InventoryPostingRuleStateEventId(this.state.getInventoryPostingRuleId(), version);
        InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated e = newInventoryPostingRuleStateCreated(stateEventId);
        ((AbstractInventoryPostingRuleStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched newInventoryPostingRuleStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryPostingRuleStateEventId stateEventId = new InventoryPostingRuleStateEventId(this.state.getInventoryPostingRuleId(), version);
        InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched e = newInventoryPostingRuleStateMergePatched(stateEventId);
        ((AbstractInventoryPostingRuleStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted newInventoryPostingRuleStateDeleted(Long version, String commandId, String requesterId) {
        InventoryPostingRuleStateEventId stateEventId = new InventoryPostingRuleStateEventId(this.state.getInventoryPostingRuleId(), version);
        InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted e = newInventoryPostingRuleStateDeleted(stateEventId);
        ((AbstractInventoryPostingRuleStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated newInventoryPostingRuleStateCreated(InventoryPostingRuleStateEventId stateEventId) {
        return new AbstractInventoryPostingRuleStateEvent.SimpleInventoryPostingRuleStateCreated(stateEventId);
    }

    protected InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched newInventoryPostingRuleStateMergePatched(InventoryPostingRuleStateEventId stateEventId) {
        return new AbstractInventoryPostingRuleStateEvent.SimpleInventoryPostingRuleStateMergePatched(stateEventId);
    }

    protected InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted newInventoryPostingRuleStateDeleted(InventoryPostingRuleStateEventId stateEventId)
    {
        return new AbstractInventoryPostingRuleStateEvent.SimpleInventoryPostingRuleStateDeleted(stateEventId);
    }

    public static class SimpleInventoryPostingRuleAggregate extends AbstractInventoryPostingRuleAggregate
    {
        public SimpleInventoryPostingRuleAggregate(InventoryPostingRuleState state) {
            super(state);
        }

    }

}

