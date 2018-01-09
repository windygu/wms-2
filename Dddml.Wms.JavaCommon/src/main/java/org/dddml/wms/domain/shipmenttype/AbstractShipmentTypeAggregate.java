package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentTypeAggregate extends AbstractAggregate implements ShipmentTypeAggregate
{
    private ShipmentTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentTypeAggregate(ShipmentTypeState state)
    {
        this.state = state;
    }

    public ShipmentTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentTypeCommand.CreateShipmentType c)
    {
        if (c.getVersion() == null) { c.setVersion(ShipmentTypeState.VERSION_NULL); }
        ShipmentTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentTypeCommand.MergePatchShipmentType c)
    {
        ShipmentTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentTypeStateEvent map(ShipmentTypeCommand.CreateShipmentType c) {
        ShipmentTypeStateEventId stateEventId = new ShipmentTypeStateEventId(c.getShipmentTypeId(), c.getVersion());
        ShipmentTypeStateEvent.ShipmentTypeStateCreated e = newShipmentTypeStateCreated(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractShipmentTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentTypeStateEvent map(ShipmentTypeCommand.MergePatchShipmentType c) {
        ShipmentTypeStateEventId stateEventId = new ShipmentTypeStateEventId(c.getShipmentTypeId(), c.getVersion());
        ShipmentTypeStateEvent.ShipmentTypeStateMergePatched e = newShipmentTypeStateMergePatched(stateEventId);
        e.setParentTypeId(c.getParentTypeId());
        e.setHasTable(c.getHasTable());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyParentTypeIdRemoved(c.getIsPropertyParentTypeIdRemoved());
        e.setIsPropertyHasTableRemoved(c.getIsPropertyHasTableRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractShipmentTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentTypeStateEvent.ShipmentTypeStateCreated newShipmentTypeStateCreated(Long version, String commandId, String requesterId) {
        ShipmentTypeStateEventId stateEventId = new ShipmentTypeStateEventId(this.state.getShipmentTypeId(), version);
        ShipmentTypeStateEvent.ShipmentTypeStateCreated e = newShipmentTypeStateCreated(stateEventId);
        ((AbstractShipmentTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentTypeStateEvent.ShipmentTypeStateMergePatched newShipmentTypeStateMergePatched(Long version, String commandId, String requesterId) {
        ShipmentTypeStateEventId stateEventId = new ShipmentTypeStateEventId(this.state.getShipmentTypeId(), version);
        ShipmentTypeStateEvent.ShipmentTypeStateMergePatched e = newShipmentTypeStateMergePatched(stateEventId);
        ((AbstractShipmentTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentTypeStateEvent.ShipmentTypeStateCreated newShipmentTypeStateCreated(ShipmentTypeStateEventId stateEventId) {
        return new AbstractShipmentTypeStateEvent.SimpleShipmentTypeStateCreated(stateEventId);
    }

    protected ShipmentTypeStateEvent.ShipmentTypeStateMergePatched newShipmentTypeStateMergePatched(ShipmentTypeStateEventId stateEventId) {
        return new AbstractShipmentTypeStateEvent.SimpleShipmentTypeStateMergePatched(stateEventId);
    }

    public static class SimpleShipmentTypeAggregate extends AbstractShipmentTypeAggregate
    {
        public SimpleShipmentTypeAggregate(ShipmentTypeState state) {
            super(state);
        }

    }

}

