package org.dddml.wms.domain.shipmentitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentItemAggregate extends AbstractAggregate implements ShipmentItemAggregate
{
    private ShipmentItemState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentItemAggregate(ShipmentItemState state)
    {
        this.state = state;
    }

    public ShipmentItemState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentItemCommand.CreateShipmentItem c)
    {
        if (c.getVersion() == null) { c.setVersion(ShipmentItemState.VERSION_NULL); }
        ShipmentItemStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentItemCommand.MergePatchShipmentItem c)
    {
        ShipmentItemStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentItemCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentItemStateEvent map(ShipmentItemCommand.CreateShipmentItem c) {
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(c.getShipmentItemId(), c.getVersion());
        ShipmentItemStateEvent.ShipmentItemStateCreated e = newShipmentItemStateCreated(stateEventId);
        e.setProductId(c.getProductId());
        e.setQuantity(c.getQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setActive(c.getActive());
        ((AbstractShipmentItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentItemStateEvent map(ShipmentItemCommand.MergePatchShipmentItem c) {
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(c.getShipmentItemId(), c.getVersion());
        ShipmentItemStateEvent.ShipmentItemStateMergePatched e = newShipmentItemStateMergePatched(stateEventId);
        e.setProductId(c.getProductId());
        e.setQuantity(c.getQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setActive(c.getActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyShipmentContentDescriptionRemoved(c.getIsPropertyShipmentContentDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractShipmentItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentItemStateEvent.ShipmentItemStateCreated newShipmentItemStateCreated(String commandId, String requesterId) {
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(this.state.getShipmentItemId(), this.state.getVersion());
        ShipmentItemStateEvent.ShipmentItemStateCreated e = newShipmentItemStateCreated(stateEventId);
        ((AbstractShipmentItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentItemStateEvent.ShipmentItemStateMergePatched newShipmentItemStateMergePatched(String commandId, String requesterId) {
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(this.state.getShipmentItemId(), this.state.getVersion());
        ShipmentItemStateEvent.ShipmentItemStateMergePatched e = newShipmentItemStateMergePatched(stateEventId);
        ((AbstractShipmentItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentItemStateEvent.ShipmentItemStateCreated newShipmentItemStateCreated(ShipmentItemStateEventId stateEventId) {
        return new AbstractShipmentItemStateEvent.SimpleShipmentItemStateCreated(stateEventId);
    }

    protected ShipmentItemStateEvent.ShipmentItemStateMergePatched newShipmentItemStateMergePatched(ShipmentItemStateEventId stateEventId) {
        return new AbstractShipmentItemStateEvent.SimpleShipmentItemStateMergePatched(stateEventId);
    }


    public static class SimpleShipmentItemAggregate extends AbstractShipmentItemAggregate
    {
        public SimpleShipmentItemAggregate(ShipmentItemState state) {
            super(state);
        }

    }

}

