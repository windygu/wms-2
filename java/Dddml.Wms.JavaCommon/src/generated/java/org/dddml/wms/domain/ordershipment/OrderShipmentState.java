package org.dddml.wms.domain.ordershipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.ordershipment.OrderShipmentEvent.*;

public interface OrderShipmentState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderShipmentId getOrderShipmentId();

    java.math.BigDecimal getQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    interface MutableOrderShipmentState extends OrderShipmentState {
        void setOrderShipmentId(OrderShipmentId orderShipmentId);

        void setQuantity(java.math.BigDecimal quantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(OrderShipmentEvent.OrderShipmentStateCreated e);

        void when(OrderShipmentEvent.OrderShipmentStateMergePatched e);

    }

    interface SqlOrderShipmentState extends MutableOrderShipmentState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

