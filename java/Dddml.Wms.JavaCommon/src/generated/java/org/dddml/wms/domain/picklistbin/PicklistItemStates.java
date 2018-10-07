package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface PicklistItemStates extends Iterable<PicklistItemState>, Saveable
{
    PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    //PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, boolean forCreation);

    //PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, boolean forCreation, boolean nullAllowed);

    void remove(PicklistItemState state);

    void add(PicklistItemState state);

}


