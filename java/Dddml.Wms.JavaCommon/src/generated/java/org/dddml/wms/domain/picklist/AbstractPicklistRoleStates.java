package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractPicklistRoleStates implements PicklistRoleStates
{
    protected PicklistRoleStateDao getPicklistRoleStateDao()
    {
        return (PicklistRoleStateDao)ApplicationContext.current.get("PicklistRoleStateDao");
    }

    private PicklistState picklistState;

    private Map<PicklistRoleId, PicklistRoleState> loadedPicklistRoleStates = new HashMap<PicklistRoleId, PicklistRoleState>();

    private Map<PicklistRoleId, PicklistRoleState> removedPicklistRoleStates = new HashMap<PicklistRoleId, PicklistRoleState>();

    protected Iterable<PicklistRoleState> getLoadedPicklistRoleStates() {
        return this.loadedPicklistRoleStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<PicklistRoleState> getInnerIterable() {
        if (!getForReapplying()) {
            return getPicklistRoleStateDao().findByPicklistId(picklistState.getPicklistId());
        } else {
            List<PicklistRoleState> ss = new ArrayList<PicklistRoleState>();
            for (PicklistRoleState s : loadedPicklistRoleStates.values()) {
                if (!(removedPicklistRoleStates.containsKey(s.getPicklistRoleId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractPicklistRoleStates(PicklistState outerState) {
        this.picklistState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<PicklistRoleState> iterator() {
        return getInnerIterable().iterator();
    }

    public PicklistRoleState get(PartyRoleId partyRoleId) {
        return get(partyRoleId, false, false);
    }

    public PicklistRoleState get(PartyRoleId partyRoleId, boolean forCreation) {
        return get(partyRoleId, forCreation, false);
    }

    public PicklistRoleState get(PartyRoleId partyRoleId, boolean forCreation, boolean nullAllowed) {
        PicklistRoleId globalId = new PicklistRoleId(picklistState.getPicklistId(), partyRoleId);
        if (loadedPicklistRoleStates.containsKey(globalId)) {
            return loadedPicklistRoleStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            PicklistRoleState state = new AbstractPicklistRoleState.SimplePicklistRoleState(getForReapplying());
            state.setPicklistRoleId(globalId);
            loadedPicklistRoleStates.put(globalId, state);
            return state;
        } else {
            PicklistRoleState state = getPicklistRoleStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedPicklistRoleStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(PicklistRoleState state)
    {
        this.removedPicklistRoleStates.put(state.getPicklistRoleId(), state);
    }

    public void addToSave(PicklistRoleState state)
    {
        this.loadedPicklistRoleStates.put(state.getPicklistRoleId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (PicklistRoleState s : this.getLoadedPicklistRoleStates()) {
            getPicklistRoleStateDao().save(s);
        }
        for (PicklistRoleState s : this.removedPicklistRoleStates.values()) {
            getPicklistRoleStateDao().delete(s);
        }
    }

    //endregion

}


