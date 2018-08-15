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
     * Occurred At
     */
    private java.sql.Timestamp occurredAt;

    public java.sql.Timestamp getOccurredAt()
    {
        return this.occurredAt;
    }

    public void setOccurredAt(java.sql.Timestamp occurredAt)
    {
        this.occurredAt = occurredAt;
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

    private Boolean isPropertyOccurredAtRemoved;

    public Boolean getIsPropertyOccurredAtRemoved()
    {
        return this.isPropertyOccurredAtRemoved;
    }

    public void setIsPropertyOccurredAtRemoved(Boolean removed)
    {
        this.isPropertyOccurredAtRemoved = removed;
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

    public static class CreateInventoryItemEntryDto extends CreateOrMergePatchInventoryItemEntryDto
    {
        public CreateInventoryItemEntryDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

}

