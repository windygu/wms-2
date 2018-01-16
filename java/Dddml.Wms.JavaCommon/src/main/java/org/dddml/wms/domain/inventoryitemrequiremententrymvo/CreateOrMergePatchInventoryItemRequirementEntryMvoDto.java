package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemRequirementEntryMvoDto extends AbstractInventoryItemRequirementEntryMvoCommandDto
{
    private BigDecimal quantity;

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
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

    private Boolean isPropertyInventoryItemRequirementQuantityRemoved;

    public Boolean getIsPropertyInventoryItemRequirementQuantityRemoved()
    {
        return this.isPropertyInventoryItemRequirementQuantityRemoved;
    }

    public void setIsPropertyInventoryItemRequirementQuantityRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemRequirementQuantityRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementCreatedByRemoved;

    public Boolean getIsPropertyInventoryItemRequirementCreatedByRemoved()
    {
        return this.isPropertyInventoryItemRequirementCreatedByRemoved;
    }

    public void setIsPropertyInventoryItemRequirementCreatedByRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemRequirementCreatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementCreatedAtRemoved;

    public Boolean getIsPropertyInventoryItemRequirementCreatedAtRemoved()
    {
        return this.isPropertyInventoryItemRequirementCreatedAtRemoved;
    }

    public void setIsPropertyInventoryItemRequirementCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemRequirementCreatedAtRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementUpdatedByRemoved;

    public Boolean getIsPropertyInventoryItemRequirementUpdatedByRemoved()
    {
        return this.isPropertyInventoryItemRequirementUpdatedByRemoved;
    }

    public void setIsPropertyInventoryItemRequirementUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemRequirementUpdatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementUpdatedAtRemoved;

    public Boolean getIsPropertyInventoryItemRequirementUpdatedAtRemoved()
    {
        return this.isPropertyInventoryItemRequirementUpdatedAtRemoved;
    }

    public void setIsPropertyInventoryItemRequirementUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemRequirementUpdatedAtRemoved = removed;
    }

    public void copyTo(AbstractInventoryItemRequirementEntryMvoCommand.AbstractCreateOrMergePatchInventoryItemRequirementEntryMvo command)
    {
        ((AbstractInventoryItemRequirementEntryMvoCommandDto) this).copyTo(command);
        command.setQuantity(this.getQuantity());
        command.setSourceEventId(this.getSourceEventId() == null ? null : this.getSourceEventId().toInventoryPRTriggeredId());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setInventoryItemRequirementQuantity(this.getInventoryItemRequirementQuantity());
        command.setInventoryItemRequirementCreatedBy(this.getInventoryItemRequirementCreatedBy());
        command.setInventoryItemRequirementCreatedAt(this.getInventoryItemRequirementCreatedAt());
        command.setInventoryItemRequirementUpdatedBy(this.getInventoryItemRequirementUpdatedBy());
        command.setInventoryItemRequirementUpdatedAt(this.getInventoryItemRequirementUpdatedAt());
    }

    public InventoryItemRequirementEntryMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemRequirementEntryMvoCommand.SimpleCreateInventoryItemRequirementEntryMvo command = new AbstractInventoryItemRequirementEntryMvoCommand.SimpleCreateInventoryItemRequirementEntryMvo();
            copyTo((AbstractInventoryItemRequirementEntryMvoCommand.AbstractCreateInventoryItemRequirementEntryMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryItemRequirementEntryMvoCommand.SimpleMergePatchInventoryItemRequirementEntryMvo command = new AbstractInventoryItemRequirementEntryMvoCommand.SimpleMergePatchInventoryItemRequirementEntryMvo();
            copyTo((AbstractInventoryItemRequirementEntryMvoCommand.SimpleMergePatchInventoryItemRequirementEntryMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemRequirementEntryMvoCommand.AbstractCreateInventoryItemRequirementEntryMvo command)
    {
        copyTo((AbstractInventoryItemRequirementEntryMvoCommand.AbstractCreateOrMergePatchInventoryItemRequirementEntryMvo) command);
    }

    public void copyTo(AbstractInventoryItemRequirementEntryMvoCommand.AbstractMergePatchInventoryItemRequirementEntryMvo command)
    {
        copyTo((AbstractInventoryItemRequirementEntryMvoCommand.AbstractCreateOrMergePatchInventoryItemRequirementEntryMvo) command);
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertySourceEventIdRemoved(this.getIsPropertySourceEventIdRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyInventoryItemRequirementQuantityRemoved(this.getIsPropertyInventoryItemRequirementQuantityRemoved());
        command.setIsPropertyInventoryItemRequirementCreatedByRemoved(this.getIsPropertyInventoryItemRequirementCreatedByRemoved());
        command.setIsPropertyInventoryItemRequirementCreatedAtRemoved(this.getIsPropertyInventoryItemRequirementCreatedAtRemoved());
        command.setIsPropertyInventoryItemRequirementUpdatedByRemoved(this.getIsPropertyInventoryItemRequirementUpdatedByRemoved());
        command.setIsPropertyInventoryItemRequirementUpdatedAtRemoved(this.getIsPropertyInventoryItemRequirementUpdatedAtRemoved());
    }

    public static class CreateInventoryItemRequirementEntryMvoDto extends CreateOrMergePatchInventoryItemRequirementEntryMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo toCreateInventoryItemRequirementEntryMvo()
        {
            return (InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo) toCommand();
        }

    }

    public static class MergePatchInventoryItemRequirementEntryMvoDto extends CreateOrMergePatchInventoryItemRequirementEntryMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo toMergePatchInventoryItemRequirementEntryMvo()
        {
            return (InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo) toCommand();
        }

    }

}

