package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEntryStateDao
{
    InventoryItemEntryState get(InventoryItemEntryId id, boolean nullAllowed);

    void save(InventoryItemEntryState state);

    Iterable<InventoryItemEntryState> findByInventoryItemId(InventoryItemId inventoryItemId);

    void delete(InventoryItemEntryState state);
}


