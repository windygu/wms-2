package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryItemRequirementEntryStateCommandConverter<TCreateInventoryItemRequirementEntry extends InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry>
{
    public InventoryItemRequirementEntryCommand toCreateOrMergePatchInventoryItemRequirementEntry(InventoryItemRequirementEntryState state)
    {
        //where TCreateInventoryItemRequirementEntry : ICreateInventoryItemRequirementEntry, new()
        //where TMergePatchInventoryItemRequirementEntry : IMergePatchInventoryItemRequirementEntry, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryItemRequirementEntry(state);
        }
        else 
        {
            return null;
        }
    }

    public TCreateInventoryItemRequirementEntry toCreateInventoryItemRequirementEntry(InventoryItemRequirementEntryState state) //where TCreateInventoryItemRequirementEntry : ICreateInventoryItemRequirementEntry, new()
    {
        TCreateInventoryItemRequirementEntry cmd = newCreateInventoryItemRequirementEntry();

        cmd.setEntrySeqId(state.getEntrySeqId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSourceEventId(state.getSourceEventId());
        cmd.setInventoryItemRequirementId(state.getInventoryItemRequirementId());
        return cmd;
    }

    protected abstract TCreateInventoryItemRequirementEntry newCreateInventoryItemRequirementEntry();

    public static class SimpleInventoryItemRequirementEntryStateCommandConverter extends AbstractInventoryItemRequirementEntryStateCommandConverter<AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry>
    {
        @Override
        protected AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry newCreateInventoryItemRequirementEntry() {
            return new AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry();
        }


    }

}

