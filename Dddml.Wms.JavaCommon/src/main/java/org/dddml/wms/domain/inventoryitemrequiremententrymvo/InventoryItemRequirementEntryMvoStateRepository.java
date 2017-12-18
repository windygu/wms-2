package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementEntryMvoStateRepository
{
    InventoryItemRequirementEntryMvoState get(InventoryItemRequirementEntryId id, boolean nullAllowed);

    void save(InventoryItemRequirementEntryMvoState state);

}

