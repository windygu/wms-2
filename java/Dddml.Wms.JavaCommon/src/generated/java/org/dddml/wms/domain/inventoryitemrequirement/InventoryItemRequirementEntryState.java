package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.Set;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryEvent.*;

public interface InventoryItemRequirementEntryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    Long getEntrySeqId();

    BigDecimal getQuantity();

    InventoryPRTriggeredId getSourceEventId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    InventoryItemId getInventoryItemRequirementId();

    String getCommandId();

    interface MutableInventoryItemRequirementEntryState extends InventoryItemRequirementEntryState {
        void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId);

        void setEntrySeqId(Long entrySeqId);

        void setQuantity(BigDecimal quantity);

        void setSourceEventId(InventoryPRTriggeredId sourceEventId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e);

    }

    interface SqlInventoryItemRequirementEntryState extends MutableInventoryItemRequirementEntryState {
        InventoryItemRequirementEntryId getInventoryItemRequirementEntryId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

