package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementConfirmationAggregate extends AbstractAggregate implements MovementConfirmationAggregate
{
    private MovementConfirmationState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractMovementConfirmationAggregate(MovementConfirmationState state)
    {
        this.state = state;
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
        MovementConfirmationStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementConfirmationCommand.MergePatchMovementConfirmation c)
    {
        MovementConfirmationStateEvent e = map(c);
        apply(e);
    }

    public void delete(MovementConfirmationCommand.DeleteMovementConfirmation c)
    {
        MovementConfirmationStateEvent e = map(c);
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

    protected MovementConfirmationStateEvent map(MovementConfirmationCommand.CreateMovementConfirmation c) {
        MovementConfirmationStateEventId stateEventId = new MovementConfirmationStateEventId(c.getDocumentNumber(), c.getVersion());
        MovementConfirmationStateEvent.MovementConfirmationStateCreated e = newMovementConfirmationStateCreated(stateEventId);
        newMovementConfirmationDocumentActionCommandAndExecute(c, state, e);
        e.setMovementDocumentNumber(c.getMovementDocumentNumber());
        e.setIsApproved(c.getIsApproved());
        e.setApprovalAmount(c.getApprovalAmount());
        e.setProcessed(c.getProcessed());
        e.setProcessing(c.getProcessing());
        e.setDocumentTypeId(c.getDocumentTypeId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractMovementConfirmationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementConfirmationLineCommand.CreateMovementConfirmationLine innerCommand : c.getMovementConfirmationLines())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addMovementConfirmationLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementConfirmationStateEvent map(MovementConfirmationCommand.MergePatchMovementConfirmation c) {
        MovementConfirmationStateEventId stateEventId = new MovementConfirmationStateEventId(c.getDocumentNumber(), c.getVersion());
        MovementConfirmationStateEvent.MovementConfirmationStateMergePatched e = newMovementConfirmationStateMergePatched(stateEventId);
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
        ((AbstractMovementConfirmationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (MovementConfirmationLineCommand innerCommand : c.getMovementConfirmationLineCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            MovementConfirmationLineStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addMovementConfirmationLineEvent(innerEvent);
        }

        return e;
    }

    protected MovementConfirmationStateEvent map(MovementConfirmationCommand.DeleteMovementConfirmation c) {
        MovementConfirmationStateEventId stateEventId = new MovementConfirmationStateEventId(c.getDocumentNumber(), c.getVersion());
        MovementConfirmationStateEvent.MovementConfirmationStateDeleted e = newMovementConfirmationStateDeleted(stateEventId);
        ((AbstractMovementConfirmationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected MovementConfirmationLineStateEvent map(MovementConfirmationLineCommand c, MovementConfirmationCommand outerCommand, long version, MovementConfirmationState outerState)
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

    protected MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated mapCreate(MovementConfirmationLineCommand.CreateMovementConfirmationLine c, MovementConfirmationCommand outerCommand, Long version, MovementConfirmationState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementConfirmationLineStateEventId stateEventId = new MovementConfirmationLineStateEventId(c.getMovementConfirmationDocumentNumber(), c.getLineNumber(), version);
        MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated e = newMovementConfirmationLineStateCreated(stateEventId);
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

    protected MovementConfirmationLineStateEvent.MovementConfirmationLineStateMergePatched mapMergePatch(MovementConfirmationLineCommand.MergePatchMovementConfirmationLine c, MovementConfirmationCommand outerCommand, Long version, MovementConfirmationState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementConfirmationLineStateEventId stateEventId = new MovementConfirmationLineStateEventId(c.getMovementConfirmationDocumentNumber(), c.getLineNumber(), version);
        MovementConfirmationLineStateEvent.MovementConfirmationLineStateMergePatched e = newMovementConfirmationLineStateMergePatched(stateEventId);
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

    protected MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved mapRemove(MovementConfirmationLineCommand.RemoveMovementConfirmationLine c, MovementConfirmationCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        MovementConfirmationLineStateEventId stateEventId = new MovementConfirmationLineStateEventId(c.getMovementConfirmationDocumentNumber(), c.getLineNumber(), version);
        MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved e = newMovementConfirmationLineStateRemoved(stateEventId);

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

    protected MovementConfirmationStateEvent.MovementConfirmationStateCreated newMovementConfirmationStateCreated(Long version, String commandId, String requesterId) {
        MovementConfirmationStateEventId stateEventId = new MovementConfirmationStateEventId(this.state.getDocumentNumber(), version);
        MovementConfirmationStateEvent.MovementConfirmationStateCreated e = newMovementConfirmationStateCreated(stateEventId);
        ((AbstractMovementConfirmationStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationStateEvent.MovementConfirmationStateMergePatched newMovementConfirmationStateMergePatched(Long version, String commandId, String requesterId) {
        MovementConfirmationStateEventId stateEventId = new MovementConfirmationStateEventId(this.state.getDocumentNumber(), version);
        MovementConfirmationStateEvent.MovementConfirmationStateMergePatched e = newMovementConfirmationStateMergePatched(stateEventId);
        ((AbstractMovementConfirmationStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationStateEvent.MovementConfirmationStateDeleted newMovementConfirmationStateDeleted(Long version, String commandId, String requesterId) {
        MovementConfirmationStateEventId stateEventId = new MovementConfirmationStateEventId(this.state.getDocumentNumber(), version);
        MovementConfirmationStateEvent.MovementConfirmationStateDeleted e = newMovementConfirmationStateDeleted(stateEventId);
        ((AbstractMovementConfirmationStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationStateEvent.MovementConfirmationStateCreated newMovementConfirmationStateCreated(MovementConfirmationStateEventId stateEventId) {
        return new AbstractMovementConfirmationStateEvent.SimpleMovementConfirmationStateCreated(stateEventId);
    }

    protected MovementConfirmationStateEvent.MovementConfirmationStateMergePatched newMovementConfirmationStateMergePatched(MovementConfirmationStateEventId stateEventId) {
        return new AbstractMovementConfirmationStateEvent.SimpleMovementConfirmationStateMergePatched(stateEventId);
    }

    protected MovementConfirmationStateEvent.MovementConfirmationStateDeleted newMovementConfirmationStateDeleted(MovementConfirmationStateEventId stateEventId)
    {
        return new AbstractMovementConfirmationStateEvent.SimpleMovementConfirmationStateDeleted(stateEventId);
    }

    protected MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(MovementConfirmationLineStateEventId stateEventId) {
        return new AbstractMovementConfirmationLineStateEvent.SimpleMovementConfirmationLineStateCreated(stateEventId);
    }

    protected MovementConfirmationLineStateEvent.MovementConfirmationLineStateMergePatched newMovementConfirmationLineStateMergePatched(MovementConfirmationLineStateEventId stateEventId) {
        return new AbstractMovementConfirmationLineStateEvent.SimpleMovementConfirmationLineStateMergePatched(stateEventId);
    }

    protected MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(MovementConfirmationLineStateEventId stateEventId)
    {
        return new AbstractMovementConfirmationLineStateEvent.SimpleMovementConfirmationLineStateRemoved(stateEventId);
    }

    protected void newMovementConfirmationDocumentActionCommandAndExecute(MovementConfirmationCommand.CreateMovementConfirmation c, MovementConfirmationState s, MovementConfirmationStateEvent.MovementConfirmationStateCreated e)
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
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, command.getContent())) {
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
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), command.getContent()));
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
            MovementConfirmationStateEvent.MovementConfirmationStateMergePatched e = newMovementConfirmationStateMergePatched(version, commandId, requesterId);
            doDocumentAction(value, s -> e.setDocumentStatusId(s));
            apply(e);
        }

        protected  void doDocumentAction(String value, java.util.function.Consumer<String> setDocumentStatusId) {
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

