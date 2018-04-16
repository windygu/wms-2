package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentMethodTypeEvent extends Event
{
    ShipmentMethodTypeEventId getShipmentMethodTypeEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentMethodTypeStateEvent extends ShipmentMethodTypeEvent {
        String getDescription();

        void setDescription(String description);

        Long getSequenceNum();

        void setSequenceNum(Long sequenceNum);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface ShipmentMethodTypeStateCreated extends ShipmentMethodTypeStateEvent
    {
    
    }


    interface ShipmentMethodTypeStateMergePatched extends ShipmentMethodTypeStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceNumRemoved();

        void setIsPropertySequenceNumRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface ShipmentMethodTypeStateDeleted extends ShipmentMethodTypeStateEvent
    {
    }


}

