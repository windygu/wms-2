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

    InventoryItemSourceVO getSource();

    void setSource(InventoryItemSourceVO source);

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

    BigDecimal getInventoryItemQuantityOnHand();

    void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand);

    BigDecimal getInventoryItemQuantityInTransit();

    void setInventoryItemQuantityInTransit(BigDecimal inventoryItemQuantityInTransit);

    BigDecimal getInventoryItemQuantityReserved();

    void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved);

    BigDecimal getInventoryItemQuantityOccupied();

    void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied);

    BigDecimal getInventoryItemQuantityVirtual();

    void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual);

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

