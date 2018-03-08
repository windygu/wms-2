package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemStateEvent extends Event
{
    InventoryItemEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

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

    interface InventoryItemStateCreated extends InventoryItemStateEvent
    {
        Iterable<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> getInventoryItemEntryEvents();
        
        void addInventoryItemEntryEvent(InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e);

        InventoryItemEntryStateEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId);

    
    }


    interface InventoryItemStateMergePatched extends InventoryItemStateEvent
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

        Iterable<InventoryItemEntryStateEvent> getInventoryItemEntryEvents();
        
        void addInventoryItemEntryEvent(InventoryItemEntryStateEvent e);

        InventoryItemEntryStateEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId);


    }


}

