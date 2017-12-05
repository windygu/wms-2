package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface SellableInventoryItemEntryMvoStateEvent extends Event
{
    SellableInventoryItemEntryMvoStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getQuantitySellable();

    void setQuantitySellable(BigDecimal quantitySellable);

    InventoryPRTriggeredId getSourceEventId();

    void setSourceEventId(InventoryPRTriggeredId sourceEventId);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    BigDecimal getSellableInventoryItemQuantitySellable();

    void setSellableInventoryItemQuantitySellable(BigDecimal sellableInventoryItemQuantitySellable);

    String getSellableInventoryItemCreatedBy();

    void setSellableInventoryItemCreatedBy(String sellableInventoryItemCreatedBy);

    Date getSellableInventoryItemCreatedAt();

    void setSellableInventoryItemCreatedAt(Date sellableInventoryItemCreatedAt);

    String getSellableInventoryItemUpdatedBy();

    void setSellableInventoryItemUpdatedBy(String sellableInventoryItemUpdatedBy);

    Date getSellableInventoryItemUpdatedAt();

    void setSellableInventoryItemUpdatedAt(Date sellableInventoryItemUpdatedAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface SellableInventoryItemEntryMvoStateCreated extends SellableInventoryItemEntryMvoStateEvent
    {
    
    }


    interface SellableInventoryItemEntryMvoStateMergePatched extends SellableInventoryItemEntryMvoStateEvent
    {
        Boolean getIsPropertyQuantitySellableRemoved();

        void setIsPropertyQuantitySellableRemoved(Boolean removed);

        Boolean getIsPropertySourceEventIdRemoved();

        void setIsPropertySourceEventIdRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertySellableInventoryItemQuantitySellableRemoved();

        void setIsPropertySellableInventoryItemQuantitySellableRemoved(Boolean removed);

        Boolean getIsPropertySellableInventoryItemCreatedByRemoved();

        void setIsPropertySellableInventoryItemCreatedByRemoved(Boolean removed);

        Boolean getIsPropertySellableInventoryItemCreatedAtRemoved();

        void setIsPropertySellableInventoryItemCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertySellableInventoryItemUpdatedByRemoved();

        void setIsPropertySellableInventoryItemUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertySellableInventoryItemUpdatedAtRemoved();

        void setIsPropertySellableInventoryItemUpdatedAtRemoved(Boolean removed);


    }


}
