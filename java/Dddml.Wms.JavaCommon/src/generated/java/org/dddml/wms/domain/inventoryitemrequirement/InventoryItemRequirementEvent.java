package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemRequirementEvent extends Event
{
    InventoryItemRequirementEventId getInventoryItemRequirementEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemRequirementStateEvent extends InventoryItemRequirementEvent {
        BigDecimal getQuantity();

        void setQuantity(BigDecimal quantity);

    }

    interface InventoryItemRequirementStateCreated extends InventoryItemRequirementStateEvent
    {
        Iterable<InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated> getInventoryItemRequirementEntryEvents();
        
        void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e);

        InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(Long entrySeqId);

    
    }


    interface InventoryItemRequirementStateMergePatched extends InventoryItemRequirementStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Iterable<InventoryItemRequirementEntryEvent> getInventoryItemRequirementEntryEvents();
        
        void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryEvent e);

        InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(Long entrySeqId);


    }


}

