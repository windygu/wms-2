package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderItemShipGrpInvReservationEvent extends AbstractEvent implements OrderItemShipGrpInvReservationEvent.SqlOrderItemShipGrpInvReservationEvent 
{
    private OrderItemShipGrpInvReservationEventId orderItemShipGrpInvReservationEventId;

    public OrderItemShipGrpInvReservationEventId getOrderItemShipGrpInvReservationEventId() {
        return this.orderItemShipGrpInvReservationEventId;
    }

    public void setOrderItemShipGrpInvReservationEventId(OrderItemShipGrpInvReservationEventId eventId) {
        this.orderItemShipGrpInvReservationEventId = eventId;
    }
    
    public OrderItemShipGrpInvResId getOrderItemShipGrpInvResId() {
        return getOrderItemShipGrpInvReservationEventId().getOrderItemShipGrpInvResId();
    }

    public void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId) {
        getOrderItemShipGrpInvReservationEventId().setOrderItemShipGrpInvResId(orderItemShipGrpInvResId);
    }

    public Long getVersion() {
        return getOrderItemShipGrpInvReservationEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getOrderItemShipGrpInvReservationEventId().setVersion(version);
    //}

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

    protected AbstractOrderItemShipGrpInvReservationEvent() {
    }

    protected AbstractOrderItemShipGrpInvReservationEvent(OrderItemShipGrpInvReservationEventId eventId) {
        this.orderItemShipGrpInvReservationEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderItemShipGrpInvReservationStateEvent extends AbstractOrderItemShipGrpInvReservationEvent implements OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateEvent {
        private String reserveOrderEnumId;

        public String getReserveOrderEnumId()
        {
            return this.reserveOrderEnumId;
        }

        public void setReserveOrderEnumId(String reserveOrderEnumId)
        {
            this.reserveOrderEnumId = reserveOrderEnumId;
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

        private java.math.BigDecimal quantityNotAvailable;

        public java.math.BigDecimal getQuantityNotAvailable()
        {
            return this.quantityNotAvailable;
        }

        public void setQuantityNotAvailable(java.math.BigDecimal quantityNotAvailable)
        {
            this.quantityNotAvailable = quantityNotAvailable;
        }

        private java.sql.Timestamp reservedDatetime;

        public java.sql.Timestamp getReservedDatetime()
        {
            return this.reservedDatetime;
        }

        public void setReservedDatetime(java.sql.Timestamp reservedDatetime)
        {
            this.reservedDatetime = reservedDatetime;
        }

        private java.sql.Timestamp createdDatetime;

        public java.sql.Timestamp getCreatedDatetime()
        {
            return this.createdDatetime;
        }

        public void setCreatedDatetime(java.sql.Timestamp createdDatetime)
        {
            this.createdDatetime = createdDatetime;
        }

        private java.sql.Timestamp promisedDatetime;

        public java.sql.Timestamp getPromisedDatetime()
        {
            return this.promisedDatetime;
        }

        public void setPromisedDatetime(java.sql.Timestamp promisedDatetime)
        {
            this.promisedDatetime = promisedDatetime;
        }

        private java.sql.Timestamp currentPromisedDate;

        public java.sql.Timestamp getCurrentPromisedDate()
        {
            return this.currentPromisedDate;
        }

        public void setCurrentPromisedDate(java.sql.Timestamp currentPromisedDate)
        {
            this.currentPromisedDate = currentPromisedDate;
        }

        private String priority;

        public String getPriority()
        {
            return this.priority;
        }

        public void setPriority(String priority)
        {
            this.priority = priority;
        }

        private Long sequenceId;

        public Long getSequenceId()
        {
            return this.sequenceId;
        }

        public void setSequenceId(Long sequenceId)
        {
            this.sequenceId = sequenceId;
        }

        private java.sql.Timestamp oldPickStartDate;

        public java.sql.Timestamp getOldPickStartDate()
        {
            return this.oldPickStartDate;
        }

        public void setOldPickStartDate(java.sql.Timestamp oldPickStartDate)
        {
            this.oldPickStartDate = oldPickStartDate;
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

        protected AbstractOrderItemShipGrpInvReservationStateEvent(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderItemShipGrpInvReservationStateCreated extends AbstractOrderItemShipGrpInvReservationStateEvent implements OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated
    {
        public AbstractOrderItemShipGrpInvReservationStateCreated() {
            this(new OrderItemShipGrpInvReservationEventId());
        }

        public AbstractOrderItemShipGrpInvReservationStateCreated(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderItemShipGrpInvReservationStateMergePatched extends AbstractOrderItemShipGrpInvReservationStateEvent implements OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched
    {
        public AbstractOrderItemShipGrpInvReservationStateMergePatched() {
            this(new OrderItemShipGrpInvReservationEventId());
        }

        public AbstractOrderItemShipGrpInvReservationStateMergePatched(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyReserveOrderEnumIdRemoved;

        public Boolean getIsPropertyReserveOrderEnumIdRemoved() {
            return this.isPropertyReserveOrderEnumIdRemoved;
        }

        public void setIsPropertyReserveOrderEnumIdRemoved(Boolean removed) {
            this.isPropertyReserveOrderEnumIdRemoved = removed;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyQuantityNotAvailableRemoved;

        public Boolean getIsPropertyQuantityNotAvailableRemoved() {
            return this.isPropertyQuantityNotAvailableRemoved;
        }

        public void setIsPropertyQuantityNotAvailableRemoved(Boolean removed) {
            this.isPropertyQuantityNotAvailableRemoved = removed;
        }

        private Boolean isPropertyReservedDatetimeRemoved;

        public Boolean getIsPropertyReservedDatetimeRemoved() {
            return this.isPropertyReservedDatetimeRemoved;
        }

        public void setIsPropertyReservedDatetimeRemoved(Boolean removed) {
            this.isPropertyReservedDatetimeRemoved = removed;
        }

        private Boolean isPropertyCreatedDatetimeRemoved;

        public Boolean getIsPropertyCreatedDatetimeRemoved() {
            return this.isPropertyCreatedDatetimeRemoved;
        }

        public void setIsPropertyCreatedDatetimeRemoved(Boolean removed) {
            this.isPropertyCreatedDatetimeRemoved = removed;
        }

        private Boolean isPropertyPromisedDatetimeRemoved;

        public Boolean getIsPropertyPromisedDatetimeRemoved() {
            return this.isPropertyPromisedDatetimeRemoved;
        }

        public void setIsPropertyPromisedDatetimeRemoved(Boolean removed) {
            this.isPropertyPromisedDatetimeRemoved = removed;
        }

        private Boolean isPropertyCurrentPromisedDateRemoved;

        public Boolean getIsPropertyCurrentPromisedDateRemoved() {
            return this.isPropertyCurrentPromisedDateRemoved;
        }

        public void setIsPropertyCurrentPromisedDateRemoved(Boolean removed) {
            this.isPropertyCurrentPromisedDateRemoved = removed;
        }

        private Boolean isPropertyPriorityRemoved;

        public Boolean getIsPropertyPriorityRemoved() {
            return this.isPropertyPriorityRemoved;
        }

        public void setIsPropertyPriorityRemoved(Boolean removed) {
            this.isPropertyPriorityRemoved = removed;
        }

        private Boolean isPropertySequenceIdRemoved;

        public Boolean getIsPropertySequenceIdRemoved() {
            return this.isPropertySequenceIdRemoved;
        }

        public void setIsPropertySequenceIdRemoved(Boolean removed) {
            this.isPropertySequenceIdRemoved = removed;
        }

        private Boolean isPropertyOldPickStartDateRemoved;

        public Boolean getIsPropertyOldPickStartDateRemoved() {
            return this.isPropertyOldPickStartDateRemoved;
        }

        public void setIsPropertyOldPickStartDateRemoved(Boolean removed) {
            this.isPropertyOldPickStartDateRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrderItemShipGrpInvReservationStateDeleted extends AbstractOrderItemShipGrpInvReservationStateEvent implements OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted
    {
        public AbstractOrderItemShipGrpInvReservationStateDeleted() {
            this(new OrderItemShipGrpInvReservationEventId());
        }

        public AbstractOrderItemShipGrpInvReservationStateDeleted(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrderItemShipGrpInvReservationStateCreated extends AbstractOrderItemShipGrpInvReservationStateCreated
    {
        public SimpleOrderItemShipGrpInvReservationStateCreated() {
        }

        public SimpleOrderItemShipGrpInvReservationStateCreated(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderItemShipGrpInvReservationStateMergePatched extends AbstractOrderItemShipGrpInvReservationStateMergePatched
    {
        public SimpleOrderItemShipGrpInvReservationStateMergePatched() {
        }

        public SimpleOrderItemShipGrpInvReservationStateMergePatched(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderItemShipGrpInvReservationStateDeleted extends AbstractOrderItemShipGrpInvReservationStateDeleted
    {
        public SimpleOrderItemShipGrpInvReservationStateDeleted() {
        }

        public SimpleOrderItemShipGrpInvReservationStateDeleted(OrderItemShipGrpInvReservationEventId eventId) {
            super(eventId);
        }
    }

}

