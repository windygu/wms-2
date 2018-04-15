package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredEvent.*;

public interface InventoryPRTriggeredState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryPRTriggeredId getInventoryPRTriggeredId();

    void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId);

    Boolean getIsProcessed();

    void setIsProcessed(Boolean isProcessed);

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


    void mutate(Event e);

    void when(InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated e);

    void when(InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched e);

    
}

