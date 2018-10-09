package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractWarehouseAggregate extends AbstractAggregate implements WarehouseAggregate
{
    private WarehouseState.MutableWarehouseState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractWarehouseAggregate(WarehouseState state)
    {
        this.state = (WarehouseState.MutableWarehouseState)state;
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
        WarehouseEvent e = map(c);
        apply(e);
    }

    public void mergePatch(WarehouseCommand.MergePatchWarehouse c)
    {
        WarehouseEvent e = map(c);
        apply(e);
    }

    public void delete(WarehouseCommand.DeleteWarehouse c)
    {
        WarehouseEvent e = map(c);
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

    protected WarehouseEvent map(WarehouseCommand.CreateWarehouse c) {
        WarehouseEventId stateEventId = new WarehouseEventId(c.getWarehouseId(), c.getVersion());
        WarehouseEvent.WarehouseStateCreated e = newWarehouseStateCreated(stateEventId);
        e.setWarehouseName(c.getWarehouseName());
        e.setDescription(c.getDescription());
        e.setIsInTransit(c.getIsInTransit());
        e.setActive(c.getActive());
        ((AbstractWarehouseEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseEvent map(WarehouseCommand.MergePatchWarehouse c) {
        WarehouseEventId stateEventId = new WarehouseEventId(c.getWarehouseId(), c.getVersion());
        WarehouseEvent.WarehouseStateMergePatched e = newWarehouseStateMergePatched(stateEventId);
        e.setWarehouseName(c.getWarehouseName());
        e.setDescription(c.getDescription());
        e.setIsInTransit(c.getIsInTransit());
        e.setActive(c.getActive());
        e.setIsPropertyWarehouseNameRemoved(c.getIsPropertyWarehouseNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyIsInTransitRemoved(c.getIsPropertyIsInTransitRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractWarehouseEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseEvent map(WarehouseCommand.DeleteWarehouse c) {
        WarehouseEventId stateEventId = new WarehouseEventId(c.getWarehouseId(), c.getVersion());
        WarehouseEvent.WarehouseStateDeleted e = newWarehouseStateDeleted(stateEventId);
        ((AbstractWarehouseEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected WarehouseEvent.WarehouseStateCreated newWarehouseStateCreated(Long version, String commandId, String requesterId) {
        WarehouseEventId stateEventId = new WarehouseEventId(this.state.getWarehouseId(), version);
        WarehouseEvent.WarehouseStateCreated e = newWarehouseStateCreated(stateEventId);
        ((AbstractWarehouseEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseEvent.WarehouseStateMergePatched newWarehouseStateMergePatched(Long version, String commandId, String requesterId) {
        WarehouseEventId stateEventId = new WarehouseEventId(this.state.getWarehouseId(), version);
        WarehouseEvent.WarehouseStateMergePatched e = newWarehouseStateMergePatched(stateEventId);
        ((AbstractWarehouseEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseEvent.WarehouseStateDeleted newWarehouseStateDeleted(Long version, String commandId, String requesterId) {
        WarehouseEventId stateEventId = new WarehouseEventId(this.state.getWarehouseId(), version);
        WarehouseEvent.WarehouseStateDeleted e = newWarehouseStateDeleted(stateEventId);
        ((AbstractWarehouseEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected WarehouseEvent.WarehouseStateCreated newWarehouseStateCreated(WarehouseEventId stateEventId) {
        return new AbstractWarehouseEvent.SimpleWarehouseStateCreated(stateEventId);
    }

    protected WarehouseEvent.WarehouseStateMergePatched newWarehouseStateMergePatched(WarehouseEventId stateEventId) {
        return new AbstractWarehouseEvent.SimpleWarehouseStateMergePatched(stateEventId);
    }

    protected WarehouseEvent.WarehouseStateDeleted newWarehouseStateDeleted(WarehouseEventId stateEventId)
    {
        return new AbstractWarehouseEvent.SimpleWarehouseStateDeleted(stateEventId);
    }

    public static class SimpleWarehouseAggregate extends AbstractWarehouseAggregate
    {
        public SimpleWarehouseAggregate(WarehouseState state) {
            super(state);
        }

    }

}

