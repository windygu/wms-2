package org.dddml.wms.domain.inventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryStateEvent.*;

public interface InventoryItemEntryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemEntryId getInventoryItemEntryId();

    void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId);

    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

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

    Boolean getActive();

    void setActive(Boolean active);

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e);

    
}

