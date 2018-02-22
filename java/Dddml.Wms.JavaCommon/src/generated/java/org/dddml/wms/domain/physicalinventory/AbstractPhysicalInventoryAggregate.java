package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPhysicalInventoryAggregate extends AbstractAggregate implements PhysicalInventoryAggregate
{
    private PhysicalInventoryState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPhysicalInventoryAggregate(PhysicalInventoryState state)
    {
        this.state = state;
    }

    public PhysicalInventoryState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PhysicalInventoryCommand.CreatePhysicalInventory c)
    {
        if (c.getVersion() == null) { c.setVersion(PhysicalInventoryState.VERSION_NULL); }
        PhysicalInventoryStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PhysicalInventoryCommand.MergePatchPhysicalInventory c)
    {
        PhysicalInventoryStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PhysicalInventoryCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PhysicalInventoryStateEvent map(PhysicalInventoryCommand.CreatePhysicalInventory c) {
        PhysicalInventoryStateEventId stateEventId = new PhysicalInventoryStateEventId(c.getDocumentNumber(), c.getVersion());
        PhysicalInventoryStateEvent.PhysicalInventoryStateCreated e = newPhysicalInventoryStateCreated(stateEventId);
        newPhysicalInventoryDocumentActionCommandAndExecute(c, state, e);
        e.setWarehouseId(c.getWarehouseId());
        e.setLocatorIdPattern(c.getLocatorIdPattern());
        e.setProductIdPattern(c.getProductIdPattern());
        e.setPosted(c.getPosted());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setMovementDate(c.getMovementDate());
        e.setDescription(c.getDescription());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setIsQuantityUpdated(c.getIsQuantityUpdated());
        e.setReversalDocumentNumber(c.getReversalDocumentNumber());
        e.setActive(c.getActive());
        ((AbstractPhysicalInventoryStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PhysicalInventoryLineCommand.CreatePhysicalInventoryLine innerCommand : c.getPhysicalInventoryLines())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addPhysicalInventoryLineEvent(innerEvent);
        }

        return e;
    }

    protected PhysicalInventoryStateEvent map(PhysicalInventoryCommand.MergePatchPhysicalInventory c) {
        PhysicalInventoryStateEventId stateEventId = new PhysicalInventoryStateEventId(c.getDocumentNumber(), c.getVersion());
        PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setLocatorIdPattern(c.getLocatorIdPattern());
        e.setProductIdPattern(c.getProductIdPattern());
        e.setPosted(c.getPosted());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setMovementDate(c.getMovementDate());
        e.setDescription(c.getDescription());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setIsQuantityUpdated(c.getIsQuantityUpdated());
        e.setReversalDocumentNumber(c.getReversalDocumentNumber());
        e.setActive(c.getActive());
        e.setIsPropertyWarehouseIdRemoved(c.getIsPropertyWarehouseIdRemoved());
        e.setIsPropertyLocatorIdPatternRemoved(c.getIsPropertyLocatorIdPatternRemoved());
        e.setIsPropertyProductIdPatternRemoved(c.getIsPropertyProductIdPatternRemoved());
        e.setIsPropertyPostedRemoved(c.getIsPropertyPostedRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyProcessingRemoved(c.getIsPropertyProcessingRemoved());
        e.setIsPropertyDocumentTypeIdRemoved(c.getIsPropertyDocumentTypeIdRemoved());
        e.setIsPropertyMovementDateRemoved(c.getIsPropertyMovementDateRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyIsApprovedRemoved(c.getIsPropertyIsApprovedRemoved());
        e.setIsPropertyApprovalAmountRemoved(c.getIsPropertyApprovalAmountRemoved());
        e.setIsPropertyIsQuantityUpdatedRemoved(c.getIsPropertyIsQuantityUpdatedRemoved());
        e.setIsPropertyReversalDocumentNumberRemoved(c.getIsPropertyReversalDocumentNumberRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPhysicalInventoryStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PhysicalInventoryLineCommand innerCommand : c.getPhysicalInventoryLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PhysicalInventoryLineStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addPhysicalInventoryLineEvent(innerEvent);
        }

        return e;
    }


    protected PhysicalInventoryLineStateEvent map(PhysicalInventoryLineCommand c, PhysicalInventoryCommand outerCommand, long version, PhysicalInventoryState outerState)
    {
        PhysicalInventoryLineCommand.CreatePhysicalInventoryLine create = (c.getCommandType().equals(CommandType.CREATE)) ? ((PhysicalInventoryLineCommand.CreatePhysicalInventoryLine)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        PhysicalInventoryLineCommand.RemovePhysicalInventoryLine remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((PhysicalInventoryLineCommand.RemovePhysicalInventoryLine)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated mapCreate(PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c, PhysicalInventoryCommand outerCommand, Long version, PhysicalInventoryState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PhysicalInventoryLineStateEventId stateEventId = new PhysicalInventoryLineStateEventId(c.getPhysicalInventoryDocumentNumber(), c.getInventoryItemId(), version);
        PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated e = newPhysicalInventoryLineStateCreated(stateEventId);
        PhysicalInventoryLineState s = outerState.getPhysicalInventoryLines().get(c.getInventoryItemId());

        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched mapMergePatch(PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine c, PhysicalInventoryCommand outerCommand, Long version, PhysicalInventoryState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PhysicalInventoryLineStateEventId stateEventId = new PhysicalInventoryLineStateEventId(c.getPhysicalInventoryDocumentNumber(), c.getInventoryItemId(), version);
        PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched e = newPhysicalInventoryLineStateMergePatched(stateEventId);
        PhysicalInventoryLineState s = outerState.getPhysicalInventoryLines().get(c.getInventoryItemId());

        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setIsPropertyBookQuantityRemoved(c.getIsPropertyBookQuantityRemoved());
        e.setIsPropertyCountedQuantityRemoved(c.getIsPropertyCountedQuantityRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved mapRemove(PhysicalInventoryLineCommand.RemovePhysicalInventoryLine c, PhysicalInventoryCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PhysicalInventoryLineStateEventId stateEventId = new PhysicalInventoryLineStateEventId(c.getPhysicalInventoryDocumentNumber(), c.getInventoryItemId(), version);
        PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved e = newPhysicalInventoryLineStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(PhysicalInventoryCommand command, PhysicalInventoryLineCommand innerCommand)
    {
        AbstractPhysicalInventoryCommand properties = command instanceof AbstractPhysicalInventoryCommand ? (AbstractPhysicalInventoryCommand) command : null;
        AbstractPhysicalInventoryLineCommand innerProperties = innerCommand instanceof AbstractPhysicalInventoryLineCommand ? (AbstractPhysicalInventoryLineCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerDocumentNumberName = "DocumentNumber";
        String outerDocumentNumberValue = properties.getDocumentNumber();
        String innerPhysicalInventoryDocumentNumberName = "PhysicalInventoryDocumentNumber";
        String innerPhysicalInventoryDocumentNumberValue = innerProperties.getPhysicalInventoryDocumentNumber();
        if (innerPhysicalInventoryDocumentNumberValue == null) {
            innerProperties.setPhysicalInventoryDocumentNumber(outerDocumentNumberValue);
        }
        else if (innerPhysicalInventoryDocumentNumberValue != outerDocumentNumberValue 
            && (innerPhysicalInventoryDocumentNumberValue == null || innerPhysicalInventoryDocumentNumberValue != null && !innerPhysicalInventoryDocumentNumberValue.equals(outerDocumentNumberValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerDocumentNumberName, outerDocumentNumberValue, innerPhysicalInventoryDocumentNumberName, innerPhysicalInventoryDocumentNumberValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected PhysicalInventoryStateEvent.PhysicalInventoryStateCreated newPhysicalInventoryStateCreated(Long version, String commandId, String requesterId) {
        PhysicalInventoryStateEventId stateEventId = new PhysicalInventoryStateEventId(this.state.getDocumentNumber(), version);
        PhysicalInventoryStateEvent.PhysicalInventoryStateCreated e = newPhysicalInventoryStateCreated(stateEventId);
        ((AbstractPhysicalInventoryStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched newPhysicalInventoryStateMergePatched(Long version, String commandId, String requesterId) {
        PhysicalInventoryStateEventId stateEventId = new PhysicalInventoryStateEventId(this.state.getDocumentNumber(), version);
        PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(stateEventId);
        ((AbstractPhysicalInventoryStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryStateEvent.PhysicalInventoryStateCreated newPhysicalInventoryStateCreated(PhysicalInventoryStateEventId stateEventId) {
        return new AbstractPhysicalInventoryStateEvent.SimplePhysicalInventoryStateCreated(stateEventId);
    }

    protected PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched newPhysicalInventoryStateMergePatched(PhysicalInventoryStateEventId stateEventId) {
        return new AbstractPhysicalInventoryStateEvent.SimplePhysicalInventoryStateMergePatched(stateEventId);
    }

    protected PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated newPhysicalInventoryLineStateCreated(PhysicalInventoryLineStateEventId stateEventId) {
        return new AbstractPhysicalInventoryLineStateEvent.SimplePhysicalInventoryLineStateCreated(stateEventId);
    }

    protected PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched newPhysicalInventoryLineStateMergePatched(PhysicalInventoryLineStateEventId stateEventId) {
        return new AbstractPhysicalInventoryLineStateEvent.SimplePhysicalInventoryLineStateMergePatched(stateEventId);
    }

    protected PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved newPhysicalInventoryLineStateRemoved(PhysicalInventoryLineStateEventId stateEventId)
    {
        return new AbstractPhysicalInventoryLineStateEvent.SimplePhysicalInventoryLineStateRemoved(stateEventId);
    }

    protected void newPhysicalInventoryDocumentActionCommandAndExecute(PhysicalInventoryCommand.CreatePhysicalInventory c, PhysicalInventoryState s, PhysicalInventoryStateEvent.PhysicalInventoryStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getPhysicalInventoryDocumentActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    private PropertyCommandHandler<String, String> physicalInventoryDocumentActionCommandHandler;

    public void setPhysicalInventoryDocumentActionCommandHandler(PropertyCommandHandler<String, String> h) {
        this.physicalInventoryDocumentActionCommandHandler = h;
    }

    protected PropertyCommandHandler<String, String> getPhysicalInventoryDocumentActionCommandHandler() {
        Object h = ApplicationContext.current.get("PhysicalInventoryDocumentActionCommandHandler");
        if (h instanceof PropertyCommandHandler) {
            return (PropertyCommandHandler<String, String>) h;
        }
        return this.physicalInventoryDocumentActionCommandHandler;
    }

    public static class SimplePhysicalInventoryAggregate extends AbstractPhysicalInventoryAggregate
    {
        public SimplePhysicalInventoryAggregate(PhysicalInventoryState state) {
            super(state);
        }

        @Override
        public void documentAction(String value, Long version, String commandId, String requesterId) {
            PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            doDocumentAction(value, s -> e.setDocumentStatusId(s));
            apply(e);
        }

        protected  void doDocumentAction(String value, java.util.function.Consumer<String> setDocumentStatusId) {
            PropertyCommandHandler<String, String> pCommandHandler = this.getPhysicalInventoryDocumentActionCommandHandler();
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

