package org.dddml.wms.domain.sellableinventoryitem;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface SellableInventoryItemEntryStates extends Iterable<SellableInventoryItemEntryState>, Saveable
{
    SellableInventoryItemEntryState get(Long entrySeqId);

    SellableInventoryItemEntryState get(Long entrySeqId, boolean forCreation);

    SellableInventoryItemEntryState get(Long entrySeqId, boolean forCreation, boolean nullAllowed);

    void remove(SellableInventoryItemEntryState state);

    void addToSave(SellableInventoryItemEntryState state);

}


