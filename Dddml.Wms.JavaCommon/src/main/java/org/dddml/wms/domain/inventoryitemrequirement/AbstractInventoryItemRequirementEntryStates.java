package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractInventoryItemRequirementEntryStates implements InventoryItemRequirementEntryStates
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

    protected Iterable<InventoryItemRequirementEntryState> getInnerIterable() {
        if (!getForReapplying()) {
            return getInventoryItemRequirementEntryStateDao().findByInventoryItemRequirementId(inventoryItemRequirementState.getInventoryItemRequirementId());
        } else {
            List<InventoryItemRequirementEntryState> ss = new ArrayList<InventoryItemRequirementEntryState>();
            for (InventoryItemRequirementEntryState s : loadedInventoryItemRequirementEntryStates.values()) {
                ss.add(s);
            }
            return ss;
        }
    }

    public AbstractInventoryItemRequirementEntryStates(InventoryItemRequirementState outerState) {
        this.inventoryItemRequirementState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<InventoryItemRequirementEntryState> iterator() {
        return getInnerIterable().iterator();
    }

    public InventoryItemRequirementEntryState get(Long entrySeqId) {
        return get(entrySeqId, false, false);
    }

    public InventoryItemRequirementEntryState get(Long entrySeqId, boolean forCreation) {
        return get(entrySeqId, forCreation, false);
    }

    public InventoryItemRequirementEntryState get(Long entrySeqId, boolean forCreation, boolean nullAllowed) {
        InventoryItemRequirementEntryId globalId = new InventoryItemRequirementEntryId(inventoryItemRequirementState.getInventoryItemRequirementId(), entrySeqId);
        if (loadedInventoryItemRequirementEntryStates.containsKey(globalId)) {
            return loadedInventoryItemRequirementEntryStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            InventoryItemRequirementEntryState state = new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState(getForReapplying());
            state.setInventoryItemRequirementEntryId(globalId);
            loadedInventoryItemRequirementEntryStates.put(globalId, state);
            return state;
        } else {
            InventoryItemRequirementEntryState state = getInventoryItemRequirementEntryStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedInventoryItemRequirementEntryStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InventoryItemRequirementEntryState state)
    {
        this.removedInventoryItemRequirementEntryStates.put(state.getInventoryItemRequirementEntryId(), state);
    }

    public void addToSave(InventoryItemRequirementEntryState state)
    {
        this.loadedInventoryItemRequirementEntryStates.put(state.getInventoryItemRequirementEntryId(), state);
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


