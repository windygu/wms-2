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
        InventoryItemStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemCommand.MergePatchInventoryItem c)
    {
        InventoryItemStateEvent e = map(c);
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

    protected InventoryItemStateEvent map(InventoryItemCommand.CreateInventoryItem c) {
        InventoryItemStateEventId stateEventId = new InventoryItemStateEventId(c.getInventoryItemId(), c.getVersion());
        InventoryItemStateEvent.InventoryItemStateCreated e = newInventoryItemStateCreated(stateEventId);
        ((AbstractInventoryItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal quantityOnHand = BigDecimal.ZERO;
        BigDecimal quantityReserved = BigDecimal.ZERO;
        BigDecimal quantityOccupied = BigDecimal.ZERO;
        BigDecimal quantityVirtual = BigDecimal.ZERO;
        Long version = c.getVersion();
        for (InventoryItemEntryCommand.CreateInventoryItemEntry innerCommand : c.getEntries())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemEntryStateEvent.InventoryItemEntryStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addInventoryItemEntryEvent(innerEvent);
            quantityOnHand = quantityOnHand.add(innerEvent.getQuantityOnHand() != null ? innerEvent.getQuantityOnHand() : BigDecimal.ZERO);
            quantityReserved = quantityReserved.add(innerEvent.getQuantityReserved() != null ? innerEvent.getQuantityReserved() : BigDecimal.ZERO);
            quantityOccupied = quantityOccupied.add(innerEvent.getQuantityOccupied() != null ? innerEvent.getQuantityOccupied() : BigDecimal.ZERO);
            quantityVirtual = quantityVirtual.add(innerEvent.getQuantityVirtual() != null ? innerEvent.getQuantityVirtual() : BigDecimal.ZERO);
        }

        e.setQuantityOnHand(quantityOnHand);
        e.setQuantityReserved(quantityReserved);
        e.setQuantityOccupied(quantityOccupied);
        e.setQuantityVirtual(quantityVirtual);
        return e;
    }

    protected InventoryItemStateEvent map(InventoryItemCommand.MergePatchInventoryItem c) {
        InventoryItemStateEventId stateEventId = new InventoryItemStateEventId(c.getInventoryItemId(), c.getVersion());
        InventoryItemStateEvent.InventoryItemStateMergePatched e = newInventoryItemStateMergePatched(stateEventId);
        ((AbstractInventoryItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal quantityOnHand = this.state.getQuantityOnHand();
        BigDecimal quantityReserved = this.state.getQuantityReserved();
        BigDecimal quantityOccupied = this.state.getQuantityOccupied();
        BigDecimal quantityVirtual = this.state.getQuantityVirtual();
        Long version = c.getVersion();
        for (InventoryItemEntryCommand innerCommand : c.getInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemEntryStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addInventoryItemEntryEvent(innerEvent);
            // ////////////////
            if (!(innerEvent instanceof InventoryItemEntryStateEvent.InventoryItemEntryStateCreated)) { continue; }
            InventoryItemEntryStateEvent.InventoryItemEntryStateCreated entryCreated = (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated)innerEvent;
            quantityOnHand = quantityOnHand.add(entryCreated.getQuantityOnHand() != null ? entryCreated.getQuantityOnHand() : BigDecimal.ZERO);
            quantityReserved = quantityReserved.add(entryCreated.getQuantityReserved() != null ? entryCreated.getQuantityReserved() : BigDecimal.ZERO);
            quantityOccupied = quantityOccupied.add(entryCreated.getQuantityOccupied() != null ? entryCreated.getQuantityOccupied() : BigDecimal.ZERO);
            quantityVirtual = quantityVirtual.add(entryCreated.getQuantityVirtual() != null ? entryCreated.getQuantityVirtual() : BigDecimal.ZERO);
            // ////////////////
        }

        e.setQuantityOnHand(quantityOnHand);
        e.setQuantityReserved(quantityReserved);
        e.setQuantityOccupied(quantityOccupied);
        e.setQuantityVirtual(quantityVirtual);
        return e;
    }


    protected InventoryItemEntryStateEvent map(InventoryItemEntryCommand c, InventoryItemCommand outerCommand, long version, InventoryItemState outerState)
    {
        InventoryItemEntryCommand.CreateInventoryItemEntry create = (c.getCommandType().equals(CommandType.CREATE)) ? ((InventoryItemEntryCommand.CreateInventoryItemEntry)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected InventoryItemEntryStateEvent.InventoryItemEntryStateCreated mapCreate(InventoryItemEntryCommand.CreateInventoryItemEntry c, InventoryItemCommand outerCommand, Long version, InventoryItemState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        InventoryItemEntryStateEventId stateEventId = new InventoryItemEntryStateEventId(c.getInventoryItemId(), c.getEntrySeqId(), version);
        InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e = newInventoryItemEntryStateCreated(stateEventId);
        InventoryItemEntryState s = outerState.getEntries().get(c.getEntrySeqId());

        e.setQuantityOnHand(c.getQuantityOnHand());
        e.setQuantityReserved(c.getQuantityReserved());
        e.setQuantityOccupied(c.getQuantityOccupied());
        e.setQuantityVirtual(c.getQuantityVirtual());
        e.setSource(c.getSource());
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

    protected InventoryItemStateEvent.InventoryItemStateCreated newInventoryItemStateCreated(String commandId, String requesterId) {
        InventoryItemStateEventId stateEventId = new InventoryItemStateEventId(this.state.getInventoryItemId(), this.state.getVersion());
        InventoryItemStateEvent.InventoryItemStateCreated e = newInventoryItemStateCreated(stateEventId);
        ((AbstractInventoryItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemStateEvent.InventoryItemStateMergePatched newInventoryItemStateMergePatched(String commandId, String requesterId) {
        InventoryItemStateEventId stateEventId = new InventoryItemStateEventId(this.state.getInventoryItemId(), this.state.getVersion());
        InventoryItemStateEvent.InventoryItemStateMergePatched e = newInventoryItemStateMergePatched(stateEventId);
        ((AbstractInventoryItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemStateEvent.InventoryItemStateCreated newInventoryItemStateCreated(InventoryItemStateEventId stateEventId) {
        return new AbstractInventoryItemStateEvent.SimpleInventoryItemStateCreated(stateEventId);
    }

    protected InventoryItemStateEvent.InventoryItemStateMergePatched newInventoryItemStateMergePatched(InventoryItemStateEventId stateEventId) {
        return new AbstractInventoryItemStateEvent.SimpleInventoryItemStateMergePatched(stateEventId);
    }

    protected InventoryItemEntryStateEvent.InventoryItemEntryStateCreated newInventoryItemEntryStateCreated(InventoryItemEntryStateEventId stateEventId) {
        return new AbstractInventoryItemEntryStateEvent.SimpleInventoryItemEntryStateCreated(stateEventId);
    }


    public static class SimpleInventoryItemAggregate extends AbstractInventoryItemAggregate
    {
        public SimpleInventoryItemAggregate(InventoryItemState state) {
            super(state);
        }

    }

}

