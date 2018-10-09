package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.orderitemshipgrpinvreservation.OrderItemShipGrpInvReservationEvent.*;

public interface OrderItemShipGrpInvReservationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderItemShipGrpInvResId getOrderItemShipGrpInvResId();

    String getReserveOrderEnumId();

    java.math.BigDecimal getQuantity();

    java.math.BigDecimal getQuantityNotAvailable();

    java.sql.Timestamp getReservedDatetime();

    java.sql.Timestamp getCreatedDatetime();

    java.sql.Timestamp getPromisedDatetime();

    java.sql.Timestamp getCurrentPromisedDate();

    String getPriority();

    Long getSequenceId();

    java.sql.Timestamp getOldPickStartDate();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableOrderItemShipGrpInvReservationState extends OrderItemShipGrpInvReservationState {
        void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId);

        void setReserveOrderEnumId(String reserveOrderEnumId);

        void setQuantity(java.math.BigDecimal quantity);

        void setQuantityNotAvailable(java.math.BigDecimal quantityNotAvailable);

        void setReservedDatetime(java.sql.Timestamp reservedDatetime);

        void setCreatedDatetime(java.sql.Timestamp createdDatetime);

        void setPromisedDatetime(java.sql.Timestamp promisedDatetime);

        void setCurrentPromisedDate(java.sql.Timestamp currentPromisedDate);

        void setPriority(String priority);

        void setSequenceId(Long sequenceId);

        void setOldPickStartDate(java.sql.Timestamp oldPickStartDate);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated e);

        void when(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched e);

        void when(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted e);
    }

    interface SqlOrderItemShipGrpInvReservationState extends MutableOrderItemShipGrpInvReservationState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

