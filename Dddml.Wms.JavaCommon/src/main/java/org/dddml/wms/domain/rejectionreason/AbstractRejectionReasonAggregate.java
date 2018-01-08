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
        RejectionReasonStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(RejectionReasonCommand.MergePatchRejectionReason c)
    {
        RejectionReasonStateEvent e = map(c);
        apply(e);
    }

    public void delete(RejectionReasonCommand.DeleteRejectionReason c)
    {
        RejectionReasonStateEvent e = map(c);
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

    protected RejectionReasonStateEvent map(RejectionReasonCommand.CreateRejectionReason c) {
        RejectionReasonStateEventId stateEventId = new RejectionReasonStateEventId(c.getRejectionReasonId(), c.getVersion());
        RejectionReasonStateEvent.RejectionReasonStateCreated e = newRejectionReasonStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractRejectionReasonStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonStateEvent map(RejectionReasonCommand.MergePatchRejectionReason c) {
        RejectionReasonStateEventId stateEventId = new RejectionReasonStateEventId(c.getRejectionReasonId(), c.getVersion());
        RejectionReasonStateEvent.RejectionReasonStateMergePatched e = newRejectionReasonStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractRejectionReasonStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonStateEvent map(RejectionReasonCommand.DeleteRejectionReason c) {
        RejectionReasonStateEventId stateEventId = new RejectionReasonStateEventId(c.getRejectionReasonId(), c.getVersion());
        RejectionReasonStateEvent.RejectionReasonStateDeleted e = newRejectionReasonStateDeleted(stateEventId);
        ((AbstractRejectionReasonStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected RejectionReasonStateEvent.RejectionReasonStateCreated newRejectionReasonStateCreated(String commandId, String requesterId) {
        RejectionReasonStateEventId stateEventId = new RejectionReasonStateEventId(this.state.getRejectionReasonId(), this.state.getVersion());
        RejectionReasonStateEvent.RejectionReasonStateCreated e = newRejectionReasonStateCreated(stateEventId);
        ((AbstractRejectionReasonStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonStateEvent.RejectionReasonStateMergePatched newRejectionReasonStateMergePatched(String commandId, String requesterId) {
        RejectionReasonStateEventId stateEventId = new RejectionReasonStateEventId(this.state.getRejectionReasonId(), this.state.getVersion());
        RejectionReasonStateEvent.RejectionReasonStateMergePatched e = newRejectionReasonStateMergePatched(stateEventId);
        ((AbstractRejectionReasonStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonStateEvent.RejectionReasonStateDeleted newRejectionReasonStateDeleted(String commandId, String requesterId) {
        RejectionReasonStateEventId stateEventId = new RejectionReasonStateEventId(this.state.getRejectionReasonId(), this.state.getVersion());
        RejectionReasonStateEvent.RejectionReasonStateDeleted e = newRejectionReasonStateDeleted(stateEventId);
        ((AbstractRejectionReasonStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RejectionReasonStateEvent.RejectionReasonStateCreated newRejectionReasonStateCreated(RejectionReasonStateEventId stateEventId) {
        return new AbstractRejectionReasonStateEvent.SimpleRejectionReasonStateCreated(stateEventId);
    }

    protected RejectionReasonStateEvent.RejectionReasonStateMergePatched newRejectionReasonStateMergePatched(RejectionReasonStateEventId stateEventId) {
        return new AbstractRejectionReasonStateEvent.SimpleRejectionReasonStateMergePatched(stateEventId);
    }

    protected RejectionReasonStateEvent.RejectionReasonStateDeleted newRejectionReasonStateDeleted(RejectionReasonStateEventId stateEventId)
    {
        return new AbstractRejectionReasonStateEvent.SimpleRejectionReasonStateDeleted(stateEventId);
    }

    public static class SimpleRejectionReasonAggregate extends AbstractRejectionReasonAggregate
    {
        public SimpleRejectionReasonAggregate(RejectionReasonState state) {
            super(state);
        }

    }

}

