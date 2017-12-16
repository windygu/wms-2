package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractStatusItemStateCommandConverter<TCreateStatusItem extends StatusItemCommand.CreateStatusItem, TMergePatchStatusItem extends StatusItemCommand.MergePatchStatusItem, TDeleteStatusItem extends StatusItemCommand.DeleteStatusItem>
{
    public StatusItemCommand toCreateOrMergePatchStatusItem(StatusItemState state)
    {
        //where TCreateStatusItem : ICreateStatusItem, new()
        //where TMergePatchStatusItem : IMergePatchStatusItem, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateStatusItem(state);
        }
        else 
        {
            return toMergePatchStatusItem(state);
        }
    }

    public TDeleteStatusItem toDeleteStatusItem(StatusItemState state) //where TDeleteStatusItem : IDeleteStatusItem, new()
    {
        TDeleteStatusItem cmd = newDeleteStatusItem();
        cmd.setStatusId(state.getStatusId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchStatusItem toMergePatchStatusItem(StatusItemState state) //where TMergePatchStatusItem : IMergePatchStatusItem, new()
    {
        TMergePatchStatusItem cmd = newMergePatchStatusItem();

        cmd.setVersion(state.getVersion());

        cmd.setStatusId(state.getStatusId());
        cmd.setStatusTypeId(state.getStatusTypeId());
        cmd.setStatusCode(state.getStatusCode());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getStatusTypeId() == null) { cmd.setIsPropertyStatusTypeIdRemoved(true); }
        if (state.getStatusCode() == null) { cmd.setIsPropertyStatusCodeRemoved(true); }
        if (state.getSequenceId() == null) { cmd.setIsPropertySequenceIdRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateStatusItem toCreateStatusItem(StatusItemState state) //where TCreateStatusItem : ICreateStatusItem, new()
    {
        TCreateStatusItem cmd = newCreateStatusItem();

        cmd.setVersion(state.getVersion());
        cmd.setStatusId(state.getStatusId());
        cmd.setStatusTypeId(state.getStatusTypeId());
        cmd.setStatusCode(state.getStatusCode());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateStatusItem newCreateStatusItem();

    protected abstract TMergePatchStatusItem newMergePatchStatusItem(); 

    protected abstract TDeleteStatusItem newDeleteStatusItem();

    public static class SimpleStatusItemStateCommandConverter extends AbstractStatusItemStateCommandConverter<AbstractStatusItemCommand.SimpleCreateStatusItem, AbstractStatusItemCommand.SimpleMergePatchStatusItem, AbstractStatusItemCommand.SimpleDeleteStatusItem>
    {
        @Override
        protected AbstractStatusItemCommand.SimpleCreateStatusItem newCreateStatusItem() {
            return new AbstractStatusItemCommand.SimpleCreateStatusItem();
        }

        @Override
        protected AbstractStatusItemCommand.SimpleMergePatchStatusItem newMergePatchStatusItem() {
            return new AbstractStatusItemCommand.SimpleMergePatchStatusItem();
        }

        @Override
        protected AbstractStatusItemCommand.SimpleDeleteStatusItem newDeleteStatusItem() {
            return new AbstractStatusItemCommand.SimpleDeleteStatusItem();
        }


    }

}

