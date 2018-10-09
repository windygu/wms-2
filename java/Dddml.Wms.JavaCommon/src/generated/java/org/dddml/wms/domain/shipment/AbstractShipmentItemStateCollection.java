package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractShipmentItemStateCollection implements EntityStateCollection<String, ShipmentItemState>, Saveable
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

    protected Iterable<ShipmentItemState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getShipmentItemStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ShipmentItemState> ss = new ArrayList<ShipmentItemState>();
            for (ShipmentItemState s : loadedShipmentItemStates.values()) {
                if (!(removedShipmentItemStates.containsKey(((ShipmentItemState.SqlShipmentItemState)s).getShipmentItemId()))) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentItemStateCollection(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(((ShipmentState.SqlShipmentState)outerState).getForReapplying());
    }

    @Override
    public Iterator<ShipmentItemState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentItemState get(String shipmentItemSeqId) {
        return get(shipmentItemSeqId, false, false);
    }

    public ShipmentItemState get(String shipmentItemSeqId, boolean nullAllowed) {
        return get(shipmentItemSeqId, nullAllowed, false);
    }

    ShipmentItemState get(String shipmentItemSeqId, boolean nullAllowed, boolean forCreation) {
        ShipmentItemId globalId = new ShipmentItemId(shipmentState.getShipmentId(), shipmentItemSeqId);
        if (loadedShipmentItemStates.containsKey(globalId)) {
            ShipmentItemState state = loadedShipmentItemStates.get(globalId);
            if (state instanceof AbstractShipmentItemState) {
                ((AbstractShipmentItemState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            ShipmentItemState state = new AbstractShipmentItemState.SimpleShipmentItemState(getForReapplying());
            ((ShipmentItemState.SqlShipmentItemState)state).setShipmentItemId(globalId);
            loadedShipmentItemStates.put(globalId, state);
            return state;
        } else {
            ShipmentItemState state = getShipmentItemStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractShipmentItemState) {
                    ((AbstractShipmentItemState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((ShipmentItemState.SqlShipmentItemState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedShipmentItemStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentItemState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedShipmentItemStates.put(((ShipmentItemState.SqlShipmentItemState)state).getShipmentItemId(), state);
    }

    public void add(ShipmentItemState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedShipmentItemStates.put(((ShipmentItemState.SqlShipmentItemState)state).getShipmentItemId(), state);
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


