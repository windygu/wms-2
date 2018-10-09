package org.dddml.wms.domain.inventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryEvent.*;

public interface InventoryItemEntryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    Long getEntrySeqId();

    BigDecimal getOnHandQuantity();

    BigDecimal getInTransitQuantity();

    BigDecimal getReservedQuantity();

    BigDecimal getOccupiedQuantity();

    BigDecimal getVirtualQuantity();

    InventoryItemSourceInfo getSource();

    java.sql.Timestamp getOccurredAt();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    InventoryItemId getInventoryItemId();

    String getCommandId();

    interface MutableInventoryItemEntryState extends InventoryItemEntryState {
        void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId);

        void setEntrySeqId(Long entrySeqId);

        void setOnHandQuantity(BigDecimal onHandQuantity);

        void setInTransitQuantity(BigDecimal inTransitQuantity);

        void setReservedQuantity(BigDecimal reservedQuantity);

        void setOccupiedQuantity(BigDecimal occupiedQuantity);

        void setVirtualQuantity(BigDecimal virtualQuantity);

        void setSource(InventoryItemSourceInfo source);

        void setOccurredAt(java.sql.Timestamp occurredAt);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setInventoryItemId(InventoryItemId inventoryItemId);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(InventoryItemEntryEvent.InventoryItemEntryStateCreated e);

    }

    interface SqlInventoryItemEntryState extends MutableInventoryItemEntryState {
        InventoryItemEntryId getInventoryItemEntryId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

