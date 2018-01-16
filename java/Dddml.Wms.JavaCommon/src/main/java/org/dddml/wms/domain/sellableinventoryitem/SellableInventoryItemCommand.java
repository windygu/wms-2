package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface SellableInventoryItemCommand extends Command
{
    InventoryItemId getSellableInventoryItemId();

    void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(SellableInventoryItemState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((SellableInventoryItemCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((SellableInventoryItemCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(SellableInventoryItemCommand c) {
        return ((c instanceof SellableInventoryItemCommand.CreateSellableInventoryItem) 
            && c.getVersion().equals(SellableInventoryItemState.VERSION_NULL));
    }

    interface CreateOrMergePatchSellableInventoryItem extends SellableInventoryItemCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateSellableInventoryItem extends CreateOrMergePatchSellableInventoryItem
    {
        CreateSellableInventoryItemEntryCommands getEntries();

        SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry newCreateSellableInventoryItemEntry();

    }

    interface MergePatchSellableInventoryItem extends CreateOrMergePatchSellableInventoryItem
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        SellableInventoryItemEntryCommands getSellableInventoryItemEntryCommands();

        SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry newCreateSellableInventoryItemEntry();

    }

	interface DeleteSellableInventoryItem extends SellableInventoryItemCommand
	{
	}

    interface CreateSellableInventoryItemEntryCommands extends Iterable<SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry>
    {
        void add(SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c);

        void remove(SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c);

        void clear();
    }

    interface SellableInventoryItemEntryCommands extends Iterable<SellableInventoryItemEntryCommand>
    {
        void add(SellableInventoryItemEntryCommand c);

        void remove(SellableInventoryItemEntryCommand c);

        void clear();
    }

}

