package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryItemRequirementEntryMvoStateCommandConverter<TCreateInventoryItemRequirementEntryMvo extends InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo, TMergePatchInventoryItemRequirementEntryMvo extends InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo, TDeleteInventoryItemRequirementEntryMvo extends InventoryItemRequirementEntryMvoCommand.DeleteInventoryItemRequirementEntryMvo>
{
    public InventoryItemRequirementEntryMvoCommand toCreateOrMergePatchInventoryItemRequirementEntryMvo(InventoryItemRequirementEntryMvoState state)
    {
        //where TCreateInventoryItemRequirementEntryMvo : ICreateInventoryItemRequirementEntryMvo, new()
        //where TMergePatchInventoryItemRequirementEntryMvo : IMergePatchInventoryItemRequirementEntryMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryItemRequirementEntryMvo(state);
        }
        else 
        {
            return toMergePatchInventoryItemRequirementEntryMvo(state);
        }
    }

    public TDeleteInventoryItemRequirementEntryMvo toDeleteInventoryItemRequirementEntryMvo(InventoryItemRequirementEntryMvoState state) //where TDeleteInventoryItemRequirementEntryMvo : IDeleteInventoryItemRequirementEntryMvo, new()
    {
        TDeleteInventoryItemRequirementEntryMvo cmd = newDeleteInventoryItemRequirementEntryMvo();
        cmd.setInventoryItemRequirementEntryId(state.getInventoryItemRequirementEntryId());
        cmd.setInventoryItemRequirementVersion(state.getInventoryItemRequirementVersion());

        return cmd;
    }

    public TMergePatchInventoryItemRequirementEntryMvo toMergePatchInventoryItemRequirementEntryMvo(InventoryItemRequirementEntryMvoState state) //where TMergePatchInventoryItemRequirementEntryMvo : IMergePatchInventoryItemRequirementEntryMvo, new()
    {
        TMergePatchInventoryItemRequirementEntryMvo cmd = newMergePatchInventoryItemRequirementEntryMvo();

        cmd.setInventoryItemRequirementVersion(state.getInventoryItemRequirementVersion());

        cmd.setInventoryItemRequirementEntryId(state.getInventoryItemRequirementEntryId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSourceEventId(state.getSourceEventId());
        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemRequirementQuantity(state.getInventoryItemRequirementQuantity());
        cmd.setInventoryItemRequirementCreatedBy(state.getInventoryItemRequirementCreatedBy());
        cmd.setInventoryItemRequirementCreatedAt(state.getInventoryItemRequirementCreatedAt());
        cmd.setInventoryItemRequirementUpdatedBy(state.getInventoryItemRequirementUpdatedBy());
        cmd.setInventoryItemRequirementUpdatedAt(state.getInventoryItemRequirementUpdatedAt());
            
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getSourceEventId() == null) { cmd.setIsPropertySourceEventIdRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getInventoryItemRequirementQuantity() == null) { cmd.setIsPropertyInventoryItemRequirementQuantityRemoved(true); }
        if (state.getInventoryItemRequirementCreatedBy() == null) { cmd.setIsPropertyInventoryItemRequirementCreatedByRemoved(true); }
        if (state.getInventoryItemRequirementCreatedAt() == null) { cmd.setIsPropertyInventoryItemRequirementCreatedAtRemoved(true); }
        if (state.getInventoryItemRequirementUpdatedBy() == null) { cmd.setIsPropertyInventoryItemRequirementUpdatedByRemoved(true); }
        if (state.getInventoryItemRequirementUpdatedAt() == null) { cmd.setIsPropertyInventoryItemRequirementUpdatedAtRemoved(true); }
        return cmd;
    }

    public TCreateInventoryItemRequirementEntryMvo toCreateInventoryItemRequirementEntryMvo(InventoryItemRequirementEntryMvoState state) //where TCreateInventoryItemRequirementEntryMvo : ICreateInventoryItemRequirementEntryMvo, new()
    {
        TCreateInventoryItemRequirementEntryMvo cmd = newCreateInventoryItemRequirementEntryMvo();

        cmd.setInventoryItemRequirementVersion(state.getInventoryItemRequirementVersion());
        cmd.setInventoryItemRequirementEntryId(state.getInventoryItemRequirementEntryId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSourceEventId(state.getSourceEventId());
        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemRequirementQuantity(state.getInventoryItemRequirementQuantity());
        cmd.setInventoryItemRequirementCreatedBy(state.getInventoryItemRequirementCreatedBy());
        cmd.setInventoryItemRequirementCreatedAt(state.getInventoryItemRequirementCreatedAt());
        cmd.setInventoryItemRequirementUpdatedBy(state.getInventoryItemRequirementUpdatedBy());
        cmd.setInventoryItemRequirementUpdatedAt(state.getInventoryItemRequirementUpdatedAt());
        return cmd;
    }

    protected abstract TCreateInventoryItemRequirementEntryMvo newCreateInventoryItemRequirementEntryMvo();

    protected abstract TMergePatchInventoryItemRequirementEntryMvo newMergePatchInventoryItemRequirementEntryMvo(); 

    protected abstract TDeleteInventoryItemRequirementEntryMvo newDeleteInventoryItemRequirementEntryMvo();

    public static class SimpleInventoryItemRequirementEntryMvoStateCommandConverter extends AbstractInventoryItemRequirementEntryMvoStateCommandConverter<AbstractInventoryItemRequirementEntryMvoCommand.SimpleCreateInventoryItemRequirementEntryMvo, AbstractInventoryItemRequirementEntryMvoCommand.SimpleMergePatchInventoryItemRequirementEntryMvo, AbstractInventoryItemRequirementEntryMvoCommand.SimpleDeleteInventoryItemRequirementEntryMvo>
    {
        @Override
        protected AbstractInventoryItemRequirementEntryMvoCommand.SimpleCreateInventoryItemRequirementEntryMvo newCreateInventoryItemRequirementEntryMvo() {
            return new AbstractInventoryItemRequirementEntryMvoCommand.SimpleCreateInventoryItemRequirementEntryMvo();
        }

        @Override
        protected AbstractInventoryItemRequirementEntryMvoCommand.SimpleMergePatchInventoryItemRequirementEntryMvo newMergePatchInventoryItemRequirementEntryMvo() {
            return new AbstractInventoryItemRequirementEntryMvoCommand.SimpleMergePatchInventoryItemRequirementEntryMvo();
        }

        @Override
        protected AbstractInventoryItemRequirementEntryMvoCommand.SimpleDeleteInventoryItemRequirementEntryMvo newDeleteInventoryItemRequirementEntryMvo() {
            return new AbstractInventoryItemRequirementEntryMvoCommand.SimpleDeleteInventoryItemRequirementEntryMvo();
        }


    }

}

