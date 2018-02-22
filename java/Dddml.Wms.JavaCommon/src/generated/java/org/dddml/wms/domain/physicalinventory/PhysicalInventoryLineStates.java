package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface PhysicalInventoryLineStates extends Iterable<PhysicalInventoryLineState>, Saveable
{
    PhysicalInventoryLineState get(InventoryItemId inventoryItemId);

    PhysicalInventoryLineState get(InventoryItemId inventoryItemId, boolean forCreation);

    PhysicalInventoryLineState get(InventoryItemId inventoryItemId, boolean forCreation, boolean nullAllowed);

    void remove(PhysicalInventoryLineState state);

    void addToSave(PhysicalInventoryLineState state);

}


