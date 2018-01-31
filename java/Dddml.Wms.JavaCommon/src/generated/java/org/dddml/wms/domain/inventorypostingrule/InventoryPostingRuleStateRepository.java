package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryPostingRuleStateRepository
{
    InventoryPostingRuleState get(String id, boolean nullAllowed);

    void save(InventoryPostingRuleState state);

}

