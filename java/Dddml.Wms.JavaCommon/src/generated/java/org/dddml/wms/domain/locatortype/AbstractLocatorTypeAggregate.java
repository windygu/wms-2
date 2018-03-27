package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLocatorTypeAggregate extends AbstractAggregate implements LocatorTypeAggregate
{
    private LocatorTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractLocatorTypeAggregate(LocatorTypeState state)
    {
        this.state = state;
    }

    public LocatorTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(LocatorTypeCommand.CreateLocatorType c)
    {
        if (c.getVersion() == null) { c.setVersion(LocatorTypeState.VERSION_NULL); }
        LocatorTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(LocatorTypeCommand.MergePatchLocatorType c)
    {
        LocatorTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(LocatorTypeCommand.DeleteLocatorType c)
    {
        LocatorTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        LocatorTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected LocatorTypeStateEvent map(LocatorTypeCommand.CreateLocatorType c) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(c.getLocatorTypeId(), c.getVersion());
        LocatorTypeStateEvent.LocatorTypeStateCreated e = newLocatorTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractLocatorTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeStateEvent map(LocatorTypeCommand.MergePatchLocatorType c) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(c.getLocatorTypeId(), c.getVersion());
        LocatorTypeStateEvent.LocatorTypeStateMergePatched e = newLocatorTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractLocatorTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeStateEvent map(LocatorTypeCommand.DeleteLocatorType c) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(c.getLocatorTypeId(), c.getVersion());
        LocatorTypeStateEvent.LocatorTypeStateDeleted e = newLocatorTypeStateDeleted(stateEventId);
        ((AbstractLocatorTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected LocatorTypeStateEvent.LocatorTypeStateCreated newLocatorTypeStateCreated(Long version, String commandId, String requesterId) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(this.state.getLocatorTypeId(), version);
        LocatorTypeStateEvent.LocatorTypeStateCreated e = newLocatorTypeStateCreated(stateEventId);
        ((AbstractLocatorTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeStateEvent.LocatorTypeStateMergePatched newLocatorTypeStateMergePatched(Long version, String commandId, String requesterId) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(this.state.getLocatorTypeId(), version);
        LocatorTypeStateEvent.LocatorTypeStateMergePatched e = newLocatorTypeStateMergePatched(stateEventId);
        ((AbstractLocatorTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeStateEvent.LocatorTypeStateDeleted newLocatorTypeStateDeleted(Long version, String commandId, String requesterId) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(this.state.getLocatorTypeId(), version);
        LocatorTypeStateEvent.LocatorTypeStateDeleted e = newLocatorTypeStateDeleted(stateEventId);
        ((AbstractLocatorTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeStateEvent.LocatorTypeStateCreated newLocatorTypeStateCreated(LocatorTypeEventId stateEventId) {
        return new AbstractLocatorTypeStateEvent.SimpleLocatorTypeStateCreated(stateEventId);
    }

    protected LocatorTypeStateEvent.LocatorTypeStateMergePatched newLocatorTypeStateMergePatched(LocatorTypeEventId stateEventId) {
        return new AbstractLocatorTypeStateEvent.SimpleLocatorTypeStateMergePatched(stateEventId);
    }

    protected LocatorTypeStateEvent.LocatorTypeStateDeleted newLocatorTypeStateDeleted(LocatorTypeEventId stateEventId)
    {
        return new AbstractLocatorTypeStateEvent.SimpleLocatorTypeStateDeleted(stateEventId);
    }

    public static class SimpleLocatorTypeAggregate extends AbstractLocatorTypeAggregate
    {
        public SimpleLocatorTypeAggregate(LocatorTypeState state) {
            super(state);
        }

    }

}

