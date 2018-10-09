package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractShipmentImageStateCollection implements EntityStateCollection<String, ShipmentImageState>, Saveable
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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        if (this.shipmentState instanceof AbstractShipmentState) {
            if (((AbstractShipmentState)this.shipmentState).getStateReadOnly()) 
            { return true; }
        }
        if (this.stateCollectionReadOnly == null) {
            return false;
        }
        return this.stateCollectionReadOnly;
    }

    public void setStateCollectionReadOnly(Boolean readOnly) {
        this.stateCollectionReadOnly = readOnly;
    }

    protected Iterable<ShipmentImageState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getShipmentImageStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ShipmentImageState> ss = new ArrayList<ShipmentImageState>();
            for (ShipmentImageState s : loadedShipmentImageStates.values()) {
                if (!(removedShipmentImageStates.containsKey(((ShipmentImageState.SqlShipmentImageState)s).getShipmentImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentImageStateCollection(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(((ShipmentState.SqlShipmentState)outerState).getForReapplying());
    }

    @Override
    public Iterator<ShipmentImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    public ShipmentImageState get(String sequenceId, boolean nullAllowed) {
        return get(sequenceId, nullAllowed, false);
    }

    ShipmentImageState get(String sequenceId, boolean nullAllowed, boolean forCreation) {
        ShipmentImageId globalId = new ShipmentImageId(shipmentState.getShipmentId(), sequenceId);
        if (loadedShipmentImageStates.containsKey(globalId)) {
            ShipmentImageState state = loadedShipmentImageStates.get(globalId);
            if (state instanceof AbstractShipmentImageState) {
                ((AbstractShipmentImageState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            ShipmentImageState state = new AbstractShipmentImageState.SimpleShipmentImageState(getForReapplying());
            ((ShipmentImageState.SqlShipmentImageState)state).setShipmentImageId(globalId);
            loadedShipmentImageStates.put(globalId, state);
            return state;
        } else {
            ShipmentImageState state = getShipmentImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractShipmentImageState) {
                    ((AbstractShipmentImageState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((ShipmentImageState.SqlShipmentImageState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedShipmentImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedShipmentImageStates.put(((ShipmentImageState.SqlShipmentImageState)state).getShipmentImageId(), state);
    }

    public void add(ShipmentImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedShipmentImageStates.put(((ShipmentImageState.SqlShipmentImageState)state).getShipmentImageId(), state);
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


