package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrderRoleMvoStateRepository
{
    OrderRoleMvoState get(OrderRoleId id, boolean nullAllowed);

    void save(OrderRoleMvoState state);

}

