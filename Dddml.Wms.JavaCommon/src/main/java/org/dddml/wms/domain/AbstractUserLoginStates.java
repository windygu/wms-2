package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractUserLoginStates implements UserLoginStates
{
    protected UserLoginStateDao getUserLoginStateDao()
    {
        return (UserLoginStateDao)ApplicationContext.current.get("UserLoginStateDao");
    }

    private UserState userState;

    private Map<UserLoginId, UserLoginState> loadedUserLoginStates = new HashMap<UserLoginId, UserLoginState>();

    private Map<UserLoginId, UserLoginState> removedUserLoginStates = new HashMap<UserLoginId, UserLoginState>();

    protected Iterable<UserLoginState> getLoadedUserLoginStates() {
        return this.loadedUserLoginStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<UserLoginState> getInnerIterable() {
        if (!getForReapplying()) {
            return getUserLoginStateDao().findByUserId(userState.getUserId());
        } else {
            List<UserLoginState> ss = new ArrayList<UserLoginState>();
            for (UserLoginState s : loadedUserLoginStates.values()) {
                if (!(removedUserLoginStates.containsKey(s.getUserLoginId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractUserLoginStates(UserState outerState) {
        this.userState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<UserLoginState> iterator() {
        return getInnerIterable().iterator();
    }

    public UserLoginState get(LoginKey loginKey) {
        return get(loginKey, false, false);
    }

    public UserLoginState get(LoginKey loginKey, boolean forCreation) {
        return get(loginKey, forCreation, false);
    }

    public UserLoginState get(LoginKey loginKey, boolean forCreation, boolean nullAllowed) {
        UserLoginId globalId = new UserLoginId(userState.getUserId(), loginKey);
        if (loadedUserLoginStates.containsKey(globalId)) {
            return loadedUserLoginStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            UserLoginState state = new AbstractUserLoginState.SimpleUserLoginState(getForReapplying());
            state.setUserLoginId(globalId);
            loadedUserLoginStates.put(globalId, state);
            return state;
        } else {
            UserLoginState state = getUserLoginStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedUserLoginStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(UserLoginState state)
    {
        this.removedUserLoginStates.put(state.getUserLoginId(), state);
    }

    public void addToSave(UserLoginState state)
    {
        this.loadedUserLoginStates.put(state.getUserLoginId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (UserLoginState s : this.getLoadedUserLoginStates()) {
            getUserLoginStateDao().save(s);
        }
        for (UserLoginState s : this.removedUserLoginStates.values()) {
            getUserLoginStateDao().delete(s);
        }
    }

    //endregion

}


