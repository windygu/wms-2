package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractShipmentReceiptStateCollection implements EntityStateCollection<String, ShipmentReceiptState>, Saveable
{
    protected ShipmentReceiptStateDao getShipmentReceiptStateDao()
    {
        return (ShipmentReceiptStateDao)ApplicationContext.current.get("ShipmentReceiptStateDao");
    }

    private ShipmentState shipmentState;

    private Map<ShipmentReceiptId, ShipmentReceiptState> loadedShipmentReceiptStates = new HashMap<ShipmentReceiptId, ShipmentReceiptState>();

    private Map<ShipmentReceiptId, ShipmentReceiptState> removedShipmentReceiptStates = new HashMap<ShipmentReceiptId, ShipmentReceiptState>();

    protected Iterable<ShipmentReceiptState> getLoadedShipmentReceiptStates() {
        return this.loadedShipmentReceiptStates.values();
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

    protected Iterable<ShipmentReceiptState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getShipmentReceiptStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ShipmentReceiptState> ss = new ArrayList<ShipmentReceiptState>();
            for (ShipmentReceiptState s : loadedShipmentReceiptStates.values()) {
                if (!(removedShipmentReceiptStates.containsKey(((ShipmentReceiptState.SqlShipmentReceiptState)s).getShipmentReceiptId()))) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentReceiptStateCollection(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(((ShipmentState.SqlShipmentState)outerState).getForReapplying());
    }

    @Override
    public Iterator<ShipmentReceiptState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentReceiptState get(String receiptSeqId) {
        return get(receiptSeqId, false, false);
    }

    public ShipmentReceiptState get(String receiptSeqId, boolean nullAllowed) {
        return get(receiptSeqId, nullAllowed, false);
    }

    ShipmentReceiptState get(String receiptSeqId, boolean nullAllowed, boolean forCreation) {
        ShipmentReceiptId globalId = new ShipmentReceiptId(shipmentState.getShipmentId(), receiptSeqId);
        if (loadedShipmentReceiptStates.containsKey(globalId)) {
            ShipmentReceiptState state = loadedShipmentReceiptStates.get(globalId);
            if (state instanceof AbstractShipmentReceiptState) {
                ((AbstractShipmentReceiptState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            ShipmentReceiptState state = new AbstractShipmentReceiptState.SimpleShipmentReceiptState(getForReapplying());
            ((ShipmentReceiptState.SqlShipmentReceiptState)state).setShipmentReceiptId(globalId);
            loadedShipmentReceiptStates.put(globalId, state);
            return state;
        } else {
            ShipmentReceiptState state = getShipmentReceiptStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractShipmentReceiptState) {
                    ((AbstractShipmentReceiptState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((ShipmentReceiptState.SqlShipmentReceiptState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedShipmentReceiptStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentReceiptState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedShipmentReceiptStates.put(((ShipmentReceiptState.SqlShipmentReceiptState)state).getShipmentReceiptId(), state);
    }

    public void add(ShipmentReceiptState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedShipmentReceiptStates.put(((ShipmentReceiptState.SqlShipmentReceiptState)state).getShipmentReceiptId(), state);
    }

    public Collection<ShipmentReceiptState> getLoadedStates() {
        return Collections.unmodifiableCollection(this.loadedShipmentReceiptStates.values());
    }

    public Collection<ShipmentReceiptState> getRemovedStates() {
        return Collections.unmodifiableCollection(this.removedShipmentReceiptStates.values());
    }

    //region Saveable Implements

    public void save ()
    {
        for (ShipmentReceiptState s : this.getLoadedShipmentReceiptStates()) {
            getShipmentReceiptStateDao().save(s);
        }
        for (ShipmentReceiptState s : this.removedShipmentReceiptStates.values()) {
            getShipmentReceiptStateDao().delete(s);
        }
    }

    //endregion

}


