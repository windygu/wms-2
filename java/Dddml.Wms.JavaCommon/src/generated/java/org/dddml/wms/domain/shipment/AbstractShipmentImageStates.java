package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractShipmentImageStates implements ShipmentImageStates
{
    protected ShipmentImageStateDao getShipmentImageStateDao()
    {
        return (ShipmentImageStateDao)ApplicationContext.current.get("ShipmentImageStateDao");
    }

    private ShipmentState shipmentState;

    private Map<ShipmentImageId, ShipmentImageState> loadedShipmentImageStates = new HashMap<ShipmentImageId, ShipmentImageState>();

    private Map<ShipmentImageId, ShipmentImageState> removedShipmentImageStates = new HashMap<ShipmentImageId, ShipmentImageState>();

    protected Iterable<ShipmentImageState> getLoadedShipmentImageStates() {
        return this.loadedShipmentImageStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<ShipmentImageState> getInnerIterable() {
        if (!getForReapplying()) {
            return getShipmentImageStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ShipmentImageState> ss = new ArrayList<ShipmentImageState>();
            for (ShipmentImageState s : loadedShipmentImageStates.values()) {
                if (!(removedShipmentImageStates.containsKey(s.getShipmentImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentImageStates(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<ShipmentImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    public ShipmentImageState get(String sequenceId, boolean forCreation) {
        return get(sequenceId, forCreation, false);
    }

    public ShipmentImageState get(String sequenceId, boolean forCreation, boolean nullAllowed) {
        ShipmentImageId globalId = new ShipmentImageId(shipmentState.getShipmentId(), sequenceId);
        if (loadedShipmentImageStates.containsKey(globalId)) {
            return loadedShipmentImageStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            ShipmentImageState state = new AbstractShipmentImageState.SimpleShipmentImageState(getForReapplying());
            state.setShipmentImageId(globalId);
            loadedShipmentImageStates.put(globalId, state);
            return state;
        } else {
            ShipmentImageState state = getShipmentImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedShipmentImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentImageState state)
    {
        this.removedShipmentImageStates.put(state.getShipmentImageId(), state);
    }

    public void addToSave(ShipmentImageState state)
    {
        this.loadedShipmentImageStates.put(state.getShipmentImageId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (ShipmentImageState s : this.getLoadedShipmentImageStates()) {
            getShipmentImageStateDao().save(s);
        }
        for (ShipmentImageState s : this.removedShipmentImageStates.values()) {
            getShipmentImageStateDao().delete(s);
        }
    }

    //endregion

}


