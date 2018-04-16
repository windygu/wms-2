package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderitemshipgrpinvreservation.OrderItemShipGrpInvReservationEvent.*;

public abstract class AbstractOrderItemShipGrpInvReservationState implements OrderItemShipGrpInvReservationState
{

    private OrderItemShipGrpInvResId orderItemShipGrpInvResId;

    public OrderItemShipGrpInvResId getOrderItemShipGrpInvResId()
    {
        return this.orderItemShipGrpInvResId;
    }

    public void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId)
    {
        this.orderItemShipGrpInvResId = orderItemShipGrpInvResId;
    }

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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractOrderItemShipGrpInvReservationState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderItemShipGrpInvResId(((OrderItemShipGrpInvReservationEvent) events.get(0)).getOrderItemShipGrpInvReservationEventId().getOrderItemShipGrpInvResId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractOrderItemShipGrpInvReservationState() {
        this(false);
    }

    public AbstractOrderItemShipGrpInvReservationState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderItemShipGrpInvReservationStateCreated) {
            when((OrderItemShipGrpInvReservationStateCreated) e);
        } else if (e instanceof OrderItemShipGrpInvReservationStateMergePatched) {
            when((OrderItemShipGrpInvReservationStateMergePatched) e);
        } else if (e instanceof OrderItemShipGrpInvReservationStateDeleted) {
            when((OrderItemShipGrpInvReservationStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderItemShipGrpInvReservationStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setReserveOrderEnumId(e.getReserveOrderEnumId());
        this.setQuantity(e.getQuantity());
        this.setQuantityNotAvailable(e.getQuantityNotAvailable());
        this.setReservedDatetime(e.getReservedDatetime());
        this.setCreatedDatetime(e.getCreatedDatetime());
        this.setPromisedDatetime(e.getPromisedDatetime());
        this.setCurrentPromisedDate(e.getCurrentPromisedDate());
        this.setPriority(e.getPriority());
        this.setSequenceId(e.getSequenceId());
        this.setOldPickStartDate(e.getOldPickStartDate());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrderItemShipGrpInvReservationStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getReserveOrderEnumId() == null)
        {
            if (e.getIsPropertyReserveOrderEnumIdRemoved() != null && e.getIsPropertyReserveOrderEnumIdRemoved())
            {
                this.setReserveOrderEnumId(null);
            }
        }
        else
        {
            this.setReserveOrderEnumId(e.getReserveOrderEnumId());
        }
        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
        }
        if (e.getQuantityNotAvailable() == null)
        {
            if (e.getIsPropertyQuantityNotAvailableRemoved() != null && e.getIsPropertyQuantityNotAvailableRemoved())
            {
                this.setQuantityNotAvailable(null);
            }
        }
        else
        {
            this.setQuantityNotAvailable(e.getQuantityNotAvailable());
        }
        if (e.getReservedDatetime() == null)
        {
            if (e.getIsPropertyReservedDatetimeRemoved() != null && e.getIsPropertyReservedDatetimeRemoved())
            {
                this.setReservedDatetime(null);
            }
        }
        else
        {
            this.setReservedDatetime(e.getReservedDatetime());
        }
        if (e.getCreatedDatetime() == null)
        {
            if (e.getIsPropertyCreatedDatetimeRemoved() != null && e.getIsPropertyCreatedDatetimeRemoved())
            {
                this.setCreatedDatetime(null);
            }
        }
        else
        {
            this.setCreatedDatetime(e.getCreatedDatetime());
        }
        if (e.getPromisedDatetime() == null)
        {
            if (e.getIsPropertyPromisedDatetimeRemoved() != null && e.getIsPropertyPromisedDatetimeRemoved())
            {
                this.setPromisedDatetime(null);
            }
        }
        else
        {
            this.setPromisedDatetime(e.getPromisedDatetime());
        }
        if (e.getCurrentPromisedDate() == null)
        {
            if (e.getIsPropertyCurrentPromisedDateRemoved() != null && e.getIsPropertyCurrentPromisedDateRemoved())
            {
                this.setCurrentPromisedDate(null);
            }
        }
        else
        {
            this.setCurrentPromisedDate(e.getCurrentPromisedDate());
        }
        if (e.getPriority() == null)
        {
            if (e.getIsPropertyPriorityRemoved() != null && e.getIsPropertyPriorityRemoved())
            {
                this.setPriority(null);
            }
        }
        else
        {
            this.setPriority(e.getPriority());
        }
        if (e.getSequenceId() == null)
        {
            if (e.getIsPropertySequenceIdRemoved() != null && e.getIsPropertySequenceIdRemoved())
            {
                this.setSequenceId(null);
            }
        }
        else
        {
            this.setSequenceId(e.getSequenceId());
        }
        if (e.getOldPickStartDate() == null)
        {
            if (e.getIsPropertyOldPickStartDateRemoved() != null && e.getIsPropertyOldPickStartDateRemoved())
            {
                this.setOldPickStartDate(null);
            }
        }
        else
        {
            this.setOldPickStartDate(e.getOldPickStartDate());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(OrderItemShipGrpInvReservationStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderItemShipGrpInvReservationEvent event)
    {
        OrderItemShipGrpInvResId stateEntityId = this.getOrderItemShipGrpInvResId(); // Aggregate Id
        OrderItemShipGrpInvResId eventEntityId = event.getOrderItemShipGrpInvReservationEventId().getOrderItemShipGrpInvResId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = event.getOrderItemShipGrpInvReservationEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getOrderItemShipGrpInvReservationEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderItemShipGrpInvReservationState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderItemShipGrpInvReservationState extends AbstractOrderItemShipGrpInvReservationState
    {

        public SimpleOrderItemShipGrpInvReservationState() {
        }

        public SimpleOrderItemShipGrpInvReservationState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderItemShipGrpInvReservationState(List<Event> events) {
            super(events);
        }

    }


}

