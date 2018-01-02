package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractRejectionReasonStateCommandConverter<TCreateRejectionReason extends RejectionReasonCommand.CreateRejectionReason, TMergePatchRejectionReason extends RejectionReasonCommand.MergePatchRejectionReason, TDeleteRejectionReason extends RejectionReasonCommand.DeleteRejectionReason>
{
    public RejectionReasonCommand toCreateOrMergePatchRejectionReason(RejectionReasonState state)
    {
        //where TCreateRejectionReason : ICreateRejectionReason, new()
        //where TMergePatchRejectionReason : IMergePatchRejectionReason, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateRejectionReason(state);
        }
        else 
        {
            return toMergePatchRejectionReason(state);
        }
    }

    public TDeleteRejectionReason toDeleteRejectionReason(RejectionReasonState state) //where TDeleteRejectionReason : IDeleteRejectionReason, new()
    {
        TDeleteRejectionReason cmd = newDeleteRejectionReason();
        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchRejectionReason toMergePatchRejectionReason(RejectionReasonState state) //where TMergePatchRejectionReason : IMergePatchRejectionReason, new()
    {
        TMergePatchRejectionReason cmd = newMergePatchRejectionReason();

        cmd.setVersion(state.getVersion());

        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateRejectionReason toCreateRejectionReason(RejectionReasonState state) //where TCreateRejectionReason : ICreateRejectionReason, new()
    {
        TCreateRejectionReason cmd = newCreateRejectionReason();

        cmd.setVersion(state.getVersion());
        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateRejectionReason newCreateRejectionReason();

    protected abstract TMergePatchRejectionReason newMergePatchRejectionReason(); 

    protected abstract TDeleteRejectionReason newDeleteRejectionReason();

    public static class SimpleRejectionReasonStateCommandConverter extends AbstractRejectionReasonStateCommandConverter<AbstractRejectionReasonCommand.SimpleCreateRejectionReason, AbstractRejectionReasonCommand.SimpleMergePatchRejectionReason, AbstractRejectionReasonCommand.SimpleDeleteRejectionReason>
    {
        @Override
        protected AbstractRejectionReasonCommand.SimpleCreateRejectionReason newCreateRejectionReason() {
            return new AbstractRejectionReasonCommand.SimpleCreateRejectionReason();
        }

        @Override
        protected AbstractRejectionReasonCommand.SimpleMergePatchRejectionReason newMergePatchRejectionReason() {
            return new AbstractRejectionReasonCommand.SimpleMergePatchRejectionReason();
        }

        @Override
        protected AbstractRejectionReasonCommand.SimpleDeleteRejectionReason newDeleteRejectionReason() {
            return new AbstractRejectionReasonCommand.SimpleDeleteRejectionReason();
        }


    }

}

