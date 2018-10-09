package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomConversionAggregate extends AbstractAggregate implements UomConversionAggregate
{
    private UomConversionState.MutableUomConversionState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractUomConversionAggregate(UomConversionState state)
    {
        this.state = (UomConversionState.MutableUomConversionState)state;
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
        UomConversionEvent e = map(c);
        apply(e);
    }

    public void mergePatch(UomConversionCommand.MergePatchUomConversion c)
    {
        UomConversionEvent e = map(c);
        apply(e);
    }

    public void delete(UomConversionCommand.DeleteUomConversion c)
    {
        UomConversionEvent e = map(c);
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

    protected UomConversionEvent map(UomConversionCommand.CreateUomConversion c) {
        UomConversionEventId stateEventId = new UomConversionEventId(c.getUomConversionId(), c.getVersion());
        UomConversionEvent.UomConversionStateCreated e = newUomConversionStateCreated(stateEventId);
        e.setConversionFactor(c.getConversionFactor());
        e.setCustomMethodId(c.getCustomMethodId());
        e.setDecimalScale(c.getDecimalScale());
        e.setRoundingMode(c.getRoundingMode());
        e.setActive(c.getActive());
        ((AbstractUomConversionEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionEvent map(UomConversionCommand.MergePatchUomConversion c) {
        UomConversionEventId stateEventId = new UomConversionEventId(c.getUomConversionId(), c.getVersion());
        UomConversionEvent.UomConversionStateMergePatched e = newUomConversionStateMergePatched(stateEventId);
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
        ((AbstractUomConversionEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionEvent map(UomConversionCommand.DeleteUomConversion c) {
        UomConversionEventId stateEventId = new UomConversionEventId(c.getUomConversionId(), c.getVersion());
        UomConversionEvent.UomConversionStateDeleted e = newUomConversionStateDeleted(stateEventId);
        ((AbstractUomConversionEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected UomConversionEvent.UomConversionStateCreated newUomConversionStateCreated(Long version, String commandId, String requesterId) {
        UomConversionEventId stateEventId = new UomConversionEventId(this.state.getUomConversionId(), version);
        UomConversionEvent.UomConversionStateCreated e = newUomConversionStateCreated(stateEventId);
        ((AbstractUomConversionEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionEvent.UomConversionStateMergePatched newUomConversionStateMergePatched(Long version, String commandId, String requesterId) {
        UomConversionEventId stateEventId = new UomConversionEventId(this.state.getUomConversionId(), version);
        UomConversionEvent.UomConversionStateMergePatched e = newUomConversionStateMergePatched(stateEventId);
        ((AbstractUomConversionEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionEvent.UomConversionStateDeleted newUomConversionStateDeleted(Long version, String commandId, String requesterId) {
        UomConversionEventId stateEventId = new UomConversionEventId(this.state.getUomConversionId(), version);
        UomConversionEvent.UomConversionStateDeleted e = newUomConversionStateDeleted(stateEventId);
        ((AbstractUomConversionEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected UomConversionEvent.UomConversionStateCreated newUomConversionStateCreated(UomConversionEventId stateEventId) {
        return new AbstractUomConversionEvent.SimpleUomConversionStateCreated(stateEventId);
    }

    protected UomConversionEvent.UomConversionStateMergePatched newUomConversionStateMergePatched(UomConversionEventId stateEventId) {
        return new AbstractUomConversionEvent.SimpleUomConversionStateMergePatched(stateEventId);
    }

    protected UomConversionEvent.UomConversionStateDeleted newUomConversionStateDeleted(UomConversionEventId stateEventId)
    {
        return new AbstractUomConversionEvent.SimpleUomConversionStateDeleted(stateEventId);
    }

    public static class SimpleUomConversionAggregate extends AbstractUomConversionAggregate
    {
        public SimpleUomConversionAggregate(UomConversionState state) {
            super(state);
        }

    }

}

