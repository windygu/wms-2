package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInOutLineMvoAggregate extends AbstractAggregate implements InOutLineMvoAggregate
{
    private InOutLineMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInOutLineMvoAggregate(InOutLineMvoState state)
    {
        this.state = state;
    }

    public InOutLineMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InOutLineMvoCommand.CreateInOutLineMvo c)
    {
        if (c.getInOutVersion() == null) { c.setInOutVersion(InOutLineMvoState.VERSION_NULL); }
        InOutLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InOutLineMvoCommand.MergePatchInOutLineMvo c)
    {
        InOutLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(InOutLineMvoCommand.DeleteInOutLineMvo c)
    {
        InOutLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InOutLineMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InOutLineMvoStateEvent map(InOutLineMvoCommand.CreateInOutLineMvo c) {
        InOutLineMvoStateEventId stateEventId = new InOutLineMvoStateEventId(c.getInOutLineId(), c.getInOutVersion());
        InOutLineMvoStateEvent.InOutLineMvoStateCreated e = newInOutLineMvoStateCreated(stateEventId);
        e.setLocatorId(c.getLocatorId());
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setDescription(c.getDescription());
        e.setUomId(c.getUomId());
        e.setMovementQuantity(c.getMovementQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setPickedQuantity(c.getPickedQuantity());
        e.setIsInvoiced(c.getIsInvoiced());
        e.setProcessed(c.getProcessed());
        e.setQuantityEntered(c.getQuantityEntered());
        e.setRmaLineNumber(c.getRmaLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        newInOutLineMvoDocumentActionCommandAndExecute(c, state, e);
        e.setInOutPosted(c.getInOutPosted());
        e.setInOutProcessed(c.getInOutProcessed());
        e.setInOutProcessing(c.getInOutProcessing());
        e.setInOutDocumentTypeId(c.getInOutDocumentTypeId());
        e.setInOutDescription(c.getInOutDescription());
        e.setInOutOrderId(c.getInOutOrderId());
        e.setInOutDateOrdered(c.getInOutDateOrdered());
        e.setInOutIsPrinted(c.getInOutIsPrinted());
        e.setInOutMovementTypeId(c.getInOutMovementTypeId());
        e.setInOutMovementDate(c.getInOutMovementDate());
        e.setInOutBusinessPartnerId(c.getInOutBusinessPartnerId());
        e.setInOutWarehouseId(c.getInOutWarehouseId());
        e.setInOutPOReference(c.getInOutPOReference());
        e.setInOutShipperId(c.getInOutShipperId());
        e.setInOutDatePrinted(c.getInOutDatePrinted());
        e.setInOutSalesRepresentativeId(c.getInOutSalesRepresentativeId());
        e.setInOutNumberOfPackages(c.getInOutNumberOfPackages());
        e.setInOutPickDate(c.getInOutPickDate());
        e.setInOutShipDate(c.getInOutShipDate());
        e.setInOutTrackingNumber(c.getInOutTrackingNumber());
        e.setInOutDateReceived(c.getInOutDateReceived());
        e.setInOutIsInTransit(c.getInOutIsInTransit());
        e.setInOutIsApproved(c.getInOutIsApproved());
        e.setInOutIsInDispute(c.getInOutIsInDispute());
        e.setInOutRmaDocumentNumber(c.getInOutRmaDocumentNumber());
        e.setInOutReversalDocumentNumber(c.getInOutReversalDocumentNumber());
        e.setInOutCreatedBy(c.getInOutCreatedBy());
        e.setInOutCreatedAt(c.getInOutCreatedAt());
        e.setInOutUpdatedBy(c.getInOutUpdatedBy());
        e.setInOutUpdatedAt(c.getInOutUpdatedAt());
        e.setInOutActive(c.getInOutActive());
        e.setInOutDeleted(c.getInOutDeleted());
        ((AbstractInOutLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoStateEvent map(InOutLineMvoCommand.MergePatchInOutLineMvo c) {
        InOutLineMvoStateEventId stateEventId = new InOutLineMvoStateEventId(c.getInOutLineId(), c.getInOutVersion());
        InOutLineMvoStateEvent.InOutLineMvoStateMergePatched e = newInOutLineMvoStateMergePatched(stateEventId);
        e.setLocatorId(c.getLocatorId());
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setDescription(c.getDescription());
        e.setUomId(c.getUomId());
        e.setMovementQuantity(c.getMovementQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setPickedQuantity(c.getPickedQuantity());
        e.setIsInvoiced(c.getIsInvoiced());
        e.setProcessed(c.getProcessed());
        e.setQuantityEntered(c.getQuantityEntered());
        e.setRmaLineNumber(c.getRmaLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        newInOutLineMvoDocumentActionCommandAndExecute(c, state, e);
        e.setInOutPosted(c.getInOutPosted());
        e.setInOutProcessed(c.getInOutProcessed());
        e.setInOutProcessing(c.getInOutProcessing());
        e.setInOutDocumentTypeId(c.getInOutDocumentTypeId());
        e.setInOutDescription(c.getInOutDescription());
        e.setInOutOrderId(c.getInOutOrderId());
        e.setInOutDateOrdered(c.getInOutDateOrdered());
        e.setInOutIsPrinted(c.getInOutIsPrinted());
        e.setInOutMovementTypeId(c.getInOutMovementTypeId());
        e.setInOutMovementDate(c.getInOutMovementDate());
        e.setInOutBusinessPartnerId(c.getInOutBusinessPartnerId());
        e.setInOutWarehouseId(c.getInOutWarehouseId());
        e.setInOutPOReference(c.getInOutPOReference());
        e.setInOutShipperId(c.getInOutShipperId());
        e.setInOutDatePrinted(c.getInOutDatePrinted());
        e.setInOutSalesRepresentativeId(c.getInOutSalesRepresentativeId());
        e.setInOutNumberOfPackages(c.getInOutNumberOfPackages());
        e.setInOutPickDate(c.getInOutPickDate());
        e.setInOutShipDate(c.getInOutShipDate());
        e.setInOutTrackingNumber(c.getInOutTrackingNumber());
        e.setInOutDateReceived(c.getInOutDateReceived());
        e.setInOutIsInTransit(c.getInOutIsInTransit());
        e.setInOutIsApproved(c.getInOutIsApproved());
        e.setInOutIsInDispute(c.getInOutIsInDispute());
        e.setInOutRmaDocumentNumber(c.getInOutRmaDocumentNumber());
        e.setInOutReversalDocumentNumber(c.getInOutReversalDocumentNumber());
        e.setInOutCreatedBy(c.getInOutCreatedBy());
        e.setInOutCreatedAt(c.getInOutCreatedAt());
        e.setInOutUpdatedBy(c.getInOutUpdatedBy());
        e.setInOutUpdatedAt(c.getInOutUpdatedAt());
        e.setInOutActive(c.getInOutActive());
        e.setInOutDeleted(c.getInOutDeleted());
        e.setIsPropertyLocatorIdRemoved(c.getIsPropertyLocatorIdRemoved());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyUomIdRemoved(c.getIsPropertyUomIdRemoved());
        e.setIsPropertyMovementQuantityRemoved(c.getIsPropertyMovementQuantityRemoved());
        e.setIsPropertyConfirmedQuantityRemoved(c.getIsPropertyConfirmedQuantityRemoved());
        e.setIsPropertyScrappedQuantityRemoved(c.getIsPropertyScrappedQuantityRemoved());
        e.setIsPropertyTargetQuantityRemoved(c.getIsPropertyTargetQuantityRemoved());
        e.setIsPropertyPickedQuantityRemoved(c.getIsPropertyPickedQuantityRemoved());
        e.setIsPropertyIsInvoicedRemoved(c.getIsPropertyIsInvoicedRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyQuantityEnteredRemoved(c.getIsPropertyQuantityEnteredRemoved());
        e.setIsPropertyRmaLineNumberRemoved(c.getIsPropertyRmaLineNumberRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyInOutPostedRemoved(c.getIsPropertyInOutPostedRemoved());
        e.setIsPropertyInOutProcessedRemoved(c.getIsPropertyInOutProcessedRemoved());
        e.setIsPropertyInOutProcessingRemoved(c.getIsPropertyInOutProcessingRemoved());
        e.setIsPropertyInOutDocumentTypeIdRemoved(c.getIsPropertyInOutDocumentTypeIdRemoved());
        e.setIsPropertyInOutDescriptionRemoved(c.getIsPropertyInOutDescriptionRemoved());
        e.setIsPropertyInOutOrderIdRemoved(c.getIsPropertyInOutOrderIdRemoved());
        e.setIsPropertyInOutDateOrderedRemoved(c.getIsPropertyInOutDateOrderedRemoved());
        e.setIsPropertyInOutIsPrintedRemoved(c.getIsPropertyInOutIsPrintedRemoved());
        e.setIsPropertyInOutMovementTypeIdRemoved(c.getIsPropertyInOutMovementTypeIdRemoved());
        e.setIsPropertyInOutMovementDateRemoved(c.getIsPropertyInOutMovementDateRemoved());
        e.setIsPropertyInOutBusinessPartnerIdRemoved(c.getIsPropertyInOutBusinessPartnerIdRemoved());
        e.setIsPropertyInOutWarehouseIdRemoved(c.getIsPropertyInOutWarehouseIdRemoved());
        e.setIsPropertyInOutPOReferenceRemoved(c.getIsPropertyInOutPOReferenceRemoved());
        e.setIsPropertyInOutShipperIdRemoved(c.getIsPropertyInOutShipperIdRemoved());
        e.setIsPropertyInOutDatePrintedRemoved(c.getIsPropertyInOutDatePrintedRemoved());
        e.setIsPropertyInOutSalesRepresentativeIdRemoved(c.getIsPropertyInOutSalesRepresentativeIdRemoved());
        e.setIsPropertyInOutNumberOfPackagesRemoved(c.getIsPropertyInOutNumberOfPackagesRemoved());
        e.setIsPropertyInOutPickDateRemoved(c.getIsPropertyInOutPickDateRemoved());
        e.setIsPropertyInOutShipDateRemoved(c.getIsPropertyInOutShipDateRemoved());
        e.setIsPropertyInOutTrackingNumberRemoved(c.getIsPropertyInOutTrackingNumberRemoved());
        e.setIsPropertyInOutDateReceivedRemoved(c.getIsPropertyInOutDateReceivedRemoved());
        e.setIsPropertyInOutIsInTransitRemoved(c.getIsPropertyInOutIsInTransitRemoved());
        e.setIsPropertyInOutIsApprovedRemoved(c.getIsPropertyInOutIsApprovedRemoved());
        e.setIsPropertyInOutIsInDisputeRemoved(c.getIsPropertyInOutIsInDisputeRemoved());
        e.setIsPropertyInOutRmaDocumentNumberRemoved(c.getIsPropertyInOutRmaDocumentNumberRemoved());
        e.setIsPropertyInOutReversalDocumentNumberRemoved(c.getIsPropertyInOutReversalDocumentNumberRemoved());
        e.setIsPropertyInOutCreatedByRemoved(c.getIsPropertyInOutCreatedByRemoved());
        e.setIsPropertyInOutCreatedAtRemoved(c.getIsPropertyInOutCreatedAtRemoved());
        e.setIsPropertyInOutUpdatedByRemoved(c.getIsPropertyInOutUpdatedByRemoved());
        e.setIsPropertyInOutUpdatedAtRemoved(c.getIsPropertyInOutUpdatedAtRemoved());
        e.setIsPropertyInOutActiveRemoved(c.getIsPropertyInOutActiveRemoved());
        e.setIsPropertyInOutDeletedRemoved(c.getIsPropertyInOutDeletedRemoved());
        ((AbstractInOutLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoStateEvent map(InOutLineMvoCommand.DeleteInOutLineMvo c) {
        InOutLineMvoStateEventId stateEventId = new InOutLineMvoStateEventId(c.getInOutLineId(), c.getInOutVersion());
        InOutLineMvoStateEvent.InOutLineMvoStateDeleted e = newInOutLineMvoStateDeleted(stateEventId);
        ((AbstractInOutLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected void newInOutLineMvoDocumentActionCommandAndExecute(InOutLineMvoCommand.MergePatchInOutLineMvo c, InOutLineMvoState s, InOutLineMvoStateEvent.InOutLineMvoStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getInOutLineMvoDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getInOutDocumentStatusId());
        pCmd.setStateSetter(p -> e.setInOutDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCommandHandler.execute(pCmd);
    }

    protected void newInOutLineMvoDocumentActionCommandAndExecute(InOutLineMvoCommand.CreateInOutLineMvo c, InOutLineMvoState s, InOutLineMvoStateEvent.InOutLineMvoStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getInOutLineMvoDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getInOutDocumentStatusId());
        pCmd.setStateSetter(p -> e.setInOutDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCommandHandler.execute(pCmd);
    }

    protected PropertyCommandHandler<String, String> getInOutLineMvoDocumentActionCommandHandler()
    {
        return (PropertyCommandHandler<String, String>)ApplicationContext.current.get("InOutLineMvoDocumentActionCommandHandler");
    }


    ////////////////////////

    protected InOutLineMvoStateEvent.InOutLineMvoStateCreated newInOutLineMvoStateCreated(String commandId, String requesterId) {
        InOutLineMvoStateEventId stateEventId = new InOutLineMvoStateEventId(this.state.getInOutLineId(), this.state.getInOutVersion());
        InOutLineMvoStateEvent.InOutLineMvoStateCreated e = newInOutLineMvoStateCreated(stateEventId);
        ((AbstractInOutLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoStateEvent.InOutLineMvoStateMergePatched newInOutLineMvoStateMergePatched(String commandId, String requesterId) {
        InOutLineMvoStateEventId stateEventId = new InOutLineMvoStateEventId(this.state.getInOutLineId(), this.state.getInOutVersion());
        InOutLineMvoStateEvent.InOutLineMvoStateMergePatched e = newInOutLineMvoStateMergePatched(stateEventId);
        ((AbstractInOutLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoStateEvent.InOutLineMvoStateDeleted newInOutLineMvoStateDeleted(String commandId, String requesterId) {
        InOutLineMvoStateEventId stateEventId = new InOutLineMvoStateEventId(this.state.getInOutLineId(), this.state.getInOutVersion());
        InOutLineMvoStateEvent.InOutLineMvoStateDeleted e = newInOutLineMvoStateDeleted(stateEventId);
        ((AbstractInOutLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoStateEvent.InOutLineMvoStateCreated newInOutLineMvoStateCreated(InOutLineMvoStateEventId stateEventId) {
        return new AbstractInOutLineMvoStateEvent.SimpleInOutLineMvoStateCreated(stateEventId);
    }

    protected InOutLineMvoStateEvent.InOutLineMvoStateMergePatched newInOutLineMvoStateMergePatched(InOutLineMvoStateEventId stateEventId) {
        return new AbstractInOutLineMvoStateEvent.SimpleInOutLineMvoStateMergePatched(stateEventId);
    }

    protected InOutLineMvoStateEvent.InOutLineMvoStateDeleted newInOutLineMvoStateDeleted(InOutLineMvoStateEventId stateEventId)
    {
        return new AbstractInOutLineMvoStateEvent.SimpleInOutLineMvoStateDeleted(stateEventId);
    }


    public static class SimpleInOutLineMvoAggregate extends AbstractInOutLineMvoAggregate
    {
        public SimpleInOutLineMvoAggregate(InOutLineMvoState state) {
            super(state);
        }

    }

}

