package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryDto extends AbstractInventoryItemEntryCommandDto
{
    private BigDecimal onHandQuantity;

    public BigDecimal getOnHandQuantity()
    {
        return this.onHandQuantity;
    }

    public void setOnHandQuantity(BigDecimal onHandQuantity)
    {
        this.onHandQuantity = onHandQuantity;
    }

    private BigDecimal inTransitQuantity;

    public BigDecimal getInTransitQuantity()
    {
        return this.inTransitQuantity;
    }

    public void setInTransitQuantity(BigDecimal inTransitQuantity)
    {
        this.inTransitQuantity = inTransitQuantity;
    }

    private BigDecimal reservedQuantity;

    public BigDecimal getReservedQuantity()
    {
        return this.reservedQuantity;
    }

    public void setReservedQuantity(BigDecimal reservedQuantity)
    {
        this.reservedQuantity = reservedQuantity;
    }

    private BigDecimal occupiedQuantity;

    public BigDecimal getOccupiedQuantity()
    {
        return this.occupiedQuantity;
    }

    public void setOccupiedQuantity(BigDecimal occupiedQuantity)
    {
        this.occupiedQuantity = occupiedQuantity;
    }

    private BigDecimal virtualQuantity;

    public BigDecimal getVirtualQuantity()
    {
        return this.virtualQuantity;
    }

    public void setVirtualQuantity(BigDecimal virtualQuantity)
    {
        this.virtualQuantity = virtualQuantity;
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

    private Boolean isPropertyOnHandQuantityRemoved;

    public Boolean getIsPropertyOnHandQuantityRemoved()
    {
        return this.isPropertyOnHandQuantityRemoved;
    }

    public void setIsPropertyOnHandQuantityRemoved(Boolean removed)
    {
        this.isPropertyOnHandQuantityRemoved = removed;
    }

    private Boolean isPropertyInTransitQuantityRemoved;

    public Boolean getIsPropertyInTransitQuantityRemoved()
    {
        return this.isPropertyInTransitQuantityRemoved;
    }

    public void setIsPropertyInTransitQuantityRemoved(Boolean removed)
    {
        this.isPropertyInTransitQuantityRemoved = removed;
    }

    private Boolean isPropertyReservedQuantityRemoved;

    public Boolean getIsPropertyReservedQuantityRemoved()
    {
        return this.isPropertyReservedQuantityRemoved;
    }

    public void setIsPropertyReservedQuantityRemoved(Boolean removed)
    {
        this.isPropertyReservedQuantityRemoved = removed;
    }

    private Boolean isPropertyOccupiedQuantityRemoved;

    public Boolean getIsPropertyOccupiedQuantityRemoved()
    {
        return this.isPropertyOccupiedQuantityRemoved;
    }

    public void setIsPropertyOccupiedQuantityRemoved(Boolean removed)
    {
        this.isPropertyOccupiedQuantityRemoved = removed;
    }

    private Boolean isPropertyVirtualQuantityRemoved;

    public Boolean getIsPropertyVirtualQuantityRemoved()
    {
        return this.isPropertyVirtualQuantityRemoved;
    }

    public void setIsPropertyVirtualQuantityRemoved(Boolean removed)
    {
        this.isPropertyVirtualQuantityRemoved = removed;
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
        command.setOnHandQuantity(this.getOnHandQuantity());
        command.setInTransitQuantity(this.getInTransitQuantity());
        command.setReservedQuantity(this.getReservedQuantity());
        command.setOccupiedQuantity(this.getOccupiedQuantity());
        command.setVirtualQuantity(this.getVirtualQuantity());
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
