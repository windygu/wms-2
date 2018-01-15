package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemCommand extends AbstractCommand implements InventoryItemCommand
{
    private InventoryItemId inventoryItemId;

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
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


    public static abstract class AbstractCreateOrMergePatchInventoryItem extends AbstractInventoryItemCommand implements CreateOrMergePatchInventoryItem
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

        public InventoryItemEntryCommand.CreateInventoryItemEntry newCreateInventoryItemEntry()
        {
            AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry c = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
            c.setInventoryItemId(this.getInventoryItemId());

            return c;
        }

    }

    public static abstract class AbstractCreateInventoryItem extends AbstractCreateOrMergePatchInventoryItem implements CreateInventoryItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateInventoryItemEntryCommands entries = new SimpleCreateInventoryItemEntryCommands();

        public CreateInventoryItemEntryCommands getEntries()
        {
            return this.entries;
        }

    }

    public static abstract class AbstractMergePatchInventoryItem extends AbstractCreateOrMergePatchInventoryItem implements MergePatchInventoryItem
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

        private InventoryItemEntryCommands inventoryItemEntryCommands = new SimpleInventoryItemEntryCommands();

        public InventoryItemEntryCommands getInventoryItemEntryCommands()
        {
            return this.inventoryItemEntryCommands;
        }

    }

    public static class SimpleCreateInventoryItem extends AbstractCreateInventoryItem
    {
    }

    
    public static class SimpleMergePatchInventoryItem extends AbstractMergePatchInventoryItem
    {
    }

    
	public static class SimpleDeleteInventoryItem extends AbstractInventoryItemCommand implements DeleteInventoryItem
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateInventoryItemEntryCommands implements CreateInventoryItemEntryCommands
    {
        private List<InventoryItemEntryCommand.CreateInventoryItemEntry> innerCommands = new ArrayList<InventoryItemEntryCommand.CreateInventoryItemEntry>();

        public void add(InventoryItemEntryCommand.CreateInventoryItemEntry c)
        {
            innerCommands.add(c);
        }

        public void remove(InventoryItemEntryCommand.CreateInventoryItemEntry c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<InventoryItemEntryCommand.CreateInventoryItemEntry> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleInventoryItemEntryCommands implements InventoryItemEntryCommands
    {
        private List<InventoryItemEntryCommand> innerCommands = new ArrayList<InventoryItemEntryCommand>();

        public void add(InventoryItemEntryCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(InventoryItemEntryCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<InventoryItemEntryCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

