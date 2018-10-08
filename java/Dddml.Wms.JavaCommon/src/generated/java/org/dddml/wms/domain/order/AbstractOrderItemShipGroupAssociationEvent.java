package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderItemShipGroupAssociationEvent extends AbstractEvent implements OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent 
{
    private OrderItemShipGroupAssociationEventId orderItemShipGroupAssociationEventId;

    public OrderItemShipGroupAssociationEventId getOrderItemShipGroupAssociationEventId() {
        return this.orderItemShipGroupAssociationEventId;
    }

    public void setOrderItemShipGroupAssociationEventId(OrderItemShipGroupAssociationEventId eventId) {
        this.orderItemShipGroupAssociationEventId = eventId;
    }
    
    public String getOrderItemSeqId() {
        return getOrderItemShipGroupAssociationEventId().getOrderItemSeqId();
    }

    public void setOrderItemSeqId(String orderItemSeqId) {
        getOrderItemShipGroupAssociationEventId().setOrderItemSeqId(orderItemSeqId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderItemShipGroupAssociationEvent() {
    }

    protected AbstractOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEventId eventId) {
        this.orderItemShipGroupAssociationEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderItemShipGroupAssociationStateEvent extends AbstractOrderItemShipGroupAssociationEvent implements OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
        }

        private java.math.BigDecimal cancelQuantity;

        public java.math.BigDecimal getCancelQuantity()
        {
            return this.cancelQuantity;
        }

        public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
        {
            this.cancelQuantity = cancelQuantity;
        }

        private Integer numberOfPackages;

        public Integer getNumberOfPackages()
        {
            return this.numberOfPackages;
        }

        public void setNumberOfPackages(Integer numberOfPackages)
        {
            this.numberOfPackages = numberOfPackages;
        }

        private Integer numberOfContainers;

        public Integer getNumberOfContainers()
        {
            return this.numberOfContainers;
        }

        public void setNumberOfContainers(Integer numberOfContainers)
        {
            this.numberOfContainers = numberOfContainers;
        }

        private Integer numberOfPakagesPerContainer;

        public Integer getNumberOfPakagesPerContainer()
        {
            return this.numberOfPakagesPerContainer;
        }

        public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
        {
            this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
        }

        private String orderItemShipGroupAssociationKey;

        public String getOrderItemShipGroupAssociationKey()
        {
            return this.orderItemShipGroupAssociationKey;
        }

        public void setOrderItemShipGroupAssociationKey(String orderItemShipGroupAssociationKey)
        {
            this.orderItemShipGroupAssociationKey = orderItemShipGroupAssociationKey;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractOrderItemShipGroupAssociationStateEvent(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderItemShipGroupAssociationStateCreated extends AbstractOrderItemShipGroupAssociationStateEvent implements OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated
    {
        public AbstractOrderItemShipGroupAssociationStateCreated() {
            this(new OrderItemShipGroupAssociationEventId());
        }

        public AbstractOrderItemShipGroupAssociationStateCreated(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderItemShipGroupAssociationStateMergePatched extends AbstractOrderItemShipGroupAssociationStateEvent implements OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched
    {
        public AbstractOrderItemShipGroupAssociationStateMergePatched() {
            this(new OrderItemShipGroupAssociationEventId());
        }

        public AbstractOrderItemShipGroupAssociationStateMergePatched(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyCancelQuantityRemoved;

        public Boolean getIsPropertyCancelQuantityRemoved() {
            return this.isPropertyCancelQuantityRemoved;
        }

        public void setIsPropertyCancelQuantityRemoved(Boolean removed) {
            this.isPropertyCancelQuantityRemoved = removed;
        }

        private Boolean isPropertyNumberOfPackagesRemoved;

        public Boolean getIsPropertyNumberOfPackagesRemoved() {
            return this.isPropertyNumberOfPackagesRemoved;
        }

        public void setIsPropertyNumberOfPackagesRemoved(Boolean removed) {
            this.isPropertyNumberOfPackagesRemoved = removed;
        }

        private Boolean isPropertyNumberOfContainersRemoved;

        public Boolean getIsPropertyNumberOfContainersRemoved() {
            return this.isPropertyNumberOfContainersRemoved;
        }

        public void setIsPropertyNumberOfContainersRemoved(Boolean removed) {
            this.isPropertyNumberOfContainersRemoved = removed;
        }

        private Boolean isPropertyNumberOfPakagesPerContainerRemoved;

        public Boolean getIsPropertyNumberOfPakagesPerContainerRemoved() {
            return this.isPropertyNumberOfPakagesPerContainerRemoved;
        }

        public void setIsPropertyNumberOfPakagesPerContainerRemoved(Boolean removed) {
            this.isPropertyNumberOfPakagesPerContainerRemoved = removed;
        }

        private Boolean isPropertyOrderItemShipGroupAssociationKeyRemoved;

        public Boolean getIsPropertyOrderItemShipGroupAssociationKeyRemoved() {
            return this.isPropertyOrderItemShipGroupAssociationKeyRemoved;
        }

        public void setIsPropertyOrderItemShipGroupAssociationKeyRemoved(Boolean removed) {
            this.isPropertyOrderItemShipGroupAssociationKeyRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrderItemShipGroupAssociationStateRemoved extends AbstractOrderItemShipGroupAssociationStateEvent implements OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved
    {
        public AbstractOrderItemShipGroupAssociationStateRemoved() {
            this(new OrderItemShipGroupAssociationEventId());
        }

        public AbstractOrderItemShipGroupAssociationStateRemoved(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleOrderItemShipGroupAssociationStateCreated extends AbstractOrderItemShipGroupAssociationStateCreated
    {
        public SimpleOrderItemShipGroupAssociationStateCreated() {
        }

        public SimpleOrderItemShipGroupAssociationStateCreated(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderItemShipGroupAssociationStateMergePatched extends AbstractOrderItemShipGroupAssociationStateMergePatched
    {
        public SimpleOrderItemShipGroupAssociationStateMergePatched() {
        }

        public SimpleOrderItemShipGroupAssociationStateMergePatched(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderItemShipGroupAssociationStateRemoved extends AbstractOrderItemShipGroupAssociationStateRemoved
    {
        public SimpleOrderItemShipGroupAssociationStateRemoved() {
        }

        public SimpleOrderItemShipGroupAssociationStateRemoved(OrderItemShipGroupAssociationEventId eventId) {
            super(eventId);
        }
    }

}

