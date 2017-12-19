package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentTypeStateEvent extends Event
{
    ShipmentTypeStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getParentTypeId();

    void setParentTypeId(String parentTypeId);

    String getHasTable();

    void setHasTable(String hasTable);

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

    interface ShipmentTypeStateCreated extends ShipmentTypeStateEvent
    {
    
    }


    interface ShipmentTypeStateMergePatched extends ShipmentTypeStateEvent
    {
        Boolean getIsPropertyParentTypeIdRemoved();

        void setIsPropertyParentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyHasTableRemoved();

        void setIsPropertyHasTableRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

