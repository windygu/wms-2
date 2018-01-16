package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractSellableInventoryItemEntryCommand extends AbstractCommand implements SellableInventoryItemEntryCommand
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

    private InventoryItemId sellableInventoryItemId;

    public InventoryItemId getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
    }


    public static abstract class AbstractCreateOrMergePatchSellableInventoryItemEntry extends AbstractSellableInventoryItemEntryCommand implements CreateOrMergePatchSellableInventoryItemEntry
    {
        private BigDecimal sellableQuantity;

        public BigDecimal getSellableQuantity()
        {
            return this.sellableQuantity;
        }

        public void setSellableQuantity(BigDecimal sellableQuantity)
        {
            this.sellableQuantity = sellableQuantity;
        }

        private InventoryPRTriggeredId sourceEventId;

        public InventoryPRTriggeredId getSourceEventId()
        {
            return this.sourceEventId;
        }

        public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
        {
            this.sourceEventId = sourceEventId;
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

    public static abstract class AbstractCreateSellableInventoryItemEntry extends AbstractCreateOrMergePatchSellableInventoryItemEntry implements CreateSellableInventoryItemEntry
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class SimpleCreateSellableInventoryItemEntry extends AbstractCreateSellableInventoryItemEntry
    {
    }

    

}

