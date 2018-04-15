package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInventoryItemRequirementEvent extends AbstractEvent implements InventoryItemRequirementEvent 
{
    private InventoryItemRequirementEventId inventoryItemRequirementEventId;

    public InventoryItemRequirementEventId getInventoryItemRequirementEventId() {
        return this.inventoryItemRequirementEventId;
    }

    public void setInventoryItemRequirementEventId(InventoryItemRequirementEventId eventId) {
        this.inventoryItemRequirementEventId = eventId;
    }
    
    public InventoryItemId getInventoryItemRequirementId() {
        return getInventoryItemRequirementEventId().getInventoryItemRequirementId();
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId) {
        getInventoryItemRequirementEventId().setInventoryItemRequirementId(inventoryItemRequirementId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private BigDecimal quantity;

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractInventoryItemRequirementEvent() {
    }

    protected AbstractInventoryItemRequirementEvent(InventoryItemRequirementEventId eventId) {
        this.inventoryItemRequirementEventId = eventId;
    }

    protected InventoryItemRequirementEntryEventId newInventoryItemRequirementEntryEventId(Long entrySeqId)
    {
        InventoryItemRequirementEntryEventId eventId = new InventoryItemRequirementEntryEventId(this.getInventoryItemRequirementEventId().getInventoryItemRequirementId(), 
            entrySeqId, 
            this.getInventoryItemRequirementEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(InventoryItemRequirementEntryEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(InventoryItemRequirementEvent oe, InventoryItemRequirementEntryEvent e)
    {
        if (!oe.getInventoryItemRequirementEventId().getInventoryItemRequirementId().equals(e.getInventoryItemRequirementEntryEventId().getInventoryItemRequirementId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id InventoryItemRequirementId %1$s but inner id InventoryItemRequirementId %2$s", 
                oe.getInventoryItemRequirementEventId().getInventoryItemRequirementId(), e.getInventoryItemRequirementEntryEventId().getInventoryItemRequirementId());
        }
    }

    public InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(Long entrySeqId) {
        return new AbstractInventoryItemRequirementEntryEvent.SimpleInventoryItemRequirementEntryStateCreated(newInventoryItemRequirementEntryEventId(entrySeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractInventoryItemRequirementStateCreated extends AbstractInventoryItemRequirementEvent implements InventoryItemRequirementEvent.InventoryItemRequirementStateCreated
    {
        public AbstractInventoryItemRequirementStateCreated() {
            this(new InventoryItemRequirementEventId());
        }

        public AbstractInventoryItemRequirementStateCreated(InventoryItemRequirementEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<InventoryItemRequirementEntryEventId, InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated> inventoryItemRequirementEntryEvents = new HashMap<InventoryItemRequirementEntryEventId, InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated>();
        
        private Iterable<InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated> readOnlyInventoryItemRequirementEntryEvents;

        public Iterable<InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated> getInventoryItemRequirementEntryEvents()
        {
            return this.inventoryItemRequirementEntryEvents.values();
        }

        public void setInventoryItemRequirementEntryEvents(Iterable<InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated> es)
        {
            if (es != null)
            {
                for (InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e : es)
                {
                    addInventoryItemRequirementEntryEvent(e);
                }
            }
            else { this.inventoryItemRequirementEntryEvents.clear(); }
        }
        
        public void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.inventoryItemRequirementEntryEvents.put(e.getInventoryItemRequirementEntryEventId(), e);
        }

    }


    public static abstract class AbstractInventoryItemRequirementStateMergePatched extends AbstractInventoryItemRequirementEvent implements InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched
    {
        public AbstractInventoryItemRequirementStateMergePatched() {
            this(new InventoryItemRequirementEventId());
        }

        public AbstractInventoryItemRequirementStateMergePatched(InventoryItemRequirementEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Map<InventoryItemRequirementEntryEventId, InventoryItemRequirementEntryEvent> inventoryItemRequirementEntryEvents = new HashMap<InventoryItemRequirementEntryEventId, InventoryItemRequirementEntryEvent>();
        
        private Iterable<InventoryItemRequirementEntryEvent> readOnlyInventoryItemRequirementEntryEvents;

        public Iterable<InventoryItemRequirementEntryEvent> getInventoryItemRequirementEntryEvents()
        {
            return this.inventoryItemRequirementEntryEvents.values();
        }

        public void setInventoryItemRequirementEntryEvents(Iterable<InventoryItemRequirementEntryEvent> es)
        {
            if (es != null)
            {
                for (InventoryItemRequirementEntryEvent e : es)
                {
                    addInventoryItemRequirementEntryEvent(e);
                }
            }
            else { this.inventoryItemRequirementEntryEvents.clear(); }
        }
        
        public void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.inventoryItemRequirementEntryEvents.put(e.getInventoryItemRequirementEntryEventId(), e);
        }

    }


    public static class SimpleInventoryItemRequirementStateCreated extends AbstractInventoryItemRequirementStateCreated
    {
        public SimpleInventoryItemRequirementStateCreated() {
        }

        public SimpleInventoryItemRequirementStateCreated(InventoryItemRequirementEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInventoryItemRequirementStateMergePatched extends AbstractInventoryItemRequirementStateMergePatched
    {
        public SimpleInventoryItemRequirementStateMergePatched() {
        }

        public SimpleInventoryItemRequirementStateMergePatched(InventoryItemRequirementEventId eventId) {
            super(eventId);
        }
    }

}

