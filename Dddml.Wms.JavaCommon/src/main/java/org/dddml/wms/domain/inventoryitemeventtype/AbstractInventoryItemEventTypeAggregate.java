package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemEventTypeAggregate extends AbstractAggregate implements InventoryItemEventTypeAggregate
{
    private InventoryItemEventTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryItemEventTypeAggregate(InventoryItemEventTypeState state)
    {
        this.state = state;
    }

    public InventoryItemEventTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryItemEventTypeCommand.CreateInventoryItemEventType c)
    {
        if (c.getVersion() == null) { c.setVersion(InventoryItemEventTypeState.VERSION_NULL); }
        InventoryItemEventTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemEventTypeCommand.MergePatchInventoryItemEventType c)
    {
        InventoryItemEventTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(InventoryItemEventTypeCommand.DeleteInventoryItemEventType c)
    {
        InventoryItemEventTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c)
    {
        if (this.state.getVersion() == null)
        {
            if (isCommandCreate((InventoryItemEventTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (this.state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((InventoryItemEventTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryItemEventTypeStateEvent map(InventoryItemEventTypeCommand.CreateInventoryItemEventType c) {
        InventoryItemEventTypeStateEventId stateEventId = new InventoryItemEventTypeStateEventId(c.getInventoryItemEventTypeId(), c.getVersion());
        InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated e = newInventoryItemEventTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractInventoryItemEventTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEventTypeStateEvent map(InventoryItemEventTypeCommand.MergePatchInventoryItemEventType c) {
        InventoryItemEventTypeStateEventId stateEventId = new InventoryItemEventTypeStateEventId(c.getInventoryItemEventTypeId(), c.getVersion());
        InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched e = newInventoryItemEventTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractInventoryItemEventTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEventTypeStateEvent map(InventoryItemEventTypeCommand.DeleteInventoryItemEventType c) {
        InventoryItemEventTypeStateEventId stateEventId = new InventoryItemEventTypeStateEventId(c.getInventoryItemEventTypeId(), c.getVersion());
        InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted e = newInventoryItemEventTypeStateDeleted(stateEventId);
        ((AbstractInventoryItemEventTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    private static boolean isCommandCreate(InventoryItemEventTypeCommand c)
    {
        return ((c instanceof InventoryItemEventTypeCommand.CreateInventoryItemEventType) 
            && c.getVersion().equals(InventoryItemEventTypeState.VERSION_NULL));
    }


    ////////////////////////

    protected InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated newInventoryItemEventTypeStateCreated(String commandId, String requesterId) {
        InventoryItemEventTypeStateEventId stateEventId = new InventoryItemEventTypeStateEventId(this.state.getInventoryItemEventTypeId(), this.state.getVersion());
        InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated e = newInventoryItemEventTypeStateCreated(stateEventId);
        ((AbstractInventoryItemEventTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched newInventoryItemEventTypeStateMergePatched(String commandId, String requesterId) {
        InventoryItemEventTypeStateEventId stateEventId = new InventoryItemEventTypeStateEventId(this.state.getInventoryItemEventTypeId(), this.state.getVersion());
        InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched e = newInventoryItemEventTypeStateMergePatched(stateEventId);
        ((AbstractInventoryItemEventTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted newInventoryItemEventTypeStateDeleted(String commandId, String requesterId) {
        InventoryItemEventTypeStateEventId stateEventId = new InventoryItemEventTypeStateEventId(this.state.getInventoryItemEventTypeId(), this.state.getVersion());
        InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted e = newInventoryItemEventTypeStateDeleted(stateEventId);
        ((AbstractInventoryItemEventTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated newInventoryItemEventTypeStateCreated(InventoryItemEventTypeStateEventId stateEventId) {
        return new AbstractInventoryItemEventTypeStateEvent.SimpleInventoryItemEventTypeStateCreated(stateEventId);
    }

    protected InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched newInventoryItemEventTypeStateMergePatched(InventoryItemEventTypeStateEventId stateEventId) {
        return new AbstractInventoryItemEventTypeStateEvent.SimpleInventoryItemEventTypeStateMergePatched(stateEventId);
    }

    protected InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted newInventoryItemEventTypeStateDeleted(InventoryItemEventTypeStateEventId stateEventId)
    {
        return new AbstractInventoryItemEventTypeStateEvent.SimpleInventoryItemEventTypeStateDeleted(stateEventId);
    }


    public static class SimpleInventoryItemEventTypeAggregate extends AbstractInventoryItemEventTypeAggregate
    {
        public SimpleInventoryItemEventTypeAggregate(InventoryItemEventTypeState state) {
            super(state);
        }

    }

}

