package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractSellableInventoryItemEntryMvoStateEvent extends AbstractStateEvent implements SellableInventoryItemEntryMvoStateEvent 
{
    private SellableInventoryItemEntryMvoStateEventId stateEventId;

    public SellableInventoryItemEntryMvoStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(SellableInventoryItemEntryMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public SellableInventoryItemEntryId getSellableInventoryItemEntryId() {
        return getStateEventId().getSellableInventoryItemEntryId();
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId) {
        getStateEventId().setSellableInventoryItemEntryId(sellableInventoryItemEntryId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private BigDecimal quantitySellable;

    public BigDecimal getQuantitySellable()
    {
        return this.quantitySellable;
    }

    public void setQuantitySellable(BigDecimal quantitySellable)
    {
        this.quantitySellable = quantitySellable;
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

    private BigDecimal sellableInventoryItemQuantitySellable;

    public BigDecimal getSellableInventoryItemQuantitySellable()
    {
        return this.sellableInventoryItemQuantitySellable;
    }

    public void setSellableInventoryItemQuantitySellable(BigDecimal sellableInventoryItemQuantitySellable)
    {
        this.sellableInventoryItemQuantitySellable = sellableInventoryItemQuantitySellable;
    }

    private String sellableInventoryItemCreatedBy;

    public String getSellableInventoryItemCreatedBy()
    {
        return this.sellableInventoryItemCreatedBy;
    }

    public void setSellableInventoryItemCreatedBy(String sellableInventoryItemCreatedBy)
    {
        this.sellableInventoryItemCreatedBy = sellableInventoryItemCreatedBy;
    }

    private Date sellableInventoryItemCreatedAt;

    public Date getSellableInventoryItemCreatedAt()
    {
        return this.sellableInventoryItemCreatedAt;
    }

    public void setSellableInventoryItemCreatedAt(Date sellableInventoryItemCreatedAt)
    {
        this.sellableInventoryItemCreatedAt = sellableInventoryItemCreatedAt;
    }

    private String sellableInventoryItemUpdatedBy;

    public String getSellableInventoryItemUpdatedBy()
    {
        return this.sellableInventoryItemUpdatedBy;
    }

    public void setSellableInventoryItemUpdatedBy(String sellableInventoryItemUpdatedBy)
    {
        this.sellableInventoryItemUpdatedBy = sellableInventoryItemUpdatedBy;
    }

    private Date sellableInventoryItemUpdatedAt;

    public Date getSellableInventoryItemUpdatedAt()
    {
        return this.sellableInventoryItemUpdatedAt;
    }

    public void setSellableInventoryItemUpdatedAt(Date sellableInventoryItemUpdatedAt)
    {
        this.sellableInventoryItemUpdatedAt = sellableInventoryItemUpdatedAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractSellableInventoryItemEntryMvoStateEvent() {
    }

    protected AbstractSellableInventoryItemEntryMvoStateEvent(SellableInventoryItemEntryMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractSellableInventoryItemEntryMvoStateCreated extends AbstractSellableInventoryItemEntryMvoStateEvent implements SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated
    {
        public AbstractSellableInventoryItemEntryMvoStateCreated() {
            this(new SellableInventoryItemEntryMvoStateEventId());
        }

        public AbstractSellableInventoryItemEntryMvoStateCreated(SellableInventoryItemEntryMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractSellableInventoryItemEntryMvoStateMergePatched extends AbstractSellableInventoryItemEntryMvoStateEvent implements SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched
    {
        public AbstractSellableInventoryItemEntryMvoStateMergePatched() {
            this(new SellableInventoryItemEntryMvoStateEventId());
        }

        public AbstractSellableInventoryItemEntryMvoStateMergePatched(SellableInventoryItemEntryMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantitySellableRemoved;

        public Boolean getIsPropertyQuantitySellableRemoved() {
            return this.isPropertyQuantitySellableRemoved;
        }

        public void setIsPropertyQuantitySellableRemoved(Boolean removed) {
            this.isPropertyQuantitySellableRemoved = removed;
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

        private Boolean isPropertySellableInventoryItemQuantitySellableRemoved;

        public Boolean getIsPropertySellableInventoryItemQuantitySellableRemoved() {
            return this.isPropertySellableInventoryItemQuantitySellableRemoved;
        }

        public void setIsPropertySellableInventoryItemQuantitySellableRemoved(Boolean removed) {
            this.isPropertySellableInventoryItemQuantitySellableRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemCreatedByRemoved;

        public Boolean getIsPropertySellableInventoryItemCreatedByRemoved() {
            return this.isPropertySellableInventoryItemCreatedByRemoved;
        }

        public void setIsPropertySellableInventoryItemCreatedByRemoved(Boolean removed) {
            this.isPropertySellableInventoryItemCreatedByRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemCreatedAtRemoved;

        public Boolean getIsPropertySellableInventoryItemCreatedAtRemoved() {
            return this.isPropertySellableInventoryItemCreatedAtRemoved;
        }

        public void setIsPropertySellableInventoryItemCreatedAtRemoved(Boolean removed) {
            this.isPropertySellableInventoryItemCreatedAtRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemUpdatedByRemoved;

        public Boolean getIsPropertySellableInventoryItemUpdatedByRemoved() {
            return this.isPropertySellableInventoryItemUpdatedByRemoved;
        }

        public void setIsPropertySellableInventoryItemUpdatedByRemoved(Boolean removed) {
            this.isPropertySellableInventoryItemUpdatedByRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemUpdatedAtRemoved;

        public Boolean getIsPropertySellableInventoryItemUpdatedAtRemoved() {
            return this.isPropertySellableInventoryItemUpdatedAtRemoved;
        }

        public void setIsPropertySellableInventoryItemUpdatedAtRemoved(Boolean removed) {
            this.isPropertySellableInventoryItemUpdatedAtRemoved = removed;
        }

    }


    public static class SimpleSellableInventoryItemEntryMvoStateCreated extends AbstractSellableInventoryItemEntryMvoStateCreated
    {
        public SimpleSellableInventoryItemEntryMvoStateCreated() {
        }

        public SimpleSellableInventoryItemEntryMvoStateCreated(SellableInventoryItemEntryMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleSellableInventoryItemEntryMvoStateMergePatched extends AbstractSellableInventoryItemEntryMvoStateMergePatched
    {
        public SimpleSellableInventoryItemEntryMvoStateMergePatched() {
        }

        public SimpleSellableInventoryItemEntryMvoStateMergePatched(SellableInventoryItemEntryMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

