package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementLineMvoAggregate extends AbstractAggregate implements MovementLineMvoAggregate
{
    private MovementLineMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractMovementLineMvoAggregate(MovementLineMvoState state)
    {
        this.state = state;
    }

    public MovementLineMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(MovementLineMvoCommand.CreateMovementLineMvo c)
    {
        if (c.getMovementVersion() == null) { c.setMovementVersion(MovementLineMvoState.VERSION_NULL); }
        MovementLineMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementLineMvoCommand.MergePatchMovementLineMvo c)
    {
        MovementLineMvoEvent e = map(c);
        apply(e);
    }

    public void delete(MovementLineMvoCommand.DeleteMovementLineMvo c)
    {
        MovementLineMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        MovementLineMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected MovementLineMvoEvent map(MovementLineMvoCommand.CreateMovementLineMvo c) {
        MovementLineMvoEventId stateEventId = new MovementLineMvoEventId(c.getMovementLineId(), c.getMovementVersion());
        MovementLineMvoEvent.MovementLineMvoStateCreated e = newMovementLineMvoStateCreated(stateEventId);
        e.setMovementQuantity(c.getMovementQuantity());
        e.setProductId(c.getProductId());
        e.setLocatorIdFrom(c.getLocatorIdFrom());
        e.setLocatorIdTo(c.getLocatorIdTo());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setMovementDocumentStatusId(c.getMovementDocumentStatusId());
        e.setMovementMovementDate(c.getMovementMovementDate());
        e.setMovementPosted(c.getMovementPosted());
        e.setMovementProcessed(c.getMovementProcessed());
        e.setMovementProcessing(c.getMovementProcessing());
        e.setMovementDateReceived(c.getMovementDateReceived());
        e.setMovementDocumentTypeId(c.getMovementDocumentTypeId());
        e.setMovementIsInTransit(c.getMovementIsInTransit());
        e.setMovementIsApproved(c.getMovementIsApproved());
        e.setMovementApprovalAmount(c.getMovementApprovalAmount());
        e.setMovementShipperId(c.getMovementShipperId());
        e.setMovementSalesRepresentativeId(c.getMovementSalesRepresentativeId());
        e.setMovementBusinessPartnerId(c.getMovementBusinessPartnerId());
        e.setMovementChargeAmount(c.getMovementChargeAmount());
        e.setMovementCreateFrom(c.getMovementCreateFrom());
        e.setMovementFreightAmount(c.getMovementFreightAmount());
        e.setMovementReversalDocumentNumber(c.getMovementReversalDocumentNumber());
        e.setMovementWarehouseIdFrom(c.getMovementWarehouseIdFrom());
        e.setMovementWarehouseIdTo(c.getMovementWarehouseIdTo());
        e.setMovementDescription(c.getMovementDescription());
        e.setMovementCreatedBy(c.getMovementCreatedBy());
        e.setMovementCreatedAt(c.getMovementCreatedAt());
        e.setMovementUpdatedBy(c.getMovementUpdatedBy());
        e.setMovementUpdatedAt(c.getMovementUpdatedAt());
        e.setMovementActive(c.getMovementActive());
        e.setMovementDeleted(c.getMovementDeleted());
        ((AbstractMovementLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoEvent map(MovementLineMvoCommand.MergePatchMovementLineMvo c) {
        MovementLineMvoEventId stateEventId = new MovementLineMvoEventId(c.getMovementLineId(), c.getMovementVersion());
        MovementLineMvoEvent.MovementLineMvoStateMergePatched e = newMovementLineMvoStateMergePatched(stateEventId);
        e.setMovementQuantity(c.getMovementQuantity());
        e.setProductId(c.getProductId());
        e.setLocatorIdFrom(c.getLocatorIdFrom());
        e.setLocatorIdTo(c.getLocatorIdTo());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setMovementDocumentStatusId(c.getMovementDocumentStatusId());
        e.setMovementMovementDate(c.getMovementMovementDate());
        e.setMovementPosted(c.getMovementPosted());
        e.setMovementProcessed(c.getMovementProcessed());
        e.setMovementProcessing(c.getMovementProcessing());
        e.setMovementDateReceived(c.getMovementDateReceived());
        e.setMovementDocumentTypeId(c.getMovementDocumentTypeId());
        e.setMovementIsInTransit(c.getMovementIsInTransit());
        e.setMovementIsApproved(c.getMovementIsApproved());
        e.setMovementApprovalAmount(c.getMovementApprovalAmount());
        e.setMovementShipperId(c.getMovementShipperId());
        e.setMovementSalesRepresentativeId(c.getMovementSalesRepresentativeId());
        e.setMovementBusinessPartnerId(c.getMovementBusinessPartnerId());
        e.setMovementChargeAmount(c.getMovementChargeAmount());
        e.setMovementCreateFrom(c.getMovementCreateFrom());
        e.setMovementFreightAmount(c.getMovementFreightAmount());
        e.setMovementReversalDocumentNumber(c.getMovementReversalDocumentNumber());
        e.setMovementWarehouseIdFrom(c.getMovementWarehouseIdFrom());
        e.setMovementWarehouseIdTo(c.getMovementWarehouseIdTo());
        e.setMovementDescription(c.getMovementDescription());
        e.setMovementCreatedBy(c.getMovementCreatedBy());
        e.setMovementCreatedAt(c.getMovementCreatedAt());
        e.setMovementUpdatedBy(c.getMovementUpdatedBy());
        e.setMovementUpdatedAt(c.getMovementUpdatedAt());
        e.setMovementActive(c.getMovementActive());
        e.setMovementDeleted(c.getMovementDeleted());
        e.setIsPropertyMovementQuantityRemoved(c.getIsPropertyMovementQuantityRemoved());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyLocatorIdFromRemoved(c.getIsPropertyLocatorIdFromRemoved());
        e.setIsPropertyLocatorIdToRemoved(c.getIsPropertyLocatorIdToRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyMovementDocumentStatusIdRemoved(c.getIsPropertyMovementDocumentStatusIdRemoved());
        e.setIsPropertyMovementMovementDateRemoved(c.getIsPropertyMovementMovementDateRemoved());
        e.setIsPropertyMovementPostedRemoved(c.getIsPropertyMovementPostedRemoved());
        e.setIsPropertyMovementProcessedRemoved(c.getIsPropertyMovementProcessedRemoved());
        e.setIsPropertyMovementProcessingRemoved(c.getIsPropertyMovementProcessingRemoved());
        e.setIsPropertyMovementDateReceivedRemoved(c.getIsPropertyMovementDateReceivedRemoved());
        e.setIsPropertyMovementDocumentTypeIdRemoved(c.getIsPropertyMovementDocumentTypeIdRemoved());
        e.setIsPropertyMovementIsInTransitRemoved(c.getIsPropertyMovementIsInTransitRemoved());
        e.setIsPropertyMovementIsApprovedRemoved(c.getIsPropertyMovementIsApprovedRemoved());
        e.setIsPropertyMovementApprovalAmountRemoved(c.getIsPropertyMovementApprovalAmountRemoved());
        e.setIsPropertyMovementShipperIdRemoved(c.getIsPropertyMovementShipperIdRemoved());
        e.setIsPropertyMovementSalesRepresentativeIdRemoved(c.getIsPropertyMovementSalesRepresentativeIdRemoved());
        e.setIsPropertyMovementBusinessPartnerIdRemoved(c.getIsPropertyMovementBusinessPartnerIdRemoved());
        e.setIsPropertyMovementChargeAmountRemoved(c.getIsPropertyMovementChargeAmountRemoved());
        e.setIsPropertyMovementCreateFromRemoved(c.getIsPropertyMovementCreateFromRemoved());
        e.setIsPropertyMovementFreightAmountRemoved(c.getIsPropertyMovementFreightAmountRemoved());
        e.setIsPropertyMovementReversalDocumentNumberRemoved(c.getIsPropertyMovementReversalDocumentNumberRemoved());
        e.setIsPropertyMovementWarehouseIdFromRemoved(c.getIsPropertyMovementWarehouseIdFromRemoved());
        e.setIsPropertyMovementWarehouseIdToRemoved(c.getIsPropertyMovementWarehouseIdToRemoved());
        e.setIsPropertyMovementDescriptionRemoved(c.getIsPropertyMovementDescriptionRemoved());
        e.setIsPropertyMovementCreatedByRemoved(c.getIsPropertyMovementCreatedByRemoved());
        e.setIsPropertyMovementCreatedAtRemoved(c.getIsPropertyMovementCreatedAtRemoved());
        e.setIsPropertyMovementUpdatedByRemoved(c.getIsPropertyMovementUpdatedByRemoved());
        e.setIsPropertyMovementUpdatedAtRemoved(c.getIsPropertyMovementUpdatedAtRemoved());
        e.setIsPropertyMovementActiveRemoved(c.getIsPropertyMovementActiveRemoved());
        e.setIsPropertyMovementDeletedRemoved(c.getIsPropertyMovementDeletedRemoved());
        ((AbstractMovementLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoEvent map(MovementLineMvoCommand.DeleteMovementLineMvo c) {
        MovementLineMvoEventId stateEventId = new MovementLineMvoEventId(c.getMovementLineId(), c.getMovementVersion());
        MovementLineMvoEvent.MovementLineMvoStateDeleted e = newMovementLineMvoStateDeleted(stateEventId);
        ((AbstractMovementLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected MovementLineMvoEvent.MovementLineMvoStateCreated newMovementLineMvoStateCreated(Long version, String commandId, String requesterId) {
        MovementLineMvoEventId stateEventId = new MovementLineMvoEventId(this.state.getMovementLineId(), version);
        MovementLineMvoEvent.MovementLineMvoStateCreated e = newMovementLineMvoStateCreated(stateEventId);
        ((AbstractMovementLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoEvent.MovementLineMvoStateMergePatched newMovementLineMvoStateMergePatched(Long version, String commandId, String requesterId) {
        MovementLineMvoEventId stateEventId = new MovementLineMvoEventId(this.state.getMovementLineId(), version);
        MovementLineMvoEvent.MovementLineMvoStateMergePatched e = newMovementLineMvoStateMergePatched(stateEventId);
        ((AbstractMovementLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoEvent.MovementLineMvoStateDeleted newMovementLineMvoStateDeleted(Long version, String commandId, String requesterId) {
        MovementLineMvoEventId stateEventId = new MovementLineMvoEventId(this.state.getMovementLineId(), version);
        MovementLineMvoEvent.MovementLineMvoStateDeleted e = newMovementLineMvoStateDeleted(stateEventId);
        ((AbstractMovementLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoEvent.MovementLineMvoStateCreated newMovementLineMvoStateCreated(MovementLineMvoEventId stateEventId) {
        return new AbstractMovementLineMvoEvent.SimpleMovementLineMvoStateCreated(stateEventId);
    }

    protected MovementLineMvoEvent.MovementLineMvoStateMergePatched newMovementLineMvoStateMergePatched(MovementLineMvoEventId stateEventId) {
        return new AbstractMovementLineMvoEvent.SimpleMovementLineMvoStateMergePatched(stateEventId);
    }

    protected MovementLineMvoEvent.MovementLineMvoStateDeleted newMovementLineMvoStateDeleted(MovementLineMvoEventId stateEventId)
    {
        return new AbstractMovementLineMvoEvent.SimpleMovementLineMvoStateDeleted(stateEventId);
    }

    public static class SimpleMovementLineMvoAggregate extends AbstractMovementLineMvoAggregate
    {
        public SimpleMovementLineMvoAggregate(MovementLineMvoState state) {
            super(state);
        }

    }

}

