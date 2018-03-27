package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractShipmentPackageContentStates implements ShipmentPackageContentStates
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

    protected Iterable<ShipmentPackageContentState> getInnerIterable() {
        if (!getForReapplying()) {
            return getShipmentPackageContentStateDao().findByShipmentPackageId(shipmentPackageState.getShipmentPackageId());
        } else {
            List<ShipmentPackageContentState> ss = new ArrayList<ShipmentPackageContentState>();
            for (ShipmentPackageContentState s : loadedShipmentPackageContentStates.values()) {
                if (!(removedShipmentPackageContentStates.containsKey(s.getShipmentPackageContentId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentPackageContentStates(ShipmentPackageState outerState) {
        this.shipmentPackageState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<ShipmentPackageContentState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentPackageContentState get(String shipmentItemSeqId) {
        return get(shipmentItemSeqId, false, false);
    }

    public ShipmentPackageContentState get(String shipmentItemSeqId, boolean forCreation) {
        return get(shipmentItemSeqId, forCreation, false);
    }

    public ShipmentPackageContentState get(String shipmentItemSeqId, boolean forCreation, boolean nullAllowed) {
        ShipmentPackageContentId globalId = new ShipmentPackageContentId(shipmentPackageState.getShipmentPackageId(), shipmentItemSeqId);
        if (loadedShipmentPackageContentStates.containsKey(globalId)) {
            return loadedShipmentPackageContentStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            ShipmentPackageContentState state = new AbstractShipmentPackageContentState.SimpleShipmentPackageContentState(getForReapplying());
            state.setShipmentPackageContentId(globalId);
            loadedShipmentPackageContentStates.put(globalId, state);
            return state;
        } else {
            ShipmentPackageContentState state = getShipmentPackageContentStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedShipmentPackageContentStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentPackageContentState state)
    {
        this.removedShipmentPackageContentStates.put(state.getShipmentPackageContentId(), state);
    }

    public void addToSave(ShipmentPackageContentState state)
    {
        this.loadedShipmentPackageContentStates.put(state.getShipmentPackageContentId(), state);
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


