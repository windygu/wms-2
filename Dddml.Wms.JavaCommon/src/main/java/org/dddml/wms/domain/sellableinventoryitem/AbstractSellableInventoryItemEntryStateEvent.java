package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractSellableInventoryItemEntryStateEvent extends AbstractStateEvent implements SellableInventoryItemEntryStateEvent 
{
    private SellableInventoryItemEntryState state;

    public SellableInventoryItemEntryState getSellableInventoryItemEntryState() {
        return state;
    }

    public SellableInventoryItemEntryStateEventId getStateEventId() {
        SellableInventoryItemEntryStateEventId eventId = new SellableInventoryItemEntryStateEventId(state.getSellableInventoryItemId(), state.getEntrySeqId(), SellableInventoryItemState.VERSION_NULL);
        return eventId;
    }

    public void setStateEventId(SellableInventoryItemEntryStateEventId stateEventId) {
        this.state.setSellableInventoryItemId(stateEventId.getSellableInventoryItemId());
        this.state.setEntrySeqId(stateEventId.getEntrySeqId());
    }

    public Long getEntrySeqId() {
        return getStateEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getStateEventId().setEntrySeqId(entrySeqId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    public Long getVersion()
    {
        return this.state.getVersion();
    }

    public void setVersion(Long version)
    {
        this.state.setVersion(version);
    }

    public BigDecimal getSellableQuantity()
    {
        return this.state.getSellableQuantity();
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.state.setSellableQuantity(sellableQuantity);
    }

    public InventoryPRTriggeredId getSourceEventId()
    {
        return this.state.getSourceEventId();
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
    {
        this.state.setSourceEventId(sourceEventId);
    }

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

    protected AbstractSellableInventoryItemEntryStateEvent() {
        this(new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState());
    }

    protected AbstractSellableInventoryItemEntryStateEvent(SellableInventoryItemEntryStateEventId stateEventId) {
        this(new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState());
        setStateEventId(stateEventId);
    }

    protected AbstractSellableInventoryItemEntryStateEvent(SellableInventoryItemEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractSellableInventoryItemEntryStateCreated extends AbstractSellableInventoryItemEntryStateEvent implements SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated
    {
        public AbstractSellableInventoryItemEntryStateCreated() {
            this(new SellableInventoryItemEntryStateEventId());
        }

        public AbstractSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryStateEventId stateEventId) {
            super(stateEventId);
        }

        public AbstractSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryState s) {
            super(s);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static class SimpleSellableInventoryItemEntryStateCreated extends AbstractSellableInventoryItemEntryStateCreated
    {
        public SimpleSellableInventoryItemEntryStateCreated() {
        }

        public SimpleSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryStateEventId stateEventId) {
            super(stateEventId);
        }

        public SimpleSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryState s) {
            super(s);
        }
    }

}

