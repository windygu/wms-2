package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomAggregate extends AbstractAggregate implements UomAggregate
{
    private UomState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractUomAggregate(UomState state)
    {
        this.state = state;
    }

    public UomState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(UomCommand.CreateUom c)
    {
        if (c.getVersion() == null) { c.setVersion(UomState.VERSION_NULL); }
        UomStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(UomCommand.MergePatchUom c)
    {
        UomStateEvent e = map(c);
        apply(e);
    }

    public void delete(UomCommand.DeleteUom c)
    {
        UomStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        UomCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected UomStateEvent map(UomCommand.CreateUom c) {
        UomStateEventId stateEventId = new UomStateEventId(c.getUomId(), c.getVersion());
        UomStateEvent.UomStateCreated e = newUomStateCreated(stateEventId);
        e.setUomTypeId(c.getUomTypeId());
        e.setAbbreviation(c.getAbbreviation());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractUomStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomStateEvent map(UomCommand.MergePatchUom c) {
        UomStateEventId stateEventId = new UomStateEventId(c.getUomId(), c.getVersion());
        UomStateEvent.UomStateMergePatched e = newUomStateMergePatched(stateEventId);
        e.setUomTypeId(c.getUomTypeId());
        e.setAbbreviation(c.getAbbreviation());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyUomTypeIdRemoved(c.getIsPropertyUomTypeIdRemoved());
        e.setIsPropertyAbbreviationRemoved(c.getIsPropertyAbbreviationRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractUomStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomStateEvent map(UomCommand.DeleteUom c) {
        UomStateEventId stateEventId = new UomStateEventId(c.getUomId(), c.getVersion());
        UomStateEvent.UomStateDeleted e = newUomStateDeleted(stateEventId);
        ((AbstractUomStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected UomStateEvent.UomStateCreated newUomStateCreated(String commandId, String requesterId) {
        UomStateEventId stateEventId = new UomStateEventId(this.state.getUomId(), this.state.getVersion());
        UomStateEvent.UomStateCreated e = newUomStateCreated(stateEventId);
        ((AbstractUomStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomStateEvent.UomStateMergePatched newUomStateMergePatched(String commandId, String requesterId) {
        UomStateEventId stateEventId = new UomStateEventId(this.state.getUomId(), this.state.getVersion());
        UomStateEvent.UomStateMergePatched e = newUomStateMergePatched(stateEventId);
        ((AbstractUomStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomStateEvent.UomStateDeleted newUomStateDeleted(String commandId, String requesterId) {
        UomStateEventId stateEventId = new UomStateEventId(this.state.getUomId(), this.state.getVersion());
        UomStateEvent.UomStateDeleted e = newUomStateDeleted(stateEventId);
        ((AbstractUomStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomStateEvent.UomStateCreated newUomStateCreated(UomStateEventId stateEventId) {
        return new AbstractUomStateEvent.SimpleUomStateCreated(stateEventId);
    }

    protected UomStateEvent.UomStateMergePatched newUomStateMergePatched(UomStateEventId stateEventId) {
        return new AbstractUomStateEvent.SimpleUomStateMergePatched(stateEventId);
    }

    protected UomStateEvent.UomStateDeleted newUomStateDeleted(UomStateEventId stateEventId)
    {
        return new AbstractUomStateEvent.SimpleUomStateDeleted(stateEventId);
    }


    public static class SimpleUomAggregate extends AbstractUomAggregate
    {
        public SimpleUomAggregate(UomState state) {
            super(state);
        }

    }

}

