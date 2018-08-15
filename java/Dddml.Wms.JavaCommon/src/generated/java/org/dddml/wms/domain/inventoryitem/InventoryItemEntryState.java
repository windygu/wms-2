package org.dddml.wms.domain.inventoryitem;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryEvent.*;

public interface InventoryItemEntryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemEntryId getInventoryItemEntryId();

    void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId);

    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

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

    InventoryItemSourceInfo getSource();

    void setSource(InventoryItemSourceInfo source);

    java.sql.Timestamp getOccuredAt();

    void setOccuredAt(java.sql.Timestamp occuredAt);

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

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(InventoryItemEntryEvent.InventoryItemEntryStateCreated e);

    
}

