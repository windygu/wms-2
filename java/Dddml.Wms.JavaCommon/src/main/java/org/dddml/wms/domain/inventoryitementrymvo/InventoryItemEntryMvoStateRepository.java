package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEntryMvoStateRepository
{
    InventoryItemEntryMvoState get(InventoryItemEntryId id, boolean nullAllowed);

    void save(InventoryItemEntryMvoState state);

}

