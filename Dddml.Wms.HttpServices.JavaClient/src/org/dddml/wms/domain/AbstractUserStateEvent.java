package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public abstract class AbstractUserStateEvent implements UserStateEvent
{
    private UserStateEventId stateEventId;

    public UserStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(UserStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String userName;

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    private Integer accessFailedCount;

    public Integer getAccessFailedCount()
    {
        return this.accessFailedCount;
    }

    public void setAccessFailedCount(Integer accessFailedCount)
    {
        this.accessFailedCount = accessFailedCount;
    }

    private String email;

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    private Boolean emailConfirmed;

    public Boolean getEmailConfirmed()
    {
        return this.emailConfirmed;
    }

    public void setEmailConfirmed(Boolean emailConfirmed)
    {
        this.emailConfirmed = emailConfirmed;
    }

    private Boolean lockoutEnabled;

    public Boolean getLockoutEnabled()
    {
        return this.lockoutEnabled;
    }

    public void setLockoutEnabled(Boolean lockoutEnabled)
    {
        this.lockoutEnabled = lockoutEnabled;
    }

    private Date lockoutEndDateUtc;

    public Date getLockoutEndDateUtc()
    {
        return this.lockoutEndDateUtc;
    }

    public void setLockoutEndDateUtc(Date lockoutEndDateUtc)
    {
        this.lockoutEndDateUtc = lockoutEndDateUtc;
    }

    private String passwordHash;

    public String getPasswordHash()
    {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    private String phoneNumber;

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    private Boolean phoneNumberConfirmed;

    public Boolean getPhoneNumberConfirmed()
    {
        return this.phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed)
    {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    private Boolean twoFactorEnabled;

    public Boolean getTwoFactorEnabled()
    {
        return this.twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled)
    {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    private String securityStamp;

    public String getSecurityStamp()
    {
        return this.securityStamp;
    }

    public void setSecurityStamp(String securityStamp)
    {
        this.securityStamp = securityStamp;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    protected AbstractUserStateEvent() {
    }

    protected AbstractUserStateEvent(UserStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected UserRoleStateEventDao getUserRoleStateEventDao() {
        return (UserRoleStateEventDao)ApplicationContext.current.get("UserRoleStateEventDao");
    }

    protected UserRoleStateEventId newUserRoleStateEventId(String roleId)
    {
        UserRoleStateEventId stateEventId = new UserRoleStateEventId(this.getStateEventId().getUserId(), 
            roleId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(UserRoleStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(UserStateEvent oe, UserRoleStateEvent e)
    {
        if (!oe.getStateEventId().getUserId().equals(e.getStateEventId().getUserId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id UserId %1$s but inner id UserId %2$s", 
                oe.getStateEventId().getUserId(), e.getStateEventId().getUserId());
        }
    }

    protected UserClaimStateEventDao getUserClaimStateEventDao() {
        return (UserClaimStateEventDao)ApplicationContext.current.get("UserClaimStateEventDao");
    }

    protected UserClaimStateEventId newUserClaimStateEventId(Integer claimId)
    {
        UserClaimStateEventId stateEventId = new UserClaimStateEventId(this.getStateEventId().getUserId(), 
            claimId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(UserClaimStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(UserStateEvent oe, UserClaimStateEvent e)
    {
        if (!oe.getStateEventId().getUserId().equals(e.getStateEventId().getUserId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id UserId %1$s but inner id UserId %2$s", 
                oe.getStateEventId().getUserId(), e.getStateEventId().getUserId());
        }
    }

    protected UserPermissionStateEventDao getUserPermissionStateEventDao() {
        return (UserPermissionStateEventDao)ApplicationContext.current.get("UserPermissionStateEventDao");
    }

    protected UserPermissionStateEventId newUserPermissionStateEventId(String permissionId)
    {
        UserPermissionStateEventId stateEventId = new UserPermissionStateEventId(this.getStateEventId().getUserId(), 
            permissionId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(UserPermissionStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(UserStateEvent oe, UserPermissionStateEvent e)
    {
        if (!oe.getStateEventId().getUserId().equals(e.getStateEventId().getUserId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id UserId %1$s but inner id UserId %2$s", 
                oe.getStateEventId().getUserId(), e.getStateEventId().getUserId());
        }
    }

    protected UserLoginStateEventDao getUserLoginStateEventDao() {
        return (UserLoginStateEventDao)ApplicationContext.current.get("UserLoginStateEventDao");
    }

    protected UserLoginStateEventId newUserLoginStateEventId(LoginKey loginKey)
    {
        UserLoginStateEventId stateEventId = new UserLoginStateEventId(this.getStateEventId().getUserId(), 
            loginKey, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(UserLoginStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(UserStateEvent oe, UserLoginStateEvent e)
    {
        if (!oe.getStateEventId().getUserId().equals(e.getStateEventId().getUserId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id UserId %1$s but inner id UserId %2$s", 
                oe.getStateEventId().getUserId(), e.getStateEventId().getUserId());
        }
    }


    public abstract String getStateEventType();


    public static abstract class AbstractUserStateCreated extends AbstractUserStateEvent implements UserStateCreated, Saveable
    {
        public AbstractUserStateCreated() {
        }

        public AbstractUserStateCreated(UserStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<UserRoleStateEventId, UserRoleStateEvent.UserRoleStateCreated> userRoleEvents = new HashMap<UserRoleStateEventId, UserRoleStateEvent.UserRoleStateCreated>();
        
        private Iterable<UserRoleStateEvent.UserRoleStateCreated> readOnlyUserRoleEvents;

        public Iterable<UserRoleStateEvent.UserRoleStateCreated> getUserRoleEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userRoleEvents.values();
            }
            else
            {
                if (readOnlyUserRoleEvents != null) { return readOnlyUserRoleEvents; }
                UserRoleStateEventDao eventDao = getUserRoleStateEventDao();
                List<UserRoleStateEvent.UserRoleStateCreated> eL = new ArrayList<UserRoleStateEvent.UserRoleStateCreated>();
                for (UserRoleStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserRoleStateEvent.UserRoleStateCreated)e);
                }
                return (readOnlyUserRoleEvents = eL);
            }
        }

        public void setUserRoleEvents(Iterable<UserRoleStateEvent.UserRoleStateCreated> es)
        {
            if (es != null)
            {
                for (UserRoleStateEvent.UserRoleStateCreated e : es)
                {
                    addUserRoleEvent(e);
                }
            }
            else { this.userRoleEvents.clear(); }
        }
        
        public void addUserRoleEvent(UserRoleStateEvent.UserRoleStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.userRoleEvents.put(e.getStateEventId(), e);
        }

        public abstract UserRoleStateEvent.UserRoleStateCreated newUserRoleStateCreated(String roleId);
//        {
//            return new UserRoleStateEvent.UserRoleStateCreated(newUserRoleStateEventId(roleId));
//        }

        private Map<UserClaimStateEventId, UserClaimStateEvent.UserClaimStateCreated> userClaimEvents = new HashMap<UserClaimStateEventId, UserClaimStateEvent.UserClaimStateCreated>();
        
        private Iterable<UserClaimStateEvent.UserClaimStateCreated> readOnlyUserClaimEvents;

        public Iterable<UserClaimStateEvent.UserClaimStateCreated> getUserClaimEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userClaimEvents.values();
            }
            else
            {
                if (readOnlyUserClaimEvents != null) { return readOnlyUserClaimEvents; }
                UserClaimStateEventDao eventDao = getUserClaimStateEventDao();
                List<UserClaimStateEvent.UserClaimStateCreated> eL = new ArrayList<UserClaimStateEvent.UserClaimStateCreated>();
                for (UserClaimStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserClaimStateEvent.UserClaimStateCreated)e);
                }
                return (readOnlyUserClaimEvents = eL);
            }
        }

        public void setUserClaimEvents(Iterable<UserClaimStateEvent.UserClaimStateCreated> es)
        {
            if (es != null)
            {
                for (UserClaimStateEvent.UserClaimStateCreated e : es)
                {
                    addUserClaimEvent(e);
                }
            }
            else { this.userClaimEvents.clear(); }
        }
        
        public void addUserClaimEvent(UserClaimStateEvent.UserClaimStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.userClaimEvents.put(e.getStateEventId(), e);
        }

        public abstract UserClaimStateEvent.UserClaimStateCreated newUserClaimStateCreated(Integer claimId);
//        {
//            return new UserClaimStateEvent.UserClaimStateCreated(newUserClaimStateEventId(claimId));
//        }

        private Map<UserPermissionStateEventId, UserPermissionStateEvent.UserPermissionStateCreated> userPermissionEvents = new HashMap<UserPermissionStateEventId, UserPermissionStateEvent.UserPermissionStateCreated>();
        
        private Iterable<UserPermissionStateEvent.UserPermissionStateCreated> readOnlyUserPermissionEvents;

        public Iterable<UserPermissionStateEvent.UserPermissionStateCreated> getUserPermissionEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userPermissionEvents.values();
            }
            else
            {
                if (readOnlyUserPermissionEvents != null) { return readOnlyUserPermissionEvents; }
                UserPermissionStateEventDao eventDao = getUserPermissionStateEventDao();
                List<UserPermissionStateEvent.UserPermissionStateCreated> eL = new ArrayList<UserPermissionStateEvent.UserPermissionStateCreated>();
                for (UserPermissionStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserPermissionStateEvent.UserPermissionStateCreated)e);
                }
                return (readOnlyUserPermissionEvents = eL);
            }
        }

        public void setUserPermissionEvents(Iterable<UserPermissionStateEvent.UserPermissionStateCreated> es)
        {
            if (es != null)
            {
                for (UserPermissionStateEvent.UserPermissionStateCreated e : es)
                {
                    addUserPermissionEvent(e);
                }
            }
            else { this.userPermissionEvents.clear(); }
        }
        
        public void addUserPermissionEvent(UserPermissionStateEvent.UserPermissionStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.userPermissionEvents.put(e.getStateEventId(), e);
        }

        public abstract UserPermissionStateEvent.UserPermissionStateCreated newUserPermissionStateCreated(String permissionId);
//        {
//            return new UserPermissionStateEvent.UserPermissionStateCreated(newUserPermissionStateEventId(permissionId));
//        }

        private Map<UserLoginStateEventId, UserLoginStateEvent.UserLoginStateCreated> userLoginEvents = new HashMap<UserLoginStateEventId, UserLoginStateEvent.UserLoginStateCreated>();
        
        private Iterable<UserLoginStateEvent.UserLoginStateCreated> readOnlyUserLoginEvents;

        public Iterable<UserLoginStateEvent.UserLoginStateCreated> getUserLoginEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userLoginEvents.values();
            }
            else
            {
                if (readOnlyUserLoginEvents != null) { return readOnlyUserLoginEvents; }
                UserLoginStateEventDao eventDao = getUserLoginStateEventDao();
                List<UserLoginStateEvent.UserLoginStateCreated> eL = new ArrayList<UserLoginStateEvent.UserLoginStateCreated>();
                for (UserLoginStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserLoginStateEvent.UserLoginStateCreated)e);
                }
                return (readOnlyUserLoginEvents = eL);
            }
        }

        public void setUserLoginEvents(Iterable<UserLoginStateEvent.UserLoginStateCreated> es)
        {
            if (es != null)
            {
                for (UserLoginStateEvent.UserLoginStateCreated e : es)
                {
                    addUserLoginEvent(e);
                }
            }
            else { this.userLoginEvents.clear(); }
        }
        
        public void addUserLoginEvent(UserLoginStateEvent.UserLoginStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.userLoginEvents.put(e.getStateEventId(), e);
        }

        public abstract UserLoginStateEvent.UserLoginStateCreated newUserLoginStateCreated(LoginKey loginKey);
//        {
//            return new UserLoginStateEvent.UserLoginStateCreated(newUserLoginStateEventId(loginKey));
//        }

        public void save()
        {
            for (UserRoleStateEvent.UserRoleStateCreated e : this.getUserRoleEvents()) {
                getUserRoleStateEventDao().save(e);
            }
            for (UserClaimStateEvent.UserClaimStateCreated e : this.getUserClaimEvents()) {
                getUserClaimStateEventDao().save(e);
            }
            for (UserPermissionStateEvent.UserPermissionStateCreated e : this.getUserPermissionEvents()) {
                getUserPermissionStateEventDao().save(e);
            }
            for (UserLoginStateEvent.UserLoginStateCreated e : this.getUserLoginEvents()) {
                getUserLoginStateEventDao().save(e);
            }
        }
    }


/*
    public static abstract class AbstractUserStateMergePatched extends AbstractUserStateEvent implements UserStateMergePatched, Saveable
    {
        Boolean isPropertyUserNameRemoved();

        void setPropertyUserNameRemoved(Boolean removed);

        Boolean isPropertyAccessFailedCountRemoved();

        void setPropertyAccessFailedCountRemoved(Boolean removed);

        Boolean isPropertyEmailRemoved();

        void setPropertyEmailRemoved(Boolean removed);

        Boolean isPropertyEmailConfirmedRemoved();

        void setPropertyEmailConfirmedRemoved(Boolean removed);

        Boolean isPropertyLockoutEnabledRemoved();

        void setPropertyLockoutEnabledRemoved(Boolean removed);

        Boolean isPropertyLockoutEndDateUtcRemoved();

        void setPropertyLockoutEndDateUtcRemoved(Boolean removed);

        Boolean isPropertyPasswordHashRemoved();

        void setPropertyPasswordHashRemoved(Boolean removed);

        Boolean isPropertyPhoneNumberRemoved();

        void setPropertyPhoneNumberRemoved(Boolean removed);

        Boolean isPropertyPhoneNumberConfirmedRemoved();

        void setPropertyPhoneNumberConfirmedRemoved(Boolean removed);

        Boolean isPropertyTwoFactorEnabledRemoved();

        void setPropertyTwoFactorEnabledRemoved(Boolean removed);

        Boolean isPropertySecurityStampRemoved();

        void setPropertySecurityStampRemoved(Boolean removed);

        Boolean isPropertyActiveRemoved();

        void setPropertyActiveRemoved(Boolean removed);

        Iterable<UserRoleStateEvent> getUserRoleEvents();
        
        void addUserRoleEvent(UserRoleStateEvent e);

        UserRoleStateEvent.UserRoleStateCreated newUserRoleStateCreated(String roleId);

        UserRoleStateEvent.UserRoleStateMergePatched newUserRoleStateMergePatched(String roleId);

        UserRoleStateEvent.UserRoleStateRemoved newUserRoleStateRemoved(String roleId);

        Iterable<UserClaimStateEvent> getUserClaimEvents();
        
        void addUserClaimEvent(UserClaimStateEvent e);

        UserClaimStateEvent.UserClaimStateCreated newUserClaimStateCreated(Integer claimId);

        UserClaimStateEvent.UserClaimStateMergePatched newUserClaimStateMergePatched(Integer claimId);

        UserClaimStateEvent.UserClaimStateRemoved newUserClaimStateRemoved(Integer claimId);

        Iterable<UserPermissionStateEvent> getUserPermissionEvents();
        
        void addUserPermissionEvent(UserPermissionStateEvent e);

        UserPermissionStateEvent.UserPermissionStateCreated newUserPermissionStateCreated(String permissionId);

        UserPermissionStateEvent.UserPermissionStateMergePatched newUserPermissionStateMergePatched(String permissionId);

        UserPermissionStateEvent.UserPermissionStateRemoved newUserPermissionStateRemoved(String permissionId);

        Iterable<UserLoginStateEvent> getUserLoginEvents();
        
        void addUserLoginEvent(UserLoginStateEvent e);

        UserLoginStateEvent.UserLoginStateCreated newUserLoginStateCreated(LoginKey loginKey);

        UserLoginStateEvent.UserLoginStateMergePatched newUserLoginStateMergePatched(LoginKey loginKey);

        UserLoginStateEvent.UserLoginStateRemoved newUserLoginStateRemoved(LoginKey loginKey);


    }
*/

    public static abstract class AbstractUserStateDeleted extends AbstractUserStateEvent implements UserStateDeleted, Saveable
    {
        public AbstractUserStateDeleted() {
        }

        public AbstractUserStateDeleted(UserStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<UserRoleStateEventId, UserRoleStateEvent.UserRoleStateRemoved> userRoleEvents = new HashMap<UserRoleStateEventId, UserRoleStateEvent.UserRoleStateRemoved>();
        
        private Iterable<UserRoleStateEvent.UserRoleStateRemoved> readOnlyUserRoleEvents;

        public Iterable<UserRoleStateEvent.UserRoleStateRemoved> getUserRoleEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userRoleEvents.values();
            }
            else
            {
                if (readOnlyUserRoleEvents != null) { return readOnlyUserRoleEvents; }
                UserRoleStateEventDao eventDao = getUserRoleStateEventDao();
                List<UserRoleStateEvent.UserRoleStateRemoved> eL = new ArrayList<UserRoleStateEvent.UserRoleStateRemoved>();
                for (UserRoleStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserRoleStateEvent.UserRoleStateRemoved)e);
                }
                return (readOnlyUserRoleEvents = eL);
            }
        }

        public void setUserRoleEvents(Iterable<UserRoleStateEvent.UserRoleStateRemoved> es)
        {
            if (es != null)
            {
                for (UserRoleStateEvent.UserRoleStateRemoved e : es)
                {
                    addUserRoleEvent(e);
                }
            }
            else { this.userRoleEvents.clear(); }
        }
        
        public void addUserRoleEvent(UserRoleStateEvent.UserRoleStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.userRoleEvents.put(e.getStateEventId(), e);
        }

        public abstract UserRoleStateEvent.UserRoleStateRemoved newUserRoleStateRemoved(String roleId);
//        {
//            return new UserRoleStateEvent.UserRoleStateRemoved(newUserRoleStateEventId(roleId));
//        }

		
        private Map<UserClaimStateEventId, UserClaimStateEvent.UserClaimStateRemoved> userClaimEvents = new HashMap<UserClaimStateEventId, UserClaimStateEvent.UserClaimStateRemoved>();
        
        private Iterable<UserClaimStateEvent.UserClaimStateRemoved> readOnlyUserClaimEvents;

        public Iterable<UserClaimStateEvent.UserClaimStateRemoved> getUserClaimEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userClaimEvents.values();
            }
            else
            {
                if (readOnlyUserClaimEvents != null) { return readOnlyUserClaimEvents; }
                UserClaimStateEventDao eventDao = getUserClaimStateEventDao();
                List<UserClaimStateEvent.UserClaimStateRemoved> eL = new ArrayList<UserClaimStateEvent.UserClaimStateRemoved>();
                for (UserClaimStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserClaimStateEvent.UserClaimStateRemoved)e);
                }
                return (readOnlyUserClaimEvents = eL);
            }
        }

        public void setUserClaimEvents(Iterable<UserClaimStateEvent.UserClaimStateRemoved> es)
        {
            if (es != null)
            {
                for (UserClaimStateEvent.UserClaimStateRemoved e : es)
                {
                    addUserClaimEvent(e);
                }
            }
            else { this.userClaimEvents.clear(); }
        }
        
        public void addUserClaimEvent(UserClaimStateEvent.UserClaimStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.userClaimEvents.put(e.getStateEventId(), e);
        }

        public abstract UserClaimStateEvent.UserClaimStateRemoved newUserClaimStateRemoved(Integer claimId);
//        {
//            return new UserClaimStateEvent.UserClaimStateRemoved(newUserClaimStateEventId(claimId));
//        }

		
        private Map<UserPermissionStateEventId, UserPermissionStateEvent.UserPermissionStateRemoved> userPermissionEvents = new HashMap<UserPermissionStateEventId, UserPermissionStateEvent.UserPermissionStateRemoved>();
        
        private Iterable<UserPermissionStateEvent.UserPermissionStateRemoved> readOnlyUserPermissionEvents;

        public Iterable<UserPermissionStateEvent.UserPermissionStateRemoved> getUserPermissionEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userPermissionEvents.values();
            }
            else
            {
                if (readOnlyUserPermissionEvents != null) { return readOnlyUserPermissionEvents; }
                UserPermissionStateEventDao eventDao = getUserPermissionStateEventDao();
                List<UserPermissionStateEvent.UserPermissionStateRemoved> eL = new ArrayList<UserPermissionStateEvent.UserPermissionStateRemoved>();
                for (UserPermissionStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserPermissionStateEvent.UserPermissionStateRemoved)e);
                }
                return (readOnlyUserPermissionEvents = eL);
            }
        }

        public void setUserPermissionEvents(Iterable<UserPermissionStateEvent.UserPermissionStateRemoved> es)
        {
            if (es != null)
            {
                for (UserPermissionStateEvent.UserPermissionStateRemoved e : es)
                {
                    addUserPermissionEvent(e);
                }
            }
            else { this.userPermissionEvents.clear(); }
        }
        
        public void addUserPermissionEvent(UserPermissionStateEvent.UserPermissionStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.userPermissionEvents.put(e.getStateEventId(), e);
        }

        public abstract UserPermissionStateEvent.UserPermissionStateRemoved newUserPermissionStateRemoved(String permissionId);
//        {
//            return new UserPermissionStateEvent.UserPermissionStateRemoved(newUserPermissionStateEventId(permissionId));
//        }

		
        private Map<UserLoginStateEventId, UserLoginStateEvent.UserLoginStateRemoved> userLoginEvents = new HashMap<UserLoginStateEventId, UserLoginStateEvent.UserLoginStateRemoved>();
        
        private Iterable<UserLoginStateEvent.UserLoginStateRemoved> readOnlyUserLoginEvents;

        public Iterable<UserLoginStateEvent.UserLoginStateRemoved> getUserLoginEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.userLoginEvents.values();
            }
            else
            {
                if (readOnlyUserLoginEvents != null) { return readOnlyUserLoginEvents; }
                UserLoginStateEventDao eventDao = getUserLoginStateEventDao();
                List<UserLoginStateEvent.UserLoginStateRemoved> eL = new ArrayList<UserLoginStateEvent.UserLoginStateRemoved>();
                for (UserLoginStateEvent e : eventDao.findByUserStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((UserLoginStateEvent.UserLoginStateRemoved)e);
                }
                return (readOnlyUserLoginEvents = eL);
            }
        }

        public void setUserLoginEvents(Iterable<UserLoginStateEvent.UserLoginStateRemoved> es)
        {
            if (es != null)
            {
                for (UserLoginStateEvent.UserLoginStateRemoved e : es)
                {
                    addUserLoginEvent(e);
                }
            }
            else { this.userLoginEvents.clear(); }
        }
        
        public void addUserLoginEvent(UserLoginStateEvent.UserLoginStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.userLoginEvents.put(e.getStateEventId(), e);
        }

        public abstract UserLoginStateEvent.UserLoginStateRemoved newUserLoginStateRemoved(LoginKey loginKey);
//        {
//            return new UserLoginStateEvent.UserLoginStateRemoved(newUserLoginStateEventId(loginKey));
//        }

        public void save()
        {
            for (UserRoleStateEvent.UserRoleStateRemoved e : this.getUserRoleEvents()) {
                getUserRoleStateEventDao().save(e);
            }
            for (UserClaimStateEvent.UserClaimStateRemoved e : this.getUserClaimEvents()) {
                getUserClaimStateEventDao().save(e);
            }
            for (UserPermissionStateEvent.UserPermissionStateRemoved e : this.getUserPermissionEvents()) {
                getUserPermissionStateEventDao().save(e);
            }
            for (UserLoginStateEvent.UserLoginStateRemoved e : this.getUserLoginEvents()) {
                getUserLoginStateEventDao().save(e);
            }
        }
    }

}

