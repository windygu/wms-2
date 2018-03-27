package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.orderitemshipgrpinvreservation.OrderItemShipGrpInvReservationStateEvent.*;

public interface OrderItemShipGrpInvReservationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderItemShipGrpInvResId getOrderItemShipGrpInvResId();

    void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId);

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

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(OrderItemShipGrpInvReservationStateEvent.OrderItemShipGrpInvReservationStateCreated e);

    void when(OrderItemShipGrpInvReservationStateEvent.OrderItemShipGrpInvReservationStateMergePatched e);

    void when(OrderItemShipGrpInvReservationStateEvent.OrderItemShipGrpInvReservationStateDeleted e);
    
}

