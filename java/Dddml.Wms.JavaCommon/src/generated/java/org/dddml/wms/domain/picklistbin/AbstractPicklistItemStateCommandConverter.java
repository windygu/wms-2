package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPicklistItemStateCommandConverter<TCreatePicklistItem extends PicklistItemCommand.CreatePicklistItem, TMergePatchPicklistItem extends PicklistItemCommand.MergePatchPicklistItem, TRemovePicklistItem extends PicklistItemCommand.RemovePicklistItem>
{
    public PicklistItemCommand toCreateOrMergePatchPicklistItem(PicklistItemState state)
    {
        //where TCreatePicklistItem : ICreatePicklistItem, new()
        //where TMergePatchPicklistItem : IMergePatchPicklistItem, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePicklistItem(state);
        }
        else 
        {
            return toMergePatchPicklistItem(state);
        }
    }

    public TRemovePicklistItem toRemovePicklistItem(PicklistItemState state) //where TRemovePicklistItem : IRemovePicklistItem, new()
    {
        TRemovePicklistItem cmd = newRemovePicklistItem();
        cmd.setPicklistItemOrderShipGrpInvId(state.getPicklistItemOrderShipGrpInvId());
        return cmd;
    }

    public TMergePatchPicklistItem toMergePatchPicklistItem(PicklistItemState state) //where TMergePatchPicklistItem : IMergePatchPicklistItem, new()
    {
        TMergePatchPicklistItem cmd = newMergePatchPicklistItem();

        cmd.setPicklistItemOrderShipGrpInvId(state.getPicklistItemOrderShipGrpInvId());
        cmd.setItemStatusId(state.getItemStatusId());
        cmd.setQuantity(state.getQuantity());
        cmd.setActive(state.getActive());
        cmd.setPicklistBinId(state.getPicklistBinId());
            
        if (state.getItemStatusId() == null) { cmd.setIsPropertyItemStatusIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreatePicklistItem toCreatePicklistItem(PicklistItemState state) //where TCreatePicklistItem : ICreatePicklistItem, new()
    {
        TCreatePicklistItem cmd = newCreatePicklistItem();

        cmd.setPicklistItemOrderShipGrpInvId(state.getPicklistItemOrderShipGrpInvId());
        cmd.setItemStatusId(state.getItemStatusId());
        cmd.setQuantity(state.getQuantity());
        cmd.setActive(state.getActive());
        cmd.setPicklistBinId(state.getPicklistBinId());
        return cmd;
    }

    protected abstract TCreatePicklistItem newCreatePicklistItem();

    protected abstract TMergePatchPicklistItem newMergePatchPicklistItem(); 

    protected abstract TRemovePicklistItem newRemovePicklistItem();

    public static class SimplePicklistItemStateCommandConverter extends AbstractPicklistItemStateCommandConverter<AbstractPicklistItemCommand.SimpleCreatePicklistItem, AbstractPicklistItemCommand.SimpleMergePatchPicklistItem, AbstractPicklistItemCommand.SimpleRemovePicklistItem>
    {
        @Override
        protected AbstractPicklistItemCommand.SimpleCreatePicklistItem newCreatePicklistItem() {
            return new AbstractPicklistItemCommand.SimpleCreatePicklistItem();
        }

        @Override
        protected AbstractPicklistItemCommand.SimpleMergePatchPicklistItem newMergePatchPicklistItem() {
            return new AbstractPicklistItemCommand.SimpleMergePatchPicklistItem();
        }

        @Override
        protected AbstractPicklistItemCommand.SimpleRemovePicklistItem newRemovePicklistItem() {
            return new AbstractPicklistItemCommand.SimpleRemovePicklistItem();
        }


    }

}

