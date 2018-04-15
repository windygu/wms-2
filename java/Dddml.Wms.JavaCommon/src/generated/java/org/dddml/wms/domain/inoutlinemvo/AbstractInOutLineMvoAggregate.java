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
        InOutLineMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InOutLineMvoCommand.MergePatchInOutLineMvo c)
    {
        InOutLineMvoEvent e = map(c);
        apply(e);
    }

    public void delete(InOutLineMvoCommand.DeleteInOutLineMvo c)
    {
        InOutLineMvoEvent e = map(c);
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

    protected InOutLineMvoEvent map(InOutLineMvoCommand.CreateInOutLineMvo c) {
        InOutLineMvoEventId stateEventId = new InOutLineMvoEventId(c.getInOutLineId(), c.getInOutVersion());
        InOutLineMvoEvent.InOutLineMvoStateCreated e = newInOutLineMvoStateCreated(stateEventId);
        e.setLocatorId(c.getLocatorId());
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setDescription(c.getDescription());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setMovementQuantity(c.getMovementQuantity());
        e.setPickedQuantity(c.getPickedQuantity());
        e.setIsInvoiced(c.getIsInvoiced());
        e.setProcessed(c.getProcessed());
        e.setRmaLineNumber(c.getRmaLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setInOutDocumentStatusId(c.getInOutDocumentStatusId());
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
        e.setInOutFreightAmount(c.getInOutFreightAmount());
        e.setInOutShipperId(c.getInOutShipperId());
        e.setInOutChargeAmount(c.getInOutChargeAmount());
        e.setInOutDatePrinted(c.getInOutDatePrinted());
        e.setInOutCreatedFrom(c.getInOutCreatedFrom());
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
        ((AbstractInOutLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoEvent map(InOutLineMvoCommand.MergePatchInOutLineMvo c) {
        InOutLineMvoEventId stateEventId = new InOutLineMvoEventId(c.getInOutLineId(), c.getInOutVersion());
        InOutLineMvoEvent.InOutLineMvoStateMergePatched e = newInOutLineMvoStateMergePatched(stateEventId);
        e.setLocatorId(c.getLocatorId());
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setDescription(c.getDescription());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setMovementQuantity(c.getMovementQuantity());
        e.setPickedQuantity(c.getPickedQuantity());
        e.setIsInvoiced(c.getIsInvoiced());
        e.setProcessed(c.getProcessed());
        e.setRmaLineNumber(c.getRmaLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setInOutDocumentStatusId(c.getInOutDocumentStatusId());
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
        e.setInOutFreightAmount(c.getInOutFreightAmount());
        e.setInOutShipperId(c.getInOutShipperId());
        e.setInOutChargeAmount(c.getInOutChargeAmount());
        e.setInOutDatePrinted(c.getInOutDatePrinted());
        e.setInOutCreatedFrom(c.getInOutCreatedFrom());
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
        e.setIsPropertyLocatorIdRemoved(c.getIsPropertyLocatorIdRemoved());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyQuantityUomIdRemoved(c.getIsPropertyQuantityUomIdRemoved());
        e.setIsPropertyMovementQuantityRemoved(c.getIsPropertyMovementQuantityRemoved());
        e.setIsPropertyPickedQuantityRemoved(c.getIsPropertyPickedQuantityRemoved());
        e.setIsPropertyIsInvoicedRemoved(c.getIsPropertyIsInvoicedRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyRmaLineNumberRemoved(c.getIsPropertyRmaLineNumberRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyInOutDocumentStatusIdRemoved(c.getIsPropertyInOutDocumentStatusIdRemoved());
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
        e.setIsPropertyInOutFreightAmountRemoved(c.getIsPropertyInOutFreightAmountRemoved());
        e.setIsPropertyInOutShipperIdRemoved(c.getIsPropertyInOutShipperIdRemoved());
        e.setIsPropertyInOutChargeAmountRemoved(c.getIsPropertyInOutChargeAmountRemoved());
        e.setIsPropertyInOutDatePrintedRemoved(c.getIsPropertyInOutDatePrintedRemoved());
        e.setIsPropertyInOutCreatedFromRemoved(c.getIsPropertyInOutCreatedFromRemoved());
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
        ((AbstractInOutLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoEvent map(InOutLineMvoCommand.DeleteInOutLineMvo c) {
        InOutLineMvoEventId stateEventId = new InOutLineMvoEventId(c.getInOutLineId(), c.getInOutVersion());
        InOutLineMvoEvent.InOutLineMvoStateDeleted e = newInOutLineMvoStateDeleted(stateEventId);
        ((AbstractInOutLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InOutLineMvoEvent.InOutLineMvoStateCreated newInOutLineMvoStateCreated(Long version, String commandId, String requesterId) {
        InOutLineMvoEventId stateEventId = new InOutLineMvoEventId(this.state.getInOutLineId(), version);
        InOutLineMvoEvent.InOutLineMvoStateCreated e = newInOutLineMvoStateCreated(stateEventId);
        ((AbstractInOutLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoEvent.InOutLineMvoStateMergePatched newInOutLineMvoStateMergePatched(Long version, String commandId, String requesterId) {
        InOutLineMvoEventId stateEventId = new InOutLineMvoEventId(this.state.getInOutLineId(), version);
        InOutLineMvoEvent.InOutLineMvoStateMergePatched e = newInOutLineMvoStateMergePatched(stateEventId);
        ((AbstractInOutLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoEvent.InOutLineMvoStateDeleted newInOutLineMvoStateDeleted(Long version, String commandId, String requesterId) {
        InOutLineMvoEventId stateEventId = new InOutLineMvoEventId(this.state.getInOutLineId(), version);
        InOutLineMvoEvent.InOutLineMvoStateDeleted e = newInOutLineMvoStateDeleted(stateEventId);
        ((AbstractInOutLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutLineMvoEvent.InOutLineMvoStateCreated newInOutLineMvoStateCreated(InOutLineMvoEventId stateEventId) {
        return new AbstractInOutLineMvoEvent.SimpleInOutLineMvoStateCreated(stateEventId);
    }

    protected InOutLineMvoEvent.InOutLineMvoStateMergePatched newInOutLineMvoStateMergePatched(InOutLineMvoEventId stateEventId) {
        return new AbstractInOutLineMvoEvent.SimpleInOutLineMvoStateMergePatched(stateEventId);
    }

    protected InOutLineMvoEvent.InOutLineMvoStateDeleted newInOutLineMvoStateDeleted(InOutLineMvoEventId stateEventId)
    {
        return new AbstractInOutLineMvoEvent.SimpleInOutLineMvoStateDeleted(stateEventId);
    }

    public static class SimpleInOutLineMvoAggregate extends AbstractInOutLineMvoAggregate
    {
        public SimpleInOutLineMvoAggregate(InOutLineMvoState state) {
            super(state);
        }

    }

}

