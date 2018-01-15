package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.Set;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.sellableinventoryitementrymvo.SellableInventoryItemEntryMvoStateEvent.*;

public interface SellableInventoryItemEntryMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    SellableInventoryItemEntryId getSellableInventoryItemEntryId();

    void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId);

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

    BigDecimal getSellableInventoryItemSellableQuantity();

    void setSellableInventoryItemSellableQuantity(BigDecimal sellableInventoryItemSellableQuantity);

    Long getSellableInventoryItemVersion();

    void setSellableInventoryItemVersion(Long sellableInventoryItemVersion);

    String getSellableInventoryItemCreatedBy();

    void setSellableInventoryItemCreatedBy(String sellableInventoryItemCreatedBy);

    Date getSellableInventoryItemCreatedAt();

    void setSellableInventoryItemCreatedAt(Date sellableInventoryItemCreatedAt);

    String getSellableInventoryItemUpdatedBy();

    void setSellableInventoryItemUpdatedBy(String sellableInventoryItemUpdatedBy);

    Date getSellableInventoryItemUpdatedAt();

    void setSellableInventoryItemUpdatedAt(Date sellableInventoryItemUpdatedAt);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e);

    void when(SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e);

    
}

