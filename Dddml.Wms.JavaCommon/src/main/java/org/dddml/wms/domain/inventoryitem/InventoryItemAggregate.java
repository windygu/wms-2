package org.dddml.wms.domain.inventoryitem;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemAggregate
{
    InventoryItemState getState();

    List<Event> getChanges();

    void create(InventoryItemCommand.CreateInventoryItem c);

    void mergePatch(InventoryItemCommand.MergePatchInventoryItem c);

    void throwOnInvalidStateTransition(Command c);
}

