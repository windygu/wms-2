package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.ordershipment.OrderShipmentStateEvent.*;

public abstract class AbstractOrderShipmentState implements OrderShipmentState
{

    private OrderShipmentId orderShipmentId;

    public OrderShipmentId getOrderShipmentId()
    {
        return this.orderShipmentId;
    }

    public void setOrderShipmentId(OrderShipmentId orderShipmentId)
    {
        this.orderShipmentId = orderShipmentId;
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

    public AbstractOrderShipmentState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderShipmentId(((OrderShipmentStateEvent) events.get(0)).getStateEventId().getOrderShipmentId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractOrderShipmentState() {
        this(false);
    }

    public AbstractOrderShipmentState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderShipmentStateCreated) {
            when((OrderShipmentStateCreated) e);
        } else if (e instanceof OrderShipmentStateMergePatched) {
            when((OrderShipmentStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderShipmentStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrderShipmentStateMergePatched e)
    {
        throwOnWrongEvent(e);

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

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderShipmentStateEvent stateEvent)
    {
        OrderShipmentId stateEntityId = this.getOrderShipmentId(); // Aggregate Id
        OrderShipmentId eventEntityId = stateEvent.getStateEventId().getOrderShipmentId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderShipmentState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderShipmentState extends AbstractOrderShipmentState
    {

        public SimpleOrderShipmentState() {
        }

        public SimpleOrderShipmentState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderShipmentState(List<Event> events) {
            super(events);
        }

    }


}

