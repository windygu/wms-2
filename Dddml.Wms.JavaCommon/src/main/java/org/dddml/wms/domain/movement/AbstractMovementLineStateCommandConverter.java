package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementLineStateCommandConverter<TCreateMovementLine extends MovementLineCommand.CreateMovementLine, TMergePatchMovementLine extends MovementLineCommand.MergePatchMovementLine, TRemoveMovementLine extends MovementLineCommand.RemoveMovementLine>
{
    public MovementLineCommand toCreateOrMergePatchMovementLine(MovementLineState state)
    {
        //where TCreateMovementLine : ICreateMovementLine, new()
        //where TMergePatchMovementLine : IMergePatchMovementLine, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementLine(state);
        }
        else 
        {
            return toMergePatchMovementLine(state);
        }
    }

    public TRemoveMovementLine toRemoveMovementLine(MovementLineState state) //where TRemoveMovementLine : IRemoveMovementLine, new()
    {
        TRemoveMovementLine cmd = newRemoveMovementLine();
        cmd.setLineNumber(state.getLineNumber());
        return cmd;
    }

    public TMergePatchMovementLine toMergePatchMovementLine(MovementLineState state) //where TMergePatchMovementLine : IMergePatchMovementLine, new()
    {
        TMergePatchMovementLine cmd = newMergePatchMovementLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setActive(state.getActive());
        cmd.setMovementDocumentNumber(state.getMovementDocumentNumber());
            
        if (state.getMovementQuantity() == null) { cmd.setIsPropertyMovementQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateMovementLine toCreateMovementLine(MovementLineState state) //where TCreateMovementLine : ICreateMovementLine, new()
    {
        TCreateMovementLine cmd = newCreateMovementLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setActive(state.getActive());
        cmd.setMovementDocumentNumber(state.getMovementDocumentNumber());
        return cmd;
    }

    protected abstract TCreateMovementLine newCreateMovementLine();

    protected abstract TMergePatchMovementLine newMergePatchMovementLine(); 

    protected abstract TRemoveMovementLine newRemoveMovementLine();

    public static class SimpleMovementLineStateCommandConverter extends AbstractMovementLineStateCommandConverter<AbstractMovementLineCommand.SimpleCreateMovementLine, AbstractMovementLineCommand.SimpleMergePatchMovementLine, AbstractMovementLineCommand.SimpleRemoveMovementLine>
    {
        @Override
        protected AbstractMovementLineCommand.SimpleCreateMovementLine newCreateMovementLine() {
            return new AbstractMovementLineCommand.SimpleCreateMovementLine();
        }

        @Override
        protected AbstractMovementLineCommand.SimpleMergePatchMovementLine newMergePatchMovementLine() {
            return new AbstractMovementLineCommand.SimpleMergePatchMovementLine();
        }

        @Override
        protected AbstractMovementLineCommand.SimpleRemoveMovementLine newRemoveMovementLine() {
            return new AbstractMovementLineCommand.SimpleRemoveMovementLine();
        }


    }

}

