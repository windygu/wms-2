package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractDamageTypeStateCommandConverter<TCreateDamageType extends DamageTypeCommand.CreateDamageType, TMergePatchDamageType extends DamageTypeCommand.MergePatchDamageType, TDeleteDamageType extends DamageTypeCommand.DeleteDamageType>
{
    public DamageTypeCommand toCreateOrMergePatchDamageType(DamageTypeState state)
    {
        //where TCreateDamageType : ICreateDamageType, new()
        //where TMergePatchDamageType : IMergePatchDamageType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateDamageType(state);
        }
        else 
        {
            return toMergePatchDamageType(state);
        }
    }

    public TDeleteDamageType toDeleteDamageType(DamageTypeState state) //where TDeleteDamageType : IDeleteDamageType, new()
    {
        TDeleteDamageType cmd = newDeleteDamageType();
        cmd.setDamageTypeId(state.getDamageTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchDamageType toMergePatchDamageType(DamageTypeState state) //where TMergePatchDamageType : IMergePatchDamageType, new()
    {
        TMergePatchDamageType cmd = newMergePatchDamageType();

        cmd.setVersion(state.getVersion());

        cmd.setDamageTypeId(state.getDamageTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setDefaultHandlingMethodId(state.getDefaultHandlingMethodId());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getSequenceId() == null) { cmd.setIsPropertySequenceIdRemoved(true); }
        if (state.getDefaultHandlingMethodId() == null) { cmd.setIsPropertyDefaultHandlingMethodIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateDamageType toCreateDamageType(DamageTypeState state) //where TCreateDamageType : ICreateDamageType, new()
    {
        TCreateDamageType cmd = newCreateDamageType();

        cmd.setVersion(state.getVersion());
        cmd.setDamageTypeId(state.getDamageTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setDefaultHandlingMethodId(state.getDefaultHandlingMethodId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateDamageType newCreateDamageType();

    protected abstract TMergePatchDamageType newMergePatchDamageType(); 

    protected abstract TDeleteDamageType newDeleteDamageType();

    public static class SimpleDamageTypeStateCommandConverter extends AbstractDamageTypeStateCommandConverter<AbstractDamageTypeCommand.SimpleCreateDamageType, AbstractDamageTypeCommand.SimpleMergePatchDamageType, AbstractDamageTypeCommand.SimpleDeleteDamageType>
    {
        @Override
        protected AbstractDamageTypeCommand.SimpleCreateDamageType newCreateDamageType() {
            return new AbstractDamageTypeCommand.SimpleCreateDamageType();
        }

        @Override
        protected AbstractDamageTypeCommand.SimpleMergePatchDamageType newMergePatchDamageType() {
            return new AbstractDamageTypeCommand.SimpleMergePatchDamageType();
        }

        @Override
        protected AbstractDamageTypeCommand.SimpleDeleteDamageType newDeleteDamageType() {
            return new AbstractDamageTypeCommand.SimpleDeleteDamageType();
        }


    }

}

