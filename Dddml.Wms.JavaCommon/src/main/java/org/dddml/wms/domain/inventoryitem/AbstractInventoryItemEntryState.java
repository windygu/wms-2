package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryStateEvent.*;

public abstract class AbstractInventoryItemEntryState implements InventoryItemEntryState
{

    private InventoryItemEntryId inventoryItemEntryId = new InventoryItemEntryId();

    public InventoryItemEntryId getInventoryItemEntryId() {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId) {
        this.inventoryItemEntryId = inventoryItemEntryId;
    }

    public InventoryItemId getInventoryItemId() {
        return this.getInventoryItemEntryId().getInventoryItemId();
    }
        
    public void setInventoryItemId(InventoryItemId inventoryItemId) {
        this.getInventoryItemEntryId().setInventoryItemId(inventoryItemId);
    }

    public Long getEntrySeqId() {
        return this.getInventoryItemEntryId().getEntrySeqId();
    }
        
    public void setEntrySeqId(Long entrySeqId) {
        this.getInventoryItemEntryId().setEntrySeqId(entrySeqId);
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


    public AbstractInventoryItemEntryState() {
        this(false);
    }

    public AbstractInventoryItemEntryState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryItemEntryStateCreated) {
            when((InventoryItemEntryStateCreated) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryItemEntryStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantityOnHand(e.getQuantityOnHand());
        this.setQuantityInTransit(e.getQuantityInTransit());
        this.setQuantityReserved(e.getQuantityReserved());
        this.setQuantityOccupied(e.getQuantityOccupied());
        this.setQuantityVirtual(e.getQuantityVirtual());
        this.setSource(e.getSource());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryItemEntryStateEvent stateEvent)
    {
        InventoryItemId stateEntityIdInventoryItemId = this.getInventoryItemEntryId().getInventoryItemId();
        InventoryItemId eventEntityIdInventoryItemId = stateEvent.getStateEventId().getInventoryItemId();
        if (!stateEntityIdInventoryItemId.equals(eventEntityIdInventoryItemId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InventoryItemId %1$s in state but entity id InventoryItemId %2$s in event", stateEntityIdInventoryItemId, eventEntityIdInventoryItemId);
        }

        Long stateEntityIdEntrySeqId = this.getInventoryItemEntryId().getEntrySeqId();
        Long eventEntityIdEntrySeqId = stateEvent.getStateEventId().getEntrySeqId();
        if (!stateEntityIdEntrySeqId.equals(eventEntityIdEntrySeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id EntrySeqId %1$s in state but entity id EntrySeqId %2$s in event", stateEntityIdEntrySeqId, eventEntityIdEntrySeqId);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? InventoryItemEntryState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(InventoryItemEntryState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInventoryItemEntryState extends AbstractInventoryItemEntryState
    {

        public SimpleInventoryItemEntryState() {
        }

        public SimpleInventoryItemEntryState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

