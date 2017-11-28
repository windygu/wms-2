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

        private InventoryItemEventVO eventVO;

        public InventoryItemEventVO getEventVO()
        {
            return this.eventVO;
        }

        public void setEventVO(InventoryItemEventVO eventVO)
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

