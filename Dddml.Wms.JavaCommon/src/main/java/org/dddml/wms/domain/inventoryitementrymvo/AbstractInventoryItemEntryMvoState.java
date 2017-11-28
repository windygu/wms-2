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

    private BigDecimal quantityOnHandVar;

    public BigDecimal getQuantityOnHandVar()
    {
        return this.quantityOnHandVar;
    }

    public void setQuantityOnHandVar(BigDecimal quantityOnHandVar)
    {
        this.quantityOnHandVar = quantityOnHandVar;
    }

    private BigDecimal quantityReservedVar;

    public BigDecimal getQuantityReservedVar()
    {
        return this.quantityReservedVar;
    }

    public void setQuantityReservedVar(BigDecimal quantityReservedVar)
    {
        this.quantityReservedVar = quantityReservedVar;
    }

    private BigDecimal quantityOccupiedVar;

    public BigDecimal getQuantityOccupiedVar()
    {
        return this.quantityOccupiedVar;
    }

    public void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar)
    {
        this.quantityOccupiedVar = quantityOccupiedVar;
    }

    private BigDecimal quantityVirtualVar;

    public BigDecimal getQuantityVirtualVar()
    {
        return this.quantityVirtualVar;
    }

    public void setQuantityVirtualVar(BigDecimal quantityVirtualVar)
    {
        this.quantityVirtualVar = quantityVirtualVar;
    }

    private InventoryItemEventVO eventVO;

    public InventoryItemEventVO getEventVO()
    {
        return this.eventVO;
    }

    public void setEventVO(InventoryItemEventVO eventVO)
    {
        this.eventVO = eventVO;
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

    private BigDecimal inventoryItemQuantityOnHand;

    public BigDecimal getInventoryItemQuantityOnHand()
    {
        return this.inventoryItemQuantityOnHand;
    }

    public void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand)
    {
        this.inventoryItemQuantityOnHand = inventoryItemQuantityOnHand;
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

        this.setQuantityOnHandVar(e.getQuantityOnHandVar());
        this.setQuantityReservedVar(e.getQuantityReservedVar());
        this.setQuantityOccupiedVar(e.getQuantityOccupiedVar());
        this.setQuantityVirtualVar(e.getQuantityVirtualVar());
        this.setEventVO(e.getEventVO());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setInventoryItemQuantityOnHand(e.getInventoryItemQuantityOnHand());
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

        if (e.getQuantityOnHandVar() == null)
        {
            if (e.getIsPropertyQuantityOnHandVarRemoved() != null && e.getIsPropertyQuantityOnHandVarRemoved())
            {
                this.setQuantityOnHandVar(null);
            }
        }
        else
        {
            this.setQuantityOnHandVar(e.getQuantityOnHandVar());
        }
        if (e.getQuantityReservedVar() == null)
        {
            if (e.getIsPropertyQuantityReservedVarRemoved() != null && e.getIsPropertyQuantityReservedVarRemoved())
            {
                this.setQuantityReservedVar(null);
            }
        }
        else
        {
            this.setQuantityReservedVar(e.getQuantityReservedVar());
        }
        if (e.getQuantityOccupiedVar() == null)
        {
            if (e.getIsPropertyQuantityOccupiedVarRemoved() != null && e.getIsPropertyQuantityOccupiedVarRemoved())
            {
                this.setQuantityOccupiedVar(null);
            }
        }
        else
        {
            this.setQuantityOccupiedVar(e.getQuantityOccupiedVar());
        }
        if (e.getQuantityVirtualVar() == null)
        {
            if (e.getIsPropertyQuantityVirtualVarRemoved() != null && e.getIsPropertyQuantityVirtualVarRemoved())
            {
                this.setQuantityVirtualVar(null);
            }
        }
        else
        {
            this.setQuantityVirtualVar(e.getQuantityVirtualVar());
        }
        if (e.getEventVO() == null)
        {
            if (e.getIsPropertyEventVORemoved() != null && e.getIsPropertyEventVORemoved())
            {
                this.setEventVO(null);
            }
        }
        else
        {
            this.setEventVO(e.getEventVO());
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

