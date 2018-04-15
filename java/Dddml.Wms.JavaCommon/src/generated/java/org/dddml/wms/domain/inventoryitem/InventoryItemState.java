package org.dddml.wms.domain.inventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitem.InventoryItemEvent.*;

public interface InventoryItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);

    BigDecimal getOnHandQuantity();

    void setOnHandQuantity(BigDecimal onHandQuantity);

    BigDecimal getInTransitQuantity();

    void setInTransitQuantity(BigDecimal inTransitQuantity);

    BigDecimal getReservedQuantity();

    void setReservedQuantity(BigDecimal reservedQuantity);

    BigDecimal getOccupiedQuantity();

    void setOccupiedQuantity(BigDecimal occupiedQuantity);

    BigDecimal getVirtualQuantity();

    void setVirtualQuantity(BigDecimal virtualQuantity);

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

    void when(InventoryItemEvent.InventoryItemStateCreated e);

    void when(InventoryItemEvent.InventoryItemStateMergePatched e);

    
}

