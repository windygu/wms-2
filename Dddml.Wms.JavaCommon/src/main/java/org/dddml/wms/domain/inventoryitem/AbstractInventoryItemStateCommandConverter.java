package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryItemStateCommandConverter<TCreateInventoryItem extends InventoryItemCommand.CreateInventoryItem, TMergePatchInventoryItem extends InventoryItemCommand.MergePatchInventoryItem, TDeleteInventoryItem extends InventoryItemCommand.DeleteInventoryItem, TCreateInventoryItemEntry extends InventoryItemEntryCommand.CreateInventoryItemEntry>
{
    public InventoryItemCommand toCreateOrMergePatchInventoryItem(InventoryItemState state)
    {
        //where TCreateInventoryItem : ICreateInventoryItem, new()
        //where TMergePatchInventoryItem : IMergePatchInventoryItem, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryItem(state);
        }
        else 
        {
            return toMergePatchInventoryItem(state);
        }
    }

    public TDeleteInventoryItem toDeleteInventoryItem(InventoryItemState state) //where TDeleteInventoryItem : IDeleteInventoryItem, new()
    {
        TDeleteInventoryItem cmd = newDeleteInventoryItem();
        cmd.setInventoryItemId(state.getInventoryItemId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchInventoryItem toMergePatchInventoryItem(InventoryItemState state) //where TMergePatchInventoryItem : IMergePatchInventoryItem, new()
    {
        TMergePatchInventoryItem cmd = newMergePatchInventoryItem();

        cmd.setVersion(state.getVersion());

        cmd.setInventoryItemId(state.getInventoryItemId());
            
        for (InventoryItemEntryState d : state.getEntries())
        {
            InventoryItemEntryCommand c = getInventoryItemEntryStateCommandConverter().toCreateOrMergePatchInventoryItemEntry(d);
            cmd.getInventoryItemEntryCommands().add(c);
        }
        return cmd;
    }

    public TCreateInventoryItem toCreateInventoryItem(InventoryItemState state) //where TCreateInventoryItem : ICreateInventoryItem, new()
    {
        TCreateInventoryItem cmd = newCreateInventoryItem();

        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemId(state.getInventoryItemId());
        for (InventoryItemEntryState d : state.getEntries())
        {
            InventoryItemEntryCommand.CreateInventoryItemEntry c = getInventoryItemEntryStateCommandConverter().toCreateInventoryItemEntry(d);
            cmd.getEntries().add(c);
        }
        return cmd;
    }

    protected abstract AbstractInventoryItemEntryStateCommandConverter<TCreateInventoryItemEntry>
        getInventoryItemEntryStateCommandConverter();

    protected abstract TCreateInventoryItem newCreateInventoryItem();

    protected abstract TMergePatchInventoryItem newMergePatchInventoryItem(); 

    protected abstract TDeleteInventoryItem newDeleteInventoryItem();

    public static class SimpleInventoryItemStateCommandConverter extends AbstractInventoryItemStateCommandConverter<AbstractInventoryItemCommand.SimpleCreateInventoryItem, AbstractInventoryItemCommand.SimpleMergePatchInventoryItem, AbstractInventoryItemCommand.SimpleDeleteInventoryItem, AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry>
    {
        @Override
        protected AbstractInventoryItemCommand.SimpleCreateInventoryItem newCreateInventoryItem() {
            return new AbstractInventoryItemCommand.SimpleCreateInventoryItem();
        }

        @Override
        protected AbstractInventoryItemCommand.SimpleMergePatchInventoryItem newMergePatchInventoryItem() {
            return new AbstractInventoryItemCommand.SimpleMergePatchInventoryItem();
        }

        @Override
        protected AbstractInventoryItemCommand.SimpleDeleteInventoryItem newDeleteInventoryItem() {
            return new AbstractInventoryItemCommand.SimpleDeleteInventoryItem();
        }

        @Override
        protected AbstractInventoryItemEntryStateCommandConverter<AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry> getInventoryItemEntryStateCommandConverter()
        {
            return new AbstractInventoryItemEntryStateCommandConverter.SimpleInventoryItemEntryStateCommandConverter();
        }


    }

}

