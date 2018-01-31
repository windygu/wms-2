package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryStateEvent.*;

public abstract class AbstractSellableInventoryItemEntryState implements SellableInventoryItemEntryState
{

    private SellableInventoryItemEntryId sellableInventoryItemEntryId = new SellableInventoryItemEntryId();

    public SellableInventoryItemEntryId getSellableInventoryItemEntryId() {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId) {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    public InventoryItemId getSellableInventoryItemId() {
        return this.getSellableInventoryItemEntryId().getSellableInventoryItemId();
    }
        
    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId) {
        this.getSellableInventoryItemEntryId().setSellableInventoryItemId(sellableInventoryItemId);
    }

    public Long getEntrySeqId() {
        return this.getSellableInventoryItemEntryId().getEntrySeqId();
    }
        
    public void setEntrySeqId(Long entrySeqId) {
        this.getSellableInventoryItemEntryId().setEntrySeqId(entrySeqId);
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

    private String commandId;

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }


    public AbstractSellableInventoryItemEntryState() {
        this(false);
    }

    public AbstractSellableInventoryItemEntryState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof SellableInventoryItemEntryStateCreated) {
            when((SellableInventoryItemEntryStateCreated) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(SellableInventoryItemEntryStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setSellableQuantity(e.getSellableQuantity());
        this.setSourceEventId(e.getSourceEventId());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(SellableInventoryItemEntryStateEvent stateEvent)
    {
        InventoryItemId stateEntityIdSellableInventoryItemId = this.getSellableInventoryItemEntryId().getSellableInventoryItemId();
        InventoryItemId eventEntityIdSellableInventoryItemId = stateEvent.getStateEventId().getSellableInventoryItemId();
        if (!stateEntityIdSellableInventoryItemId.equals(eventEntityIdSellableInventoryItemId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id SellableInventoryItemId %1$s in state but entity id SellableInventoryItemId %2$s in event", stateEntityIdSellableInventoryItemId, eventEntityIdSellableInventoryItemId);
        }

        Long stateEntityIdEntrySeqId = this.getSellableInventoryItemEntryId().getEntrySeqId();
        Long eventEntityIdEntrySeqId = stateEvent.getStateEventId().getEntrySeqId();
        if (!stateEntityIdEntrySeqId.equals(eventEntityIdEntrySeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id EntrySeqId %1$s in state but entity id EntrySeqId %2$s in event", stateEntityIdEntrySeqId, eventEntityIdEntrySeqId);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? SellableInventoryItemEntryState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(SellableInventoryItemEntryState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleSellableInventoryItemEntryState extends AbstractSellableInventoryItemEntryState
    {

        public SimpleSellableInventoryItemEntryState() {
        }

        public SimpleSellableInventoryItemEntryState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

