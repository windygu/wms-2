package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.specialization.Saveable;

public interface UserRoleStates extends Iterable<UserRoleState>, Saveable
{
    UserRoleState get(String roleId);

    UserRoleState get(String roleId, boolean forCreation);

    UserRoleState get(String roleId, boolean forCreation, boolean nullAllowed);

    void remove(UserRoleState state);

    void addToSave(UserRoleState state);

}


