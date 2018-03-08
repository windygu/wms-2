package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractInventoryItemRequirementEntryMvoStateEvent extends AbstractStateEvent implements InventoryItemRequirementEntryMvoStateEvent 
{
    private InventoryItemRequirementEntryMvoEventId stateEventId;

    public InventoryItemRequirementEntryMvoEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(InventoryItemRequirementEntryMvoEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId() {
        return getStateEventId().getInventoryItemRequirementEntryId();
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId) {
        getStateEventId().setInventoryItemRequirementEntryId(inventoryItemRequirementEntryId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private BigDecimal quantity;

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private InventoryPRTriggeredId sourceEventId;

    public InventoryPRTriggeredId getSourceEventId()
    {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
    {
        this.sourceEventId = sourceEventId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private BigDecimal inventoryItemRequirementQuantity;

    public BigDecimal getInventoryItemRequirementQuantity()
    {
        return this.inventoryItemRequirementQuantity;
    }

    public void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity)
    {
        this.inventoryItemRequirementQuantity = inventoryItemRequirementQuantity;
    }

    private String inventoryItemRequirementCreatedBy;

    public String getInventoryItemRequirementCreatedBy()
    {
        return this.inventoryItemRequirementCreatedBy;
    }

    public void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy)
    {
        this.inventoryItemRequirementCreatedBy = inventoryItemRequirementCreatedBy;
    }

    private Date inventoryItemRequirementCreatedAt;

    public Date getInventoryItemRequirementCreatedAt()
    {
        return this.inventoryItemRequirementCreatedAt;
    }

    public void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt)
    {
        this.inventoryItemRequirementCreatedAt = inventoryItemRequirementCreatedAt;
    }

    private String inventoryItemRequirementUpdatedBy;

    public String getInventoryItemRequirementUpdatedBy()
    {
        return this.inventoryItemRequirementUpdatedBy;
    }

    public void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy)
    {
        this.inventoryItemRequirementUpdatedBy = inventoryItemRequirementUpdatedBy;
    }

    private Date inventoryItemRequirementUpdatedAt;

    public Date getInventoryItemRequirementUpdatedAt()
    {
        return this.inventoryItemRequirementUpdatedAt;
    }

    public void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt)
    {
        this.inventoryItemRequirementUpdatedAt = inventoryItemRequirementUpdatedAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractInventoryItemRequirementEntryMvoStateEvent() {
    }

    protected AbstractInventoryItemRequirementEntryMvoStateEvent(InventoryItemRequirementEntryMvoEventId eventId) {
        this.stateEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractInventoryItemRequirementEntryMvoStateCreated extends AbstractInventoryItemRequirementEntryMvoStateEvent implements InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateCreated
    {
        public AbstractInventoryItemRequirementEntryMvoStateCreated() {
            this(new InventoryItemRequirementEntryMvoEventId());
        }

        public AbstractInventoryItemRequirementEntryMvoStateCreated(InventoryItemRequirementEntryMvoEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractInventoryItemRequirementEntryMvoStateMergePatched extends AbstractInventoryItemRequirementEntryMvoStateEvent implements InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateMergePatched
    {
        public AbstractInventoryItemRequirementEntryMvoStateMergePatched() {
            this(new InventoryItemRequirementEntryMvoEventId());
        }

        public AbstractInventoryItemRequirementEntryMvoStateMergePatched(InventoryItemRequirementEntryMvoEventId eventId) {
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

        private Boolean isPropertySourceEventIdRemoved;

        public Boolean getIsPropertySourceEventIdRemoved() {
            return this.isPropertySourceEventIdRemoved;
        }

        public void setIsPropertySourceEventIdRemoved(Boolean removed) {
            this.isPropertySourceEventIdRemoved = removed;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved() {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed) {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyInventoryItemRequirementQuantityRemoved;

        public Boolean getIsPropertyInventoryItemRequirementQuantityRemoved() {
            return this.isPropertyInventoryItemRequirementQuantityRemoved;
        }

        public void setIsPropertyInventoryItemRequirementQuantityRemoved(Boolean removed) {
            this.isPropertyInventoryItemRequirementQuantityRemoved = removed;
        }

        private Boolean isPropertyInventoryItemRequirementCreatedByRemoved;

        public Boolean getIsPropertyInventoryItemRequirementCreatedByRemoved() {
            return this.isPropertyInventoryItemRequirementCreatedByRemoved;
        }

        public void setIsPropertyInventoryItemRequirementCreatedByRemoved(Boolean removed) {
            this.isPropertyInventoryItemRequirementCreatedByRemoved = removed;
        }

        private Boolean isPropertyInventoryItemRequirementCreatedAtRemoved;

        public Boolean getIsPropertyInventoryItemRequirementCreatedAtRemoved() {
            return this.isPropertyInventoryItemRequirementCreatedAtRemoved;
        }

        public void setIsPropertyInventoryItemRequirementCreatedAtRemoved(Boolean removed) {
            this.isPropertyInventoryItemRequirementCreatedAtRemoved = removed;
        }

        private Boolean isPropertyInventoryItemRequirementUpdatedByRemoved;

        public Boolean getIsPropertyInventoryItemRequirementUpdatedByRemoved() {
            return this.isPropertyInventoryItemRequirementUpdatedByRemoved;
        }

        public void setIsPropertyInventoryItemRequirementUpdatedByRemoved(Boolean removed) {
            this.isPropertyInventoryItemRequirementUpdatedByRemoved = removed;
        }

        private Boolean isPropertyInventoryItemRequirementUpdatedAtRemoved;

        public Boolean getIsPropertyInventoryItemRequirementUpdatedAtRemoved() {
            return this.isPropertyInventoryItemRequirementUpdatedAtRemoved;
        }

        public void setIsPropertyInventoryItemRequirementUpdatedAtRemoved(Boolean removed) {
            this.isPropertyInventoryItemRequirementUpdatedAtRemoved = removed;
        }

    }


    public static class SimpleInventoryItemRequirementEntryMvoStateCreated extends AbstractInventoryItemRequirementEntryMvoStateCreated
    {
        public SimpleInventoryItemRequirementEntryMvoStateCreated() {
        }

        public SimpleInventoryItemRequirementEntryMvoStateCreated(InventoryItemRequirementEntryMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInventoryItemRequirementEntryMvoStateMergePatched extends AbstractInventoryItemRequirementEntryMvoStateMergePatched
    {
        public SimpleInventoryItemRequirementEntryMvoStateMergePatched() {
        }

        public SimpleInventoryItemRequirementEntryMvoStateMergePatched(InventoryItemRequirementEntryMvoEventId eventId) {
            super(eventId);
        }
    }

}

