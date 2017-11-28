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

    BigDecimal getInventoryItemQuantityOnHand();

    void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand);

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

