package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class OrderItemShipGroupAssociationStateEventDto extends AbstractEvent
{

    private OrderItemShipGroupAssociationEventId orderItemShipGroupAssociationEventId;

    OrderItemShipGroupAssociationEventId getOrderItemShipGroupAssociationEventId() {
        if (orderItemShipGroupAssociationEventId == null) { orderItemShipGroupAssociationEventId = new OrderItemShipGroupAssociationEventId(); }
        return orderItemShipGroupAssociationEventId;
    }

    void setOrderItemShipGroupAssociationEventId(OrderItemShipGroupAssociationEventId eventId) {
        this.orderItemShipGroupAssociationEventId = eventId;
    }

    public String getOrderItemSeqId() {
        return getOrderItemShipGroupAssociationEventId().getOrderItemSeqId();
    }

    public void setOrderItemSeqId(String orderItemSeqId) {
        getOrderItemShipGroupAssociationEventId().setOrderItemSeqId(orderItemSeqId);
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity() {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    private Integer numberOfPackages;

    public Integer getNumberOfPackages() {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    private Integer numberOfContainers;

    public Integer getNumberOfContainers() {
        return this.numberOfContainers;
    }

    public void setNumberOfContainers(Integer numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    private Integer numberOfPakagesPerContainer;

    public Integer getNumberOfPakagesPerContainer() {
        return this.numberOfPakagesPerContainer;
    }

    public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer) {
        this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
    }

    private String orderItemShipGroupAssociationKey;

    public String getOrderItemShipGroupAssociationKey() {
        return this.orderItemShipGroupAssociationKey;
    }

    public void setOrderItemShipGroupAssociationKey(String orderItemShipGroupAssociationKey) {
        this.orderItemShipGroupAssociationKey = orderItemShipGroupAssociationKey;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
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


	public static class OrderItemShipGroupAssociationStateCreatedDto extends OrderItemShipGroupAssociationStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderItemShipGroupAssociationStateMergePatchedDto extends OrderItemShipGroupAssociationStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderItemShipGroupAssociationStateRemovedDto extends OrderItemShipGroupAssociationStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

