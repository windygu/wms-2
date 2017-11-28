package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryItemEntryStateEvent extends AbstractStateEvent implements InventoryItemEntryStateEvent 
{
    private InventoryItemEntryState state;

    public InventoryItemEntryState getInventoryItemEntryState() {
        return state;
    }

    public InventoryItemEntryStateEventId getStateEventId() {
        InventoryItemEntryStateEventId eventId = new InventoryItemEntryStateEventId(state.getInventoryItemId(), state.getEntrySeqId(), InventoryItemState.VERSION_NULL);
        return eventId;
    }

    public void setStateEventId(InventoryItemEntryStateEventId stateEventId) {
        this.state.setInventoryItemId(stateEventId.getInventoryItemId());
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

    public BigDecimal getQuantityOnHandVar()
    {
        return this.state.getQuantityOnHandVar();
    }

    public void setQuantityOnHandVar(BigDecimal quantityOnHandVar)
    {
        this.state.setQuantityOnHandVar(quantityOnHandVar);
    }

    public BigDecimal getQuantityReservedVar()
    {
        return this.state.getQuantityReservedVar();
    }

    public void setQuantityReservedVar(BigDecimal quantityReservedVar)
    {
        this.state.setQuantityReservedVar(quantityReservedVar);
    }

    public BigDecimal getQuantityOccupiedVar()
    {
        return this.state.getQuantityOccupiedVar();
    }

    public void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar)
    {
        this.state.setQuantityOccupiedVar(quantityOccupiedVar);
    }

    public BigDecimal getQuantityVirtualVar()
    {
        return this.state.getQuantityVirtualVar();
    }

    public void setQuantityVirtualVar(BigDecimal quantityVirtualVar)
    {
        this.state.setQuantityVirtualVar(quantityVirtualVar);
    }

    public InventoryItemEventVO getEventVO()
    {
        return this.state.getEventVO();
    }

    public void setEventVO(InventoryItemEventVO eventVO)
    {
        this.state.setEventVO(eventVO);
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

    public Boolean getActive()
    {
        return this.state.getActive();
    }

    public void setActive(Boolean active)
    {
        this.state.setActive(active);
    }


    public String getCommandId() {
        return this.state.getCommandId();
    }

    public void setCommandId(String commandId) {
        this.state.setCommandId(commandId);
    }

    protected AbstractInventoryItemEntryStateEvent() {
        this(new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState());
    }

    protected AbstractInventoryItemEntryStateEvent(InventoryItemEntryStateEventId stateEventId) {
        this(new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState());
        setStateEventId(stateEventId);
    }

    protected AbstractInventoryItemEntryStateEvent(InventoryItemEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryItemEntryStateCreated extends AbstractInventoryItemEntryStateEvent implements InventoryItemEntryStateEvent.InventoryItemEntryStateCreated
    {
        public AbstractInventoryItemEntryStateCreated() {
            this(new InventoryItemEntryStateEventId());
        }

        public AbstractInventoryItemEntryStateCreated(InventoryItemEntryStateEventId stateEventId) {
            super(stateEventId);
        }

        public AbstractInventoryItemEntryStateCreated(InventoryItemEntryState s) {
            super(s);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static class SimpleInventoryItemEntryStateCreated extends AbstractInventoryItemEntryStateCreated
    {
        public SimpleInventoryItemEntryStateCreated() {
        }

        public SimpleInventoryItemEntryStateCreated(InventoryItemEntryStateEventId stateEventId) {
            super(stateEventId);
        }

        public SimpleInventoryItemEntryStateCreated(InventoryItemEntryState s) {
            super(s);
        }
    }

}

