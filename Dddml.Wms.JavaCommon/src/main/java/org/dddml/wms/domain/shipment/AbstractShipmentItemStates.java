package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractShipmentItemStates implements ShipmentItemStates
{
    protected ShipmentItemStateDao getShipmentItemStateDao()
    {
        return (ShipmentItemStateDao)ApplicationContext.current.get("ShipmentItemStateDao");
    }

    private ShipmentState shipmentState;

    private Map<ShipmentItemId, ShipmentItemState> loadedShipmentItemStates = new HashMap<ShipmentItemId, ShipmentItemState>();

    private Map<ShipmentItemId, ShipmentItemState> removedShipmentItemStates = new HashMap<ShipmentItemId, ShipmentItemState>();

    protected Iterable<ShipmentItemState> getLoadedShipmentItemStates() {
        return this.loadedShipmentItemStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<ShipmentItemState> getInnerIterable() {
        if (!getForReapplying()) {
            return getShipmentItemStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ShipmentItemState> ss = new ArrayList<ShipmentItemState>();
            for (ShipmentItemState s : loadedShipmentItemStates.values()) {
                if (!(removedShipmentItemStates.containsKey(s.getShipmentItemId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentItemStates(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<ShipmentItemState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentItemState get(String shipmentItemSeqId) {
        return get(shipmentItemSeqId, false, false);
    }

    public ShipmentItemState get(String shipmentItemSeqId, boolean forCreation) {
        return get(shipmentItemSeqId, forCreation, false);
    }

    public ShipmentItemState get(String shipmentItemSeqId, boolean forCreation, boolean nullAllowed) {
        ShipmentItemId globalId = new ShipmentItemId(shipmentState.getShipmentId(), shipmentItemSeqId);
        if (loadedShipmentItemStates.containsKey(globalId)) {
            return loadedShipmentItemStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            ShipmentItemState state = new AbstractShipmentItemState.SimpleShipmentItemState(getForReapplying());
            state.setShipmentItemId(globalId);
            loadedShipmentItemStates.put(globalId, state);
            return state;
        } else {
            ShipmentItemState state = getShipmentItemStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedShipmentItemStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentItemState state)
    {
        this.removedShipmentItemStates.put(state.getShipmentItemId(), state);
    }

    public void addToSave(ShipmentItemState state)
    {
        this.loadedShipmentItemStates.put(state.getShipmentItemId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (ShipmentItemState s : this.getLoadedShipmentItemStates()) {
            getShipmentItemStateDao().save(s);
        }
        for (ShipmentItemState s : this.removedShipmentItemStates.values()) {
            getShipmentItemStateDao().delete(s);
        }
    }

    //endregion

}


