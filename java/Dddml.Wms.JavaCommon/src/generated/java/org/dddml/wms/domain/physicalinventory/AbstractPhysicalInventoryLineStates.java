package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractPhysicalInventoryLineStates implements PhysicalInventoryLineStates
{
    protected PhysicalInventoryLineStateDao getPhysicalInventoryLineStateDao()
    {
        return (PhysicalInventoryLineStateDao)ApplicationContext.current.get("PhysicalInventoryLineStateDao");
    }

    private PhysicalInventoryState physicalInventoryState;

    private Map<PhysicalInventoryLineId, PhysicalInventoryLineState> loadedPhysicalInventoryLineStates = new HashMap<PhysicalInventoryLineId, PhysicalInventoryLineState>();

    private Map<PhysicalInventoryLineId, PhysicalInventoryLineState> removedPhysicalInventoryLineStates = new HashMap<PhysicalInventoryLineId, PhysicalInventoryLineState>();

    protected Iterable<PhysicalInventoryLineState> getLoadedPhysicalInventoryLineStates() {
        return this.loadedPhysicalInventoryLineStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<PhysicalInventoryLineState> getInnerIterable() {
        if (!getForReapplying()) {
            return getPhysicalInventoryLineStateDao().findByPhysicalInventoryDocumentNumber(physicalInventoryState.getDocumentNumber());
        } else {
            List<PhysicalInventoryLineState> ss = new ArrayList<PhysicalInventoryLineState>();
            for (PhysicalInventoryLineState s : loadedPhysicalInventoryLineStates.values()) {
                if (!(removedPhysicalInventoryLineStates.containsKey(s.getPhysicalInventoryLineId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractPhysicalInventoryLineStates(PhysicalInventoryState outerState) {
        this.physicalInventoryState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<PhysicalInventoryLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public PhysicalInventoryLineState get(InventoryItemId inventoryItemId) {
        return get(inventoryItemId, false, false);
    }

    PhysicalInventoryLineState get(InventoryItemId inventoryItemId, boolean forCreation) {
        return get(inventoryItemId, forCreation, false);
    }

    PhysicalInventoryLineState get(InventoryItemId inventoryItemId, boolean forCreation, boolean nullAllowed) {
        PhysicalInventoryLineId globalId = new PhysicalInventoryLineId(physicalInventoryState.getDocumentNumber(), inventoryItemId);
        if (loadedPhysicalInventoryLineStates.containsKey(globalId)) {
            return loadedPhysicalInventoryLineStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            PhysicalInventoryLineState state = new AbstractPhysicalInventoryLineState.SimplePhysicalInventoryLineState(getForReapplying());
            state.setPhysicalInventoryLineId(globalId);
            loadedPhysicalInventoryLineStates.put(globalId, state);
            return state;
        } else {
            PhysicalInventoryLineState state = getPhysicalInventoryLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedPhysicalInventoryLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(PhysicalInventoryLineState state)
    {
        this.removedPhysicalInventoryLineStates.put(state.getPhysicalInventoryLineId(), state);
    }

    public void add(PhysicalInventoryLineState state)
    {
        this.loadedPhysicalInventoryLineStates.put(state.getPhysicalInventoryLineId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (PhysicalInventoryLineState s : this.getLoadedPhysicalInventoryLineStates()) {
            getPhysicalInventoryLineStateDao().save(s);
        }
        for (PhysicalInventoryLineState s : this.removedPhysicalInventoryLineStates.values()) {
            getPhysicalInventoryLineStateDao().delete(s);
        }
    }

    //endregion

}


