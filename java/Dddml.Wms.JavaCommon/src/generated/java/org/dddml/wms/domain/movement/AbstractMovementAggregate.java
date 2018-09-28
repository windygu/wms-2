package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementAggregate extends AbstractAggregate implements MovementAggregate
{
    private MovementState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractMovementAggregate(MovementState state)
    {
        this.state = state;
    }

    public MovementState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(MovementCommand.CreateMovement c)
    {
        if (c.getVersion() == null) { c.setVersion(MovementState.VERSION_NULL); }
        MovementEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementCommand.MergePatchMovement c)
    {
        try {
            verifyPatch(c);
        } catch (Exception ex) {
            throw new DomainError("VerificationFailed", ex);
        }
        MovementEvent e = map(c);
        apply(e);
    }

    private void verifyPatch(MovementCommand.MergePatchMovement c) {
        Date movementDate = c.getMovementDate();
        Date MovementDate = movementDate;
        Boolean posted = c.getPosted();
        Boolean Posted = posted;
        Boolean processed = c.getProcessed();
        Boolean Processed = processed;
        String processing = c.getProcessing();
        String Processing = processing;
        Date dateReceived = c.getDateReceived();
        Date DateReceived = dateReceived;
        String documentTypeId = c.getDocumentTypeId();
        String DocumentTypeId = documentTypeId;
        Boolean isInTransit = c.getIsInTransit();
        Boolean IsInTransit = isInTransit;
        Boolean isApproved = c.getIsApproved();
        Boolean IsApproved = isApproved;
        BigDecimal approvalAmount = c.getApprovalAmount();
        BigDecimal ApprovalAmount = approvalAmount;
        String shipperId = c.getShipperId();
        String ShipperId = shipperId;
        String salesRepresentativeId = c.getSalesRepresentativeId();
        String SalesRepresentativeId = salesRepresentativeId;
        String businessPartnerId = c.getBusinessPartnerId();
        String BusinessPartnerId = businessPartnerId;
        BigDecimal chargeAmount = c.getChargeAmount();
        BigDecimal ChargeAmount = chargeAmount;
        String createFrom = c.getCreateFrom();
        String CreateFrom = createFrom;
        BigDecimal freightAmount = c.getFreightAmount();
        BigDecimal FreightAmount = freightAmount;
        String reversalDocumentNumber = c.getReversalDocumentNumber();
        String ReversalDocumentNumber = reversalDocumentNumber;
        String warehouseIdFrom = c.getWarehouseIdFrom();
        String WarehouseIdFrom = warehouseIdFrom;
        String warehouseIdTo = c.getWarehouseIdTo();
        String WarehouseIdTo = warehouseIdTo;
        String description = c.getDescription();
        String Description = description;

        if (!"Drafted".equalsIgnoreCase(getState().getDocumentStatusId())) { throw new IllegalArgumentException("DocumentStatus error."); }

    }

    public void delete(MovementCommand.DeleteMovement c)
    {
        MovementEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        MovementCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected MovementEvent map(MovementCommand.CreateMovement c) {
        MovementEventId stateEventId = new MovementEventId(c.getDocumentNumber(), c.getVersion());
        MovementEvent.MovementStateCreated e = newMovementStateCreated(stateEventId);
        newMovementDocumentActionCommandAndExecute(c, state, e);
        e.setMovementDate(c.getMovementDate());
        e.setPosted(c.getPosted());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDateReceived(c.getDateReceived());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setIsInTransit(c.getIsInTransit());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setShipperId(c.getShipperId());
        e.setSalesRepresentativeId(c.getSalesRepresentativeId());
        e.setBusinessPartnerId(c.getBusinessPartnerId());
        e.setChargeAmount(c.getChargeAmount());
        e.setCreateFrom(c.getCreateFrom());
        e.setFreightAmount(c.getFreightAmount());
        e.setReversalDocumentNumber(c.getReversalDocumentNumber());
        e.setWarehouseIdFrom(c.getWarehouseIdFrom());
        e.setWarehouseIdTo(c.getWarehouseIdTo());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractMovementEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementLineCommand.CreateMovementLine innerCommand : c.getMovementLines())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementLineEvent.MovementLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addMovementLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementEvent map(MovementCommand.MergePatchMovement c) {
        MovementEventId stateEventId = new MovementEventId(c.getDocumentNumber(), c.getVersion());
        MovementEvent.MovementStateMergePatched e = newMovementStateMergePatched(stateEventId);
        if (c.getDocumentAction() != null)
        newMovementDocumentActionCommandAndExecute(c, state, e);
        e.setMovementDate(c.getMovementDate());
        e.setPosted(c.getPosted());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDateReceived(c.getDateReceived());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setIsInTransit(c.getIsInTransit());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setShipperId(c.getShipperId());
        e.setSalesRepresentativeId(c.getSalesRepresentativeId());
        e.setBusinessPartnerId(c.getBusinessPartnerId());
        e.setChargeAmount(c.getChargeAmount());
        e.setCreateFrom(c.getCreateFrom());
        e.setFreightAmount(c.getFreightAmount());
        e.setReversalDocumentNumber(c.getReversalDocumentNumber());
        e.setWarehouseIdFrom(c.getWarehouseIdFrom());
        e.setWarehouseIdTo(c.getWarehouseIdTo());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyMovementDateRemoved(c.getIsPropertyMovementDateRemoved());
        e.setIsPropertyPostedRemoved(c.getIsPropertyPostedRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyProcessingRemoved(c.getIsPropertyProcessingRemoved());
        e.setIsPropertyDateReceivedRemoved(c.getIsPropertyDateReceivedRemoved());
        e.setIsPropertyDocumentTypeIdRemoved(c.getIsPropertyDocumentTypeIdRemoved());
        e.setIsPropertyIsInTransitRemoved(c.getIsPropertyIsInTransitRemoved());
        e.setIsPropertyIsApprovedRemoved(c.getIsPropertyIsApprovedRemoved());
        e.setIsPropertyApprovalAmountRemoved(c.getIsPropertyApprovalAmountRemoved());
        e.setIsPropertyShipperIdRemoved(c.getIsPropertyShipperIdRemoved());
        e.setIsPropertySalesRepresentativeIdRemoved(c.getIsPropertySalesRepresentativeIdRemoved());
        e.setIsPropertyBusinessPartnerIdRemoved(c.getIsPropertyBusinessPartnerIdRemoved());
        e.setIsPropertyChargeAmountRemoved(c.getIsPropertyChargeAmountRemoved());
        e.setIsPropertyCreateFromRemoved(c.getIsPropertyCreateFromRemoved());
        e.setIsPropertyFreightAmountRemoved(c.getIsPropertyFreightAmountRemoved());
        e.setIsPropertyReversalDocumentNumberRemoved(c.getIsPropertyReversalDocumentNumberRemoved());
        e.setIsPropertyWarehouseIdFromRemoved(c.getIsPropertyWarehouseIdFromRemoved());
        e.setIsPropertyWarehouseIdToRemoved(c.getIsPropertyWarehouseIdToRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractMovementEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementLineCommand innerCommand : c.getMovementLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementLineEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addMovementLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementEvent map(MovementCommand.DeleteMovement c) {
        MovementEventId stateEventId = new MovementEventId(c.getDocumentNumber(), c.getVersion());
        MovementEvent.MovementStateDeleted e = newMovementStateDeleted(stateEventId);
        ((AbstractMovementEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected MovementLineEvent map(MovementLineCommand c, MovementCommand outerCommand, Long version, MovementState outerState)
    {
        MovementLineCommand.CreateMovementLine create = (c.getCommandType().equals(CommandType.CREATE)) ? ((MovementLineCommand.CreateMovementLine)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        MovementLineCommand.MergePatchMovementLine merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((MovementLineCommand.MergePatchMovementLine)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        MovementLineCommand.RemoveMovementLine remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((MovementLineCommand.RemoveMovementLine)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected MovementLineEvent.MovementLineStateCreated mapCreate(MovementLineCommand.CreateMovementLine c, MovementCommand outerCommand, Long version, MovementState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementLineEventId stateEventId = new MovementLineEventId(c.getMovementDocumentNumber(), c.getLineNumber(), version);
        MovementLineEvent.MovementLineStateCreated e = newMovementLineStateCreated(stateEventId);
        MovementLineState s = outerState.getMovementLines().get(c.getLineNumber());

        e.setMovementQuantity(c.getMovementQuantity());
        e.setProductId(c.getProductId());
        e.setLocatorIdFrom(c.getLocatorIdFrom());
        e.setLocatorIdTo(c.getLocatorIdTo());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected MovementLineEvent.MovementLineStateMergePatched mapMergePatch(MovementLineCommand.MergePatchMovementLine c, MovementCommand outerCommand, Long version, MovementState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementLineEventId stateEventId = new MovementLineEventId(c.getMovementDocumentNumber(), c.getLineNumber(), version);
        MovementLineEvent.MovementLineStateMergePatched e = newMovementLineStateMergePatched(stateEventId);
        MovementLineState s = outerState.getMovementLines().get(c.getLineNumber());

        e.setMovementQuantity(c.getMovementQuantity());
        e.setProductId(c.getProductId());
        e.setLocatorIdFrom(c.getLocatorIdFrom());
        e.setLocatorIdTo(c.getLocatorIdTo());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setActive(c.getActive());
        e.setIsPropertyMovementQuantityRemoved(c.getIsPropertyMovementQuantityRemoved());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyLocatorIdFromRemoved(c.getIsPropertyLocatorIdFromRemoved());
        e.setIsPropertyLocatorIdToRemoved(c.getIsPropertyLocatorIdToRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected MovementLineEvent.MovementLineStateRemoved mapRemove(MovementLineCommand.RemoveMovementLine c, MovementCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementLineEventId stateEventId = new MovementLineEventId(c.getMovementDocumentNumber(), c.getLineNumber(), version);
        MovementLineEvent.MovementLineStateRemoved e = newMovementLineStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(MovementCommand command, MovementLineCommand innerCommand)
    {
        AbstractMovementCommand properties = command instanceof AbstractMovementCommand ? (AbstractMovementCommand) command : null;
        AbstractMovementLineCommand innerProperties = innerCommand instanceof AbstractMovementLineCommand ? (AbstractMovementLineCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerDocumentNumberName = "DocumentNumber";
        String outerDocumentNumberValue = properties.getDocumentNumber();
        String innerMovementDocumentNumberName = "MovementDocumentNumber";
        String innerMovementDocumentNumberValue = innerProperties.getMovementDocumentNumber();
        if (innerMovementDocumentNumberValue == null) {
            innerProperties.setMovementDocumentNumber(outerDocumentNumberValue);
        }
        else if (innerMovementDocumentNumberValue != outerDocumentNumberValue 
            && (innerMovementDocumentNumberValue == null || innerMovementDocumentNumberValue != null && !innerMovementDocumentNumberValue.equals(outerDocumentNumberValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerDocumentNumberName, outerDocumentNumberValue, innerMovementDocumentNumberName, innerMovementDocumentNumberValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected MovementEvent.MovementStateCreated newMovementStateCreated(Long version, String commandId, String requesterId) {
        MovementEventId stateEventId = new MovementEventId(this.state.getDocumentNumber(), version);
        MovementEvent.MovementStateCreated e = newMovementStateCreated(stateEventId);
        ((AbstractMovementEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementEvent.MovementStateMergePatched newMovementStateMergePatched(Long version, String commandId, String requesterId) {
        MovementEventId stateEventId = new MovementEventId(this.state.getDocumentNumber(), version);
        MovementEvent.MovementStateMergePatched e = newMovementStateMergePatched(stateEventId);
        ((AbstractMovementEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementEvent.MovementStateDeleted newMovementStateDeleted(Long version, String commandId, String requesterId) {
        MovementEventId stateEventId = new MovementEventId(this.state.getDocumentNumber(), version);
        MovementEvent.MovementStateDeleted e = newMovementStateDeleted(stateEventId);
        ((AbstractMovementEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementEvent.MovementStateCreated newMovementStateCreated(MovementEventId stateEventId) {
        return new AbstractMovementEvent.SimpleMovementStateCreated(stateEventId);
    }

    protected MovementEvent.MovementStateMergePatched newMovementStateMergePatched(MovementEventId stateEventId) {
        return new AbstractMovementEvent.SimpleMovementStateMergePatched(stateEventId);
    }

    protected MovementEvent.MovementStateDeleted newMovementStateDeleted(MovementEventId stateEventId)
    {
        return new AbstractMovementEvent.SimpleMovementStateDeleted(stateEventId);
    }

    protected MovementLineEvent.MovementLineStateCreated newMovementLineStateCreated(MovementLineEventId stateEventId) {
        return new AbstractMovementLineEvent.SimpleMovementLineStateCreated(stateEventId);
    }

    protected MovementLineEvent.MovementLineStateMergePatched newMovementLineStateMergePatched(MovementLineEventId stateEventId) {
        return new AbstractMovementLineEvent.SimpleMovementLineStateMergePatched(stateEventId);
    }

    protected MovementLineEvent.MovementLineStateRemoved newMovementLineStateRemoved(MovementLineEventId stateEventId)
    {
        return new AbstractMovementLineEvent.SimpleMovementLineStateRemoved(stateEventId);
    }

    protected void newMovementDocumentActionCommandAndExecute(MovementCommand.MergePatchMovement c, MovementState s, MovementEvent.MovementStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    protected void newMovementDocumentActionCommandAndExecute(MovementCommand.CreateMovement c, MovementState s, MovementEvent.MovementStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementDocumentActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    public class SimpleMovementDocumentActionCommandHandler implements PropertyCommandHandler<String, String> {

        public void execute(PropertyCommand<String, String> command) {
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, command.getContent())) {
                command.getStateSetter().accept("Drafted");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Void", command.getContent())) {
                command.getStateSetter().accept("Voided");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Complete", command.getContent()) && ((MovementState)command.getContext()).getIsInTransit() == false) {
                command.getStateSetter().accept("Completed");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Complete", command.getContent()) && ((MovementState)command.getContext()).getIsInTransit() == true) {
                command.getStateSetter().accept("InProgress");
                return;
            }
            if (Objects.equals("InProgress", command.getStateGetter().get()) && Objects.equals("Confirm", command.getContent())) {
                command.getStateSetter().accept("Complete");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Close", command.getContent())) {
                command.getStateSetter().accept("Closed");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Reverse", command.getContent()) && ((MovementState)command.getContext()).getIsInTransit() == false) {
                command.getStateSetter().accept("Reversed");
                return;
            }
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), command.getContent()));
        }
    }

    private PropertyCommandHandler<String, String> movementDocumentActionCommandHandler = new SimpleMovementDocumentActionCommandHandler();

    public void setMovementDocumentActionCommandHandler(PropertyCommandHandler<String, String> h) {
        this.movementDocumentActionCommandHandler = h;
    }

    protected PropertyCommandHandler<String, String> getMovementDocumentActionCommandHandler() {
        Object h = ApplicationContext.current.get("MovementDocumentActionCommandHandler");
        if (h instanceof PropertyCommandHandler) {
            return (PropertyCommandHandler<String, String>) h;
        }
        return this.movementDocumentActionCommandHandler;
    }

    public static class SimpleMovementAggregate extends AbstractMovementAggregate
    {
        public SimpleMovementAggregate(MovementState state) {
            super(state);
        }

        @Override
        public void addLine(String lineNumber, String productId, String locatorIdFrom, String locatorIdTo, java.util.Map<String, Object> attributeSetInstance, String description, String quantityUomId, BigDecimal movementQuantity, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void documentAction(String value, Long version, String commandId, String requesterId) {
            MovementEvent.MovementStateMergePatched e = newMovementStateMergePatched(version, commandId, requesterId);
            documentAction(e, value);
            apply(e);
        }

        protected void documentAction(MovementEvent.MovementStateMergePatched e, String value) {
            doDocumentAction(value, s -> e.setDocumentStatusId(s));
        }

        protected void doDocumentAction(String value, java.util.function.Consumer<String> setDocumentStatusId) {
            PropertyCommandHandler<String, String> pCommandHandler = this.getMovementDocumentActionCommandHandler();
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

