package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryPRTriggeredEvent extends Event
{
    InventoryPRTriggeredEventId getInventoryPRTriggeredEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryPRTriggeredStateEvent extends InventoryPRTriggeredEvent {
        Boolean getIsProcessed();

        void setIsProcessed(Boolean isProcessed);

    }

    interface InventoryPRTriggeredStateCreated extends InventoryPRTriggeredStateEvent
    {
    
    }


    interface InventoryPRTriggeredStateMergePatched extends InventoryPRTriggeredStateEvent
    {
        Boolean getIsPropertyIsProcessedRemoved();

        void setIsPropertyIsProcessedRemoved(Boolean removed);


    }


}

