package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryMvoDto extends AbstractInventoryItemEntryMvoCommandDto
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

    private InventoryItemSourceVODto source;

    public InventoryItemSourceVODto getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceVODto source)
    {
        this.source = source;
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

    private BigDecimal inventoryItemQuantityInTransit;

    public BigDecimal getInventoryItemQuantityInTransit()
    {
        return this.inventoryItemQuantityInTransit;
    }

    public void setInventoryItemQuantityInTransit(BigDecimal inventoryItemQuantityInTransit)
    {
        this.inventoryItemQuantityInTransit = inventoryItemQuantityInTransit;
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

    private Boolean isPropertyInventoryItemQuantityInTransitRemoved;

    public Boolean getIsPropertyInventoryItemQuantityInTransitRemoved()
    {
        return this.isPropertyInventoryItemQuantityInTransitRemoved;
    }

    public void setIsPropertyInventoryItemQuantityInTransitRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemQuantityInTransitRemoved = removed;
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
        command.setQuantityOnHand(this.getQuantityOnHand());
        command.setQuantityInTransit(this.getQuantityInTransit());
        command.setQuantityReserved(this.getQuantityReserved());
        command.setQuantityOccupied(this.getQuantityOccupied());
        command.setQuantityVirtual(this.getQuantityVirtual());
        command.setSource(this.getSource() == null ? null : this.getSource().toInventoryItemSourceVO());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setInventoryItemQuantityOnHand(this.getInventoryItemQuantityOnHand());
        command.setInventoryItemQuantityInTransit(this.getInventoryItemQuantityInTransit());
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
        command.setIsPropertyQuantityOnHandRemoved(this.getIsPropertyQuantityOnHandRemoved());
        command.setIsPropertyQuantityInTransitRemoved(this.getIsPropertyQuantityInTransitRemoved());
        command.setIsPropertyQuantityReservedRemoved(this.getIsPropertyQuantityReservedRemoved());
        command.setIsPropertyQuantityOccupiedRemoved(this.getIsPropertyQuantityOccupiedRemoved());
        command.setIsPropertyQuantityVirtualRemoved(this.getIsPropertyQuantityVirtualRemoved());
        command.setIsPropertySourceRemoved(this.getIsPropertySourceRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyInventoryItemQuantityOnHandRemoved(this.getIsPropertyInventoryItemQuantityOnHandRemoved());
        command.setIsPropertyInventoryItemQuantityInTransitRemoved(this.getIsPropertyInventoryItemQuantityInTransitRemoved());
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

