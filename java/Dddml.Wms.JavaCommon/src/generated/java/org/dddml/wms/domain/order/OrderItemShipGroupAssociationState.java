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

    OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId();

    void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId);

    String getOrderItemSeqId();

    void setOrderItemSeqId(String orderItemSeqId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.math.BigDecimal getCancelQuantity();

    void setCancelQuantity(java.math.BigDecimal cancelQuantity);

    Integer getNumberOfPackages();

    void setNumberOfPackages(Integer numberOfPackages);

    Integer getNumberOfContainers();

    void setNumberOfContainers(Integer numberOfContainers);

    Integer getNumberOfPakagesPerContainer();

    void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer);

    String getOrderItemShipGroupAssociationKey();

    void setOrderItemShipGroupAssociationKey(String orderItemShipGroupAssociationKey);

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

    String getOrderId();

    void setOrderId(String orderId);

    String getOrderShipGroupShipGroupSeqId();

    void setOrderShipGroupShipGroupSeqId(String orderShipGroupShipGroupSeqId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e);

    void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched e);

    void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e);
    
}

