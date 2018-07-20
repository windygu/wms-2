package org.dddml.wms.domain.sellableinventoryitem;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchSellableInventoryItemEntryDto extends AbstractSellableInventoryItemEntryCommandDto
{
    /**
     * Sellable Quantity
     */
    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
    }

    /**
     * Source Event Id
     */
    private InventoryPRTriggeredId sourceEventId;

    public InventoryPRTriggeredId getSourceEventId()
    {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
    {
        this.sourceEventId = sourceEventId;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractSellableInventoryItemEntryCommand.AbstractCreateOrMergePatchSellableInventoryItemEntry command)
    {
        ((AbstractSellableInventoryItemEntryCommandDto) this).copyTo(command);
        command.setSellableQuantity(this.getSellableQuantity());
        command.setSourceEventId(this.getSourceEventId());
        command.setActive(this.getActive());
    }

    public SellableInventoryItemEntryCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry command = new AbstractSellableInventoryItemEntryCommand.SimpleCreateSellableInventoryItemEntry();
            copyTo((AbstractSellableInventoryItemEntryCommand.AbstractCreateSellableInventoryItemEntry) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractSellableInventoryItemEntryCommand.AbstractCreateSellableInventoryItemEntry command)
    {
        copyTo((AbstractSellableInventoryItemEntryCommand.AbstractCreateOrMergePatchSellableInventoryItemEntry) command);
    }

    public static class CreateSellableInventoryItemEntryDto extends CreateOrMergePatchSellableInventoryItemEntryDto
    {
        public CreateSellableInventoryItemEntryDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry toCreateSellableInventoryItemEntry()
        {
            return (SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry) toCommand();
        }

    }

}

