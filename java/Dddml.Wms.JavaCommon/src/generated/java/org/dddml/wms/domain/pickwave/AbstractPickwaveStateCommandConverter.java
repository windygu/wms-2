package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPickwaveStateCommandConverter<TCreatePickwave extends PickwaveCommand.CreatePickwave, TMergePatchPickwave extends PickwaveCommand.MergePatchPickwave, TDeletePickwave extends PickwaveCommand.DeletePickwave>
{
    public PickwaveCommand toCreateOrMergePatchPickwave(PickwaveState state)
    {
        //where TCreatePickwave : ICreatePickwave, new()
        //where TMergePatchPickwave : IMergePatchPickwave, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePickwave(state);
        }
        else 
        {
            return toMergePatchPickwave(state);
        }
    }

    public TDeletePickwave toDeletePickwave(PickwaveState state) //where TDeletePickwave : IDeletePickwave, new()
    {
        TDeletePickwave cmd = newDeletePickwave();
        cmd.setPickwaveId(state.getPickwaveId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchPickwave toMergePatchPickwave(PickwaveState state) //where TMergePatchPickwave : IMergePatchPickwave, new()
    {
        TMergePatchPickwave cmd = newMergePatchPickwave();

        cmd.setVersion(state.getVersion());

        cmd.setPickwaveId(state.getPickwaveId());
        cmd.setStatusId(state.getStatusId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getStatusId() == null) { cmd.setIsPropertyStatusIdRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreatePickwave toCreatePickwave(PickwaveState state) //where TCreatePickwave : ICreatePickwave, new()
    {
        TCreatePickwave cmd = newCreatePickwave();

        cmd.setVersion(state.getVersion());
        cmd.setPickwaveId(state.getPickwaveId());
        cmd.setStatusId(state.getStatusId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreatePickwave newCreatePickwave();

    protected abstract TMergePatchPickwave newMergePatchPickwave(); 

    protected abstract TDeletePickwave newDeletePickwave();

    public static class SimplePickwaveStateCommandConverter extends AbstractPickwaveStateCommandConverter<AbstractPickwaveCommand.SimpleCreatePickwave, AbstractPickwaveCommand.SimpleMergePatchPickwave, AbstractPickwaveCommand.SimpleDeletePickwave>
    {
        @Override
        protected AbstractPickwaveCommand.SimpleCreatePickwave newCreatePickwave() {
            return new AbstractPickwaveCommand.SimpleCreatePickwave();
        }

        @Override
        protected AbstractPickwaveCommand.SimpleMergePatchPickwave newMergePatchPickwave() {
            return new AbstractPickwaveCommand.SimpleMergePatchPickwave();
        }

        @Override
        protected AbstractPickwaveCommand.SimpleDeletePickwave newDeletePickwave() {
            return new AbstractPickwaveCommand.SimpleDeletePickwave();
        }


    }

}

