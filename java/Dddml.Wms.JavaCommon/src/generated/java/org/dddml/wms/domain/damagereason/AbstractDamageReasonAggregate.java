package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageReasonAggregate extends AbstractAggregate implements DamageReasonAggregate
{
    private DamageReasonState.MutableDamageReasonState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractDamageReasonAggregate(DamageReasonState state)
    {
        this.state = (DamageReasonState.MutableDamageReasonState)state;
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
        DamageReasonEvent e = map(c);
        apply(e);
    }

    public void mergePatch(DamageReasonCommand.MergePatchDamageReason c)
    {
        DamageReasonEvent e = map(c);
        apply(e);
    }

    public void delete(DamageReasonCommand.DeleteDamageReason c)
    {
        DamageReasonEvent e = map(c);
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

    protected DamageReasonEvent map(DamageReasonCommand.CreateDamageReason c) {
        DamageReasonEventId stateEventId = new DamageReasonEventId(c.getDamageReasonId(), c.getVersion());
        DamageReasonEvent.DamageReasonStateCreated e = newDamageReasonStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setActive(c.getActive());
        ((AbstractDamageReasonEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonEvent map(DamageReasonCommand.MergePatchDamageReason c) {
        DamageReasonEventId stateEventId = new DamageReasonEventId(c.getDamageReasonId(), c.getVersion());
        DamageReasonEvent.DamageReasonStateMergePatched e = newDamageReasonStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertySequenceIdRemoved(c.getIsPropertySequenceIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractDamageReasonEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonEvent map(DamageReasonCommand.DeleteDamageReason c) {
        DamageReasonEventId stateEventId = new DamageReasonEventId(c.getDamageReasonId(), c.getVersion());
        DamageReasonEvent.DamageReasonStateDeleted e = newDamageReasonStateDeleted(stateEventId);
        ((AbstractDamageReasonEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected DamageReasonEvent.DamageReasonStateCreated newDamageReasonStateCreated(Long version, String commandId, String requesterId) {
        DamageReasonEventId stateEventId = new DamageReasonEventId(this.state.getDamageReasonId(), version);
        DamageReasonEvent.DamageReasonStateCreated e = newDamageReasonStateCreated(stateEventId);
        ((AbstractDamageReasonEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonEvent.DamageReasonStateMergePatched newDamageReasonStateMergePatched(Long version, String commandId, String requesterId) {
        DamageReasonEventId stateEventId = new DamageReasonEventId(this.state.getDamageReasonId(), version);
        DamageReasonEvent.DamageReasonStateMergePatched e = newDamageReasonStateMergePatched(stateEventId);
        ((AbstractDamageReasonEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonEvent.DamageReasonStateDeleted newDamageReasonStateDeleted(Long version, String commandId, String requesterId) {
        DamageReasonEventId stateEventId = new DamageReasonEventId(this.state.getDamageReasonId(), version);
        DamageReasonEvent.DamageReasonStateDeleted e = newDamageReasonStateDeleted(stateEventId);
        ((AbstractDamageReasonEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageReasonEvent.DamageReasonStateCreated newDamageReasonStateCreated(DamageReasonEventId stateEventId) {
        return new AbstractDamageReasonEvent.SimpleDamageReasonStateCreated(stateEventId);
    }

    protected DamageReasonEvent.DamageReasonStateMergePatched newDamageReasonStateMergePatched(DamageReasonEventId stateEventId) {
        return new AbstractDamageReasonEvent.SimpleDamageReasonStateMergePatched(stateEventId);
    }

    protected DamageReasonEvent.DamageReasonStateDeleted newDamageReasonStateDeleted(DamageReasonEventId stateEventId)
    {
        return new AbstractDamageReasonEvent.SimpleDamageReasonStateDeleted(stateEventId);
    }

    public static class SimpleDamageReasonAggregate extends AbstractDamageReasonAggregate
    {
        public SimpleDamageReasonAggregate(DamageReasonState state) {
            super(state);
        }

    }

}

