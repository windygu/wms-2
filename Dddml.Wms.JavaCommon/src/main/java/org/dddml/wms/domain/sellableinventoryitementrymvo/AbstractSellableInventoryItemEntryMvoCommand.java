package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractSellableInventoryItemEntryMvoCommand extends AbstractCommand implements SellableInventoryItemEntryMvoCommand
{
    private SellableInventoryItemEntryId sellableInventoryItemEntryId;

    public SellableInventoryItemEntryId getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }


    public static abstract class AbstractCreateOrMergePatchSellableInventoryItemEntryMvo extends AbstractSellableInventoryItemEntryMvoCommand implements CreateOrMergePatchSellableInventoryItemEntryMvo
    {
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
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

    }

    public static abstract class AbstractCreateSellableInventoryItemEntryMvo extends AbstractCreateOrMergePatchSellableInventoryItemEntryMvo implements CreateSellableInventoryItemEntryMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchSellableInventoryItemEntryMvo extends AbstractCreateOrMergePatchSellableInventoryItemEntryMvo implements MergePatchSellableInventoryItemEntryMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyQuantitySellableRemoved;

        public Boolean getIsPropertyQuantitySellableRemoved()
        {
            return this.isPropertyQuantitySellableRemoved;
        }

        public void setIsPropertyQuantitySellableRemoved(Boolean removed)
        {
            this.isPropertyQuantitySellableRemoved = removed;
        }

        private Boolean isPropertySourceEventIdRemoved;

        public Boolean getIsPropertySourceEventIdRemoved()
        {
            return this.isPropertySourceEventIdRemoved;
        }

        public void setIsPropertySourceEventIdRemoved(Boolean removed)
        {
            this.isPropertySourceEventIdRemoved = removed;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved()
        {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed)
        {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemQuantitySellableRemoved;

        public Boolean getIsPropertySellableInventoryItemQuantitySellableRemoved()
        {
            return this.isPropertySellableInventoryItemQuantitySellableRemoved;
        }

        public void setIsPropertySellableInventoryItemQuantitySellableRemoved(Boolean removed)
        {
            this.isPropertySellableInventoryItemQuantitySellableRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemCreatedByRemoved;

        public Boolean getIsPropertySellableInventoryItemCreatedByRemoved()
        {
            return this.isPropertySellableInventoryItemCreatedByRemoved;
        }

        public void setIsPropertySellableInventoryItemCreatedByRemoved(Boolean removed)
        {
            this.isPropertySellableInventoryItemCreatedByRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemCreatedAtRemoved;

        public Boolean getIsPropertySellableInventoryItemCreatedAtRemoved()
        {
            return this.isPropertySellableInventoryItemCreatedAtRemoved;
        }

        public void setIsPropertySellableInventoryItemCreatedAtRemoved(Boolean removed)
        {
            this.isPropertySellableInventoryItemCreatedAtRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemUpdatedByRemoved;

        public Boolean getIsPropertySellableInventoryItemUpdatedByRemoved()
        {
            return this.isPropertySellableInventoryItemUpdatedByRemoved;
        }

        public void setIsPropertySellableInventoryItemUpdatedByRemoved(Boolean removed)
        {
            this.isPropertySellableInventoryItemUpdatedByRemoved = removed;
        }

        private Boolean isPropertySellableInventoryItemUpdatedAtRemoved;

        public Boolean getIsPropertySellableInventoryItemUpdatedAtRemoved()
        {
            return this.isPropertySellableInventoryItemUpdatedAtRemoved;
        }

        public void setIsPropertySellableInventoryItemUpdatedAtRemoved(Boolean removed)
        {
            this.isPropertySellableInventoryItemUpdatedAtRemoved = removed;
        }

    }

    public static class SimpleCreateSellableInventoryItemEntryMvo extends AbstractCreateSellableInventoryItemEntryMvo
    {
    }

    
    public static class SimpleMergePatchSellableInventoryItemEntryMvo extends AbstractMergePatchSellableInventoryItemEntryMvo
    {
    }

    
	public static class SimpleDeleteSellableInventoryItemEntryMvo extends AbstractSellableInventoryItemEntryMvoCommand implements DeleteSellableInventoryItemEntryMvo
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

