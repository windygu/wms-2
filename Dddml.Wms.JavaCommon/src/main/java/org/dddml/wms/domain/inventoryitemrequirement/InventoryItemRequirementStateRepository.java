package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementStateRepository
{
    InventoryItemRequirementState get(InventoryItemId id, boolean nullAllowed);

    void save(InventoryItemRequirementState state);

}

