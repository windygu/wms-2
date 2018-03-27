package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPicklistBinStateCommandConverter<TCreatePicklistBin extends PicklistBinCommand.CreatePicklistBin, TMergePatchPicklistBin extends PicklistBinCommand.MergePatchPicklistBin, TDeletePicklistBin extends PicklistBinCommand.DeletePicklistBin, TCreatePicklistItem extends PicklistItemCommand.CreatePicklistItem, TMergePatchPicklistItem extends PicklistItemCommand.MergePatchPicklistItem, TRemovePicklistItem extends PicklistItemCommand.RemovePicklistItem>
{
    public PicklistBinCommand toCreateOrMergePatchPicklistBin(PicklistBinState state)
    {
        //where TCreatePicklistBin : ICreatePicklistBin, new()
        //where TMergePatchPicklistBin : IMergePatchPicklistBin, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePicklistBin(state);
        }
        else 
        {
            return toMergePatchPicklistBin(state);
        }
    }

    public TDeletePicklistBin toDeletePicklistBin(PicklistBinState state) //where TDeletePicklistBin : IDeletePicklistBin, new()
    {
        TDeletePicklistBin cmd = newDeletePicklistBin();
        cmd.setPicklistBinId(state.getPicklistBinId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchPicklistBin toMergePatchPicklistBin(PicklistBinState state) //where TMergePatchPicklistBin : IMergePatchPicklistBin, new()
    {
        TMergePatchPicklistBin cmd = newMergePatchPicklistBin();

        cmd.setVersion(state.getVersion());

        cmd.setPicklistBinId(state.getPicklistBinId());
        cmd.setPicklistId(state.getPicklistId());
        cmd.setBinLocationNumber(state.getBinLocationNumber());
        cmd.setPrimaryOrderId(state.getPrimaryOrderId());
        cmd.setPrimaryShipGroupSeqId(state.getPrimaryShipGroupSeqId());
        cmd.setActive(state.getActive());
            
        if (state.getPicklistId() == null) { cmd.setIsPropertyPicklistIdRemoved(true); }
        if (state.getBinLocationNumber() == null) { cmd.setIsPropertyBinLocationNumberRemoved(true); }
        if (state.getPrimaryOrderId() == null) { cmd.setIsPropertyPrimaryOrderIdRemoved(true); }
        if (state.getPrimaryShipGroupSeqId() == null) { cmd.setIsPropertyPrimaryShipGroupSeqIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (PicklistItemState d : state.getPicklistItems())
        {
            PicklistItemCommand c = getPicklistItemStateCommandConverter().toCreateOrMergePatchPicklistItem(d);
            cmd.getPicklistItemCommands().add(c);
        }
        return cmd;
    }

    public TCreatePicklistBin toCreatePicklistBin(PicklistBinState state) //where TCreatePicklistBin : ICreatePicklistBin, new()
    {
        TCreatePicklistBin cmd = newCreatePicklistBin();

        cmd.setVersion(state.getVersion());
        cmd.setPicklistBinId(state.getPicklistBinId());
        cmd.setPicklistId(state.getPicklistId());
        cmd.setBinLocationNumber(state.getBinLocationNumber());
        cmd.setPrimaryOrderId(state.getPrimaryOrderId());
        cmd.setPrimaryShipGroupSeqId(state.getPrimaryShipGroupSeqId());
        cmd.setActive(state.getActive());
        for (PicklistItemState d : state.getPicklistItems())
        {
            PicklistItemCommand.CreatePicklistItem c = getPicklistItemStateCommandConverter().toCreatePicklistItem(d);
            cmd.getPicklistItems().add(c);
        }
        return cmd;
    }

    protected abstract AbstractPicklistItemStateCommandConverter<TCreatePicklistItem, TMergePatchPicklistItem, TRemovePicklistItem>
        getPicklistItemStateCommandConverter();

    protected abstract TCreatePicklistBin newCreatePicklistBin();

    protected abstract TMergePatchPicklistBin newMergePatchPicklistBin(); 

    protected abstract TDeletePicklistBin newDeletePicklistBin();

    public static class SimplePicklistBinStateCommandConverter extends AbstractPicklistBinStateCommandConverter<AbstractPicklistBinCommand.SimpleCreatePicklistBin, AbstractPicklistBinCommand.SimpleMergePatchPicklistBin, AbstractPicklistBinCommand.SimpleDeletePicklistBin, AbstractPicklistItemCommand.SimpleCreatePicklistItem, AbstractPicklistItemCommand.SimpleMergePatchPicklistItem, AbstractPicklistItemCommand.SimpleRemovePicklistItem>
    {
        @Override
        protected AbstractPicklistBinCommand.SimpleCreatePicklistBin newCreatePicklistBin() {
            return new AbstractPicklistBinCommand.SimpleCreatePicklistBin();
        }

        @Override
        protected AbstractPicklistBinCommand.SimpleMergePatchPicklistBin newMergePatchPicklistBin() {
            return new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
        }

        @Override
        protected AbstractPicklistBinCommand.SimpleDeletePicklistBin newDeletePicklistBin() {
            return new AbstractPicklistBinCommand.SimpleDeletePicklistBin();
        }

        @Override
        protected AbstractPicklistItemStateCommandConverter<AbstractPicklistItemCommand.SimpleCreatePicklistItem, AbstractPicklistItemCommand.SimpleMergePatchPicklistItem, AbstractPicklistItemCommand.SimpleRemovePicklistItem> getPicklistItemStateCommandConverter()
        {
            return new AbstractPicklistItemStateCommandConverter.SimplePicklistItemStateCommandConverter();
        }


    }

}

