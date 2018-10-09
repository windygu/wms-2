package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractPhysicalInventoryLineStateCollection implements EntityStateCollection<InventoryItemId, PhysicalInventoryLineState>, Saveable
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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        //if (this.physicalInventoryState instanceof AbstractPhysicalInventoryState) {
        //    if (((AbstractPhysicalInventoryState)this.physicalInventoryState).getStateReadOnly()) 
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

    protected Iterable<PhysicalInventoryLineState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getPhysicalInventoryLineStateDao().findByPhysicalInventoryDocumentNumber(physicalInventoryState.getDocumentNumber());
        } else {
            List<PhysicalInventoryLineState> ss = new ArrayList<PhysicalInventoryLineState>();
            for (PhysicalInventoryLineState s : loadedPhysicalInventoryLineStates.values()) {
                if (!(removedPhysicalInventoryLineStates.containsKey(((PhysicalInventoryLineState.SqlPhysicalInventoryLineState)s).getPhysicalInventoryLineId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractPhysicalInventoryLineStateCollection(PhysicalInventoryState outerState) {
        this.physicalInventoryState = outerState;
        this.setForReapplying(((PhysicalInventoryState.SqlPhysicalInventoryState)outerState).getForReapplying());
    }

    @Override
    public Iterator<PhysicalInventoryLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public PhysicalInventoryLineState get(InventoryItemId inventoryItemId) {
        return get(inventoryItemId, false, false);
    }

    public PhysicalInventoryLineState get(InventoryItemId inventoryItemId, boolean nullAllowed) {
        return get(inventoryItemId, nullAllowed, false);
    }

    PhysicalInventoryLineState get(InventoryItemId inventoryItemId, boolean nullAllowed, boolean forCreation) {
        PhysicalInventoryLineId globalId = new PhysicalInventoryLineId(physicalInventoryState.getDocumentNumber(), inventoryItemId);
        if (loadedPhysicalInventoryLineStates.containsKey(globalId)) {
            PhysicalInventoryLineState state = loadedPhysicalInventoryLineStates.get(globalId);
            if (state instanceof AbstractPhysicalInventoryLineState) {
                ((AbstractPhysicalInventoryLineState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            PhysicalInventoryLineState state = new AbstractPhysicalInventoryLineState.SimplePhysicalInventoryLineState(getForReapplying());
            ((PhysicalInventoryLineState.SqlPhysicalInventoryLineState)state).setPhysicalInventoryLineId(globalId);
            loadedPhysicalInventoryLineStates.put(globalId, state);
            return state;
        } else {
            PhysicalInventoryLineState state = getPhysicalInventoryLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((PhysicalInventoryLineState.SqlPhysicalInventoryLineState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractPhysicalInventoryLineState) {
                    ((AbstractPhysicalInventoryLineState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedPhysicalInventoryLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(PhysicalInventoryLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedPhysicalInventoryLineStates.put(((PhysicalInventoryLineState.SqlPhysicalInventoryLineState)state).getPhysicalInventoryLineId(), state);
    }

    public void add(PhysicalInventoryLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedPhysicalInventoryLineStates.put(((PhysicalInventoryLineState.SqlPhysicalInventoryLineState)state).getPhysicalInventoryLineId(), state);
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


