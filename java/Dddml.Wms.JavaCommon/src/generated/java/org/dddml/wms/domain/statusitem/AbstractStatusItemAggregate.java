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
        StatusItemEvent e = map(c);
        apply(e);
    }

    public void mergePatch(StatusItemCommand.MergePatchStatusItem c)
    {
        StatusItemEvent e = map(c);
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

    protected StatusItemEvent map(StatusItemCommand.CreateStatusItem c) {
        StatusItemEventId stateEventId = new StatusItemEventId(c.getStatusId(), c.getVersion());
        StatusItemEvent.StatusItemStateCreated e = newStatusItemStateCreated(stateEventId);
        e.setStatusTypeId(c.getStatusTypeId());
        e.setStatusCode(c.getStatusCode());
        e.setSequenceId(c.getSequenceId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractStatusItemEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected StatusItemEvent map(StatusItemCommand.MergePatchStatusItem c) {
        StatusItemEventId stateEventId = new StatusItemEventId(c.getStatusId(), c.getVersion());
        StatusItemEvent.StatusItemStateMergePatched e = newStatusItemStateMergePatched(stateEventId);
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
        ((AbstractStatusItemEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected StatusItemEvent.StatusItemStateCreated newStatusItemStateCreated(Long version, String commandId, String requesterId) {
        StatusItemEventId stateEventId = new StatusItemEventId(this.state.getStatusId(), version);
        StatusItemEvent.StatusItemStateCreated e = newStatusItemStateCreated(stateEventId);
        ((AbstractStatusItemEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected StatusItemEvent.StatusItemStateMergePatched newStatusItemStateMergePatched(Long version, String commandId, String requesterId) {
        StatusItemEventId stateEventId = new StatusItemEventId(this.state.getStatusId(), version);
        StatusItemEvent.StatusItemStateMergePatched e = newStatusItemStateMergePatched(stateEventId);
        ((AbstractStatusItemEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected StatusItemEvent.StatusItemStateCreated newStatusItemStateCreated(StatusItemEventId stateEventId) {
        return new AbstractStatusItemEvent.SimpleStatusItemStateCreated(stateEventId);
    }

    protected StatusItemEvent.StatusItemStateMergePatched newStatusItemStateMergePatched(StatusItemEventId stateEventId) {
        return new AbstractStatusItemEvent.SimpleStatusItemStateMergePatched(stateEventId);
    }

    public static class SimpleStatusItemAggregate extends AbstractStatusItemAggregate
    {
        public SimpleStatusItemAggregate(StatusItemState state) {
            super(state);
        }

    }

}

