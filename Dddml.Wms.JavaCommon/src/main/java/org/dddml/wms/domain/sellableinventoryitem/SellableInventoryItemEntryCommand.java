package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface SellableInventoryItemEntryCommand extends Command
{
    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

    InventoryItemId getSellableInventoryItemId();

    void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);

    interface CreateOrMergePatchSellableInventoryItemEntry extends SellableInventoryItemEntryCommand
    {
        BigDecimal getQuantitySellable();

        void setQuantitySellable(BigDecimal quantitySellable);

        InventoryPRTriggeredId getSourceEventId();

        void setSourceEventId(InventoryPRTriggeredId sourceEventId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateSellableInventoryItemEntry extends CreateOrMergePatchSellableInventoryItemEntry
    {
    }

}

