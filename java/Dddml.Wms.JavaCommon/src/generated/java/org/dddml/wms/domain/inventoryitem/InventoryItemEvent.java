package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEvent extends Event
{
    InventoryItemEventId getInventoryItemEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemStateCreated extends InventoryItemEvent
    {
        Iterable<InventoryItemEntryEvent.InventoryItemEntryStateCreated> getInventoryItemEntryEvents();
        
        void addInventoryItemEntryEvent(InventoryItemEntryEvent.InventoryItemEntryStateCreated e);

        InventoryItemEntryEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId);

    
    }


    interface InventoryItemStateMergePatched extends InventoryItemEvent
    {
        Boolean getIsPropertyOnHandQuantityRemoved();

        void setIsPropertyOnHandQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInTransitQuantityRemoved();

        void setIsPropertyInTransitQuantityRemoved(Boolean removed);

        Boolean getIsPropertyReservedQuantityRemoved();

        void setIsPropertyReservedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyOccupiedQuantityRemoved();

        void setIsPropertyOccupiedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVirtualQuantityRemoved();

        void setIsPropertyVirtualQuantityRemoved(Boolean removed);

        Iterable<InventoryItemEntryEvent> getInventoryItemEntryEvents();
        
        void addInventoryItemEntryEvent(InventoryItemEntryEvent e);

        InventoryItemEntryEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId);


    }


}

