package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitemrequiremententrymvo.InventoryItemRequirementEntryMvoStateEvent.*;

public abstract class AbstractInventoryItemRequirementEntryMvoState implements InventoryItemRequirementEntryMvoState
{

    private InventoryItemRequirementEntryId inventoryItemRequirementEntryId;

    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId()
    {
        return this.inventoryItemRequirementEntryId;
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
    }

    private BigDecimal quantity;

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private InventoryPRTriggeredId sourceEventId;

    public InventoryPRTriggeredId getSourceEventId()
    {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
    {
        this.sourceEventId = sourceEventId;
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

    private BigDecimal inventoryItemRequirementQuantity;

    public BigDecimal getInventoryItemRequirementQuantity()
    {
        return this.inventoryItemRequirementQuantity;
    }

    public void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity)
    {
        this.inventoryItemRequirementQuantity = inventoryItemRequirementQuantity;
    }

    private Long inventoryItemRequirementVersion;

    public Long getInventoryItemRequirementVersion()
    {
        return this.inventoryItemRequirementVersion;
    }

    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
    }

    private String inventoryItemRequirementCreatedBy;

    public String getInventoryItemRequirementCreatedBy()
    {
        return this.inventoryItemRequirementCreatedBy;
    }

    public void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy)
    {
        this.inventoryItemRequirementCreatedBy = inventoryItemRequirementCreatedBy;
    }

    private Date inventoryItemRequirementCreatedAt;

    public Date getInventoryItemRequirementCreatedAt()
    {
        return this.inventoryItemRequirementCreatedAt;
    }

    public void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt)
    {
        this.inventoryItemRequirementCreatedAt = inventoryItemRequirementCreatedAt;
    }

    private String inventoryItemRequirementUpdatedBy;

    public String getInventoryItemRequirementUpdatedBy()
    {
        return this.inventoryItemRequirementUpdatedBy;
    }

    public void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy)
    {
        this.inventoryItemRequirementUpdatedBy = inventoryItemRequirementUpdatedBy;
    }

    private Date inventoryItemRequirementUpdatedAt;

    public Date getInventoryItemRequirementUpdatedAt()
    {
        return this.inventoryItemRequirementUpdatedAt;
    }

    public void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt)
    {
        this.inventoryItemRequirementUpdatedAt = inventoryItemRequirementUpdatedAt;
    }

    public boolean isStateUnsaved() 
    {
        return this.getInventoryItemRequirementVersion() == null;
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

    public AbstractInventoryItemRequirementEntryMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInventoryItemRequirementEntryId(((InventoryItemRequirementEntryMvoStateEvent) events.get(0)).getStateEventId().getInventoryItemRequirementEntryId());
            for (Event e : events) {
                mutate(e);
                this.setInventoryItemRequirementVersion(this.getInventoryItemRequirementVersion() + 1);
            }
        }
    }


    public AbstractInventoryItemRequirementEntryMvoState() {
        this(false);
    }

    public AbstractInventoryItemRequirementEntryMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryItemRequirementEntryMvoStateCreated) {
            when((InventoryItemRequirementEntryMvoStateCreated) e);
        } else if (e instanceof InventoryItemRequirementEntryMvoStateMergePatched) {
            when((InventoryItemRequirementEntryMvoStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryItemRequirementEntryMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());
        this.setSourceEventId(e.getSourceEventId());
        this.setVersion(e.getVersion());
        this.setInventoryItemRequirementQuantity(e.getInventoryItemRequirementQuantity());
        this.setInventoryItemRequirementCreatedBy(e.getInventoryItemRequirementCreatedBy());
        this.setInventoryItemRequirementCreatedAt(e.getInventoryItemRequirementCreatedAt());
        this.setInventoryItemRequirementUpdatedBy(e.getInventoryItemRequirementUpdatedBy());
        this.setInventoryItemRequirementUpdatedAt(e.getInventoryItemRequirementUpdatedAt());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(InventoryItemRequirementEntryMvoStateMergePatched e)
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
        if (e.getSourceEventId() == null)
        {
            if (e.getIsPropertySourceEventIdRemoved() != null && e.getIsPropertySourceEventIdRemoved())
            {
                this.setSourceEventId(null);
            }
        }
        else
        {
            this.setSourceEventId(e.getSourceEventId());
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
        if (e.getInventoryItemRequirementQuantity() == null)
        {
            if (e.getIsPropertyInventoryItemRequirementQuantityRemoved() != null && e.getIsPropertyInventoryItemRequirementQuantityRemoved())
            {
                this.setInventoryItemRequirementQuantity(null);
            }
        }
        else
        {
            this.setInventoryItemRequirementQuantity(e.getInventoryItemRequirementQuantity());
        }
        if (e.getInventoryItemRequirementCreatedBy() == null)
        {
            if (e.getIsPropertyInventoryItemRequirementCreatedByRemoved() != null && e.getIsPropertyInventoryItemRequirementCreatedByRemoved())
            {
                this.setInventoryItemRequirementCreatedBy(null);
            }
        }
        else
        {
            this.setInventoryItemRequirementCreatedBy(e.getInventoryItemRequirementCreatedBy());
        }
        if (e.getInventoryItemRequirementCreatedAt() == null)
        {
            if (e.getIsPropertyInventoryItemRequirementCreatedAtRemoved() != null && e.getIsPropertyInventoryItemRequirementCreatedAtRemoved())
            {
                this.setInventoryItemRequirementCreatedAt(null);
            }
        }
        else
        {
            this.setInventoryItemRequirementCreatedAt(e.getInventoryItemRequirementCreatedAt());
        }
        if (e.getInventoryItemRequirementUpdatedBy() == null)
        {
            if (e.getIsPropertyInventoryItemRequirementUpdatedByRemoved() != null && e.getIsPropertyInventoryItemRequirementUpdatedByRemoved())
            {
                this.setInventoryItemRequirementUpdatedBy(null);
            }
        }
        else
        {
            this.setInventoryItemRequirementUpdatedBy(e.getInventoryItemRequirementUpdatedBy());
        }
        if (e.getInventoryItemRequirementUpdatedAt() == null)
        {
            if (e.getIsPropertyInventoryItemRequirementUpdatedAtRemoved() != null && e.getIsPropertyInventoryItemRequirementUpdatedAtRemoved())
            {
                this.setInventoryItemRequirementUpdatedAt(null);
            }
        }
        else
        {
            this.setInventoryItemRequirementUpdatedAt(e.getInventoryItemRequirementUpdatedAt());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryItemRequirementEntryMvoStateEvent stateEvent)
    {
        InventoryItemRequirementEntryId stateEntityId = this.getInventoryItemRequirementEntryId(); // Aggregate Id
        InventoryItemRequirementEntryId eventEntityId = stateEvent.getStateEventId().getInventoryItemRequirementEntryId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getInventoryItemRequirementVersion();
        Long eventVersion = stateEvent.getStateEventId().getInventoryItemRequirementVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getInventoryItemRequirementVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemRequirementEntryMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryItemRequirementEntryMvoState extends AbstractInventoryItemRequirementEntryMvoState
    {

        public SimpleInventoryItemRequirementEntryMvoState() {
        }

        public SimpleInventoryItemRequirementEntryMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInventoryItemRequirementEntryMvoState(List<Event> events) {
            super(events);
        }

    }


}

