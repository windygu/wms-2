package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentImageEvent extends Event {

    interface SqlShipmentImageEvent extends ShipmentImageEvent {
        ShipmentImageEventId getShipmentImageEventId();
    }

    String getSequenceId();

    //void setSequenceId(String sequenceId);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentImageStateEvent extends ShipmentImageEvent {
        Long getVersion();

        void setVersion(Long version);

        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface ShipmentImageStateCreated extends ShipmentImageStateEvent
    {
    
    }


    interface ShipmentImageStateMergePatched extends ShipmentImageStateEvent
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface ShipmentImageStateRemoved extends ShipmentImageStateEvent
    {
    }


}

