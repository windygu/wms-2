package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryDto extends AbstractInventoryItemEntryCommandDto
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

    private BigDecimal quantityInTransit;

    public BigDecimal getQuantityInTransit()
    {
        return this.quantityInTransit;
    }

    public void setQuantityInTransit(BigDecimal quantityInTransit)
    {
        this.quantityInTransit = quantityInTransit;
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

    private InventoryItemSourceInfoDto source;

    public InventoryItemSourceInfoDto getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceInfoDto source)
    {
        this.source = source;
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

    private Boolean isPropertyQuantityOnHandRemoved;

    public Boolean getIsPropertyQuantityOnHandRemoved()
    {
        return this.isPropertyQuantityOnHandRemoved;
    }

    public void setIsPropertyQuantityOnHandRemoved(Boolean removed)
    {
        this.isPropertyQuantityOnHandRemoved = removed;
    }

    private Boolean isPropertyQuantityInTransitRemoved;

    public Boolean getIsPropertyQuantityInTransitRemoved()
    {
        return this.isPropertyQuantityInTransitRemoved;
    }

    public void setIsPropertyQuantityInTransitRemoved(Boolean removed)
    {
        this.isPropertyQuantityInTransitRemoved = removed;
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

    private Boolean isPropertySourceRemoved;

    public Boolean getIsPropertySourceRemoved()
    {
        return this.isPropertySourceRemoved;
    }

    public void setIsPropertySourceRemoved(Boolean removed)
    {
        this.isPropertySourceRemoved = removed;
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

    public void copyTo(AbstractInventoryItemEntryCommand.AbstractCreateOrMergePatchInventoryItemEntry command)
    {
        ((AbstractInventoryItemEntryCommandDto) this).copyTo(command);
        command.setQuantityOnHand(this.getQuantityOnHand());
        command.setQuantityInTransit(this.getQuantityInTransit());
        command.setQuantityReserved(this.getQuantityReserved());
        command.setQuantityOccupied(this.getQuantityOccupied());
        command.setQuantityVirtual(this.getQuantityVirtual());
        command.setSource(this.getSource() == null ? null : this.getSource().toInventoryItemSourceInfo());
        command.setActive(this.getActive());
    }

    public InventoryItemEntryCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry command = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
            copyTo((AbstractInventoryItemEntryCommand.AbstractCreateInventoryItemEntry) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemEntryCommand.AbstractCreateInventoryItemEntry command)
    {
        copyTo((AbstractInventoryItemEntryCommand.AbstractCreateOrMergePatchInventoryItemEntry) command);
    }

    public static class CreateInventoryItemEntryDto extends CreateOrMergePatchInventoryItemEntryDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemEntryCommand.CreateInventoryItemEntry toCreateInventoryItemEntry()
        {
            return (InventoryItemEntryCommand.CreateInventoryItemEntry) toCommand();
        }

    }

}

