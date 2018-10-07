package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractSellableInventoryItemEntryStates implements SellableInventoryItemEntryStates
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

    protected Iterable<SellableInventoryItemEntryState> getInnerIterable() {
        if (!getForReapplying()) {
            return getSellableInventoryItemEntryStateDao().findBySellableInventoryItemId(sellableInventoryItemState.getSellableInventoryItemId());
        } else {
            List<SellableInventoryItemEntryState> ss = new ArrayList<SellableInventoryItemEntryState>();
            for (SellableInventoryItemEntryState s : loadedSellableInventoryItemEntryStates.values()) {
                ss.add(s);
            }
            return ss;
        }
    }

    public AbstractSellableInventoryItemEntryStates(SellableInventoryItemState outerState) {
        this.sellableInventoryItemState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<SellableInventoryItemEntryState> iterator() {
        return getInnerIterable().iterator();
    }

    public SellableInventoryItemEntryState get(Long entrySeqId) {
        return get(entrySeqId, false, false);
    }

    SellableInventoryItemEntryState get(Long entrySeqId, boolean forCreation) {
        return get(entrySeqId, forCreation, false);
    }

    SellableInventoryItemEntryState get(Long entrySeqId, boolean forCreation, boolean nullAllowed) {
        SellableInventoryItemEntryId globalId = new SellableInventoryItemEntryId(sellableInventoryItemState.getSellableInventoryItemId(), entrySeqId);
        if (loadedSellableInventoryItemEntryStates.containsKey(globalId)) {
            return loadedSellableInventoryItemEntryStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            SellableInventoryItemEntryState state = new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState(getForReapplying());
            state.setSellableInventoryItemEntryId(globalId);
            loadedSellableInventoryItemEntryStates.put(globalId, state);
            return state;
        } else {
            SellableInventoryItemEntryState state = getSellableInventoryItemEntryStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedSellableInventoryItemEntryStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(SellableInventoryItemEntryState state)
    {
        this.removedSellableInventoryItemEntryStates.put(state.getSellableInventoryItemEntryId(), state);
    }

    public void add(SellableInventoryItemEntryState state)
    {
        this.loadedSellableInventoryItemEntryStates.put(state.getSellableInventoryItemEntryId(), state);
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


