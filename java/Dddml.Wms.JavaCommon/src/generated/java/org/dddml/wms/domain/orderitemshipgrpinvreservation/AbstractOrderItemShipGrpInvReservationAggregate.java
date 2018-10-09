package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemShipGrpInvReservationAggregate extends AbstractAggregate implements OrderItemShipGrpInvReservationAggregate
{
    private OrderItemShipGrpInvReservationState.MutableOrderItemShipGrpInvReservationState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderItemShipGrpInvReservationAggregate(OrderItemShipGrpInvReservationState state)
    {
        this.state = (OrderItemShipGrpInvReservationState.MutableOrderItemShipGrpInvReservationState)state;
    }

    public OrderItemShipGrpInvReservationState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation c)
    {
        if (c.getVersion() == null) { c.setVersion(OrderItemShipGrpInvReservationState.VERSION_NULL); }
        OrderItemShipGrpInvReservationEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation c)
    {
        OrderItemShipGrpInvReservationEvent e = map(c);
        apply(e);
    }

    public void delete(OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation c)
    {
        OrderItemShipGrpInvReservationEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderItemShipGrpInvReservationCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderItemShipGrpInvReservationEvent map(OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation c) {
        OrderItemShipGrpInvReservationEventId stateEventId = new OrderItemShipGrpInvReservationEventId(c.getOrderItemShipGrpInvResId(), c.getVersion());
        OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated e = newOrderItemShipGrpInvReservationStateCreated(stateEventId);
        e.setReserveOrderEnumId(c.getReserveOrderEnumId());
        e.setQuantity(c.getQuantity());
        e.setQuantityNotAvailable(c.getQuantityNotAvailable());
        e.setReservedDatetime(c.getReservedDatetime());
        e.setCreatedDatetime(c.getCreatedDatetime());
        e.setPromisedDatetime(c.getPromisedDatetime());
        e.setCurrentPromisedDate(c.getCurrentPromisedDate());
        e.setPriority(c.getPriority());
        e.setSequenceId(c.getSequenceId());
        e.setOldPickStartDate(c.getOldPickStartDate());
        e.setActive(c.getActive());
        ((AbstractOrderItemShipGrpInvReservationEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGrpInvReservationEvent map(OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation c) {
        OrderItemShipGrpInvReservationEventId stateEventId = new OrderItemShipGrpInvReservationEventId(c.getOrderItemShipGrpInvResId(), c.getVersion());
        OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched e = newOrderItemShipGrpInvReservationStateMergePatched(stateEventId);
        e.setReserveOrderEnumId(c.getReserveOrderEnumId());
        e.setQuantity(c.getQuantity());
        e.setQuantityNotAvailable(c.getQuantityNotAvailable());
        e.setReservedDatetime(c.getReservedDatetime());
        e.setCreatedDatetime(c.getCreatedDatetime());
        e.setPromisedDatetime(c.getPromisedDatetime());
        e.setCurrentPromisedDate(c.getCurrentPromisedDate());
        e.setPriority(c.getPriority());
        e.setSequenceId(c.getSequenceId());
        e.setOldPickStartDate(c.getOldPickStartDate());
        e.setActive(c.getActive());
        e.setIsPropertyReserveOrderEnumIdRemoved(c.getIsPropertyReserveOrderEnumIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyQuantityNotAvailableRemoved(c.getIsPropertyQuantityNotAvailableRemoved());
        e.setIsPropertyReservedDatetimeRemoved(c.getIsPropertyReservedDatetimeRemoved());
        e.setIsPropertyCreatedDatetimeRemoved(c.getIsPropertyCreatedDatetimeRemoved());
        e.setIsPropertyPromisedDatetimeRemoved(c.getIsPropertyPromisedDatetimeRemoved());
        e.setIsPropertyCurrentPromisedDateRemoved(c.getIsPropertyCurrentPromisedDateRemoved());
        e.setIsPropertyPriorityRemoved(c.getIsPropertyPriorityRemoved());
        e.setIsPropertySequenceIdRemoved(c.getIsPropertySequenceIdRemoved());
        e.setIsPropertyOldPickStartDateRemoved(c.getIsPropertyOldPickStartDateRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrderItemShipGrpInvReservationEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGrpInvReservationEvent map(OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation c) {
        OrderItemShipGrpInvReservationEventId stateEventId = new OrderItemShipGrpInvReservationEventId(c.getOrderItemShipGrpInvResId(), c.getVersion());
        OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted e = newOrderItemShipGrpInvReservationStateDeleted(stateEventId);
        ((AbstractOrderItemShipGrpInvReservationEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated newOrderItemShipGrpInvReservationStateCreated(Long version, String commandId, String requesterId) {
        OrderItemShipGrpInvReservationEventId stateEventId = new OrderItemShipGrpInvReservationEventId(this.state.getOrderItemShipGrpInvResId(), version);
        OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated e = newOrderItemShipGrpInvReservationStateCreated(stateEventId);
        ((AbstractOrderItemShipGrpInvReservationEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched newOrderItemShipGrpInvReservationStateMergePatched(Long version, String commandId, String requesterId) {
        OrderItemShipGrpInvReservationEventId stateEventId = new OrderItemShipGrpInvReservationEventId(this.state.getOrderItemShipGrpInvResId(), version);
        OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched e = newOrderItemShipGrpInvReservationStateMergePatched(stateEventId);
        ((AbstractOrderItemShipGrpInvReservationEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted newOrderItemShipGrpInvReservationStateDeleted(Long version, String commandId, String requesterId) {
        OrderItemShipGrpInvReservationEventId stateEventId = new OrderItemShipGrpInvReservationEventId(this.state.getOrderItemShipGrpInvResId(), version);
        OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted e = newOrderItemShipGrpInvReservationStateDeleted(stateEventId);
        ((AbstractOrderItemShipGrpInvReservationEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated newOrderItemShipGrpInvReservationStateCreated(OrderItemShipGrpInvReservationEventId stateEventId) {
        return new AbstractOrderItemShipGrpInvReservationEvent.SimpleOrderItemShipGrpInvReservationStateCreated(stateEventId);
    }

    protected OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched newOrderItemShipGrpInvReservationStateMergePatched(OrderItemShipGrpInvReservationEventId stateEventId) {
        return new AbstractOrderItemShipGrpInvReservationEvent.SimpleOrderItemShipGrpInvReservationStateMergePatched(stateEventId);
    }

    protected OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted newOrderItemShipGrpInvReservationStateDeleted(OrderItemShipGrpInvReservationEventId stateEventId)
    {
        return new AbstractOrderItemShipGrpInvReservationEvent.SimpleOrderItemShipGrpInvReservationStateDeleted(stateEventId);
    }

    public static class SimpleOrderItemShipGrpInvReservationAggregate extends AbstractOrderItemShipGrpInvReservationAggregate
    {
        public SimpleOrderItemShipGrpInvReservationAggregate(OrderItemShipGrpInvReservationState state) {
            super(state);
        }

    }

}

