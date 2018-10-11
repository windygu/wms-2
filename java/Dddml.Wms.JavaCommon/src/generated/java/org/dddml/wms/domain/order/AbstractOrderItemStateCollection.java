package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractOrderItemStateCollection implements EntityStateCollection<String, OrderItemState>, Saveable
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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        if (this.orderState instanceof AbstractOrderState) {
            if (((AbstractOrderState)this.orderState).getStateReadOnly()) 
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

    protected Iterable<OrderItemState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getOrderItemStateDao().findByOrderId(orderState.getOrderId());
        } else {
            List<OrderItemState> ss = new ArrayList<OrderItemState>();
            for (OrderItemState s : loadedOrderItemStates.values()) {
                if (!(removedOrderItemStates.containsKey(((OrderItemState.SqlOrderItemState)s).getOrderItemId()))) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderItemStateCollection(OrderState outerState) {
        this.orderState = outerState;
        this.setForReapplying(((OrderState.SqlOrderState)outerState).getForReapplying());
    }

    @Override
    public Iterator<OrderItemState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderItemState get(String orderItemSeqId) {
        return get(orderItemSeqId, false, false);
    }

    public OrderItemState get(String orderItemSeqId, boolean nullAllowed) {
        return get(orderItemSeqId, nullAllowed, false);
    }

    OrderItemState get(String orderItemSeqId, boolean nullAllowed, boolean forCreation) {
        OrderItemId globalId = new OrderItemId(orderState.getOrderId(), orderItemSeqId);
        if (loadedOrderItemStates.containsKey(globalId)) {
            OrderItemState state = loadedOrderItemStates.get(globalId);
            if (state instanceof AbstractOrderItemState) {
                ((AbstractOrderItemState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            OrderItemState state = new AbstractOrderItemState.SimpleOrderItemState(getForReapplying());
            ((OrderItemState.SqlOrderItemState)state).setOrderItemId(globalId);
            loadedOrderItemStates.put(globalId, state);
            return state;
        } else {
            OrderItemState state = getOrderItemStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractOrderItemState) {
                    ((AbstractOrderItemState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((OrderItemState.SqlOrderItemState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedOrderItemStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderItemState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedOrderItemStates.put(((OrderItemState.SqlOrderItemState)state).getOrderItemId(), state);
    }

    public void add(OrderItemState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedOrderItemStates.put(((OrderItemState.SqlOrderItemState)state).getOrderItemId(), state);
    }

    public Collection<OrderItemState> getLoadedStates() {
        return Collections.unmodifiableCollection(this.loadedOrderItemStates.values());
    }

    public Collection<OrderItemState> getRemovedStates() {
        return Collections.unmodifiableCollection(this.removedOrderItemStates.values());
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


