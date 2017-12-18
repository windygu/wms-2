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

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e);

    
}

