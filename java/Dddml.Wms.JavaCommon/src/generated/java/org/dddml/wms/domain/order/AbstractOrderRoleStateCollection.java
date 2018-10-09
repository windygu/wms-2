package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractOrderRoleStateCollection implements EntityStateCollection<PartyRoleId, OrderRoleState>, Saveable
{
    protected OrderRoleStateDao getOrderRoleStateDao()
    {
        return (OrderRoleStateDao)ApplicationContext.current.get("OrderRoleStateDao");
    }

    private OrderState orderState;

    private Map<OrderRoleId, OrderRoleState> loadedOrderRoleStates = new HashMap<OrderRoleId, OrderRoleState>();

    private Map<OrderRoleId, OrderRoleState> removedOrderRoleStates = new HashMap<OrderRoleId, OrderRoleState>();

    protected Iterable<OrderRoleState> getLoadedOrderRoleStates() {
        return this.loadedOrderRoleStates.values();
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

    protected Iterable<OrderRoleState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getOrderRoleStateDao().findByOrderId(orderState.getOrderId());
        } else {
            List<OrderRoleState> ss = new ArrayList<OrderRoleState>();
            for (OrderRoleState s : loadedOrderRoleStates.values()) {
                if (!(removedOrderRoleStates.containsKey(((OrderRoleState.SqlOrderRoleState)s).getOrderRoleId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderRoleStateCollection(OrderState outerState) {
        this.orderState = outerState;
        this.setForReapplying(((OrderState.SqlOrderState)outerState).getForReapplying());
    }

    @Override
    public Iterator<OrderRoleState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderRoleState get(PartyRoleId partyRoleId) {
        return get(partyRoleId, false, false);
    }

    public OrderRoleState get(PartyRoleId partyRoleId, boolean nullAllowed) {
        return get(partyRoleId, nullAllowed, false);
    }

    OrderRoleState get(PartyRoleId partyRoleId, boolean nullAllowed, boolean forCreation) {
        OrderRoleId globalId = new OrderRoleId(orderState.getOrderId(), partyRoleId);
        if (loadedOrderRoleStates.containsKey(globalId)) {
            OrderRoleState state = loadedOrderRoleStates.get(globalId);
            if (state instanceof AbstractOrderRoleState) {
                ((AbstractOrderRoleState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            OrderRoleState state = new AbstractOrderRoleState.SimpleOrderRoleState(getForReapplying());
            ((OrderRoleState.SqlOrderRoleState)state).setOrderRoleId(globalId);
            loadedOrderRoleStates.put(globalId, state);
            return state;
        } else {
            OrderRoleState state = getOrderRoleStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((OrderRoleState.SqlOrderRoleState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractOrderRoleState) {
                    ((AbstractOrderRoleState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedOrderRoleStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderRoleState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedOrderRoleStates.put(((OrderRoleState.SqlOrderRoleState)state).getOrderRoleId(), state);
    }

    public void add(OrderRoleState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedOrderRoleStates.put(((OrderRoleState.SqlOrderRoleState)state).getOrderRoleId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (OrderRoleState s : this.getLoadedOrderRoleStates()) {
            getOrderRoleStateDao().save(s);
        }
        for (OrderRoleState s : this.removedOrderRoleStates.values()) {
            getOrderRoleStateDao().delete(s);
        }
    }

    //endregion

}


