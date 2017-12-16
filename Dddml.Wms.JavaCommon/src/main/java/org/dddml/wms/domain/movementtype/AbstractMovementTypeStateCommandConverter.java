package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementTypeStateCommandConverter<TCreateMovementType extends MovementTypeCommand.CreateMovementType, TMergePatchMovementType extends MovementTypeCommand.MergePatchMovementType, TDeleteMovementType extends MovementTypeCommand.DeleteMovementType>
{
    public MovementTypeCommand toCreateOrMergePatchMovementType(MovementTypeState state)
    {
        //where TCreateMovementType : ICreateMovementType, new()
        //where TMergePatchMovementType : IMergePatchMovementType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementType(state);
        }
        else 
        {
            return toMergePatchMovementType(state);
        }
    }

    public TDeleteMovementType toDeleteMovementType(MovementTypeState state) //where TDeleteMovementType : IDeleteMovementType, new()
    {
        TDeleteMovementType cmd = newDeleteMovementType();
        cmd.setMovementTypeId(state.getMovementTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchMovementType toMergePatchMovementType(MovementTypeState state) //where TMergePatchMovementType : IMergePatchMovementType, new()
    {
        TMergePatchMovementType cmd = newMergePatchMovementType();

        cmd.setVersion(state.getVersion());

        cmd.setMovementTypeId(state.getMovementTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateMovementType toCreateMovementType(MovementTypeState state) //where TCreateMovementType : ICreateMovementType, new()
    {
        TCreateMovementType cmd = newCreateMovementType();

        cmd.setVersion(state.getVersion());
        cmd.setMovementTypeId(state.getMovementTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateMovementType newCreateMovementType();

    protected abstract TMergePatchMovementType newMergePatchMovementType(); 

    protected abstract TDeleteMovementType newDeleteMovementType();

    public static class SimpleMovementTypeStateCommandConverter extends AbstractMovementTypeStateCommandConverter<AbstractMovementTypeCommand.SimpleCreateMovementType, AbstractMovementTypeCommand.SimpleMergePatchMovementType, AbstractMovementTypeCommand.SimpleDeleteMovementType>
    {
        @Override
        protected AbstractMovementTypeCommand.SimpleCreateMovementType newCreateMovementType() {
            return new AbstractMovementTypeCommand.SimpleCreateMovementType();
        }

        @Override
        protected AbstractMovementTypeCommand.SimpleMergePatchMovementType newMergePatchMovementType() {
            return new AbstractMovementTypeCommand.SimpleMergePatchMovementType();
        }

        @Override
        protected AbstractMovementTypeCommand.SimpleDeleteMovementType newDeleteMovementType() {
            return new AbstractMovementTypeCommand.SimpleDeleteMovementType();
        }


    }

}

