package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PhysicalInventoryLineEventDao
{
    void save(PhysicalInventoryLineEvent e);

    Iterable<PhysicalInventoryLineEvent> findByPhysicalInventoryEventId(PhysicalInventoryEventId physicalInventoryEventId);

}

