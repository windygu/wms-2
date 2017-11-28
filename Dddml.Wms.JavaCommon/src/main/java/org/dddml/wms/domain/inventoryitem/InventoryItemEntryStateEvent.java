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

    BigDecimal getQuantityOnHandVar();

    void setQuantityOnHandVar(BigDecimal quantityOnHandVar);

    BigDecimal getQuantityReservedVar();

    void setQuantityReservedVar(BigDecimal quantityReservedVar);

    BigDecimal getQuantityOccupiedVar();

    void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar);

    BigDecimal getQuantityVirtualVar();

    void setQuantityVirtualVar(BigDecimal quantityVirtualVar);

    InventoryItemEventVO getEventVO();

    void setEventVO(InventoryItemEventVO eventVO);

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

