package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryEvent.*;

public abstract class AbstractInventoryItemRequirementEntryState implements InventoryItemRequirementEntryState
{

    private InventoryItemRequirementEntryId inventoryItemRequirementEntryId = new InventoryItemRequirementEntryId();

    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId() {
        return this.inventoryItemRequirementEntryId;
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId) {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
    }

    public InventoryItemId getInventoryItemRequirementId() {
        return this.getInventoryItemRequirementEntryId().getInventoryItemRequirementId();
    }
        
    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId) {
        this.getInventoryItemRequirementEntryId().setInventoryItemRequirementId(inventoryItemRequirementId);
    }

    public Long getEntrySeqId() {
        return this.getInventoryItemRequirementEntryId().getEntrySeqId();
    }
        
    public void setEntrySeqId(Long entrySeqId) {
        this.getInventoryItemRequirementEntryId().setEntrySeqId(entrySeqId);
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


    public AbstractInventoryItemRequirementEntryState() {
        this(false);
    }

    public AbstractInventoryItemRequirementEntryState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InventoryItemRequirementEntryStateCreated) {
            when((InventoryItemRequirementEntryStateCreated) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InventoryItemRequirementEntryStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());
        this.setSourceEventId(e.getSourceEventId());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InventoryItemRequirementEntryEvent event)
    {
        InventoryItemId stateEntityIdInventoryItemRequirementId = this.getInventoryItemRequirementEntryId().getInventoryItemRequirementId();
        InventoryItemId eventEntityIdInventoryItemRequirementId = event.getInventoryItemRequirementEntryEventId().getInventoryItemRequirementId();
        if (!stateEntityIdInventoryItemRequirementId.equals(eventEntityIdInventoryItemRequirementId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InventoryItemRequirementId %1$s in state but entity id InventoryItemRequirementId %2$s in event", stateEntityIdInventoryItemRequirementId, eventEntityIdInventoryItemRequirementId);
        }

        Long stateEntityIdEntrySeqId = this.getInventoryItemRequirementEntryId().getEntrySeqId();
        Long eventEntityIdEntrySeqId = event.getInventoryItemRequirementEntryEventId().getEntrySeqId();
        if (!stateEntityIdEntrySeqId.equals(eventEntityIdEntrySeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id EntrySeqId %1$s in state but entity id EntrySeqId %2$s in event", stateEntityIdEntrySeqId, eventEntityIdEntrySeqId);
        }

        if (getForReapplying()) { return; }

        InventoryItemRequirementEntryStateEvent stateEvent = event instanceof InventoryItemRequirementEntryStateEvent ? (InventoryItemRequirementEntryStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? InventoryItemRequirementEntryState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(InventoryItemRequirementEntryState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleInventoryItemRequirementEntryState extends AbstractInventoryItemRequirementEntryState
    {

        public SimpleInventoryItemRequirementEntryState() {
        }

        public SimpleInventoryItemRequirementEntryState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

