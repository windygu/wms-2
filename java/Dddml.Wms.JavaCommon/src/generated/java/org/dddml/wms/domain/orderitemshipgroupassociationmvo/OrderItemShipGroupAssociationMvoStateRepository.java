package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderItemShipGroupAssociationMvoStateRepository
{
    OrderItemShipGroupAssociationMvoState get(OrderItemShipGroupAssociationId id, boolean nullAllowed);

    void save(OrderItemShipGroupAssociationMvoState state);

}

