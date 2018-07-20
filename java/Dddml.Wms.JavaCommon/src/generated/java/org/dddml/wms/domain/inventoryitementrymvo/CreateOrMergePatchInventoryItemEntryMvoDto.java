package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEntryMvoDto extends AbstractInventoryItemEntryMvoCommandDto
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
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    /**
     * Inventory Item On Hand Quantity
     */
    private BigDecimal inventoryItemOnHandQuantity;

    public BigDecimal getInventoryItemOnHandQuantity()
    {
        return this.inventoryItemOnHandQuantity;
    }

    public void setInventoryItemOnHandQuantity(BigDecimal inventoryItemOnHandQuantity)
    {
        this.inventoryItemOnHandQuantity = inventoryItemOnHandQuantity;
    }

    /**
     * Inventory Item In Transit Quantity
     */
    private BigDecimal inventoryItemInTransitQuantity;

    public BigDecimal getInventoryItemInTransitQuantity()
    {
        return this.inventoryItemInTransitQuantity;
    }

    public void setInventoryItemInTransitQuantity(BigDecimal inventoryItemInTransitQuantity)
    {
        this.inventoryItemInTransitQuantity = inventoryItemInTransitQuantity;
    }

    /**
     * Inventory Item Reserved Quantity
     */
    private BigDecimal inventoryItemReservedQuantity;

    public BigDecimal getInventoryItemReservedQuantity()
    {
        return this.inventoryItemReservedQuantity;
    }

    public void setInventoryItemReservedQuantity(BigDecimal inventoryItemReservedQuantity)
    {
        this.inventoryItemReservedQuantity = inventoryItemReservedQuantity;
    }

    /**
     * Inventory Item Occupied Quantity
     */
    private BigDecimal inventoryItemOccupiedQuantity;

    public BigDecimal getInventoryItemOccupiedQuantity()
    {
        return this.inventoryItemOccupiedQuantity;
    }

    public void setInventoryItemOccupiedQuantity(BigDecimal inventoryItemOccupiedQuantity)
    {
        this.inventoryItemOccupiedQuantity = inventoryItemOccupiedQuantity;
    }

    /**
     * Inventory Item Virtual Quantity
     */
    private BigDecimal inventoryItemVirtualQuantity;

    public BigDecimal getInventoryItemVirtualQuantity()
    {
        return this.inventoryItemVirtualQuantity;
    }

    public void setInventoryItemVirtualQuantity(BigDecimal inventoryItemVirtualQuantity)
    {
        this.inventoryItemVirtualQuantity = inventoryItemVirtualQuantity;
    }

    /**
     * Inventory Item Created By
     */
    private String inventoryItemCreatedBy;

    public String getInventoryItemCreatedBy()
    {
        return this.inventoryItemCreatedBy;
    }

    public void setInventoryItemCreatedBy(String inventoryItemCreatedBy)
    {
        this.inventoryItemCreatedBy = inventoryItemCreatedBy;
    }

    /**
     * Inventory Item Created At
     */
    private Date inventoryItemCreatedAt;

    public Date getInventoryItemCreatedAt()
    {
        return this.inventoryItemCreatedAt;
    }

    public void setInventoryItemCreatedAt(Date inventoryItemCreatedAt)
    {
        this.inventoryItemCreatedAt = inventoryItemCreatedAt;
    }

    /**
     * Inventory Item Updated By
     */
    private String inventoryItemUpdatedBy;

    public String getInventoryItemUpdatedBy()
    {
        return this.inventoryItemUpdatedBy;
    }

    public void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy)
    {
        this.inventoryItemUpdatedBy = inventoryItemUpdatedBy;
    }

    /**
     * Inventory Item Updated At
     */
    private Date inventoryItemUpdatedAt;

    public Date getInventoryItemUpdatedAt()
    {
        return this.inventoryItemUpdatedAt;
    }

    public void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt)
    {
        this.inventoryItemUpdatedAt = inventoryItemUpdatedAt;
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

    private Boolean isPropertyInventoryItemOnHandQuantityRemoved;

    public Boolean getIsPropertyInventoryItemOnHandQuantityRemoved()
    {
        return this.isPropertyInventoryItemOnHandQuantityRemoved;
    }

    public void setIsPropertyInventoryItemOnHandQuantityRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemOnHandQuantityRemoved = removed;
    }

    private Boolean isPropertyInventoryItemInTransitQuantityRemoved;

    public Boolean getIsPropertyInventoryItemInTransitQuantityRemoved()
    {
        return this.isPropertyInventoryItemInTransitQuantityRemoved;
    }

    public void setIsPropertyInventoryItemInTransitQuantityRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemInTransitQuantityRemoved = removed;
    }

    private Boolean isPropertyInventoryItemReservedQuantityRemoved;

    public Boolean getIsPropertyInventoryItemReservedQuantityRemoved()
    {
        return this.isPropertyInventoryItemReservedQuantityRemoved;
    }

    public void setIsPropertyInventoryItemReservedQuantityRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemReservedQuantityRemoved = removed;
    }

    private Boolean isPropertyInventoryItemOccupiedQuantityRemoved;

    public Boolean getIsPropertyInventoryItemOccupiedQuantityRemoved()
    {
        return this.isPropertyInventoryItemOccupiedQuantityRemoved;
    }

    public void setIsPropertyInventoryItemOccupiedQuantityRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemOccupiedQuantityRemoved = removed;
    }

    private Boolean isPropertyInventoryItemVirtualQuantityRemoved;

    public Boolean getIsPropertyInventoryItemVirtualQuantityRemoved()
    {
        return this.isPropertyInventoryItemVirtualQuantityRemoved;
    }

    public void setIsPropertyInventoryItemVirtualQuantityRemoved(Boolean removed)
    {
        this.isPropertyInventoryItemVirtualQuantityRemoved = removed;
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
        command.setOnHandQuantity(this.getOnHandQuantity());
        command.setInTransitQuantity(this.getInTransitQuantity());
        command.setReservedQuantity(this.getReservedQuantity());
        command.setOccupiedQuantity(this.getOccupiedQuantity());
        command.setVirtualQuantity(this.getVirtualQuantity());
        command.setSource(this.getSource());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setInventoryItemOnHandQuantity(this.getInventoryItemOnHandQuantity());
        command.setInventoryItemInTransitQuantity(this.getInventoryItemInTransitQuantity());
        command.setInventoryItemReservedQuantity(this.getInventoryItemReservedQuantity());
        command.setInventoryItemOccupiedQuantity(this.getInventoryItemOccupiedQuantity());
        command.setInventoryItemVirtualQuantity(this.getInventoryItemVirtualQuantity());
        command.setInventoryItemCreatedBy(this.getInventoryItemCreatedBy());
        command.setInventoryItemCreatedAt(this.getInventoryItemCreatedAt());
        command.setInventoryItemUpdatedBy(this.getInventoryItemUpdatedBy());
        command.setInventoryItemUpdatedAt(this.getInventoryItemUpdatedAt());
    }

    public InventoryItemEntryMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
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
        command.setIsPropertyOnHandQuantityRemoved(this.getIsPropertyOnHandQuantityRemoved());
        command.setIsPropertyInTransitQuantityRemoved(this.getIsPropertyInTransitQuantityRemoved());
        command.setIsPropertyReservedQuantityRemoved(this.getIsPropertyReservedQuantityRemoved());
        command.setIsPropertyOccupiedQuantityRemoved(this.getIsPropertyOccupiedQuantityRemoved());
        command.setIsPropertyVirtualQuantityRemoved(this.getIsPropertyVirtualQuantityRemoved());
        command.setIsPropertySourceRemoved(this.getIsPropertySourceRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyInventoryItemOnHandQuantityRemoved(this.getIsPropertyInventoryItemOnHandQuantityRemoved());
        command.setIsPropertyInventoryItemInTransitQuantityRemoved(this.getIsPropertyInventoryItemInTransitQuantityRemoved());
        command.setIsPropertyInventoryItemReservedQuantityRemoved(this.getIsPropertyInventoryItemReservedQuantityRemoved());
        command.setIsPropertyInventoryItemOccupiedQuantityRemoved(this.getIsPropertyInventoryItemOccupiedQuantityRemoved());
        command.setIsPropertyInventoryItemVirtualQuantityRemoved(this.getIsPropertyInventoryItemVirtualQuantityRemoved());
        command.setIsPropertyInventoryItemCreatedByRemoved(this.getIsPropertyInventoryItemCreatedByRemoved());
        command.setIsPropertyInventoryItemCreatedAtRemoved(this.getIsPropertyInventoryItemCreatedAtRemoved());
        command.setIsPropertyInventoryItemUpdatedByRemoved(this.getIsPropertyInventoryItemUpdatedByRemoved());
        command.setIsPropertyInventoryItemUpdatedAtRemoved(this.getIsPropertyInventoryItemUpdatedAtRemoved());
    }

    public static class CreateInventoryItemEntryMvoDto extends CreateOrMergePatchInventoryItemEntryMvoDto
    {
        public CreateInventoryItemEntryMvoDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

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
        public MergePatchInventoryItemEntryMvoDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

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

