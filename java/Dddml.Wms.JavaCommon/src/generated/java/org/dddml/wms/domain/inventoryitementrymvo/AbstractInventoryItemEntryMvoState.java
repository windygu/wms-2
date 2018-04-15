package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitementrymvo.InventoryItemEntryMvoEvent.*;

public abstract class AbstractInventoryItemEntryMvoState implements InventoryItemEntryMvoState
{

    private InventoryItemEntryId inventoryItemEntryId;

    public InventoryItemEntryId getInventoryItemEntryId()
    {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
    }

    private BigDecimal onHandQuantity;

    public BigDecimal getOnHandQuantity()
    {
        return this.onHandQuantity;
    }

    public void setOnHandQuantity(BigDecimal onHandQuantity)
    {
        this.onHandQuantity = onHandQuantity;
    }

    private BigDecimal inTransitQuantity;

    public BigDecimal getInTransitQuantity()
    {
        return this.inTransitQuantity;
    }

    public void setInTransitQuantity(BigDecimal inTransitQuantity)
    {
        this.inTransitQuantity = inTransitQuantity;
    }

    private BigDecimal reservedQuantity;

    public BigDecimal getReservedQuantity()
    {
        return this.reservedQuantity;
    }

    public void setReservedQuantity(BigDecimal reservedQuantity)
    {
        this.reservedQuantity = reservedQuantity;
    }

    private BigDecimal occupiedQuantity;

    public BigDecimal getOccupiedQuantity()
    {
        return this.occupiedQuantity;
    }

    public void setOccupiedQuantity(BigDecimal occupiedQuantity)
    {
        this.occupiedQuantity = occupiedQuantity;
    }

    private BigDecimal virtualQuantity;

    public BigDecimal getVirtualQuantity()
    {
        return this.virtualQuantity;
    }

    public void setVirtualQuantity(BigDecimal virtualQuantity)
    {
        this.virtualQuantity = virtualQuantity;
    }

    private InventoryItemSourceInfo source;

    public InventoryItemSourceInfo getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceInfo source)
    {
        this.source = source;
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

    private BigDecimal inventoryItemOnHandQuantity;

    public BigDecimal getInventoryItemOnHandQuantity()
    {
        return this.inventoryItemOnHandQuantity;
    }

    public void setInventoryItemOnHandQuantity(BigDecimal inventoryItemOnHandQuantity)
    {
        this.inventoryItemOnHandQuantity = inventoryItemOnHandQuantity;
    }

    private BigDecimal inventoryItemInTransitQuantity;

    public BigDecimal getInventoryItemInTransitQuantity()
    {
        return this.inventoryItemInTransitQuantity;
    }

    public void setInventoryItemInTransitQuantity(BigDecimal inventoryItemInTransitQuantity)
    {
        this.inventoryItemInTransitQuantity = inventoryItemInTransitQuantity;
    }

    private BigDecimal inventoryItemReservedQuantity;

    public BigDecimal getInventoryItemReservedQuantity()
    {
        return this.inventoryItemReservedQuantity;
    }

    public void setInventoryItemReservedQuantity(BigDecimal inventoryItemReservedQuantity)
    {
        this.inventoryItemReservedQuantity = inventoryItemReservedQuantity;
    }

    private BigDecimal inventoryItemOccupiedQuantity;

    public BigDecimal getInventoryItemOccupiedQuantity()
    {
        return this.inventoryItemOccupiedQuantity;
    }

    public void setInventoryItemOccupiedQuantity(BigDecimal inventoryItemOccupiedQuantity)
    {
        this.inventoryItemOccupiedQuantity = inventoryItemOccupiedQuantity;
    }

    private BigDecimal inventoryItemVirtualQuantity;

    public BigDecimal getInventoryItemVirtualQuantity()
    {
        return this.inventoryItemVirtualQuantity;
    }

    public void setInventoryItemVirtualQuantity(BigDecimal inventoryItemVirtualQuantity)
    {
        this.inventoryItemVirtualQuantity = inventoryItemVirtualQuantity;
    }

    private Long inventoryItemVersion;

    public Long getInventoryItemVersion()
    {
        return this.inventoryItemVersion;
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.inventoryItemVersion = inventoryItemVersion;
    }

    private String inventoryItemCreatedBy;

    public String getInventoryItemCreatedBy()
    {
        return this.inventoryItemCreatedBy;
    }

    public void setInventoryItemCreatedBy(String inventoryItemCreatedBy)
    {
        this.inventoryItemCreatedBy = inventoryItemCreatedBy;
    }

    private Date inventoryItemCreatedAt;

    public Date getInventoryItemCreatedAt()
    {
        return this.inventoryItemCreatedAt;
    }

    public void setInventoryItemCreatedAt(Date inventoryItemCreatedAt)
    {
        this.inventoryItemCreatedAt = inventoryItemCreatedAt;
    }

    private String inventoryItemUpdatedBy;

    public String getInventoryItemUpdatedBy()
    {
        return this.inventoryItemUpdatedBy;
    }

    public void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy)
    {
        this.inventoryItemUpdatedBy = inventoryItemUpdatedBy;
    }

    private Date inventoryItemUpdatedAt;

    public Date getInventoryItemUpdatedAt()
    {
        return this.inventoryItemUpdatedAt;
    }

    public void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt)
    {
        this.inventoryItemUpdatedAt = inventoryItemUpdatedAt;
    }

    public boolean isStateUnsaved() 
    {
        return this.getInventoryItemVersion() == null;
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

    public AbstractInventoryItemEntryMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInventoryItemEntryId(((InventoryItemEntryMvoEvent) events.get(0)).getInventoryItemEntryMvoEventId().getInventoryItemEntryId());
            for (Event e : events) {
                mutate(e);
                this.setInventoryItemVersion(this.getInventoryItemVersion() + 1);
            }
        }
    }


    public AbstractInventoryItemEntryMvoState() {
        this(false);
    }

    public AbstractInventoryItemEntryMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryItemEntryMvoStateCreated) {
            when((InventoryItemEntryMvoStateCreated) e);
        } else if (e instanceof InventoryItemEntryMvoStateMergePatched) {
            when((InventoryItemEntryMvoStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryItemEntryMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setOnHandQuantity(e.getOnHandQuantity());
        this.setInTransitQuantity(e.getInTransitQuantity());
        this.setReservedQuantity(e.getReservedQuantity());
        this.setOccupiedQuantity(e.getOccupiedQuantity());
        this.setVirtualQuantity(e.getVirtualQuantity());
        this.setSource(e.getSource());
        this.setVersion(e.getVersion());
        this.setInventoryItemOnHandQuantity(e.getInventoryItemOnHandQuantity());
        this.setInventoryItemInTransitQuantity(e.getInventoryItemInTransitQuantity());
        this.setInventoryItemReservedQuantity(e.getInventoryItemReservedQuantity());
        this.setInventoryItemOccupiedQuantity(e.getInventoryItemOccupiedQuantity());
        this.setInventoryItemVirtualQuantity(e.getInventoryItemVirtualQuantity());
        this.setInventoryItemCreatedBy(e.getInventoryItemCreatedBy());
        this.setInventoryItemCreatedAt(e.getInventoryItemCreatedAt());
        this.setInventoryItemUpdatedBy(e.getInventoryItemUpdatedBy());
        this.setInventoryItemUpdatedAt(e.getInventoryItemUpdatedAt());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(InventoryItemEntryMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getOnHandQuantity() == null)
        {
            if (e.getIsPropertyOnHandQuantityRemoved() != null && e.getIsPropertyOnHandQuantityRemoved())
            {
                this.setOnHandQuantity(null);
            }
        }
        else
        {
            this.setOnHandQuantity(e.getOnHandQuantity());
        }
        if (e.getInTransitQuantity() == null)
        {
            if (e.getIsPropertyInTransitQuantityRemoved() != null && e.getIsPropertyInTransitQuantityRemoved())
            {
                this.setInTransitQuantity(null);
            }
        }
        else
        {
            this.setInTransitQuantity(e.getInTransitQuantity());
        }
        if (e.getReservedQuantity() == null)
        {
            if (e.getIsPropertyReservedQuantityRemoved() != null && e.getIsPropertyReservedQuantityRemoved())
            {
                this.setReservedQuantity(null);
            }
        }
        else
        {
            this.setReservedQuantity(e.getReservedQuantity());
        }
        if (e.getOccupiedQuantity() == null)
        {
            if (e.getIsPropertyOccupiedQuantityRemoved() != null && e.getIsPropertyOccupiedQuantityRemoved())
            {
                this.setOccupiedQuantity(null);
            }
        }
        else
        {
            this.setOccupiedQuantity(e.getOccupiedQuantity());
        }
        if (e.getVirtualQuantity() == null)
        {
            if (e.getIsPropertyVirtualQuantityRemoved() != null && e.getIsPropertyVirtualQuantityRemoved())
            {
                this.setVirtualQuantity(null);
            }
        }
        else
        {
            this.setVirtualQuantity(e.getVirtualQuantity());
        }
        if (e.getSource() == null)
        {
            if (e.getIsPropertySourceRemoved() != null && e.getIsPropertySourceRemoved())
            {
                this.setSource(null);
            }
        }
        else
        {
            this.setSource(e.getSource());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getInventoryItemOnHandQuantity() == null)
        {
            if (e.getIsPropertyInventoryItemOnHandQuantityRemoved() != null && e.getIsPropertyInventoryItemOnHandQuantityRemoved())
            {
                this.setInventoryItemOnHandQuantity(null);
            }
        }
        else
        {
            this.setInventoryItemOnHandQuantity(e.getInventoryItemOnHandQuantity());
        }
        if (e.getInventoryItemInTransitQuantity() == null)
        {
            if (e.getIsPropertyInventoryItemInTransitQuantityRemoved() != null && e.getIsPropertyInventoryItemInTransitQuantityRemoved())
            {
                this.setInventoryItemInTransitQuantity(null);
            }
        }
        else
        {
            this.setInventoryItemInTransitQuantity(e.getInventoryItemInTransitQuantity());
        }
        if (e.getInventoryItemReservedQuantity() == null)
        {
            if (e.getIsPropertyInventoryItemReservedQuantityRemoved() != null && e.getIsPropertyInventoryItemReservedQuantityRemoved())
            {
                this.setInventoryItemReservedQuantity(null);
            }
        }
        else
        {
            this.setInventoryItemReservedQuantity(e.getInventoryItemReservedQuantity());
        }
        if (e.getInventoryItemOccupiedQuantity() == null)
        {
            if (e.getIsPropertyInventoryItemOccupiedQuantityRemoved() != null && e.getIsPropertyInventoryItemOccupiedQuantityRemoved())
            {
                this.setInventoryItemOccupiedQuantity(null);
            }
        }
        else
        {
            this.setInventoryItemOccupiedQuantity(e.getInventoryItemOccupiedQuantity());
        }
        if (e.getInventoryItemVirtualQuantity() == null)
        {
            if (e.getIsPropertyInventoryItemVirtualQuantityRemoved() != null && e.getIsPropertyInventoryItemVirtualQuantityRemoved())
            {
                this.setInventoryItemVirtualQuantity(null);
            }
        }
        else
        {
            this.setInventoryItemVirtualQuantity(e.getInventoryItemVirtualQuantity());
        }
        if (e.getInventoryItemCreatedBy() == null)
        {
            if (e.getIsPropertyInventoryItemCreatedByRemoved() != null && e.getIsPropertyInventoryItemCreatedByRemoved())
            {
                this.setInventoryItemCreatedBy(null);
            }
        }
        else
        {
            this.setInventoryItemCreatedBy(e.getInventoryItemCreatedBy());
        }
        if (e.getInventoryItemCreatedAt() == null)
        {
            if (e.getIsPropertyInventoryItemCreatedAtRemoved() != null && e.getIsPropertyInventoryItemCreatedAtRemoved())
            {
                this.setInventoryItemCreatedAt(null);
            }
        }
        else
        {
            this.setInventoryItemCreatedAt(e.getInventoryItemCreatedAt());
        }
        if (e.getInventoryItemUpdatedBy() == null)
        {
            if (e.getIsPropertyInventoryItemUpdatedByRemoved() != null && e.getIsPropertyInventoryItemUpdatedByRemoved())
            {
                this.setInventoryItemUpdatedBy(null);
            }
        }
        else
        {
            this.setInventoryItemUpdatedBy(e.getInventoryItemUpdatedBy());
        }
        if (e.getInventoryItemUpdatedAt() == null)
        {
            if (e.getIsPropertyInventoryItemUpdatedAtRemoved() != null && e.getIsPropertyInventoryItemUpdatedAtRemoved())
            {
                this.setInventoryItemUpdatedAt(null);
            }
        }
        else
        {
            this.setInventoryItemUpdatedAt(e.getInventoryItemUpdatedAt());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryItemEntryMvoEvent stateEvent)
    {
        InventoryItemEntryId stateEntityId = this.getInventoryItemEntryId(); // Aggregate Id
        InventoryItemEntryId eventEntityId = stateEvent.getInventoryItemEntryMvoEventId().getInventoryItemEntryId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getInventoryItemVersion();
        Long eventVersion = stateEvent.getInventoryItemEntryMvoEventId().getInventoryItemVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getInventoryItemEntryMvoEventId().getInventoryItemVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemEntryMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryItemEntryMvoState extends AbstractInventoryItemEntryMvoState
    {

        public SimpleInventoryItemEntryMvoState() {
        }

        public SimpleInventoryItemEntryMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInventoryItemEntryMvoState(List<Event> events) {
            super(events);
        }

    }


}

