package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface SellableInventoryItemStateEvent extends Event
{
    SellableInventoryItemStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getQuantitySellable();

    void setQuantitySellable(BigDecimal quantitySellable);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface SellableInventoryItemStateCreated extends SellableInventoryItemStateEvent
    {
        Iterable<SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated> getSellableInventoryItemEntryEvents();
        
        void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated e);

        SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId);

    
    }


    interface SellableInventoryItemStateMergePatched extends SellableInventoryItemStateEvent
    {
        Boolean getIsPropertyQuantitySellableRemoved();

        void setIsPropertyQuantitySellableRemoved(Boolean removed);

        Iterable<SellableInventoryItemEntryStateEvent> getSellableInventoryItemEntryEvents();
        
        void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryStateEvent e);

        SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId);


    }


}

