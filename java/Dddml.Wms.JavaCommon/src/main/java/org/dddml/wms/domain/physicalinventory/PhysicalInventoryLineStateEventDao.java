package org.dddml.wms.domain.physicalinventory;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PhysicalInventoryLineStateEventDao
{
    void save(PhysicalInventoryLineStateEvent e);

    Iterable<PhysicalInventoryLineStateEvent> findByPhysicalInventoryStateEventId(PhysicalInventoryStateEventId physicalInventoryStateEventId);

}

