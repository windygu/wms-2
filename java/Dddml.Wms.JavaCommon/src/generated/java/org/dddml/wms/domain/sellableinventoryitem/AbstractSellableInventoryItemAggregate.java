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
        SellableInventoryItemEvent e = map(c);
        apply(e);
    }

    public void mergePatch(SellableInventoryItemCommand.MergePatchSellableInventoryItem c)
    {
        SellableInventoryItemEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        SellableInventoryItemCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected SellableInventoryItemEvent map(SellableInventoryItemCommand.CreateSellableInventoryItem c) {
        SellableInventoryItemEventId stateEventId = new SellableInventoryItemEventId(c.getSellableInventoryItemId(), c.getVersion());
        SellableInventoryItemEvent.SellableInventoryItemStateCreated e = newSellableInventoryItemStateCreated(stateEventId);
        ((AbstractSellableInventoryItemEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal sellableQuantity = BigDecimal.ZERO;
        Long version = c.getVersion();
        for (SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry innerCommand : c.getCreateSellableInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addSellableInventoryItemEntryEvent(innerEvent);
            sellableQuantity = sellableQuantity.add(innerEvent.getSellableQuantity() != null ? innerEvent.getSellableQuantity() : BigDecimal.ZERO);
        }

        e.setSellableQuantity(sellableQuantity);
        return e;
    }

    protected SellableInventoryItemEvent map(SellableInventoryItemCommand.MergePatchSellableInventoryItem c) {
        SellableInventoryItemEventId stateEventId = new SellableInventoryItemEventId(c.getSellableInventoryItemId(), c.getVersion());
        SellableInventoryItemEvent.SellableInventoryItemStateMergePatched e = newSellableInventoryItemStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal sellableQuantity = this.state.getSellableQuantity();
        Long version = c.getVersion();
        for (SellableInventoryItemEntryCommand innerCommand : c.getSellableInventoryItemEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            SellableInventoryItemEntryEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addSellableInventoryItemEntryEvent(innerEvent);
            // ////////////////
            if (!(innerEvent instanceof SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated)) { continue; }
            SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated entryCreated = (SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated)innerEvent;
            sellableQuantity = sellableQuantity.add(entryCreated.getSellableQuantity() != null ? entryCreated.getSellableQuantity() : BigDecimal.ZERO);
            // ////////////////
        }

        e.setSellableQuantity(sellableQuantity);
        return e;
    }


    protected SellableInventoryItemEntryEvent map(SellableInventoryItemEntryCommand c, SellableInventoryItemCommand outerCommand, Long version, SellableInventoryItemState outerState)
    {
        SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry create = (c.getCommandType().equals(CommandType.CREATE)) ? ((SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated mapCreate(SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry c, SellableInventoryItemCommand outerCommand, Long version, SellableInventoryItemState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        SellableInventoryItemEntryEventId stateEventId = new SellableInventoryItemEntryEventId(c.getSellableInventoryItemId(), c.getEntrySeqId(), version);
        SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated e = newSellableInventoryItemEntryStateCreated(stateEventId);
        SellableInventoryItemEntryState s = outerState.getEntries().get(c.getEntrySeqId());

        e.setSellableQuantity(c.getSellableQuantity());
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


    ////////////////////////

    protected SellableInventoryItemEvent.SellableInventoryItemStateCreated newSellableInventoryItemStateCreated(Long version, String commandId, String requesterId) {
        SellableInventoryItemEventId stateEventId = new SellableInventoryItemEventId(this.state.getSellableInventoryItemId(), version);
        SellableInventoryItemEvent.SellableInventoryItemStateCreated e = newSellableInventoryItemStateCreated(stateEventId);
        ((AbstractSellableInventoryItemEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEvent.SellableInventoryItemStateMergePatched newSellableInventoryItemStateMergePatched(Long version, String commandId, String requesterId) {
        SellableInventoryItemEventId stateEventId = new SellableInventoryItemEventId(this.state.getSellableInventoryItemId(), version);
        SellableInventoryItemEvent.SellableInventoryItemStateMergePatched e = newSellableInventoryItemStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEvent.SellableInventoryItemStateCreated newSellableInventoryItemStateCreated(SellableInventoryItemEventId stateEventId) {
        return new AbstractSellableInventoryItemEvent.SimpleSellableInventoryItemStateCreated(stateEventId);
    }

    protected SellableInventoryItemEvent.SellableInventoryItemStateMergePatched newSellableInventoryItemStateMergePatched(SellableInventoryItemEventId stateEventId) {
        return new AbstractSellableInventoryItemEvent.SimpleSellableInventoryItemStateMergePatched(stateEventId);
    }

    protected SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated newSellableInventoryItemEntryStateCreated(SellableInventoryItemEntryEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryEvent.SimpleSellableInventoryItemEntryStateCreated(stateEventId);
    }

    public static class SimpleSellableInventoryItemAggregate extends AbstractSellableInventoryItemAggregate
    {
        public SimpleSellableInventoryItemAggregate(SellableInventoryItemState state) {
            super(state);
        }

    }

}

