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

    void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId);

    BigDecimal getSellableQuantity();

    void setSellableQuantity(BigDecimal sellableQuantity);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);

    SellableInventoryItemEntryStates getEntries();


    void mutate(Event e);

    void when(SellableInventoryItemEvent.SellableInventoryItemStateCreated e);

    void when(SellableInventoryItemEvent.SellableInventoryItemStateMergePatched e);

    
}

