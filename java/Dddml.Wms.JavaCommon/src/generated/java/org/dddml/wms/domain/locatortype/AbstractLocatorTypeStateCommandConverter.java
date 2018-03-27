package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractLocatorTypeStateCommandConverter<TCreateLocatorType extends LocatorTypeCommand.CreateLocatorType, TMergePatchLocatorType extends LocatorTypeCommand.MergePatchLocatorType, TDeleteLocatorType extends LocatorTypeCommand.DeleteLocatorType>
{
    public LocatorTypeCommand toCreateOrMergePatchLocatorType(LocatorTypeState state)
    {
        //where TCreateLocatorType : ICreateLocatorType, new()
        //where TMergePatchLocatorType : IMergePatchLocatorType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateLocatorType(state);
        }
        else 
        {
            return toMergePatchLocatorType(state);
        }
    }

    public TDeleteLocatorType toDeleteLocatorType(LocatorTypeState state) //where TDeleteLocatorType : IDeleteLocatorType, new()
    {
        TDeleteLocatorType cmd = newDeleteLocatorType();
        cmd.setLocatorTypeId(state.getLocatorTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchLocatorType toMergePatchLocatorType(LocatorTypeState state) //where TMergePatchLocatorType : IMergePatchLocatorType, new()
    {
        TMergePatchLocatorType cmd = newMergePatchLocatorType();

        cmd.setVersion(state.getVersion());

        cmd.setLocatorTypeId(state.getLocatorTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateLocatorType toCreateLocatorType(LocatorTypeState state) //where TCreateLocatorType : ICreateLocatorType, new()
    {
        TCreateLocatorType cmd = newCreateLocatorType();

        cmd.setVersion(state.getVersion());
        cmd.setLocatorTypeId(state.getLocatorTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateLocatorType newCreateLocatorType();

    protected abstract TMergePatchLocatorType newMergePatchLocatorType(); 

    protected abstract TDeleteLocatorType newDeleteLocatorType();

    public static class SimpleLocatorTypeStateCommandConverter extends AbstractLocatorTypeStateCommandConverter<AbstractLocatorTypeCommand.SimpleCreateLocatorType, AbstractLocatorTypeCommand.SimpleMergePatchLocatorType, AbstractLocatorTypeCommand.SimpleDeleteLocatorType>
    {
        @Override
        protected AbstractLocatorTypeCommand.SimpleCreateLocatorType newCreateLocatorType() {
            return new AbstractLocatorTypeCommand.SimpleCreateLocatorType();
        }

        @Override
        protected AbstractLocatorTypeCommand.SimpleMergePatchLocatorType newMergePatchLocatorType() {
            return new AbstractLocatorTypeCommand.SimpleMergePatchLocatorType();
        }

        @Override
        protected AbstractLocatorTypeCommand.SimpleDeleteLocatorType newDeleteLocatorType() {
            return new AbstractLocatorTypeCommand.SimpleDeleteLocatorType();
        }


    }

}

