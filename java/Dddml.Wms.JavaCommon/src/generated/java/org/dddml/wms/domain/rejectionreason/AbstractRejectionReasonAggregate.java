package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractRejectionReasonAggregate extends AbstractAggregate implements RejectionReasonAggregate
{
    private RejectionReasonState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractRejectionReasonAggregate(RejectionReasonState state)
    {
        this.state = state;
    }

    public RejectionReasonState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(RejectionReasonCommand.CreateRejectionReason c)
    {
        if (c.getVersion() == null) { c.setVersion(RejectionReasonState.VERSION_NULL); }
        RejectionReasonEvent e = map(c);
        apply(e);
    }

    public void mergePatch(RejectionReasonCommand.MergePatchRejectionReason c)
    {
        RejectionReasonEvent e = map(c);
        apply(e);
    }

    public void delete(RejectionReasonCommand.DeleteRejectionReason c)
    {
        RejectionReasonEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        RejectionReasonCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected RejectionReasonEvent map(RejectionReasonCommand.CreateRejectionReason c) {
        RejectionReasonEventId stateEventId = new RejectionReasonEventId(c.getRejectionReasonId(), c.getVersion());
        RejectionReasonEvent.RejectionReasonStateCreated e = newRejectionReasonStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractRejectionReasonEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonEvent map(RejectionReasonCommand.MergePatchRejectionReason c) {
        RejectionReasonEventId stateEventId = new RejectionReasonEventId(c.getRejectionReasonId(), c.getVersion());
        RejectionReasonEvent.RejectionReasonStateMergePatched e = newRejectionReasonStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractRejectionReasonEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonEvent map(RejectionReasonCommand.DeleteRejectionReason c) {
        RejectionReasonEventId stateEventId = new RejectionReasonEventId(c.getRejectionReasonId(), c.getVersion());
        RejectionReasonEvent.RejectionReasonStateDeleted e = newRejectionReasonStateDeleted(stateEventId);
        ((AbstractRejectionReasonEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected RejectionReasonEvent.RejectionReasonStateCreated newRejectionReasonStateCreated(Long version, String commandId, String requesterId) {
        RejectionReasonEventId stateEventId = new RejectionReasonEventId(this.state.getRejectionReasonId(), version);
        RejectionReasonEvent.RejectionReasonStateCreated e = newRejectionReasonStateCreated(stateEventId);
        ((AbstractRejectionReasonEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonEvent.RejectionReasonStateMergePatched newRejectionReasonStateMergePatched(Long version, String commandId, String requesterId) {
        RejectionReasonEventId stateEventId = new RejectionReasonEventId(this.state.getRejectionReasonId(), version);
        RejectionReasonEvent.RejectionReasonStateMergePatched e = newRejectionReasonStateMergePatched(stateEventId);
        ((AbstractRejectionReasonEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonEvent.RejectionReasonStateDeleted newRejectionReasonStateDeleted(Long version, String commandId, String requesterId) {
        RejectionReasonEventId stateEventId = new RejectionReasonEventId(this.state.getRejectionReasonId(), version);
        RejectionReasonEvent.RejectionReasonStateDeleted e = newRejectionReasonStateDeleted(stateEventId);
        ((AbstractRejectionReasonEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonEvent.RejectionReasonStateCreated newRejectionReasonStateCreated(RejectionReasonEventId stateEventId) {
        return new AbstractRejectionReasonEvent.SimpleRejectionReasonStateCreated(stateEventId);
    }

    protected RejectionReasonEvent.RejectionReasonStateMergePatched newRejectionReasonStateMergePatched(RejectionReasonEventId stateEventId) {
        return new AbstractRejectionReasonEvent.SimpleRejectionReasonStateMergePatched(stateEventId);
    }

    protected RejectionReasonEvent.RejectionReasonStateDeleted newRejectionReasonStateDeleted(RejectionReasonEventId stateEventId)
    {
        return new AbstractRejectionReasonEvent.SimpleRejectionReasonStateDeleted(stateEventId);
    }

    public static class SimpleRejectionReasonAggregate extends AbstractRejectionReasonAggregate
    {
        public SimpleRejectionReasonAggregate(RejectionReasonState state) {
            super(state);
        }

    }

}

