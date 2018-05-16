package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class SellableInventoryItemEntryMvoStateDto
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

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
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

    private BigDecimal sellableInventoryItemSellableQuantity;

    public BigDecimal getSellableInventoryItemSellableQuantity()
    {
        return this.sellableInventoryItemSellableQuantity;
    }

    public void setSellableInventoryItemSellableQuantity(BigDecimal sellableInventoryItemSellableQuantity)
    {
        this.sellableInventoryItemSellableQuantity = sellableInventoryItemSellableQuantity;
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

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

