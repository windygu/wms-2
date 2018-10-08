package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPhysicalInventoryLineEvent extends AbstractEvent implements PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent 
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

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

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

    protected AbstractPhysicalInventoryLineEvent() {
    }

    protected AbstractPhysicalInventoryLineEvent(PhysicalInventoryLineEventId eventId) {
        this.physicalInventoryLineEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractPhysicalInventoryLineStateEvent extends AbstractPhysicalInventoryLineEvent implements PhysicalInventoryLineEvent.PhysicalInventoryLineStateEvent {
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

        private String lineNumber;

        public String getLineNumber()
        {
            return this.lineNumber;
        }

        public void setLineNumber(String lineNumber)
        {
            this.lineNumber = lineNumber;
        }

        private String reversalLineNumber;

        public String getReversalLineNumber()
        {
            return this.reversalLineNumber;
        }

        public void setReversalLineNumber(String reversalLineNumber)
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

        protected AbstractPhysicalInventoryLineStateEvent(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPhysicalInventoryLineStateCreated extends AbstractPhysicalInventoryLineStateEvent implements PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated
    {
        public AbstractPhysicalInventoryLineStateCreated() {
            this(new PhysicalInventoryLineEventId());
        }

        public AbstractPhysicalInventoryLineStateCreated(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPhysicalInventoryLineStateMergePatched extends AbstractPhysicalInventoryLineStateEvent implements PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched
    {
        public AbstractPhysicalInventoryLineStateMergePatched() {
            this(new PhysicalInventoryLineEventId());
        }

        public AbstractPhysicalInventoryLineStateMergePatched(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

        private Boolean isPropertyLineNumberRemoved;

        public Boolean getIsPropertyLineNumberRemoved() {
            return this.isPropertyLineNumberRemoved;
        }

        public void setIsPropertyLineNumberRemoved(Boolean removed) {
            this.isPropertyLineNumberRemoved = removed;
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


    public static abstract class AbstractPhysicalInventoryLineStateRemoved extends AbstractPhysicalInventoryLineStateEvent implements PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved
    {
        public AbstractPhysicalInventoryLineStateRemoved() {
            this(new PhysicalInventoryLineEventId());
        }

        public AbstractPhysicalInventoryLineStateRemoved(PhysicalInventoryLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

