package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEventTypeStateEvent extends Event
{
    InventoryItemEventTypeStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getDescription();

    void setDescription(String description);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemEventTypeStateCreated extends InventoryItemEventTypeStateEvent
    {
    
    }


    interface InventoryItemEventTypeStateMergePatched extends InventoryItemEventTypeStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface InventoryItemEventTypeStateDeleted extends InventoryItemEventTypeStateEvent
    {
    }


}
