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

    SellableInventoryItemEntryId getSellableInventoryItemEntryId();

    void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId);

    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

    BigDecimal getSellableQuantity();

    void setSellableQuantity(BigDecimal sellableQuantity);

    InventoryPRTriggeredId getSourceEventId();

    void setSourceEventId(InventoryPRTriggeredId sourceEventId);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    InventoryItemId getSellableInventoryItemId();

    void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated e);

    
}

