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

    protected Iterable<ItemIssuanceState> getInnerIterable() {
        if (!getForReapplying()) {
            return getItemIssuanceStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ItemIssuanceState> ss = new ArrayList<ItemIssuanceState>();
            for (ItemIssuanceState s : loadedItemIssuanceStates.values()) {
                if (!(removedItemIssuanceStates.containsKey(s.getShipmentItemIssuanceId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractItemIssuanceStateCollection(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<ItemIssuanceState> iterator() {
        return getInnerIterable().iterator();
    }

    public ItemIssuanceState get(String itemIssuanceSeqId) {
        return get(itemIssuanceSeqId, false, false);
    }

    ItemIssuanceState get(String itemIssuanceSeqId, boolean forCreation) {
        return get(itemIssuanceSeqId, forCreation, false);
    }

    ItemIssuanceState get(String itemIssuanceSeqId, boolean forCreation, boolean nullAllowed) {
        ShipmentItemIssuanceId globalId = new ShipmentItemIssuanceId(shipmentState.getShipmentId(), itemIssuanceSeqId);
        if (loadedItemIssuanceStates.containsKey(globalId)) {
            return loadedItemIssuanceStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            ItemIssuanceState state = new AbstractItemIssuanceState.SimpleItemIssuanceState(getForReapplying());
            state.setShipmentItemIssuanceId(globalId);
            loadedItemIssuanceStates.put(globalId, state);
            return state;
        } else {
            ItemIssuanceState state = getItemIssuanceStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedItemIssuanceStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ItemIssuanceState state)
    {
        this.removedItemIssuanceStates.put(state.getShipmentItemIssuanceId(), state);
    }

    public void add(ItemIssuanceState state)
    {
        this.loadedItemIssuanceStates.put(state.getShipmentItemIssuanceId(), state);
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


