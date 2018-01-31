package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemRequirementEntryCommand extends AbstractCommand implements InventoryItemRequirementEntryCommand
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

    private InventoryItemId inventoryItemRequirementId;

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
    }


    public static abstract class AbstractCreateOrMergePatchInventoryItemRequirementEntry extends AbstractInventoryItemRequirementEntryCommand implements CreateOrMergePatchInventoryItemRequirementEntry
    {
        private BigDecimal quantity;

        public BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(BigDecimal quantity)
        {
            this.quantity = quantity;
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

    public static abstract class AbstractCreateInventoryItemRequirementEntry extends AbstractCreateOrMergePatchInventoryItemRequirementEntry implements CreateInventoryItemRequirementEntry
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class SimpleCreateInventoryItemRequirementEntry extends AbstractCreateInventoryItemRequirementEntry
    {
    }

    

}

