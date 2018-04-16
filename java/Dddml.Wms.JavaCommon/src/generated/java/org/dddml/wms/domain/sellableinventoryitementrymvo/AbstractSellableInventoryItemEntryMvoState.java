package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitementrymvo.SellableInventoryItemEntryMvoEvent.*;

public abstract class AbstractSellableInventoryItemEntryMvoState implements SellableInventoryItemEntryMvoState
{

    private SellableInventoryItemEntryId sellableInventoryItemEntryId;

    public SellableInventoryItemEntryId getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
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

    private BigDecimal sellableInventoryItemSellableQuantity;

    public BigDecimal getSellableInventoryItemSellableQuantity()
    {
        return this.sellableInventoryItemSellableQuantity;
    }

    public void setSellableInventoryItemSellableQuantity(BigDecimal sellableInventoryItemSellableQuantity)
    {
        this.sellableInventoryItemSellableQuantity = sellableInventoryItemSellableQuantity;
    }

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }

    private String sellableInventoryItemCreatedBy;

    public String getSellableInventoryItemCreatedBy()
    {
        return this.sellableInventoryItemCreatedBy;
    }

    public void setSellableInventoryItemCreatedBy(String sellableInventoryItemCreatedBy)
    {
        this.sellableInventoryItemCreatedBy = sellableInventoryItemCreatedBy;
    }

    private Date sellableInventoryItemCreatedAt;

    public Date getSellableInventoryItemCreatedAt()
    {
        return this.sellableInventoryItemCreatedAt;
    }

    public void setSellableInventoryItemCreatedAt(Date sellableInventoryItemCreatedAt)
    {
        this.sellableInventoryItemCreatedAt = sellableInventoryItemCreatedAt;
    }

    private String sellableInventoryItemUpdatedBy;

    public String getSellableInventoryItemUpdatedBy()
    {
        return this.sellableInventoryItemUpdatedBy;
    }

    public void setSellableInventoryItemUpdatedBy(String sellableInventoryItemUpdatedBy)
    {
        this.sellableInventoryItemUpdatedBy = sellableInventoryItemUpdatedBy;
    }

    private Date sellableInventoryItemUpdatedAt;

    public Date getSellableInventoryItemUpdatedAt()
    {
        return this.sellableInventoryItemUpdatedAt;
    }

    public void setSellableInventoryItemUpdatedAt(Date sellableInventoryItemUpdatedAt)
    {
        this.sellableInventoryItemUpdatedAt = sellableInventoryItemUpdatedAt;
    }

    public boolean isStateUnsaved() 
    {
        return this.getSellableInventoryItemVersion() == null;
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

    public AbstractSellableInventoryItemEntryMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setSellableInventoryItemEntryId(((SellableInventoryItemEntryMvoEvent) events.get(0)).getSellableInventoryItemEntryMvoEventId().getSellableInventoryItemEntryId());
            for (Event e : events) {
                mutate(e);
                this.setSellableInventoryItemVersion(this.getSellableInventoryItemVersion() + 1);
            }
        }
    }


    public AbstractSellableInventoryItemEntryMvoState() {
        this(false);
    }

    public AbstractSellableInventoryItemEntryMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof SellableInventoryItemEntryMvoStateCreated) {
            when((SellableInventoryItemEntryMvoStateCreated) e);
        } else if (e instanceof SellableInventoryItemEntryMvoStateMergePatched) {
            when((SellableInventoryItemEntryMvoStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(SellableInventoryItemEntryMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setSellableQuantity(e.getSellableQuantity());
        this.setSourceEventId(e.getSourceEventId());
        this.setVersion(e.getVersion());
        this.setSellableInventoryItemSellableQuantity(e.getSellableInventoryItemSellableQuantity());
        this.setSellableInventoryItemCreatedBy(e.getSellableInventoryItemCreatedBy());
        this.setSellableInventoryItemCreatedAt(e.getSellableInventoryItemCreatedAt());
        this.setSellableInventoryItemUpdatedBy(e.getSellableInventoryItemUpdatedBy());
        this.setSellableInventoryItemUpdatedAt(e.getSellableInventoryItemUpdatedAt());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(SellableInventoryItemEntryMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getSellableQuantity() == null)
        {
            if (e.getIsPropertySellableQuantityRemoved() != null && e.getIsPropertySellableQuantityRemoved())
            {
                this.setSellableQuantity(null);
            }
        }
        else
        {
            this.setSellableQuantity(e.getSellableQuantity());
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
        if (e.getSellableInventoryItemSellableQuantity() == null)
        {
            if (e.getIsPropertySellableInventoryItemSellableQuantityRemoved() != null && e.getIsPropertySellableInventoryItemSellableQuantityRemoved())
            {
                this.setSellableInventoryItemSellableQuantity(null);
            }
        }
        else
        {
            this.setSellableInventoryItemSellableQuantity(e.getSellableInventoryItemSellableQuantity());
        }
        if (e.getSellableInventoryItemCreatedBy() == null)
        {
            if (e.getIsPropertySellableInventoryItemCreatedByRemoved() != null && e.getIsPropertySellableInventoryItemCreatedByRemoved())
            {
                this.setSellableInventoryItemCreatedBy(null);
            }
        }
        else
        {
            this.setSellableInventoryItemCreatedBy(e.getSellableInventoryItemCreatedBy());
        }
        if (e.getSellableInventoryItemCreatedAt() == null)
        {
            if (e.getIsPropertySellableInventoryItemCreatedAtRemoved() != null && e.getIsPropertySellableInventoryItemCreatedAtRemoved())
            {
                this.setSellableInventoryItemCreatedAt(null);
            }
        }
        else
        {
            this.setSellableInventoryItemCreatedAt(e.getSellableInventoryItemCreatedAt());
        }
        if (e.getSellableInventoryItemUpdatedBy() == null)
        {
            if (e.getIsPropertySellableInventoryItemUpdatedByRemoved() != null && e.getIsPropertySellableInventoryItemUpdatedByRemoved())
            {
                this.setSellableInventoryItemUpdatedBy(null);
            }
        }
        else
        {
            this.setSellableInventoryItemUpdatedBy(e.getSellableInventoryItemUpdatedBy());
        }
        if (e.getSellableInventoryItemUpdatedAt() == null)
        {
            if (e.getIsPropertySellableInventoryItemUpdatedAtRemoved() != null && e.getIsPropertySellableInventoryItemUpdatedAtRemoved())
            {
                this.setSellableInventoryItemUpdatedAt(null);
            }
        }
        else
        {
            this.setSellableInventoryItemUpdatedAt(e.getSellableInventoryItemUpdatedAt());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(SellableInventoryItemEntryMvoEvent event)
    {
        SellableInventoryItemEntryId stateEntityId = this.getSellableInventoryItemEntryId(); // Aggregate Id
        SellableInventoryItemEntryId eventEntityId = event.getSellableInventoryItemEntryMvoEventId().getSellableInventoryItemEntryId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getSellableInventoryItemVersion();
        Long eventVersion = event.getSellableInventoryItemEntryMvoEventId().getSellableInventoryItemVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getSellableInventoryItemEntryMvoEventId().getSellableInventoryItemVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(SellableInventoryItemEntryMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleSellableInventoryItemEntryMvoState extends AbstractSellableInventoryItemEntryMvoState
    {

        public SimpleSellableInventoryItemEntryMvoState() {
        }

        public SimpleSellableInventoryItemEntryMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleSellableInventoryItemEntryMvoState(List<Event> events) {
            super(events);
        }

    }


}

