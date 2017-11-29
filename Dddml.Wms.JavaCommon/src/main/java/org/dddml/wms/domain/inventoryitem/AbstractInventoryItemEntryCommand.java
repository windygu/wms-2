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

        private InventoryItemSourceVO source;

        public InventoryItemSourceVO getSource()
        {
            return this.source;
        }

        public void setSource(InventoryItemSourceVO source)
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

