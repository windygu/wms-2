package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractSellableInventoryItemEntryEvent extends AbstractEvent implements SellableInventoryItemEntryEvent.SqlSellableInventoryItemEntryEvent 
{
    private SellableInventoryItemEntryState state;

    public SellableInventoryItemEntryState getSellableInventoryItemEntryState() {
        return state;
    }

    public SellableInventoryItemEntryEventId getSellableInventoryItemEntryEventId() {
        SellableInventoryItemEntryEventId eventId = new SellableInventoryItemEntryEventId(state.getSellableInventoryItemId(), state.getEntrySeqId(), SellableInventoryItemState.VERSION_NULL);
        return eventId;
    }

    public void setSellableInventoryItemEntryEventId(SellableInventoryItemEntryEventId eventId) {
        this.state.setSellableInventoryItemId(eventId.getSellableInventoryItemId());
        this.state.setEntrySeqId(eventId.getEntrySeqId());
    }

    public Long getEntrySeqId() {
        return getSellableInventoryItemEntryEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getSellableInventoryItemEntryEventId().setEntrySeqId(entrySeqId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public String getCreatedBy()
    {
        return this.state.getCreatedBy();
    }

    public void setCreatedBy(String createdBy)
    {
        this.state.setCreatedBy(createdBy);
    }

    public Date getCreatedAt()
    {
        return this.state.getCreatedAt();
    }

    public void setCreatedAt(Date createdAt)
    {
        this.state.setCreatedAt(createdAt);
    }


    public String getCommandId() {
        return this.state.getCommandId();
    }

    public void setCommandId(String commandId) {
        this.state.setCommandId(commandId);
    }

    protected AbstractSellableInventoryItemEntryEvent() {
        this(new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState());
    }

    protected AbstractSellableInventoryItemEntryEvent(SellableInventoryItemEntryEventId eventId) {
        this(new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState());
        setSellableInventoryItemEntryEventId(eventId);
    }

    protected AbstractSellableInventoryItemEntryEvent(SellableInventoryItemEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getEventType();


    public static abstract class AbstractSellableInventoryItemEntryStateEvent extends AbstractSellableInventoryItemEntryEvent implements SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateEvent {
        public Long getVersion()
        {
            return this.getSellableInventoryItemEntryState().getVersion();
        }

        public void setVersion(Long version)
        {
            this.getSellableInventoryItemEntryState().setVersion(version);
        }

        public BigDecimal getSellableQuantity()
        {
            return this.getSellableInventoryItemEntryState().getSellableQuantity();
        }

        public void setSellableQuantity(BigDecimal sellableQuantity)
        {
            this.getSellableInventoryItemEntryState().setSellableQuantity(sellableQuantity);
        }

        public InventoryPRTriggeredId getSourceEventId()
        {
            return this.getSellableInventoryItemEntryState().getSourceEventId();
        }

        public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
        {
            this.getSellableInventoryItemEntryState().setSourceEventId(sourceEventId);
        }

        protected AbstractSellableInventoryItemEntryStateEvent(SellableInventoryItemEntryEventId eventId) {
            super(eventId);
        }

        public AbstractSellableInventoryItemEntryStateEvent(SellableInventoryItemEntryState s) {
            super(s);
        }
    }

    public static abstract class AbstractSellableInventoryItemEntryStateCreated extends AbstractSellableInventoryItemEntryStateEvent implements SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated
    {
        public AbstractSellableInventoryItemEntryStateCreated() {
            this(new SellableInventoryItemEntryEventId());
        }

        public AbstractSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryEventId eventId) {
            super(eventId);
        }

        public AbstractSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryState s) {
            super(s);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static class SimpleSellableInventoryItemEntryStateCreated extends AbstractSellableInventoryItemEntryStateCreated
    {
        public SimpleSellableInventoryItemEntryStateCreated() {
        }

        public SimpleSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryEventId eventId) {
            super(eventId);
        }

        public SimpleSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryState s) {
            super(s);
        }
    }

}

