package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractInventoryItemEntryStateCollection implements EntityStateCollection<Long, InventoryItemEntryState>, Saveable
{
    protected InventoryItemEntryStateDao getInventoryItemEntryStateDao()
    {
        return (InventoryItemEntryStateDao)ApplicationContext.current.get("InventoryItemEntryStateDao");
    }

    private InventoryItemState inventoryItemState;

    private Map<InventoryItemEntryId, InventoryItemEntryState> loadedInventoryItemEntryStates = new HashMap<InventoryItemEntryId, InventoryItemEntryState>();

    private Map<InventoryItemEntryId, InventoryItemEntryState> removedInventoryItemEntryStates = new HashMap<InventoryItemEntryId, InventoryItemEntryState>();

    protected Iterable<InventoryItemEntryState> getLoadedInventoryItemEntryStates() {
        return this.loadedInventoryItemEntryStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<InventoryItemEntryState> getInnerIterable() {
        if (!getForReapplying()) {
            return getInventoryItemEntryStateDao().findByInventoryItemId(inventoryItemState.getInventoryItemId());
        } else {
            List<InventoryItemEntryState> ss = new ArrayList<InventoryItemEntryState>();
            for (InventoryItemEntryState s : loadedInventoryItemEntryStates.values()) {
                ss.add(s);
            }
            return ss;
        }
    }

    public AbstractInventoryItemEntryStateCollection(InventoryItemState outerState) {
        this.inventoryItemState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<InventoryItemEntryState> iterator() {
        return getInnerIterable().iterator();
    }

    public InventoryItemEntryState get(Long entrySeqId) {
        return get(entrySeqId, false, false);
    }

    InventoryItemEntryState get(Long entrySeqId, boolean forCreation) {
        return get(entrySeqId, forCreation, false);
    }

    InventoryItemEntryState get(Long entrySeqId, boolean forCreation, boolean nullAllowed) {
        InventoryItemEntryId globalId = new InventoryItemEntryId(inventoryItemState.getInventoryItemId(), entrySeqId);
        if (loadedInventoryItemEntryStates.containsKey(globalId)) {
            return loadedInventoryItemEntryStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            InventoryItemEntryState state = new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState(getForReapplying());
            state.setInventoryItemEntryId(globalId);
            loadedInventoryItemEntryStates.put(globalId, state);
            return state;
        } else {
            InventoryItemEntryState state = getInventoryItemEntryStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedInventoryItemEntryStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InventoryItemEntryState state)
    {
        this.removedInventoryItemEntryStates.put(state.getInventoryItemEntryId(), state);
    }

    public void add(InventoryItemEntryState state)
    {
        this.loadedInventoryItemEntryStates.put(state.getInventoryItemEntryId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
    }

    //endregion

}


