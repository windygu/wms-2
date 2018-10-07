package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractPicklistItemStates implements PicklistItemStates
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

    protected Iterable<PicklistItemState> getInnerIterable() {
        if (!getForReapplying()) {
            return getPicklistItemStateDao().findByPicklistBinId(picklistBinState.getPicklistBinId());
        } else {
            List<PicklistItemState> ss = new ArrayList<PicklistItemState>();
            for (PicklistItemState s : loadedPicklistItemStates.values()) {
                if (!(removedPicklistItemStates.containsKey(s.getPicklistBinPicklistItemId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractPicklistItemStates(PicklistBinState outerState) {
        this.picklistBinState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<PicklistItemState> iterator() {
        return getInnerIterable().iterator();
    }

    public PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return get(picklistItemOrderShipGrpInvId, false, false);
    }

    PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, boolean forCreation) {
        return get(picklistItemOrderShipGrpInvId, forCreation, false);
    }

    PicklistItemState get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, boolean forCreation, boolean nullAllowed) {
        PicklistBinPicklistItemId globalId = new PicklistBinPicklistItemId(picklistBinState.getPicklistBinId(), picklistItemOrderShipGrpInvId);
        if (loadedPicklistItemStates.containsKey(globalId)) {
            return loadedPicklistItemStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            PicklistItemState state = new AbstractPicklistItemState.SimplePicklistItemState(getForReapplying());
            state.setPicklistBinPicklistItemId(globalId);
            loadedPicklistItemStates.put(globalId, state);
            return state;
        } else {
            PicklistItemState state = getPicklistItemStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedPicklistItemStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(PicklistItemState state)
    {
        this.removedPicklistItemStates.put(state.getPicklistBinPicklistItemId(), state);
    }

    public void add(PicklistItemState state)
    {
        this.loadedPicklistItemStates.put(state.getPicklistBinPicklistItemId(), state);
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


