package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchSellableInventoryItemEntryMvoDto extends AbstractSellableInventoryItemEntryMvoCommandDto
{
    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
    }

    private InventoryPRTriggeredIdDto sourceEventId;

    public InventoryPRTriggeredIdDto getSourceEventId()
    {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredIdDto sourceEventId)
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

    private Boolean isPropertySellableQuantityRemoved;

    public Boolean getIsPropertySellableQuantityRemoved()
    {
        return this.isPropertySellableQuantityRemoved;
    }

    public void setIsPropertySellableQuantityRemoved(Boolean removed)
    {
        this.isPropertySellableQuantityRemoved = removed;
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

    private Boolean isPropertySellableInventoryItemSellableQuantityRemoved;

    public Boolean getIsPropertySellableInventoryItemSellableQuantityRemoved()
    {
        return this.isPropertySellableInventoryItemSellableQuantityRemoved;
    }

    public void setIsPropertySellableInventoryItemSellableQuantityRemoved(Boolean removed)
    {
        this.isPropertySellableInventoryItemSellableQuantityRemoved = removed;
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

    public void copyTo(AbstractSellableInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchSellableInventoryItemEntryMvo command)
    {
        ((AbstractSellableInventoryItemEntryMvoCommandDto) this).copyTo(command);
        command.setSellableQuantity(this.getSellableQuantity());
        command.setSourceEventId(this.getSourceEventId() == null ? null : this.getSourceEventId().toInventoryPRTriggeredId());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setSellableInventoryItemSellableQuantity(this.getSellableInventoryItemSellableQuantity());
        command.setSellableInventoryItemCreatedBy(this.getSellableInventoryItemCreatedBy());
        command.setSellableInventoryItemCreatedAt(this.getSellableInventoryItemCreatedAt());
        command.setSellableInventoryItemUpdatedBy(this.getSellableInventoryItemUpdatedBy());
        command.setSellableInventoryItemUpdatedAt(this.getSellableInventoryItemUpdatedAt());
    }

    public SellableInventoryItemEntryMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractSellableInventoryItemEntryMvoCommand.SimpleCreateSellableInventoryItemEntryMvo command = new AbstractSellableInventoryItemEntryMvoCommand.SimpleCreateSellableInventoryItemEntryMvo();
            copyTo((AbstractSellableInventoryItemEntryMvoCommand.AbstractCreateSellableInventoryItemEntryMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractSellableInventoryItemEntryMvoCommand.SimpleMergePatchSellableInventoryItemEntryMvo command = new AbstractSellableInventoryItemEntryMvoCommand.SimpleMergePatchSellableInventoryItemEntryMvo();
            copyTo((AbstractSellableInventoryItemEntryMvoCommand.SimpleMergePatchSellableInventoryItemEntryMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractSellableInventoryItemEntryMvoCommand.AbstractCreateSellableInventoryItemEntryMvo command)
    {
        copyTo((AbstractSellableInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchSellableInventoryItemEntryMvo) command);
    }

    public void copyTo(AbstractSellableInventoryItemEntryMvoCommand.AbstractMergePatchSellableInventoryItemEntryMvo command)
    {
        copyTo((AbstractSellableInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchSellableInventoryItemEntryMvo) command);
        command.setIsPropertySellableQuantityRemoved(this.getIsPropertySellableQuantityRemoved());
        command.setIsPropertySourceEventIdRemoved(this.getIsPropertySourceEventIdRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertySellableInventoryItemSellableQuantityRemoved(this.getIsPropertySellableInventoryItemSellableQuantityRemoved());
        command.setIsPropertySellableInventoryItemCreatedByRemoved(this.getIsPropertySellableInventoryItemCreatedByRemoved());
        command.setIsPropertySellableInventoryItemCreatedAtRemoved(this.getIsPropertySellableInventoryItemCreatedAtRemoved());
        command.setIsPropertySellableInventoryItemUpdatedByRemoved(this.getIsPropertySellableInventoryItemUpdatedByRemoved());
        command.setIsPropertySellableInventoryItemUpdatedAtRemoved(this.getIsPropertySellableInventoryItemUpdatedAtRemoved());
    }

    public static class CreateSellableInventoryItemEntryMvoDto extends CreateOrMergePatchSellableInventoryItemEntryMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo toCreateSellableInventoryItemEntryMvo()
        {
            return (SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo) toCommand();
        }

    }

    public static class MergePatchSellableInventoryItemEntryMvoDto extends CreateOrMergePatchSellableInventoryItemEntryMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo toMergePatchSellableInventoryItemEntryMvo()
        {
            return (SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo) toCommand();
        }

    }

}

