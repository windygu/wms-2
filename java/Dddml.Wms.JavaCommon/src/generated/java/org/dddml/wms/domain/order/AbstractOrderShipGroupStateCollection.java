package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractOrderShipGroupStateCollection implements EntityStateCollection<String, OrderShipGroupState>, Saveable
{
    protected OrderShipGroupStateDao getOrderShipGroupStateDao()
    {
        return (OrderShipGroupStateDao)ApplicationContext.current.get("OrderShipGroupStateDao");
    }

    private OrderState orderState;

    private Map<OrderShipGroupId, OrderShipGroupState> loadedOrderShipGroupStates = new HashMap<OrderShipGroupId, OrderShipGroupState>();

    private Map<OrderShipGroupId, OrderShipGroupState> removedOrderShipGroupStates = new HashMap<OrderShipGroupId, OrderShipGroupState>();

    protected Iterable<OrderShipGroupState> getLoadedOrderShipGroupStates() {
        return this.loadedOrderShipGroupStates.values();
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
        //if (this.orderState instanceof AbstractOrderState) {
        //    if (((AbstractOrderState)this.orderState).getStateReadOnly()) 
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

    protected Iterable<OrderShipGroupState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getOrderShipGroupStateDao().findByOrderId(orderState.getOrderId());
        } else {
            List<OrderShipGroupState> ss = new ArrayList<OrderShipGroupState>();
            for (OrderShipGroupState s : loadedOrderShipGroupStates.values()) {
                if (!(removedOrderShipGroupStates.containsKey(((OrderShipGroupState.SqlOrderShipGroupState)s).getOrderShipGroupId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderShipGroupStateCollection(OrderState outerState) {
        this.orderState = outerState;
        this.setForReapplying(((OrderState.SqlOrderState)outerState).getForReapplying());
    }

    @Override
    public Iterator<OrderShipGroupState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderShipGroupState get(String shipGroupSeqId) {
        return get(shipGroupSeqId, false, false);
    }

    public OrderShipGroupState get(String shipGroupSeqId, boolean nullAllowed) {
        return get(shipGroupSeqId, nullAllowed, false);
    }

    OrderShipGroupState get(String shipGroupSeqId, boolean nullAllowed, boolean forCreation) {
        OrderShipGroupId globalId = new OrderShipGroupId(orderState.getOrderId(), shipGroupSeqId);
        if (loadedOrderShipGroupStates.containsKey(globalId)) {
            OrderShipGroupState state = loadedOrderShipGroupStates.get(globalId);
            if (state instanceof AbstractOrderShipGroupState) {
                ((AbstractOrderShipGroupState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            OrderShipGroupState state = new AbstractOrderShipGroupState.SimpleOrderShipGroupState(getForReapplying());
            ((OrderShipGroupState.SqlOrderShipGroupState)state).setOrderShipGroupId(globalId);
            loadedOrderShipGroupStates.put(globalId, state);
            return state;
        } else {
            OrderShipGroupState state = getOrderShipGroupStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((OrderShipGroupState.SqlOrderShipGroupState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractOrderShipGroupState) {
                    ((AbstractOrderShipGroupState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedOrderShipGroupStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderShipGroupState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedOrderShipGroupStates.put(((OrderShipGroupState.SqlOrderShipGroupState)state).getOrderShipGroupId(), state);
    }

    public void add(OrderShipGroupState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedOrderShipGroupStates.put(((OrderShipGroupState.SqlOrderShipGroupState)state).getOrderShipGroupId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (OrderShipGroupState s : this.getLoadedOrderShipGroupStates()) {
            getOrderShipGroupStateDao().save(s);
        }
        for (OrderShipGroupState s : this.removedOrderShipGroupStates.values()) {
            getOrderShipGroupStateDao().delete(s);
        }
    }

    //endregion

}


