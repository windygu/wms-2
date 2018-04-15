package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemEntryMvoAggregate extends AbstractAggregate implements InventoryItemEntryMvoAggregate
{
    private InventoryItemEntryMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryItemEntryMvoAggregate(InventoryItemEntryMvoState state)
    {
        this.state = state;
    }

    public InventoryItemEntryMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo c)
    {
        if (c.getInventoryItemVersion() == null) { c.setInventoryItemVersion(InventoryItemEntryMvoState.VERSION_NULL); }
        InventoryItemEntryMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo c)
    {
        InventoryItemEntryMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InventoryItemEntryMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryItemEntryMvoEvent map(InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo c) {
        InventoryItemEntryMvoEventId stateEventId = new InventoryItemEntryMvoEventId(c.getInventoryItemEntryId(), c.getInventoryItemVersion());
        InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateCreated e = newInventoryItemEntryMvoStateCreated(stateEventId);
        e.setOnHandQuantity(c.getOnHandQuantity());
        e.setInTransitQuantity(c.getInTransitQuantity());
        e.setReservedQuantity(c.getReservedQuantity());
        e.setOccupiedQuantity(c.getOccupiedQuantity());
        e.setVirtualQuantity(c.getVirtualQuantity());
        e.setSource(c.getSource());
        e.setVersion(c.getVersion());
        e.setInventoryItemOnHandQuantity(c.getInventoryItemOnHandQuantity());
        e.setInventoryItemInTransitQuantity(c.getInventoryItemInTransitQuantity());
        e.setInventoryItemReservedQuantity(c.getInventoryItemReservedQuantity());
        e.setInventoryItemOccupiedQuantity(c.getInventoryItemOccupiedQuantity());
        e.setInventoryItemVirtualQuantity(c.getInventoryItemVirtualQuantity());
        e.setInventoryItemCreatedBy(c.getInventoryItemCreatedBy());
        e.setInventoryItemCreatedAt(c.getInventoryItemCreatedAt());
        e.setInventoryItemUpdatedBy(c.getInventoryItemUpdatedBy());
        e.setInventoryItemUpdatedAt(c.getInventoryItemUpdatedAt());
        ((AbstractInventoryItemEntryMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEntryMvoEvent map(InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo c) {
        InventoryItemEntryMvoEventId stateEventId = new InventoryItemEntryMvoEventId(c.getInventoryItemEntryId(), c.getInventoryItemVersion());
        InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateMergePatched e = newInventoryItemEntryMvoStateMergePatched(stateEventId);
        e.setOnHandQuantity(c.getOnHandQuantity());
        e.setInTransitQuantity(c.getInTransitQuantity());
        e.setReservedQuantity(c.getReservedQuantity());
        e.setOccupiedQuantity(c.getOccupiedQuantity());
        e.setVirtualQuantity(c.getVirtualQuantity());
        e.setSource(c.getSource());
        e.setVersion(c.getVersion());
        e.setInventoryItemOnHandQuantity(c.getInventoryItemOnHandQuantity());
        e.setInventoryItemInTransitQuantity(c.getInventoryItemInTransitQuantity());
        e.setInventoryItemReservedQuantity(c.getInventoryItemReservedQuantity());
        e.setInventoryItemOccupiedQuantity(c.getInventoryItemOccupiedQuantity());
        e.setInventoryItemVirtualQuantity(c.getInventoryItemVirtualQuantity());
        e.setInventoryItemCreatedBy(c.getInventoryItemCreatedBy());
        e.setInventoryItemCreatedAt(c.getInventoryItemCreatedAt());
        e.setInventoryItemUpdatedBy(c.getInventoryItemUpdatedBy());
        e.setInventoryItemUpdatedAt(c.getInventoryItemUpdatedAt());
        e.setIsPropertyOnHandQuantityRemoved(c.getIsPropertyOnHandQuantityRemoved());
        e.setIsPropertyInTransitQuantityRemoved(c.getIsPropertyInTransitQuantityRemoved());
        e.setIsPropertyReservedQuantityRemoved(c.getIsPropertyReservedQuantityRemoved());
        e.setIsPropertyOccupiedQuantityRemoved(c.getIsPropertyOccupiedQuantityRemoved());
        e.setIsPropertyVirtualQuantityRemoved(c.getIsPropertyVirtualQuantityRemoved());
        e.setIsPropertySourceRemoved(c.getIsPropertySourceRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyInventoryItemOnHandQuantityRemoved(c.getIsPropertyInventoryItemOnHandQuantityRemoved());
        e.setIsPropertyInventoryItemInTransitQuantityRemoved(c.getIsPropertyInventoryItemInTransitQuantityRemoved());
        e.setIsPropertyInventoryItemReservedQuantityRemoved(c.getIsPropertyInventoryItemReservedQuantityRemoved());
        e.setIsPropertyInventoryItemOccupiedQuantityRemoved(c.getIsPropertyInventoryItemOccupiedQuantityRemoved());
        e.setIsPropertyInventoryItemVirtualQuantityRemoved(c.getIsPropertyInventoryItemVirtualQuantityRemoved());
        e.setIsPropertyInventoryItemCreatedByRemoved(c.getIsPropertyInventoryItemCreatedByRemoved());
        e.setIsPropertyInventoryItemCreatedAtRemoved(c.getIsPropertyInventoryItemCreatedAtRemoved());
        e.setIsPropertyInventoryItemUpdatedByRemoved(c.getIsPropertyInventoryItemUpdatedByRemoved());
        e.setIsPropertyInventoryItemUpdatedAtRemoved(c.getIsPropertyInventoryItemUpdatedAtRemoved());
        ((AbstractInventoryItemEntryMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateCreated newInventoryItemEntryMvoStateCreated(Long version, String commandId, String requesterId) {
        InventoryItemEntryMvoEventId stateEventId = new InventoryItemEntryMvoEventId(this.state.getInventoryItemEntryId(), version);
        InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateCreated e = newInventoryItemEntryMvoStateCreated(stateEventId);
        ((AbstractInventoryItemEntryMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateMergePatched newInventoryItemEntryMvoStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryItemEntryMvoEventId stateEventId = new InventoryItemEntryMvoEventId(this.state.getInventoryItemEntryId(), version);
        InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateMergePatched e = newInventoryItemEntryMvoStateMergePatched(stateEventId);
        ((AbstractInventoryItemEntryMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateCreated newInventoryItemEntryMvoStateCreated(InventoryItemEntryMvoEventId stateEventId) {
        return new AbstractInventoryItemEntryMvoEvent.SimpleInventoryItemEntryMvoStateCreated(stateEventId);
    }

    protected InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateMergePatched newInventoryItemEntryMvoStateMergePatched(InventoryItemEntryMvoEventId stateEventId) {
        return new AbstractInventoryItemEntryMvoEvent.SimpleInventoryItemEntryMvoStateMergePatched(stateEventId);
    }

    public static class SimpleInventoryItemEntryMvoAggregate extends AbstractInventoryItemEntryMvoAggregate
    {
        public SimpleInventoryItemEntryMvoAggregate(InventoryItemEntryMvoState state) {
            super(state);
        }

    }

}

