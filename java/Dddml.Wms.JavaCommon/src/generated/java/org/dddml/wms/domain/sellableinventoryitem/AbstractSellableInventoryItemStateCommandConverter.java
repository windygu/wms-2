package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public abstract class AbstractSellableInventoryItemStateCommandConverter<TCreateSellableInventoryItem extends SellableInventoryItemCommand.CreateSellableInventoryItem, TMergePatchSellableInventoryItem extends SellableInventoryItemCommand.MergePatchSellableInventoryItem, TDeleteSellableInventoryItem extends SellableInventoryItemCommand.DeleteSellableInventoryItem, TCreateSellableInventoryItemEntry extends SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry>
{
    public SellableInventoryItemCommand toCreateOrMergePatchSellableInventoryItem(SellableInventoryItemState state)
    {
        //where TCreateSellableInventoryItem : ICreateSellableInventoryItem, new()
        //where TMergePatchSellableInventoryItem : IMergePatchSellableInventoryItem, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateSellableInventoryItem(state);
        }
        else 
        {
            return toMergePatchSellableInventoryItem(state);
        }
    }

    public TDeleteSellableInventoryItem toDeleteSellableInventoryItem(SellableInventoryItemState state) //where TDeleteSellableInventoryItem : IDeleteSellableInventoryItem, new()
    {
        TDeleteSellableInventoryItem cmd = newDeleteSellableInventoryItem();
        cmd.setSellableInventoryItemId(state.getSellableInventoryItemId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchSellableInventoryItem toMergePatchSellableInventoryItem(SellableInventoryItemState state) //where TMergePatchSellableInventoryItem : IMergePatchSellableInventoryItem, new()
    {
        TMergePatchSellableInventoryItem cmd = newMergePatchSellableInventoryItem();

        cmd.setVersion(state.getVersion());

        cmd.setSellableInventoryItemId(state.getSellableInventoryItemId());
            
        for (SellableInventoryItemEntryState d : state.getEntries())
        {
            SellableInventoryItemEntryCommand c = getSellableInventoryItemEntryStateCommandConverter().toCreateOrMergePatchSellableInventoryItemEntry(d);
            cmd.getSellableInventoryItemEntryCommands().add(c);
        }
        return cmd;
    }

    public TCreateSellableInventoryItem toCreateSellableInventoryItem(SellableInventoryItemState state) //where TCreateSellableInventoryItem : ICreateSellableInventoryItem, new()
    {
        TCreateSellableInventoryItem cmd = newCreateSellableInventoryItem();

        cmd.setVersion(state.getVersion());
        cmd.setSellableInventoryItemId(state.getSellableInventoryItemId());
        for (SellableInventoryItemEntryState d : state.getEntries())
        {
            SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c = getSellableInventoryItemEntryStateCommandConverter().toCreateSellableInventoryItemEntry(d);
            cmd.getEntries().add(c);
        }
        return cmd;
    }

    protected abstract AbstractSellableInventoryItemEntryStateCommandConverter<TCreateSellableInventoryItemEntry>
        getSellableInventoryItemEntryStateCommandConverter();

    protected abstract TCreateSellableInventoryItem newCreateSellableInventoryItem();

    protected abstract TMergePatchSellableInventoryItem newMergePatchSellableInventoryItem(); 

    protected abstract TDeleteSellableInventoryItem newDeleteSellableInventoryItem();

    public static class SimpleSellableInventoryItemStateCommandConverter extends AbstractSellableInventoryItemStateCommandConverter<AbstractSellableInventoryItemCommand.SimpleCreateSellableInventoryItem, AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem, AbstractSellableInventoryItemCommand.SimpleDeleteSellableInventoryItem, AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry>
    {
        @Override
        protected AbstractSellableInventoryItemCommand.SimpleCreateSellableInventoryItem newCreateSellableInventoryItem() {
            return new AbstractSellableInventoryItemCommand.SimpleCreateSellableInventoryItem();
        }

        @Override
        protected AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem newMergePatchSellableInventoryItem() {
            return new AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem();
        }

        @Override
        protected AbstractSellableInventoryItemCommand.SimpleDeleteSellableInventoryItem newDeleteSellableInventoryItem() {
            return new AbstractSellableInventoryItemCommand.SimpleDeleteSellableInventoryItem();
        }

        @Override
        protected AbstractSellableInventoryItemEntryStateCommandConverter<AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry> getSellableInventoryItemEntryStateCommandConverter()
        {
            return new AbstractSellableInventoryItemEntryStateCommandConverter.SimpleSellableInventoryItemEntryStateCommandConverter();
        }


    }

}

