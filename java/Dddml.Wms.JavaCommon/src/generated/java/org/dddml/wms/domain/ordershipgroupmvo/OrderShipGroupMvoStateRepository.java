package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderShipGroupMvoStateRepository
{
    OrderShipGroupMvoState get(OrderShipGroupId id, boolean nullAllowed);

    void save(OrderShipGroupMvoState state);

}

