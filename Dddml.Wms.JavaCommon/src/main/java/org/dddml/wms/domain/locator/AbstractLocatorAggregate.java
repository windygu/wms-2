package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLocatorAggregate extends AbstractAggregate implements LocatorAggregate
{
    private LocatorState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractLocatorAggregate(LocatorState state)
    {
        this.state = state;
    }

    public LocatorState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(LocatorCommand.CreateLocator c)
    {
        if (c.getVersion() == null) { c.setVersion(LocatorState.VERSION_NULL); }
        LocatorStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(LocatorCommand.MergePatchLocator c)
    {
        LocatorStateEvent e = map(c);
        apply(e);
    }

    public void delete(LocatorCommand.DeleteLocator c)
    {
        LocatorStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        LocatorCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected LocatorStateEvent map(LocatorCommand.CreateLocator c) {
        LocatorStateEventId stateEventId = new LocatorStateEventId(c.getLocatorId(), c.getVersion());
        LocatorStateEvent.LocatorStateCreated e = newLocatorStateCreated(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setParentLocatorId(c.getParentLocatorId());
        e.setLocatorType(c.getLocatorType());
        e.setPriorityNumber(c.getPriorityNumber());
        e.setIsDefault(c.getIsDefault());
        e.setX(c.getX());
        e.setY(c.getY());
        e.setZ(c.getZ());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractLocatorStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorStateEvent map(LocatorCommand.MergePatchLocator c) {
        LocatorStateEventId stateEventId = new LocatorStateEventId(c.getLocatorId(), c.getVersion());
        LocatorStateEvent.LocatorStateMergePatched e = newLocatorStateMergePatched(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setParentLocatorId(c.getParentLocatorId());
        e.setLocatorType(c.getLocatorType());
        e.setPriorityNumber(c.getPriorityNumber());
        e.setIsDefault(c.getIsDefault());
        e.setX(c.getX());
        e.setY(c.getY());
        e.setZ(c.getZ());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyWarehouseIdRemoved(c.getIsPropertyWarehouseIdRemoved());
        e.setIsPropertyParentLocatorIdRemoved(c.getIsPropertyParentLocatorIdRemoved());
        e.setIsPropertyLocatorTypeRemoved(c.getIsPropertyLocatorTypeRemoved());
        e.setIsPropertyPriorityNumberRemoved(c.getIsPropertyPriorityNumberRemoved());
        e.setIsPropertyIsDefaultRemoved(c.getIsPropertyIsDefaultRemoved());
        e.setIsPropertyXRemoved(c.getIsPropertyXRemoved());
        e.setIsPropertyYRemoved(c.getIsPropertyYRemoved());
        e.setIsPropertyZRemoved(c.getIsPropertyZRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractLocatorStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorStateEvent map(LocatorCommand.DeleteLocator c) {
        LocatorStateEventId stateEventId = new LocatorStateEventId(c.getLocatorId(), c.getVersion());
        LocatorStateEvent.LocatorStateDeleted e = newLocatorStateDeleted(stateEventId);
        ((AbstractLocatorStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected LocatorStateEvent.LocatorStateCreated newLocatorStateCreated(String commandId, String requesterId) {
        LocatorStateEventId stateEventId = new LocatorStateEventId(this.state.getLocatorId(), this.state.getVersion());
        LocatorStateEvent.LocatorStateCreated e = newLocatorStateCreated(stateEventId);
        ((AbstractLocatorStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorStateEvent.LocatorStateMergePatched newLocatorStateMergePatched(String commandId, String requesterId) {
        LocatorStateEventId stateEventId = new LocatorStateEventId(this.state.getLocatorId(), this.state.getVersion());
        LocatorStateEvent.LocatorStateMergePatched e = newLocatorStateMergePatched(stateEventId);
        ((AbstractLocatorStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorStateEvent.LocatorStateDeleted newLocatorStateDeleted(String commandId, String requesterId) {
        LocatorStateEventId stateEventId = new LocatorStateEventId(this.state.getLocatorId(), this.state.getVersion());
        LocatorStateEvent.LocatorStateDeleted e = newLocatorStateDeleted(stateEventId);
        ((AbstractLocatorStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorStateEvent.LocatorStateCreated newLocatorStateCreated(LocatorStateEventId stateEventId) {
        return new AbstractLocatorStateEvent.SimpleLocatorStateCreated(stateEventId);
    }

    protected LocatorStateEvent.LocatorStateMergePatched newLocatorStateMergePatched(LocatorStateEventId stateEventId) {
        return new AbstractLocatorStateEvent.SimpleLocatorStateMergePatched(stateEventId);
    }

    protected LocatorStateEvent.LocatorStateDeleted newLocatorStateDeleted(LocatorStateEventId stateEventId)
    {
        return new AbstractLocatorStateEvent.SimpleLocatorStateDeleted(stateEventId);
    }

    public static class SimpleLocatorAggregate extends AbstractLocatorAggregate
    {
        public SimpleLocatorAggregate(LocatorState state) {
            super(state);
        }

    }

}

