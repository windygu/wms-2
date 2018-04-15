package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementEntryEventDao
{
    void save(InventoryItemRequirementEntryEvent e);

    Iterable<InventoryItemRequirementEntryEvent> findByInventoryItemRequirementEventId(InventoryItemRequirementEventId inventoryItemRequirementEventId);

}

