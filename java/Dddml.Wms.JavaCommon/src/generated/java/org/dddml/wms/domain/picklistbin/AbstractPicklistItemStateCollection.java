package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractPicklistItemStateCollection implements EntityStateCollection<PicklistItemOrderShipGrpInvId, PicklistItemState>, Saveable
{
    protected PicklistItemStateDao getPicklistItemStateDao()
    {
        return (PicklistItemStateDao)ApplicationContext.current.get("PicklistItemStateDao");
    }

    private PicklistBinState picklistBinState;

    private Map<PicklistBinPicklistItemId, PicklistItemState> loadedPicklistItemStates = new HashMap<PicklistBinPicklistItemId, PicklistItemState>();

    private Map<PicklistBinPicklistItemId, PicklistItemState> removedPicklistItemStates = new HashMap<PicklistBinPicklistItemId, PicklistItemState>();

    protected Iterable<PicklistItemState> getLoadedPicklistItemStates() {
        return this.loadedPicklistItemStates.values();
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
        if (this.picklistBinState instanceof AbstractPicklistBinState) {
            if (((AbstractPicklistBinState)this.picklistBinState).getStateReadOnly()) 
            { return true; }
        }
        if (this.stateCollectionReadOnly == null) {
            return false;
        }
        return this.stateCollectionReadOnly;
    }

    public void setStateCollectionReadOnly(Boolean readOnly) {
        this.stateCollectionReadOnly = readOnly;
    }

    protected Iterable<PicklistItemState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getPicklistItemStateDao().findByPicklistBinId(picklistBinState.getPicklistBinId());
        } else {
            List<PicklistItemState> ss = new ArrayList<PicklistItemState>();
            for (PicklistItemState s : loadedPicklistItemStates.values()) {
                if (!(removedPicklistItemStates.containsKey(((PicklistItemState.SqlPicklistItemState)s).getPicklistBinPicklistItemId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractPicklistItemStateCollection(PicklistBinState outerState) {
        this.picklistBinState = outerState;
        this.setForReapplying(((PicklistBinState.SqlPicklistBinState)outerState).getForReapplying());
    }

    @Override
    public Iterator<PicklistItemState> iterator() {
        return getInnerIterable().iterator();
    }

    public PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return get(picklistItemOrderShipGrpInvId, false, false);
    }

    public PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, boolean nullAllowed) {
        return get(picklistItemOrderShipGrpInvId, nullAllowed, false);
    }

    PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, boolean nullAllowed, boolean forCreation) {
        PicklistBinPicklistItemId globalId = new PicklistBinPicklistItemId(picklistBinState.getPicklistBinId(), picklistItemOrderShipGrpInvId);
        if (loadedPicklistItemStates.containsKey(globalId)) {
            PicklistItemState state = loadedPicklistItemStates.get(globalId);
            if (state instanceof AbstractPicklistItemState) {
                ((AbstractPicklistItemState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            PicklistItemState state = new AbstractPicklistItemState.SimplePicklistItemState(getForReapplying());
            ((PicklistItemState.SqlPicklistItemState)state).setPicklistBinPicklistItemId(globalId);
            loadedPicklistItemStates.put(globalId, state);
            return state;
        } else {
            PicklistItemState state = getPicklistItemStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractPicklistItemState) {
                    ((AbstractPicklistItemState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((PicklistItemState.SqlPicklistItemState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedPicklistItemStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(PicklistItemState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedPicklistItemStates.put(((PicklistItemState.SqlPicklistItemState)state).getPicklistBinPicklistItemId(), state);
    }

    public void add(PicklistItemState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedPicklistItemStates.put(((PicklistItemState.SqlPicklistItemState)state).getPicklistBinPicklistItemId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (PicklistItemState s : this.getLoadedPicklistItemStates()) {
            getPicklistItemStateDao().save(s);
        }
        for (PicklistItemState s : this.removedPicklistItemStates.values()) {
            getPicklistItemStateDao().delete(s);
        }
    }

    //endregion

}


