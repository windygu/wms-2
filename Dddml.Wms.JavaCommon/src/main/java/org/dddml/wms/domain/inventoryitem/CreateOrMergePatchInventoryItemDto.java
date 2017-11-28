package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemDto extends AbstractInventoryItemCommandDto
{
    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand()
    {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand)
    {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityReserved;

    public BigDecimal getQuantityReserved()
    {
        return this.quantityReserved;
    }

    public void setQuantityReserved(BigDecimal quantityReserved)
    {
        this.quantityReserved = quantityReserved;
    }

    private BigDecimal quantityOccupied;

    public BigDecimal getQuantityOccupied()
    {
        return this.quantityOccupied;
    }

    public void setQuantityOccupied(BigDecimal quantityOccupied)
    {
        this.quantityOccupied = quantityOccupied;
    }

    private BigDecimal quantityVirtual;

    public BigDecimal getQuantityVirtual()
    {
        return this.quantityVirtual;
    }

    public void setQuantityVirtual(BigDecimal quantityVirtual)
    {
        this.quantityVirtual = quantityVirtual;
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

    private CreateOrMergePatchInventoryItemEntryDto[] entries;

    public CreateOrMergePatchInventoryItemEntryDto[] getEntries()
    {
        return this.entries;
    }

    public void setEntries(CreateOrMergePatchInventoryItemEntryDto[] entries)
    {
        this.entries = entries;
    }

    private Boolean isPropertyQuantityOnHandRemoved;

    public Boolean getIsPropertyQuantityOnHandRemoved()
    {
        return this.isPropertyQuantityOnHandRemoved;
    }

    public void setIsPropertyQuantityOnHandRemoved(Boolean removed)
    {
        this.isPropertyQuantityOnHandRemoved = removed;
    }

    private Boolean isPropertyQuantityReservedRemoved;

    public Boolean getIsPropertyQuantityReservedRemoved()
    {
        return this.isPropertyQuantityReservedRemoved;
    }

    public void setIsPropertyQuantityReservedRemoved(Boolean removed)
    {
        this.isPropertyQuantityReservedRemoved = removed;
    }

    private Boolean isPropertyQuantityOccupiedRemoved;

    public Boolean getIsPropertyQuantityOccupiedRemoved()
    {
        return this.isPropertyQuantityOccupiedRemoved;
    }

    public void setIsPropertyQuantityOccupiedRemoved(Boolean removed)
    {
        this.isPropertyQuantityOccupiedRemoved = removed;
    }

    private Boolean isPropertyQuantityVirtualRemoved;

    public Boolean getIsPropertyQuantityVirtualRemoved()
    {
        return this.isPropertyQuantityVirtualRemoved;
    }

    public void setIsPropertyQuantityVirtualRemoved(Boolean removed)
    {
        this.isPropertyQuantityVirtualRemoved = removed;
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

    public void copyTo(AbstractInventoryItemCommand.AbstractCreateOrMergePatchInventoryItem command)
    {
        ((AbstractInventoryItemCommandDto) this).copyTo(command);
        command.setQuantityOnHand(this.getQuantityOnHand());
        command.setQuantityReserved(this.getQuantityReserved());
        command.setQuantityOccupied(this.getQuantityOccupied());
        command.setQuantityVirtual(this.getQuantityVirtual());
        command.setActive(this.getActive());
    }

    public InventoryItemCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemCommand.SimpleCreateInventoryItem command = new AbstractInventoryItemCommand.SimpleCreateInventoryItem();
            copyTo((AbstractInventoryItemCommand.AbstractCreateInventoryItem) command);
            if (this.getEntries() != null) {
                for (CreateOrMergePatchInventoryItemEntryDto cmd : this.getEntries()) {
                    command.getEntries().add((InventoryItemEntryCommand.CreateInventoryItemEntry) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryItemCommand.SimpleMergePatchInventoryItem command = new AbstractInventoryItemCommand.SimpleMergePatchInventoryItem();
            copyTo((AbstractInventoryItemCommand.SimpleMergePatchInventoryItem) command);
            if (this.getEntries() != null) {
                for (CreateOrMergePatchInventoryItemEntryDto cmd : this.getEntries()) {
                    command.getInventoryItemEntryCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemCommand.AbstractCreateInventoryItem command)
    {
        copyTo((AbstractInventoryItemCommand.AbstractCreateOrMergePatchInventoryItem) command);
    }

    public void copyTo(AbstractInventoryItemCommand.AbstractMergePatchInventoryItem command)
    {
        copyTo((AbstractInventoryItemCommand.AbstractCreateOrMergePatchInventoryItem) command);
        command.setIsPropertyQuantityOnHandRemoved(this.getIsPropertyQuantityOnHandRemoved());
        command.setIsPropertyQuantityReservedRemoved(this.getIsPropertyQuantityReservedRemoved());
        command.setIsPropertyQuantityOccupiedRemoved(this.getIsPropertyQuantityOccupiedRemoved());
        command.setIsPropertyQuantityVirtualRemoved(this.getIsPropertyQuantityVirtualRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInventoryItemDto extends CreateOrMergePatchInventoryItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemCommand.CreateInventoryItem toCreateInventoryItem()
        {
            return (InventoryItemCommand.CreateInventoryItem) toCommand();
        }

    }

    public static class MergePatchInventoryItemDto extends CreateOrMergePatchInventoryItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryItemCommand.MergePatchInventoryItem toMergePatchInventoryItem()
        {
            return (InventoryItemCommand.MergePatchInventoryItem) toCommand();
        }

    }

}

