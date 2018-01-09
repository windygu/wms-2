package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageTypeAggregate extends AbstractAggregate implements DamageTypeAggregate
{
    private DamageTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractDamageTypeAggregate(DamageTypeState state)
    {
        this.state = state;
    }

    public DamageTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(DamageTypeCommand.CreateDamageType c)
    {
        if (c.getVersion() == null) { c.setVersion(DamageTypeState.VERSION_NULL); }
        DamageTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(DamageTypeCommand.MergePatchDamageType c)
    {
        DamageTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(DamageTypeCommand.DeleteDamageType c)
    {
        DamageTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        DamageTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected DamageTypeStateEvent map(DamageTypeCommand.CreateDamageType c) {
        DamageTypeStateEventId stateEventId = new DamageTypeStateEventId(c.getDamageTypeId(), c.getVersion());
        DamageTypeStateEvent.DamageTypeStateCreated e = newDamageTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setDefaultHandlingMethodId(c.getDefaultHandlingMethodId());
        e.setActive(c.getActive());
        ((AbstractDamageTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageTypeStateEvent map(DamageTypeCommand.MergePatchDamageType c) {
        DamageTypeStateEventId stateEventId = new DamageTypeStateEventId(c.getDamageTypeId(), c.getVersion());
        DamageTypeStateEvent.DamageTypeStateMergePatched e = newDamageTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceId(c.getSequenceId());
        e.setDefaultHandlingMethodId(c.getDefaultHandlingMethodId());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertySequenceIdRemoved(c.getIsPropertySequenceIdRemoved());
        e.setIsPropertyDefaultHandlingMethodIdRemoved(c.getIsPropertyDefaultHandlingMethodIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractDamageTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageTypeStateEvent map(DamageTypeCommand.DeleteDamageType c) {
        DamageTypeStateEventId stateEventId = new DamageTypeStateEventId(c.getDamageTypeId(), c.getVersion());
        DamageTypeStateEvent.DamageTypeStateDeleted e = newDamageTypeStateDeleted(stateEventId);
        ((AbstractDamageTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected DamageTypeStateEvent.DamageTypeStateCreated newDamageTypeStateCreated(Long version, String commandId, String requesterId) {
        DamageTypeStateEventId stateEventId = new DamageTypeStateEventId(this.state.getDamageTypeId(), version);
        DamageTypeStateEvent.DamageTypeStateCreated e = newDamageTypeStateCreated(stateEventId);
        ((AbstractDamageTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageTypeStateEvent.DamageTypeStateMergePatched newDamageTypeStateMergePatched(Long version, String commandId, String requesterId) {
        DamageTypeStateEventId stateEventId = new DamageTypeStateEventId(this.state.getDamageTypeId(), version);
        DamageTypeStateEvent.DamageTypeStateMergePatched e = newDamageTypeStateMergePatched(stateEventId);
        ((AbstractDamageTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageTypeStateEvent.DamageTypeStateDeleted newDamageTypeStateDeleted(Long version, String commandId, String requesterId) {
        DamageTypeStateEventId stateEventId = new DamageTypeStateEventId(this.state.getDamageTypeId(), version);
        DamageTypeStateEvent.DamageTypeStateDeleted e = newDamageTypeStateDeleted(stateEventId);
        ((AbstractDamageTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DamageTypeStateEvent.DamageTypeStateCreated newDamageTypeStateCreated(DamageTypeStateEventId stateEventId) {
        return new AbstractDamageTypeStateEvent.SimpleDamageTypeStateCreated(stateEventId);
    }

    protected DamageTypeStateEvent.DamageTypeStateMergePatched newDamageTypeStateMergePatched(DamageTypeStateEventId stateEventId) {
        return new AbstractDamageTypeStateEvent.SimpleDamageTypeStateMergePatched(stateEventId);
    }

    protected DamageTypeStateEvent.DamageTypeStateDeleted newDamageTypeStateDeleted(DamageTypeStateEventId stateEventId)
    {
        return new AbstractDamageTypeStateEvent.SimpleDamageTypeStateDeleted(stateEventId);
    }

    public static class SimpleDamageTypeAggregate extends AbstractDamageTypeAggregate
    {
        public SimpleDamageTypeAggregate(DamageTypeState state) {
            super(state);
        }

    }

}

