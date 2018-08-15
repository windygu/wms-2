package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEntryEvent extends Event
{
    InventoryItemEntryEventId getInventoryItemEntryEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemEntryStateEvent extends InventoryItemEntryEvent {
        Long getVersion();

        void setVersion(Long version);

        BigDecimal getOnHandQuantity();

        void setOnHandQuantity(BigDecimal onHandQuantity);

        BigDecimal getInTransitQuantity();

        void setInTransitQuantity(BigDecimal inTransitQuantity);

        BigDecimal getReservedQuantity();

        void setReservedQuantity(BigDecimal reservedQuantity);

        BigDecimal getOccupiedQuantity();

        void setOccupiedQuantity(BigDecimal occupiedQuantity);

        BigDecimal getVirtualQuantity();

        void setVirtualQuantity(BigDecimal virtualQuantity);

        InventoryItemSourceInfo getSource();

        void setSource(InventoryItemSourceInfo source);

        java.sql.Timestamp getOccurredAt();

        void setOccurredAt(java.sql.Timestamp occurredAt);

    }

    interface InventoryItemEntryStateCreated extends InventoryItemEntryStateEvent
    {
    
    }


}

