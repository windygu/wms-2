package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentMethodTypeAggregate extends AbstractAggregate implements ShipmentMethodTypeAggregate
{
    private ShipmentMethodTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentMethodTypeAggregate(ShipmentMethodTypeState state)
    {
        this.state = state;
    }

    public ShipmentMethodTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentMethodTypeCommand.CreateShipmentMethodType c)
    {
        if (c.getVersion() == null) { c.setVersion(ShipmentMethodTypeState.VERSION_NULL); }
        ShipmentMethodTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentMethodTypeCommand.MergePatchShipmentMethodType c)
    {
        ShipmentMethodTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(ShipmentMethodTypeCommand.DeleteShipmentMethodType c)
    {
        ShipmentMethodTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentMethodTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentMethodTypeStateEvent map(ShipmentMethodTypeCommand.CreateShipmentMethodType c) {
        ShipmentMethodTypeEventId stateEventId = new ShipmentMethodTypeEventId(c.getShipmentMethodTypeId(), c.getVersion());
        ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated e = newShipmentMethodTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceNum(c.getSequenceNum());
        e.setActive(c.getActive());
        ((AbstractShipmentMethodTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentMethodTypeStateEvent map(ShipmentMethodTypeCommand.MergePatchShipmentMethodType c) {
        ShipmentMethodTypeEventId stateEventId = new ShipmentMethodTypeEventId(c.getShipmentMethodTypeId(), c.getVersion());
        ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched e = newShipmentMethodTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setSequenceNum(c.getSequenceNum());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertySequenceNumRemoved(c.getIsPropertySequenceNumRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractShipmentMethodTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentMethodTypeStateEvent map(ShipmentMethodTypeCommand.DeleteShipmentMethodType c) {
        ShipmentMethodTypeEventId stateEventId = new ShipmentMethodTypeEventId(c.getShipmentMethodTypeId(), c.getVersion());
        ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted e = newShipmentMethodTypeStateDeleted(stateEventId);
        ((AbstractShipmentMethodTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated newShipmentMethodTypeStateCreated(Long version, String commandId, String requesterId) {
        ShipmentMethodTypeEventId stateEventId = new ShipmentMethodTypeEventId(this.state.getShipmentMethodTypeId(), version);
        ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated e = newShipmentMethodTypeStateCreated(stateEventId);
        ((AbstractShipmentMethodTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched newShipmentMethodTypeStateMergePatched(Long version, String commandId, String requesterId) {
        ShipmentMethodTypeEventId stateEventId = new ShipmentMethodTypeEventId(this.state.getShipmentMethodTypeId(), version);
        ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched e = newShipmentMethodTypeStateMergePatched(stateEventId);
        ((AbstractShipmentMethodTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted newShipmentMethodTypeStateDeleted(Long version, String commandId, String requesterId) {
        ShipmentMethodTypeEventId stateEventId = new ShipmentMethodTypeEventId(this.state.getShipmentMethodTypeId(), version);
        ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted e = newShipmentMethodTypeStateDeleted(stateEventId);
        ((AbstractShipmentMethodTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated newShipmentMethodTypeStateCreated(ShipmentMethodTypeEventId stateEventId) {
        return new AbstractShipmentMethodTypeStateEvent.SimpleShipmentMethodTypeStateCreated(stateEventId);
    }

    protected ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched newShipmentMethodTypeStateMergePatched(ShipmentMethodTypeEventId stateEventId) {
        return new AbstractShipmentMethodTypeStateEvent.SimpleShipmentMethodTypeStateMergePatched(stateEventId);
    }

    protected ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted newShipmentMethodTypeStateDeleted(ShipmentMethodTypeEventId stateEventId)
    {
        return new AbstractShipmentMethodTypeStateEvent.SimpleShipmentMethodTypeStateDeleted(stateEventId);
    }

    public static class SimpleShipmentMethodTypeAggregate extends AbstractShipmentMethodTypeAggregate
    {
        public SimpleShipmentMethodTypeAggregate(ShipmentMethodTypeState state) {
            super(state);
        }

    }

}

