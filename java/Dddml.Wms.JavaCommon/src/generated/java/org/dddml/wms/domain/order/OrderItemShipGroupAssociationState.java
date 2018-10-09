package org.dddml.wms.domain.order;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderItemShipGroupAssociationEvent.*;

public interface OrderItemShipGroupAssociationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getOrderItemSeqId();

    java.math.BigDecimal getQuantity();

    java.math.BigDecimal getCancelQuantity();

    Integer getNumberOfPackages();

    Integer getNumberOfContainers();

    Integer getNumberOfPakagesPerContainer();

    String getOrderItemShipGroupAssociationKey();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getOrderId();

    String getOrderShipGroupShipGroupSeqId();

    interface MutableOrderItemShipGroupAssociationState extends OrderItemShipGroupAssociationState {
        void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId);

        void setOrderItemSeqId(String orderItemSeqId);

        void setQuantity(java.math.BigDecimal quantity);

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        void setNumberOfPackages(Integer numberOfPackages);

        void setNumberOfContainers(Integer numberOfContainers);

        void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer);

        void setOrderItemShipGroupAssociationKey(String orderItemShipGroupAssociationKey);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setOrderId(String orderId);

        void setOrderShipGroupShipGroupSeqId(String orderShipGroupShipGroupSeqId);


        void mutate(Event e);

        void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e);

        void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched e);

        void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e);
    }

    interface SqlOrderItemShipGroupAssociationState extends MutableOrderItemShipGroupAssociationState {
        OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

