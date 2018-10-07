package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractPicklistRoleStateCollection implements EntityStateCollection<PartyRoleId, PicklistRoleState>, Saveable
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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        //if (this.picklistState instanceof AbstractPicklistState) {
        //    if (((AbstractPicklistState)this.picklistState).getStateReadOnly()) 
        //    { return true; }
        //}
        if (this.stateCollectionReadOnly == null) {
            return false;
        }
        return this.stateCollectionReadOnly;
    }

    public void setStateCollectionReadOnly(Boolean readOnly) {
        this.stateCollectionReadOnly = readOnly;
    }

    protected Iterable<PicklistRoleState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
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

    public AbstractPicklistRoleStateCollection(PicklistState outerState) {
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

    public PicklistRoleState get(PartyRoleId partyRoleId, boolean nullAllowed) {
        return get(partyRoleId, nullAllowed, false);
    }

    PicklistRoleState get(PartyRoleId partyRoleId, boolean nullAllowed, boolean forCreation) {
        PicklistRoleId globalId = new PicklistRoleId(picklistState.getPicklistId(), partyRoleId);
        if (loadedPicklistRoleStates.containsKey(globalId)) {
            PicklistRoleState state = loadedPicklistRoleStates.get(globalId);
            if (state instanceof AbstractPicklistRoleState) {
                ((AbstractPicklistRoleState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            PicklistRoleState state = new AbstractPicklistRoleState.SimplePicklistRoleState(getForReapplying());
            state.setPicklistRoleId(globalId);
            loadedPicklistRoleStates.put(globalId, state);
            return state;
        } else {
            PicklistRoleState state = getPicklistRoleStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state.isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedPicklistRoleStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(PicklistRoleState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedPicklistRoleStates.put(state.getPicklistRoleId(), state);
    }

    public void add(PicklistRoleState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
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


