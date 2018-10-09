package org.dddml.wms.domain.sellableinventoryitem;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEvent.*;

public interface SellableInventoryItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getSellableInventoryItemId();

    BigDecimal getSellableQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    String getCommandId();

    EntityStateCollection<Long, SellableInventoryItemEntryState> getEntries();

    interface MutableSellableInventoryItemState extends SellableInventoryItemState {
        void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);

        void setSellableQuantity(BigDecimal sellableQuantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(SellableInventoryItemEvent.SellableInventoryItemStateCreated e);

        void when(SellableInventoryItemEvent.SellableInventoryItemStateMergePatched e);

    }

    interface SqlSellableInventoryItemState extends MutableSellableInventoryItemState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

