package org.dddml.wms.domain;

import java.util.Date;

public interface UserRoleStateDao
{
    UserRoleState get(UserRoleId id);

    UserRoleState get(UserRoleId id, boolean nullAllowed);

    void save(UserRoleState state);

    Iterable<UserRoleState> findByUserId(String userId);

    void delete(UserRoleState state);
}


