package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractOrderShipGroupStates implements OrderShipGroupStates
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

    protected Iterable<OrderShipGroupState> getInnerIterable() {
        if (!getForReapplying()) {
            return getOrderShipGroupStateDao().findByOrderId(orderState.getOrderId());
        } else {
            List<OrderShipGroupState> ss = new ArrayList<OrderShipGroupState>();
            for (OrderShipGroupState s : loadedOrderShipGroupStates.values()) {
                if (!(removedOrderShipGroupStates.containsKey(s.getOrderShipGroupId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderShipGroupStates(OrderState outerState) {
        this.orderState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<OrderShipGroupState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderShipGroupState get(Long shipGroupSeqId) {
        return get(shipGroupSeqId, false, false);
    }

    public OrderShipGroupState get(Long shipGroupSeqId, boolean forCreation) {
        return get(shipGroupSeqId, forCreation, false);
    }

    public OrderShipGroupState get(Long shipGroupSeqId, boolean forCreation, boolean nullAllowed) {
        OrderShipGroupId globalId = new OrderShipGroupId(orderState.getOrderId(), shipGroupSeqId);
        if (loadedOrderShipGroupStates.containsKey(globalId)) {
            return loadedOrderShipGroupStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            OrderShipGroupState state = new AbstractOrderShipGroupState.SimpleOrderShipGroupState(getForReapplying());
            state.setOrderShipGroupId(globalId);
            loadedOrderShipGroupStates.put(globalId, state);
            return state;
        } else {
            OrderShipGroupState state = getOrderShipGroupStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedOrderShipGroupStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderShipGroupState state)
    {
        this.removedOrderShipGroupStates.put(state.getOrderShipGroupId(), state);
    }

    public void addToSave(OrderShipGroupState state)
    {
        this.loadedOrderShipGroupStates.put(state.getOrderShipGroupId(), state);
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


