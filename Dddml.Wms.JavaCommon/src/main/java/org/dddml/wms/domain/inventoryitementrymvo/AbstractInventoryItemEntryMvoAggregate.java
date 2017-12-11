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
        InventoryItemEntryMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo c)
    {
        InventoryItemEntryMvoStateEvent e = map(c);
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

    protected InventoryItemEntryMvoStateEvent map(InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo c) {
        InventoryItemEntryMvoStateEventId stateEventId = new InventoryItemEntryMvoStateEventId(c.getInventoryItemEntryId(), c.getInventoryItemVersion());
        InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated e = newInventoryItemEntryMvoStateCreated(stateEventId);
        e.setQuantityOnHand(c.getQuantityOnHand());
        e.setQuantityReserved(c.getQuantityReserved());
        e.setQuantityOccupied(c.getQuantityOccupied());
        e.setQuantityVirtual(c.getQuantityVirtual());
        e.setSource(c.getSource());
        e.setVersion(c.getVersion());
        e.setInventoryItemQuantityOnHand(c.getInventoryItemQuantityOnHand());
        e.setInventoryItemQuantityReserved(c.getInventoryItemQuantityReserved());
        e.setInventoryItemQuantityOccupied(c.getInventoryItemQuantityOccupied());
        e.setInventoryItemQuantityVirtual(c.getInventoryItemQuantityVirtual());
        e.setInventoryItemCreatedBy(c.getInventoryItemCreatedBy());
        e.setInventoryItemCreatedAt(c.getInventoryItemCreatedAt());
        e.setInventoryItemUpdatedBy(c.getInventoryItemUpdatedBy());
        e.setInventoryItemUpdatedAt(c.getInventoryItemUpdatedAt());
        ((AbstractInventoryItemEntryMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEntryMvoStateEvent map(InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo c) {
        InventoryItemEntryMvoStateEventId stateEventId = new InventoryItemEntryMvoStateEventId(c.getInventoryItemEntryId(), c.getInventoryItemVersion());
        InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched e = newInventoryItemEntryMvoStateMergePatched(stateEventId);
        e.setQuantityOnHand(c.getQuantityOnHand());
        e.setQuantityReserved(c.getQuantityReserved());
        e.setQuantityOccupied(c.getQuantityOccupied());
        e.setQuantityVirtual(c.getQuantityVirtual());
        e.setSource(c.getSource());
        e.setVersion(c.getVersion());
        e.setInventoryItemQuantityOnHand(c.getInventoryItemQuantityOnHand());
        e.setInventoryItemQuantityReserved(c.getInventoryItemQuantityReserved());
        e.setInventoryItemQuantityOccupied(c.getInventoryItemQuantityOccupied());
        e.setInventoryItemQuantityVirtual(c.getInventoryItemQuantityVirtual());
        e.setInventoryItemCreatedBy(c.getInventoryItemCreatedBy());
        e.setInventoryItemCreatedAt(c.getInventoryItemCreatedAt());
        e.setInventoryItemUpdatedBy(c.getInventoryItemUpdatedBy());
        e.setInventoryItemUpdatedAt(c.getInventoryItemUpdatedAt());
        e.setIsPropertyQuantityOnHandRemoved(c.getIsPropertyQuantityOnHandRemoved());
        e.setIsPropertyQuantityReservedRemoved(c.getIsPropertyQuantityReservedRemoved());
        e.setIsPropertyQuantityOccupiedRemoved(c.getIsPropertyQuantityOccupiedRemoved());
        e.setIsPropertyQuantityVirtualRemoved(c.getIsPropertyQuantityVirtualRemoved());
        e.setIsPropertySourceRemoved(c.getIsPropertySourceRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyInventoryItemQuantityOnHandRemoved(c.getIsPropertyInventoryItemQuantityOnHandRemoved());
        e.setIsPropertyInventoryItemQuantityReservedRemoved(c.getIsPropertyInventoryItemQuantityReservedRemoved());
        e.setIsPropertyInventoryItemQuantityOccupiedRemoved(c.getIsPropertyInventoryItemQuantityOccupiedRemoved());
        e.setIsPropertyInventoryItemQuantityVirtualRemoved(c.getIsPropertyInventoryItemQuantityVirtualRemoved());
        e.setIsPropertyInventoryItemCreatedByRemoved(c.getIsPropertyInventoryItemCreatedByRemoved());
        e.setIsPropertyInventoryItemCreatedAtRemoved(c.getIsPropertyInventoryItemCreatedAtRemoved());
        e.setIsPropertyInventoryItemUpdatedByRemoved(c.getIsPropertyInventoryItemUpdatedByRemoved());
        e.setIsPropertyInventoryItemUpdatedAtRemoved(c.getIsPropertyInventoryItemUpdatedAtRemoved());
        ((AbstractInventoryItemEntryMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated newInventoryItemEntryMvoStateCreated(String commandId, String requesterId) {
        InventoryItemEntryMvoStateEventId stateEventId = new InventoryItemEntryMvoStateEventId(this.state.getInventoryItemEntryId(), this.state.getInventoryItemVersion());
        InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated e = newInventoryItemEntryMvoStateCreated(stateEventId);
        ((AbstractInventoryItemEntryMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched newInventoryItemEntryMvoStateMergePatched(String commandId, String requesterId) {
        InventoryItemEntryMvoStateEventId stateEventId = new InventoryItemEntryMvoStateEventId(this.state.getInventoryItemEntryId(), this.state.getInventoryItemVersion());
        InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched e = newInventoryItemEntryMvoStateMergePatched(stateEventId);
        ((AbstractInventoryItemEntryMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated newInventoryItemEntryMvoStateCreated(InventoryItemEntryMvoStateEventId stateEventId) {
        return new AbstractInventoryItemEntryMvoStateEvent.SimpleInventoryItemEntryMvoStateCreated(stateEventId);
    }

    protected InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched newInventoryItemEntryMvoStateMergePatched(InventoryItemEntryMvoStateEventId stateEventId) {
        return new AbstractInventoryItemEntryMvoStateEvent.SimpleInventoryItemEntryMvoStateMergePatched(stateEventId);
    }


    public static class SimpleInventoryItemEntryMvoAggregate extends AbstractInventoryItemEntryMvoAggregate
    {
        public SimpleInventoryItemEntryMvoAggregate(InventoryItemEntryMvoState state) {
            super(state);
        }

    }

}

