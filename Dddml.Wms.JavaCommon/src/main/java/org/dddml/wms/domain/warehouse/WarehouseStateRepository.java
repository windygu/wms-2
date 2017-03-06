package org.dddml.wms.domain.warehouse;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface WarehouseStateRepository
{
    WarehouseState get(String id, boolean nullAllowed);
    
    void save(WarehouseState state);

}

