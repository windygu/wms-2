package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPickwaveAggregate extends AbstractAggregate implements PickwaveAggregate
{
    private PickwaveState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPickwaveAggregate(PickwaveState state)
    {
        this.state = state;
    }

    public PickwaveState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PickwaveCommand.CreatePickwave c)
    {
        if (c.getVersion() == null) { c.setVersion(PickwaveState.VERSION_NULL); }
        PickwaveStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PickwaveCommand.MergePatchPickwave c)
    {
        PickwaveStateEvent e = map(c);
        apply(e);
    }

    public void delete(PickwaveCommand.DeletePickwave c)
    {
        PickwaveStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PickwaveCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PickwaveStateEvent map(PickwaveCommand.CreatePickwave c) {
        PickwaveEventId stateEventId = new PickwaveEventId(c.getPickwaveId(), c.getVersion());
        PickwaveStateEvent.PickwaveStateCreated e = newPickwaveStateCreated(stateEventId);
        e.setStatusId(c.getStatusId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractPickwaveStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveStateEvent map(PickwaveCommand.MergePatchPickwave c) {
        PickwaveEventId stateEventId = new PickwaveEventId(c.getPickwaveId(), c.getVersion());
        PickwaveStateEvent.PickwaveStateMergePatched e = newPickwaveStateMergePatched(stateEventId);
        e.setStatusId(c.getStatusId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyStatusIdRemoved(c.getIsPropertyStatusIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPickwaveStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveStateEvent map(PickwaveCommand.DeletePickwave c) {
        PickwaveEventId stateEventId = new PickwaveEventId(c.getPickwaveId(), c.getVersion());
        PickwaveStateEvent.PickwaveStateDeleted e = newPickwaveStateDeleted(stateEventId);
        ((AbstractPickwaveStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PickwaveStateEvent.PickwaveStateCreated newPickwaveStateCreated(Long version, String commandId, String requesterId) {
        PickwaveEventId stateEventId = new PickwaveEventId(this.state.getPickwaveId(), version);
        PickwaveStateEvent.PickwaveStateCreated e = newPickwaveStateCreated(stateEventId);
        ((AbstractPickwaveStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveStateEvent.PickwaveStateMergePatched newPickwaveStateMergePatched(Long version, String commandId, String requesterId) {
        PickwaveEventId stateEventId = new PickwaveEventId(this.state.getPickwaveId(), version);
        PickwaveStateEvent.PickwaveStateMergePatched e = newPickwaveStateMergePatched(stateEventId);
        ((AbstractPickwaveStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveStateEvent.PickwaveStateDeleted newPickwaveStateDeleted(Long version, String commandId, String requesterId) {
        PickwaveEventId stateEventId = new PickwaveEventId(this.state.getPickwaveId(), version);
        PickwaveStateEvent.PickwaveStateDeleted e = newPickwaveStateDeleted(stateEventId);
        ((AbstractPickwaveStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveStateEvent.PickwaveStateCreated newPickwaveStateCreated(PickwaveEventId stateEventId) {
        return new AbstractPickwaveStateEvent.SimplePickwaveStateCreated(stateEventId);
    }

    protected PickwaveStateEvent.PickwaveStateMergePatched newPickwaveStateMergePatched(PickwaveEventId stateEventId) {
        return new AbstractPickwaveStateEvent.SimplePickwaveStateMergePatched(stateEventId);
    }

    protected PickwaveStateEvent.PickwaveStateDeleted newPickwaveStateDeleted(PickwaveEventId stateEventId)
    {
        return new AbstractPickwaveStateEvent.SimplePickwaveStateDeleted(stateEventId);
    }

    public static class SimplePickwaveAggregate extends AbstractPickwaveAggregate
    {
        public SimplePickwaveAggregate(PickwaveState state) {
            super(state);
        }

    }

}

