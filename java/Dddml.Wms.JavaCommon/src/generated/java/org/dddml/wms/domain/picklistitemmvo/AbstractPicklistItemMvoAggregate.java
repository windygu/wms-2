package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistItemMvoAggregate extends AbstractAggregate implements PicklistItemMvoAggregate
{
    private PicklistItemMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPicklistItemMvoAggregate(PicklistItemMvoState state)
    {
        this.state = state;
    }

    public PicklistItemMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PicklistItemMvoCommand.CreatePicklistItemMvo c)
    {
        if (c.getPicklistBinVersion() == null) { c.setPicklistBinVersion(PicklistItemMvoState.VERSION_NULL); }
        PicklistItemMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistItemMvoCommand.MergePatchPicklistItemMvo c)
    {
        PicklistItemMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistItemMvoCommand.DeletePicklistItemMvo c)
    {
        PicklistItemMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PicklistItemMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PicklistItemMvoStateEvent map(PicklistItemMvoCommand.CreatePicklistItemMvo c) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(c.getPicklistBinPicklistItemId(), c.getPicklistBinVersion());
        PicklistItemMvoStateEvent.PicklistItemMvoStateCreated e = newPicklistItemMvoStateCreated(stateEventId);
        e.setItemStatusId(c.getItemStatusId());
        e.setQuantity(c.getQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPicklistBinPicklistId(c.getPicklistBinPicklistId());
        e.setPicklistBinBinLocationNumber(c.getPicklistBinBinLocationNumber());
        e.setPicklistBinPrimaryOrderId(c.getPicklistBinPrimaryOrderId());
        e.setPicklistBinPrimaryShipGroupSeqId(c.getPicklistBinPrimaryShipGroupSeqId());
        e.setPicklistBinCreatedBy(c.getPicklistBinCreatedBy());
        e.setPicklistBinCreatedAt(c.getPicklistBinCreatedAt());
        e.setPicklistBinUpdatedBy(c.getPicklistBinUpdatedBy());
        e.setPicklistBinUpdatedAt(c.getPicklistBinUpdatedAt());
        e.setPicklistBinActive(c.getPicklistBinActive());
        e.setPicklistBinDeleted(c.getPicklistBinDeleted());
        ((AbstractPicklistItemMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoStateEvent map(PicklistItemMvoCommand.MergePatchPicklistItemMvo c) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(c.getPicklistBinPicklistItemId(), c.getPicklistBinVersion());
        PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched e = newPicklistItemMvoStateMergePatched(stateEventId);
        e.setItemStatusId(c.getItemStatusId());
        e.setQuantity(c.getQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPicklistBinPicklistId(c.getPicklistBinPicklistId());
        e.setPicklistBinBinLocationNumber(c.getPicklistBinBinLocationNumber());
        e.setPicklistBinPrimaryOrderId(c.getPicklistBinPrimaryOrderId());
        e.setPicklistBinPrimaryShipGroupSeqId(c.getPicklistBinPrimaryShipGroupSeqId());
        e.setPicklistBinCreatedBy(c.getPicklistBinCreatedBy());
        e.setPicklistBinCreatedAt(c.getPicklistBinCreatedAt());
        e.setPicklistBinUpdatedBy(c.getPicklistBinUpdatedBy());
        e.setPicklistBinUpdatedAt(c.getPicklistBinUpdatedAt());
        e.setPicklistBinActive(c.getPicklistBinActive());
        e.setPicklistBinDeleted(c.getPicklistBinDeleted());
        e.setIsPropertyItemStatusIdRemoved(c.getIsPropertyItemStatusIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyPicklistBinPicklistIdRemoved(c.getIsPropertyPicklistBinPicklistIdRemoved());
        e.setIsPropertyPicklistBinBinLocationNumberRemoved(c.getIsPropertyPicklistBinBinLocationNumberRemoved());
        e.setIsPropertyPicklistBinPrimaryOrderIdRemoved(c.getIsPropertyPicklistBinPrimaryOrderIdRemoved());
        e.setIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved(c.getIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved());
        e.setIsPropertyPicklistBinCreatedByRemoved(c.getIsPropertyPicklistBinCreatedByRemoved());
        e.setIsPropertyPicklistBinCreatedAtRemoved(c.getIsPropertyPicklistBinCreatedAtRemoved());
        e.setIsPropertyPicklistBinUpdatedByRemoved(c.getIsPropertyPicklistBinUpdatedByRemoved());
        e.setIsPropertyPicklistBinUpdatedAtRemoved(c.getIsPropertyPicklistBinUpdatedAtRemoved());
        e.setIsPropertyPicklistBinActiveRemoved(c.getIsPropertyPicklistBinActiveRemoved());
        e.setIsPropertyPicklistBinDeletedRemoved(c.getIsPropertyPicklistBinDeletedRemoved());
        ((AbstractPicklistItemMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoStateEvent map(PicklistItemMvoCommand.DeletePicklistItemMvo c) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(c.getPicklistBinPicklistItemId(), c.getPicklistBinVersion());
        PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted e = newPicklistItemMvoStateDeleted(stateEventId);
        ((AbstractPicklistItemMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PicklistItemMvoStateEvent.PicklistItemMvoStateCreated newPicklistItemMvoStateCreated(Long version, String commandId, String requesterId) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(this.state.getPicklistBinPicklistItemId(), version);
        PicklistItemMvoStateEvent.PicklistItemMvoStateCreated e = newPicklistItemMvoStateCreated(stateEventId);
        ((AbstractPicklistItemMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched newPicklistItemMvoStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(this.state.getPicklistBinPicklistItemId(), version);
        PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched e = newPicklistItemMvoStateMergePatched(stateEventId);
        ((AbstractPicklistItemMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted newPicklistItemMvoStateDeleted(Long version, String commandId, String requesterId) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(this.state.getPicklistBinPicklistItemId(), version);
        PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted e = newPicklistItemMvoStateDeleted(stateEventId);
        ((AbstractPicklistItemMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoStateEvent.PicklistItemMvoStateCreated newPicklistItemMvoStateCreated(PicklistItemMvoEventId stateEventId) {
        return new AbstractPicklistItemMvoStateEvent.SimplePicklistItemMvoStateCreated(stateEventId);
    }

    protected PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched newPicklistItemMvoStateMergePatched(PicklistItemMvoEventId stateEventId) {
        return new AbstractPicklistItemMvoStateEvent.SimplePicklistItemMvoStateMergePatched(stateEventId);
    }

    protected PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted newPicklistItemMvoStateDeleted(PicklistItemMvoEventId stateEventId)
    {
        return new AbstractPicklistItemMvoStateEvent.SimplePicklistItemMvoStateDeleted(stateEventId);
    }

    public static class SimplePicklistItemMvoAggregate extends AbstractPicklistItemMvoAggregate
    {
        public SimplePicklistItemMvoAggregate(PicklistItemMvoState state) {
            super(state);
        }

    }

}

