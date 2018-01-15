package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemRequirementEntryDto extends AbstractInventoryItemRequirementEntryCommandDto
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractInventoryItemRequirementEntryCommand.AbstractCreateOrMergePatchInventoryItemRequirementEntry command)
    {
        ((AbstractInventoryItemRequirementEntryCommandDto) this).copyTo(command);
        command.setQuantity(this.getQuantity());
        command.setSourceEventId(this.getSourceEventId() == null ? null : this.getSourceEventId().toInventoryPRTriggeredId());
        command.setActive(this.getActive());
    }

    public InventoryItemRequirementEntryCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry command = new AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry();
            copyTo((AbstractInventoryItemRequirementEntryCommand.AbstractCreateInventoryItemRequirementEntry) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemRequirementEntryCommand.AbstractCreateInventoryItemRequirementEntry command)
    {
        copyTo((AbstractInventoryItemRequirementEntryCommand.AbstractCreateOrMergePatchInventoryItemRequirementEntry) command);
    }

    public static class CreateInventoryItemRequirementEntryDto extends CreateOrMergePatchInventoryItemRequirementEntryDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry toCreateInventoryItemRequirementEntry()
        {
            return (InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry) toCommand();
        }

    }

}

