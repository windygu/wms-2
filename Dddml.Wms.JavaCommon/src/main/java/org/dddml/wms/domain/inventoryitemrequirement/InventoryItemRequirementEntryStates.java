package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface InventoryItemRequirementEntryStates extends Iterable<InventoryItemRequirementEntryState>, Saveable
{
    InventoryItemRequirementEntryState get(Long entrySeqId);

    InventoryItemRequirementEntryState get(Long entrySeqId, boolean forCreation);

    InventoryItemRequirementEntryState get(Long entrySeqId, boolean forCreation, boolean nullAllowed);

    void remove(InventoryItemRequirementEntryState state);

    void addToSave(InventoryItemRequirementEntryState state);

}


