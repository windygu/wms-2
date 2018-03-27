package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPicklistItemMvoStateCommandConverter<TCreatePicklistItemMvo extends PicklistItemMvoCommand.CreatePicklistItemMvo, TMergePatchPicklistItemMvo extends PicklistItemMvoCommand.MergePatchPicklistItemMvo, TDeletePicklistItemMvo extends PicklistItemMvoCommand.DeletePicklistItemMvo>
{
    public PicklistItemMvoCommand toCreateOrMergePatchPicklistItemMvo(PicklistItemMvoState state)
    {
        //where TCreatePicklistItemMvo : ICreatePicklistItemMvo, new()
        //where TMergePatchPicklistItemMvo : IMergePatchPicklistItemMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePicklistItemMvo(state);
        }
        else 
        {
            return toMergePatchPicklistItemMvo(state);
        }
    }

    public TDeletePicklistItemMvo toDeletePicklistItemMvo(PicklistItemMvoState state) //where TDeletePicklistItemMvo : IDeletePicklistItemMvo, new()
    {
        TDeletePicklistItemMvo cmd = newDeletePicklistItemMvo();
        cmd.setPicklistBinPicklistItemId(state.getPicklistBinPicklistItemId());
        cmd.setPicklistBinVersion(state.getPicklistBinVersion());

        return cmd;
    }

    public TMergePatchPicklistItemMvo toMergePatchPicklistItemMvo(PicklistItemMvoState state) //where TMergePatchPicklistItemMvo : IMergePatchPicklistItemMvo, new()
    {
        TMergePatchPicklistItemMvo cmd = newMergePatchPicklistItemMvo();

        cmd.setPicklistBinVersion(state.getPicklistBinVersion());

        cmd.setPicklistBinPicklistItemId(state.getPicklistBinPicklistItemId());
        cmd.setItemStatusId(state.getItemStatusId());
        cmd.setQuantity(state.getQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setPicklistBinPicklistId(state.getPicklistBinPicklistId());
        cmd.setPicklistBinBinLocationNumber(state.getPicklistBinBinLocationNumber());
        cmd.setPicklistBinPrimaryOrderId(state.getPicklistBinPrimaryOrderId());
        cmd.setPicklistBinPrimaryShipGroupSeqId(state.getPicklistBinPrimaryShipGroupSeqId());
        cmd.setPicklistBinCreatedBy(state.getPicklistBinCreatedBy());
        cmd.setPicklistBinCreatedAt(state.getPicklistBinCreatedAt());
        cmd.setPicklistBinUpdatedBy(state.getPicklistBinUpdatedBy());
        cmd.setPicklistBinUpdatedAt(state.getPicklistBinUpdatedAt());
        cmd.setPicklistBinActive(state.getPicklistBinActive());
        cmd.setPicklistBinDeleted(state.getPicklistBinDeleted());
            
        if (state.getItemStatusId() == null) { cmd.setIsPropertyItemStatusIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getPicklistBinPicklistId() == null) { cmd.setIsPropertyPicklistBinPicklistIdRemoved(true); }
        if (state.getPicklistBinBinLocationNumber() == null) { cmd.setIsPropertyPicklistBinBinLocationNumberRemoved(true); }
        if (state.getPicklistBinPrimaryOrderId() == null) { cmd.setIsPropertyPicklistBinPrimaryOrderIdRemoved(true); }
        if (state.getPicklistBinPrimaryShipGroupSeqId() == null) { cmd.setIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved(true); }
        if (state.getPicklistBinCreatedBy() == null) { cmd.setIsPropertyPicklistBinCreatedByRemoved(true); }
        if (state.getPicklistBinCreatedAt() == null) { cmd.setIsPropertyPicklistBinCreatedAtRemoved(true); }
        if (state.getPicklistBinUpdatedBy() == null) { cmd.setIsPropertyPicklistBinUpdatedByRemoved(true); }
        if (state.getPicklistBinUpdatedAt() == null) { cmd.setIsPropertyPicklistBinUpdatedAtRemoved(true); }
        if (state.getPicklistBinActive() == null) { cmd.setIsPropertyPicklistBinActiveRemoved(true); }
        if (state.getPicklistBinDeleted() == null) { cmd.setIsPropertyPicklistBinDeletedRemoved(true); }
        return cmd;
    }

    public TCreatePicklistItemMvo toCreatePicklistItemMvo(PicklistItemMvoState state) //where TCreatePicklistItemMvo : ICreatePicklistItemMvo, new()
    {
        TCreatePicklistItemMvo cmd = newCreatePicklistItemMvo();

        cmd.setPicklistBinVersion(state.getPicklistBinVersion());
        cmd.setPicklistBinPicklistItemId(state.getPicklistBinPicklistItemId());
        cmd.setItemStatusId(state.getItemStatusId());
        cmd.setQuantity(state.getQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setPicklistBinPicklistId(state.getPicklistBinPicklistId());
        cmd.setPicklistBinBinLocationNumber(state.getPicklistBinBinLocationNumber());
        cmd.setPicklistBinPrimaryOrderId(state.getPicklistBinPrimaryOrderId());
        cmd.setPicklistBinPrimaryShipGroupSeqId(state.getPicklistBinPrimaryShipGroupSeqId());
        cmd.setPicklistBinCreatedBy(state.getPicklistBinCreatedBy());
        cmd.setPicklistBinCreatedAt(state.getPicklistBinCreatedAt());
        cmd.setPicklistBinUpdatedBy(state.getPicklistBinUpdatedBy());
        cmd.setPicklistBinUpdatedAt(state.getPicklistBinUpdatedAt());
        cmd.setPicklistBinActive(state.getPicklistBinActive());
        cmd.setPicklistBinDeleted(state.getPicklistBinDeleted());
        return cmd;
    }

    protected abstract TCreatePicklistItemMvo newCreatePicklistItemMvo();

    protected abstract TMergePatchPicklistItemMvo newMergePatchPicklistItemMvo(); 

    protected abstract TDeletePicklistItemMvo newDeletePicklistItemMvo();

    public static class SimplePicklistItemMvoStateCommandConverter extends AbstractPicklistItemMvoStateCommandConverter<AbstractPicklistItemMvoCommand.SimpleCreatePicklistItemMvo, AbstractPicklistItemMvoCommand.SimpleMergePatchPicklistItemMvo, AbstractPicklistItemMvoCommand.SimpleDeletePicklistItemMvo>
    {
        @Override
        protected AbstractPicklistItemMvoCommand.SimpleCreatePicklistItemMvo newCreatePicklistItemMvo() {
            return new AbstractPicklistItemMvoCommand.SimpleCreatePicklistItemMvo();
        }

        @Override
        protected AbstractPicklistItemMvoCommand.SimpleMergePatchPicklistItemMvo newMergePatchPicklistItemMvo() {
            return new AbstractPicklistItemMvoCommand.SimpleMergePatchPicklistItemMvo();
        }

        @Override
        protected AbstractPicklistItemMvoCommand.SimpleDeletePicklistItemMvo newDeletePicklistItemMvo() {
            return new AbstractPicklistItemMvoCommand.SimpleDeletePicklistItemMvo();
        }


    }

}

