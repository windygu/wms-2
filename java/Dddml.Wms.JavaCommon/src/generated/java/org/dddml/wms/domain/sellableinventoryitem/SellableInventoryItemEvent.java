package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface SellableInventoryItemEvent extends Event {

    interface SqlSellableInventoryItemEvent extends SellableInventoryItemEvent {
        SellableInventoryItemEventId getSellableInventoryItemEventId();
    }

    InventoryItemId getSellableInventoryItemId();

    //void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface SellableInventoryItemStateEvent extends SellableInventoryItemEvent {
        BigDecimal getSellableQuantity();

        void setSellableQuantity(BigDecimal sellableQuantity);

    }

    interface SellableInventoryItemStateCreated extends SellableInventoryItemStateEvent
    {
        Iterable<SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated> getSellableInventoryItemEntryEvents();
        
        void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated e);

        SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId);

    
    }


    interface SellableInventoryItemStateMergePatched extends SellableInventoryItemStateEvent
    {
        Boolean getIsPropertySellableQuantityRemoved();

        void setIsPropertySellableQuantityRemoved(Boolean removed);

        Iterable<SellableInventoryItemEntryEvent> getSellableInventoryItemEntryEvents();
        
        void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryEvent e);

        SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId);


    }


}

