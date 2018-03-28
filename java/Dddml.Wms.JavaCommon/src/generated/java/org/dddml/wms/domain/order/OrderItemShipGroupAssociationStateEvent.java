package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderItemShipGroupAssociationStateEvent extends Event
{
    OrderItemShipGroupAssociationEventId getOrderItemShipGroupAssociationEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.math.BigDecimal getCancelQuantity();

    void setCancelQuantity(java.math.BigDecimal cancelQuantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderItemShipGroupAssociationStateCreated extends OrderItemShipGroupAssociationStateEvent
    {
    
    }


    interface OrderItemShipGroupAssociationStateMergePatched extends OrderItemShipGroupAssociationStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCancelQuantityRemoved();

        void setIsPropertyCancelQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrderItemShipGroupAssociationStateRemoved extends OrderItemShipGroupAssociationStateEvent
    {
    }


}

