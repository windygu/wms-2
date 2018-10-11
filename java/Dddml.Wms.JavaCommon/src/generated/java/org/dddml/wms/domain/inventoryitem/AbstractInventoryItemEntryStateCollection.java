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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        if (this.inventoryItemState instanceof AbstractInventoryItemState) {
            if (((AbstractInventoryItemState)this.inventoryItemState).getStateReadOnly()) 
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

    protected Iterable<InventoryItemEntryState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
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
        this.setForReapplying(((InventoryItemState.SqlInventoryItemState)outerState).getForReapplying());
    }

    @Override
    public Iterator<InventoryItemEntryState> iterator() {
        return getInnerIterable().iterator();
    }

    public InventoryItemEntryState get(Long entrySeqId) {
        return get(entrySeqId, false, false);
    }

    public InventoryItemEntryState get(Long entrySeqId, boolean nullAllowed) {
        return get(entrySeqId, nullAllowed, false);
    }

    InventoryItemEntryState get(Long entrySeqId, boolean nullAllowed, boolean forCreation) {
        InventoryItemEntryId globalId = new InventoryItemEntryId(inventoryItemState.getInventoryItemId(), entrySeqId);
        if (loadedInventoryItemEntryStates.containsKey(globalId)) {
            InventoryItemEntryState state = loadedInventoryItemEntryStates.get(globalId);
            if (state instanceof AbstractInventoryItemEntryState) {
                ((AbstractInventoryItemEntryState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            InventoryItemEntryState state = new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState(getForReapplying());
            ((InventoryItemEntryState.SqlInventoryItemEntryState)state).setInventoryItemEntryId(globalId);
            loadedInventoryItemEntryStates.put(globalId, state);
            return state;
        } else {
            InventoryItemEntryState state = getInventoryItemEntryStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractInventoryItemEntryState) {
                    ((AbstractInventoryItemEntryState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((InventoryItemEntryState.SqlInventoryItemEntryState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedInventoryItemEntryStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InventoryItemEntryState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedInventoryItemEntryStates.put(((InventoryItemEntryState.SqlInventoryItemEntryState)state).getInventoryItemEntryId(), state);
    }

    public void add(InventoryItemEntryState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedInventoryItemEntryStates.put(((InventoryItemEntryState.SqlInventoryItemEntryState)state).getInventoryItemEntryId(), state);
    }

    public Collection<InventoryItemEntryState> getLoadedStates() {
        return Collections.unmodifiableCollection(this.loadedInventoryItemEntryStates.values());
    }

    public Collection<InventoryItemEntryState> getRemovedStates() {
        return Collections.unmodifiableCollection(this.removedInventoryItemEntryStates.values());
    }

    //region Saveable Implements

    public void save ()
    {
    }

    //endregion

}


