package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryMvoDto extends AbstractInventoryItemEntryMvoCommandDto
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

    private BigDecimal inventoryItemQuantityOnHand;

    public BigDecimal getInventoryItemQuantityOnHand()
    {
        return this.inventoryItemQuantityOnHand;
    }

    public void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand)
    {
        this.inventoryItemQuantityOnHand = inventoryItemQuantityOnHand;
    }

    private BigDecimal inventoryItemQuantityReserved;

    public BigDecimal getInventoryItemQuantityReserved()
    {
        return this.inventoryItemQuantityReserved;
    }

    public void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved)
    {
        this.inventoryItemQuantityReserved = inventoryItemQuantityReserved;
    }

    private BigDecimal inventoryItemQuantityOccupied;

    public BigDecimal getInventoryItemQuantityOccupied()
    {
        return this.inventoryItemQuantityOccupied;
    }

    public void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied)
    {
        this.inventoryItemQuantityOccupied = inventoryItemQuantityOccupied;
    }

    private BigDecimal inventoryItemQuantityVirtual;

    public BigDecimal getInventoryItemQuantityVirtual()
    {
        return this.inventoryItemQuantityVirtual;
    }

    public void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual)
    {
        this.inventoryItemQuantityVirtual = inventoryItemQuantityVirtual;
    }

    private String inventoryItemCreatedBy;

    public String getInventoryItemCreatedBy()
    {
        return this.inventoryItemCreatedBy;
    }

    public void setInventoryItemCreatedBy(String inventoryItemCreatedBy)
    {
        this.inventoryItemCreatedBy = inventoryItemCreatedBy;
    }

    private Date inventoryItemCreatedAt;

    public Date getInventoryItemCreatedAt()
    {
        return this.inventoryItemCreatedAt;
    }

    public void setInventoryItemCreatedAt(Date inventoryItemCreatedAt)
    {
        this.inventoryItemCreatedAt = inventoryItemCreatedAt;
    }

    private String inventoryItemUpdatedBy;

    public String getInventoryItemUpdatedBy()
    {
        return this.inventoryItemUpdatedBy;
    }

    public void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy)
    {
        this.inventoryItemUpdatedBy = inventoryItemUpdatedBy;
    }

    private Date inventoryItemUpdatedAt;

    public Date getInventoryItemUpdatedAt()
    {
        return this.inventoryItemUpdatedAt;
    }

    public void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt)
    {
        this.inventoryItemUpdatedAt = inventoryItemUpdatedAt;
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

    private Boolean isPropertyInventoryItemQuantityOnHandRemoved;

    public Boolean getIsPropertyInventoryItemQuantityOnHandRemoved()
    {
        return this.isPropertyInventoryItemQuantityOnHandRemoved;
    }

    public void setIsPropertyInventoryItemQuantityOnHandRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemQuantityOnHandRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityReservedRemoved;

    public Boolean getIsPropertyInventoryItemQuantityReservedRemoved()
    {
        return this.isPropertyInventoryItemQuantityReservedRemoved;
    }

    public void setIsPropertyInventoryItemQuantityReservedRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemQuantityReservedRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityOccupiedRemoved;

    public Boolean getIsPropertyInventoryItemQuantityOccupiedRemoved()
    {
        return this.isPropertyInventoryItemQuantityOccupiedRemoved;
    }

    public void setIsPropertyInventoryItemQuantityOccupiedRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemQuantityOccupiedRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityVirtualRemoved;

    public Boolean getIsPropertyInventoryItemQuantityVirtualRemoved()
    {
        return this.isPropertyInventoryItemQuantityVirtualRemoved;
    }

    public void setIsPropertyInventoryItemQuantityVirtualRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemQuantityVirtualRemoved = removed;
    }

    private Boolean isPropertyInventoryItemCreatedByRemoved;

    public Boolean getIsPropertyInventoryItemCreatedByRemoved()
    {
        return this.isPropertyInventoryItemCreatedByRemoved;
    }

    public void setIsPropertyInventoryItemCreatedByRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemCreatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemCreatedAtRemoved;

    public Boolean getIsPropertyInventoryItemCreatedAtRemoved()
    {
        return this.isPropertyInventoryItemCreatedAtRemoved;
    }

    public void setIsPropertyInventoryItemCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemCreatedAtRemoved = removed;
    }

    private Boolean isPropertyInventoryItemUpdatedByRemoved;

    public Boolean getIsPropertyInventoryItemUpdatedByRemoved()
    {
        return this.isPropertyInventoryItemUpdatedByRemoved;
    }

    public void setIsPropertyInventoryItemUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemUpdatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemUpdatedAtRemoved;

    public Boolean getIsPropertyInventoryItemUpdatedAtRemoved()
    {
        return this.isPropertyInventoryItemUpdatedAtRemoved;
    }

    public void setIsPropertyInventoryItemUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemUpdatedAtRemoved = removed;
    }

    public void copyTo(AbstractInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchInventoryItemEntryMvo command)
    {
        ((AbstractInventoryItemEntryMvoCommandDto) this).copyTo(command);
        command.setQuantityOnHandVar(this.getQuantityOnHandVar());
        command.setQuantityReservedVar(this.getQuantityReservedVar());
        command.setQuantityOccupiedVar(this.getQuantityOccupiedVar());
        command.setQuantityVirtualVar(this.getQuantityVirtualVar());
        command.setEventVO((this.getEventVO() == null) ? null : this.getEventVO().toInventoryItemEventVO());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setInventoryItemQuantityOnHand(this.getInventoryItemQuantityOnHand());
        command.setInventoryItemQuantityReserved(this.getInventoryItemQuantityReserved());
        command.setInventoryItemQuantityOccupied(this.getInventoryItemQuantityOccupied());
        command.setInventoryItemQuantityVirtual(this.getInventoryItemQuantityVirtual());
        command.setInventoryItemCreatedBy(this.getInventoryItemCreatedBy());
        command.setInventoryItemCreatedAt(this.getInventoryItemCreatedAt());
        command.setInventoryItemUpdatedBy(this.getInventoryItemUpdatedBy());
        command.setInventoryItemUpdatedAt(this.getInventoryItemUpdatedAt());
    }

    public InventoryItemEntryMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemEntryMvoCommand.SimpleCreateInventoryItemEntryMvo command = new AbstractInventoryItemEntryMvoCommand.SimpleCreateInventoryItemEntryMvo();
            copyTo((AbstractInventoryItemEntryMvoCommand.AbstractCreateInventoryItemEntryMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryItemEntryMvoCommand.SimpleMergePatchInventoryItemEntryMvo command = new AbstractInventoryItemEntryMvoCommand.SimpleMergePatchInventoryItemEntryMvo();
            copyTo((AbstractInventoryItemEntryMvoCommand.SimpleMergePatchInventoryItemEntryMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemEntryMvoCommand.AbstractCreateInventoryItemEntryMvo command)
    {
        copyTo((AbstractInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchInventoryItemEntryMvo) command);
    }

    public void copyTo(AbstractInventoryItemEntryMvoCommand.AbstractMergePatchInventoryItemEntryMvo command)
    {
        copyTo((AbstractInventoryItemEntryMvoCommand.AbstractCreateOrMergePatchInventoryItemEntryMvo) command);
        command.setIsPropertyQuantityOnHandVarRemoved(this.getIsPropertyQuantityOnHandVarRemoved());
        command.setIsPropertyQuantityReservedVarRemoved(this.getIsPropertyQuantityReservedVarRemoved());
        command.setIsPropertyQuantityOccupiedVarRemoved(this.getIsPropertyQuantityOccupiedVarRemoved());
        command.setIsPropertyQuantityVirtualVarRemoved(this.getIsPropertyQuantityVirtualVarRemoved());
        command.setIsPropertyEventVORemoved(this.getIsPropertyEventVORemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyInventoryItemQuantityOnHandRemoved(this.getIsPropertyInventoryItemQuantityOnHandRemoved());
        command.setIsPropertyInventoryItemQuantityReservedRemoved(this.getIsPropertyInventoryItemQuantityReservedRemoved());
        command.setIsPropertyInventoryItemQuantityOccupiedRemoved(this.getIsPropertyInventoryItemQuantityOccupiedRemoved());
        command.setIsPropertyInventoryItemQuantityVirtualRemoved(this.getIsPropertyInventoryItemQuantityVirtualRemoved());
        command.setIsPropertyInventoryItemCreatedByRemoved(this.getIsPropertyInventoryItemCreatedByRemoved());
        command.setIsPropertyInventoryItemCreatedAtRemoved(this.getIsPropertyInventoryItemCreatedAtRemoved());
        command.setIsPropertyInventoryItemUpdatedByRemoved(this.getIsPropertyInventoryItemUpdatedByRemoved());
        command.setIsPropertyInventoryItemUpdatedAtRemoved(this.getIsPropertyInventoryItemUpdatedAtRemoved());
    }

    public static class CreateInventoryItemEntryMvoDto extends CreateOrMergePatchInventoryItemEntryMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo toCreateInventoryItemEntryMvo()
        {
            return (InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo) toCommand();
        }

    }

    public static class MergePatchInventoryItemEntryMvoDto extends CreateOrMergePatchInventoryItemEntryMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo toMergePatchInventoryItemEntryMvo()
        {
            return (InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo) toCommand();
        }

    }

}

