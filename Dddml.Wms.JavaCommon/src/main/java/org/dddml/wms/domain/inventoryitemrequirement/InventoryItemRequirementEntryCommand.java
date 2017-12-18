package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InventoryItemRequirementEntryCommand extends Command
{
    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

    InventoryItemId getInventoryItemRequirementId();

    void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);

    interface CreateOrMergePatchInventoryItemRequirementEntry extends InventoryItemRequirementEntryCommand
    {
        BigDecimal getQuantity();

        void setQuantity(BigDecimal quantity);

        InventoryPRTriggeredId getSourceEventId();

        void setSourceEventId(InventoryPRTriggeredId sourceEventId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItemRequirementEntry extends CreateOrMergePatchInventoryItemRequirementEntry
    {
    }

}

