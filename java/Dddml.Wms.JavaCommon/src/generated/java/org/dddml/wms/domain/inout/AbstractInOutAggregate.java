package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInOutAggregate extends AbstractAggregate implements InOutAggregate
{
    private InOutState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInOutAggregate(InOutState state)
    {
        this.state = state;
    }

    public InOutState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InOutCommand.CreateInOut c)
    {
        if (c.getVersion() == null) { c.setVersion(InOutState.VERSION_NULL); }
        InOutEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InOutCommand.MergePatchInOut c)
    {
        try {
            verifyPatch(c);
        } catch (Exception ex) {
            throw new DomainError("VerificationFailed", ex);
        }
        InOutEvent e = map(c);
        apply(e);
    }

    private void verifyPatch(InOutCommand.MergePatchInOut c) {
        Boolean posted = c.getPosted();
        Boolean Posted = posted;
        Boolean processed = c.getProcessed();
        Boolean Processed = processed;
        String processing = c.getProcessing();
        String Processing = processing;
        String documentTypeId = c.getDocumentTypeId();
        String DocumentTypeId = documentTypeId;
        String description = c.getDescription();
        String Description = description;
        String orderId = c.getOrderId();
        String OrderId = orderId;
        Date dateOrdered = c.getDateOrdered();
        Date DateOrdered = dateOrdered;
        Boolean isPrinted = c.getIsPrinted();
        Boolean IsPrinted = isPrinted;
        String movementTypeId = c.getMovementTypeId();
        String MovementTypeId = movementTypeId;
        Date movementDate = c.getMovementDate();
        Date MovementDate = movementDate;
        String businessPartnerId = c.getBusinessPartnerId();
        String BusinessPartnerId = businessPartnerId;
        String warehouseId = c.getWarehouseId();
        String WarehouseId = warehouseId;
        String POReference = c.getPOReference();
        BigDecimal freightAmount = c.getFreightAmount();
        BigDecimal FreightAmount = freightAmount;
        String shipperId = c.getShipperId();
        String ShipperId = shipperId;
        BigDecimal chargeAmount = c.getChargeAmount();
        BigDecimal ChargeAmount = chargeAmount;
        Date datePrinted = c.getDatePrinted();
        Date DatePrinted = datePrinted;
        String createdFrom = c.getCreatedFrom();
        String CreatedFrom = createdFrom;
        String salesRepresentativeId = c.getSalesRepresentativeId();
        String SalesRepresentativeId = salesRepresentativeId;
        Integer numberOfPackages = c.getNumberOfPackages();
        Integer NumberOfPackages = numberOfPackages;
        Date pickDate = c.getPickDate();
        Date PickDate = pickDate;
        Date shipDate = c.getShipDate();
        Date ShipDate = shipDate;
        String trackingNumber = c.getTrackingNumber();
        String TrackingNumber = trackingNumber;
        Date dateReceived = c.getDateReceived();
        Date DateReceived = dateReceived;
        Boolean isInTransit = c.getIsInTransit();
        Boolean IsInTransit = isInTransit;
        Boolean isApproved = c.getIsApproved();
        Boolean IsApproved = isApproved;
        Boolean isInDispute = c.getIsInDispute();
        Boolean IsInDispute = isInDispute;
        String rmaDocumentNumber = c.getRmaDocumentNumber();
        String RmaDocumentNumber = rmaDocumentNumber;
        String reversalDocumentNumber = c.getReversalDocumentNumber();
        String ReversalDocumentNumber = reversalDocumentNumber;

        if (!"Drafted".equalsIgnoreCase(getState().getDocumentStatusId())) { throw new IllegalArgumentException("DocumentStatus error."); }

    }

    public void throwOnInvalidStateTransition(Command c) {
        InOutCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InOutEvent map(InOutCommand.CreateInOut c) {
        InOutEventId stateEventId = new InOutEventId(c.getDocumentNumber(), c.getVersion());
        InOutEvent.InOutStateCreated e = newInOutStateCreated(stateEventId);
        newInOutDocumentActionCommandAndExecute(c, state, e);
        e.setPosted(c.getPosted());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setDescription(c.getDescription());
        e.setOrderId(c.getOrderId());
        e.setDateOrdered(c.getDateOrdered());
        e.setIsPrinted(c.getIsPrinted());
        e.setMovementTypeId(c.getMovementTypeId());
        e.setMovementDate(c.getMovementDate());
        e.setBusinessPartnerId(c.getBusinessPartnerId());
        e.setWarehouseId(c.getWarehouseId());
        e.setPOReference(c.getPOReference());
        e.setFreightAmount(c.getFreightAmount());
        e.setShipperId(c.getShipperId());
        e.setChargeAmount(c.getChargeAmount());
        e.setDatePrinted(c.getDatePrinted());
        e.setCreatedFrom(c.getCreatedFrom());
        e.setSalesRepresentativeId(c.getSalesRepresentativeId());
        e.setNumberOfPackages(c.getNumberOfPackages());
        e.setPickDate(c.getPickDate());
        e.setShipDate(c.getShipDate());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setDateReceived(c.getDateReceived());
        e.setIsInTransit(c.getIsInTransit());
        e.setIsApproved(c.getIsApproved());
        e.setIsInDispute(c.getIsInDispute());
        e.setRmaDocumentNumber(c.getRmaDocumentNumber());
        e.setReversalDocumentNumber(c.getReversalDocumentNumber());
        e.setActive(c.getActive());
        ((AbstractInOutEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (InOutLineCommand.CreateInOutLine innerCommand : c.getInOutLines())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InOutLineEvent.InOutLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addInOutLineEvent(innerEvent);
        }

        return e;
    }

    protected InOutEvent map(InOutCommand.MergePatchInOut c) {
        InOutEventId stateEventId = new InOutEventId(c.getDocumentNumber(), c.getVersion());
        InOutEvent.InOutStateMergePatched e = newInOutStateMergePatched(stateEventId);
        e.setPosted(c.getPosted());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setDescription(c.getDescription());
        e.setOrderId(c.getOrderId());
        e.setDateOrdered(c.getDateOrdered());
        e.setIsPrinted(c.getIsPrinted());
        e.setMovementTypeId(c.getMovementTypeId());
        e.setMovementDate(c.getMovementDate());
        e.setBusinessPartnerId(c.getBusinessPartnerId());
        e.setWarehouseId(c.getWarehouseId());
        e.setPOReference(c.getPOReference());
        e.setFreightAmount(c.getFreightAmount());
        e.setShipperId(c.getShipperId());
        e.setChargeAmount(c.getChargeAmount());
        e.setDatePrinted(c.getDatePrinted());
        e.setCreatedFrom(c.getCreatedFrom());
        e.setSalesRepresentativeId(c.getSalesRepresentativeId());
        e.setNumberOfPackages(c.getNumberOfPackages());
        e.setPickDate(c.getPickDate());
        e.setShipDate(c.getShipDate());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setDateReceived(c.getDateReceived());
        e.setIsInTransit(c.getIsInTransit());
        e.setIsApproved(c.getIsApproved());
        e.setIsInDispute(c.getIsInDispute());
        e.setRmaDocumentNumber(c.getRmaDocumentNumber());
        e.setReversalDocumentNumber(c.getReversalDocumentNumber());
        e.setActive(c.getActive());
        e.setIsPropertyPostedRemoved(c.getIsPropertyPostedRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyProcessingRemoved(c.getIsPropertyProcessingRemoved());
        e.setIsPropertyDocumentTypeIdRemoved(c.getIsPropertyDocumentTypeIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyOrderIdRemoved(c.getIsPropertyOrderIdRemoved());
        e.setIsPropertyDateOrderedRemoved(c.getIsPropertyDateOrderedRemoved());
        e.setIsPropertyIsPrintedRemoved(c.getIsPropertyIsPrintedRemoved());
        e.setIsPropertyMovementTypeIdRemoved(c.getIsPropertyMovementTypeIdRemoved());
        e.setIsPropertyMovementDateRemoved(c.getIsPropertyMovementDateRemoved());
        e.setIsPropertyBusinessPartnerIdRemoved(c.getIsPropertyBusinessPartnerIdRemoved());
        e.setIsPropertyWarehouseIdRemoved(c.getIsPropertyWarehouseIdRemoved());
        e.setIsPropertyPOReferenceRemoved(c.getIsPropertyPOReferenceRemoved());
        e.setIsPropertyFreightAmountRemoved(c.getIsPropertyFreightAmountRemoved());
        e.setIsPropertyShipperIdRemoved(c.getIsPropertyShipperIdRemoved());
        e.setIsPropertyChargeAmountRemoved(c.getIsPropertyChargeAmountRemoved());
        e.setIsPropertyDatePrintedRemoved(c.getIsPropertyDatePrintedRemoved());
        e.setIsPropertyCreatedFromRemoved(c.getIsPropertyCreatedFromRemoved());
        e.setIsPropertySalesRepresentativeIdRemoved(c.getIsPropertySalesRepresentativeIdRemoved());
        e.setIsPropertyNumberOfPackagesRemoved(c.getIsPropertyNumberOfPackagesRemoved());
        e.setIsPropertyPickDateRemoved(c.getIsPropertyPickDateRemoved());
        e.setIsPropertyShipDateRemoved(c.getIsPropertyShipDateRemoved());
        e.setIsPropertyTrackingNumberRemoved(c.getIsPropertyTrackingNumberRemoved());
        e.setIsPropertyDateReceivedRemoved(c.getIsPropertyDateReceivedRemoved());
        e.setIsPropertyIsInTransitRemoved(c.getIsPropertyIsInTransitRemoved());
        e.setIsPropertyIsApprovedRemoved(c.getIsPropertyIsApprovedRemoved());
        e.setIsPropertyIsInDisputeRemoved(c.getIsPropertyIsInDisputeRemoved());
        e.setIsPropertyRmaDocumentNumberRemoved(c.getIsPropertyRmaDocumentNumberRemoved());
        e.setIsPropertyReversalDocumentNumberRemoved(c.getIsPropertyReversalDocumentNumberRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractInOutEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (InOutLineCommand innerCommand : c.getInOutLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InOutLineEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addInOutLineEvent(innerEvent);
        }

        return e;
    }


    protected InOutLineEvent map(InOutLineCommand c, InOutCommand outerCommand, Long version, InOutState outerState)
    {
        InOutLineCommand.CreateInOutLine create = (c.getCommandType().equals(CommandType.CREATE)) ? ((InOutLineCommand.CreateInOutLine)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        InOutLineCommand.MergePatchInOutLine merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((InOutLineCommand.MergePatchInOutLine)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        InOutLineCommand.RemoveInOutLine remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((InOutLineCommand.RemoveInOutLine)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected InOutLineEvent.InOutLineStateCreated mapCreate(InOutLineCommand.CreateInOutLine c, InOutCommand outerCommand, Long version, InOutState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        InOutLineEventId stateEventId = new InOutLineEventId(c.getInOutDocumentNumber(), c.getLineNumber(), version);
        InOutLineEvent.InOutLineStateCreated e = newInOutLineStateCreated(stateEventId);
        InOutLineState s = outerState.getInOutLines().get(c.getLineNumber());

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
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected InOutLineEvent.InOutLineStateMergePatched mapMergePatch(InOutLineCommand.MergePatchInOutLine c, InOutCommand outerCommand, Long version, InOutState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        InOutLineEventId stateEventId = new InOutLineEventId(c.getInOutDocumentNumber(), c.getLineNumber(), version);
        InOutLineEvent.InOutLineStateMergePatched e = newInOutLineStateMergePatched(stateEventId);
        InOutLineState s = outerState.getInOutLines().get(c.getLineNumber());

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
        e.setActive(c.getActive());
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
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected InOutLineEvent.InOutLineStateRemoved mapRemove(InOutLineCommand.RemoveInOutLine c, InOutCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        InOutLineEventId stateEventId = new InOutLineEventId(c.getInOutDocumentNumber(), c.getLineNumber(), version);
        InOutLineEvent.InOutLineStateRemoved e = newInOutLineStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(InOutCommand command, InOutLineCommand innerCommand)
    {
        AbstractInOutCommand properties = command instanceof AbstractInOutCommand ? (AbstractInOutCommand) command : null;
        AbstractInOutLineCommand innerProperties = innerCommand instanceof AbstractInOutLineCommand ? (AbstractInOutLineCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerDocumentNumberName = "DocumentNumber";
        String outerDocumentNumberValue = properties.getDocumentNumber();
        String innerInOutDocumentNumberName = "InOutDocumentNumber";
        String innerInOutDocumentNumberValue = innerProperties.getInOutDocumentNumber();
        if (innerInOutDocumentNumberValue == null) {
            innerProperties.setInOutDocumentNumber(outerDocumentNumberValue);
        }
        else if (innerInOutDocumentNumberValue != outerDocumentNumberValue 
            && (innerInOutDocumentNumberValue == null || innerInOutDocumentNumberValue != null && !innerInOutDocumentNumberValue.equals(outerDocumentNumberValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerDocumentNumberName, outerDocumentNumberValue, innerInOutDocumentNumberName, innerInOutDocumentNumberValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected InOutEvent.InOutStateCreated newInOutStateCreated(Long version, String commandId, String requesterId) {
        InOutEventId stateEventId = new InOutEventId(this.state.getDocumentNumber(), version);
        InOutEvent.InOutStateCreated e = newInOutStateCreated(stateEventId);
        ((AbstractInOutEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutEvent.InOutStateMergePatched newInOutStateMergePatched(Long version, String commandId, String requesterId) {
        InOutEventId stateEventId = new InOutEventId(this.state.getDocumentNumber(), version);
        InOutEvent.InOutStateMergePatched e = newInOutStateMergePatched(stateEventId);
        ((AbstractInOutEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutEvent.InOutStateCreated newInOutStateCreated(InOutEventId stateEventId) {
        return new AbstractInOutEvent.SimpleInOutStateCreated(stateEventId);
    }

    protected InOutEvent.InOutStateMergePatched newInOutStateMergePatched(InOutEventId stateEventId) {
        return new AbstractInOutEvent.SimpleInOutStateMergePatched(stateEventId);
    }

    protected InOutLineEvent.InOutLineStateCreated newInOutLineStateCreated(InOutLineEventId stateEventId) {
        return new AbstractInOutLineEvent.SimpleInOutLineStateCreated(stateEventId);
    }

    protected InOutLineEvent.InOutLineStateMergePatched newInOutLineStateMergePatched(InOutLineEventId stateEventId) {
        return new AbstractInOutLineEvent.SimpleInOutLineStateMergePatched(stateEventId);
    }

    protected InOutLineEvent.InOutLineStateRemoved newInOutLineStateRemoved(InOutLineEventId stateEventId)
    {
        return new AbstractInOutLineEvent.SimpleInOutLineStateRemoved(stateEventId);
    }

    protected void newInOutDocumentActionCommandAndExecute(InOutCommand.CreateInOut c, InOutState s, InOutEvent.InOutStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getInOutDocumentActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    public class SimpleInOutDocumentActionCommandHandler implements PropertyCommandHandler<String, String> {

        public void execute(PropertyCommand<String, String> command) {
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, command.getContent())) {
                command.getStateSetter().accept("Drafted");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Complete", command.getContent())) {
                command.getStateSetter().accept("Completed");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Void", command.getContent())) {
                command.getStateSetter().accept("Voided");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Close", command.getContent())) {
                command.getStateSetter().accept("Closed");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Reverse", command.getContent())) {
                command.getStateSetter().accept("Reversed");
                return;
            }
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), command.getContent()));
        }
    }

    private PropertyCommandHandler<String, String> inOutDocumentActionCommandHandler = new SimpleInOutDocumentActionCommandHandler();

    public void setInOutDocumentActionCommandHandler(PropertyCommandHandler<String, String> h) {
        this.inOutDocumentActionCommandHandler = h;
    }

    protected PropertyCommandHandler<String, String> getInOutDocumentActionCommandHandler() {
        Object h = ApplicationContext.current.get("InOutDocumentActionCommandHandler");
        if (h instanceof PropertyCommandHandler) {
            return (PropertyCommandHandler<String, String>) h;
        }
        return this.inOutDocumentActionCommandHandler;
    }

    public static class SimpleInOutAggregate extends AbstractInOutAggregate
    {
        public SimpleInOutAggregate(InOutState state) {
            super(state);
        }

        @Override
        public void complete(Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void close(Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void _void(Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void reverse(Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addLine(String lineNumber, String locatorId, String productId, java.util.Map<String, Object> attributeSetInstance, String description, String quantityUomId, BigDecimal movementQuantity, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void documentAction(String value, Long version, String commandId, String requesterId) {
            InOutEvent.InOutStateMergePatched e = newInOutStateMergePatched(version, commandId, requesterId);
            doDocumentAction(value, s -> e.setDocumentStatusId(s));
            apply(e);
        }

        protected  void doDocumentAction(String value, java.util.function.Consumer<String> setDocumentStatusId) {
            PropertyCommandHandler<String, String> pCommandHandler = this.getInOutDocumentActionCommandHandler();
            PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<>();
            pCmd.setContent(value);
            pCmd.setStateGetter(() -> this.getState().getDocumentStatusId());
            pCmd.setStateSetter(setDocumentStatusId);
            pCmd.setOuterCommandType("DocumentAction");
            pCmd.setContext(getState());
            pCommandHandler.execute(pCmd);
        }

    }

}

