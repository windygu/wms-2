package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractDamageReasonStateCommandConverter<TCreateDamageReason extends DamageReasonCommand.CreateDamageReason, TMergePatchDamageReason extends DamageReasonCommand.MergePatchDamageReason, TDeleteDamageReason extends DamageReasonCommand.DeleteDamageReason>
{
    public DamageReasonCommand toCreateOrMergePatchDamageReason(DamageReasonState state)
    {
        //where TCreateDamageReason : ICreateDamageReason, new()
        //where TMergePatchDamageReason : IMergePatchDamageReason, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateDamageReason(state);
        }
        else 
        {
            return toMergePatchDamageReason(state);
        }
    }

    public TDeleteDamageReason toDeleteDamageReason(DamageReasonState state) //where TDeleteDamageReason : IDeleteDamageReason, new()
    {
        TDeleteDamageReason cmd = newDeleteDamageReason();
        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchDamageReason toMergePatchDamageReason(DamageReasonState state) //where TMergePatchDamageReason : IMergePatchDamageReason, new()
    {
        TMergePatchDamageReason cmd = newMergePatchDamageReason();

        cmd.setVersion(state.getVersion());

        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getSequenceId() == null) { cmd.setIsPropertySequenceIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateDamageReason toCreateDamageReason(DamageReasonState state) //where TCreateDamageReason : ICreateDamageReason, new()
    {
        TCreateDamageReason cmd = newCreateDamageReason();

        cmd.setVersion(state.getVersion());
        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateDamageReason newCreateDamageReason();

    protected abstract TMergePatchDamageReason newMergePatchDamageReason(); 

    protected abstract TDeleteDamageReason newDeleteDamageReason();

    public static class SimpleDamageReasonStateCommandConverter extends AbstractDamageReasonStateCommandConverter<AbstractDamageReasonCommand.SimpleCreateDamageReason, AbstractDamageReasonCommand.SimpleMergePatchDamageReason, AbstractDamageReasonCommand.SimpleDeleteDamageReason>
    {
        @Override
        protected AbstractDamageReasonCommand.SimpleCreateDamageReason newCreateDamageReason() {
            return new AbstractDamageReasonCommand.SimpleCreateDamageReason();
        }

        @Override
        protected AbstractDamageReasonCommand.SimpleMergePatchDamageReason newMergePatchDamageReason() {
            return new AbstractDamageReasonCommand.SimpleMergePatchDamageReason();
        }

        @Override
        protected AbstractDamageReasonCommand.SimpleDeleteDamageReason newDeleteDamageReason() {
            return new AbstractDamageReasonCommand.SimpleDeleteDamageReason();
        }


    }

}

