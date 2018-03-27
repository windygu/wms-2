package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public interface OrderStateRepository
{
    OrderState get(String id, boolean nullAllowed);

    void save(OrderState state);

}

