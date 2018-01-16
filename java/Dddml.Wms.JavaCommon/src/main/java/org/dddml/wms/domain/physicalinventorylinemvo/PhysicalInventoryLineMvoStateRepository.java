package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PhysicalInventoryLineMvoStateRepository
{
    PhysicalInventoryLineMvoState get(PhysicalInventoryLineId id, boolean nullAllowed);

    void save(PhysicalInventoryLineMvoState state);

}

