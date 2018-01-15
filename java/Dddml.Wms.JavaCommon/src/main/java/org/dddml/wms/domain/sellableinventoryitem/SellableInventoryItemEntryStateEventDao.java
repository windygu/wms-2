package org.dddml.wms.domain.sellableinventoryitem;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface SellableInventoryItemEntryStateEventDao
{
    void save(SellableInventoryItemEntryStateEvent e);

    Iterable<SellableInventoryItemEntryStateEvent> findBySellableInventoryItemStateEventId(SellableInventoryItemStateEventId sellableInventoryItemStateEventId);

}

