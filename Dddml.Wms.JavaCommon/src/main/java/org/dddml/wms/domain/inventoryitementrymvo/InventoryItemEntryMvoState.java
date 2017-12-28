package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitementrymvo.InventoryItemEntryMvoStateEvent.*;

public interface InventoryItemEntryMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemEntryId getInventoryItemEntryId();

    void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId);

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

    BigDecimal getInventoryItemOnHandQuantity();

    void setInventoryItemOnHandQuantity(BigDecimal inventoryItemOnHandQuantity);

    BigDecimal getInventoryItemInTransitQuantity();

    void setInventoryItemInTransitQuantity(BigDecimal inventoryItemInTransitQuantity);

    BigDecimal getInventoryItemReservedQuantity();

    void setInventoryItemReservedQuantity(BigDecimal inventoryItemReservedQuantity);

    BigDecimal getInventoryItemOccupiedQuantity();

    void setInventoryItemOccupiedQuantity(BigDecimal inventoryItemOccupiedQuantity);

    BigDecimal getInventoryItemVirtualQuantity();

    void setInventoryItemVirtualQuantity(BigDecimal inventoryItemVirtualQuantity);

    Long getInventoryItemVersion();

    void setInventoryItemVersion(Long inventoryItemVersion);

    String getInventoryItemCreatedBy();

    void setInventoryItemCreatedBy(String inventoryItemCreatedBy);

    Date getInventoryItemCreatedAt();

    void setInventoryItemCreatedAt(Date inventoryItemCreatedAt);

    String getInventoryItemUpdatedBy();

    void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy);

    Date getInventoryItemUpdatedAt();

    void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated e);

    void when(InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched e);

    
}

