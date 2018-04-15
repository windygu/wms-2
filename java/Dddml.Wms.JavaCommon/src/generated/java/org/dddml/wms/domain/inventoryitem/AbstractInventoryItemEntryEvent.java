package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInventoryItemEntryEvent extends AbstractEvent implements InventoryItemEntryEvent 
{
    private InventoryItemEntryState state;

    public InventoryItemEntryState getInventoryItemEntryState() {
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

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    public Long getVersion()
    {
        return this.state.getVersion();
    }

    public void setVersion(Long version)
    {
        this.state.setVersion(version);
    }

    public BigDecimal getOnHandQuantity()
    {
        return this.state.getOnHandQuantity();
    }

    public void setOnHandQuantity(BigDecimal onHandQuantity)
    {
        this.state.setOnHandQuantity(onHandQuantity);
    }

    public BigDecimal getInTransitQuantity()
    {
        return this.state.getInTransitQuantity();
    }

    public void setInTransitQuantity(BigDecimal inTransitQuantity)
    {
        this.state.setInTransitQuantity(inTransitQuantity);
    }

    public BigDecimal getReservedQuantity()
    {
        return this.state.getReservedQuantity();
    }

    public void setReservedQuantity(BigDecimal reservedQuantity)
    {
        this.state.setReservedQuantity(reservedQuantity);
    }

    public BigDecimal getOccupiedQuantity()
    {
        return this.state.getOccupiedQuantity();
    }

    public void setOccupiedQuantity(BigDecimal occupiedQuantity)
    {
        this.state.setOccupiedQuantity(occupiedQuantity);
    }

    public BigDecimal getVirtualQuantity()
    {
        return this.state.getVirtualQuantity();
    }

    public void setVirtualQuantity(BigDecimal virtualQuantity)
    {
        this.state.setVirtualQuantity(virtualQuantity);
    }

    public InventoryItemSourceInfo getSource()
    {
        return this.state.getSource();
    }

    public void setSource(InventoryItemSourceInfo source)
    {
        this.state.setSource(source);
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

    protected AbstractInventoryItemEntryEvent() {
        this(new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState());
    }

    protected AbstractInventoryItemEntryEvent(InventoryItemEntryEventId eventId) {
        this(new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState());
        setInventoryItemEntryEventId(eventId);
    }

    protected AbstractInventoryItemEntryEvent(InventoryItemEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getEventType();


    public static abstract class AbstractInventoryItemEntryStateCreated extends AbstractInventoryItemEntryEvent implements InventoryItemEntryEvent.InventoryItemEntryStateCreated
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

