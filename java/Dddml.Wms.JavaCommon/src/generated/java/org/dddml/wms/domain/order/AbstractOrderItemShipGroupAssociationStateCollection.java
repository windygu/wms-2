package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractOrderItemShipGroupAssociationStateCollection implements EntityStateCollection<String, OrderItemShipGroupAssociationState>, Saveable
{
    protected OrderItemShipGroupAssociationStateDao getOrderItemShipGroupAssociationStateDao()
    {
        return (OrderItemShipGroupAssociationStateDao)ApplicationContext.current.get("OrderItemShipGroupAssociationStateDao");
    }

    private OrderShipGroupState orderShipGroupState;

    private Map<OrderItemShipGroupAssociationId, OrderItemShipGroupAssociationState> loadedOrderItemShipGroupAssociationStates = new HashMap<OrderItemShipGroupAssociationId, OrderItemShipGroupAssociationState>();

    private Map<OrderItemShipGroupAssociationId, OrderItemShipGroupAssociationState> removedOrderItemShipGroupAssociationStates = new HashMap<OrderItemShipGroupAssociationId, OrderItemShipGroupAssociationState>();

    protected Iterable<OrderItemShipGroupAssociationState> getLoadedOrderItemShipGroupAssociationStates() {
        return this.loadedOrderItemShipGroupAssociationStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<OrderItemShipGroupAssociationState> getInnerIterable() {
        if (!getForReapplying()) {
            return getOrderItemShipGroupAssociationStateDao().findByOrderIdAndOrderShipGroupShipGroupSeqId(orderShipGroupState.getOrderShipGroupId().getOrderId(), orderShipGroupState.getOrderShipGroupId().getShipGroupSeqId());
        } else {
            List<OrderItemShipGroupAssociationState> ss = new ArrayList<OrderItemShipGroupAssociationState>();
            for (OrderItemShipGroupAssociationState s : loadedOrderItemShipGroupAssociationStates.values()) {
                if (!(removedOrderItemShipGroupAssociationStates.containsKey(s.getOrderItemShipGroupAssociationId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderItemShipGroupAssociationStateCollection(OrderShipGroupState outerState) {
        this.orderShipGroupState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<OrderItemShipGroupAssociationState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderItemShipGroupAssociationState get(String orderItemSeqId) {
        return get(orderItemSeqId, false, false);
    }

    OrderItemShipGroupAssociationState get(String orderItemSeqId, boolean forCreation) {
        return get(orderItemSeqId, forCreation, false);
    }

    OrderItemShipGroupAssociationState get(String orderItemSeqId, boolean forCreation, boolean nullAllowed) {
        OrderItemShipGroupAssociationId globalId = new OrderItemShipGroupAssociationId(orderShipGroupState.getOrderShipGroupId().getOrderId(), orderShipGroupState.getOrderShipGroupId().getShipGroupSeqId(), orderItemSeqId);
        if (loadedOrderItemShipGroupAssociationStates.containsKey(globalId)) {
            return loadedOrderItemShipGroupAssociationStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            OrderItemShipGroupAssociationState state = new AbstractOrderItemShipGroupAssociationState.SimpleOrderItemShipGroupAssociationState(getForReapplying());
            state.setOrderItemShipGroupAssociationId(globalId);
            loadedOrderItemShipGroupAssociationStates.put(globalId, state);
            return state;
        } else {
            OrderItemShipGroupAssociationState state = getOrderItemShipGroupAssociationStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedOrderItemShipGroupAssociationStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderItemShipGroupAssociationState state)
    {
        this.removedOrderItemShipGroupAssociationStates.put(state.getOrderItemShipGroupAssociationId(), state);
    }

    public void add(OrderItemShipGroupAssociationState state)
    {
        this.loadedOrderItemShipGroupAssociationStates.put(state.getOrderItemShipGroupAssociationId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (OrderItemShipGroupAssociationState s : this.getLoadedOrderItemShipGroupAssociationStates()) {
            getOrderItemShipGroupAssociationStateDao().save(s);
        }
        for (OrderItemShipGroupAssociationState s : this.removedOrderItemShipGroupAssociationStates.values()) {
            getOrderItemShipGroupAssociationStateDao().delete(s);
        }
    }

    //endregion

}


