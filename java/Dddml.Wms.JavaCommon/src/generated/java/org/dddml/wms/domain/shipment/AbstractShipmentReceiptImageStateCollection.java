package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractShipmentReceiptImageStateCollection implements EntityStateCollection<String, ShipmentReceiptImageState>, Saveable
{
    protected ShipmentReceiptImageStateDao getShipmentReceiptImageStateDao()
    {
        return (ShipmentReceiptImageStateDao)ApplicationContext.current.get("ShipmentReceiptImageStateDao");
    }

    private ShipmentReceiptState shipmentReceiptState;

    private Map<ShipmentReceiptImageId, ShipmentReceiptImageState> loadedShipmentReceiptImageStates = new HashMap<ShipmentReceiptImageId, ShipmentReceiptImageState>();

    private Map<ShipmentReceiptImageId, ShipmentReceiptImageState> removedShipmentReceiptImageStates = new HashMap<ShipmentReceiptImageId, ShipmentReceiptImageState>();

    protected Iterable<ShipmentReceiptImageState> getLoadedShipmentReceiptImageStates() {
        return this.loadedShipmentReceiptImageStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<ShipmentReceiptImageState> getInnerIterable() {
        if (!getForReapplying()) {
            return getShipmentReceiptImageStateDao().findByShipmentIdAndShipmentReceiptReceiptSeqId(shipmentReceiptState.getShipmentReceiptId().getShipmentId(), shipmentReceiptState.getShipmentReceiptId().getReceiptSeqId());
        } else {
            List<ShipmentReceiptImageState> ss = new ArrayList<ShipmentReceiptImageState>();
            for (ShipmentReceiptImageState s : loadedShipmentReceiptImageStates.values()) {
                if (!(removedShipmentReceiptImageStates.containsKey(s.getShipmentReceiptImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentReceiptImageStateCollection(ShipmentReceiptState outerState) {
        this.shipmentReceiptState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<ShipmentReceiptImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentReceiptImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    ShipmentReceiptImageState get(String sequenceId, boolean forCreation) {
        return get(sequenceId, forCreation, false);
    }

    ShipmentReceiptImageState get(String sequenceId, boolean forCreation, boolean nullAllowed) {
        ShipmentReceiptImageId globalId = new ShipmentReceiptImageId(shipmentReceiptState.getShipmentReceiptId().getShipmentId(), shipmentReceiptState.getShipmentReceiptId().getReceiptSeqId(), sequenceId);
        if (loadedShipmentReceiptImageStates.containsKey(globalId)) {
            return loadedShipmentReceiptImageStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            ShipmentReceiptImageState state = new AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState(getForReapplying());
            state.setShipmentReceiptImageId(globalId);
            loadedShipmentReceiptImageStates.put(globalId, state);
            return state;
        } else {
            ShipmentReceiptImageState state = getShipmentReceiptImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedShipmentReceiptImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentReceiptImageState state)
    {
        this.removedShipmentReceiptImageStates.put(state.getShipmentReceiptImageId(), state);
    }

    public void add(ShipmentReceiptImageState state)
    {
        this.loadedShipmentReceiptImageStates.put(state.getShipmentReceiptImageId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (ShipmentReceiptImageState s : this.getLoadedShipmentReceiptImageStates()) {
            getShipmentReceiptImageStateDao().save(s);
        }
        for (ShipmentReceiptImageState s : this.removedShipmentReceiptImageStates.values()) {
            getShipmentReceiptImageStateDao().delete(s);
        }
    }

    //endregion

}


