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
        MovementStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementCommand.MergePatchMovement c)
    {
        MovementStateEvent e = map(c);
        apply(e);
    }

    public void delete(MovementCommand.DeleteMovement c)
    {
        MovementStateEvent e = map(c);
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

    protected MovementStateEvent map(MovementCommand.CreateMovement c) {
        MovementStateEventId stateEventId = new MovementStateEventId(c.getDocumentNumber(), c.getVersion());
        MovementStateEvent.MovementStateCreated e = newMovementStateCreated(stateEventId);
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
        ((AbstractMovementStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementLineCommand.CreateMovementLine innerCommand : c.getMovementLines())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementLineStateEvent.MovementLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addMovementLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementStateEvent map(MovementCommand.MergePatchMovement c) {
        MovementStateEventId stateEventId = new MovementStateEventId(c.getDocumentNumber(), c.getVersion());
        MovementStateEvent.MovementStateMergePatched e = newMovementStateMergePatched(stateEventId);
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
        ((AbstractMovementStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementLineCommand innerCommand : c.getMovementLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementLineStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addMovementLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementStateEvent map(MovementCommand.DeleteMovement c) {
        MovementStateEventId stateEventId = new MovementStateEventId(c.getDocumentNumber(), c.getVersion());
        MovementStateEvent.MovementStateDeleted e = newMovementStateDeleted(stateEventId);
        ((AbstractMovementStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected MovementLineStateEvent map(MovementLineCommand c, MovementCommand outerCommand, long version, MovementState outerState)
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

    protected MovementLineStateEvent.MovementLineStateCreated mapCreate(MovementLineCommand.CreateMovementLine c, MovementCommand outerCommand, Long version, MovementState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementLineStateEventId stateEventId = new MovementLineStateEventId(c.getMovementDocumentNumber(), c.getLineNumber(), version);
        MovementLineStateEvent.MovementLineStateCreated e = newMovementLineStateCreated(stateEventId);
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

    protected MovementLineStateEvent.MovementLineStateMergePatched mapMergePatch(MovementLineCommand.MergePatchMovementLine c, MovementCommand outerCommand, Long version, MovementState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementLineStateEventId stateEventId = new MovementLineStateEventId(c.getMovementDocumentNumber(), c.getLineNumber(), version);
        MovementLineStateEvent.MovementLineStateMergePatched e = newMovementLineStateMergePatched(stateEventId);
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

    protected MovementLineStateEvent.MovementLineStateRemoved mapRemove(MovementLineCommand.RemoveMovementLine c, MovementCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementLineStateEventId stateEventId = new MovementLineStateEventId(c.getMovementDocumentNumber(), c.getLineNumber(), version);
        MovementLineStateEvent.MovementLineStateRemoved e = newMovementLineStateRemoved(stateEventId);

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

    protected MovementStateEvent.MovementStateCreated newMovementStateCreated(String commandId, String requesterId) {
        MovementStateEventId stateEventId = new MovementStateEventId(this.state.getDocumentNumber(), this.state.getVersion());
        MovementStateEvent.MovementStateCreated e = newMovementStateCreated(stateEventId);
        ((AbstractMovementStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementStateEvent.MovementStateMergePatched newMovementStateMergePatched(String commandId, String requesterId) {
        MovementStateEventId stateEventId = new MovementStateEventId(this.state.getDocumentNumber(), this.state.getVersion());
        MovementStateEvent.MovementStateMergePatched e = newMovementStateMergePatched(stateEventId);
        ((AbstractMovementStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementStateEvent.MovementStateDeleted newMovementStateDeleted(String commandId, String requesterId) {
        MovementStateEventId stateEventId = new MovementStateEventId(this.state.getDocumentNumber(), this.state.getVersion());
        MovementStateEvent.MovementStateDeleted e = newMovementStateDeleted(stateEventId);
        ((AbstractMovementStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementStateEvent.MovementStateCreated newMovementStateCreated(MovementStateEventId stateEventId) {
        return new AbstractMovementStateEvent.SimpleMovementStateCreated(stateEventId);
    }

    protected MovementStateEvent.MovementStateMergePatched newMovementStateMergePatched(MovementStateEventId stateEventId) {
        return new AbstractMovementStateEvent.SimpleMovementStateMergePatched(stateEventId);
    }

    protected MovementStateEvent.MovementStateDeleted newMovementStateDeleted(MovementStateEventId stateEventId)
    {
        return new AbstractMovementStateEvent.SimpleMovementStateDeleted(stateEventId);
    }

    protected MovementLineStateEvent.MovementLineStateCreated newMovementLineStateCreated(MovementLineStateEventId stateEventId) {
        return new AbstractMovementLineStateEvent.SimpleMovementLineStateCreated(stateEventId);
    }

    protected MovementLineStateEvent.MovementLineStateMergePatched newMovementLineStateMergePatched(MovementLineStateEventId stateEventId) {
        return new AbstractMovementLineStateEvent.SimpleMovementLineStateMergePatched(stateEventId);
    }

    protected MovementLineStateEvent.MovementLineStateRemoved newMovementLineStateRemoved(MovementLineStateEventId stateEventId)
    {
        return new AbstractMovementLineStateEvent.SimpleMovementLineStateRemoved(stateEventId);
    }

    protected void newMovementDocumentActionCommandAndExecute(MovementCommand.CreateMovement c, MovementState s, MovementStateEvent.MovementStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementDocumentActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCommandHandler.execute(pCmd);
    }

    protected PropertyCommandHandler<String, String> getMovementDocumentActionCommandHandler()
    {
        return (PropertyCommandHandler<String, String>)ApplicationContext.current.get("MovementDocumentActionCommandHandler");
    }

    public static class SimpleMovementAggregate extends AbstractMovementAggregate
    {
        public SimpleMovementAggregate(MovementState state) {
            super(state);
        }

        @Override
        public void documentAction(String value, String commandId, String requesterId) {
            MovementStateEvent.MovementStateMergePatched e = newMovementStateMergePatched(commandId, requesterId);
            // ////////////////////////////
            PropertyCommandHandler<String, String> pCommandHandler = this.getMovementDocumentActionCommandHandler();
            PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<>();
            pCmd.setContent(value);
            pCmd.setStateGetter(() -> this.getState().getDocumentStatusId());
            pCmd.setStateSetter(s -> e.setDocumentStatusId(s));
            pCmd.setOuterCommandType("DocumentAction");
            pCommandHandler.execute(pCmd);
            // ////////////////////////////
            apply(e);
        }

    }

}

