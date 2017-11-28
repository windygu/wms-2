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
        BigDecimal getQuantityOnHand();

        void setQuantityOnHand(BigDecimal quantityOnHand);

        BigDecimal getQuantityReserved();

        void setQuantityReserved(BigDecimal quantityReserved);

        BigDecimal getQuantityOccupied();

        void setQuantityOccupied(BigDecimal quantityOccupied);

        BigDecimal getQuantityVirtual();

        void setQuantityVirtual(BigDecimal quantityVirtual);

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
        Boolean getIsPropertyQuantityOnHandRemoved();

        void setIsPropertyQuantityOnHandRemoved(Boolean removed);

        Boolean getIsPropertyQuantityReservedRemoved();

        void setIsPropertyQuantityReservedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityOccupiedRemoved();

        void setIsPropertyQuantityOccupiedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityVirtualRemoved();

        void setIsPropertyQuantityVirtualRemoved(Boolean removed);

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

