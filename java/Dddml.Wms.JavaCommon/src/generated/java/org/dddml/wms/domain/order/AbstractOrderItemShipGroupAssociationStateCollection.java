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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        //if (this.orderShipGroupState instanceof AbstractOrderShipGroupState) {
        //    if (((AbstractOrderShipGroupState)this.orderShipGroupState).getStateReadOnly()) 
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

    protected Iterable<OrderItemShipGroupAssociationState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
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

    public OrderItemShipGroupAssociationState get(String orderItemSeqId, boolean nullAllowed) {
        return get(orderItemSeqId, nullAllowed, false);
    }

    OrderItemShipGroupAssociationState get(String orderItemSeqId, boolean nullAllowed, boolean forCreation) {
        OrderItemShipGroupAssociationId globalId = new OrderItemShipGroupAssociationId(orderShipGroupState.getOrderShipGroupId().getOrderId(), orderShipGroupState.getOrderShipGroupId().getShipGroupSeqId(), orderItemSeqId);
        if (loadedOrderItemShipGroupAssociationStates.containsKey(globalId)) {
            OrderItemShipGroupAssociationState state = loadedOrderItemShipGroupAssociationStates.get(globalId);
            if (state instanceof AbstractOrderItemShipGroupAssociationState) {
                ((AbstractOrderItemShipGroupAssociationState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            OrderItemShipGroupAssociationState state = new AbstractOrderItemShipGroupAssociationState.SimpleOrderItemShipGroupAssociationState(getForReapplying());
            state.setOrderItemShipGroupAssociationId(globalId);
            loadedOrderItemShipGroupAssociationStates.put(globalId, state);
            return state;
        } else {
            OrderItemShipGroupAssociationState state = getOrderItemShipGroupAssociationStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state.isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedOrderItemShipGroupAssociationStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderItemShipGroupAssociationState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedOrderItemShipGroupAssociationStates.put(state.getOrderItemShipGroupAssociationId(), state);
    }

    public void add(OrderItemShipGroupAssociationState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
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


