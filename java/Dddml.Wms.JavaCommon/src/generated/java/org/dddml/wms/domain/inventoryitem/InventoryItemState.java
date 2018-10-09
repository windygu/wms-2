package org.dddml.wms.domain.inventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitem.InventoryItemEvent.*;

public interface InventoryItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getInventoryItemId();

    BigDecimal getOnHandQuantity();

    BigDecimal getInTransitQuantity();

    BigDecimal getReservedQuantity();

    BigDecimal getOccupiedQuantity();

    BigDecimal getVirtualQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    EntityStateCollection<Long, InventoryItemEntryState> getEntries();

    interface MutableInventoryItemState extends InventoryItemState {
        void setInventoryItemId(InventoryItemId inventoryItemId);

        void setOnHandQuantity(BigDecimal onHandQuantity);

        void setInTransitQuantity(BigDecimal inTransitQuantity);

        void setReservedQuantity(BigDecimal reservedQuantity);

        void setOccupiedQuantity(BigDecimal occupiedQuantity);

        void setVirtualQuantity(BigDecimal virtualQuantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);


        void mutate(Event e);

        void when(InventoryItemEvent.InventoryItemStateCreated e);

        void when(InventoryItemEvent.InventoryItemStateMergePatched e);

    }

    interface SqlInventoryItemState extends MutableInventoryItemState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

