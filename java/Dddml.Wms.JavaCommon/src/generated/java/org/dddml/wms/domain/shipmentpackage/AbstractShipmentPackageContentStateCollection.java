package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractShipmentPackageContentStateCollection implements EntityStateCollection<String, ShipmentPackageContentState>, Saveable
{
    protected ShipmentPackageContentStateDao getShipmentPackageContentStateDao()
    {
        return (ShipmentPackageContentStateDao)ApplicationContext.current.get("ShipmentPackageContentStateDao");
    }

    private ShipmentPackageState shipmentPackageState;

    private Map<ShipmentPackageContentId, ShipmentPackageContentState> loadedShipmentPackageContentStates = new HashMap<ShipmentPackageContentId, ShipmentPackageContentState>();

    private Map<ShipmentPackageContentId, ShipmentPackageContentState> removedShipmentPackageContentStates = new HashMap<ShipmentPackageContentId, ShipmentPackageContentState>();

    protected Iterable<ShipmentPackageContentState> getLoadedShipmentPackageContentStates() {
        return this.loadedShipmentPackageContentStates.values();
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
        if (this.shipmentPackageState instanceof AbstractShipmentPackageState) {
            if (((AbstractShipmentPackageState)this.shipmentPackageState).getStateReadOnly()) 
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

    protected Iterable<ShipmentPackageContentState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getShipmentPackageContentStateDao().findByShipmentPackageId(shipmentPackageState.getShipmentPackageId());
        } else {
            List<ShipmentPackageContentState> ss = new ArrayList<ShipmentPackageContentState>();
            for (ShipmentPackageContentState s : loadedShipmentPackageContentStates.values()) {
                if (!(removedShipmentPackageContentStates.containsKey(((ShipmentPackageContentState.SqlShipmentPackageContentState)s).getShipmentPackageContentId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentPackageContentStateCollection(ShipmentPackageState outerState) {
        this.shipmentPackageState = outerState;
        this.setForReapplying(((ShipmentPackageState.SqlShipmentPackageState)outerState).getForReapplying());
    }

    @Override
    public Iterator<ShipmentPackageContentState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentPackageContentState get(String shipmentItemSeqId) {
        return get(shipmentItemSeqId, false, false);
    }

    public ShipmentPackageContentState get(String shipmentItemSeqId, boolean nullAllowed) {
        return get(shipmentItemSeqId, nullAllowed, false);
    }

    ShipmentPackageContentState get(String shipmentItemSeqId, boolean nullAllowed, boolean forCreation) {
        ShipmentPackageContentId globalId = new ShipmentPackageContentId(shipmentPackageState.getShipmentPackageId(), shipmentItemSeqId);
        if (loadedShipmentPackageContentStates.containsKey(globalId)) {
            ShipmentPackageContentState state = loadedShipmentPackageContentStates.get(globalId);
            if (state instanceof AbstractShipmentPackageContentState) {
                ((AbstractShipmentPackageContentState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            ShipmentPackageContentState state = new AbstractShipmentPackageContentState.SimpleShipmentPackageContentState(getForReapplying());
            ((ShipmentPackageContentState.SqlShipmentPackageContentState)state).setShipmentPackageContentId(globalId);
            loadedShipmentPackageContentStates.put(globalId, state);
            return state;
        } else {
            ShipmentPackageContentState state = getShipmentPackageContentStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractShipmentPackageContentState) {
                    ((AbstractShipmentPackageContentState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((ShipmentPackageContentState.SqlShipmentPackageContentState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedShipmentPackageContentStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentPackageContentState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedShipmentPackageContentStates.put(((ShipmentPackageContentState.SqlShipmentPackageContentState)state).getShipmentPackageContentId(), state);
    }

    public void add(ShipmentPackageContentState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedShipmentPackageContentStates.put(((ShipmentPackageContentState.SqlShipmentPackageContentState)state).getShipmentPackageContentId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (ShipmentPackageContentState s : this.getLoadedShipmentPackageContentStates()) {
            getShipmentPackageContentStateDao().save(s);
        }
        for (ShipmentPackageContentState s : this.removedShipmentPackageContentStates.values()) {
            getShipmentPackageContentStateDao().delete(s);
        }
    }

    //endregion

}


