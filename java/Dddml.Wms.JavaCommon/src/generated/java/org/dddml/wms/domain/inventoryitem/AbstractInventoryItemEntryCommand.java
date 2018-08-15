package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemEntryCommand extends AbstractCommand implements InventoryItemEntryCommand
{
    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
    }

    private InventoryItemId inventoryItemId;

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }


    public static abstract class AbstractCreateOrMergePatchInventoryItemEntry extends AbstractInventoryItemEntryCommand implements CreateOrMergePatchInventoryItemEntry
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

        private InventoryItemSourceInfo source;

        public InventoryItemSourceInfo getSource()
        {
            return this.source;
        }

        public void setSource(InventoryItemSourceInfo source)
        {
            this.source = source;
        }

        private java.sql.Timestamp occuredAt;

        public java.sql.Timestamp getOccuredAt()
        {
            return this.occuredAt;
        }

        public void setOccuredAt(java.sql.Timestamp occuredAt)
        {
            this.occuredAt = occuredAt;
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

    }

    public static abstract class AbstractCreateInventoryItemEntry extends AbstractCreateOrMergePatchInventoryItemEntry implements CreateInventoryItemEntry
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class SimpleCreateInventoryItemEntry extends AbstractCreateInventoryItemEntry
    {
    }

    

}

