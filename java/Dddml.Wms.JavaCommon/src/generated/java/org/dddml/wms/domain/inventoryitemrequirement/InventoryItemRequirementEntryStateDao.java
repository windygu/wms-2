package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface InventoryItemRequirementEntryStateDao
{
    InventoryItemRequirementEntryState get(InventoryItemRequirementEntryId id, boolean nullAllowed);

    void save(InventoryItemRequirementEntryState state);

    Iterable<InventoryItemRequirementEntryState> findByInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);

    void delete(InventoryItemRequirementEntryState state);
}


