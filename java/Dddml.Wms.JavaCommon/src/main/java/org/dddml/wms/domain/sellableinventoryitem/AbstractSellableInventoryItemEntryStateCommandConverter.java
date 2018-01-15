package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public abstract class AbstractSellableInventoryItemEntryStateCommandConverter<TCreateSellableInventoryItemEntry extends SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry>
{
    public SellableInventoryItemEntryCommand toCreateOrMergePatchSellableInventoryItemEntry(SellableInventoryItemEntryState state)
    {
        //where TCreateSellableInventoryItemEntry : ICreateSellableInventoryItemEntry, new()
        //where TMergePatchSellableInventoryItemEntry : IMergePatchSellableInventoryItemEntry, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateSellableInventoryItemEntry(state);
        }
        else 
        {
            return null;
        }
    }

    public TCreateSellableInventoryItemEntry toCreateSellableInventoryItemEntry(SellableInventoryItemEntryState state) //where TCreateSellableInventoryItemEntry : ICreateSellableInventoryItemEntry, new()
    {
        TCreateSellableInventoryItemEntry cmd = newCreateSellableInventoryItemEntry();

        cmd.setEntrySeqId(state.getEntrySeqId());
        cmd.setSellableQuantity(state.getSellableQuantity());
        cmd.setSourceEventId(state.getSourceEventId());
        cmd.setSellableInventoryItemId(state.getSellableInventoryItemId());
        return cmd;
    }

    protected abstract TCreateSellableInventoryItemEntry newCreateSellableInventoryItemEntry();

    public static class SimpleSellableInventoryItemEntryStateCommandConverter extends AbstractSellableInventoryItemEntryStateCommandConverter<AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry>
    {
        @Override
        protected AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry newCreateSellableInventoryItemEntry() {
            return new AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry();
        }


    }

}

