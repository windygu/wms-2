package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementConfirmationLineMvoAggregate extends AbstractAggregate implements MovementConfirmationLineMvoAggregate
{
    private MovementConfirmationLineMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractMovementConfirmationLineMvoAggregate(MovementConfirmationLineMvoState state)
    {
        this.state = state;
    }

    public MovementConfirmationLineMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c)
    {
        if (c.getMovementConfirmationVersion() == null) { c.setMovementConfirmationVersion(MovementConfirmationLineMvoState.VERSION_NULL); }
        MovementConfirmationLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c)
    {
        MovementConfirmationLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c)
    {
        MovementConfirmationLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        MovementConfirmationLineMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected MovementConfirmationLineMvoStateEvent map(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c) {
        MovementConfirmationLineMvoStateEventId stateEventId = new MovementConfirmationLineMvoStateEventId(c.getMovementConfirmationLineId(), c.getMovementConfirmationVersion());
        MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated e = newMovementConfirmationLineMvoStateCreated(stateEventId);
        e.setMovementLineNumber(c.getMovementLineNumber());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setDifferenceQuantity(c.getDifferenceQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setDescription(c.getDescription());
        e.setProcessed(c.getProcessed());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        newMovementConfirmationLineMvoDocumentActionCommandAndExecute(c, state, e);
        e.setMovementConfirmationMovementDocumentNumber(c.getMovementConfirmationMovementDocumentNumber());
        e.setMovementConfirmationIsApproved(c.getMovementConfirmationIsApproved());
        e.setMovementConfirmationApprovalAmount(c.getMovementConfirmationApprovalAmount());
        e.setMovementConfirmationProcessed(c.getMovementConfirmationProcessed());
        e.setMovementConfirmationProcessing(c.getMovementConfirmationProcessing());
        e.setMovementConfirmationDocumentTypeId(c.getMovementConfirmationDocumentTypeId());
        e.setMovementConfirmationDescription(c.getMovementConfirmationDescription());
        e.setMovementConfirmationCreatedBy(c.getMovementConfirmationCreatedBy());
        e.setMovementConfirmationCreatedAt(c.getMovementConfirmationCreatedAt());
        e.setMovementConfirmationUpdatedBy(c.getMovementConfirmationUpdatedBy());
        e.setMovementConfirmationUpdatedAt(c.getMovementConfirmationUpdatedAt());
        e.setMovementConfirmationActive(c.getMovementConfirmationActive());
        e.setMovementConfirmationDeleted(c.getMovementConfirmationDeleted());
        ((AbstractMovementConfirmationLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoStateEvent map(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c) {
        MovementConfirmationLineMvoStateEventId stateEventId = new MovementConfirmationLineMvoStateEventId(c.getMovementConfirmationLineId(), c.getMovementConfirmationVersion());
        MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e = newMovementConfirmationLineMvoStateMergePatched(stateEventId);
        e.setMovementLineNumber(c.getMovementLineNumber());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setDifferenceQuantity(c.getDifferenceQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setDescription(c.getDescription());
        e.setProcessed(c.getProcessed());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        newMovementConfirmationLineMvoDocumentActionCommandAndExecute(c, state, e);
        e.setMovementConfirmationMovementDocumentNumber(c.getMovementConfirmationMovementDocumentNumber());
        e.setMovementConfirmationIsApproved(c.getMovementConfirmationIsApproved());
        e.setMovementConfirmationApprovalAmount(c.getMovementConfirmationApprovalAmount());
        e.setMovementConfirmationProcessed(c.getMovementConfirmationProcessed());
        e.setMovementConfirmationProcessing(c.getMovementConfirmationProcessing());
        e.setMovementConfirmationDocumentTypeId(c.getMovementConfirmationDocumentTypeId());
        e.setMovementConfirmationDescription(c.getMovementConfirmationDescription());
        e.setMovementConfirmationCreatedBy(c.getMovementConfirmationCreatedBy());
        e.setMovementConfirmationCreatedAt(c.getMovementConfirmationCreatedAt());
        e.setMovementConfirmationUpdatedBy(c.getMovementConfirmationUpdatedBy());
        e.setMovementConfirmationUpdatedAt(c.getMovementConfirmationUpdatedAt());
        e.setMovementConfirmationActive(c.getMovementConfirmationActive());
        e.setMovementConfirmationDeleted(c.getMovementConfirmationDeleted());
        e.setIsPropertyMovementLineNumberRemoved(c.getIsPropertyMovementLineNumberRemoved());
        e.setIsPropertyTargetQuantityRemoved(c.getIsPropertyTargetQuantityRemoved());
        e.setIsPropertyConfirmedQuantityRemoved(c.getIsPropertyConfirmedQuantityRemoved());
        e.setIsPropertyDifferenceQuantityRemoved(c.getIsPropertyDifferenceQuantityRemoved());
        e.setIsPropertyScrappedQuantityRemoved(c.getIsPropertyScrappedQuantityRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyMovementConfirmationMovementDocumentNumberRemoved(c.getIsPropertyMovementConfirmationMovementDocumentNumberRemoved());
        e.setIsPropertyMovementConfirmationIsApprovedRemoved(c.getIsPropertyMovementConfirmationIsApprovedRemoved());
        e.setIsPropertyMovementConfirmationApprovalAmountRemoved(c.getIsPropertyMovementConfirmationApprovalAmountRemoved());
        e.setIsPropertyMovementConfirmationProcessedRemoved(c.getIsPropertyMovementConfirmationProcessedRemoved());
        e.setIsPropertyMovementConfirmationProcessingRemoved(c.getIsPropertyMovementConfirmationProcessingRemoved());
        e.setIsPropertyMovementConfirmationDocumentTypeIdRemoved(c.getIsPropertyMovementConfirmationDocumentTypeIdRemoved());
        e.setIsPropertyMovementConfirmationDescriptionRemoved(c.getIsPropertyMovementConfirmationDescriptionRemoved());
        e.setIsPropertyMovementConfirmationCreatedByRemoved(c.getIsPropertyMovementConfirmationCreatedByRemoved());
        e.setIsPropertyMovementConfirmationCreatedAtRemoved(c.getIsPropertyMovementConfirmationCreatedAtRemoved());
        e.setIsPropertyMovementConfirmationUpdatedByRemoved(c.getIsPropertyMovementConfirmationUpdatedByRemoved());
        e.setIsPropertyMovementConfirmationUpdatedAtRemoved(c.getIsPropertyMovementConfirmationUpdatedAtRemoved());
        e.setIsPropertyMovementConfirmationActiveRemoved(c.getIsPropertyMovementConfirmationActiveRemoved());
        e.setIsPropertyMovementConfirmationDeletedRemoved(c.getIsPropertyMovementConfirmationDeletedRemoved());
        ((AbstractMovementConfirmationLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoStateEvent map(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c) {
        MovementConfirmationLineMvoStateEventId stateEventId = new MovementConfirmationLineMvoStateEventId(c.getMovementConfirmationLineId(), c.getMovementConfirmationVersion());
        MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted e = newMovementConfirmationLineMvoStateDeleted(stateEventId);
        ((AbstractMovementConfirmationLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected void newMovementConfirmationLineMvoDocumentActionCommandAndExecute(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c, MovementConfirmationLineMvoState s, MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementConfirmationLineMvoDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getMovementConfirmationDocumentStatusId());
        pCmd.setStateSetter(p -> e.setMovementConfirmationDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCommandHandler.execute(pCmd);
    }

    protected void newMovementConfirmationLineMvoDocumentActionCommandAndExecute(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c, MovementConfirmationLineMvoState s, MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getMovementConfirmationLineMvoDocumentActionCommandHandler();
        String pCmdContent = c.getDocumentAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getMovementConfirmationDocumentStatusId());
        pCmd.setStateSetter(p -> e.setMovementConfirmationDocumentStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCommandHandler.execute(pCmd);
    }

    protected PropertyCommandHandler<String, String> getMovementConfirmationLineMvoDocumentActionCommandHandler()
    {
        return (PropertyCommandHandler<String, String>)ApplicationContext.current.get("MovementConfirmationLineMvoDocumentActionCommandHandler");
    }


    ////////////////////////

    protected MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated newMovementConfirmationLineMvoStateCreated(String commandId, String requesterId) {
        MovementConfirmationLineMvoStateEventId stateEventId = new MovementConfirmationLineMvoStateEventId(this.state.getMovementConfirmationLineId(), this.state.getMovementConfirmationVersion());
        MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated e = newMovementConfirmationLineMvoStateCreated(stateEventId);
        ((AbstractMovementConfirmationLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched newMovementConfirmationLineMvoStateMergePatched(String commandId, String requesterId) {
        MovementConfirmationLineMvoStateEventId stateEventId = new MovementConfirmationLineMvoStateEventId(this.state.getMovementConfirmationLineId(), this.state.getMovementConfirmationVersion());
        MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e = newMovementConfirmationLineMvoStateMergePatched(stateEventId);
        ((AbstractMovementConfirmationLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted newMovementConfirmationLineMvoStateDeleted(String commandId, String requesterId) {
        MovementConfirmationLineMvoStateEventId stateEventId = new MovementConfirmationLineMvoStateEventId(this.state.getMovementConfirmationLineId(), this.state.getMovementConfirmationVersion());
        MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted e = newMovementConfirmationLineMvoStateDeleted(stateEventId);
        ((AbstractMovementConfirmationLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated newMovementConfirmationLineMvoStateCreated(MovementConfirmationLineMvoStateEventId stateEventId) {
        return new AbstractMovementConfirmationLineMvoStateEvent.SimpleMovementConfirmationLineMvoStateCreated(stateEventId);
    }

    protected MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched newMovementConfirmationLineMvoStateMergePatched(MovementConfirmationLineMvoStateEventId stateEventId) {
        return new AbstractMovementConfirmationLineMvoStateEvent.SimpleMovementConfirmationLineMvoStateMergePatched(stateEventId);
    }

    protected MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted newMovementConfirmationLineMvoStateDeleted(MovementConfirmationLineMvoStateEventId stateEventId)
    {
        return new AbstractMovementConfirmationLineMvoStateEvent.SimpleMovementConfirmationLineMvoStateDeleted(stateEventId);
    }


    public static class SimpleMovementConfirmationLineMvoAggregate extends AbstractMovementConfirmationLineMvoAggregate
    {
        public SimpleMovementConfirmationLineMvoAggregate(MovementConfirmationLineMvoState state) {
            super(state);
        }

    }

}

