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
        LocatorEvent e = map(c);
        apply(e);
    }

    public void mergePatch(LocatorCommand.MergePatchLocator c)
    {
        LocatorEvent e = map(c);
        apply(e);
    }

    public void delete(LocatorCommand.DeleteLocator c)
    {
        LocatorEvent e = map(c);
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

    protected LocatorEvent map(LocatorCommand.CreateLocator c) {
        LocatorEventId stateEventId = new LocatorEventId(c.getLocatorId(), c.getVersion());
        LocatorEvent.LocatorStateCreated e = newLocatorStateCreated(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setParentLocatorId(c.getParentLocatorId());
        e.setLocatorType(c.getLocatorType());
        e.setPriorityNumber(c.getPriorityNumber());
        e.setIsDefault(c.getIsDefault());
        e.setX(c.getX());
        e.setY(c.getY());
        e.setZ(c.getZ());
        e.setDescription(c.getDescription());
        e.setLocatorTypeId(c.getLocatorTypeId());
        e.setActive(c.getActive());
        ((AbstractLocatorEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorEvent map(LocatorCommand.MergePatchLocator c) {
        LocatorEventId stateEventId = new LocatorEventId(c.getLocatorId(), c.getVersion());
        LocatorEvent.LocatorStateMergePatched e = newLocatorStateMergePatched(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setParentLocatorId(c.getParentLocatorId());
        e.setLocatorType(c.getLocatorType());
        e.setPriorityNumber(c.getPriorityNumber());
        e.setIsDefault(c.getIsDefault());
        e.setX(c.getX());
        e.setY(c.getY());
        e.setZ(c.getZ());
        e.setDescription(c.getDescription());
        e.setLocatorTypeId(c.getLocatorTypeId());
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
        e.setIsPropertyLocatorTypeIdRemoved(c.getIsPropertyLocatorTypeIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractLocatorEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorEvent map(LocatorCommand.DeleteLocator c) {
        LocatorEventId stateEventId = new LocatorEventId(c.getLocatorId(), c.getVersion());
        LocatorEvent.LocatorStateDeleted e = newLocatorStateDeleted(stateEventId);
        ((AbstractLocatorEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected LocatorEvent.LocatorStateCreated newLocatorStateCreated(Long version, String commandId, String requesterId) {
        LocatorEventId stateEventId = new LocatorEventId(this.state.getLocatorId(), version);
        LocatorEvent.LocatorStateCreated e = newLocatorStateCreated(stateEventId);
        ((AbstractLocatorEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorEvent.LocatorStateMergePatched newLocatorStateMergePatched(Long version, String commandId, String requesterId) {
        LocatorEventId stateEventId = new LocatorEventId(this.state.getLocatorId(), version);
        LocatorEvent.LocatorStateMergePatched e = newLocatorStateMergePatched(stateEventId);
        ((AbstractLocatorEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorEvent.LocatorStateDeleted newLocatorStateDeleted(Long version, String commandId, String requesterId) {
        LocatorEventId stateEventId = new LocatorEventId(this.state.getLocatorId(), version);
        LocatorEvent.LocatorStateDeleted e = newLocatorStateDeleted(stateEventId);
        ((AbstractLocatorEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LocatorEvent.LocatorStateCreated newLocatorStateCreated(LocatorEventId stateEventId) {
        return new AbstractLocatorEvent.SimpleLocatorStateCreated(stateEventId);
    }

    protected LocatorEvent.LocatorStateMergePatched newLocatorStateMergePatched(LocatorEventId stateEventId) {
        return new AbstractLocatorEvent.SimpleLocatorStateMergePatched(stateEventId);
    }

    protected LocatorEvent.LocatorStateDeleted newLocatorStateDeleted(LocatorEventId stateEventId)
    {
        return new AbstractLocatorEvent.SimpleLocatorStateDeleted(stateEventId);
    }

    public static class SimpleLocatorAggregate extends AbstractLocatorAggregate
    {
        public SimpleLocatorAggregate(LocatorState state) {
            super(state);
        }

    }

}

