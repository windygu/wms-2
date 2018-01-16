package org.dddml.wms.domain.sellableinventoryitem;

import java.util.List;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface SellableInventoryItemAggregate
{
    SellableInventoryItemState getState();

    List<Event> getChanges();

    void create(SellableInventoryItemCommand.CreateSellableInventoryItem c);

    void mergePatch(SellableInventoryItemCommand.MergePatchSellableInventoryItem c);

    void throwOnInvalidStateTransition(Command c);
}

