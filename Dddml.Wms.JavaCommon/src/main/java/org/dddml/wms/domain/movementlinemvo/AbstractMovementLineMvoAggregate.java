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
        MovementLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementLineMvoCommand.MergePatchMovementLineMvo c)
    {
        MovementLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(MovementLineMvoCommand.DeleteMovementLineMvo c)
    {
        MovementLineMvoStateEvent e = map(c);
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

    protected MovementLineMvoStateEvent map(MovementLineMvoCommand.CreateMovementLineMvo c) {
        MovementLineMvoStateEventId stateEventId = new MovementLineMvoStateEventId(c.getMovementLineId(), c.getMovementVersion());
        MovementLineMvoStateEvent.MovementLineMvoStateCreated e = newMovementLineMvoStateCreated(stateEventId);
        e.setMovementQuantity(c.getMovementQuantity());
        e.setProductId(c.getProductId());
        e.setLocatorIdFrom(c.getLocatorIdFrom());
        e.setLocatorIdTo(c.getLocatorIdTo());
        e.setAttributeSetInstanceIdFrom(c.getAttributeSetInstanceIdFrom());
        e.setAttributeSetInstanceIdTo(c.getAttributeSetInstanceIdTo());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        newMovementLineMvoDocumentActionCommandAndExecute(c, state, e);
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
        ((AbstractMovementLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoStateEvent map(MovementLineMvoCommand.MergePatchMovementLineMvo c) {
        MovementLineMvoStateEventId stateEventId = new MovementLineMvoStateEventId(c.getMovementLineId(), c.getMovementVersion());
        MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e = newMovementLineMvoStateMergePatched(stateEventId);
        e.setMovementQuantity(c.getMovementQuantity());
        e.setProductId(c.getProductId());
        e.setLocatorIdFrom(c.getLocatorIdFrom());
        e.setLocatorIdTo(c.getLocatorIdTo());
        e.setAttributeSetInstanceIdFrom(c.getAttributeSetInstanceIdFrom());
        e.setAttributeSetInstanceIdTo(c.getAttributeSetInstanceIdTo());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        newMovementLineMvoDocumentActionCommandAndExecute(c, state, e);
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
        e.setIsPropertyAttributeSetInstanceIdFromRemoved(c.getIsPropertyAttributeSetInstanceIdFromRemoved());
        e.setIsPropertyAttributeSetInstanceIdToRemoved(c.getIsPropertyAttributeSetInstanceIdToRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
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
        ((AbstractMovementLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoStateEvent map(MovementLineMvoCommand.DeleteMovementLineMvo c) {
        MovementLineMvoStateEventId stateEventId = new MovementLineMvoStateEventId(c.getMovementLineId(), c.getMovementVersion());
        MovementLineMvoStateEvent.MovementLineMvoStateDeleted e = newMovementLineMvoStateDeleted(stateEventId);
        ((AbstractMovementLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected void newMovementLineMvoDocumentActionCommandAndExecute(MovementLineMvoCommand.MergePatchMovementLineMvo c, MovementLineMvoState s, MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementLineMvoDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getMovementDocumentStatusId());
        pCmd.setStateSetter(p -> e.setMovementDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCommandHandler.execute(pCmd);
    }

    protected void newMovementLineMvoDocumentActionCommandAndExecute(MovementLineMvoCommand.CreateMovementLineMvo c, MovementLineMvoState s, MovementLineMvoStateEvent.MovementLineMvoStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementLineMvoDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getMovementDocumentStatusId());
        pCmd.setStateSetter(p -> e.setMovementDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCommandHandler.execute(pCmd);
    }

    protected PropertyCommandHandler<String, String> getMovementLineMvoDocumentActionCommandHandler()
    {
        return (PropertyCommandHandler<String, String>)ApplicationContext.current.get("MovementLineMvoDocumentActionCommandHandler");
    }


    ////////////////////////

    protected MovementLineMvoStateEvent.MovementLineMvoStateCreated newMovementLineMvoStateCreated(String commandId, String requesterId) {
        MovementLineMvoStateEventId stateEventId = new MovementLineMvoStateEventId(this.state.getMovementLineId(), this.state.getMovementVersion());
        MovementLineMvoStateEvent.MovementLineMvoStateCreated e = newMovementLineMvoStateCreated(stateEventId);
        ((AbstractMovementLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoStateEvent.MovementLineMvoStateMergePatched newMovementLineMvoStateMergePatched(String commandId, String requesterId) {
        MovementLineMvoStateEventId stateEventId = new MovementLineMvoStateEventId(this.state.getMovementLineId(), this.state.getMovementVersion());
        MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e = newMovementLineMvoStateMergePatched(stateEventId);
        ((AbstractMovementLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoStateEvent.MovementLineMvoStateDeleted newMovementLineMvoStateDeleted(String commandId, String requesterId) {
        MovementLineMvoStateEventId stateEventId = new MovementLineMvoStateEventId(this.state.getMovementLineId(), this.state.getMovementVersion());
        MovementLineMvoStateEvent.MovementLineMvoStateDeleted e = newMovementLineMvoStateDeleted(stateEventId);
        ((AbstractMovementLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementLineMvoStateEvent.MovementLineMvoStateCreated newMovementLineMvoStateCreated(MovementLineMvoStateEventId stateEventId) {
        return new AbstractMovementLineMvoStateEvent.SimpleMovementLineMvoStateCreated(stateEventId);
    }

    protected MovementLineMvoStateEvent.MovementLineMvoStateMergePatched newMovementLineMvoStateMergePatched(MovementLineMvoStateEventId stateEventId) {
        return new AbstractMovementLineMvoStateEvent.SimpleMovementLineMvoStateMergePatched(stateEventId);
    }

    protected MovementLineMvoStateEvent.MovementLineMvoStateDeleted newMovementLineMvoStateDeleted(MovementLineMvoStateEventId stateEventId)
    {
        return new AbstractMovementLineMvoStateEvent.SimpleMovementLineMvoStateDeleted(stateEventId);
    }


    public static class SimpleMovementLineMvoAggregate extends AbstractMovementLineMvoAggregate
    {
        public SimpleMovementLineMvoAggregate(MovementLineMvoState state) {
            super(state);
        }

    }

}
