package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageReasonAggregate extends AbstractAggregate implements DamageReasonAggregate
{
    private DamageReasonState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractDamageReasonAggregate(DamageReasonState state)
    {
        this.state = state;
    }

    public DamageReasonState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(DamageReasonCommand.CreateDamageReason c)
    {
        if (c.getVersion() == null) { c.setVersion(DamageReasonState.VERSION_NULL); }
        DamageReasonStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(DamageReasonCommand.MergePatchDamageReason c)
    {
        DamageReasonStateEvent e = map(c);
        apply(e);
    }

    public void delete(DamageReasonCommand.DeleteDamageReason c)
    {
        DamageReasonStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        DamageReasonCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected DamageReasonStateEvent map(DamageReasonCommand.CreateDamageReason c) {
        DamageReasonStateEventId stateEventId = new DamageReasonStateEventId(c.getDamageReasonId(), c.getVersion());
        DamageReasonStateEvent.DamageReasonStateCreated e = newDamageReasonStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setActive(c.getActive());
        ((AbstractDamageReasonStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonStateEvent map(DamageReasonCommand.MergePatchDamageReason c) {
        DamageReasonStateEventId stateEventId = new DamageReasonStateEventId(c.getDamageReasonId(), c.getVersion());
        DamageReasonStateEvent.DamageReasonStateMergePatched e = newDamageReasonStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertySequenceIdRemoved(c.getIsPropertySequenceIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractDamageReasonStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonStateEvent map(DamageReasonCommand.DeleteDamageReason c) {
        DamageReasonStateEventId stateEventId = new DamageReasonStateEventId(c.getDamageReasonId(), c.getVersion());
        DamageReasonStateEvent.DamageReasonStateDeleted e = newDamageReasonStateDeleted(stateEventId);
        ((AbstractDamageReasonStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected DamageReasonStateEvent.DamageReasonStateCreated newDamageReasonStateCreated(String commandId, String requesterId) {
        DamageReasonStateEventId stateEventId = new DamageReasonStateEventId(this.state.getDamageReasonId(), this.state.getVersion());
        DamageReasonStateEvent.DamageReasonStateCreated e = newDamageReasonStateCreated(stateEventId);
        ((AbstractDamageReasonStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonStateEvent.DamageReasonStateMergePatched newDamageReasonStateMergePatched(String commandId, String requesterId) {
        DamageReasonStateEventId stateEventId = new DamageReasonStateEventId(this.state.getDamageReasonId(), this.state.getVersion());
        DamageReasonStateEvent.DamageReasonStateMergePatched e = newDamageReasonStateMergePatched(stateEventId);
        ((AbstractDamageReasonStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonStateEvent.DamageReasonStateDeleted newDamageReasonStateDeleted(String commandId, String requesterId) {
        DamageReasonStateEventId stateEventId = new DamageReasonStateEventId(this.state.getDamageReasonId(), this.state.getVersion());
        DamageReasonStateEvent.DamageReasonStateDeleted e = newDamageReasonStateDeleted(stateEventId);
        ((AbstractDamageReasonStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonStateEvent.DamageReasonStateCreated newDamageReasonStateCreated(DamageReasonStateEventId stateEventId) {
        return new AbstractDamageReasonStateEvent.SimpleDamageReasonStateCreated(stateEventId);
    }

    protected DamageReasonStateEvent.DamageReasonStateMergePatched newDamageReasonStateMergePatched(DamageReasonStateEventId stateEventId) {
        return new AbstractDamageReasonStateEvent.SimpleDamageReasonStateMergePatched(stateEventId);
    }

    protected DamageReasonStateEvent.DamageReasonStateDeleted newDamageReasonStateDeleted(DamageReasonStateEventId stateEventId)
    {
        return new AbstractDamageReasonStateEvent.SimpleDamageReasonStateDeleted(stateEventId);
    }

    public static class SimpleDamageReasonAggregate extends AbstractDamageReasonAggregate
    {
        public SimpleDamageReasonAggregate(DamageReasonState state) {
            super(state);
        }

    }

}

