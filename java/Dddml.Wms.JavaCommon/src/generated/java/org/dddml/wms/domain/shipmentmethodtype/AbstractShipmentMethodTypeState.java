package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentmethodtype.ShipmentMethodTypeEvent.*;

public abstract class AbstractShipmentMethodTypeState implements ShipmentMethodTypeState.SqlShipmentMethodTypeState
{

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private Long sequenceNum;

    public Long getSequenceNum()
    {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum)
    {
        this.sequenceNum = sequenceNum;
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

    public AbstractShipmentMethodTypeState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setShipmentMethodTypeId(((ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent) events.get(0)).getShipmentMethodTypeEventId().getShipmentMethodTypeId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractShipmentMethodTypeState() {
        this(false);
    }

    public AbstractShipmentMethodTypeState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getShipmentMethodTypeId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getShipmentMethodTypeId(), ((ShipmentMethodTypeState)obj).getShipmentMethodTypeId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentMethodTypeStateCreated) {
            when((ShipmentMethodTypeStateCreated) e);
        } else if (e instanceof ShipmentMethodTypeStateMergePatched) {
            when((ShipmentMethodTypeStateMergePatched) e);
        } else if (e instanceof ShipmentMethodTypeStateDeleted) {
            when((ShipmentMethodTypeStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentMethodTypeStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDescription(e.getDescription());
        this.setSequenceNum(e.getSequenceNum());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(ShipmentMethodTypeState s) {
        if (s == this) {
            return;
        }
        this.setDescription(s.getDescription());
        this.setSequenceNum(s.getSequenceNum());
        this.setActive(s.getActive());
    }

    public void when(ShipmentMethodTypeStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getSequenceNum() == null)
        {
            if (e.getIsPropertySequenceNumRemoved() != null && e.getIsPropertySequenceNumRemoved())
            {
                this.setSequenceNum(null);
            }
        }
        else
        {
            this.setSequenceNum(e.getSequenceNum());
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

    public void when(ShipmentMethodTypeStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentMethodTypeEvent event)
    {
        String stateEntityId = this.getShipmentMethodTypeId(); // Aggregate Id
        String eventEntityId = ((ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent)event).getShipmentMethodTypeEventId().getShipmentMethodTypeId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent)event).getShipmentMethodTypeEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getShipmentMethodTypeEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentMethodTypeState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentMethodTypeState extends AbstractShipmentMethodTypeState
    {

        public SimpleShipmentMethodTypeState() {
        }

        public SimpleShipmentMethodTypeState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleShipmentMethodTypeState(List<Event> events) {
            super(events);
        }

    }


}

