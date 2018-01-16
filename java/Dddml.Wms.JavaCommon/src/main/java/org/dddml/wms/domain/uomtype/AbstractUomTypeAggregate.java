package org.dddml.wms.domain.uomtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomTypeAggregate extends AbstractAggregate implements UomTypeAggregate
{
    private UomTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractUomTypeAggregate(UomTypeState state)
    {
        this.state = state;
    }

    public UomTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(UomTypeCommand.CreateUomType c)
    {
        if (c.getVersion() == null) { c.setVersion(UomTypeState.VERSION_NULL); }
        UomTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(UomTypeCommand.MergePatchUomType c)
    {
        UomTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(UomTypeCommand.DeleteUomType c)
    {
        UomTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        UomTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected UomTypeStateEvent map(UomTypeCommand.CreateUomType c) {
        UomTypeStateEventId stateEventId = new UomTypeStateEventId(c.getUomTypeId(), c.getVersion());
        UomTypeStateEvent.UomTypeStateCreated e = newUomTypeStateCreated(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractUomTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomTypeStateEvent map(UomTypeCommand.MergePatchUomType c) {
        UomTypeStateEventId stateEventId = new UomTypeStateEventId(c.getUomTypeId(), c.getVersion());
        UomTypeStateEvent.UomTypeStateMergePatched e = newUomTypeStateMergePatched(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyParentTypeIdRemoved(c.getIsPropertyParentTypeIdRemoved());
        e.setIsPropertyHasTableRemoved(c.getIsPropertyHasTableRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractUomTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomTypeStateEvent map(UomTypeCommand.DeleteUomType c) {
        UomTypeStateEventId stateEventId = new UomTypeStateEventId(c.getUomTypeId(), c.getVersion());
        UomTypeStateEvent.UomTypeStateDeleted e = newUomTypeStateDeleted(stateEventId);
        ((AbstractUomTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected UomTypeStateEvent.UomTypeStateCreated newUomTypeStateCreated(Long version, String commandId, String requesterId) {
        UomTypeStateEventId stateEventId = new UomTypeStateEventId(this.state.getUomTypeId(), version);
        UomTypeStateEvent.UomTypeStateCreated e = newUomTypeStateCreated(stateEventId);
        ((AbstractUomTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomTypeStateEvent.UomTypeStateMergePatched newUomTypeStateMergePatched(Long version, String commandId, String requesterId) {
        UomTypeStateEventId stateEventId = new UomTypeStateEventId(this.state.getUomTypeId(), version);
        UomTypeStateEvent.UomTypeStateMergePatched e = newUomTypeStateMergePatched(stateEventId);
        ((AbstractUomTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomTypeStateEvent.UomTypeStateDeleted newUomTypeStateDeleted(Long version, String commandId, String requesterId) {
        UomTypeStateEventId stateEventId = new UomTypeStateEventId(this.state.getUomTypeId(), version);
        UomTypeStateEvent.UomTypeStateDeleted e = newUomTypeStateDeleted(stateEventId);
        ((AbstractUomTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomTypeStateEvent.UomTypeStateCreated newUomTypeStateCreated(UomTypeStateEventId stateEventId) {
        return new AbstractUomTypeStateEvent.SimpleUomTypeStateCreated(stateEventId);
    }

    protected UomTypeStateEvent.UomTypeStateMergePatched newUomTypeStateMergePatched(UomTypeStateEventId stateEventId) {
        return new AbstractUomTypeStateEvent.SimpleUomTypeStateMergePatched(stateEventId);
    }

    protected UomTypeStateEvent.UomTypeStateDeleted newUomTypeStateDeleted(UomTypeStateEventId stateEventId)
    {
        return new AbstractUomTypeStateEvent.SimpleUomTypeStateDeleted(stateEventId);
    }

    public static class SimpleUomTypeAggregate extends AbstractUomTypeAggregate
    {
        public SimpleUomTypeAggregate(UomTypeState state) {
            super(state);
        }

    }

}

