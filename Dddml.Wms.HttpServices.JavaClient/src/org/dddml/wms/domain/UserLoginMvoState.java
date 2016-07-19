package org.dddml.wms.domain;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.UserLoginMvoStateEvent.*;

public interface UserLoginMvoState
{
    UserLoginId getUserLoginId();

    void setUserLoginId(UserLoginId userLoginId);

    Long getVersion();

    void setVersion(Long version);

    Boolean getActive();

    void setActive(Boolean active);

    String getUserUserName();

    void setUserUserName(String userUserName);

    Integer getUserAccessFailedCount();

    void setUserAccessFailedCount(Integer userAccessFailedCount);

    String getUserEmail();

    void setUserEmail(String userEmail);

    Boolean getUserEmailConfirmed();

    void setUserEmailConfirmed(Boolean userEmailConfirmed);

    Boolean getUserLockoutEnabled();

    void setUserLockoutEnabled(Boolean userLockoutEnabled);

    Date getUserLockoutEndDateUtc();

    void setUserLockoutEndDateUtc(Date userLockoutEndDateUtc);

    String getUserPasswordHash();

    void setUserPasswordHash(String userPasswordHash);

    String getUserPhoneNumber();

    void setUserPhoneNumber(String userPhoneNumber);

    Boolean getUserPhoneNumberConfirmed();

    void setUserPhoneNumberConfirmed(Boolean userPhoneNumberConfirmed);

    Boolean getUserTwoFactorEnabled();

    void setUserTwoFactorEnabled(Boolean userTwoFactorEnabled);

    String getUserSecurityStamp();

    void setUserSecurityStamp(String userSecurityStamp);

    Long getUserVersion();

    void setUserVersion(Long userVersion);

    String getUserCreatedBy();

    void setUserCreatedBy(String userCreatedBy);

    Date getUserCreatedAt();

    void setUserCreatedAt(Date userCreatedAt);

    String getUserUpdatedBy();

    void setUserUpdatedBy(String userUpdatedBy);

    Date getUserUpdatedAt();

    void setUserUpdatedAt(Date userUpdatedAt);

    Boolean getUserActive();

    void setUserActive(Boolean userActive);

    Boolean getUserDeleted();

    void setUserDeleted(Boolean userDeleted);


    boolean isStateUnsaved();


    void when(UserLoginMvoStateCreated e);

    void when(UserLoginMvoStateMergePatched e);

    void when(UserLoginMvoStateDeleted e);

    void mutate(Event e);

    
}

