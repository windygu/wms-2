package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageHandlingMethodAggregate extends AbstractAggregate implements DamageHandlingMethodAggregate
{
    private DamageHandlingMethodState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractDamageHandlingMethodAggregate(DamageHandlingMethodState state)
    {
        this.state = state;
    }

    public DamageHandlingMethodState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(DamageHandlingMethodCommand.CreateDamageHandlingMethod c)
    {
        if (c.getVersion() == null) { c.setVersion(DamageHandlingMethodState.VERSION_NULL); }
        DamageHandlingMethodStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(DamageHandlingMethodCommand.MergePatchDamageHandlingMethod c)
    {
        DamageHandlingMethodStateEvent e = map(c);
        apply(e);
    }

    public void delete(DamageHandlingMethodCommand.DeleteDamageHandlingMethod c)
    {
        DamageHandlingMethodStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        DamageHandlingMethodCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected DamageHandlingMethodStateEvent map(DamageHandlingMethodCommand.CreateDamageHandlingMethod c) {
        DamageHandlingMethodStateEventId stateEventId = new DamageHandlingMethodStateEventId(c.getDamageHandlingMethodId(), c.getVersion());
        DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated e = newDamageHandlingMethodStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setActive(c.getActive());
        ((AbstractDamageHandlingMethodStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageHandlingMethodStateEvent map(DamageHandlingMethodCommand.MergePatchDamageHandlingMethod c) {
        DamageHandlingMethodStateEventId stateEventId = new DamageHandlingMethodStateEventId(c.getDamageHandlingMethodId(), c.getVersion());
        DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched e = newDamageHandlingMethodStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertySequenceIdRemoved(c.getIsPropertySequenceIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractDamageHandlingMethodStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageHandlingMethodStateEvent map(DamageHandlingMethodCommand.DeleteDamageHandlingMethod c) {
        DamageHandlingMethodStateEventId stateEventId = new DamageHandlingMethodStateEventId(c.getDamageHandlingMethodId(), c.getVersion());
        DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted e = newDamageHandlingMethodStateDeleted(stateEventId);
        ((AbstractDamageHandlingMethodStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated newDamageHandlingMethodStateCreated(String commandId, String requesterId) {
        DamageHandlingMethodStateEventId stateEventId = new DamageHandlingMethodStateEventId(this.state.getDamageHandlingMethodId(), this.state.getVersion());
        DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated e = newDamageHandlingMethodStateCreated(stateEventId);
        ((AbstractDamageHandlingMethodStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched newDamageHandlingMethodStateMergePatched(String commandId, String requesterId) {
        DamageHandlingMethodStateEventId stateEventId = new DamageHandlingMethodStateEventId(this.state.getDamageHandlingMethodId(), this.state.getVersion());
        DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched e = newDamageHandlingMethodStateMergePatched(stateEventId);
        ((AbstractDamageHandlingMethodStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted newDamageHandlingMethodStateDeleted(String commandId, String requesterId) {
        DamageHandlingMethodStateEventId stateEventId = new DamageHandlingMethodStateEventId(this.state.getDamageHandlingMethodId(), this.state.getVersion());
        DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted e = newDamageHandlingMethodStateDeleted(stateEventId);
        ((AbstractDamageHandlingMethodStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated newDamageHandlingMethodStateCreated(DamageHandlingMethodStateEventId stateEventId) {
        return new AbstractDamageHandlingMethodStateEvent.SimpleDamageHandlingMethodStateCreated(stateEventId);
    }

    protected DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched newDamageHandlingMethodStateMergePatched(DamageHandlingMethodStateEventId stateEventId) {
        return new AbstractDamageHandlingMethodStateEvent.SimpleDamageHandlingMethodStateMergePatched(stateEventId);
    }

    protected DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted newDamageHandlingMethodStateDeleted(DamageHandlingMethodStateEventId stateEventId)
    {
        return new AbstractDamageHandlingMethodStateEvent.SimpleDamageHandlingMethodStateDeleted(stateEventId);
    }

    public static class SimpleDamageHandlingMethodAggregate extends AbstractDamageHandlingMethodAggregate
    {
        public SimpleDamageHandlingMethodAggregate(DamageHandlingMethodState state) {
            super(state);
        }

    }

}

