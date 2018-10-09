package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.warehouse.WarehouseEvent.*;

public abstract class AbstractWarehouseState implements WarehouseState.SqlWarehouseState
{

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String warehouseName;

    public String getWarehouseName()
    {
        return this.warehouseName;
    }

    public void setWarehouseName(String warehouseName)
    {
        this.warehouseName = warehouseName;
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

    private Boolean isInTransit;

    public Boolean getIsInTransit()
    {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit)
    {
        this.isInTransit = isInTransit;
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

    public AbstractWarehouseState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setWarehouseId(((WarehouseEvent.SqlWarehouseEvent) events.get(0)).getWarehouseEventId().getWarehouseId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractWarehouseState() {
        this(false);
    }

    public AbstractWarehouseState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof WarehouseStateCreated) {
            when((WarehouseStateCreated) e);
        } else if (e instanceof WarehouseStateMergePatched) {
            when((WarehouseStateMergePatched) e);
        } else if (e instanceof WarehouseStateDeleted) {
            when((WarehouseStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(WarehouseStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setWarehouseName(e.getWarehouseName());
        this.setDescription(e.getDescription());
        this.setIsInTransit(e.getIsInTransit());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(WarehouseStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getWarehouseName() == null)
        {
            if (e.getIsPropertyWarehouseNameRemoved() != null && e.getIsPropertyWarehouseNameRemoved())
            {
                this.setWarehouseName(null);
            }
        }
        else
        {
            this.setWarehouseName(e.getWarehouseName());
        }
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
        if (e.getIsInTransit() == null)
        {
            if (e.getIsPropertyIsInTransitRemoved() != null && e.getIsPropertyIsInTransitRemoved())
            {
                this.setIsInTransit(null);
            }
        }
        else
        {
            this.setIsInTransit(e.getIsInTransit());
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

    public void when(WarehouseStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(WarehouseEvent event)
    {
        String stateEntityId = this.getWarehouseId(); // Aggregate Id
        String eventEntityId = ((WarehouseEvent.SqlWarehouseEvent)event).getWarehouseEventId().getWarehouseId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((WarehouseEvent.SqlWarehouseEvent)event).getWarehouseEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getWarehouseEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(WarehouseState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleWarehouseState extends AbstractWarehouseState
    {

        public SimpleWarehouseState() {
        }

        public SimpleWarehouseState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleWarehouseState(List<Event> events) {
            super(events);
        }

    }


}

