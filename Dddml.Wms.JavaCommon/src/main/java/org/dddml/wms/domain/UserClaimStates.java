package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.specialization.Saveable;

public interface UserClaimStates extends Iterable<UserClaimState>, Saveable
{
    UserClaimState get(Integer claimId);

    UserClaimState get(Integer claimId, boolean forCreation);

    UserClaimState get(Integer claimId, boolean forCreation, boolean nullAllowed);

    void remove(UserClaimState state);

    void addToSave(UserClaimState state);

}


