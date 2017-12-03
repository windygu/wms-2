package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryPRTriggeredStateRepository
{
    InventoryPRTriggeredState get(InventoryPRTriggeredId id, boolean nullAllowed);

    void save(InventoryPRTriggeredState state);

}

