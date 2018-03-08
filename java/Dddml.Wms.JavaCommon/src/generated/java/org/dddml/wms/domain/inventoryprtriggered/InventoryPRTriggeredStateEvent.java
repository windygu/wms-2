package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryPRTriggeredStateEvent extends Event
{
    InventoryPRTriggeredEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Boolean getIsProcessed();

    void setIsProcessed(Boolean isProcessed);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryPRTriggeredStateCreated extends InventoryPRTriggeredStateEvent
    {
    
    }


    interface InventoryPRTriggeredStateMergePatched extends InventoryPRTriggeredStateEvent
    {
        Boolean getIsPropertyIsProcessedRemoved();

        void setIsPropertyIsProcessedRemoved(Boolean removed);


    }


}

