package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface OrderRoleStates extends Iterable<OrderRoleState>, Saveable
{
    OrderRoleState get(PartyRoleId partyRoleId);

    //OrderRoleState get(PartyRoleId partyRoleId, boolean forCreation);

    //OrderRoleState get(PartyRoleId partyRoleId, boolean forCreation, boolean nullAllowed);

    void remove(OrderRoleState state);

    void add(OrderRoleState state);

}


