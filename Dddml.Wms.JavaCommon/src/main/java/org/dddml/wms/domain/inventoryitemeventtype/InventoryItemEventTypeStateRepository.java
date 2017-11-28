package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemEventTypeStateRepository
{
    InventoryItemEventTypeState get(String id, boolean nullAllowed);

    void save(InventoryItemEventTypeState state);

}

