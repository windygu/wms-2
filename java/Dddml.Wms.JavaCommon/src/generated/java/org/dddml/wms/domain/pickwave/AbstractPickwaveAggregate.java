package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPickwaveAggregate extends AbstractAggregate implements PickwaveAggregate
{
    private PickwaveState.MutablePickwaveState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPickwaveAggregate(PickwaveState state)
    {
        this.state = (PickwaveState.MutablePickwaveState)state;
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
        PickwaveEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PickwaveCommand.MergePatchPickwave c)
    {
        PickwaveEvent e = map(c);
        apply(e);
    }

    public void delete(PickwaveCommand.DeletePickwave c)
    {
        PickwaveEvent e = map(c);
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

    protected PickwaveEvent map(PickwaveCommand.CreatePickwave c) {
        PickwaveEventId stateEventId = new PickwaveEventId(c.getPickwaveId(), c.getVersion());
        PickwaveEvent.PickwaveStateCreated e = newPickwaveStateCreated(stateEventId);
        e.setStatusId(c.getStatusId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractPickwaveEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveEvent map(PickwaveCommand.MergePatchPickwave c) {
        PickwaveEventId stateEventId = new PickwaveEventId(c.getPickwaveId(), c.getVersion());
        PickwaveEvent.PickwaveStateMergePatched e = newPickwaveStateMergePatched(stateEventId);
        e.setStatusId(c.getStatusId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyStatusIdRemoved(c.getIsPropertyStatusIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPickwaveEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveEvent map(PickwaveCommand.DeletePickwave c) {
        PickwaveEventId stateEventId = new PickwaveEventId(c.getPickwaveId(), c.getVersion());
        PickwaveEvent.PickwaveStateDeleted e = newPickwaveStateDeleted(stateEventId);
        ((AbstractPickwaveEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PickwaveEvent.PickwaveStateCreated newPickwaveStateCreated(Long version, String commandId, String requesterId) {
        PickwaveEventId stateEventId = new PickwaveEventId(this.state.getPickwaveId(), version);
        PickwaveEvent.PickwaveStateCreated e = newPickwaveStateCreated(stateEventId);
        ((AbstractPickwaveEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveEvent.PickwaveStateMergePatched newPickwaveStateMergePatched(Long version, String commandId, String requesterId) {
        PickwaveEventId stateEventId = new PickwaveEventId(this.state.getPickwaveId(), version);
        PickwaveEvent.PickwaveStateMergePatched e = newPickwaveStateMergePatched(stateEventId);
        ((AbstractPickwaveEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveEvent.PickwaveStateDeleted newPickwaveStateDeleted(Long version, String commandId, String requesterId) {
        PickwaveEventId stateEventId = new PickwaveEventId(this.state.getPickwaveId(), version);
        PickwaveEvent.PickwaveStateDeleted e = newPickwaveStateDeleted(stateEventId);
        ((AbstractPickwaveEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PickwaveEvent.PickwaveStateCreated newPickwaveStateCreated(PickwaveEventId stateEventId) {
        return new AbstractPickwaveEvent.SimplePickwaveStateCreated(stateEventId);
    }

    protected PickwaveEvent.PickwaveStateMergePatched newPickwaveStateMergePatched(PickwaveEventId stateEventId) {
        return new AbstractPickwaveEvent.SimplePickwaveStateMergePatched(stateEventId);
    }

    protected PickwaveEvent.PickwaveStateDeleted newPickwaveStateDeleted(PickwaveEventId stateEventId)
    {
        return new AbstractPickwaveEvent.SimplePickwaveStateDeleted(stateEventId);
    }

    public static class SimplePickwaveAggregate extends AbstractPickwaveAggregate
    {
        public SimplePickwaveAggregate(PickwaveState state) {
            super(state);
        }

    }

}

