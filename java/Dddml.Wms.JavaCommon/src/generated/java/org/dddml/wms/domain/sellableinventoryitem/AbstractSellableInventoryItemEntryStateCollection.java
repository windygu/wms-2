package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractSellableInventoryItemEntryStateCollection implements EntityStateCollection<Long, SellableInventoryItemEntryState>, Saveable
{
    protected SellableInventoryItemEntryStateDao getSellableInventoryItemEntryStateDao()
    {
        return (SellableInventoryItemEntryStateDao)ApplicationContext.current.get("SellableInventoryItemEntryStateDao");
    }

    private SellableInventoryItemState sellableInventoryItemState;

    private Map<SellableInventoryItemEntryId, SellableInventoryItemEntryState> loadedSellableInventoryItemEntryStates = new HashMap<SellableInventoryItemEntryId, SellableInventoryItemEntryState>();

    private Map<SellableInventoryItemEntryId, SellableInventoryItemEntryState> removedSellableInventoryItemEntryStates = new HashMap<SellableInventoryItemEntryId, SellableInventoryItemEntryState>();

    protected Iterable<SellableInventoryItemEntryState> getLoadedSellableInventoryItemEntryStates() {
        return this.loadedSellableInventoryItemEntryStates.values();
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
        //if (this.sellableInventoryItemState instanceof AbstractSellableInventoryItemState) {
        //    if (((AbstractSellableInventoryItemState)this.sellableInventoryItemState).getStateReadOnly()) 
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

    protected Iterable<SellableInventoryItemEntryState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getSellableInventoryItemEntryStateDao().findBySellableInventoryItemId(sellableInventoryItemState.getSellableInventoryItemId());
        } else {
            List<SellableInventoryItemEntryState> ss = new ArrayList<SellableInventoryItemEntryState>();
            for (SellableInventoryItemEntryState s : loadedSellableInventoryItemEntryStates.values()) {
                ss.add(s);
            }
            return ss;
        }
    }

    public AbstractSellableInventoryItemEntryStateCollection(SellableInventoryItemState outerState) {
        this.sellableInventoryItemState = outerState;
        this.setForReapplying(((SellableInventoryItemState.SqlSellableInventoryItemState)outerState).getForReapplying());
    }

    @Override
    public Iterator<SellableInventoryItemEntryState> iterator() {
        return getInnerIterable().iterator();
    }

    public SellableInventoryItemEntryState get(Long entrySeqId) {
        return get(entrySeqId, false, false);
    }

    public SellableInventoryItemEntryState get(Long entrySeqId, boolean nullAllowed) {
        return get(entrySeqId, nullAllowed, false);
    }

    SellableInventoryItemEntryState get(Long entrySeqId, boolean nullAllowed, boolean forCreation) {
        SellableInventoryItemEntryId globalId = new SellableInventoryItemEntryId(sellableInventoryItemState.getSellableInventoryItemId(), entrySeqId);
        if (loadedSellableInventoryItemEntryStates.containsKey(globalId)) {
            SellableInventoryItemEntryState state = loadedSellableInventoryItemEntryStates.get(globalId);
            if (state instanceof AbstractSellableInventoryItemEntryState) {
                ((AbstractSellableInventoryItemEntryState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            SellableInventoryItemEntryState state = new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState(getForReapplying());
            ((SellableInventoryItemEntryState.SqlSellableInventoryItemEntryState)state).setSellableInventoryItemEntryId(globalId);
            loadedSellableInventoryItemEntryStates.put(globalId, state);
            return state;
        } else {
            SellableInventoryItemEntryState state = getSellableInventoryItemEntryStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((SellableInventoryItemEntryState.SqlSellableInventoryItemEntryState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractSellableInventoryItemEntryState) {
                    ((AbstractSellableInventoryItemEntryState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedSellableInventoryItemEntryStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(SellableInventoryItemEntryState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedSellableInventoryItemEntryStates.put(((SellableInventoryItemEntryState.SqlSellableInventoryItemEntryState)state).getSellableInventoryItemEntryId(), state);
    }

    public void add(SellableInventoryItemEntryState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedSellableInventoryItemEntryStates.put(((SellableInventoryItemEntryState.SqlSellableInventoryItemEntryState)state).getSellableInventoryItemEntryId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (SellableInventoryItemEntryState s : this.getLoadedSellableInventoryItemEntryStates()) {
            getSellableInventoryItemEntryStateDao().save(s);
        }
        for (SellableInventoryItemEntryState s : this.removedSellableInventoryItemEntryStates.values()) {
            getSellableInventoryItemEntryStateDao().delete(s);
        }
    }

    //endregion

}


