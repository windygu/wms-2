package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.Set;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryStateEvent.*;

public interface InventoryItemRequirementEntryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemRequirementEntryId getInventoryItemRequirementEntryId();

    void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId);

    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal quantity);

    InventoryPRTriggeredId getSourceEventId();

    void setSourceEventId(InventoryPRTriggeredId sourceEventId);

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

    InventoryItemId getInventoryItemRequirementId();

    void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated e);

    
}

