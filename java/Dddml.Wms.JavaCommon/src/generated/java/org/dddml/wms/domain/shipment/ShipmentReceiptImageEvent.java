package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentReceiptImageEvent extends Event
{
    ShipmentReceiptImageEventId getShipmentReceiptImageEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentReceiptImageStateEvent extends ShipmentReceiptImageEvent {
        Long getVersion();

        void setVersion(Long version);

        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface ShipmentReceiptImageStateCreated extends ShipmentReceiptImageStateEvent
    {
    
    }


    interface ShipmentReceiptImageStateMergePatched extends ShipmentReceiptImageStateEvent
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface ShipmentReceiptImageStateRemoved extends ShipmentReceiptImageStateEvent
    {
    }


}

