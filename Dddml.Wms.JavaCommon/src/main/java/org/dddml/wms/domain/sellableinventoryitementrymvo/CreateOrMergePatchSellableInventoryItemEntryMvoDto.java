package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchSellableInventoryItemEntryMvoDto extends AbstractSellableInventoryItemEntryMvoCommandDto
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

    public void copyTo(AbstractSellableInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchSellableInventoryItemEntryMvo command)
    {
        ((AbstractSellableInventoryItemEntryMvoCommandDto) this).copyTo(command);
        command.setQuantitySellable(this.getQuantitySellable());
        command.setSourceEventId(this.getSourceEventId() == null ? null : this.getSourceEventId().toInventoryPRTriggeredId());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setSellableInventoryItemQuantitySellable(this.getSellableInventoryItemQuantitySellable());
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
        command.setIsPropertyQuantitySellableRemoved(this.getIsPropertyQuantitySellableRemoved());
        command.setIsPropertySourceEventIdRemoved(this.getIsPropertySourceEventIdRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertySellableInventoryItemQuantitySellableRemoved(this.getIsPropertySellableInventoryItemQuantitySellableRemoved());
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

