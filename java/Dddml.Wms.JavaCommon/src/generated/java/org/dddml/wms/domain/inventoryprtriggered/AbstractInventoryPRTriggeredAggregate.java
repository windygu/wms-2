package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryPRTriggeredAggregate extends AbstractAggregate implements InventoryPRTriggeredAggregate
{
    private InventoryPRTriggeredState.MutableInventoryPRTriggeredState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryPRTriggeredAggregate(InventoryPRTriggeredState state)
    {
        this.state = (InventoryPRTriggeredState.MutableInventoryPRTriggeredState)state;
    }

    public InventoryPRTriggeredState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryPRTriggeredCommand.CreateInventoryPRTriggered c)
    {
        if (c.getVersion() == null) { c.setVersion(InventoryPRTriggeredState.VERSION_NULL); }
        InventoryPRTriggeredEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c)
    {
        InventoryPRTriggeredEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InventoryPRTriggeredCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryPRTriggeredEvent map(InventoryPRTriggeredCommand.CreateInventoryPRTriggered c) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(c.getInventoryPRTriggeredId(), c.getVersion());
        InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated e = newInventoryPRTriggeredStateCreated(stateEventId);
        e.setIsProcessed(c.getIsProcessed());
        ((AbstractInventoryPRTriggeredEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPRTriggeredEvent map(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(c.getInventoryPRTriggeredId(), c.getVersion());
        InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched e = newInventoryPRTriggeredStateMergePatched(stateEventId);
        e.setIsProcessed(c.getIsProcessed());
        e.setIsPropertyIsProcessedRemoved(c.getIsPropertyIsProcessedRemoved());
        ((AbstractInventoryPRTriggeredEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated newInventoryPRTriggeredStateCreated(Long version, String commandId, String requesterId) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(this.state.getInventoryPRTriggeredId(), version);
        InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated e = newInventoryPRTriggeredStateCreated(stateEventId);
        ((AbstractInventoryPRTriggeredEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched newInventoryPRTriggeredStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(this.state.getInventoryPRTriggeredId(), version);
        InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched e = newInventoryPRTriggeredStateMergePatched(stateEventId);
        ((AbstractInventoryPRTriggeredEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated newInventoryPRTriggeredStateCreated(InventoryPRTriggeredEventId stateEventId) {
        return new AbstractInventoryPRTriggeredEvent.SimpleInventoryPRTriggeredStateCreated(stateEventId);
    }

    protected InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched newInventoryPRTriggeredStateMergePatched(InventoryPRTriggeredEventId stateEventId) {
        return new AbstractInventoryPRTriggeredEvent.SimpleInventoryPRTriggeredStateMergePatched(stateEventId);
    }

    public static class SimpleInventoryPRTriggeredAggregate extends AbstractInventoryPRTriggeredAggregate
    {
        public SimpleInventoryPRTriggeredAggregate(InventoryPRTriggeredState state) {
            super(state);
        }

    }

}

