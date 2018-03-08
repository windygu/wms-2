package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPhysicalInventoryLineStateEvent extends AbstractStateEvent implements PhysicalInventoryLineStateEvent 
{
    private PhysicalInventoryLineEventId physicalInventoryLineEventId;

    public PhysicalInventoryLineEventId getPhysicalInventoryLineEventId() {
        return this.physicalInventoryLineEventId;
    }

    public void setPhysicalInventoryLineEventId(PhysicalInventoryLineEventId eventId) {
        this.physicalInventoryLineEventId = eventId;
    }
    
    public InventoryItemId getInventoryItemId() {
        return getPhysicalInventoryLineEventId().getInventoryItemId();
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId) {
        getPhysicalInventoryLineEventId().setInventoryItemId(inventoryItemId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity()
    {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity)
    {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity()
    {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity)
    {
        this.countedQuantity = countedQuantity;
    }

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractPhysicalInventoryLineStateEvent() {
    }

    protected AbstractPhysicalInventoryLineStateEvent(PhysicalInventoryLineEventId eventId) {
        this.physicalInventoryLineEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPhysicalInventoryLineStateCreated extends AbstractPhysicalInventoryLineStateEvent implements PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated
    {
        public AbstractPhysicalInventoryLineStateCreated() {
            this(new PhysicalInventoryLineEventId());
        }

        public AbstractPhysicalInventoryLineStateCreated(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPhysicalInventoryLineStateMergePatched extends AbstractPhysicalInventoryLineStateEvent implements PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched
    {
        public AbstractPhysicalInventoryLineStateMergePatched() {
            this(new PhysicalInventoryLineEventId());
        }

        public AbstractPhysicalInventoryLineStateMergePatched(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyBookQuantityRemoved;

        public Boolean getIsPropertyBookQuantityRemoved() {
            return this.isPropertyBookQuantityRemoved;
        }

        public void setIsPropertyBookQuantityRemoved(Boolean removed) {
            this.isPropertyBookQuantityRemoved = removed;
        }

        private Boolean isPropertyCountedQuantityRemoved;

        public Boolean getIsPropertyCountedQuantityRemoved() {
            return this.isPropertyCountedQuantityRemoved;
        }

        public void setIsPropertyCountedQuantityRemoved(Boolean removed) {
            this.isPropertyCountedQuantityRemoved = removed;
        }

        private Boolean isPropertyProcessedRemoved;

        public Boolean getIsPropertyProcessedRemoved() {
            return this.isPropertyProcessedRemoved;
        }

        public void setIsPropertyProcessedRemoved(Boolean removed) {
            this.isPropertyProcessedRemoved = removed;
        }

        private Boolean isPropertyReversalLineNumberRemoved;

        public Boolean getIsPropertyReversalLineNumberRemoved() {
            return this.isPropertyReversalLineNumberRemoved;
        }

        public void setIsPropertyReversalLineNumberRemoved(Boolean removed) {
            this.isPropertyReversalLineNumberRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

    }


    public static abstract class AbstractPhysicalInventoryLineStateRemoved extends AbstractPhysicalInventoryLineStateEvent implements PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved
    {
        public AbstractPhysicalInventoryLineStateRemoved() {
            this(new PhysicalInventoryLineEventId());
        }

        public AbstractPhysicalInventoryLineStateRemoved(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimplePhysicalInventoryLineStateCreated extends AbstractPhysicalInventoryLineStateCreated
    {
        public SimplePhysicalInventoryLineStateCreated() {
        }

        public SimplePhysicalInventoryLineStateCreated(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePhysicalInventoryLineStateMergePatched extends AbstractPhysicalInventoryLineStateMergePatched
    {
        public SimplePhysicalInventoryLineStateMergePatched() {
        }

        public SimplePhysicalInventoryLineStateMergePatched(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePhysicalInventoryLineStateRemoved extends AbstractPhysicalInventoryLineStateRemoved
    {
        public SimplePhysicalInventoryLineStateRemoved() {
        }

        public SimplePhysicalInventoryLineStateRemoved(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }
    }

}

