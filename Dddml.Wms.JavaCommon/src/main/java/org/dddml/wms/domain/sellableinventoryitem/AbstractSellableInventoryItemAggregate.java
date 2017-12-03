package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractSellableInventoryItemAggregate extends AbstractAggregate implements SellableInventoryItemAggregate
{
    private SellableInventoryItemState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractSellableInventoryItemAggregate(SellableInventoryItemState state)
    {
        this.state = state;
    }

    public SellableInventoryItemState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(SellableInventoryItemCommand.CreateSellableInventoryItem c)
    {
        if (c.getVersion() == null) { c.setVersion(SellableInventoryItemState.VERSION_NULL); }
        SellableInventoryItemStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(SellableInventoryItemCommand.MergePatchSellableInventoryItem c)
    {
        SellableInventoryItemStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c)
    {
        if (this.state.getVersion() == null)
        {
            if (isCommandCreate((SellableInventoryItemCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((SellableInventoryItemCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected SellableInventoryItemStateEvent map(SellableInventoryItemCommand.CreateSellableInventoryItem c) {
        SellableInventoryItemStateEventId stateEventId = new SellableInventoryItemStateEventId(c.getSellableInventoryItemId(), c.getVersion());
        SellableInventoryItemStateEvent.SellableInventoryItemStateCreated e = newSellableInventoryItemStateCreated(stateEventId);
        ((AbstractSellableInventoryItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal quantitySellable = BigDecimal.ZERO;
        Long version = c.getVersion();
        for (SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry innerCommand : c.getEntries())
        {
            throwOnInconsistentCommands(c, innerCommand);
            SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addSellableInventoryItemEntryEvent(innerEvent);
            quantitySellable = quantitySellable.add(innerEvent.getQuantitySellable() != null ? innerEvent.getQuantitySellable() : BigDecimal.ZERO);
        }

        e.setQuantitySellable(quantitySellable);
        return e;
    }

    protected SellableInventoryItemStateEvent map(SellableInventoryItemCommand.MergePatchSellableInventoryItem c) {
        SellableInventoryItemStateEventId stateEventId = new SellableInventoryItemStateEventId(c.getSellableInventoryItemId(), c.getVersion());
        SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched e = newSellableInventoryItemStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal quantitySellable = this.state.getQuantitySellable();
        Long version = c.getVersion();
        for (SellableInventoryItemEntryCommand innerCommand : c.getSellableInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            SellableInventoryItemEntryStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addSellableInventoryItemEntryEvent(innerEvent);
            // ////////////////
            if (!(innerEvent instanceof SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated)) { continue; }
            SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated entryCreated = (SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated)innerEvent;
            quantitySellable = quantitySellable.add(entryCreated.getQuantitySellable() != null ? entryCreated.getQuantitySellable() : BigDecimal.ZERO);
            // ////////////////
        }

        e.setQuantitySellable(quantitySellable);
        return e;
    }


    protected SellableInventoryItemEntryStateEvent map(SellableInventoryItemEntryCommand c, SellableInventoryItemCommand outerCommand, long version, SellableInventoryItemState outerState)
    {
        SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry create = (c.getCommandType().equals(CommandType.CREATE)) ? ((SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated mapCreate(SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c, SellableInventoryItemCommand outerCommand, Long version, SellableInventoryItemState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        SellableInventoryItemEntryStateEventId stateEventId = new SellableInventoryItemEntryStateEventId(c.getSellableInventoryItemId(), c.getEntrySeqId(), version);
        SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated e = newSellableInventoryItemEntryStateCreated(stateEventId);
        SellableInventoryItemEntryState s = outerState.getEntries().get(c.getEntrySeqId());

        e.setQuantitySellable(c.getQuantitySellable());
        e.setSourceEventId(c.getSourceEventId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected void throwOnInconsistentCommands(SellableInventoryItemCommand command, SellableInventoryItemEntryCommand innerCommand)
    {
        AbstractSellableInventoryItemCommand properties = command instanceof AbstractSellableInventoryItemCommand ? (AbstractSellableInventoryItemCommand) command : null;
        AbstractSellableInventoryItemEntryCommand innerProperties = innerCommand instanceof AbstractSellableInventoryItemEntryCommand ? (AbstractSellableInventoryItemEntryCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerSellableInventoryItemIdName = "SellableInventoryItemId";
        InventoryItemId outerSellableInventoryItemIdValue = properties.getSellableInventoryItemId();
        String innerSellableInventoryItemIdName = "SellableInventoryItemId";
        InventoryItemId innerSellableInventoryItemIdValue = innerProperties.getSellableInventoryItemId();
        if (innerSellableInventoryItemIdValue == null) {
            innerProperties.setSellableInventoryItemId(outerSellableInventoryItemIdValue);
        }
        else if (innerSellableInventoryItemIdValue != outerSellableInventoryItemIdValue 
            && (innerSellableInventoryItemIdValue == null || innerSellableInventoryItemIdValue != null && !innerSellableInventoryItemIdValue.equals(outerSellableInventoryItemIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerSellableInventoryItemIdName, outerSellableInventoryItemIdValue, innerSellableInventoryItemIdName, innerSellableInventoryItemIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    private static boolean isCommandCreate(SellableInventoryItemCommand c)
    {
        return ((c instanceof SellableInventoryItemCommand.CreateSellableInventoryItem) 
            && c.getVersion().equals(SellableInventoryItemState.VERSION_NULL));
    }


    ////////////////////////

    protected SellableInventoryItemStateEvent.SellableInventoryItemStateCreated newSellableInventoryItemStateCreated(String commandId, String requesterId) {
        SellableInventoryItemStateEventId stateEventId = new SellableInventoryItemStateEventId(this.state.getSellableInventoryItemId(), this.state.getVersion());
        SellableInventoryItemStateEvent.SellableInventoryItemStateCreated e = newSellableInventoryItemStateCreated(stateEventId);
        ((AbstractSellableInventoryItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched newSellableInventoryItemStateMergePatched(String commandId, String requesterId) {
        SellableInventoryItemStateEventId stateEventId = new SellableInventoryItemStateEventId(this.state.getSellableInventoryItemId(), this.state.getVersion());
        SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched e = newSellableInventoryItemStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemStateEvent.SellableInventoryItemStateCreated newSellableInventoryItemStateCreated(SellableInventoryItemStateEventId stateEventId) {
        return new AbstractSellableInventoryItemStateEvent.SimpleSellableInventoryItemStateCreated(stateEventId);
    }

    protected SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched newSellableInventoryItemStateMergePatched(SellableInventoryItemStateEventId stateEventId) {
        return new AbstractSellableInventoryItemStateEvent.SimpleSellableInventoryItemStateMergePatched(stateEventId);
    }

    protected SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryStateEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryStateEvent.SimpleSellableInventoryItemEntryStateCreated(stateEventId);
    }


    public static class SimpleSellableInventoryItemAggregate extends AbstractSellableInventoryItemAggregate
    {
        public SimpleSellableInventoryItemAggregate(SellableInventoryItemState state) {
            super(state);
        }

    }

}

