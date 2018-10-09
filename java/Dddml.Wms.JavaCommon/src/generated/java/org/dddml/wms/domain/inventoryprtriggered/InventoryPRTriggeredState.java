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

    Boolean getIsProcessed();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    String getCommandId();

    interface MutableInventoryPRTriggeredState extends InventoryPRTriggeredState {
        void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId);

        void setIsProcessed(Boolean isProcessed);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated e);

        void when(InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched e);

    }

    interface SqlInventoryPRTriggeredState extends MutableInventoryPRTriggeredState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

