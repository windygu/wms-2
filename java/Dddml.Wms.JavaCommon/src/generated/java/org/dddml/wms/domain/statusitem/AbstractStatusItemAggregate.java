package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractStatusItemAggregate extends AbstractAggregate implements StatusItemAggregate
{
    private StatusItemState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractStatusItemAggregate(StatusItemState state)
    {
        this.state = state;
    }

    public StatusItemState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(StatusItemCommand.CreateStatusItem c)
    {
        if (c.getVersion() == null) { c.setVersion(StatusItemState.VERSION_NULL); }
        StatusItemStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(StatusItemCommand.MergePatchStatusItem c)
    {
        StatusItemStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        StatusItemCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected StatusItemStateEvent map(StatusItemCommand.CreateStatusItem c) {
        StatusItemEventId stateEventId = new StatusItemEventId(c.getStatusId(), c.getVersion());
        StatusItemStateEvent.StatusItemStateCreated e = newStatusItemStateCreated(stateEventId);
        e.setStatusTypeId(c.getStatusTypeId());
        e.setStatusCode(c.getStatusCode());
        e.setSequenceId(c.getSequenceId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractStatusItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected StatusItemStateEvent map(StatusItemCommand.MergePatchStatusItem c) {
        StatusItemEventId stateEventId = new StatusItemEventId(c.getStatusId(), c.getVersion());
        StatusItemStateEvent.StatusItemStateMergePatched e = newStatusItemStateMergePatched(stateEventId);
        e.setStatusTypeId(c.getStatusTypeId());
        e.setStatusCode(c.getStatusCode());
        e.setSequenceId(c.getSequenceId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyStatusTypeIdRemoved(c.getIsPropertyStatusTypeIdRemoved());
        e.setIsPropertyStatusCodeRemoved(c.getIsPropertyStatusCodeRemoved());
        e.setIsPropertySequenceIdRemoved(c.getIsPropertySequenceIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractStatusItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected StatusItemStateEvent.StatusItemStateCreated newStatusItemStateCreated(Long version, String commandId, String requesterId) {
        StatusItemEventId stateEventId = new StatusItemEventId(this.state.getStatusId(), version);
        StatusItemStateEvent.StatusItemStateCreated e = newStatusItemStateCreated(stateEventId);
        ((AbstractStatusItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected StatusItemStateEvent.StatusItemStateMergePatched newStatusItemStateMergePatched(Long version, String commandId, String requesterId) {
        StatusItemEventId stateEventId = new StatusItemEventId(this.state.getStatusId(), version);
        StatusItemStateEvent.StatusItemStateMergePatched e = newStatusItemStateMergePatched(stateEventId);
        ((AbstractStatusItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected StatusItemStateEvent.StatusItemStateCreated newStatusItemStateCreated(StatusItemEventId stateEventId) {
        return new AbstractStatusItemStateEvent.SimpleStatusItemStateCreated(stateEventId);
    }

    protected StatusItemStateEvent.StatusItemStateMergePatched newStatusItemStateMergePatched(StatusItemEventId stateEventId) {
        return new AbstractStatusItemStateEvent.SimpleStatusItemStateMergePatched(stateEventId);
    }

    public static class SimpleStatusItemAggregate extends AbstractStatusItemAggregate
    {
        public SimpleStatusItemAggregate(StatusItemState state) {
            super(state);
        }

    }

}

