package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemStateRepository
{
    InventoryItemState get(InventoryItemId id, boolean nullAllowed);

    void save(InventoryItemState state);

}

