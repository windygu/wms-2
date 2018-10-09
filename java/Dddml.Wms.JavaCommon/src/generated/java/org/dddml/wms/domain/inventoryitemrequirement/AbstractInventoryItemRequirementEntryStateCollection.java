package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractInventoryItemRequirementEntryStateCollection implements EntityStateCollection<Long, InventoryItemRequirementEntryState>, Saveable
{
    protected InventoryItemRequirementEntryStateDao getInventoryItemRequirementEntryStateDao()
    {
        return (InventoryItemRequirementEntryStateDao)ApplicationContext.current.get("InventoryItemRequirementEntryStateDao");
    }

    private InventoryItemRequirementState inventoryItemRequirementState;

    private Map<InventoryItemRequirementEntryId, InventoryItemRequirementEntryState> loadedInventoryItemRequirementEntryStates = new HashMap<InventoryItemRequirementEntryId, InventoryItemRequirementEntryState>();

    private Map<InventoryItemRequirementEntryId, InventoryItemRequirementEntryState> removedInventoryItemRequirementEntryStates = new HashMap<InventoryItemRequirementEntryId, InventoryItemRequirementEntryState>();

    protected Iterable<InventoryItemRequirementEntryState> getLoadedInventoryItemRequirementEntryStates() {
        return this.loadedInventoryItemRequirementEntryStates.values();
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
        //if (this.inventoryItemRequirementState instanceof AbstractInventoryItemRequirementState) {
        //    if (((AbstractInventoryItemRequirementState)this.inventoryItemRequirementState).getStateReadOnly()) 
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

    protected Iterable<InventoryItemRequirementEntryState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getInventoryItemRequirementEntryStateDao().findByInventoryItemRequirementId(inventoryItemRequirementState.getInventoryItemRequirementId());
        } else {
            List<InventoryItemRequirementEntryState> ss = new ArrayList<InventoryItemRequirementEntryState>();
            for (InventoryItemRequirementEntryState s : loadedInventoryItemRequirementEntryStates.values()) {
                ss.add(s);
            }
            return ss;
        }
    }

    public AbstractInventoryItemRequirementEntryStateCollection(InventoryItemRequirementState outerState) {
        this.inventoryItemRequirementState = outerState;
        this.setForReapplying(((InventoryItemRequirementState.SqlInventoryItemRequirementState)outerState).getForReapplying());
    }

    @Override
    public Iterator<InventoryItemRequirementEntryState> iterator() {
        return getInnerIterable().iterator();
    }

    public InventoryItemRequirementEntryState get(Long entrySeqId) {
        return get(entrySeqId, false, false);
    }

    public InventoryItemRequirementEntryState get(Long entrySeqId, boolean nullAllowed) {
        return get(entrySeqId, nullAllowed, false);
    }

    InventoryItemRequirementEntryState get(Long entrySeqId, boolean nullAllowed, boolean forCreation) {
        InventoryItemRequirementEntryId globalId = new InventoryItemRequirementEntryId(inventoryItemRequirementState.getInventoryItemRequirementId(), entrySeqId);
        if (loadedInventoryItemRequirementEntryStates.containsKey(globalId)) {
            InventoryItemRequirementEntryState state = loadedInventoryItemRequirementEntryStates.get(globalId);
            if (state instanceof AbstractInventoryItemRequirementEntryState) {
                ((AbstractInventoryItemRequirementEntryState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            InventoryItemRequirementEntryState state = new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState(getForReapplying());
            ((InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState)state).setInventoryItemRequirementEntryId(globalId);
            loadedInventoryItemRequirementEntryStates.put(globalId, state);
            return state;
        } else {
            InventoryItemRequirementEntryState state = getInventoryItemRequirementEntryStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractInventoryItemRequirementEntryState) {
                    ((AbstractInventoryItemRequirementEntryState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedInventoryItemRequirementEntryStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InventoryItemRequirementEntryState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedInventoryItemRequirementEntryStates.put(((InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState)state).getInventoryItemRequirementEntryId(), state);
    }

    public void add(InventoryItemRequirementEntryState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedInventoryItemRequirementEntryStates.put(((InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState)state).getInventoryItemRequirementEntryId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (InventoryItemRequirementEntryState s : this.getLoadedInventoryItemRequirementEntryStates()) {
            getInventoryItemRequirementEntryStateDao().save(s);
        }
        for (InventoryItemRequirementEntryState s : this.removedInventoryItemRequirementEntryStates.values()) {
            getInventoryItemRequirementEntryStateDao().delete(s);
        }
    }

    //endregion

}


