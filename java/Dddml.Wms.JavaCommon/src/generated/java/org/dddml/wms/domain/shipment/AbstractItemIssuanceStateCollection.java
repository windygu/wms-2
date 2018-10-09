package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractItemIssuanceStateCollection implements EntityStateCollection<String, ItemIssuanceState>, Saveable
{
    protected ItemIssuanceStateDao getItemIssuanceStateDao()
    {
        return (ItemIssuanceStateDao)ApplicationContext.current.get("ItemIssuanceStateDao");
    }

    private ShipmentState shipmentState;

    private Map<ShipmentItemIssuanceId, ItemIssuanceState> loadedItemIssuanceStates = new HashMap<ShipmentItemIssuanceId, ItemIssuanceState>();

    private Map<ShipmentItemIssuanceId, ItemIssuanceState> removedItemIssuanceStates = new HashMap<ShipmentItemIssuanceId, ItemIssuanceState>();

    protected Iterable<ItemIssuanceState> getLoadedItemIssuanceStates() {
        return this.loadedItemIssuanceStates.values();
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
        //if (this.shipmentState instanceof AbstractShipmentState) {
        //    if (((AbstractShipmentState)this.shipmentState).getStateReadOnly()) 
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

    protected Iterable<ItemIssuanceState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getItemIssuanceStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ItemIssuanceState> ss = new ArrayList<ItemIssuanceState>();
            for (ItemIssuanceState s : loadedItemIssuanceStates.values()) {
                if (!(removedItemIssuanceStates.containsKey(((ItemIssuanceState.SqlItemIssuanceState)s).getShipmentItemIssuanceId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractItemIssuanceStateCollection(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(((ShipmentState.SqlShipmentState)outerState).getForReapplying());
    }

    @Override
    public Iterator<ItemIssuanceState> iterator() {
        return getInnerIterable().iterator();
    }

    public ItemIssuanceState get(String itemIssuanceSeqId) {
        return get(itemIssuanceSeqId, false, false);
    }

    public ItemIssuanceState get(String itemIssuanceSeqId, boolean nullAllowed) {
        return get(itemIssuanceSeqId, nullAllowed, false);
    }

    ItemIssuanceState get(String itemIssuanceSeqId, boolean nullAllowed, boolean forCreation) {
        ShipmentItemIssuanceId globalId = new ShipmentItemIssuanceId(shipmentState.getShipmentId(), itemIssuanceSeqId);
        if (loadedItemIssuanceStates.containsKey(globalId)) {
            ItemIssuanceState state = loadedItemIssuanceStates.get(globalId);
            if (state instanceof AbstractItemIssuanceState) {
                ((AbstractItemIssuanceState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            ItemIssuanceState state = new AbstractItemIssuanceState.SimpleItemIssuanceState(getForReapplying());
            ((ItemIssuanceState.SqlItemIssuanceState)state).setShipmentItemIssuanceId(globalId);
            loadedItemIssuanceStates.put(globalId, state);
            return state;
        } else {
            ItemIssuanceState state = getItemIssuanceStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((ItemIssuanceState.SqlItemIssuanceState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractItemIssuanceState) {
                    ((AbstractItemIssuanceState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedItemIssuanceStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ItemIssuanceState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedItemIssuanceStates.put(((ItemIssuanceState.SqlItemIssuanceState)state).getShipmentItemIssuanceId(), state);
    }

    public void add(ItemIssuanceState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedItemIssuanceStates.put(((ItemIssuanceState.SqlItemIssuanceState)state).getShipmentItemIssuanceId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (ItemIssuanceState s : this.getLoadedItemIssuanceStates()) {
            getItemIssuanceStateDao().save(s);
        }
        for (ItemIssuanceState s : this.removedItemIssuanceStates.values()) {
            getItemIssuanceStateDao().delete(s);
        }
    }

    //endregion

}


