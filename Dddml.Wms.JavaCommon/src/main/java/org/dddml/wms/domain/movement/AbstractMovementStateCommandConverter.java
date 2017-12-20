package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementStateCommandConverter<TCreateMovement extends MovementCommand.CreateMovement, TMergePatchMovement extends MovementCommand.MergePatchMovement, TDeleteMovement extends MovementCommand.DeleteMovement, TCreateMovementLine extends MovementLineCommand.CreateMovementLine, TMergePatchMovementLine extends MovementLineCommand.MergePatchMovementLine, TRemoveMovementLine extends MovementLineCommand.RemoveMovementLine, TCreateMovementConfirmationLine extends MovementConfirmationLineCommand.CreateMovementConfirmationLine, TMergePatchMovementConfirmationLine extends MovementConfirmationLineCommand.MergePatchMovementConfirmationLine, TRemoveMovementConfirmationLine extends MovementConfirmationLineCommand.RemoveMovementConfirmationLine>
{
    public MovementCommand toCreateOrMergePatchMovement(MovementState state)
    {
        //where TCreateMovement : ICreateMovement, new()
        //where TMergePatchMovement : IMergePatchMovement, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovement(state);
        }
        else 
        {
            return toMergePatchMovement(state);
        }
    }

    public TDeleteMovement toDeleteMovement(MovementState state) //where TDeleteMovement : IDeleteMovement, new()
    {
        TDeleteMovement cmd = newDeleteMovement();
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchMovement toMergePatchMovement(MovementState state) //where TMergePatchMovement : IMergePatchMovement, new()
    {
        TMergePatchMovement cmd = newMergePatchMovement();

        cmd.setVersion(state.getVersion());

        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setMovementTypeId(state.getMovementTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getDocumentTypeId() == null) { cmd.setIsPropertyDocumentTypeIdRemoved(true); }
        if (state.getMovementTypeId() == null) { cmd.setIsPropertyMovementTypeIdRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (MovementLineState d : state.getMovementLines())
        {
            MovementLineCommand c = getMovementLineStateCommandConverter().toCreateOrMergePatchMovementLine(d);
            cmd.getMovementLineCommands().add(c);
        }
        for (MovementConfirmationLineState d : state.getMovementConfirmationLines())
        {
            MovementConfirmationLineCommand c = getMovementConfirmationLineStateCommandConverter().toCreateOrMergePatchMovementConfirmationLine(d);
            cmd.getMovementConfirmationLineCommands().add(c);
        }
        return cmd;
    }

    public TCreateMovement toCreateMovement(MovementState state) //where TCreateMovement : ICreateMovement, new()
    {
        TCreateMovement cmd = newCreateMovement();

        cmd.setVersion(state.getVersion());
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setMovementTypeId(state.getMovementTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        for (MovementLineState d : state.getMovementLines())
        {
            MovementLineCommand.CreateMovementLine c = getMovementLineStateCommandConverter().toCreateMovementLine(d);
            cmd.getMovementLines().add(c);
        }
        for (MovementConfirmationLineState d : state.getMovementConfirmationLines())
        {
            MovementConfirmationLineCommand.CreateMovementConfirmationLine c = getMovementConfirmationLineStateCommandConverter().toCreateMovementConfirmationLine(d);
            cmd.getMovementConfirmationLines().add(c);
        }
        return cmd;
    }

    protected abstract AbstractMovementLineStateCommandConverter<TCreateMovementLine, TMergePatchMovementLine, TRemoveMovementLine>
        getMovementLineStateCommandConverter();

    protected abstract AbstractMovementConfirmationLineStateCommandConverter<TCreateMovementConfirmationLine, TMergePatchMovementConfirmationLine, TRemoveMovementConfirmationLine>
        getMovementConfirmationLineStateCommandConverter();

    protected abstract TCreateMovement newCreateMovement();

    protected abstract TMergePatchMovement newMergePatchMovement(); 

    protected abstract TDeleteMovement newDeleteMovement();

    public static class SimpleMovementStateCommandConverter extends AbstractMovementStateCommandConverter<AbstractMovementCommand.SimpleCreateMovement, AbstractMovementCommand.SimpleMergePatchMovement, AbstractMovementCommand.SimpleDeleteMovement, AbstractMovementLineCommand.SimpleCreateMovementLine, AbstractMovementLineCommand.SimpleMergePatchMovementLine, AbstractMovementLineCommand.SimpleRemoveMovementLine, AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine>
    {
        @Override
        protected AbstractMovementCommand.SimpleCreateMovement newCreateMovement() {
            return new AbstractMovementCommand.SimpleCreateMovement();
        }

        @Override
        protected AbstractMovementCommand.SimpleMergePatchMovement newMergePatchMovement() {
            return new AbstractMovementCommand.SimpleMergePatchMovement();
        }

        @Override
        protected AbstractMovementCommand.SimpleDeleteMovement newDeleteMovement() {
            return new AbstractMovementCommand.SimpleDeleteMovement();
        }

        @Override
        protected AbstractMovementLineStateCommandConverter<AbstractMovementLineCommand.SimpleCreateMovementLine, AbstractMovementLineCommand.SimpleMergePatchMovementLine, AbstractMovementLineCommand.SimpleRemoveMovementLine> getMovementLineStateCommandConverter()
        {
            return new AbstractMovementLineStateCommandConverter.SimpleMovementLineStateCommandConverter();
        }

        @Override
        protected AbstractMovementConfirmationLineStateCommandConverter<AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine, AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine> getMovementConfirmationLineStateCommandConverter()
        {
            return new AbstractMovementConfirmationLineStateCommandConverter.SimpleMovementConfirmationLineStateCommandConverter();
        }


    }

}

