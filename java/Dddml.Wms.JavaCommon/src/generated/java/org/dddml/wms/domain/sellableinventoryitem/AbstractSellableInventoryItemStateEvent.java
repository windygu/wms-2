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
    private SellableInventoryItemEventId sellableInventoryItemEventId;

    public SellableInventoryItemEventId getSellableInventoryItemEventId() {
        return this.sellableInventoryItemEventId;
    }

    public void setSellableInventoryItemEventId(SellableInventoryItemEventId eventId) {
        this.sellableInventoryItemEventId = eventId;
    }
    
    public InventoryItemId getSellableInventoryItemId() {
        return getSellableInventoryItemEventId().getSellableInventoryItemId();
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId) {
        getSellableInventoryItemEventId().setSellableInventoryItemId(sellableInventoryItemId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
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

    protected AbstractSellableInventoryItemStateEvent(SellableInventoryItemEventId eventId) {
        this.sellableInventoryItemEventId = eventId;
    }

    protected SellableInventoryItemEntryEventId newSellableInventoryItemEntryEventId(Long entrySeqId)
    {
        SellableInventoryItemEntryEventId eventId = new SellableInventoryItemEntryEventId(this.getSellableInventoryItemEventId().getSellableInventoryItemId(), 
            entrySeqId, 
            this.getSellableInventoryItemEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(SellableInventoryItemEntryStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(SellableInventoryItemStateEvent oe, SellableInventoryItemEntryStateEvent e)
    {
        if (!oe.getSellableInventoryItemEventId().getSellableInventoryItemId().equals(e.getSellableInventoryItemEntryEventId().getSellableInventoryItemId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id SellableInventoryItemId %1$s but inner id SellableInventoryItemId %2$s", 
                oe.getSellableInventoryItemEventId().getSellableInventoryItemId(), e.getSellableInventoryItemEntryEventId().getSellableInventoryItemId());
        }
    }

    public SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId) {
        return new AbstractSellableInventoryItemEntryStateEvent.SimpleSellableInventoryItemEntryStateCreated(newSellableInventoryItemEntryEventId(entrySeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractSellableInventoryItemStateCreated extends AbstractSellableInventoryItemStateEvent implements SellableInventoryItemStateEvent.SellableInventoryItemStateCreated
    {
        public AbstractSellableInventoryItemStateCreated() {
            this(new SellableInventoryItemEventId());
        }

        public AbstractSellableInventoryItemStateCreated(SellableInventoryItemEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<SellableInventoryItemEntryEventId, SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated> sellableInventoryItemEntryEvents = new HashMap<SellableInventoryItemEntryEventId, SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated>();
        
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
            this.sellableInventoryItemEntryEvents.put(e.getSellableInventoryItemEntryEventId(), e);
        }

    }


    public static abstract class AbstractSellableInventoryItemStateMergePatched extends AbstractSellableInventoryItemStateEvent implements SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched
    {
        public AbstractSellableInventoryItemStateMergePatched() {
            this(new SellableInventoryItemEventId());
        }

        public AbstractSellableInventoryItemStateMergePatched(SellableInventoryItemEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertySellableQuantityRemoved;

        public Boolean getIsPropertySellableQuantityRemoved() {
            return this.isPropertySellableQuantityRemoved;
        }

        public void setIsPropertySellableQuantityRemoved(Boolean removed) {
            this.isPropertySellableQuantityRemoved = removed;
        }

        private Map<SellableInventoryItemEntryEventId, SellableInventoryItemEntryStateEvent> sellableInventoryItemEntryEvents = new HashMap<SellableInventoryItemEntryEventId, SellableInventoryItemEntryStateEvent>();
        
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
            this.sellableInventoryItemEntryEvents.put(e.getSellableInventoryItemEntryEventId(), e);
        }

    }


    public static class SimpleSellableInventoryItemStateCreated extends AbstractSellableInventoryItemStateCreated
    {
        public SimpleSellableInventoryItemStateCreated() {
        }

        public SimpleSellableInventoryItemStateCreated(SellableInventoryItemEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleSellableInventoryItemStateMergePatched extends AbstractSellableInventoryItemStateMergePatched
    {
        public SimpleSellableInventoryItemStateMergePatched() {
        }

        public SimpleSellableInventoryItemStateMergePatched(SellableInventoryItemEventId eventId) {
            super(eventId);
        }
    }

}

