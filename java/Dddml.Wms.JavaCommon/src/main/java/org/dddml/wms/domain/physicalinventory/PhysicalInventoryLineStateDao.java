package org.dddml.wms.domain.physicalinventory;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PhysicalInventoryLineStateDao
{
    PhysicalInventoryLineState get(PhysicalInventoryLineId id, boolean nullAllowed);

    void save(PhysicalInventoryLineState state);

    Iterable<PhysicalInventoryLineState> findByPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber);

    void delete(PhysicalInventoryLineState state);
}


