package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface WarehouseEvent extends Event {

    interface SqlWarehouseEvent extends WarehouseEvent {
        WarehouseEventId getWarehouseEventId();
    }

    String getWarehouseId();

    //void setWarehouseId(String warehouseId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface WarehouseStateEvent extends WarehouseEvent {
        String getWarehouseName();

        void setWarehouseName(String warehouseName);

        String getDescription();

        void setDescription(String description);

        Boolean getIsInTransit();

        void setIsInTransit(Boolean isInTransit);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface WarehouseStateCreated extends WarehouseStateEvent
    {
    
    }


    interface WarehouseStateMergePatched extends WarehouseStateEvent
    {
        Boolean getIsPropertyWarehouseNameRemoved();

        void setIsPropertyWarehouseNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyIsInTransitRemoved();

        void setIsPropertyIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface WarehouseStateDeleted extends WarehouseStateEvent
    {
    }


}

