package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractSellableInventoryItemEvent extends AbstractEvent implements SellableInventoryItemEvent.SqlSellableInventoryItemEvent 
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

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getSellableInventoryItemEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getSellableInventoryItemEventId().setVersion(version);
    //}

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

    protected AbstractSellableInventoryItemEvent() {
    }

    protected AbstractSellableInventoryItemEvent(SellableInventoryItemEventId eventId) {
        this.sellableInventoryItemEventId = eventId;
    }

    protected SellableInventoryItemEntryEventId newSellableInventoryItemEntryEventId(Long entrySeqId)
    {
        SellableInventoryItemEntryEventId eventId = new SellableInventoryItemEntryEventId(this.getSellableInventoryItemEventId().getSellableInventoryItemId(), 
            entrySeqId, 
            this.getSellableInventoryItemEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(SellableInventoryItemEvent.SqlSellableInventoryItemEvent oe, SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent e)
    {
        if (!oe.getSellableInventoryItemEventId().getSellableInventoryItemId().equals(e.getSellableInventoryItemEntryEventId().getSellableInventoryItemId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id SellableInventoryItemId %1$s but inner id SellableInventoryItemId %2$s", 
                oe.getSellableInventoryItemEventId().getSellableInventoryItemId(), e.getSellableInventoryItemEntryEventId().getSellableInventoryItemId());
        }
    }

    public SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(Long entrySeqId) {
        return new AbstractSellableInventoryItemEntryEvent.SimpleSellableInventoryItemEntryStateCreated(newSellableInventoryItemEntryEventId(entrySeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractSellableInventoryItemStateEvent extends AbstractSellableInventoryItemEvent implements SellableInventoryItemEvent.SellableInventoryItemStateEvent {
        private BigDecimal sellableQuantity;

        public BigDecimal getSellableQuantity()
        {
            return this.sellableQuantity;
        }

        public void setSellableQuantity(BigDecimal sellableQuantity)
        {
            this.sellableQuantity = sellableQuantity;
        }

        protected AbstractSellableInventoryItemStateEvent(SellableInventoryItemEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractSellableInventoryItemStateCreated extends AbstractSellableInventoryItemStateEvent implements SellableInventoryItemEvent.SellableInventoryItemStateCreated
    {
        public AbstractSellableInventoryItemStateCreated() {
            this(new SellableInventoryItemEventId());
        }

        public AbstractSellableInventoryItemStateCreated(SellableInventoryItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<SellableInventoryItemEntryEventId, SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated> sellableInventoryItemEntryEvents = new HashMap<SellableInventoryItemEntryEventId, SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated>();
        
        private Iterable<SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated> readOnlySellableInventoryItemEntryEvents;

        public Iterable<SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated> getSellableInventoryItemEntryEvents()
        {
            return this.sellableInventoryItemEntryEvents.values();
        }

        public void setSellableInventoryItemEntryEvents(Iterable<SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated> es)
        {
            if (es != null)
            {
                for (SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated e : es)
                {
                    addSellableInventoryItemEntryEvent(e);
                }
            }
            else { this.sellableInventoryItemEntryEvents.clear(); }
        }
        
        public void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated e)
        {
            throwOnInconsistentEventIds((SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent)e);
            this.sellableInventoryItemEntryEvents.put(((SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent)e).getSellableInventoryItemEntryEventId(), e);
        }

    }


    public static abstract class AbstractSellableInventoryItemStateMergePatched extends AbstractSellableInventoryItemStateEvent implements SellableInventoryItemEvent.SellableInventoryItemStateMergePatched
    {
        public AbstractSellableInventoryItemStateMergePatched() {
            this(new SellableInventoryItemEventId());
        }

        public AbstractSellableInventoryItemStateMergePatched(SellableInventoryItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertySellableQuantityRemoved;

        public Boolean getIsPropertySellableQuantityRemoved() {
            return this.isPropertySellableQuantityRemoved;
        }

        public void setIsPropertySellableQuantityRemoved(Boolean removed) {
            this.isPropertySellableQuantityRemoved = removed;
        }

        private Map<SellableInventoryItemEntryEventId, SellableInventoryItemEntryEvent> sellableInventoryItemEntryEvents = new HashMap<SellableInventoryItemEntryEventId, SellableInventoryItemEntryEvent>();
        
        private Iterable<SellableInventoryItemEntryEvent> readOnlySellableInventoryItemEntryEvents;

        public Iterable<SellableInventoryItemEntryEvent> getSellableInventoryItemEntryEvents()
        {
            return this.sellableInventoryItemEntryEvents.values();
        }

        public void setSellableInventoryItemEntryEvents(Iterable<SellableInventoryItemEntryEvent> es)
        {
            if (es != null)
            {
                for (SellableInventoryItemEntryEvent e : es)
                {
                    addSellableInventoryItemEntryEvent(e);
                }
            }
            else { this.sellableInventoryItemEntryEvents.clear(); }
        }
        
        public void addSellableInventoryItemEntryEvent(SellableInventoryItemEntryEvent e)
        {
            throwOnInconsistentEventIds((SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent)e);
            this.sellableInventoryItemEntryEvents.put(((SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent)e).getSellableInventoryItemEntryEventId(), e);
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

