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
        UomEvent e = map(c);
        apply(e);
    }

    public void mergePatch(UomCommand.MergePatchUom c)
    {
        UomEvent e = map(c);
        apply(e);
    }

    public void delete(UomCommand.DeleteUom c)
    {
        UomEvent e = map(c);
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

    protected UomEvent map(UomCommand.CreateUom c) {
        UomEventId stateEventId = new UomEventId(c.getUomId(), c.getVersion());
        UomEvent.UomStateCreated e = newUomStateCreated(stateEventId);
        e.setUomTypeId(c.getUomTypeId());
        e.setAbbreviation(c.getAbbreviation());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractUomEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomEvent map(UomCommand.MergePatchUom c) {
        UomEventId stateEventId = new UomEventId(c.getUomId(), c.getVersion());
        UomEvent.UomStateMergePatched e = newUomStateMergePatched(stateEventId);
        e.setUomTypeId(c.getUomTypeId());
        e.setAbbreviation(c.getAbbreviation());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyUomTypeIdRemoved(c.getIsPropertyUomTypeIdRemoved());
        e.setIsPropertyAbbreviationRemoved(c.getIsPropertyAbbreviationRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractUomEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomEvent map(UomCommand.DeleteUom c) {
        UomEventId stateEventId = new UomEventId(c.getUomId(), c.getVersion());
        UomEvent.UomStateDeleted e = newUomStateDeleted(stateEventId);
        ((AbstractUomEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected UomEvent.UomStateCreated newUomStateCreated(Long version, String commandId, String requesterId) {
        UomEventId stateEventId = new UomEventId(this.state.getUomId(), version);
        UomEvent.UomStateCreated e = newUomStateCreated(stateEventId);
        ((AbstractUomEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomEvent.UomStateMergePatched newUomStateMergePatched(Long version, String commandId, String requesterId) {
        UomEventId stateEventId = new UomEventId(this.state.getUomId(), version);
        UomEvent.UomStateMergePatched e = newUomStateMergePatched(stateEventId);
        ((AbstractUomEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomEvent.UomStateDeleted newUomStateDeleted(Long version, String commandId, String requesterId) {
        UomEventId stateEventId = new UomEventId(this.state.getUomId(), version);
        UomEvent.UomStateDeleted e = newUomStateDeleted(stateEventId);
        ((AbstractUomEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomEvent.UomStateCreated newUomStateCreated(UomEventId stateEventId) {
        return new AbstractUomEvent.SimpleUomStateCreated(stateEventId);
    }

    protected UomEvent.UomStateMergePatched newUomStateMergePatched(UomEventId stateEventId) {
        return new AbstractUomEvent.SimpleUomStateMergePatched(stateEventId);
    }

    protected UomEvent.UomStateDeleted newUomStateDeleted(UomEventId stateEventId)
    {
        return new AbstractUomEvent.SimpleUomStateDeleted(stateEventId);
    }

    public static class SimpleUomAggregate extends AbstractUomAggregate
    {
        public SimpleUomAggregate(UomState state) {
            super(state);
        }

    }

}

