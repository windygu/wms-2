package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractUserPermissionStates implements UserPermissionStates
{
    protected UserPermissionStateDao getUserPermissionStateDao()
    {
        return (UserPermissionStateDao)ApplicationContext.current.get("UserPermissionStateDao");
    }

    private UserState userState;

    private Map<UserPermissionId, UserPermissionState> loadedUserPermissionStates = new HashMap<UserPermissionId, UserPermissionState>();

    private Map<UserPermissionId, UserPermissionState> removedUserPermissionStates = new HashMap<UserPermissionId, UserPermissionState>();

    protected Iterable<UserPermissionState> getLoadedUserPermissionStates() {
        return this.loadedUserPermissionStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<UserPermissionState> getInnerIterable() {
        if (!getForReapplying()) {
            return getUserPermissionStateDao().findByUserId(userState.getUserId());
        } else {
            List<UserPermissionState> ss = new ArrayList<UserPermissionState>();
            for (UserPermissionState s : loadedUserPermissionStates.values()) {
                if (!(removedUserPermissionStates.containsKey(s.getUserPermissionId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractUserPermissionStates(UserState outerState) {
        this.userState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<UserPermissionState> iterator() {
        return getInnerIterable().iterator();
    }

    public UserPermissionState get(String permissionId) {
        return get(permissionId, false, false);
    }

    public UserPermissionState get(String permissionId, boolean forCreation) {
        return get(permissionId, forCreation, false);
    }

    public UserPermissionState get(String permissionId, boolean forCreation, boolean nullAllowed) {
        UserPermissionId globalId = new UserPermissionId(userState.getUserId(), permissionId);
        if (loadedUserPermissionStates.containsKey(globalId)) {
            return loadedUserPermissionStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            UserPermissionState state = new AbstractUserPermissionState.SimpleUserPermissionState(getForReapplying());
            state.setUserPermissionId(globalId);
            loadedUserPermissionStates.put(globalId, state);
            return state;
        } else {
            UserPermissionState state = getUserPermissionStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedUserPermissionStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(UserPermissionState state)
    {
        this.removedUserPermissionStates.put(state.getUserPermissionId(), state);
    }

    public void addToSave(UserPermissionState state)
    {
        this.loadedUserPermissionStates.put(state.getUserPermissionId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (UserPermissionState s : this.getLoadedUserPermissionStates()) {
            getUserPermissionStateDao().save(s);
        }
        for (UserPermissionState s : this.removedUserPermissionStates.values()) {
            getUserPermissionStateDao().delete(s);
        }
    }

    //endregion

}


