package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEvent.*;

public interface InventoryItemRequirementState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getInventoryItemRequirementId();

    BigDecimal getQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    String getCommandId();

    EntityStateCollection<Long, InventoryItemRequirementEntryState> getEntries();

    interface MutableInventoryItemRequirementState extends InventoryItemRequirementState {
        void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);

        void setQuantity(BigDecimal quantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(InventoryItemRequirementEvent.InventoryItemRequirementStateCreated e);

        void when(InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched e);

    }

    interface SqlInventoryItemRequirementState extends MutableInventoryItemRequirementState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

