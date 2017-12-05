package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractSellableInventoryItemStateEvent extends AbstractStateEvent implements SellableInventoryItemStateEvent 
{
    private SellableInventoryItemStateEventId stateEventId;

    public SellableInventoryItemStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(SellableInventoryItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public InventoryItemId getSellableInventoryItemId() {
        return getStateEventId().getSellableInventoryItemId();
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId) {
        getStateEventId().setSellableInventoryItemId(sellableInventoryItemId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private BigDecimal quantitySellable;

    public BigDecimal getQuantitySellable()
    {
        return this.quantitySellable;
    }

    public void setQuantitySellable(BigDecimal quantitySellable)
    {
        this.quantitySellable = quantitySellable;
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

    protected AbstractSellableInventoryItemStateEvent() {
    }

    protected AbstractSellableInventoryItemStateEvent(SellableInventoryItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected SellableInventoryItemEntryStateEventId newSellableInventoryItemEntryStateEventId(Long entrySeqId)
    {
        SellableInventoryItemEntryStateEventId stateEventId = new SellableInventoryItemEntryStateEventId(this.getStateEventId().getSellableInventoryItemId(), 
            entrySeqId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(SellableInventoryItemEntryStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(SellableInventoryItemStateEvent oe, SellableInventoryItemEntryStateEvent e)
    {
        if (!oe.getStateEventId().getSellableInventoryItemId().equals(e.getStateEventId().getSellableInventoryItemId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id SellableInventoryItemId %1$s but inner id SellableInventoryItemId %2$s", 
                oe.getStateEventId().getSellableInventoryItemId(), e.getStateEventId().getSellableInventoryItemId());
        }
    }

    public SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId) {
        return new AbstractSellableInventoryItemEntryStateEvent.SimpleSellableInventoryItemEntryStateCreated(newSellableInventoryItemEntryStateEventId(entrySeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractSellableInventoryItemStateCreated extends AbstractSellableInventoryItemStateEvent implements SellableInventoryItemStateEvent.SellableInventoryItemStateCreated
    {
        public AbstractSellableInventoryItemStateCreated() {
            this(new SellableInventoryItemStateEventId());
        }

        public AbstractSellableInventoryItemStateCreated(SellableInventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<SellableInventoryItemEntryStateEventId, SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated> sellableInventoryItemEntryEvents = new HashMap<SellableInventoryItemEntryStateEventId, SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated>();
        
        private Iterable<SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated> readOnlySellableInventoryItemEntryEvents;

        public Iterable<SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated> getSellableInventoryItemEntryEvents()
        {
            return this.sellableInventoryItemEntryEvents.values();
        }

        public void setSellableInventoryItemEntryEvents(Iterable<SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated> es)
        {
            if (es != null)
            {
                for (SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated e : es)
                {
                    addSellableInventoryItemEntryEvent(e);
                }
            }
            else { this.sellableInventoryItemEntryEvents.clear(); }
        }
        
        public void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.sellableInventoryItemEntryEvents.put(e.getStateEventId(), e);
        }

    }


    public static abstract class AbstractSellableInventoryItemStateMergePatched extends AbstractSellableInventoryItemStateEvent implements SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched
    {
        public AbstractSellableInventoryItemStateMergePatched() {
            this(new SellableInventoryItemStateEventId());
        }

        public AbstractSellableInventoryItemStateMergePatched(SellableInventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantitySellableRemoved;

        public Boolean getIsPropertyQuantitySellableRemoved() {
            return this.isPropertyQuantitySellableRemoved;
        }

        public void setIsPropertyQuantitySellableRemoved(Boolean removed) {
            this.isPropertyQuantitySellableRemoved = removed;
        }

        private Map<SellableInventoryItemEntryStateEventId, SellableInventoryItemEntryStateEvent> sellableInventoryItemEntryEvents = new HashMap<SellableInventoryItemEntryStateEventId, SellableInventoryItemEntryStateEvent>();
        
        private Iterable<SellableInventoryItemEntryStateEvent> readOnlySellableInventoryItemEntryEvents;

        public Iterable<SellableInventoryItemEntryStateEvent> getSellableInventoryItemEntryEvents()
        {
            return this.sellableInventoryItemEntryEvents.values();
        }

        public void setSellableInventoryItemEntryEvents(Iterable<SellableInventoryItemEntryStateEvent> es)
        {
            if (es != null)
            {
                for (SellableInventoryItemEntryStateEvent e : es)
                {
                    addSellableInventoryItemEntryEvent(e);
                }
            }
            else { this.sellableInventoryItemEntryEvents.clear(); }
        }
        
        public void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.sellableInventoryItemEntryEvents.put(e.getStateEventId(), e);
        }

    }


    public static class SimpleSellableInventoryItemStateCreated extends AbstractSellableInventoryItemStateCreated
    {
        public SimpleSellableInventoryItemStateCreated() {
        }

        public SimpleSellableInventoryItemStateCreated(SellableInventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleSellableInventoryItemStateMergePatched extends AbstractSellableInventoryItemStateMergePatched
    {
        public SimpleSellableInventoryItemStateMergePatched() {
        }

        public SimpleSellableInventoryItemStateMergePatched(SellableInventoryItemStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

