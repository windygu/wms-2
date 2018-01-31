package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractShipmentReceiptStates implements ShipmentReceiptStates
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

    protected Iterable<ShipmentReceiptState> getInnerIterable() {
        if (!getForReapplying()) {
            return getShipmentReceiptStateDao().findByShipmentId(shipmentState.getShipmentId());
        } else {
            List<ShipmentReceiptState> ss = new ArrayList<ShipmentReceiptState>();
            for (ShipmentReceiptState s : loadedShipmentReceiptStates.values()) {
                if (!(removedShipmentReceiptStates.containsKey(s.getShipmentReceiptId()))) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractShipmentReceiptStates(ShipmentState outerState) {
        this.shipmentState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<ShipmentReceiptState> iterator() {
        return getInnerIterable().iterator();
    }

    public ShipmentReceiptState get(String receiptSeqId) {
        return get(receiptSeqId, false, false);
    }

    public ShipmentReceiptState get(String receiptSeqId, boolean forCreation) {
        return get(receiptSeqId, forCreation, false);
    }

    public ShipmentReceiptState get(String receiptSeqId, boolean forCreation, boolean nullAllowed) {
        ShipmentReceiptId globalId = new ShipmentReceiptId(shipmentState.getShipmentId(), receiptSeqId);
        if (loadedShipmentReceiptStates.containsKey(globalId)) {
            return loadedShipmentReceiptStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            ShipmentReceiptState state = new AbstractShipmentReceiptState.SimpleShipmentReceiptState(getForReapplying());
            state.setShipmentReceiptId(globalId);
            loadedShipmentReceiptStates.put(globalId, state);
            return state;
        } else {
            ShipmentReceiptState state = getShipmentReceiptStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedShipmentReceiptStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(ShipmentReceiptState state)
    {
        this.removedShipmentReceiptStates.put(state.getShipmentReceiptId(), state);
    }

    public void addToSave(ShipmentReceiptState state)
    {
        this.loadedShipmentReceiptStates.put(state.getShipmentReceiptId(), state);
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


