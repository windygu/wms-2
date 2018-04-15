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
        MovementConfirmationLineMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c)
    {
        MovementConfirmationLineMvoEvent e = map(c);
        apply(e);
    }

    public void delete(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c)
    {
        MovementConfirmationLineMvoEvent e = map(c);
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

    protected MovementConfirmationLineMvoEvent map(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c) {
        MovementConfirmationLineMvoEventId stateEventId = new MovementConfirmationLineMvoEventId(c.getMovementConfirmationLineId(), c.getMovementConfirmationVersion());
        MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateCreated e = newMovementConfirmationLineMvoStateCreated(stateEventId);
        e.setMovementLineNumber(c.getMovementLineNumber());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setDifferenceQuantity(c.getDifferenceQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setDescription(c.getDescription());
        e.setProcessed(c.getProcessed());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setMovementConfirmationDocumentStatusId(c.getMovementConfirmationDocumentStatusId());
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
        ((AbstractMovementConfirmationLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoEvent map(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c) {
        MovementConfirmationLineMvoEventId stateEventId = new MovementConfirmationLineMvoEventId(c.getMovementConfirmationLineId(), c.getMovementConfirmationVersion());
        MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateMergePatched e = newMovementConfirmationLineMvoStateMergePatched(stateEventId);
        e.setMovementLineNumber(c.getMovementLineNumber());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setConfirmedQuantity(c.getConfirmedQuantity());
        e.setDifferenceQuantity(c.getDifferenceQuantity());
        e.setScrappedQuantity(c.getScrappedQuantity());
        e.setDescription(c.getDescription());
        e.setProcessed(c.getProcessed());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setMovementConfirmationDocumentStatusId(c.getMovementConfirmationDocumentStatusId());
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
        e.setIsPropertyMovementConfirmationDocumentStatusIdRemoved(c.getIsPropertyMovementConfirmationDocumentStatusIdRemoved());
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
        ((AbstractMovementConfirmationLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoEvent map(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c) {
        MovementConfirmationLineMvoEventId stateEventId = new MovementConfirmationLineMvoEventId(c.getMovementConfirmationLineId(), c.getMovementConfirmationVersion());
        MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateDeleted e = newMovementConfirmationLineMvoStateDeleted(stateEventId);
        ((AbstractMovementConfirmationLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateCreated newMovementConfirmationLineMvoStateCreated(Long version, String commandId, String requesterId) {
        MovementConfirmationLineMvoEventId stateEventId = new MovementConfirmationLineMvoEventId(this.state.getMovementConfirmationLineId(), version);
        MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateCreated e = newMovementConfirmationLineMvoStateCreated(stateEventId);
        ((AbstractMovementConfirmationLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateMergePatched newMovementConfirmationLineMvoStateMergePatched(Long version, String commandId, String requesterId) {
        MovementConfirmationLineMvoEventId stateEventId = new MovementConfirmationLineMvoEventId(this.state.getMovementConfirmationLineId(), version);
        MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateMergePatched e = newMovementConfirmationLineMvoStateMergePatched(stateEventId);
        ((AbstractMovementConfirmationLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateDeleted newMovementConfirmationLineMvoStateDeleted(Long version, String commandId, String requesterId) {
        MovementConfirmationLineMvoEventId stateEventId = new MovementConfirmationLineMvoEventId(this.state.getMovementConfirmationLineId(), version);
        MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateDeleted e = newMovementConfirmationLineMvoStateDeleted(stateEventId);
        ((AbstractMovementConfirmationLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateCreated newMovementConfirmationLineMvoStateCreated(MovementConfirmationLineMvoEventId stateEventId) {
        return new AbstractMovementConfirmationLineMvoEvent.SimpleMovementConfirmationLineMvoStateCreated(stateEventId);
    }

    protected MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateMergePatched newMovementConfirmationLineMvoStateMergePatched(MovementConfirmationLineMvoEventId stateEventId) {
        return new AbstractMovementConfirmationLineMvoEvent.SimpleMovementConfirmationLineMvoStateMergePatched(stateEventId);
    }

    protected MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateDeleted newMovementConfirmationLineMvoStateDeleted(MovementConfirmationLineMvoEventId stateEventId)
    {
        return new AbstractMovementConfirmationLineMvoEvent.SimpleMovementConfirmationLineMvoStateDeleted(stateEventId);
    }

    public static class SimpleMovementConfirmationLineMvoAggregate extends AbstractMovementConfirmationLineMvoAggregate
    {
        public SimpleMovementConfirmationLineMvoAggregate(MovementConfirmationLineMvoState state) {
            super(state);
        }

    }

}

