package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementConfirmationLineMvoStateCommandConverter<TCreateMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo, TMergePatchMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo, TDeleteMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo>
{
    public MovementConfirmationLineMvoCommand toCreateOrMergePatchMovementConfirmationLineMvo(MovementConfirmationLineMvoState state)
    {
        //where TCreateMovementConfirmationLineMvo : ICreateMovementConfirmationLineMvo, new()
        //where TMergePatchMovementConfirmationLineMvo : IMergePatchMovementConfirmationLineMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementConfirmationLineMvo(state);
        }
        else 
        {
            return toMergePatchMovementConfirmationLineMvo(state);
        }
    }

    public TDeleteMovementConfirmationLineMvo toDeleteMovementConfirmationLineMvo(MovementConfirmationLineMvoState state) //where TDeleteMovementConfirmationLineMvo : IDeleteMovementConfirmationLineMvo, new()
    {
        TDeleteMovementConfirmationLineMvo cmd = newDeleteMovementConfirmationLineMvo();
        cmd.setMovementConfirmationLineId(state.getMovementConfirmationLineId());
        cmd.setMovementConfirmationVersion(state.getMovementConfirmationVersion());

        return cmd;
    }

    public TMergePatchMovementConfirmationLineMvo toMergePatchMovementConfirmationLineMvo(MovementConfirmationLineMvoState state) //where TMergePatchMovementConfirmationLineMvo : IMergePatchMovementConfirmationLineMvo, new()
    {
        TMergePatchMovementConfirmationLineMvo cmd = newMergePatchMovementConfirmationLineMvo();

        cmd.setMovementConfirmationVersion(state.getMovementConfirmationVersion());

        cmd.setMovementConfirmationLineId(state.getMovementConfirmationLineId());
        cmd.setMovementLineNumber(state.getMovementLineNumber());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setConfirmedQuantity(state.getConfirmedQuantity());
        cmd.setDifferenceQuantity(state.getDifferenceQuantity());
        cmd.setScrappedQuantity(state.getScrappedQuantity());
        cmd.setDescription(state.getDescription());
        cmd.setProcessed(state.getProcessed());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setMovementConfirmationDocumentStatusId(state.getMovementConfirmationDocumentStatusId());
        cmd.setMovementConfirmationMovementDocumentNumber(state.getMovementConfirmationMovementDocumentNumber());
        cmd.setMovementConfirmationIsApproved(state.getMovementConfirmationIsApproved());
        cmd.setMovementConfirmationApprovalAmount(state.getMovementConfirmationApprovalAmount());
        cmd.setMovementConfirmationProcessed(state.getMovementConfirmationProcessed());
        cmd.setMovementConfirmationProcessing(state.getMovementConfirmationProcessing());
        cmd.setMovementConfirmationDocumentTypeId(state.getMovementConfirmationDocumentTypeId());
        cmd.setMovementConfirmationDescription(state.getMovementConfirmationDescription());
        cmd.setMovementConfirmationCreatedBy(state.getMovementConfirmationCreatedBy());
        cmd.setMovementConfirmationCreatedAt(state.getMovementConfirmationCreatedAt());
        cmd.setMovementConfirmationUpdatedBy(state.getMovementConfirmationUpdatedBy());
        cmd.setMovementConfirmationUpdatedAt(state.getMovementConfirmationUpdatedAt());
        cmd.setMovementConfirmationActive(state.getMovementConfirmationActive());
        cmd.setMovementConfirmationDeleted(state.getMovementConfirmationDeleted());
            
        if (state.getMovementLineNumber() == null) { cmd.setIsPropertyMovementLineNumberRemoved(true); }
        if (state.getTargetQuantity() == null) { cmd.setIsPropertyTargetQuantityRemoved(true); }
        if (state.getConfirmedQuantity() == null) { cmd.setIsPropertyConfirmedQuantityRemoved(true); }
        if (state.getDifferenceQuantity() == null) { cmd.setIsPropertyDifferenceQuantityRemoved(true); }
        if (state.getScrappedQuantity() == null) { cmd.setIsPropertyScrappedQuantityRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getMovementConfirmationDocumentStatusId() == null) { cmd.setIsPropertyMovementConfirmationDocumentStatusIdRemoved(true); }
        if (state.getMovementConfirmationMovementDocumentNumber() == null) { cmd.setIsPropertyMovementConfirmationMovementDocumentNumberRemoved(true); }
        if (state.getMovementConfirmationIsApproved() == null) { cmd.setIsPropertyMovementConfirmationIsApprovedRemoved(true); }
        if (state.getMovementConfirmationApprovalAmount() == null) { cmd.setIsPropertyMovementConfirmationApprovalAmountRemoved(true); }
        if (state.getMovementConfirmationProcessed() == null) { cmd.setIsPropertyMovementConfirmationProcessedRemoved(true); }
        if (state.getMovementConfirmationProcessing() == null) { cmd.setIsPropertyMovementConfirmationProcessingRemoved(true); }
        if (state.getMovementConfirmationDocumentTypeId() == null) { cmd.setIsPropertyMovementConfirmationDocumentTypeIdRemoved(true); }
        if (state.getMovementConfirmationDescription() == null) { cmd.setIsPropertyMovementConfirmationDescriptionRemoved(true); }
        if (state.getMovementConfirmationCreatedBy() == null) { cmd.setIsPropertyMovementConfirmationCreatedByRemoved(true); }
        if (state.getMovementConfirmationCreatedAt() == null) { cmd.setIsPropertyMovementConfirmationCreatedAtRemoved(true); }
        if (state.getMovementConfirmationUpdatedBy() == null) { cmd.setIsPropertyMovementConfirmationUpdatedByRemoved(true); }
        if (state.getMovementConfirmationUpdatedAt() == null) { cmd.setIsPropertyMovementConfirmationUpdatedAtRemoved(true); }
        if (state.getMovementConfirmationActive() == null) { cmd.setIsPropertyMovementConfirmationActiveRemoved(true); }
        if (state.getMovementConfirmationDeleted() == null) { cmd.setIsPropertyMovementConfirmationDeletedRemoved(true); }
        return cmd;
    }

    public TCreateMovementConfirmationLineMvo toCreateMovementConfirmationLineMvo(MovementConfirmationLineMvoState state) //where TCreateMovementConfirmationLineMvo : ICreateMovementConfirmationLineMvo, new()
    {
        TCreateMovementConfirmationLineMvo cmd = newCreateMovementConfirmationLineMvo();

        cmd.setMovementConfirmationVersion(state.getMovementConfirmationVersion());
        cmd.setMovementConfirmationLineId(state.getMovementConfirmationLineId());
        cmd.setMovementLineNumber(state.getMovementLineNumber());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setConfirmedQuantity(state.getConfirmedQuantity());
        cmd.setDifferenceQuantity(state.getDifferenceQuantity());
        cmd.setScrappedQuantity(state.getScrappedQuantity());
        cmd.setDescription(state.getDescription());
        cmd.setProcessed(state.getProcessed());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setMovementConfirmationDocumentStatusId(state.getMovementConfirmationDocumentStatusId());
        cmd.setMovementConfirmationMovementDocumentNumber(state.getMovementConfirmationMovementDocumentNumber());
        cmd.setMovementConfirmationIsApproved(state.getMovementConfirmationIsApproved());
        cmd.setMovementConfirmationApprovalAmount(state.getMovementConfirmationApprovalAmount());
        cmd.setMovementConfirmationProcessed(state.getMovementConfirmationProcessed());
        cmd.setMovementConfirmationProcessing(state.getMovementConfirmationProcessing());
        cmd.setMovementConfirmationDocumentTypeId(state.getMovementConfirmationDocumentTypeId());
        cmd.setMovementConfirmationDescription(state.getMovementConfirmationDescription());
        cmd.setMovementConfirmationCreatedBy(state.getMovementConfirmationCreatedBy());
        cmd.setMovementConfirmationCreatedAt(state.getMovementConfirmationCreatedAt());
        cmd.setMovementConfirmationUpdatedBy(state.getMovementConfirmationUpdatedBy());
        cmd.setMovementConfirmationUpdatedAt(state.getMovementConfirmationUpdatedAt());
        cmd.setMovementConfirmationActive(state.getMovementConfirmationActive());
        cmd.setMovementConfirmationDeleted(state.getMovementConfirmationDeleted());
        return cmd;
    }

    protected abstract TCreateMovementConfirmationLineMvo newCreateMovementConfirmationLineMvo();

    protected abstract TMergePatchMovementConfirmationLineMvo newMergePatchMovementConfirmationLineMvo(); 

    protected abstract TDeleteMovementConfirmationLineMvo newDeleteMovementConfirmationLineMvo();

    public static class SimpleMovementConfirmationLineMvoStateCommandConverter extends AbstractMovementConfirmationLineMvoStateCommandConverter<AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo, AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo, AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo>
    {
        @Override
        protected AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo newCreateMovementConfirmationLineMvo() {
            return new AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo();
        }

        @Override
        protected AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo newMergePatchMovementConfirmationLineMvo() {
            return new AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo();
        }

        @Override
        protected AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo newDeleteMovementConfirmationLineMvo() {
            return new AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo();
        }


    }

}

