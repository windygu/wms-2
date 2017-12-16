package org.dddml.wms.domain.orderheader;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderHeaderStateRepository
{
    OrderHeaderState get(String id, boolean nullAllowed);

    void save(OrderHeaderState state);

}

