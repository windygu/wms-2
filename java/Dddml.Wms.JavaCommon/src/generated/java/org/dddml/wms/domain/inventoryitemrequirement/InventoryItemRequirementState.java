package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEvent.*;

public interface InventoryItemRequirementState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getInventoryItemRequirementId();

    void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal quantity);

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

    String getCommandId();

    void setCommandId(String commandId);

    EntityStateCollection<Long, InventoryItemRequirementEntryState> getEntries();


    void mutate(Event e);

    void when(InventoryItemRequirementEvent.InventoryItemRequirementStateCreated e);

    void when(InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched e);

    
}

