package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInventoryItemRequirementEntryEvent extends AbstractEvent implements InventoryItemRequirementEntryEvent.SqlInventoryItemRequirementEntryEvent 
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

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractInventoryItemRequirementEntryEvent() {
        this(new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState());
    }

    protected AbstractInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryEventId eventId) {
        this(new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState());
        setInventoryItemRequirementEntryEventId(eventId);
    }

    protected AbstractInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryState s) {
        if (s == null) { throw new IllegalArgumentException(); }
        this.state = s;
    }


    public abstract String getEventType();


    public static abstract class AbstractInventoryItemRequirementEntryStateEvent extends AbstractInventoryItemRequirementEntryEvent implements InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateEvent {
        public Long getVersion()
        {
            return this.getInventoryItemRequirementEntryState().getVersion();
        }

        public void setVersion(Long version)
        {
            this.getInventoryItemRequirementEntryState().setVersion(version);
        }

        public BigDecimal getQuantity()
        {
            return this.getInventoryItemRequirementEntryState().getQuantity();
        }

        public void setQuantity(BigDecimal quantity)
        {
            this.getInventoryItemRequirementEntryState().setQuantity(quantity);
        }

        public InventoryPRTriggeredId getSourceEventId()
        {
            return this.getInventoryItemRequirementEntryState().getSourceEventId();
        }

        public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
        {
            this.getInventoryItemRequirementEntryState().setSourceEventId(sourceEventId);
        }

        protected AbstractInventoryItemRequirementEntryStateEvent(InventoryItemRequirementEntryEventId eventId) {
            super(eventId);
        }

        public AbstractInventoryItemRequirementEntryStateEvent(InventoryItemRequirementEntryState s) {
            super(s);
        }
    }

    public static abstract class AbstractInventoryItemRequirementEntryStateCreated extends AbstractInventoryItemRequirementEntryStateEvent implements InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated
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

        public String getEventType() {
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

