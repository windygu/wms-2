package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementEntryStateEventDao
{
    void save(InventoryItemRequirementEntryStateEvent e);

    Iterable<InventoryItemRequirementEntryStateEvent> findByInventoryItemRequirementStateEventId(InventoryItemRequirementStateEventId inventoryItemRequirementStateEventId);

}

