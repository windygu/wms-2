package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEntryEventDao
{
    void save(InventoryItemEntryEvent e);

    Iterable<InventoryItemEntryEvent> findByInventoryItemEventId(InventoryItemEventId inventoryItemEventId);

}

