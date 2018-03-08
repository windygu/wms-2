package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractWarehouseAggregate extends AbstractAggregate implements WarehouseAggregate
{
    private WarehouseState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractWarehouseAggregate(WarehouseState state)
    {
        this.state = state;
    }

    public WarehouseState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(WarehouseCommand.CreateWarehouse c)
    {
        if (c.getVersion() == null) { c.setVersion(WarehouseState.VERSION_NULL); }
        WarehouseStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(WarehouseCommand.MergePatchWarehouse c)
    {
        WarehouseStateEvent e = map(c);
        apply(e);
    }

    public void delete(WarehouseCommand.DeleteWarehouse c)
    {
        WarehouseStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        WarehouseCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected WarehouseStateEvent map(WarehouseCommand.CreateWarehouse c) {
        WarehouseEventId stateEventId = new WarehouseEventId(c.getWarehouseId(), c.getVersion());
        WarehouseStateEvent.WarehouseStateCreated e = newWarehouseStateCreated(stateEventId);
        e.setWarehouseName(c.getWarehouseName());
        e.setDescription(c.getDescription());
        e.setIsInTransit(c.getIsInTransit());
        e.setActive(c.getActive());
        ((AbstractWarehouseStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseStateEvent map(WarehouseCommand.MergePatchWarehouse c) {
        WarehouseEventId stateEventId = new WarehouseEventId(c.getWarehouseId(), c.getVersion());
        WarehouseStateEvent.WarehouseStateMergePatched e = newWarehouseStateMergePatched(stateEventId);
        e.setWarehouseName(c.getWarehouseName());
        e.setDescription(c.getDescription());
        e.setIsInTransit(c.getIsInTransit());
        e.setActive(c.getActive());
        e.setIsPropertyWarehouseNameRemoved(c.getIsPropertyWarehouseNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyIsInTransitRemoved(c.getIsPropertyIsInTransitRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractWarehouseStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseStateEvent map(WarehouseCommand.DeleteWarehouse c) {
        WarehouseEventId stateEventId = new WarehouseEventId(c.getWarehouseId(), c.getVersion());
        WarehouseStateEvent.WarehouseStateDeleted e = newWarehouseStateDeleted(stateEventId);
        ((AbstractWarehouseStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected WarehouseStateEvent.WarehouseStateCreated newWarehouseStateCreated(Long version, String commandId, String requesterId) {
        WarehouseEventId stateEventId = new WarehouseEventId(this.state.getWarehouseId(), version);
        WarehouseStateEvent.WarehouseStateCreated e = newWarehouseStateCreated(stateEventId);
        ((AbstractWarehouseStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseStateEvent.WarehouseStateMergePatched newWarehouseStateMergePatched(Long version, String commandId, String requesterId) {
        WarehouseEventId stateEventId = new WarehouseEventId(this.state.getWarehouseId(), version);
        WarehouseStateEvent.WarehouseStateMergePatched e = newWarehouseStateMergePatched(stateEventId);
        ((AbstractWarehouseStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseStateEvent.WarehouseStateDeleted newWarehouseStateDeleted(Long version, String commandId, String requesterId) {
        WarehouseEventId stateEventId = new WarehouseEventId(this.state.getWarehouseId(), version);
        WarehouseStateEvent.WarehouseStateDeleted e = newWarehouseStateDeleted(stateEventId);
        ((AbstractWarehouseStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseStateEvent.WarehouseStateCreated newWarehouseStateCreated(WarehouseEventId stateEventId) {
        return new AbstractWarehouseStateEvent.SimpleWarehouseStateCreated(stateEventId);
    }

    protected WarehouseStateEvent.WarehouseStateMergePatched newWarehouseStateMergePatched(WarehouseEventId stateEventId) {
        return new AbstractWarehouseStateEvent.SimpleWarehouseStateMergePatched(stateEventId);
    }

    protected WarehouseStateEvent.WarehouseStateDeleted newWarehouseStateDeleted(WarehouseEventId stateEventId)
    {
        return new AbstractWarehouseStateEvent.SimpleWarehouseStateDeleted(stateEventId);
    }

    public static class SimpleWarehouseAggregate extends AbstractWarehouseAggregate
    {
        public SimpleWarehouseAggregate(WarehouseState state) {
            super(state);
        }

    }

}

