package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderItemShipGrpInvReservationStateEvent extends Event
{
    OrderItemShipGrpInvReservationEventId getOrderItemShipGrpInvReservationEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getReserveOrderEnumId();

    void setReserveOrderEnumId(String reserveOrderEnumId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.math.BigDecimal getQuantityNotAvailable();

    void setQuantityNotAvailable(java.math.BigDecimal quantityNotAvailable);

    java.sql.Timestamp getReservedDatetime();

    void setReservedDatetime(java.sql.Timestamp reservedDatetime);

    java.sql.Timestamp getCreatedDatetime();

    void setCreatedDatetime(java.sql.Timestamp createdDatetime);

    java.sql.Timestamp getPromisedDatetime();

    void setPromisedDatetime(java.sql.Timestamp promisedDatetime);

    java.sql.Timestamp getCurrentPromisedDate();

    void setCurrentPromisedDate(java.sql.Timestamp currentPromisedDate);

    String getPriority();

    void setPriority(String priority);

    Long getSequenceId();

    void setSequenceId(Long sequenceId);

    java.sql.Timestamp getOldPickStartDate();

    void setOldPickStartDate(java.sql.Timestamp oldPickStartDate);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderItemShipGrpInvReservationStateCreated extends OrderItemShipGrpInvReservationStateEvent
    {
    
    }


    interface OrderItemShipGrpInvReservationStateMergePatched extends OrderItemShipGrpInvReservationStateEvent
    {
        Boolean getIsPropertyReserveOrderEnumIdRemoved();

        void setIsPropertyReserveOrderEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyQuantityNotAvailableRemoved();

        void setIsPropertyQuantityNotAvailableRemoved(Boolean removed);

        Boolean getIsPropertyReservedDatetimeRemoved();

        void setIsPropertyReservedDatetimeRemoved(Boolean removed);

        Boolean getIsPropertyCreatedDatetimeRemoved();

        void setIsPropertyCreatedDatetimeRemoved(Boolean removed);

        Boolean getIsPropertyPromisedDatetimeRemoved();

        void setIsPropertyPromisedDatetimeRemoved(Boolean removed);

        Boolean getIsPropertyCurrentPromisedDateRemoved();

        void setIsPropertyCurrentPromisedDateRemoved(Boolean removed);

        Boolean getIsPropertyPriorityRemoved();

        void setIsPropertyPriorityRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyOldPickStartDateRemoved();

        void setIsPropertyOldPickStartDateRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrderItemShipGrpInvReservationStateDeleted extends OrderItemShipGrpInvReservationStateEvent
    {
    }


}

