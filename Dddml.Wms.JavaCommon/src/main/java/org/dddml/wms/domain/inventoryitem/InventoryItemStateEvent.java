package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemStateEvent extends Event
{
    InventoryItemStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getQuantityOnHand();

    void setQuantityOnHand(BigDecimal quantityOnHand);

    BigDecimal getQuantityInTransit();

    void setQuantityInTransit(BigDecimal quantityInTransit);

    BigDecimal getQuantityReserved();

    void setQuantityReserved(BigDecimal quantityReserved);

    BigDecimal getQuantityOccupied();

    void setQuantityOccupied(BigDecimal quantityOccupied);

    BigDecimal getQuantityVirtual();

    void setQuantityVirtual(BigDecimal quantityVirtual);

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
        Boolean getIsPropertyQuantityOnHandRemoved();

        void setIsPropertyQuantityOnHandRemoved(Boolean removed);

        Boolean getIsPropertyQuantityInTransitRemoved();

        void setIsPropertyQuantityInTransitRemoved(Boolean removed);

        Boolean getIsPropertyQuantityReservedRemoved();

        void setIsPropertyQuantityReservedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityOccupiedRemoved();

        void setIsPropertyQuantityOccupiedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityVirtualRemoved();

        void setIsPropertyQuantityVirtualRemoved(Boolean removed);

        Iterable<InventoryItemEntryStateEvent> getInventoryItemEntryEvents();
        
        void addInventoryItemEntryEvent(InventoryItemEntryStateEvent e);

        InventoryItemEntryStateEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(Long entrySeqId);


    }


}

