package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInventoryItemEntryEvent extends AbstractEvent implements InventoryItemEntryEvent.SqlInventoryItemEntryEvent 
{
    private InventoryItemEntryState.MutableInventoryItemEntryState state;

    public InventoryItemEntryState.MutableInventoryItemEntryState getInventoryItemEntryState() {
        return state;
    }

    public InventoryItemEntryEventId getInventoryItemEntryEventId() {
        InventoryItemEntryEventId eventId = new InventoryItemEntryEventId(state.getInventoryItemId(), state.getEntrySeqId(), InventoryItemState.VERSION_NULL);
        return eventId;
    }

    public void setInventoryItemEntryEventId(InventoryItemEntryEventId eventId) {
        this.state.setInventoryItemId(eventId.getInventoryItemId());
        this.state.setEntrySeqId(eventId.getEntrySeqId());
    }

    public Long getEntrySeqId() {
        return getInventoryItemEntryEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getInventoryItemEntryEventId().setEntrySeqId(entrySeqId);
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

    protected AbstractInventoryItemEntryEvent() {
        this(new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState());
    }

    protected AbstractInventoryItemEntryEvent(InventoryItemEntryEventId eventId) {
        this(new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState());
        setInventoryItemEntryEventId(eventId);
    }

    protected AbstractInventoryItemEntryEvent(InventoryItemEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = (InventoryItemEntryState.MutableInventoryItemEntryState)s;
    }


    public abstract String getEventType();


    public static abstract class AbstractInventoryItemEntryStateEvent extends AbstractInventoryItemEntryEvent implements InventoryItemEntryEvent.InventoryItemEntryStateEvent {
        public Long getVersion()
        {
            return this.getInventoryItemEntryState().getVersion();
        }

        public void setVersion(Long version)
        {
            this.getInventoryItemEntryState().setVersion(version);
        }

        public BigDecimal getOnHandQuantity()
        {
            return this.getInventoryItemEntryState().getOnHandQuantity();
        }

        public void setOnHandQuantity(BigDecimal onHandQuantity)
        {
            this.getInventoryItemEntryState().setOnHandQuantity(onHandQuantity);
        }

        public BigDecimal getInTransitQuantity()
        {
            return this.getInventoryItemEntryState().getInTransitQuantity();
        }

        public void setInTransitQuantity(BigDecimal inTransitQuantity)
        {
            this.getInventoryItemEntryState().setInTransitQuantity(inTransitQuantity);
        }

        public BigDecimal getReservedQuantity()
        {
            return this.getInventoryItemEntryState().getReservedQuantity();
        }

        public void setReservedQuantity(BigDecimal reservedQuantity)
        {
            this.getInventoryItemEntryState().setReservedQuantity(reservedQuantity);
        }

        public BigDecimal getOccupiedQuantity()
        {
            return this.getInventoryItemEntryState().getOccupiedQuantity();
        }

        public void setOccupiedQuantity(BigDecimal occupiedQuantity)
        {
            this.getInventoryItemEntryState().setOccupiedQuantity(occupiedQuantity);
        }

        public BigDecimal getVirtualQuantity()
        {
            return this.getInventoryItemEntryState().getVirtualQuantity();
        }

        public void setVirtualQuantity(BigDecimal virtualQuantity)
        {
            this.getInventoryItemEntryState().setVirtualQuantity(virtualQuantity);
        }

        public InventoryItemSourceInfo getSource()
        {
            return this.getInventoryItemEntryState().getSource();
        }

        public void setSource(InventoryItemSourceInfo source)
        {
            this.getInventoryItemEntryState().setSource(source);
        }

        public java.sql.Timestamp getOccurredAt()
        {
            return this.getInventoryItemEntryState().getOccurredAt();
        }

        public void setOccurredAt(java.sql.Timestamp occurredAt)
        {
            this.getInventoryItemEntryState().setOccurredAt(occurredAt);
        }

        protected AbstractInventoryItemEntryStateEvent(InventoryItemEntryEventId eventId) {
            super(eventId);
        }

        public AbstractInventoryItemEntryStateEvent(InventoryItemEntryState s) {
            super(s);
        }
    }

    public static abstract class AbstractInventoryItemEntryStateCreated extends AbstractInventoryItemEntryStateEvent implements InventoryItemEntryEvent.InventoryItemEntryStateCreated
    {
        public AbstractInventoryItemEntryStateCreated() {
            this(new InventoryItemEntryEventId());
        }

        public AbstractInventoryItemEntryStateCreated(InventoryItemEntryEventId eventId) {
            super(eventId);
        }

        public AbstractInventoryItemEntryStateCreated(InventoryItemEntryState s) {
            super(s);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static class SimpleInventoryItemEntryStateCreated extends AbstractInventoryItemEntryStateCreated
    {
        public SimpleInventoryItemEntryStateCreated() {
        }

        public SimpleInventoryItemEntryStateCreated(InventoryItemEntryEventId eventId) {
            super(eventId);
        }

        public SimpleInventoryItemEntryStateCreated(InventoryItemEntryState s) {
            super(s);
        }
    }

}

