package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface InventoryItemEntryStates extends Iterable<InventoryItemEntryState>, Saveable
{
    InventoryItemEntryState get(Long entrySeqId);

    InventoryItemEntryState get(Long entrySeqId, boolean forCreation);

    InventoryItemEntryState get(Long entrySeqId, boolean forCreation, boolean nullAllowed);

    void remove(InventoryItemEntryState state);

    void addToSave(InventoryItemEntryState state);

}


