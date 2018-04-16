package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemRequirementEntryEvent extends Event
{
    InventoryItemRequirementEntryEventId getInventoryItemRequirementEntryEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemRequirementEntryStateEvent extends InventoryItemRequirementEntryEvent {
        Long getVersion();

        void setVersion(Long version);

        BigDecimal getQuantity();

        void setQuantity(BigDecimal quantity);

        InventoryPRTriggeredId getSourceEventId();

        void setSourceEventId(InventoryPRTriggeredId sourceEventId);

    }

    interface InventoryItemRequirementEntryStateCreated extends InventoryItemRequirementEntryStateEvent
    {
    
    }


}

