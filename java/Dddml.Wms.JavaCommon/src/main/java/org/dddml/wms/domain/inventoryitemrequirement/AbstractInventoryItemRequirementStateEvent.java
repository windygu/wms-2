package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryItemRequirementStateEvent extends AbstractStateEvent implements InventoryItemRequirementStateEvent 
{
    private InventoryItemRequirementStateEventId stateEventId;

    public InventoryItemRequirementStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(InventoryItemRequirementStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public InventoryItemId getInventoryItemRequirementId() {
        return getStateEventId().getInventoryItemRequirementId();
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId) {
        getStateEventId().setInventoryItemRequirementId(inventoryItemRequirementId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractInventoryItemRequirementStateEvent() {
    }

    protected AbstractInventoryItemRequirementStateEvent(InventoryItemRequirementStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected InventoryItemRequirementEntryStateEventId newInventoryItemRequirementEntryStateEventId(Long entrySeqId)
    {
        InventoryItemRequirementEntryStateEventId stateEventId = new InventoryItemRequirementEntryStateEventId(this.getStateEventId().getInventoryItemRequirementId(), 
            entrySeqId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(InventoryItemRequirementEntryStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(InventoryItemRequirementStateEvent oe, InventoryItemRequirementEntryStateEvent e)
    {
        if (!oe.getStateEventId().getInventoryItemRequirementId().equals(e.getStateEventId().getInventoryItemRequirementId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id InventoryItemRequirementId %1$s but inner id InventoryItemRequirementId %2$s", 
                oe.getStateEventId().getInventoryItemRequirementId(), e.getStateEventId().getInventoryItemRequirementId());
        }
    }

    public InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(Long entrySeqId) {
        return new AbstractInventoryItemRequirementEntryStateEvent.SimpleInventoryItemRequirementEntryStateCreated(newInventoryItemRequirementEntryStateEventId(entrySeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryItemRequirementStateCreated extends AbstractInventoryItemRequirementStateEvent implements InventoryItemRequirementStateEvent.InventoryItemRequirementStateCreated
    {
        public AbstractInventoryItemRequirementStateCreated() {
            this(new InventoryItemRequirementStateEventId());
        }

        public AbstractInventoryItemRequirementStateCreated(InventoryItemRequirementStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<InventoryItemRequirementEntryStateEventId, InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated> inventoryItemRequirementEntryEvents = new HashMap<InventoryItemRequirementEntryStateEventId, InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated>();
        
        private Iterable<InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated> readOnlyInventoryItemRequirementEntryEvents;

        public Iterable<InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated> getInventoryItemRequirementEntryEvents()
        {
            return this.inventoryItemRequirementEntryEvents.values();
        }

        public void setInventoryItemRequirementEntryEvents(Iterable<InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated> es)
        {
            if (es != null)
            {
                for (InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated e : es)
                {
                    addInventoryItemRequirementEntryEvent(e);
                }
            }
            else { this.inventoryItemRequirementEntryEvents.clear(); }
        }
        
        public void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.inventoryItemRequirementEntryEvents.put(e.getStateEventId(), e);
        }

    }


    public static abstract class AbstractInventoryItemRequirementStateMergePatched extends AbstractInventoryItemRequirementStateEvent implements InventoryItemRequirementStateEvent.InventoryItemRequirementStateMergePatched
    {
        public AbstractInventoryItemRequirementStateMergePatched() {
            this(new InventoryItemRequirementStateEventId());
        }

        public AbstractInventoryItemRequirementStateMergePatched(InventoryItemRequirementStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Map<InventoryItemRequirementEntryStateEventId, InventoryItemRequirementEntryStateEvent> inventoryItemRequirementEntryEvents = new HashMap<InventoryItemRequirementEntryStateEventId, InventoryItemRequirementEntryStateEvent>();
        
        private Iterable<InventoryItemRequirementEntryStateEvent> readOnlyInventoryItemRequirementEntryEvents;

        public Iterable<InventoryItemRequirementEntryStateEvent> getInventoryItemRequirementEntryEvents()
        {
            return this.inventoryItemRequirementEntryEvents.values();
        }

        public void setInventoryItemRequirementEntryEvents(Iterable<InventoryItemRequirementEntryStateEvent> es)
        {
            if (es != null)
            {
                for (InventoryItemRequirementEntryStateEvent e : es)
                {
                    addInventoryItemRequirementEntryEvent(e);
                }
            }
            else { this.inventoryItemRequirementEntryEvents.clear(); }
        }
        
        public void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.inventoryItemRequirementEntryEvents.put(e.getStateEventId(), e);
        }

    }


    public static class SimpleInventoryItemRequirementStateCreated extends AbstractInventoryItemRequirementStateCreated
    {
        public SimpleInventoryItemRequirementStateCreated() {
        }

        public SimpleInventoryItemRequirementStateCreated(InventoryItemRequirementStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleInventoryItemRequirementStateMergePatched extends AbstractInventoryItemRequirementStateMergePatched
    {
        public SimpleInventoryItemRequirementStateMergePatched() {
        }

        public SimpleInventoryItemRequirementStateMergePatched(InventoryItemRequirementStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

