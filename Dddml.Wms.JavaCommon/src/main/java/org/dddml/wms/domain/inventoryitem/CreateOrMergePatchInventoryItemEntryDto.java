package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryDto extends AbstractInventoryItemEntryCommandDto
{
    private BigDecimal quantityOnHandVar;

    public BigDecimal getQuantityOnHandVar()
    {
        return this.quantityOnHandVar;
    }

    public void setQuantityOnHandVar(BigDecimal quantityOnHandVar)
    {
        this.quantityOnHandVar = quantityOnHandVar;
    }

    private BigDecimal quantityReservedVar;

    public BigDecimal getQuantityReservedVar()
    {
        return this.quantityReservedVar;
    }

    public void setQuantityReservedVar(BigDecimal quantityReservedVar)
    {
        this.quantityReservedVar = quantityReservedVar;
    }

    private BigDecimal quantityOccupiedVar;

    public BigDecimal getQuantityOccupiedVar()
    {
        return this.quantityOccupiedVar;
    }

    public void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar)
    {
        this.quantityOccupiedVar = quantityOccupiedVar;
    }

    private BigDecimal quantityVirtualVar;

    public BigDecimal getQuantityVirtualVar()
    {
        return this.quantityVirtualVar;
    }

    public void setQuantityVirtualVar(BigDecimal quantityVirtualVar)
    {
        this.quantityVirtualVar = quantityVirtualVar;
    }

    private InventoryItemEventVODto eventVO;

    public InventoryItemEventVODto getEventVO()
    {
        return this.eventVO;
    }

    public void setEventVO(InventoryItemEventVODto eventVO)
    {
        this.eventVO = eventVO;
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

    private Boolean isPropertyQuantityOnHandVarRemoved;

    public Boolean getIsPropertyQuantityOnHandVarRemoved()
    {
        return this.isPropertyQuantityOnHandVarRemoved;
    }

    public void setIsPropertyQuantityOnHandVarRemoved(Boolean removed)
    {
        this.isPropertyQuantityOnHandVarRemoved = removed;
    }

    private Boolean isPropertyQuantityReservedVarRemoved;

    public Boolean getIsPropertyQuantityReservedVarRemoved()
    {
        return this.isPropertyQuantityReservedVarRemoved;
    }

    public void setIsPropertyQuantityReservedVarRemoved(Boolean removed)
    {
        this.isPropertyQuantityReservedVarRemoved = removed;
    }

    private Boolean isPropertyQuantityOccupiedVarRemoved;

    public Boolean getIsPropertyQuantityOccupiedVarRemoved()
    {
        return this.isPropertyQuantityOccupiedVarRemoved;
    }

    public void setIsPropertyQuantityOccupiedVarRemoved(Boolean removed)
    {
        this.isPropertyQuantityOccupiedVarRemoved = removed;
    }

    private Boolean isPropertyQuantityVirtualVarRemoved;

    public Boolean getIsPropertyQuantityVirtualVarRemoved()
    {
        return this.isPropertyQuantityVirtualVarRemoved;
    }

    public void setIsPropertyQuantityVirtualVarRemoved(Boolean removed)
    {
        this.isPropertyQuantityVirtualVarRemoved = removed;
    }

    private Boolean isPropertyEventVORemoved;

    public Boolean getIsPropertyEventVORemoved()
    {
        return this.isPropertyEventVORemoved;
    }

    public void setIsPropertyEventVORemoved(Boolean removed)
    {
        this.isPropertyEventVORemoved = removed;
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
        command.setQuantityOnHandVar(this.getQuantityOnHandVar());
        command.setQuantityReservedVar(this.getQuantityReservedVar());
        command.setQuantityOccupiedVar(this.getQuantityOccupiedVar());
        command.setQuantityVirtualVar(this.getQuantityVirtualVar());
        command.setEventVO((this.getEventVO() == null) ? null : this.getEventVO().toInventoryItemEventVO());
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

