package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface InventoryItemCommand extends Command
{
    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);

    Long getVersion();

    void setVersion(Long version);


    interface CreateOrMergePatchInventoryItem extends InventoryItemCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItem extends CreateOrMergePatchInventoryItem
    {
        CreateInventoryItemEntryCommands getEntries();

        InventoryItemEntryCommand.CreateInventoryItemEntry newCreateInventoryItemEntry();

    }

    interface MergePatchInventoryItem extends CreateOrMergePatchInventoryItem
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        InventoryItemEntryCommands getInventoryItemEntryCommands();

        InventoryItemEntryCommand.CreateInventoryItemEntry newCreateInventoryItemEntry();

    }

	interface DeleteInventoryItem extends InventoryItemCommand
	{
	}

    interface CreateInventoryItemEntryCommands extends Iterable<InventoryItemEntryCommand.CreateInventoryItemEntry>
    {
        void add(InventoryItemEntryCommand.CreateInventoryItemEntry c);

        void remove(InventoryItemEntryCommand.CreateInventoryItemEntry c);

        void clear();
    }

    interface InventoryItemEntryCommands extends Iterable<InventoryItemEntryCommand>
    {
        void add(InventoryItemEntryCommand c);

        void remove(InventoryItemEntryCommand c);

        void clear();
    }

}

