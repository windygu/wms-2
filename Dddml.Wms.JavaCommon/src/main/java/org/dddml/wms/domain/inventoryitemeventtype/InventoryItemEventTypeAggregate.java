package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemEventTypeAggregate
{
    InventoryItemEventTypeState getState();

    List<Event> getChanges();

    void create(InventoryItemEventTypeCommand.CreateInventoryItemEventType c);

    void mergePatch(InventoryItemEventTypeCommand.MergePatchInventoryItemEventType c);

    void delete(InventoryItemEventTypeCommand.DeleteInventoryItemEventType c);

    void throwOnInvalidStateTransition(Command c);
}

