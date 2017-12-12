package org.dddml.wms.domain.sellableinventoryitem;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchSellableInventoryItemEntryDto extends AbstractSellableInventoryItemEntryCommandDto
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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
        command.setQuantitySellable(this.getQuantitySellable());
        command.setSourceEventId(this.getSourceEventId() == null ? null : this.getSourceEventId().toInventoryPRTriggeredId());
        command.setActive(this.getActive());
    }

    public SellableInventoryItemEntryCommand toCommand()
    {
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

