package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface SellableInventoryItemEntryStateEvent extends Event
{
    SellableInventoryItemEntryEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    BigDecimal getSellableQuantity();

    void setSellableQuantity(BigDecimal sellableQuantity);

    InventoryPRTriggeredId getSourceEventId();

    void setSourceEventId(InventoryPRTriggeredId sourceEventId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface SellableInventoryItemEntryStateCreated extends SellableInventoryItemEntryStateEvent
    {
    
    }


}

