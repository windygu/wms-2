package org.dddml.wms.domain;

import java.util.Date;

public interface UserClaimStateDao
{
    UserClaimState get(UserClaimId id);

    UserClaimState get(UserClaimId id, boolean nullAllowed);

    void save(UserClaimState state);

    Iterable<UserClaimState> findByUserId(String userId);

    void delete(UserClaimState state);
}


