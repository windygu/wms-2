package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractLotEvent extends AbstractEvent implements LotEvent.SqlLotEvent 
{
    private LotEventId lotEventId;

    public LotEventId getLotEventId() {
        return this.lotEventId;
    }

    public void setLotEventId(LotEventId eventId) {
        this.lotEventId = eventId;
    }
    
    public String getLotId() {
        return getLotEventId().getLotId();
    }

    public void setLotId(String lotId) {
        getLotEventId().setLotId(lotId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getLotEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getLotEventId().setVersion(version);
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

    protected AbstractLotEvent() {
    }

    protected AbstractLotEvent(LotEventId eventId) {
        this.lotEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractLotStateEvent extends AbstractLotEvent implements LotEvent.LotStateEvent {
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractLotStateEvent(LotEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractLotStateCreated extends AbstractLotStateEvent implements LotEvent.LotStateCreated
    {
        public AbstractLotStateCreated() {
            this(new LotEventId());
        }

        public AbstractLotStateCreated(LotEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractLotStateMergePatched extends AbstractLotStateEvent implements LotEvent.LotStateMergePatched
    {
        public AbstractLotStateMergePatched() {
            this(new LotEventId());
        }

        public AbstractLotStateMergePatched(LotEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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


    public static abstract class AbstractLotStateDeleted extends AbstractLotStateEvent implements LotEvent.LotStateDeleted
    {
        public AbstractLotStateDeleted() {
            this(new LotEventId());
        }

        public AbstractLotStateDeleted(LotEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

