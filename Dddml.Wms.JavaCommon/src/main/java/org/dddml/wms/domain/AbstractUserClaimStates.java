package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractUserClaimStates implements UserClaimStates
{
    protected UserClaimStateDao getUserClaimStateDao()
    {
        return (UserClaimStateDao)ApplicationContext.current.get("UserClaimStateDao");
    }

    private UserState userState;

    private Map<UserClaimId, UserClaimState> loadedUserClaimStates = new HashMap<UserClaimId, UserClaimState>();

    private Map<UserClaimId, UserClaimState> removedUserClaimStates = new HashMap<UserClaimId, UserClaimState>();

    protected Iterable<UserClaimState> getLoadedUserClaimStates() {
        return this.loadedUserClaimStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<UserClaimState> getInnerIterable() {
        if (!getForReapplying()) {
            return getUserClaimStateDao().findByUserId(userState.getUserId());
        } else {
            List<UserClaimState> ss = new ArrayList<UserClaimState>();
            for (UserClaimState s : loadedUserClaimStates.values()) {
                if (!(removedUserClaimStates.containsKey(s.getUserClaimId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractUserClaimStates(AbstractUserState outerState) {
        this.userState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<UserClaimState> iterator() {
        return getInnerIterable().iterator();
    }

    public UserClaimState get(Integer claimId) {
        return get(claimId, false, false);
    }

    public UserClaimState get(Integer claimId, boolean forCreation) {
        return get(claimId, forCreation, false);
    }

    public UserClaimState get(Integer claimId, boolean forCreation, boolean nullAllowed) {
        UserClaimId globalId = new UserClaimId(userState.getUserId(), claimId);
        if (loadedUserClaimStates.containsKey(globalId)) {
            return loadedUserClaimStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            UserClaimState state = new AbstractUserClaimState.SimpleUserClaimState(getForReapplying());
            state.setUserClaimId(globalId);
            loadedUserClaimStates.put(globalId, state);
            return state;
        } else {
            UserClaimState state = getUserClaimStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedUserClaimStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(UserClaimState state)
    {
        this.removedUserClaimStates.put(state.getUserClaimId(), state);
    }

    public void addToSave(UserClaimState state)
    {
        this.loadedUserClaimStates.put(state.getUserClaimId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (UserClaimState s : this.getLoadedUserClaimStates()) {
            getUserClaimStateDao().save(s);
        }
        for (UserClaimState s : this.removedUserClaimStates.values()) {
            getUserClaimStateDao().delete(s);
        }
    }

    //endregion

}


