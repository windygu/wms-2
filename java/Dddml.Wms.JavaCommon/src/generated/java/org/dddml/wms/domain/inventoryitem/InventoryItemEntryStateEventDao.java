package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEntryStateEventDao
{
    void save(InventoryItemEntryStateEvent e);

    Iterable<InventoryItemEntryStateEvent> findByInventoryItemEventId(InventoryItemEventId inventoryItemEventId);

}

