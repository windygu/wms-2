package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractUserRoleStates implements UserRoleStates
{
    protected UserRoleStateDao getUserRoleStateDao()
    {
        return (UserRoleStateDao)ApplicationContext.current.get("UserRoleStateDao");
    }

    private UserState userState;

    private Map<UserRoleId, UserRoleState> loadedUserRoleStates = new HashMap<UserRoleId, UserRoleState>();

    private Map<UserRoleId, UserRoleState> removedUserRoleStates = new HashMap<UserRoleId, UserRoleState>();

    protected Iterable<UserRoleState> getLoadedUserRoleStates() {
        return this.loadedUserRoleStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<UserRoleState> getInnerIterable() {
        if (!getForReapplying()) {
            return getUserRoleStateDao().findByUserId(userState.getUserId());
        } else {
            List<UserRoleState> ss = new ArrayList<UserRoleState>();
            for (UserRoleState s : loadedUserRoleStates.values()) {
                if (!(removedUserRoleStates.containsKey(s.getUserRoleId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractUserRoleStates(AbstractUserState outerState) {
        this.userState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<UserRoleState> iterator() {
        return getInnerIterable().iterator();
    }

    public UserRoleState get(String roleId) {
        return get(roleId, false, false);
    }

    public UserRoleState get(String roleId, boolean forCreation) {
        return get(roleId, forCreation, false);
    }

    public UserRoleState get(String roleId, boolean forCreation, boolean nullAllowed) {
        UserRoleId globalId = new UserRoleId(userState.getUserId(), roleId);
        if (loadedUserRoleStates.containsKey(globalId)) {
            return loadedUserRoleStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            UserRoleState state = new AbstractUserRoleState.SimpleUserRoleState(getForReapplying());
            state.setUserRoleId(globalId);
            loadedUserRoleStates.put(globalId, state);
            return state;
        } else {
            UserRoleState state = getUserRoleStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedUserRoleStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(UserRoleState state)
    {
        this.removedUserRoleStates.put(state.getUserRoleId(), state);
    }

    public void addToSave(UserRoleState state)
    {
        this.loadedUserRoleStates.put(state.getUserRoleId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (UserRoleState s : this.getLoadedUserRoleStates()) {
            getUserRoleStateDao().save(s);
        }
        for (UserRoleState s : this.removedUserRoleStates.values()) {
            getUserRoleStateDao().delete(s);
        }
    }

    //endregion

}


