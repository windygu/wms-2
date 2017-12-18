package org.dddml.wms.domain.inventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitem.InventoryItemStateEvent.*;

public interface InventoryItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);

    BigDecimal getQuantityOnHand();

    void setQuantityOnHand(BigDecimal quantityOnHand);

    BigDecimal getQuantityInTransit();

    void setQuantityInTransit(BigDecimal quantityInTransit);

    BigDecimal getQuantityReserved();

    void setQuantityReserved(BigDecimal quantityReserved);

    BigDecimal getQuantityOccupied();

    void setQuantityOccupied(BigDecimal quantityOccupied);

    BigDecimal getQuantityVirtual();

    void setQuantityVirtual(BigDecimal quantityVirtual);

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

    InventoryItemEntryStates getEntries();


    void mutate(Event e);

    void when(InventoryItemStateEvent.InventoryItemStateCreated e);

    void when(InventoryItemStateEvent.InventoryItemStateMergePatched e);

    
}

