package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderShipmentAggregate extends AbstractAggregate implements OrderShipmentAggregate
{
    private OrderShipmentState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderShipmentAggregate(OrderShipmentState state)
    {
        this.state = state;
    }

    public OrderShipmentState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderShipmentCommand.CreateOrderShipment c)
    {
        if (c.getVersion() == null) { c.setVersion(OrderShipmentState.VERSION_NULL); }
        OrderShipmentEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderShipmentCommand.MergePatchOrderShipment c)
    {
        OrderShipmentEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderShipmentCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderShipmentEvent map(OrderShipmentCommand.CreateOrderShipment c) {
        OrderShipmentEventId stateEventId = new OrderShipmentEventId(c.getOrderShipmentId(), c.getVersion());
        OrderShipmentEvent.OrderShipmentStateCreated e = newOrderShipmentStateCreated(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        ((AbstractOrderShipmentEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipmentEvent map(OrderShipmentCommand.MergePatchOrderShipment c) {
        OrderShipmentEventId stateEventId = new OrderShipmentEventId(c.getOrderShipmentId(), c.getVersion());
        OrderShipmentEvent.OrderShipmentStateMergePatched e = newOrderShipmentStateMergePatched(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrderShipmentEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderShipmentEvent.OrderShipmentStateCreated newOrderShipmentStateCreated(Long version, String commandId, String requesterId) {
        OrderShipmentEventId stateEventId = new OrderShipmentEventId(this.state.getOrderShipmentId(), version);
        OrderShipmentEvent.OrderShipmentStateCreated e = newOrderShipmentStateCreated(stateEventId);
        ((AbstractOrderShipmentEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipmentEvent.OrderShipmentStateMergePatched newOrderShipmentStateMergePatched(Long version, String commandId, String requesterId) {
        OrderShipmentEventId stateEventId = new OrderShipmentEventId(this.state.getOrderShipmentId(), version);
        OrderShipmentEvent.OrderShipmentStateMergePatched e = newOrderShipmentStateMergePatched(stateEventId);
        ((AbstractOrderShipmentEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipmentEvent.OrderShipmentStateCreated newOrderShipmentStateCreated(OrderShipmentEventId stateEventId) {
        return new AbstractOrderShipmentEvent.SimpleOrderShipmentStateCreated(stateEventId);
    }

    protected OrderShipmentEvent.OrderShipmentStateMergePatched newOrderShipmentStateMergePatched(OrderShipmentEventId stateEventId) {
        return new AbstractOrderShipmentEvent.SimpleOrderShipmentStateMergePatched(stateEventId);
    }

    public static class SimpleOrderShipmentAggregate extends AbstractOrderShipmentAggregate
    {
        public SimpleOrderShipmentAggregate(OrderShipmentState state) {
            super(state);
        }

    }

}

