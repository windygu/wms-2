package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractRoleTypeAggregate extends AbstractAggregate implements RoleTypeAggregate
{
    private RoleTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractRoleTypeAggregate(RoleTypeState state)
    {
        this.state = state;
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
        RoleTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(RoleTypeCommand.MergePatchRoleType c)
    {
        RoleTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(RoleTypeCommand.DeleteRoleType c)
    {
        RoleTypeStateEvent e = map(c);
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

    protected RoleTypeStateEvent map(RoleTypeCommand.CreateRoleType c) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(c.getRoleTypeId(), c.getVersion());
        RoleTypeStateEvent.RoleTypeStateCreated e = newRoleTypeStateCreated(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractRoleTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeStateEvent map(RoleTypeCommand.MergePatchRoleType c) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(c.getRoleTypeId(), c.getVersion());
        RoleTypeStateEvent.RoleTypeStateMergePatched e = newRoleTypeStateMergePatched(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyParentTypeIdRemoved(c.getIsPropertyParentTypeIdRemoved());
        e.setIsPropertyHasTableRemoved(c.getIsPropertyHasTableRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractRoleTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeStateEvent map(RoleTypeCommand.DeleteRoleType c) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(c.getRoleTypeId(), c.getVersion());
        RoleTypeStateEvent.RoleTypeStateDeleted e = newRoleTypeStateDeleted(stateEventId);
        ((AbstractRoleTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected RoleTypeStateEvent.RoleTypeStateCreated newRoleTypeStateCreated(Long version, String commandId, String requesterId) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(this.state.getRoleTypeId(), version);
        RoleTypeStateEvent.RoleTypeStateCreated e = newRoleTypeStateCreated(stateEventId);
        ((AbstractRoleTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeStateEvent.RoleTypeStateMergePatched newRoleTypeStateMergePatched(Long version, String commandId, String requesterId) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(this.state.getRoleTypeId(), version);
        RoleTypeStateEvent.RoleTypeStateMergePatched e = newRoleTypeStateMergePatched(stateEventId);
        ((AbstractRoleTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeStateEvent.RoleTypeStateDeleted newRoleTypeStateDeleted(Long version, String commandId, String requesterId) {
        RoleTypeEventId stateEventId = new RoleTypeEventId(this.state.getRoleTypeId(), version);
        RoleTypeStateEvent.RoleTypeStateDeleted e = newRoleTypeStateDeleted(stateEventId);
        ((AbstractRoleTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected RoleTypeStateEvent.RoleTypeStateCreated newRoleTypeStateCreated(RoleTypeEventId stateEventId) {
        return new AbstractRoleTypeStateEvent.SimpleRoleTypeStateCreated(stateEventId);
    }

    protected RoleTypeStateEvent.RoleTypeStateMergePatched newRoleTypeStateMergePatched(RoleTypeEventId stateEventId) {
        return new AbstractRoleTypeStateEvent.SimpleRoleTypeStateMergePatched(stateEventId);
    }

    protected RoleTypeStateEvent.RoleTypeStateDeleted newRoleTypeStateDeleted(RoleTypeEventId stateEventId)
    {
        return new AbstractRoleTypeStateEvent.SimpleRoleTypeStateDeleted(stateEventId);
    }

    public static class SimpleRoleTypeAggregate extends AbstractRoleTypeAggregate
    {
        public SimpleRoleTypeAggregate(RoleTypeState state) {
            super(state);
        }

    }

}

