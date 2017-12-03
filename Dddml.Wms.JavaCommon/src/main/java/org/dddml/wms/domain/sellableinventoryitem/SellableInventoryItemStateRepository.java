package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public interface SellableInventoryItemStateRepository
{
    SellableInventoryItemState get(InventoryItemId id, boolean nullAllowed);

    void save(SellableInventoryItemState state);

}

