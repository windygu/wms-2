package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementConfirmationLineStateCommandConverter<TCreateMovementConfirmationLine extends MovementConfirmationLineCommand.CreateMovementConfirmationLine, TMergePatchMovementConfirmationLine extends MovementConfirmationLineCommand.MergePatchMovementConfirmationLine, TRemoveMovementConfirmationLine extends MovementConfirmationLineCommand.RemoveMovementConfirmationLine>
{
    public MovementConfirmationLineCommand toCreateOrMergePatchMovementConfirmationLine(MovementConfirmationLineState state)
    {
        //where TCreateMovementConfirmationLine : ICreateMovementConfirmationLine, new()
        //where TMergePatchMovementConfirmationLine : IMergePatchMovementConfirmationLine, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementConfirmationLine(state);
        }
        else 
        {
            return toMergePatchMovementConfirmationLine(state);
        }
    }

    public TRemoveMovementConfirmationLine toRemoveMovementConfirmationLine(MovementConfirmationLineState state) //where TRemoveMovementConfirmationLine : IRemoveMovementConfirmationLine, new()
    {
        TRemoveMovementConfirmationLine cmd = newRemoveMovementConfirmationLine();
        cmd.setLineNumber(state.getLineNumber());
        return cmd;
    }

    public TMergePatchMovementConfirmationLine toMergePatchMovementConfirmationLine(MovementConfirmationLineState state) //where TMergePatchMovementConfirmationLine : IMergePatchMovementConfirmationLine, new()
    {
        TMergePatchMovementConfirmationLine cmd = newMergePatchMovementConfirmationLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setMovementLineNumber(state.getMovementLineNumber());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setConfirmedQuantity(state.getConfirmedQuantity());
        cmd.setDifferenceQuantity(state.getDifferenceQuantity());
        cmd.setScrappedQuantity(state.getScrappedQuantity());
        cmd.setDescription(state.getDescription());
        cmd.setProcessed(state.getProcessed());
        cmd.setActive(state.getActive());
        cmd.setMovementConfirmationDocumentNumber(state.getMovementConfirmationDocumentNumber());
            
        if (state.getMovementLineNumber() == null) { cmd.setIsPropertyMovementLineNumberRemoved(true); }
        if (state.getTargetQuantity() == null) { cmd.setIsPropertyTargetQuantityRemoved(true); }
        if (state.getConfirmedQuantity() == null) { cmd.setIsPropertyConfirmedQuantityRemoved(true); }
        if (state.getDifferenceQuantity() == null) { cmd.setIsPropertyDifferenceQuantityRemoved(true); }
        if (state.getScrappedQuantity() == null) { cmd.setIsPropertyScrappedQuantityRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateMovementConfirmationLine toCreateMovementConfirmationLine(MovementConfirmationLineState state) //where TCreateMovementConfirmationLine : ICreateMovementConfirmationLine, new()
    {
        TCreateMovementConfirmationLine cmd = newCreateMovementConfirmationLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setMovementLineNumber(state.getMovementLineNumber());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setConfirmedQuantity(state.getConfirmedQuantity());
        cmd.setDifferenceQuantity(state.getDifferenceQuantity());
        cmd.setScrappedQuantity(state.getScrappedQuantity());
        cmd.setDescription(state.getDescription());
        cmd.setProcessed(state.getProcessed());
        cmd.setActive(state.getActive());
        cmd.setMovementConfirmationDocumentNumber(state.getMovementConfirmationDocumentNumber());
        return cmd;
    }

    protected abstract TCreateMovementConfirmationLine newCreateMovementConfirmationLine();

    protected abstract TMergePatchMovementConfirmationLine newMergePatchMovementConfirmationLine(); 

    protected abstract TRemoveMovementConfirmationLine newRemoveMovementConfirmationLine();

    public static class SimpleMovementConfirmationLineStateCommandConverter extends AbstractMovementConfirmationLineStateCommandConverter<AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine>
    {
        @Override
        protected AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine newCreateMovementConfirmationLine() {
            return new AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine();
        }

        @Override
        protected AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine newMergePatchMovementConfirmationLine() {
            return new AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine();
        }

        @Override
        protected AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine newRemoveMovementConfirmationLine() {
            return new AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine();
        }


    }

}

