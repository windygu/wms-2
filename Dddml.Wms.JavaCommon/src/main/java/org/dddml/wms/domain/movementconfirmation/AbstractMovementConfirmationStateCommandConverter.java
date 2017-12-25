package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementConfirmationStateCommandConverter<TCreateMovementConfirmation extends MovementConfirmationCommand.CreateMovementConfirmation, TMergePatchMovementConfirmation extends MovementConfirmationCommand.MergePatchMovementConfirmation, TDeleteMovementConfirmation extends MovementConfirmationCommand.DeleteMovementConfirmation, TCreateMovementConfirmationLine extends MovementConfirmationLineCommand.CreateMovementConfirmationLine, TMergePatchMovementConfirmationLine extends MovementConfirmationLineCommand.MergePatchMovementConfirmationLine, TRemoveMovementConfirmationLine extends MovementConfirmationLineCommand.RemoveMovementConfirmationLine>
{
    public MovementConfirmationCommand toCreateOrMergePatchMovementConfirmation(MovementConfirmationState state)
    {
        //where TCreateMovementConfirmation : ICreateMovementConfirmation, new()
        //where TMergePatchMovementConfirmation : IMergePatchMovementConfirmation, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementConfirmation(state);
        }
        else 
        {
            return toMergePatchMovementConfirmation(state);
        }
    }

    public TDeleteMovementConfirmation toDeleteMovementConfirmation(MovementConfirmationState state) //where TDeleteMovementConfirmation : IDeleteMovementConfirmation, new()
    {
        TDeleteMovementConfirmation cmd = newDeleteMovementConfirmation();
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchMovementConfirmation toMergePatchMovementConfirmation(MovementConfirmationState state) //where TMergePatchMovementConfirmation : IMergePatchMovementConfirmation, new()
    {
        TMergePatchMovementConfirmation cmd = newMergePatchMovementConfirmation();

        cmd.setVersion(state.getVersion());

        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setMovementDocumentNumber(state.getMovementDocumentNumber());
        cmd.setIsApproved(state.getIsApproved());
        cmd.setApprovalAmount(state.getApprovalAmount());
        cmd.setProcessed(state.getProcessed());
        cmd.setProcessing(state.getProcessing());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getMovementDocumentNumber() == null) { cmd.setIsPropertyMovementDocumentNumberRemoved(true); }
        if (state.getIsApproved() == null) { cmd.setIsPropertyIsApprovedRemoved(true); }
        if (state.getApprovalAmount() == null) { cmd.setIsPropertyApprovalAmountRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getProcessing() == null) { cmd.setIsPropertyProcessingRemoved(true); }
        if (state.getDocumentTypeId() == null) { cmd.setIsPropertyDocumentTypeIdRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (MovementConfirmationLineState d : state.getMovementConfirmationLines())
        {
            MovementConfirmationLineCommand c = getMovementConfirmationLineStateCommandConverter().toCreateOrMergePatchMovementConfirmationLine(d);
            cmd.getMovementConfirmationLineCommands().add(c);
        }
        return cmd;
    }

    public TCreateMovementConfirmation toCreateMovementConfirmation(MovementConfirmationState state) //where TCreateMovementConfirmation : ICreateMovementConfirmation, new()
    {
        TCreateMovementConfirmation cmd = newCreateMovementConfirmation();

        cmd.setVersion(state.getVersion());
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setMovementDocumentNumber(state.getMovementDocumentNumber());
        cmd.setIsApproved(state.getIsApproved());
        cmd.setApprovalAmount(state.getApprovalAmount());
        cmd.setProcessed(state.getProcessed());
        cmd.setProcessing(state.getProcessing());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        for (MovementConfirmationLineState d : state.getMovementConfirmationLines())
        {
            MovementConfirmationLineCommand.CreateMovementConfirmationLine c = getMovementConfirmationLineStateCommandConverter().toCreateMovementConfirmationLine(d);
            cmd.getMovementConfirmationLines().add(c);
        }
        return cmd;
    }

    protected abstract AbstractMovementConfirmationLineStateCommandConverter<TCreateMovementConfirmationLine, TMergePatchMovementConfirmationLine, TRemoveMovementConfirmationLine>
        getMovementConfirmationLineStateCommandConverter();

    protected abstract TCreateMovementConfirmation newCreateMovementConfirmation();

    protected abstract TMergePatchMovementConfirmation newMergePatchMovementConfirmation(); 

    protected abstract TDeleteMovementConfirmation newDeleteMovementConfirmation();

    public static class SimpleMovementConfirmationStateCommandConverter extends AbstractMovementConfirmationStateCommandConverter<AbstractMovementConfirmationCommand.SimpleCreateMovementConfirmation, AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation, AbstractMovementConfirmationCommand.SimpleDeleteMovementConfirmation, AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine>
    {
        @Override
        protected AbstractMovementConfirmationCommand.SimpleCreateMovementConfirmation newCreateMovementConfirmation() {
            return new AbstractMovementConfirmationCommand.SimpleCreateMovementConfirmation();
        }

        @Override
        protected AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation newMergePatchMovementConfirmation() {
            return new AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation();
        }

        @Override
        protected AbstractMovementConfirmationCommand.SimpleDeleteMovementConfirmation newDeleteMovementConfirmation() {
            return new AbstractMovementConfirmationCommand.SimpleDeleteMovementConfirmation();
        }

        @Override
        protected AbstractMovementConfirmationLineStateCommandConverter<AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine> getMovementConfirmationLineStateCommandConverter()
        {
            return new AbstractMovementConfirmationLineStateCommandConverter.SimpleMovementConfirmationLineStateCommandConverter();
        }


    }

}

