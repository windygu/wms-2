package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitementrymvo.InventoryItemEntryMvoStateEvent.*;

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

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand()
    {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand)
    {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityInTransit;

    public BigDecimal getQuantityInTransit()
    {
        return this.quantityInTransit;
    }

    public void setQuantityInTransit(BigDecimal quantityInTransit)
    {
        this.quantityInTransit = quantityInTransit;
    }

    private BigDecimal quantityReserved;

    public BigDecimal getQuantityReserved()
    {
        return this.quantityReserved;
    }

    public void setQuantityReserved(BigDecimal quantityReserved)
    {
        this.quantityReserved = quantityReserved;
    }

    private BigDecimal quantityOccupied;

    public BigDecimal getQuantityOccupied()
    {
        return this.quantityOccupied;
    }

    public void setQuantityOccupied(BigDecimal quantityOccupied)
    {
        this.quantityOccupied = quantityOccupied;
    }

    private BigDecimal quantityVirtual;

    public BigDecimal getQuantityVirtual()
    {
        return this.quantityVirtual;
    }

    public void setQuantityVirtual(BigDecimal quantityVirtual)
    {
        this.quantityVirtual = quantityVirtual;
    }

    private InventoryItemSourceVO source;

    public InventoryItemSourceVO getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceVO source)
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

    private BigDecimal inventoryItemQuantityOnHand;

    public BigDecimal getInventoryItemQuantityOnHand()
    {
        return this.inventoryItemQuantityOnHand;
    }

    public void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand)
    {
        this.inventoryItemQuantityOnHand = inventoryItemQuantityOnHand;
    }

    private BigDecimal inventoryItemQuantityInTransit;

    public BigDecimal getInventoryItemQuantityInTransit()
    {
        return this.inventoryItemQuantityInTransit;
    }

    public void setInventoryItemQuantityInTransit(BigDecimal inventoryItemQuantityInTransit)
    {
        this.inventoryItemQuantityInTransit = inventoryItemQuantityInTransit;
    }

    private BigDecimal inventoryItemQuantityReserved;

    public BigDecimal getInventoryItemQuantityReserved()
    {
        return this.inventoryItemQuantityReserved;
    }

    public void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved)
    {
        this.inventoryItemQuantityReserved = inventoryItemQuantityReserved;
    }

    private BigDecimal inventoryItemQuantityOccupied;

    public BigDecimal getInventoryItemQuantityOccupied()
    {
        return this.inventoryItemQuantityOccupied;
    }

    public void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied)
    {
        this.inventoryItemQuantityOccupied = inventoryItemQuantityOccupied;
    }

    private BigDecimal inventoryItemQuantityVirtual;

    public BigDecimal getInventoryItemQuantityVirtual()
    {
        return this.inventoryItemQuantityVirtual;
    }

    public void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual)
    {
        this.inventoryItemQuantityVirtual = inventoryItemQuantityVirtual;
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
            this.setInventoryItemEntryId(((InventoryItemEntryMvoStateEvent) events.get(0)).getStateEventId().getInventoryItemEntryId());
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

        this.setQuantityOnHand(e.getQuantityOnHand());
        this.setQuantityInTransit(e.getQuantityInTransit());
        this.setQuantityReserved(e.getQuantityReserved());
        this.setQuantityOccupied(e.getQuantityOccupied());
        this.setQuantityVirtual(e.getQuantityVirtual());
        this.setSource(e.getSource());
        this.setVersion(e.getVersion());
        this.setInventoryItemQuantityOnHand(e.getInventoryItemQuantityOnHand());
        this.setInventoryItemQuantityInTransit(e.getInventoryItemQuantityInTransit());
        this.setInventoryItemQuantityReserved(e.getInventoryItemQuantityReserved());
        this.setInventoryItemQuantityOccupied(e.getInventoryItemQuantityOccupied());
        this.setInventoryItemQuantityVirtual(e.getInventoryItemQuantityVirtual());
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

        if (e.getQuantityOnHand() == null)
        {
            if (e.getIsPropertyQuantityOnHandRemoved() != null && e.getIsPropertyQuantityOnHandRemoved())
            {
                this.setQuantityOnHand(null);
            }
        }
        else
        {
            this.setQuantityOnHand(e.getQuantityOnHand());
        }
        if (e.getQuantityInTransit() == null)
        {
            if (e.getIsPropertyQuantityInTransitRemoved() != null && e.getIsPropertyQuantityInTransitRemoved())
            {
                this.setQuantityInTransit(null);
            }
        }
        else
        {
            this.setQuantityInTransit(e.getQuantityInTransit());
        }
        if (e.getQuantityReserved() == null)
        {
            if (e.getIsPropertyQuantityReservedRemoved() != null && e.getIsPropertyQuantityReservedRemoved())
            {
                this.setQuantityReserved(null);
            }
        }
        else
        {
            this.setQuantityReserved(e.getQuantityReserved());
        }
        if (e.getQuantityOccupied() == null)
        {
            if (e.getIsPropertyQuantityOccupiedRemoved() != null && e.getIsPropertyQuantityOccupiedRemoved())
            {
                this.setQuantityOccupied(null);
            }
        }
        else
        {
            this.setQuantityOccupied(e.getQuantityOccupied());
        }
        if (e.getQuantityVirtual() == null)
        {
            if (e.getIsPropertyQuantityVirtualRemoved() != null && e.getIsPropertyQuantityVirtualRemoved())
            {
                this.setQuantityVirtual(null);
            }
        }
        else
        {
            this.setQuantityVirtual(e.getQuantityVirtual());
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
        if (e.getInventoryItemQuantityOnHand() == null)
        {
            if (e.getIsPropertyInventoryItemQuantityOnHandRemoved() != null && e.getIsPropertyInventoryItemQuantityOnHandRemoved())
            {
                this.setInventoryItemQuantityOnHand(null);
            }
        }
        else
        {
            this.setInventoryItemQuantityOnHand(e.getInventoryItemQuantityOnHand());
        }
        if (e.getInventoryItemQuantityInTransit() == null)
        {
            if (e.getIsPropertyInventoryItemQuantityInTransitRemoved() != null && e.getIsPropertyInventoryItemQuantityInTransitRemoved())
            {
                this.setInventoryItemQuantityInTransit(null);
            }
        }
        else
        {
            this.setInventoryItemQuantityInTransit(e.getInventoryItemQuantityInTransit());
        }
        if (e.getInventoryItemQuantityReserved() == null)
        {
            if (e.getIsPropertyInventoryItemQuantityReservedRemoved() != null && e.getIsPropertyInventoryItemQuantityReservedRemoved())
            {
                this.setInventoryItemQuantityReserved(null);
            }
        }
        else
        {
            this.setInventoryItemQuantityReserved(e.getInventoryItemQuantityReserved());
        }
        if (e.getInventoryItemQuantityOccupied() == null)
        {
            if (e.getIsPropertyInventoryItemQuantityOccupiedRemoved() != null && e.getIsPropertyInventoryItemQuantityOccupiedRemoved())
            {
                this.setInventoryItemQuantityOccupied(null);
            }
        }
        else
        {
            this.setInventoryItemQuantityOccupied(e.getInventoryItemQuantityOccupied());
        }
        if (e.getInventoryItemQuantityVirtual() == null)
        {
            if (e.getIsPropertyInventoryItemQuantityVirtualRemoved() != null && e.getIsPropertyInventoryItemQuantityVirtualRemoved())
            {
                this.setInventoryItemQuantityVirtual(null);
            }
        }
        else
        {
            this.setInventoryItemQuantityVirtual(e.getInventoryItemQuantityVirtual());
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

    protected void throwOnWrongEvent(InventoryItemEntryMvoStateEvent stateEvent)
    {
        InventoryItemEntryId stateEntityId = this.getInventoryItemEntryId(); // Aggregate Id
        InventoryItemEntryId eventEntityId = stateEvent.getStateEventId().getInventoryItemEntryId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getInventoryItemVersion();
        Long eventVersion = stateEvent.getStateEventId().getInventoryItemVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getInventoryItemVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemEntryMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
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

