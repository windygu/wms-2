package org.dddml.wms.domain;

import java.util.Date;

public interface UserLoginStateDao
{
    UserLoginState get(UserLoginId id);

    UserLoginState get(UserLoginId id, boolean nullAllowed);

    void save(UserLoginState state);

    Iterable<UserLoginState> findByUserId(String userId);

    void delete(UserLoginState state);
}


