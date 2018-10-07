package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InventoryItemCommand extends Command
{
    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(InventoryItemState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((InventoryItemCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((InventoryItemCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InventoryItemCommand c) {
        return ((c instanceof InventoryItemCommand.CreateInventoryItem) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(InventoryItemState.VERSION_NULL)));
    }

    interface CreateOrMergePatchInventoryItem extends InventoryItemCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItem extends CreateOrMergePatchInventoryItem
    {
        CreateInventoryItemEntryCommandCollection getCreateInventoryItemEntryCommands();

        InventoryItemEntryCommand.CreateInventoryItemEntry newCreateInventoryItemEntry();

    }

    interface MergePatchInventoryItem extends CreateOrMergePatchInventoryItem
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        InventoryItemEntryCommandCollection getInventoryItemEntryCommands();

        InventoryItemEntryCommand.CreateInventoryItemEntry newCreateInventoryItemEntry();

    }

	interface DeleteInventoryItem extends InventoryItemCommand
	{
	}

    interface CreateInventoryItemEntryCommandCollection extends Iterable<InventoryItemEntryCommand.CreateInventoryItemEntry>
    {
        void add(InventoryItemEntryCommand.CreateInventoryItemEntry c);

        void remove(InventoryItemEntryCommand.CreateInventoryItemEntry c);

        void clear();
    }

    interface InventoryItemEntryCommandCollection extends Iterable<InventoryItemEntryCommand>
    {
        void add(InventoryItemEntryCommand c);

        void remove(InventoryItemEntryCommand c);

        void clear();
    }

}

