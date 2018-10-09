package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPhysicalInventoryAggregate extends AbstractAggregate implements PhysicalInventoryAggregate
{
    private PhysicalInventoryState.MutablePhysicalInventoryState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPhysicalInventoryAggregate(PhysicalInventoryState state)
    {
        this.state = (PhysicalInventoryState.MutablePhysicalInventoryState)state;
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
        PhysicalInventoryEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PhysicalInventoryCommand.MergePatchPhysicalInventory c)
    {
        PhysicalInventoryEvent e = map(c);
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

    protected PhysicalInventoryEvent map(PhysicalInventoryCommand.CreatePhysicalInventory c) {
        PhysicalInventoryEventId stateEventId = new PhysicalInventoryEventId(c.getDocumentNumber(), c.getVersion());
        PhysicalInventoryEvent.PhysicalInventoryStateCreated e = newPhysicalInventoryStateCreated(stateEventId);
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
        ((AbstractPhysicalInventoryEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PhysicalInventoryLineCommand.CreatePhysicalInventoryLine innerCommand : c.getCreatePhysicalInventoryLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addPhysicalInventoryLineEvent(innerEvent);
        }

        return e;
    }

    protected PhysicalInventoryEvent map(PhysicalInventoryCommand.MergePatchPhysicalInventory c) {
        PhysicalInventoryEventId stateEventId = new PhysicalInventoryEventId(c.getDocumentNumber(), c.getVersion());
        PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(stateEventId);
        if (c.getDocumentAction() != null)
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
        ((AbstractPhysicalInventoryEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PhysicalInventoryLineCommand innerCommand : c.getPhysicalInventoryLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PhysicalInventoryLineEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addPhysicalInventoryLineEvent(innerEvent);
        }

        return e;
    }


    protected PhysicalInventoryLineEvent map(PhysicalInventoryLineCommand c, PhysicalInventoryCommand outerCommand, Long version, PhysicalInventoryState outerState)
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

    protected PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated mapCreate(PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c, PhysicalInventoryCommand outerCommand, Long version, PhysicalInventoryState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PhysicalInventoryLineEventId stateEventId = new PhysicalInventoryLineEventId(c.getPhysicalInventoryDocumentNumber(), c.getInventoryItemId(), version);
        PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e = newPhysicalInventoryLineStateCreated(stateEventId);
        PhysicalInventoryLineState s = outerState.getPhysicalInventoryLines().get(c.getInventoryItemId());

        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setLineNumber(c.getLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched mapMergePatch(PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine c, PhysicalInventoryCommand outerCommand, Long version, PhysicalInventoryState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PhysicalInventoryLineEventId stateEventId = new PhysicalInventoryLineEventId(c.getPhysicalInventoryDocumentNumber(), c.getInventoryItemId(), version);
        PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched e = newPhysicalInventoryLineStateMergePatched(stateEventId);
        PhysicalInventoryLineState s = outerState.getPhysicalInventoryLines().get(c.getInventoryItemId());

        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setLineNumber(c.getLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setIsPropertyBookQuantityRemoved(c.getIsPropertyBookQuantityRemoved());
        e.setIsPropertyCountedQuantityRemoved(c.getIsPropertyCountedQuantityRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyLineNumberRemoved(c.getIsPropertyLineNumberRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved mapRemove(PhysicalInventoryLineCommand.RemovePhysicalInventoryLine c, PhysicalInventoryCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PhysicalInventoryLineEventId stateEventId = new PhysicalInventoryLineEventId(c.getPhysicalInventoryDocumentNumber(), c.getInventoryItemId(), version);
        PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved e = newPhysicalInventoryLineStateRemoved(stateEventId);

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

    protected PhysicalInventoryEvent.PhysicalInventoryStateCreated newPhysicalInventoryStateCreated(Long version, String commandId, String requesterId) {
        PhysicalInventoryEventId stateEventId = new PhysicalInventoryEventId(this.state.getDocumentNumber(), version);
        PhysicalInventoryEvent.PhysicalInventoryStateCreated e = newPhysicalInventoryStateCreated(stateEventId);
        ((AbstractPhysicalInventoryEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryEvent.PhysicalInventoryStateMergePatched newPhysicalInventoryStateMergePatched(Long version, String commandId, String requesterId) {
        PhysicalInventoryEventId stateEventId = new PhysicalInventoryEventId(this.state.getDocumentNumber(), version);
        PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(stateEventId);
        ((AbstractPhysicalInventoryEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryEvent.PhysicalInventoryStateCreated newPhysicalInventoryStateCreated(PhysicalInventoryEventId stateEventId) {
        return new AbstractPhysicalInventoryEvent.SimplePhysicalInventoryStateCreated(stateEventId);
    }

    protected PhysicalInventoryEvent.PhysicalInventoryStateMergePatched newPhysicalInventoryStateMergePatched(PhysicalInventoryEventId stateEventId) {
        return new AbstractPhysicalInventoryEvent.SimplePhysicalInventoryStateMergePatched(stateEventId);
    }

    protected PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated newPhysicalInventoryLineStateCreated(PhysicalInventoryLineEventId stateEventId) {
        return new AbstractPhysicalInventoryLineEvent.SimplePhysicalInventoryLineStateCreated(stateEventId);
    }

    protected PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched newPhysicalInventoryLineStateMergePatched(PhysicalInventoryLineEventId stateEventId) {
        return new AbstractPhysicalInventoryLineEvent.SimplePhysicalInventoryLineStateMergePatched(stateEventId);
    }

    protected PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved newPhysicalInventoryLineStateRemoved(PhysicalInventoryLineEventId stateEventId)
    {
        return new AbstractPhysicalInventoryLineEvent.SimplePhysicalInventoryLineStateRemoved(stateEventId);
    }

    protected void newPhysicalInventoryDocumentActionCommandAndExecute(PhysicalInventoryCommand.MergePatchPhysicalInventory c, PhysicalInventoryState s, PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getPhysicalInventoryDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    protected void newPhysicalInventoryDocumentActionCommandAndExecute(PhysicalInventoryCommand.CreatePhysicalInventory c, PhysicalInventoryState s, PhysicalInventoryEvent.PhysicalInventoryStateCreated e)
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

    public class SimplePhysicalInventoryDocumentActionCommandHandler implements PropertyCommandHandler<String, String> {

        public void execute(PropertyCommand<String, String> command) {
            String trigger = command.getContent();
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, trigger)) {
                command.getStateSetter().accept("Drafted");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Complete", trigger)) {
                command.getStateSetter().accept("Completed");
                return;
            }
            if (Objects.equals("Drafted", command.getStateGetter().get()) && Objects.equals("Void", trigger)) {
                command.getStateSetter().accept("Voided");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Close", trigger)) {
                command.getStateSetter().accept("Closed");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Reverse", trigger)) {
                command.getStateSetter().accept("Reversed");
                return;
            }
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), trigger));
        }
    }

    private PropertyCommandHandler<String, String> physicalInventoryDocumentActionCommandHandler = new SimplePhysicalInventoryDocumentActionCommandHandler();

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
        public void countItem(String locatorId, String productId, java.util.Map<String, Object> attributeSetInstance, BigDecimal countedQuantity, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void documentAction(String value, Long version, String commandId, String requesterId) {
            PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            documentAction(e, value);
            apply(e);
        }

        protected void documentAction(PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e, String value) {
            doDocumentAction(value, s -> e.setDocumentStatusId(s));
        }

        protected void doDocumentAction(String value, java.util.function.Consumer<String> setDocumentStatusId) {
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

