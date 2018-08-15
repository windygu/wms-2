package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryDto extends AbstractInventoryItemEntryCommandDto
{
    /**
     * On Hand Quantity
     */
    private BigDecimal onHandQuantity;

    public BigDecimal getOnHandQuantity()
    {
        return this.onHandQuantity;
    }

    public void setOnHandQuantity(BigDecimal onHandQuantity)
    {
        this.onHandQuantity = onHandQuantity;
    }

    /**
     * In Transit Quantity
     */
    private BigDecimal inTransitQuantity;

    public BigDecimal getInTransitQuantity()
    {
        return this.inTransitQuantity;
    }

    public void setInTransitQuantity(BigDecimal inTransitQuantity)
    {
        this.inTransitQuantity = inTransitQuantity;
    }

    /**
     * Reserved Quantity
     */
    private BigDecimal reservedQuantity;

    public BigDecimal getReservedQuantity()
    {
        return this.reservedQuantity;
    }

    public void setReservedQuantity(BigDecimal reservedQuantity)
    {
        this.reservedQuantity = reservedQuantity;
    }

    /**
     * Occupied Quantity
     */
    private BigDecimal occupiedQuantity;

    public BigDecimal getOccupiedQuantity()
    {
        return this.occupiedQuantity;
    }

    public void setOccupiedQuantity(BigDecimal occupiedQuantity)
    {
        this.occupiedQuantity = occupiedQuantity;
    }

    /**
     * Virtual Quantity
     */
    private BigDecimal virtualQuantity;

    public BigDecimal getVirtualQuantity()
    {
        return this.virtualQuantity;
    }

    public void setVirtualQuantity(BigDecimal virtualQuantity)
    {
        this.virtualQuantity = virtualQuantity;
    }

    /**
     * Source
     */
    private InventoryItemSourceInfo source;

    public InventoryItemSourceInfo getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceInfo source)
    {
        this.source = source;
    }

    /**
     * Occured At
     */
    private java.sql.Timestamp occuredAt;

    public java.sql.Timestamp getOccuredAt()
    {
        return this.occuredAt;
    }

    public void setOccuredAt(java.sql.Timestamp occuredAt)
    {
        this.occuredAt = occuredAt;
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

    private Boolean isPropertyOccuredAtRemoved;

    public Boolean getIsPropertyOccuredAtRemoved()
    {
        return this.isPropertyOccuredAtRemoved;
    }

    public void setIsPropertyOccuredAtRemoved(Boolean removed)
    {
        this.isPropertyOccuredAtRemoved = removed;
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
        command.setSource(this.getSource());
        command.setOccuredAt(this.getOccuredAt());
        command.setActive(this.getActive());
    }

    public InventoryItemEntryCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
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
        public CreateInventoryItemEntryDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

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

