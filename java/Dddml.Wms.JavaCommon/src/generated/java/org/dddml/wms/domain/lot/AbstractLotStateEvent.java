package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractLotStateEvent extends AbstractStateEvent implements LotStateEvent 
{
    private LotEventId stateEventId;

    public LotEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(LotEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public String getLotId() {
        return getStateEventId().getLotId();
    }

    public void setLotId(String lotId) {
        getStateEventId().setLotId(lotId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.sql.Timestamp expirationDate;

    public java.sql.Timestamp getExpirationDate()
    {
        return this.expirationDate;
    }

    public void setExpirationDate(java.sql.Timestamp expirationDate)
    {
        this.expirationDate = expirationDate;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractLotStateEvent() {
    }

    protected AbstractLotStateEvent(LotEventId eventId) {
        this.stateEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractLotStateCreated extends AbstractLotStateEvent implements LotStateEvent.LotStateCreated
    {
        public AbstractLotStateCreated() {
            this(new LotEventId());
        }

        public AbstractLotStateCreated(LotEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractLotStateMergePatched extends AbstractLotStateEvent implements LotStateEvent.LotStateMergePatched
    {
        public AbstractLotStateMergePatched() {
            this(new LotEventId());
        }

        public AbstractLotStateMergePatched(LotEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyExpirationDateRemoved;

        public Boolean getIsPropertyExpirationDateRemoved() {
            return this.isPropertyExpirationDateRemoved;
        }

        public void setIsPropertyExpirationDateRemoved(Boolean removed) {
            this.isPropertyExpirationDateRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractLotStateDeleted extends AbstractLotStateEvent implements LotStateEvent.LotStateDeleted
    {
        public AbstractLotStateDeleted() {
            this(new LotEventId());
        }

        public AbstractLotStateDeleted(LotEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleLotStateCreated extends AbstractLotStateCreated
    {
        public SimpleLotStateCreated() {
        }

        public SimpleLotStateCreated(LotEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleLotStateMergePatched extends AbstractLotStateMergePatched
    {
        public SimpleLotStateMergePatched() {
        }

        public SimpleLotStateMergePatched(LotEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleLotStateDeleted extends AbstractLotStateDeleted
    {
        public SimpleLotStateDeleted() {
        }

        public SimpleLotStateDeleted(LotEventId eventId) {
            super(eventId);
        }
    }

}

