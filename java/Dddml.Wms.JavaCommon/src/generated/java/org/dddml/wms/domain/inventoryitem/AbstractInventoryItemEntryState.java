package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryEvent.*;

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

    private java.sql.Timestamp occuredAt;

    public java.sql.Timestamp getOccuredAt()
    {
        return this.occuredAt;
    }

    public void setOccuredAt(java.sql.Timestamp occuredAt)
    {
        this.occuredAt = occuredAt;
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

        this.setOnHandQuantity(e.getOnHandQuantity());
        this.setInTransitQuantity(e.getInTransitQuantity());
        this.setReservedQuantity(e.getReservedQuantity());
        this.setOccupiedQuantity(e.getOccupiedQuantity());
        this.setVirtualQuantity(e.getVirtualQuantity());
        this.setSource(e.getSource());
        this.setOccuredAt(e.getOccuredAt());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryItemEntryEvent event)
    {
        InventoryItemId stateEntityIdInventoryItemId = this.getInventoryItemEntryId().getInventoryItemId();
        InventoryItemId eventEntityIdInventoryItemId = event.getInventoryItemEntryEventId().getInventoryItemId();
        if (!stateEntityIdInventoryItemId.equals(eventEntityIdInventoryItemId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InventoryItemId %1$s in state but entity id InventoryItemId %2$s in event", stateEntityIdInventoryItemId, eventEntityIdInventoryItemId);
        }

        Long stateEntityIdEntrySeqId = this.getInventoryItemEntryId().getEntrySeqId();
        Long eventEntityIdEntrySeqId = event.getInventoryItemEntryEventId().getEntrySeqId();
        if (!stateEntityIdEntrySeqId.equals(eventEntityIdEntrySeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id EntrySeqId %1$s in state but entity id EntrySeqId %2$s in event", stateEntityIdEntrySeqId, eventEntityIdEntrySeqId);
        }

        if (getForReapplying()) { return; }

        InventoryItemEntryStateEvent stateEvent = event instanceof InventoryItemEntryStateEvent ? (InventoryItemEntryStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? InventoryItemEntryState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(InventoryItemEntryState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

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

