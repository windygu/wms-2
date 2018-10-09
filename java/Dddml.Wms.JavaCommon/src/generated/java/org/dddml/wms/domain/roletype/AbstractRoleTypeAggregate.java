package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractRoleTypeAggregate extends AbstractAggregate implements RoleTypeAggregate
{
    private RoleTypeState.MutableRoleTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractRoleTypeAggregate(RoleTypeState state)
    {
        this.state = (RoleTypeState.MutableRoleTypeState)state;
    }

    public RoleTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(RoleTypeCommand.CreateRoleType c)
    {
        if (c.getVersion() == null) { c.setVersion(RoleTypeState.VERSION_NULL); }
        RoleTypeEvent e = map(c);
        apply(e);
    }

    public void mergePatch(RoleTypeCommand.MergePatchRoleType c)
    {
        RoleTypeEvent e = map(c);
        apply(e);
    }

    public void delete(RoleTypeCommand.DeleteRoleType c)
    {
        RoleTypeEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        RoleTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected RoleTypeEvent map(RoleTypeCommand.CreateRoleType c) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(c.getRoleTypeId(), c.getVersion());
        RoleTypeEvent.RoleTypeStateCreated e = newRoleTypeStateCreated(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractRoleTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeEvent map(RoleTypeCommand.MergePatchRoleType c) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(c.getRoleTypeId(), c.getVersion());
        RoleTypeEvent.RoleTypeStateMergePatched e = newRoleTypeStateMergePatched(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyParentTypeIdRemoved(c.getIsPropertyParentTypeIdRemoved());
        e.setIsPropertyHasTableRemoved(c.getIsPropertyHasTableRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractRoleTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeEvent map(RoleTypeCommand.DeleteRoleType c) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(c.getRoleTypeId(), c.getVersion());
        RoleTypeEvent.RoleTypeStateDeleted e = newRoleTypeStateDeleted(stateEventId);
        ((AbstractRoleTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected RoleTypeEvent.RoleTypeStateCreated newRoleTypeStateCreated(Long version, String commandId, String requesterId) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(this.state.getRoleTypeId(), version);
        RoleTypeEvent.RoleTypeStateCreated e = newRoleTypeStateCreated(stateEventId);
        ((AbstractRoleTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeEvent.RoleTypeStateMergePatched newRoleTypeStateMergePatched(Long version, String commandId, String requesterId) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(this.state.getRoleTypeId(), version);
        RoleTypeEvent.RoleTypeStateMergePatched e = newRoleTypeStateMergePatched(stateEventId);
        ((AbstractRoleTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeEvent.RoleTypeStateDeleted newRoleTypeStateDeleted(Long version, String commandId, String requesterId) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(this.state.getRoleTypeId(), version);
        RoleTypeEvent.RoleTypeStateDeleted e = newRoleTypeStateDeleted(stateEventId);
        ((AbstractRoleTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeEvent.RoleTypeStateCreated newRoleTypeStateCreated(RoleTypeEventId stateEventId) {
        return new AbstractRoleTypeEvent.SimpleRoleTypeStateCreated(stateEventId);
    }

    protected RoleTypeEvent.RoleTypeStateMergePatched newRoleTypeStateMergePatched(RoleTypeEventId stateEventId) {
        return new AbstractRoleTypeEvent.SimpleRoleTypeStateMergePatched(stateEventId);
    }

    protected RoleTypeEvent.RoleTypeStateDeleted newRoleTypeStateDeleted(RoleTypeEventId stateEventId)
    {
        return new AbstractRoleTypeEvent.SimpleRoleTypeStateDeleted(stateEventId);
    }

    public static class SimpleRoleTypeAggregate extends AbstractRoleTypeAggregate
    {
        public SimpleRoleTypeAggregate(RoleTypeState state) {
            super(state);
        }

    }

}

