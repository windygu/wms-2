package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractDamageHandlingMethodStateCommandConverter<TCreateDamageHandlingMethod extends DamageHandlingMethodCommand.CreateDamageHandlingMethod, TMergePatchDamageHandlingMethod extends DamageHandlingMethodCommand.MergePatchDamageHandlingMethod, TDeleteDamageHandlingMethod extends DamageHandlingMethodCommand.DeleteDamageHandlingMethod>
{
    public DamageHandlingMethodCommand toCreateOrMergePatchDamageHandlingMethod(DamageHandlingMethodState state)
    {
        //where TCreateDamageHandlingMethod : ICreateDamageHandlingMethod, new()
        //where TMergePatchDamageHandlingMethod : IMergePatchDamageHandlingMethod, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateDamageHandlingMethod(state);
        }
        else 
        {
            return toMergePatchDamageHandlingMethod(state);
        }
    }

    public TDeleteDamageHandlingMethod toDeleteDamageHandlingMethod(DamageHandlingMethodState state) //where TDeleteDamageHandlingMethod : IDeleteDamageHandlingMethod, new()
    {
        TDeleteDamageHandlingMethod cmd = newDeleteDamageHandlingMethod();
        cmd.setDamageHandlingMethodId(state.getDamageHandlingMethodId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchDamageHandlingMethod toMergePatchDamageHandlingMethod(DamageHandlingMethodState state) //where TMergePatchDamageHandlingMethod : IMergePatchDamageHandlingMethod, new()
    {
        TMergePatchDamageHandlingMethod cmd = newMergePatchDamageHandlingMethod();

        cmd.setVersion(state.getVersion());

        cmd.setDamageHandlingMethodId(state.getDamageHandlingMethodId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getSequenceId() == null) { cmd.setIsPropertySequenceIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateDamageHandlingMethod toCreateDamageHandlingMethod(DamageHandlingMethodState state) //where TCreateDamageHandlingMethod : ICreateDamageHandlingMethod, new()
    {
        TCreateDamageHandlingMethod cmd = newCreateDamageHandlingMethod();

        cmd.setVersion(state.getVersion());
        cmd.setDamageHandlingMethodId(state.getDamageHandlingMethodId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateDamageHandlingMethod newCreateDamageHandlingMethod();

    protected abstract TMergePatchDamageHandlingMethod newMergePatchDamageHandlingMethod(); 

    protected abstract TDeleteDamageHandlingMethod newDeleteDamageHandlingMethod();

    public static class SimpleDamageHandlingMethodStateCommandConverter extends AbstractDamageHandlingMethodStateCommandConverter<AbstractDamageHandlingMethodCommand.SimpleCreateDamageHandlingMethod, AbstractDamageHandlingMethodCommand.SimpleMergePatchDamageHandlingMethod, AbstractDamageHandlingMethodCommand.SimpleDeleteDamageHandlingMethod>
    {
        @Override
        protected AbstractDamageHandlingMethodCommand.SimpleCreateDamageHandlingMethod newCreateDamageHandlingMethod() {
            return new AbstractDamageHandlingMethodCommand.SimpleCreateDamageHandlingMethod();
        }

        @Override
        protected AbstractDamageHandlingMethodCommand.SimpleMergePatchDamageHandlingMethod newMergePatchDamageHandlingMethod() {
            return new AbstractDamageHandlingMethodCommand.SimpleMergePatchDamageHandlingMethod();
        }

        @Override
        protected AbstractDamageHandlingMethodCommand.SimpleDeleteDamageHandlingMethod newDeleteDamageHandlingMethod() {
            return new AbstractDamageHandlingMethodCommand.SimpleDeleteDamageHandlingMethod();
        }


    }

}

