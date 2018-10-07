package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractSellableInventoryItemCommand extends AbstractCommand implements SellableInventoryItemCommand
{
    private InventoryItemId sellableInventoryItemId;

    public InventoryItemId getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchSellableInventoryItem extends AbstractSellableInventoryItemCommand implements CreateOrMergePatchSellableInventoryItem
    {
        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        public SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry newCreateSellableInventoryItemEntry()
        {
            AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry c = new AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry();
            c.setSellableInventoryItemId(this.getSellableInventoryItemId());

            return c;
        }

    }

    public static abstract class AbstractCreateSellableInventoryItem extends AbstractCreateOrMergePatchSellableInventoryItem implements CreateSellableInventoryItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateSellableInventoryItemEntryCommandCollection createSellableInventoryItemEntryCommands = new SimpleCreateSellableInventoryItemEntryCommandCollection();

        public CreateSellableInventoryItemEntryCommandCollection getCreateSellableInventoryItemEntryCommands() {
            return this.createSellableInventoryItemEntryCommands;
        }

        public CreateSellableInventoryItemEntryCommandCollection getEntries() {
            return this.createSellableInventoryItemEntryCommands; //entries;
        }

    }

    public static abstract class AbstractMergePatchSellableInventoryItem extends AbstractCreateOrMergePatchSellableInventoryItem implements MergePatchSellableInventoryItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private SellableInventoryItemEntryCommandCollection sellableInventoryItemEntryCommands = new SimpleSellableInventoryItemEntryCommandCollection();

        public SellableInventoryItemEntryCommandCollection getSellableInventoryItemEntryCommands()
        {
            return this.sellableInventoryItemEntryCommands;
        }

    }

    public static class SimpleCreateSellableInventoryItem extends AbstractCreateSellableInventoryItem
    {
    }

    
    public static class SimpleMergePatchSellableInventoryItem extends AbstractMergePatchSellableInventoryItem
    {
    }

    
	public static class SimpleDeleteSellableInventoryItem extends AbstractSellableInventoryItemCommand implements DeleteSellableInventoryItem
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateSellableInventoryItemEntryCommandCollection implements CreateSellableInventoryItemEntryCommandCollection {
        private List<SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry> innerCommands = new ArrayList<SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry>();

        public void add(SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c) {
            innerCommands.add(c);
        }

        public void remove(SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleSellableInventoryItemEntryCommandCollection implements SellableInventoryItemEntryCommandCollection {
        private List<SellableInventoryItemEntryCommand> innerCommands = new ArrayList<SellableInventoryItemEntryCommand>();

        public void add(SellableInventoryItemEntryCommand c) {
            innerCommands.add(c);
        }

        public void remove(SellableInventoryItemEntryCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<SellableInventoryItemEntryCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

