package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface PicklistRoleStates extends Iterable<PicklistRoleState>, Saveable
{
    PicklistRoleState get(PartyRoleId partyRoleId);

    //PicklistRoleState get(PartyRoleId partyRoleId, boolean forCreation);

    //PicklistRoleState get(PartyRoleId partyRoleId, boolean forCreation, boolean nullAllowed);

    void remove(PicklistRoleState state);

    void add(PicklistRoleState state);

}


