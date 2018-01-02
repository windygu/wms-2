package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractLotStateEvent extends AbstractStateEvent implements LotStateEvent 
{
    private LotStateEventId stateEventId;

    public LotStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(LotStateEventId stateEventId) {
        this.stateEventId = stateEventId;
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

    private java.sql.Timestamp creationDate;

    public java.sql.Timestamp getCreationDate()
    {
        return this.creationDate;
    }

    public void setCreationDate(java.sql.Timestamp creationDate)
    {
        this.creationDate = creationDate;
    }

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

    protected AbstractLotStateEvent(LotStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractLotStateCreated extends AbstractLotStateEvent implements LotStateEvent.LotStateCreated
    {
        public AbstractLotStateCreated() {
            this(new LotStateEventId());
        }

        public AbstractLotStateCreated(LotStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractLotStateMergePatched extends AbstractLotStateEvent implements LotStateEvent.LotStateMergePatched
    {
        public AbstractLotStateMergePatched() {
            this(new LotStateEventId());
        }

        public AbstractLotStateMergePatched(LotStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyCreationDateRemoved;

        public Boolean getIsPropertyCreationDateRemoved() {
            return this.isPropertyCreationDateRemoved;
        }

        public void setIsPropertyCreationDateRemoved(Boolean removed) {
            this.isPropertyCreationDateRemoved = removed;
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
            this(new LotStateEventId());
        }

        public AbstractLotStateDeleted(LotStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleLotStateCreated extends AbstractLotStateCreated
    {
        public SimpleLotStateCreated() {
        }

        public SimpleLotStateCreated(LotStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleLotStateMergePatched extends AbstractLotStateMergePatched
    {
        public SimpleLotStateMergePatched() {
        }

        public SimpleLotStateMergePatched(LotStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleLotStateDeleted extends AbstractLotStateDeleted
    {
        public SimpleLotStateDeleted() {
        }

        public SimpleLotStateDeleted(LotStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

