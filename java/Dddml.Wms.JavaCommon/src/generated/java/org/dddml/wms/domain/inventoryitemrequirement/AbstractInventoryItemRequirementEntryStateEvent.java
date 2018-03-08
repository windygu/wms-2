package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryItemRequirementEntryStateEvent extends AbstractStateEvent implements InventoryItemRequirementEntryStateEvent 
{
    private InventoryItemRequirementEntryState state;

    public InventoryItemRequirementEntryState getInventoryItemRequirementEntryState() {
        return state;
    }

    public InventoryItemRequirementEntryEventId getInventoryItemRequirementEntryEventId() {
        InventoryItemRequirementEntryEventId eventId = new InventoryItemRequirementEntryEventId(state.getInventoryItemRequirementId(), state.getEntrySeqId(), InventoryItemRequirementState.VERSION_NULL);
        return eventId;
    }

    public void setInventoryItemRequirementEntryEventId(InventoryItemRequirementEntryEventId eventId) {
        this.state.setInventoryItemRequirementId(eventId.getInventoryItemRequirementId());
        this.state.setEntrySeqId(eventId.getEntrySeqId());
    }

    public Long getEntrySeqId() {
        return getInventoryItemRequirementEntryEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getInventoryItemRequirementEntryEventId().setEntrySeqId(entrySeqId);
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

    public BigDecimal getQuantity()
    {
        return this.state.getQuantity();
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.state.setQuantity(quantity);
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

    protected AbstractInventoryItemRequirementEntryStateEvent() {
        this(new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState());
    }

    protected AbstractInventoryItemRequirementEntryStateEvent(InventoryItemRequirementEntryEventId eventId) {
        this(new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState());
        setInventoryItemRequirementEntryEventId(eventId);
    }

    protected AbstractInventoryItemRequirementEntryStateEvent(InventoryItemRequirementEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryItemRequirementEntryStateCreated extends AbstractInventoryItemRequirementEntryStateEvent implements InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated
    {
        public AbstractInventoryItemRequirementEntryStateCreated() {
            this(new InventoryItemRequirementEntryEventId());
        }

        public AbstractInventoryItemRequirementEntryStateCreated(InventoryItemRequirementEntryEventId eventId) {
            super(eventId);
        }

        public AbstractInventoryItemRequirementEntryStateCreated(InventoryItemRequirementEntryState s) {
            super(s);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static class SimpleInventoryItemRequirementEntryStateCreated extends AbstractInventoryItemRequirementEntryStateCreated
    {
        public SimpleInventoryItemRequirementEntryStateCreated() {
        }

        public SimpleInventoryItemRequirementEntryStateCreated(InventoryItemRequirementEntryEventId eventId) {
            super(eventId);
        }

        public SimpleInventoryItemRequirementEntryStateCreated(InventoryItemRequirementEntryState s) {
            super(s);
        }
    }

}

