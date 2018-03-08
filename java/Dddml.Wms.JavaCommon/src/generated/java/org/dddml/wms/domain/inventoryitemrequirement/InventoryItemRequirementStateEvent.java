package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemRequirementStateEvent extends Event
{
    InventoryItemRequirementEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal quantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemRequirementStateCreated extends InventoryItemRequirementStateEvent
    {
        Iterable<InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated> getInventoryItemRequirementEntryEvents();
        
        void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated e);

        InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(Long entrySeqId);

    
    }


    interface InventoryItemRequirementStateMergePatched extends InventoryItemRequirementStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Iterable<InventoryItemRequirementEntryStateEvent> getInventoryItemRequirementEntryEvents();
        
        void addInventoryItemRequirementEntryEvent(InventoryItemRequirementEntryStateEvent e);

        InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(Long entrySeqId);


    }


}

