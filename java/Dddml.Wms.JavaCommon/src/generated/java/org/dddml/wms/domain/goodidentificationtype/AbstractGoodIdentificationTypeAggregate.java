package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractGoodIdentificationTypeAggregate extends AbstractAggregate implements GoodIdentificationTypeAggregate
{
    private GoodIdentificationTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractGoodIdentificationTypeAggregate(GoodIdentificationTypeState state)
    {
        this.state = state;
    }

    public GoodIdentificationTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(GoodIdentificationTypeCommand.CreateGoodIdentificationType c)
    {
        if (c.getVersion() == null) { c.setVersion(GoodIdentificationTypeState.VERSION_NULL); }
        GoodIdentificationTypeEvent e = map(c);
        apply(e);
    }

    public void mergePatch(GoodIdentificationTypeCommand.MergePatchGoodIdentificationType c)
    {
        GoodIdentificationTypeEvent e = map(c);
        apply(e);
    }

    public void delete(GoodIdentificationTypeCommand.DeleteGoodIdentificationType c)
    {
        GoodIdentificationTypeEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        GoodIdentificationTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected GoodIdentificationTypeEvent map(GoodIdentificationTypeCommand.CreateGoodIdentificationType c) {
        GoodIdentificationTypeEventId stateEventId = new GoodIdentificationTypeEventId(c.getGoodIdentificationTypeId(), c.getVersion());
        GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated e = newGoodIdentificationTypeStateCreated(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractGoodIdentificationTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationTypeEvent map(GoodIdentificationTypeCommand.MergePatchGoodIdentificationType c) {
        GoodIdentificationTypeEventId stateEventId = new GoodIdentificationTypeEventId(c.getGoodIdentificationTypeId(), c.getVersion());
        GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched e = newGoodIdentificationTypeStateMergePatched(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyParentTypeIdRemoved(c.getIsPropertyParentTypeIdRemoved());
        e.setIsPropertyHasTableRemoved(c.getIsPropertyHasTableRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractGoodIdentificationTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationTypeEvent map(GoodIdentificationTypeCommand.DeleteGoodIdentificationType c) {
        GoodIdentificationTypeEventId stateEventId = new GoodIdentificationTypeEventId(c.getGoodIdentificationTypeId(), c.getVersion());
        GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted e = newGoodIdentificationTypeStateDeleted(stateEventId);
        ((AbstractGoodIdentificationTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated newGoodIdentificationTypeStateCreated(Long version, String commandId, String requesterId) {
        GoodIdentificationTypeEventId stateEventId = new GoodIdentificationTypeEventId(this.state.getGoodIdentificationTypeId(), version);
        GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated e = newGoodIdentificationTypeStateCreated(stateEventId);
        ((AbstractGoodIdentificationTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched newGoodIdentificationTypeStateMergePatched(Long version, String commandId, String requesterId) {
        GoodIdentificationTypeEventId stateEventId = new GoodIdentificationTypeEventId(this.state.getGoodIdentificationTypeId(), version);
        GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched e = newGoodIdentificationTypeStateMergePatched(stateEventId);
        ((AbstractGoodIdentificationTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted newGoodIdentificationTypeStateDeleted(Long version, String commandId, String requesterId) {
        GoodIdentificationTypeEventId stateEventId = new GoodIdentificationTypeEventId(this.state.getGoodIdentificationTypeId(), version);
        GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted e = newGoodIdentificationTypeStateDeleted(stateEventId);
        ((AbstractGoodIdentificationTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated newGoodIdentificationTypeStateCreated(GoodIdentificationTypeEventId stateEventId) {
        return new AbstractGoodIdentificationTypeEvent.SimpleGoodIdentificationTypeStateCreated(stateEventId);
    }

    protected GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched newGoodIdentificationTypeStateMergePatched(GoodIdentificationTypeEventId stateEventId) {
        return new AbstractGoodIdentificationTypeEvent.SimpleGoodIdentificationTypeStateMergePatched(stateEventId);
    }

    protected GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted newGoodIdentificationTypeStateDeleted(GoodIdentificationTypeEventId stateEventId)
    {
        return new AbstractGoodIdentificationTypeEvent.SimpleGoodIdentificationTypeStateDeleted(stateEventId);
    }

    public static class SimpleGoodIdentificationTypeAggregate extends AbstractGoodIdentificationTypeAggregate
    {
        public SimpleGoodIdentificationTypeAggregate(GoodIdentificationTypeState state) {
            super(state);
        }

    }

}

