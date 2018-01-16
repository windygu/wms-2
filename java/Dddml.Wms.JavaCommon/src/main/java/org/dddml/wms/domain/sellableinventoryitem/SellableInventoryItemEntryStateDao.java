package org.dddml.wms.domain.sellableinventoryitem;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface SellableInventoryItemEntryStateDao
{
    SellableInventoryItemEntryState get(SellableInventoryItemEntryId id, boolean nullAllowed);

    void save(SellableInventoryItemEntryState state);

    Iterable<SellableInventoryItemEntryState> findBySellableInventoryItemId(InventoryItemId sellableInventoryItemId);

    void delete(SellableInventoryItemEntryState state);
}


