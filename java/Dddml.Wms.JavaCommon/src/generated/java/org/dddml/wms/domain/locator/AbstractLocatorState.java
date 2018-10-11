package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.locator.LocatorEvent.*;

public abstract class AbstractLocatorState implements LocatorState.SqlLocatorState
{

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String parentLocatorId;

    public String getParentLocatorId()
    {
        return this.parentLocatorId;
    }

    public void setParentLocatorId(String parentLocatorId)
    {
        this.parentLocatorId = parentLocatorId;
    }

    private String locatorType;

    public String getLocatorType()
    {
        return this.locatorType;
    }

    public void setLocatorType(String locatorType)
    {
        this.locatorType = locatorType;
    }

    private String priorityNumber;

    public String getPriorityNumber()
    {
        return this.priorityNumber;
    }

    public void setPriorityNumber(String priorityNumber)
    {
        this.priorityNumber = priorityNumber;
    }

    private Boolean isDefault;

    public Boolean getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(Boolean isDefault)
    {
        this.isDefault = isDefault;
    }

    private String x;

    public String getX()
    {
        return this.x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    private String y;

    public String getY()
    {
        return this.y;
    }

    public void setY(String y)
    {
        this.y = y;
    }

    private String z;

    public String getZ()
    {
        return this.z;
    }

    public void setZ(String z)
    {
        this.z = z;
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

    private String locatorTypeId;

    public String getLocatorTypeId()
    {
        return this.locatorTypeId;
    }

    public void setLocatorTypeId(String locatorTypeId)
    {
        this.locatorTypeId = locatorTypeId;
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

    public AbstractLocatorState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setLocatorId(((LocatorEvent.SqlLocatorEvent) events.get(0)).getLocatorEventId().getLocatorId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractLocatorState() {
        this(false);
    }

    public AbstractLocatorState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getLocatorId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getLocatorId(), ((LocatorState)obj).getLocatorId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof LocatorStateCreated) {
            when((LocatorStateCreated) e);
        } else if (e instanceof LocatorStateMergePatched) {
            when((LocatorStateMergePatched) e);
        } else if (e instanceof LocatorStateDeleted) {
            when((LocatorStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
        if (!(getLocatorId().startsWith(getWarehouseId()))) {
            throw DomainError.named("constraintViolated", "Violated validation logic: %1$s", "getLocatorId().startsWith(getWarehouseId())");
        }
    }

    public void when(LocatorStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setWarehouseId(e.getWarehouseId());
        this.setParentLocatorId(e.getParentLocatorId());
        this.setLocatorType(e.getLocatorType());
        this.setPriorityNumber(e.getPriorityNumber());
        this.setIsDefault(e.getIsDefault());
        this.setX(e.getX());
        this.setY(e.getY());
        this.setZ(e.getZ());
        this.setDescription(e.getDescription());
        this.setLocatorTypeId(e.getLocatorTypeId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(LocatorState s) {
        if (s == this) {
            return;
        }
        this.setWarehouseId(s.getWarehouseId());
        this.setParentLocatorId(s.getParentLocatorId());
        this.setLocatorType(s.getLocatorType());
        this.setPriorityNumber(s.getPriorityNumber());
        this.setIsDefault(s.getIsDefault());
        this.setX(s.getX());
        this.setY(s.getY());
        this.setZ(s.getZ());
        this.setDescription(s.getDescription());
        this.setLocatorTypeId(s.getLocatorTypeId());
        this.setActive(s.getActive());
    }

    public void when(LocatorStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getWarehouseId() == null)
        {
            if (e.getIsPropertyWarehouseIdRemoved() != null && e.getIsPropertyWarehouseIdRemoved())
            {
                this.setWarehouseId(null);
            }
        }
        else
        {
            this.setWarehouseId(e.getWarehouseId());
        }
        if (e.getParentLocatorId() == null)
        {
            if (e.getIsPropertyParentLocatorIdRemoved() != null && e.getIsPropertyParentLocatorIdRemoved())
            {
                this.setParentLocatorId(null);
            }
        }
        else
        {
            this.setParentLocatorId(e.getParentLocatorId());
        }
        if (e.getLocatorType() == null)
        {
            if (e.getIsPropertyLocatorTypeRemoved() != null && e.getIsPropertyLocatorTypeRemoved())
            {
                this.setLocatorType(null);
            }
        }
        else
        {
            this.setLocatorType(e.getLocatorType());
        }
        if (e.getPriorityNumber() == null)
        {
            if (e.getIsPropertyPriorityNumberRemoved() != null && e.getIsPropertyPriorityNumberRemoved())
            {
                this.setPriorityNumber(null);
            }
        }
        else
        {
            this.setPriorityNumber(e.getPriorityNumber());
        }
        if (e.getIsDefault() == null)
        {
            if (e.getIsPropertyIsDefaultRemoved() != null && e.getIsPropertyIsDefaultRemoved())
            {
                this.setIsDefault(null);
            }
        }
        else
        {
            this.setIsDefault(e.getIsDefault());
        }
        if (e.getX() == null)
        {
            if (e.getIsPropertyXRemoved() != null && e.getIsPropertyXRemoved())
            {
                this.setX(null);
            }
        }
        else
        {
            this.setX(e.getX());
        }
        if (e.getY() == null)
        {
            if (e.getIsPropertyYRemoved() != null && e.getIsPropertyYRemoved())
            {
                this.setY(null);
            }
        }
        else
        {
            this.setY(e.getY());
        }
        if (e.getZ() == null)
        {
            if (e.getIsPropertyZRemoved() != null && e.getIsPropertyZRemoved())
            {
                this.setZ(null);
            }
        }
        else
        {
            this.setZ(e.getZ());
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
        if (e.getLocatorTypeId() == null)
        {
            if (e.getIsPropertyLocatorTypeIdRemoved() != null && e.getIsPropertyLocatorTypeIdRemoved())
            {
                this.setLocatorTypeId(null);
            }
        }
        else
        {
            this.setLocatorTypeId(e.getLocatorTypeId());
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

    public void when(LocatorStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(LocatorEvent event)
    {
        String stateEntityId = this.getLocatorId(); // Aggregate Id
        String eventEntityId = ((LocatorEvent.SqlLocatorEvent)event).getLocatorEventId().getLocatorId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((LocatorEvent.SqlLocatorEvent)event).getLocatorEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getLocatorEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(LocatorState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleLocatorState extends AbstractLocatorState
    {

        public SimpleLocatorState() {
        }

        public SimpleLocatorState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleLocatorState(List<Event> events) {
            super(events);
        }

    }


}

