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

    public void throwOnInvalidStateTransition(Command c)
    {
        if (this.state.getVersion() == null)
        {
            if (isCommandCreate((InventoryItemCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((InventoryItemCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
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
        e.setQuantityOnHand(c.getQuantityOnHand());
        e.setQuantityReserved(c.getQuantityReserved());
        e.setQuantityOccupied(c.getQuantityOccupied());
        e.setQuantityVirtual(c.getQuantityVirtual());
        ((AbstractInventoryItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (InventoryItemEntryCommand.CreateInventoryItemEntry innerCommand : c.getEntries())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemEntryStateEvent.InventoryItemEntryStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addInventoryItemEntryEvent(innerEvent);
        }

        return e;
    }

    protected InventoryItemStateEvent map(InventoryItemCommand.MergePatchInventoryItem c) {
        InventoryItemStateEventId stateEventId = new InventoryItemStateEventId(c.getInventoryItemId(), c.getVersion());
        InventoryItemStateEvent.InventoryItemStateMergePatched e = newInventoryItemStateMergePatched(stateEventId);
        e.setQuantityOnHand(c.getQuantityOnHand());
        e.setQuantityReserved(c.getQuantityReserved());
        e.setQuantityOccupied(c.getQuantityOccupied());
        e.setQuantityVirtual(c.getQuantityVirtual());
        e.setIsPropertyQuantityOnHandRemoved(c.getIsPropertyQuantityOnHandRemoved());
        e.setIsPropertyQuantityReservedRemoved(c.getIsPropertyQuantityReservedRemoved());
        e.setIsPropertyQuantityOccupiedRemoved(c.getIsPropertyQuantityOccupiedRemoved());
        e.setIsPropertyQuantityVirtualRemoved(c.getIsPropertyQuantityVirtualRemoved());
        ((AbstractInventoryItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (InventoryItemEntryCommand innerCommand : c.getInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemEntryStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addInventoryItemEntryEvent(innerEvent);
        }

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
        e.setActive(c.getActive());
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


    private static boolean isCommandCreate(InventoryItemCommand c)
    {
        return ((c instanceof InventoryItemCommand.CreateInventoryItem) 
            && c.getVersion().equals(InventoryItemState.VERSION_NULL));
    }


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

