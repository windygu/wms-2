package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderShipmentEvent extends Event {

    interface SqlOrderShipmentEvent extends OrderShipmentEvent {
        OrderShipmentEventId getOrderShipmentEventId();
    }

    OrderShipmentId getOrderShipmentId();

    //void setOrderShipmentId(OrderShipmentId orderShipmentId);

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

    interface OrderShipmentStateEvent extends OrderShipmentEvent {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface OrderShipmentStateCreated extends OrderShipmentStateEvent
    {
    
    }


    interface OrderShipmentStateMergePatched extends OrderShipmentStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

