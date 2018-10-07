package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemAggregate extends AbstractAggregate implements InventoryItemAggregate
{
    private InventoryItemState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryItemAggregate(InventoryItemState state)
    {
        this.state = state;
    }

    public InventoryItemState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryItemCommand.CreateInventoryItem c)
    {
        if (c.getVersion() == null) { c.setVersion(InventoryItemState.VERSION_NULL); }
        InventoryItemEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemCommand.MergePatchInventoryItem c)
    {
        InventoryItemEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InventoryItemCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryItemEvent map(InventoryItemCommand.CreateInventoryItem c) {
        InventoryItemEventId stateEventId = new InventoryItemEventId(c.getInventoryItemId(), c.getVersion());
        InventoryItemEvent.InventoryItemStateCreated e = newInventoryItemStateCreated(stateEventId);
        ((AbstractInventoryItemEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal onHandQuantity = BigDecimal.ZERO;
        BigDecimal inTransitQuantity = BigDecimal.ZERO;
        BigDecimal reservedQuantity = BigDecimal.ZERO;
        BigDecimal occupiedQuantity = BigDecimal.ZERO;
        BigDecimal virtualQuantity = BigDecimal.ZERO;
        Long version = c.getVersion();
        for (InventoryItemEntryCommand.CreateInventoryItemEntry innerCommand : c.getCreateInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemEntryEvent.InventoryItemEntryStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addInventoryItemEntryEvent(innerEvent);
            onHandQuantity = onHandQuantity.add(innerEvent.getOnHandQuantity() != null ? innerEvent.getOnHandQuantity() : BigDecimal.ZERO);
            inTransitQuantity = inTransitQuantity.add(innerEvent.getInTransitQuantity() != null ? innerEvent.getInTransitQuantity() : BigDecimal.ZERO);
            reservedQuantity = reservedQuantity.add(innerEvent.getReservedQuantity() != null ? innerEvent.getReservedQuantity() : BigDecimal.ZERO);
            occupiedQuantity = occupiedQuantity.add(innerEvent.getOccupiedQuantity() != null ? innerEvent.getOccupiedQuantity() : BigDecimal.ZERO);
            virtualQuantity = virtualQuantity.add(innerEvent.getVirtualQuantity() != null ? innerEvent.getVirtualQuantity() : BigDecimal.ZERO);
        }

        e.setOnHandQuantity(onHandQuantity);
        e.setInTransitQuantity(inTransitQuantity);
        e.setReservedQuantity(reservedQuantity);
        e.setOccupiedQuantity(occupiedQuantity);
        e.setVirtualQuantity(virtualQuantity);
        return e;
    }

    protected InventoryItemEvent map(InventoryItemCommand.MergePatchInventoryItem c) {
        InventoryItemEventId stateEventId = new InventoryItemEventId(c.getInventoryItemId(), c.getVersion());
        InventoryItemEvent.InventoryItemStateMergePatched e = newInventoryItemStateMergePatched(stateEventId);
        ((AbstractInventoryItemEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal onHandQuantity = this.state.getOnHandQuantity();
        BigDecimal inTransitQuantity = this.state.getInTransitQuantity();
        BigDecimal reservedQuantity = this.state.getReservedQuantity();
        BigDecimal occupiedQuantity = this.state.getOccupiedQuantity();
        BigDecimal virtualQuantity = this.state.getVirtualQuantity();
        Long version = c.getVersion();
        for (InventoryItemEntryCommand innerCommand : c.getInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemEntryEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addInventoryItemEntryEvent(innerEvent);
            // ////////////////
            if (!(innerEvent instanceof InventoryItemEntryEvent.InventoryItemEntryStateCreated)) { continue; }
            InventoryItemEntryEvent.InventoryItemEntryStateCreated entryCreated = (InventoryItemEntryEvent.InventoryItemEntryStateCreated)innerEvent;
            onHandQuantity = onHandQuantity.add(entryCreated.getOnHandQuantity() != null ? entryCreated.getOnHandQuantity() : BigDecimal.ZERO);
            inTransitQuantity = inTransitQuantity.add(entryCreated.getInTransitQuantity() != null ? entryCreated.getInTransitQuantity() : BigDecimal.ZERO);
            reservedQuantity = reservedQuantity.add(entryCreated.getReservedQuantity() != null ? entryCreated.getReservedQuantity() : BigDecimal.ZERO);
            occupiedQuantity = occupiedQuantity.add(entryCreated.getOccupiedQuantity() != null ? entryCreated.getOccupiedQuantity() : BigDecimal.ZERO);
            virtualQuantity = virtualQuantity.add(entryCreated.getVirtualQuantity() != null ? entryCreated.getVirtualQuantity() : BigDecimal.ZERO);
            // ////////////////
        }

        e.setOnHandQuantity(onHandQuantity);
        e.setInTransitQuantity(inTransitQuantity);
        e.setReservedQuantity(reservedQuantity);
        e.setOccupiedQuantity(occupiedQuantity);
        e.setVirtualQuantity(virtualQuantity);
        return e;
    }


    protected InventoryItemEntryEvent map(InventoryItemEntryCommand c, InventoryItemCommand outerCommand, Long version, InventoryItemState outerState)
    {
        InventoryItemEntryCommand.CreateInventoryItemEntry create = (c.getCommandType().equals(CommandType.CREATE)) ? ((InventoryItemEntryCommand.CreateInventoryItemEntry)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected InventoryItemEntryEvent.InventoryItemEntryStateCreated mapCreate(InventoryItemEntryCommand.CreateInventoryItemEntry c, InventoryItemCommand outerCommand, Long version, InventoryItemState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        InventoryItemEntryEventId stateEventId = new InventoryItemEntryEventId(c.getInventoryItemId(), c.getEntrySeqId(), version);
        InventoryItemEntryEvent.InventoryItemEntryStateCreated e = newInventoryItemEntryStateCreated(stateEventId);
        InventoryItemEntryState s = outerState.getEntries().get(c.getEntrySeqId());

        e.setOnHandQuantity(c.getOnHandQuantity());
        e.setInTransitQuantity(c.getInTransitQuantity());
        e.setReservedQuantity(c.getReservedQuantity());
        e.setOccupiedQuantity(c.getOccupiedQuantity());
        e.setVirtualQuantity(c.getVirtualQuantity());
        e.setSource(c.getSource());
        e.setOccurredAt(c.getOccurredAt());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected void throwOnInconsistentCommands(InventoryItemCommand command, InventoryItemEntryCommand innerCommand)
    {
        AbstractInventoryItemCommand properties = command instanceof AbstractInventoryItemCommand ? (AbstractInventoryItemCommand) command : null;
        AbstractInventoryItemEntryCommand innerProperties = innerCommand instanceof AbstractInventoryItemEntryCommand ? (AbstractInventoryItemEntryCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerInventoryItemIdName = "InventoryItemId";
        InventoryItemId outerInventoryItemIdValue = properties.getInventoryItemId();
        String innerInventoryItemIdName = "InventoryItemId";
        InventoryItemId innerInventoryItemIdValue = innerProperties.getInventoryItemId();
        if (innerInventoryItemIdValue == null) {
            innerProperties.setInventoryItemId(outerInventoryItemIdValue);
        }
        else if (innerInventoryItemIdValue != outerInventoryItemIdValue 
            && (innerInventoryItemIdValue == null || innerInventoryItemIdValue != null && !innerInventoryItemIdValue.equals(outerInventoryItemIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerInventoryItemIdName, outerInventoryItemIdValue, innerInventoryItemIdName, innerInventoryItemIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected InventoryItemEvent.InventoryItemStateCreated newInventoryItemStateCreated(Long version, String commandId, String requesterId) {
        InventoryItemEventId stateEventId = new InventoryItemEventId(this.state.getInventoryItemId(), version);
        InventoryItemEvent.InventoryItemStateCreated e = newInventoryItemStateCreated(stateEventId);
        ((AbstractInventoryItemEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEvent.InventoryItemStateMergePatched newInventoryItemStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryItemEventId stateEventId = new InventoryItemEventId(this.state.getInventoryItemId(), version);
        InventoryItemEvent.InventoryItemStateMergePatched e = newInventoryItemStateMergePatched(stateEventId);
        ((AbstractInventoryItemEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemEvent.InventoryItemStateCreated newInventoryItemStateCreated(InventoryItemEventId stateEventId) {
        return new AbstractInventoryItemEvent.SimpleInventoryItemStateCreated(stateEventId);
    }

    protected InventoryItemEvent.InventoryItemStateMergePatched newInventoryItemStateMergePatched(InventoryItemEventId stateEventId) {
        return new AbstractInventoryItemEvent.SimpleInventoryItemStateMergePatched(stateEventId);
    }

    protected InventoryItemEntryEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(InventoryItemEntryEventId stateEventId) {
        return new AbstractInventoryItemEntryEvent.SimpleInventoryItemEntryStateCreated(stateEventId);
    }

    public static class SimpleInventoryItemAggregate extends AbstractInventoryItemAggregate
    {
        public SimpleInventoryItemAggregate(InventoryItemState state) {
            super(state);
        }

    }

}

