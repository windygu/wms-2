package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class OrderItemShipGroupAssociationStateEventDto extends AbstractStateEvent
{

    private OrderItemShipGroupAssociationEventId orderItemShipGroupAssociationEventId;

    OrderItemShipGroupAssociationEventId getStateEventId() {
        if (orderItemShipGroupAssociationEventId == null) { orderItemShipGroupAssociationEventId = new OrderItemShipGroupAssociationEventId(); }
        return orderItemShipGroupAssociationEventId;
    }

    void setOrderItemShipGroupAssociationEventId(OrderItemShipGroupAssociationEventId eventId) {
        this.orderItemShipGroupAssociationEventId = eventId;
    }

    public String getOrderItemSeqId() {
        return getStateEventId().getOrderItemSeqId();
    }

    public void setOrderItemSeqId(String orderItemSeqId) {
        getStateEventId().setOrderItemSeqId(orderItemSeqId);
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
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderItemShipGroupAssociationStateMergePatchedDto extends OrderItemShipGroupAssociationStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderItemShipGroupAssociationStateRemovedDto extends OrderItemShipGroupAssociationStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

