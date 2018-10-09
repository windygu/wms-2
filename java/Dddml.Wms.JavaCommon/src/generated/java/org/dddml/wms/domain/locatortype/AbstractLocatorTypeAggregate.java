package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLocatorTypeAggregate extends AbstractAggregate implements LocatorTypeAggregate
{
    private LocatorTypeState.MutableLocatorTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractLocatorTypeAggregate(LocatorTypeState state)
    {
        this.state = (LocatorTypeState.MutableLocatorTypeState)state;
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
        LocatorTypeEvent e = map(c);
        apply(e);
    }

    public void mergePatch(LocatorTypeCommand.MergePatchLocatorType c)
    {
        LocatorTypeEvent e = map(c);
        apply(e);
    }

    public void delete(LocatorTypeCommand.DeleteLocatorType c)
    {
        LocatorTypeEvent e = map(c);
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

    protected LocatorTypeEvent map(LocatorTypeCommand.CreateLocatorType c) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(c.getLocatorTypeId(), c.getVersion());
        LocatorTypeEvent.LocatorTypeStateCreated e = newLocatorTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractLocatorTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeEvent map(LocatorTypeCommand.MergePatchLocatorType c) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(c.getLocatorTypeId(), c.getVersion());
        LocatorTypeEvent.LocatorTypeStateMergePatched e = newLocatorTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractLocatorTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeEvent map(LocatorTypeCommand.DeleteLocatorType c) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(c.getLocatorTypeId(), c.getVersion());
        LocatorTypeEvent.LocatorTypeStateDeleted e = newLocatorTypeStateDeleted(stateEventId);
        ((AbstractLocatorTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected LocatorTypeEvent.LocatorTypeStateCreated newLocatorTypeStateCreated(Long version, String commandId, String requesterId) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(this.state.getLocatorTypeId(), version);
        LocatorTypeEvent.LocatorTypeStateCreated e = newLocatorTypeStateCreated(stateEventId);
        ((AbstractLocatorTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeEvent.LocatorTypeStateMergePatched newLocatorTypeStateMergePatched(Long version, String commandId, String requesterId) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(this.state.getLocatorTypeId(), version);
        LocatorTypeEvent.LocatorTypeStateMergePatched e = newLocatorTypeStateMergePatched(stateEventId);
        ((AbstractLocatorTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeEvent.LocatorTypeStateDeleted newLocatorTypeStateDeleted(Long version, String commandId, String requesterId) {
        LocatorTypeEventId stateEventId = new LocatorTypeEventId(this.state.getLocatorTypeId(), version);
        LocatorTypeEvent.LocatorTypeStateDeleted e = newLocatorTypeStateDeleted(stateEventId);
        ((AbstractLocatorTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorTypeEvent.LocatorTypeStateCreated newLocatorTypeStateCreated(LocatorTypeEventId stateEventId) {
        return new AbstractLocatorTypeEvent.SimpleLocatorTypeStateCreated(stateEventId);
    }

    protected LocatorTypeEvent.LocatorTypeStateMergePatched newLocatorTypeStateMergePatched(LocatorTypeEventId stateEventId) {
        return new AbstractLocatorTypeEvent.SimpleLocatorTypeStateMergePatched(stateEventId);
    }

    protected LocatorTypeEvent.LocatorTypeStateDeleted newLocatorTypeStateDeleted(LocatorTypeEventId stateEventId)
    {
        return new AbstractLocatorTypeEvent.SimpleLocatorTypeStateDeleted(stateEventId);
    }

    public static class SimpleLocatorTypeAggregate extends AbstractLocatorTypeAggregate
    {
        public SimpleLocatorTypeAggregate(LocatorTypeState state) {
            super(state);
        }

    }

}

