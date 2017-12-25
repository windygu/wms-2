package org.dddml.wms.domain.physicalinventory;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface PhysicalInventoryLineStates extends Iterable<PhysicalInventoryLineState>, Saveable
{
    PhysicalInventoryLineState get(String lineNumber);

    PhysicalInventoryLineState get(String lineNumber, boolean forCreation);

    PhysicalInventoryLineState get(String lineNumber, boolean forCreation, boolean nullAllowed);

    void remove(PhysicalInventoryLineState state);

    void addToSave(PhysicalInventoryLineState state);

}


