package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface PhysicalInventoryStateRepository
{
    PhysicalInventoryState get(String id, boolean nullAllowed);

    void save(PhysicalInventoryState state);

}

