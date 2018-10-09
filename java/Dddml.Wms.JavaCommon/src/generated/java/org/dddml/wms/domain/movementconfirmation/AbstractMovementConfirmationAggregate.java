package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementConfirmationAggregate extends AbstractAggregate implements MovementConfirmationAggregate
{
    private MovementConfirmationState.MutableMovementConfirmationState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractMovementConfirmationAggregate(MovementConfirmationState state)
    {
        this.state = (MovementConfirmationState.MutableMovementConfirmationState)state;
    }

    public MovementConfirmationState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(MovementConfirmationCommand.CreateMovementConfirmation c)
    {
        if (c.getVersion() == null) { c.setVersion(MovementConfirmationState.VERSION_NULL); }
        MovementConfirmationEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementConfirmationCommand.MergePatchMovementConfirmation c)
    {
        try {
            verifyPatch(c);
        } catch (Exception ex) {
            throw new DomainError("VerificationFailed", ex);
        }
        MovementConfirmationEvent e = map(c);
        apply(e);
    }

    private void verifyPatch(MovementConfirmationCommand.MergePatchMovementConfirmation c) {
        String movementDocumentNumber = c.getMovementDocumentNumber();
        String MovementDocumentNumber = movementDocumentNumber;
        Boolean isApproved = c.getIsApproved();
        Boolean IsApproved = isApproved;
        BigDecimal approvalAmount = c.getApprovalAmount();
        BigDecimal ApprovalAmount = approvalAmount;
        Boolean processed = c.getProcessed();
        Boolean Processed = processed;
        String processing = c.getProcessing();
        String Processing = processing;
        String documentTypeId = c.getDocumentTypeId();
        String DocumentTypeId = documentTypeId;
        String description = c.getDescription();
        String Description = description;

        if (!"InProgress".equalsIgnoreCase(getState().getDocumentStatusId())) { throw new IllegalArgumentException("DocumentStatus error."); }

    }

    public void delete(MovementConfirmationCommand.DeleteMovementConfirmation c)
    {
        MovementConfirmationEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        MovementConfirmationCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected MovementConfirmationEvent map(MovementConfirmationCommand.CreateMovementConfirmation c) {
        MovementConfirmationEventId stateEventId = new MovementConfirmationEventId(c.getDocumentNumber(), c.getVersion());
        MovementConfirmationEvent.MovementConfirmationStateCreated e = newMovementConfirmationStateCreated(stateEventId);
        newMovementConfirmationDocumentActionCommandAndExecute(c, state, e);
        e.setMovementDocumentNumber(c.getMovementDocumentNumber());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractMovementConfirmationEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementConfirmationLineCommand.CreateMovementConfirmationLine innerCommand : c.getCreateMovementConfirmationLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementConfirmationLineEvent.MovementConfirmationLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addMovementConfirmationLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementConfirmationEvent map(MovementConfirmationCommand.MergePatchMovementConfirmation c) {
        MovementConfirmationEventId stateEventId = new MovementConfirmationEventId(c.getDocumentNumber(), c.getVersion());
        MovementConfirmationEvent.MovementConfirmationStateMergePatched e = newMovementConfirmationStateMergePatched(stateEventId);
        if (c.getDocumentAction() != null)
        newMovementConfirmationDocumentActionCommandAndExecute(c, state, e);
        e.setMovementDocumentNumber(c.getMovementDocumentNumber());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyMovementDocumentNumberRemoved(c.getIsPropertyMovementDocumentNumberRemoved());
        e.setIsPropertyIsApprovedRemoved(c.getIsPropertyIsApprovedRemoved());
        e.setIsPropertyApprovalAmountRemoved(c.getIsPropertyApprovalAmountRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyProcessingRemoved(c.getIsPropertyProcessingRemoved());
        e.setIsPropertyDocumentTypeIdRemoved(c.getIsPropertyDocumentTypeIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractMovementConfirmationEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementConfirmationLineCommand innerCommand : c.getMovementConfirmationLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementConfirmationLineEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addMovementConfirmationLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementConfirmationEvent map(MovementConfirmationCommand.DeleteMovementConfirmation c) {
        MovementConfirmationEventId stateEventId = new MovementConfirmationEventId(c.getDocumentNumber(), c.getVersion());
        MovementConfirmationEvent.MovementConfirmationStateDeleted e = newMovementConfirmationStateDeleted(stateEventId);
        ((AbstractMovementConfirmationEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected MovementConfirmationLineEvent map(MovementConfirmationLineCommand c, MovementConfirmationCommand outerCommand, Long version, MovementConfirmationState outerState)
    {
        MovementConfirmationLineCommand.CreateMovementConfirmationLine create = (c.getCommandType().equals(CommandType.CREATE)) ? ((MovementConfirmationLineCommand.CreateMovementConfirmationLine)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        MovementConfirmationLineCommand.MergePatchMovementConfirmationLine merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((MovementConfirmationLineCommand.MergePatchMovementConfirmationLine)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        MovementConfirmationLineCommand.RemoveMovementConfirmationLine remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((MovementConfirmationLineCommand.RemoveMovementConfirmationLine)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected MovementConfirmationLineEvent.MovementConfirmationLineStateCreated mapCreate(MovementConfirmationLineCommand.CreateMovementConfirmationLine c, MovementConfirmationCommand outerCommand, Long version, MovementConfirmationState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementConfirmationLineEventId stateEventId = new MovementConfirmationLineEventId(c.getMovementConfirmationDocumentNumber(), c.getLineNumber(), version);
        MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e = newMovementConfirmationLineStateCreated(stateEventId);
        MovementConfirmationLineState s = outerState.getMovementConfirmationLines().get(c.getLineNumber());

        e.setMovementLineNumber(c.getMovementLineNumber());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setDifferenceQuantity(c.getDifferenceQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setDescription(c.getDescription());
        e.setProcessed(c.getProcessed());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched mapMergePatch(MovementConfirmationLineCommand.MergePatchMovementConfirmationLine c, MovementConfirmationCommand outerCommand, Long version, MovementConfirmationState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementConfirmationLineEventId stateEventId = new MovementConfirmationLineEventId(c.getMovementConfirmationDocumentNumber(), c.getLineNumber(), version);
        MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched e = newMovementConfirmationLineStateMergePatched(stateEventId);
        MovementConfirmationLineState s = outerState.getMovementConfirmationLines().get(c.getLineNumber());

        e.setMovementLineNumber(c.getMovementLineNumber());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setDifferenceQuantity(c.getDifferenceQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setDescription(c.getDescription());
        e.setProcessed(c.getProcessed());
        e.setActive(c.getActive());
        e.setIsPropertyMovementLineNumberRemoved(c.getIsPropertyMovementLineNumberRemoved());
        e.setIsPropertyTargetQuantityRemoved(c.getIsPropertyTargetQuantityRemoved());
        e.setIsPropertyConfirmedQuantityRemoved(c.getIsPropertyConfirmedQuantityRemoved());
        e.setIsPropertyDifferenceQuantityRemoved(c.getIsPropertyDifferenceQuantityRemoved());
        e.setIsPropertyScrappedQuantityRemoved(c.getIsPropertyScrappedQuantityRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved mapRemove(MovementConfirmationLineCommand.RemoveMovementConfirmationLine c, MovementConfirmationCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementConfirmationLineEventId stateEventId = new MovementConfirmationLineEventId(c.getMovementConfirmationDocumentNumber(), c.getLineNumber(), version);
        MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e = newMovementConfirmationLineStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(MovementConfirmationCommand command, MovementConfirmationLineCommand innerCommand)
    {
        AbstractMovementConfirmationCommand properties = command instanceof AbstractMovementConfirmationCommand ? (AbstractMovementConfirmationCommand) command : null;
        AbstractMovementConfirmationLineCommand innerProperties = innerCommand instanceof AbstractMovementConfirmationLineCommand ? (AbstractMovementConfirmationLineCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerDocumentNumberName = "DocumentNumber";
        String outerDocumentNumberValue = properties.getDocumentNumber();
        String innerMovementConfirmationDocumentNumberName = "MovementConfirmationDocumentNumber";
        String innerMovementConfirmationDocumentNumberValue = innerProperties.getMovementConfirmationDocumentNumber();
        if (innerMovementConfirmationDocumentNumberValue == null) {
            innerProperties.setMovementConfirmationDocumentNumber(outerDocumentNumberValue);
        }
        else if (innerMovementConfirmationDocumentNumberValue != outerDocumentNumberValue 
            && (innerMovementConfirmationDocumentNumberValue == null || innerMovementConfirmationDocumentNumberValue != null && !innerMovementConfirmationDocumentNumberValue.equals(outerDocumentNumberValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerDocumentNumberName, outerDocumentNumberValue, innerMovementConfirmationDocumentNumberName, innerMovementConfirmationDocumentNumberValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected MovementConfirmationEvent.MovementConfirmationStateCreated newMovementConfirmationStateCreated(Long version, String commandId, String requesterId) {
        MovementConfirmationEventId stateEventId = new MovementConfirmationEventId(this.state.getDocumentNumber(), version);
        MovementConfirmationEvent.MovementConfirmationStateCreated e = newMovementConfirmationStateCreated(stateEventId);
        ((AbstractMovementConfirmationEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationEvent.MovementConfirmationStateMergePatched newMovementConfirmationStateMergePatched(Long version, String commandId, String requesterId) {
        MovementConfirmationEventId stateEventId = new MovementConfirmationEventId(this.state.getDocumentNumber(), version);
        MovementConfirmationEvent.MovementConfirmationStateMergePatched e = newMovementConfirmationStateMergePatched(stateEventId);
        ((AbstractMovementConfirmationEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationEvent.MovementConfirmationStateDeleted newMovementConfirmationStateDeleted(Long version, String commandId, String requesterId) {
        MovementConfirmationEventId stateEventId = new MovementConfirmationEventId(this.state.getDocumentNumber(), version);
        MovementConfirmationEvent.MovementConfirmationStateDeleted e = newMovementConfirmationStateDeleted(stateEventId);
        ((AbstractMovementConfirmationEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationEvent.MovementConfirmationStateCreated newMovementConfirmationStateCreated(MovementConfirmationEventId stateEventId) {
        return new AbstractMovementConfirmationEvent.SimpleMovementConfirmationStateCreated(stateEventId);
    }

    protected MovementConfirmationEvent.MovementConfirmationStateMergePatched newMovementConfirmationStateMergePatched(MovementConfirmationEventId stateEventId) {
        return new AbstractMovementConfirmationEvent.SimpleMovementConfirmationStateMergePatched(stateEventId);
    }

    protected MovementConfirmationEvent.MovementConfirmationStateDeleted newMovementConfirmationStateDeleted(MovementConfirmationEventId stateEventId)
    {
        return new AbstractMovementConfirmationEvent.SimpleMovementConfirmationStateDeleted(stateEventId);
    }

    protected MovementConfirmationLineEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(MovementConfirmationLineEventId stateEventId) {
        return new AbstractMovementConfirmationLineEvent.SimpleMovementConfirmationLineStateCreated(stateEventId);
    }

    protected MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched newMovementConfirmationLineStateMergePatched(MovementConfirmationLineEventId stateEventId) {
        return new AbstractMovementConfirmationLineEvent.SimpleMovementConfirmationLineStateMergePatched(stateEventId);
    }

    protected MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(MovementConfirmationLineEventId stateEventId)
    {
        return new AbstractMovementConfirmationLineEvent.SimpleMovementConfirmationLineStateRemoved(stateEventId);
    }

    protected void newMovementConfirmationDocumentActionCommandAndExecute(MovementConfirmationCommand.MergePatchMovementConfirmation c, MovementConfirmationState s, MovementConfirmationEvent.MovementConfirmationStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementConfirmationDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    protected void newMovementConfirmationDocumentActionCommandAndExecute(MovementConfirmationCommand.CreateMovementConfirmation c, MovementConfirmationState s, MovementConfirmationEvent.MovementConfirmationStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementConfirmationDocumentActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getDocumentStatusId());
        pCmd.setStateSetter(p -> e.setDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    public class SimpleMovementConfirmationDocumentActionCommandHandler implements PropertyCommandHandler<String, String> {

        public void execute(PropertyCommand<String, String> command) {
            String trigger = command.getContent();
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, trigger)) {
                command.getStateSetter().accept("InProgress");
                return;
            }
            if (Objects.equals("InProgress", command.getStateGetter().get()) && Objects.equals("Confirm", trigger)) {
                command.getStateSetter().accept("Completed");
                return;
            }
            if (Objects.equals("Completed", command.getStateGetter().get()) && Objects.equals("Close", trigger)) {
                command.getStateSetter().accept("Closed");
                return;
            }
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), trigger));
        }
    }

    private PropertyCommandHandler<String, String> movementConfirmationDocumentActionCommandHandler = new SimpleMovementConfirmationDocumentActionCommandHandler();

    public void setMovementConfirmationDocumentActionCommandHandler(PropertyCommandHandler<String, String> h) {
        this.movementConfirmationDocumentActionCommandHandler = h;
    }

    protected PropertyCommandHandler<String, String> getMovementConfirmationDocumentActionCommandHandler() {
        Object h = ApplicationContext.current.get("MovementConfirmationDocumentActionCommandHandler");
        if (h instanceof PropertyCommandHandler) {
            return (PropertyCommandHandler<String, String>) h;
        }
        return this.movementConfirmationDocumentActionCommandHandler;
    }

    public static class SimpleMovementConfirmationAggregate extends AbstractMovementConfirmationAggregate
    {
        public SimpleMovementConfirmationAggregate(MovementConfirmationState state) {
            super(state);
        }

        @Override
        public void documentAction(String value, Long version, String commandId, String requesterId) {
            MovementConfirmationEvent.MovementConfirmationStateMergePatched e = newMovementConfirmationStateMergePatched(version, commandId, requesterId);
            documentAction(e, value);
            apply(e);
        }

        protected void documentAction(MovementConfirmationEvent.MovementConfirmationStateMergePatched e, String value) {
            doDocumentAction(value, s -> e.setDocumentStatusId(s));
        }

        protected void doDocumentAction(String value, java.util.function.Consumer<String> setDocumentStatusId) {
            PropertyCommandHandler<String, String> pCommandHandler = this.getMovementConfirmationDocumentActionCommandHandler();
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

