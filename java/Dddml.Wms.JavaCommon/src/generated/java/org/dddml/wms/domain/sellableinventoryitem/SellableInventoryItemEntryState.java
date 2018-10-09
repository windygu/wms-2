package org.dddml.wms.domain.sellableinventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryEvent.*;

public interface SellableInventoryItemEntryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    Long getEntrySeqId();

    BigDecimal getSellableQuantity();

    InventoryPRTriggeredId getSourceEventId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    InventoryItemId getSellableInventoryItemId();

    String getCommandId();

    interface MutableSellableInventoryItemEntryState extends SellableInventoryItemEntryState {
        void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId);

        void setEntrySeqId(Long entrySeqId);

        void setSellableQuantity(BigDecimal sellableQuantity);

        void setSourceEventId(InventoryPRTriggeredId sourceEventId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated e);

    }

    interface SqlSellableInventoryItemEntryState extends MutableSellableInventoryItemEntryState {
        SellableInventoryItemEntryId getSellableInventoryItemEntryId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

