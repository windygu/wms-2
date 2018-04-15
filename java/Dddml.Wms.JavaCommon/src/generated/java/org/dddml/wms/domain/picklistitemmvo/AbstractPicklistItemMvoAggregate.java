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
        PicklistItemMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistItemMvoCommand.MergePatchPicklistItemMvo c)
    {
        PicklistItemMvoEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistItemMvoCommand.DeletePicklistItemMvo c)
    {
        PicklistItemMvoEvent e = map(c);
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

    protected PicklistItemMvoEvent map(PicklistItemMvoCommand.CreatePicklistItemMvo c) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(c.getPicklistBinPicklistItemId(), c.getPicklistBinVersion());
        PicklistItemMvoEvent.PicklistItemMvoStateCreated e = newPicklistItemMvoStateCreated(stateEventId);
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
        ((AbstractPicklistItemMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoEvent map(PicklistItemMvoCommand.MergePatchPicklistItemMvo c) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(c.getPicklistBinPicklistItemId(), c.getPicklistBinVersion());
        PicklistItemMvoEvent.PicklistItemMvoStateMergePatched e = newPicklistItemMvoStateMergePatched(stateEventId);
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
        ((AbstractPicklistItemMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoEvent map(PicklistItemMvoCommand.DeletePicklistItemMvo c) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(c.getPicklistBinPicklistItemId(), c.getPicklistBinVersion());
        PicklistItemMvoEvent.PicklistItemMvoStateDeleted e = newPicklistItemMvoStateDeleted(stateEventId);
        ((AbstractPicklistItemMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PicklistItemMvoEvent.PicklistItemMvoStateCreated newPicklistItemMvoStateCreated(Long version, String commandId, String requesterId) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(this.state.getPicklistBinPicklistItemId(), version);
        PicklistItemMvoEvent.PicklistItemMvoStateCreated e = newPicklistItemMvoStateCreated(stateEventId);
        ((AbstractPicklistItemMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoEvent.PicklistItemMvoStateMergePatched newPicklistItemMvoStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(this.state.getPicklistBinPicklistItemId(), version);
        PicklistItemMvoEvent.PicklistItemMvoStateMergePatched e = newPicklistItemMvoStateMergePatched(stateEventId);
        ((AbstractPicklistItemMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoEvent.PicklistItemMvoStateDeleted newPicklistItemMvoStateDeleted(Long version, String commandId, String requesterId) {
        PicklistItemMvoEventId stateEventId = new PicklistItemMvoEventId(this.state.getPicklistBinPicklistItemId(), version);
        PicklistItemMvoEvent.PicklistItemMvoStateDeleted e = newPicklistItemMvoStateDeleted(stateEventId);
        ((AbstractPicklistItemMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistItemMvoEvent.PicklistItemMvoStateCreated newPicklistItemMvoStateCreated(PicklistItemMvoEventId stateEventId) {
        return new AbstractPicklistItemMvoEvent.SimplePicklistItemMvoStateCreated(stateEventId);
    }

    protected PicklistItemMvoEvent.PicklistItemMvoStateMergePatched newPicklistItemMvoStateMergePatched(PicklistItemMvoEventId stateEventId) {
        return new AbstractPicklistItemMvoEvent.SimplePicklistItemMvoStateMergePatched(stateEventId);
    }

    protected PicklistItemMvoEvent.PicklistItemMvoStateDeleted newPicklistItemMvoStateDeleted(PicklistItemMvoEventId stateEventId)
    {
        return new AbstractPicklistItemMvoEvent.SimplePicklistItemMvoStateDeleted(stateEventId);
    }

    public static class SimplePicklistItemMvoAggregate extends AbstractPicklistItemMvoAggregate
    {
        public SimplePicklistItemMvoAggregate(PicklistItemMvoState state) {
            super(state);
        }

    }

}

