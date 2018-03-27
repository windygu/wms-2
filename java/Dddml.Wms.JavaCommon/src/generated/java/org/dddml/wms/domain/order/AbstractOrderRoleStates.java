package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractOrderRoleStates implements OrderRoleStates
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

    protected Iterable<OrderRoleState> getInnerIterable() {
        if (!getForReapplying()) {
            return getOrderRoleStateDao().findByOrderId(orderState.getOrderId());
        } else {
            List<OrderRoleState> ss = new ArrayList<OrderRoleState>();
            for (OrderRoleState s : loadedOrderRoleStates.values()) {
                if (!(removedOrderRoleStates.containsKey(s.getOrderRoleId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractOrderRoleStates(OrderState outerState) {
        this.orderState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<OrderRoleState> iterator() {
        return getInnerIterable().iterator();
    }

    public OrderRoleState get(PartyRoleId partyRoleId) {
        return get(partyRoleId, false, false);
    }

    public OrderRoleState get(PartyRoleId partyRoleId, boolean forCreation) {
        return get(partyRoleId, forCreation, false);
    }

    public OrderRoleState get(PartyRoleId partyRoleId, boolean forCreation, boolean nullAllowed) {
        OrderRoleId globalId = new OrderRoleId(orderState.getOrderId(), partyRoleId);
        if (loadedOrderRoleStates.containsKey(globalId)) {
            return loadedOrderRoleStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            OrderRoleState state = new AbstractOrderRoleState.SimpleOrderRoleState(getForReapplying());
            state.setOrderRoleId(globalId);
            loadedOrderRoleStates.put(globalId, state);
            return state;
        } else {
            OrderRoleState state = getOrderRoleStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedOrderRoleStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(OrderRoleState state)
    {
        this.removedOrderRoleStates.put(state.getOrderRoleId(), state);
    }

    public void addToSave(OrderRoleState state)
    {
        this.loadedOrderRoleStates.put(state.getOrderRoleId(), state);
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


