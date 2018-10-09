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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        //if (this.shipmentReceiptState instanceof AbstractShipmentReceiptState) {
        //    if (((AbstractShipmentReceiptState)this.shipmentReceiptState).getStateReadOnly()) 
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

    protected Iterable<ShipmentReceiptImageState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getShipmentReceiptImageStateDao().findByShipmentIdAndShipmentReceiptReceiptSeqId(((ShipmentReceiptState.SqlShipmentReceiptState)shipmentReceiptState).getShipmentReceiptId().getShipmentId(), ((ShipmentReceiptState.SqlShipmentReceiptState)shipmentReceiptState).getShipmentReceiptId().getReceiptSeqId());
        } else {
            List<ShipmentReceiptImageState> ss = new ArrayList<ShipmentReceiptImageState>();
            for (ShipmentReceiptImageState s : loadedShipmentReceiptImageStates.values()) {
                if (!(removedShipmentReceiptImageStates.containsKey(((ShipmentReceiptImageState.SqlShipmentReceiptImageState)s).getShipmentReceiptImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentReceiptImageStateCollection(ShipmentReceiptState outerState) {
        this.shipmentReceiptState = outerState;
        this.setForReapplying(((ShipmentReceiptState.SqlShipmentReceiptState)outerState).getForReapplying());
    }

    @Override
    public Iterator<ShipmentReceiptImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentReceiptImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    public ShipmentReceiptImageState get(String sequenceId, boolean nullAllowed) {
        return get(sequenceId, nullAllowed, false);
    }

    ShipmentReceiptImageState get(String sequenceId, boolean nullAllowed, boolean forCreation) {
        ShipmentReceiptImageId globalId = new ShipmentReceiptImageId(((ShipmentReceiptState.SqlShipmentReceiptState)shipmentReceiptState).getShipmentReceiptId().getShipmentId(), ((ShipmentReceiptState.SqlShipmentReceiptState)shipmentReceiptState).getShipmentReceiptId().getReceiptSeqId(), sequenceId);
        if (loadedShipmentReceiptImageStates.containsKey(globalId)) {
            ShipmentReceiptImageState state = loadedShipmentReceiptImageStates.get(globalId);
            if (state instanceof AbstractShipmentReceiptImageState) {
                ((AbstractShipmentReceiptImageState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            ShipmentReceiptImageState state = new AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState(getForReapplying());
            ((ShipmentReceiptImageState.SqlShipmentReceiptImageState)state).setShipmentReceiptImageId(globalId);
            loadedShipmentReceiptImageStates.put(globalId, state);
            return state;
        } else {
            ShipmentReceiptImageState state = getShipmentReceiptImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((ShipmentReceiptImageState.SqlShipmentReceiptImageState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractShipmentReceiptImageState) {
                    ((AbstractShipmentReceiptImageState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedShipmentReceiptImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentReceiptImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedShipmentReceiptImageStates.put(((ShipmentReceiptImageState.SqlShipmentReceiptImageState)state).getShipmentReceiptImageId(), state);
    }

    public void add(ShipmentReceiptImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedShipmentReceiptImageStates.put(((ShipmentReceiptImageState.SqlShipmentReceiptImageState)state).getShipmentReceiptImageId(), state);
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


