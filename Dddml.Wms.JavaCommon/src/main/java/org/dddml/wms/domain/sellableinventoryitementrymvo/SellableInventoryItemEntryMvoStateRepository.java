package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface SellableInventoryItemEntryMvoStateRepository
{
    SellableInventoryItemEntryMvoState get(SellableInventoryItemEntryId id, boolean nullAllowed);

    void save(SellableInventoryItemEntryMvoState state);

}

