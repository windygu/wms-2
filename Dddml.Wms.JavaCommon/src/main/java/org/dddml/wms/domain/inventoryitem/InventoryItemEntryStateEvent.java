package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEntryStateEvent extends Event
{
    InventoryItemEntryStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    BigDecimal getQuantityOnHand();

    void setQuantityOnHand(BigDecimal quantityOnHand);

    BigDecimal getQuantityReserved();

    void setQuantityReserved(BigDecimal quantityReserved);

    BigDecimal getQuantityOccupied();

    void setQuantityOccupied(BigDecimal quantityOccupied);

    BigDecimal getQuantityVirtual();

    void setQuantityVirtual(BigDecimal quantityVirtual);

    InventoryItemSourceVO getSource();

    void setSource(InventoryItemSourceVO source);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemEntryStateCreated extends InventoryItemEntryStateEvent
    {
    
    }


}

