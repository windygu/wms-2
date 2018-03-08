package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryPRTriggeredAggregate extends AbstractAggregate implements InventoryPRTriggeredAggregate
{
    private InventoryPRTriggeredState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryPRTriggeredAggregate(InventoryPRTriggeredState state)
    {
        this.state = state;
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
        InventoryPRTriggeredStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c)
    {
        InventoryPRTriggeredStateEvent e = map(c);
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

    protected InventoryPRTriggeredStateEvent map(InventoryPRTriggeredCommand.CreateInventoryPRTriggered c) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(c.getInventoryPRTriggeredId(), c.getVersion());
        InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated e = newInventoryPRTriggeredStateCreated(stateEventId);
        e.setIsProcessed(c.getIsProcessed());
        ((AbstractInventoryPRTriggeredStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPRTriggeredStateEvent map(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(c.getInventoryPRTriggeredId(), c.getVersion());
        InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched e = newInventoryPRTriggeredStateMergePatched(stateEventId);
        e.setIsProcessed(c.getIsProcessed());
        e.setIsPropertyIsProcessedRemoved(c.getIsPropertyIsProcessedRemoved());
        ((AbstractInventoryPRTriggeredStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated newInventoryPRTriggeredStateCreated(Long version, String commandId, String requesterId) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(this.state.getInventoryPRTriggeredId(), version);
        InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated e = newInventoryPRTriggeredStateCreated(stateEventId);
        ((AbstractInventoryPRTriggeredStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched newInventoryPRTriggeredStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryPRTriggeredEventId stateEventId = new InventoryPRTriggeredEventId(this.state.getInventoryPRTriggeredId(), version);
        InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched e = newInventoryPRTriggeredStateMergePatched(stateEventId);
        ((AbstractInventoryPRTriggeredStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated newInventoryPRTriggeredStateCreated(InventoryPRTriggeredEventId stateEventId) {
        return new AbstractInventoryPRTriggeredStateEvent.SimpleInventoryPRTriggeredStateCreated(stateEventId);
    }

    protected InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched newInventoryPRTriggeredStateMergePatched(InventoryPRTriggeredEventId stateEventId) {
        return new AbstractInventoryPRTriggeredStateEvent.SimpleInventoryPRTriggeredStateMergePatched(stateEventId);
    }

    public static class SimpleInventoryPRTriggeredAggregate extends AbstractInventoryPRTriggeredAggregate
    {
        public SimpleInventoryPRTriggeredAggregate(InventoryPRTriggeredState state) {
            super(state);
        }

    }

}

