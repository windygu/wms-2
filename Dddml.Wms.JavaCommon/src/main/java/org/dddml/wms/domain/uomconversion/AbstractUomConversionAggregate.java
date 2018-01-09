package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomConversionAggregate extends AbstractAggregate implements UomConversionAggregate
{
    private UomConversionState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractUomConversionAggregate(UomConversionState state)
    {
        this.state = state;
    }

    public UomConversionState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(UomConversionCommand.CreateUomConversion c)
    {
        if (c.getVersion() == null) { c.setVersion(UomConversionState.VERSION_NULL); }
        UomConversionStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(UomConversionCommand.MergePatchUomConversion c)
    {
        UomConversionStateEvent e = map(c);
        apply(e);
    }

    public void delete(UomConversionCommand.DeleteUomConversion c)
    {
        UomConversionStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        UomConversionCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected UomConversionStateEvent map(UomConversionCommand.CreateUomConversion c) {
        UomConversionStateEventId stateEventId = new UomConversionStateEventId(c.getUomConversionId(), c.getVersion());
        UomConversionStateEvent.UomConversionStateCreated e = newUomConversionStateCreated(stateEventId);
        e.setConversionFactor(c.getConversionFactor());
        e.setCustomMethodId(c.getCustomMethodId());
        e.setDecimalScale(c.getDecimalScale());
        e.setRoundingMode(c.getRoundingMode());
        e.setActive(c.getActive());
        ((AbstractUomConversionStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionStateEvent map(UomConversionCommand.MergePatchUomConversion c) {
        UomConversionStateEventId stateEventId = new UomConversionStateEventId(c.getUomConversionId(), c.getVersion());
        UomConversionStateEvent.UomConversionStateMergePatched e = newUomConversionStateMergePatched(stateEventId);
        e.setConversionFactor(c.getConversionFactor());
        e.setCustomMethodId(c.getCustomMethodId());
        e.setDecimalScale(c.getDecimalScale());
        e.setRoundingMode(c.getRoundingMode());
        e.setActive(c.getActive());
        e.setIsPropertyConversionFactorRemoved(c.getIsPropertyConversionFactorRemoved());
        e.setIsPropertyCustomMethodIdRemoved(c.getIsPropertyCustomMethodIdRemoved());
        e.setIsPropertyDecimalScaleRemoved(c.getIsPropertyDecimalScaleRemoved());
        e.setIsPropertyRoundingModeRemoved(c.getIsPropertyRoundingModeRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractUomConversionStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionStateEvent map(UomConversionCommand.DeleteUomConversion c) {
        UomConversionStateEventId stateEventId = new UomConversionStateEventId(c.getUomConversionId(), c.getVersion());
        UomConversionStateEvent.UomConversionStateDeleted e = newUomConversionStateDeleted(stateEventId);
        ((AbstractUomConversionStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected UomConversionStateEvent.UomConversionStateCreated newUomConversionStateCreated(Long version, String commandId, String requesterId) {
        UomConversionStateEventId stateEventId = new UomConversionStateEventId(this.state.getUomConversionId(), version);
        UomConversionStateEvent.UomConversionStateCreated e = newUomConversionStateCreated(stateEventId);
        ((AbstractUomConversionStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionStateEvent.UomConversionStateMergePatched newUomConversionStateMergePatched(Long version, String commandId, String requesterId) {
        UomConversionStateEventId stateEventId = new UomConversionStateEventId(this.state.getUomConversionId(), version);
        UomConversionStateEvent.UomConversionStateMergePatched e = newUomConversionStateMergePatched(stateEventId);
        ((AbstractUomConversionStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionStateEvent.UomConversionStateDeleted newUomConversionStateDeleted(Long version, String commandId, String requesterId) {
        UomConversionStateEventId stateEventId = new UomConversionStateEventId(this.state.getUomConversionId(), version);
        UomConversionStateEvent.UomConversionStateDeleted e = newUomConversionStateDeleted(stateEventId);
        ((AbstractUomConversionStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionStateEvent.UomConversionStateCreated newUomConversionStateCreated(UomConversionStateEventId stateEventId) {
        return new AbstractUomConversionStateEvent.SimpleUomConversionStateCreated(stateEventId);
    }

    protected UomConversionStateEvent.UomConversionStateMergePatched newUomConversionStateMergePatched(UomConversionStateEventId stateEventId) {
        return new AbstractUomConversionStateEvent.SimpleUomConversionStateMergePatched(stateEventId);
    }

    protected UomConversionStateEvent.UomConversionStateDeleted newUomConversionStateDeleted(UomConversionStateEventId stateEventId)
    {
        return new AbstractUomConversionStateEvent.SimpleUomConversionStateDeleted(stateEventId);
    }

    public static class SimpleUomConversionAggregate extends AbstractUomConversionAggregate
    {
        public SimpleUomConversionAggregate(UomConversionState state) {
            super(state);
        }

    }

}

