package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractOrderItemStates implements OrderItemStates
{
    protected OrderItemStateDao getOrderItemStateDao()
    {
        return (OrderItemStateDao)ApplicationContext.current.get("OrderItemStateDao");
    }

    private OrderState orderState;

    private Map<OrderItemId, OrderItemState> loadedOrderItemStates = new HashMap<OrderItemId, OrderItemState>();

    private Map<OrderItemId, OrderItemState> removedOrderItemStates = new HashMap<OrderItemId, OrderItemState>();

    protected Iterable<OrderItemState> getLoadedOrderItemStates() {
        return this.loadedOrderItemStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<OrderItemState> getInnerIterable() {
        if (!getForReapplying()) {
            return getOrderItemStateDao().findByOrderId(orderState.getOrderId());
        } else {
            List<OrderItemState> ss = new ArrayList<OrderItemState>();
            for (OrderItemState s : loadedOrderItemStates.values()) {
                if (!(removedOrderItemStates.containsKey(s.getOrderItemId()))) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderItemStates(OrderState outerState) {
        this.orderState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<OrderItemState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderItemState get(String orderItemSeqId) {
        return get(orderItemSeqId, false, false);
    }

    OrderItemState get(String orderItemSeqId, boolean forCreation) {
        return get(orderItemSeqId, forCreation, false);
    }

    OrderItemState get(String orderItemSeqId, boolean forCreation, boolean nullAllowed) {
        OrderItemId globalId = new OrderItemId(orderState.getOrderId(), orderItemSeqId);
        if (loadedOrderItemStates.containsKey(globalId)) {
            return loadedOrderItemStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            OrderItemState state = new AbstractOrderItemState.SimpleOrderItemState(getForReapplying());
            state.setOrderItemId(globalId);
            loadedOrderItemStates.put(globalId, state);
            return state;
        } else {
            OrderItemState state = getOrderItemStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedOrderItemStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderItemState state)
    {
        this.removedOrderItemStates.put(state.getOrderItemId(), state);
    }

    public void add(OrderItemState state)
    {
        this.loadedOrderItemStates.put(state.getOrderItemId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (OrderItemState s : this.getLoadedOrderItemStates()) {
            getOrderItemStateDao().save(s);
        }
        for (OrderItemState s : this.removedOrderItemStates.values()) {
            getOrderItemStateDao().delete(s);
        }
    }

    //endregion

}


