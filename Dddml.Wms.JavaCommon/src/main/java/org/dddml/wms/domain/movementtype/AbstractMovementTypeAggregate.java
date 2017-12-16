package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementTypeAggregate extends AbstractAggregate implements MovementTypeAggregate
{
    private MovementTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractMovementTypeAggregate(MovementTypeState state)
    {
        this.state = state;
    }

    public MovementTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(MovementTypeCommand.CreateMovementType c)
    {
        if (c.getVersion() == null) { c.setVersion(MovementTypeState.VERSION_NULL); }
        MovementTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementTypeCommand.MergePatchMovementType c)
    {
        MovementTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(MovementTypeCommand.DeleteMovementType c)
    {
        MovementTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        MovementTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected MovementTypeStateEvent map(MovementTypeCommand.CreateMovementType c) {
        MovementTypeStateEventId stateEventId = new MovementTypeStateEventId(c.getMovementTypeId(), c.getVersion());
        MovementTypeStateEvent.MovementTypeStateCreated e = newMovementTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractMovementTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementTypeStateEvent map(MovementTypeCommand.MergePatchMovementType c) {
        MovementTypeStateEventId stateEventId = new MovementTypeStateEventId(c.getMovementTypeId(), c.getVersion());
        MovementTypeStateEvent.MovementTypeStateMergePatched e = newMovementTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractMovementTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementTypeStateEvent map(MovementTypeCommand.DeleteMovementType c) {
        MovementTypeStateEventId stateEventId = new MovementTypeStateEventId(c.getMovementTypeId(), c.getVersion());
        MovementTypeStateEvent.MovementTypeStateDeleted e = newMovementTypeStateDeleted(stateEventId);
        ((AbstractMovementTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected MovementTypeStateEvent.MovementTypeStateCreated newMovementTypeStateCreated(String commandId, String requesterId) {
        MovementTypeStateEventId stateEventId = new MovementTypeStateEventId(this.state.getMovementTypeId(), this.state.getVersion());
        MovementTypeStateEvent.MovementTypeStateCreated e = newMovementTypeStateCreated(stateEventId);
        ((AbstractMovementTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementTypeStateEvent.MovementTypeStateMergePatched newMovementTypeStateMergePatched(String commandId, String requesterId) {
        MovementTypeStateEventId stateEventId = new MovementTypeStateEventId(this.state.getMovementTypeId(), this.state.getVersion());
        MovementTypeStateEvent.MovementTypeStateMergePatched e = newMovementTypeStateMergePatched(stateEventId);
        ((AbstractMovementTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementTypeStateEvent.MovementTypeStateDeleted newMovementTypeStateDeleted(String commandId, String requesterId) {
        MovementTypeStateEventId stateEventId = new MovementTypeStateEventId(this.state.getMovementTypeId(), this.state.getVersion());
        MovementTypeStateEvent.MovementTypeStateDeleted e = newMovementTypeStateDeleted(stateEventId);
        ((AbstractMovementTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementTypeStateEvent.MovementTypeStateCreated newMovementTypeStateCreated(MovementTypeStateEventId stateEventId) {
        return new AbstractMovementTypeStateEvent.SimpleMovementTypeStateCreated(stateEventId);
    }

    protected MovementTypeStateEvent.MovementTypeStateMergePatched newMovementTypeStateMergePatched(MovementTypeStateEventId stateEventId) {
        return new AbstractMovementTypeStateEvent.SimpleMovementTypeStateMergePatched(stateEventId);
    }

    protected MovementTypeStateEvent.MovementTypeStateDeleted newMovementTypeStateDeleted(MovementTypeStateEventId stateEventId)
    {
        return new AbstractMovementTypeStateEvent.SimpleMovementTypeStateDeleted(stateEventId);
    }


    public static class SimpleMovementTypeAggregate extends AbstractMovementTypeAggregate
    {
        public SimpleMovementTypeAggregate(MovementTypeState state) {
            super(state);
        }

    }

}

