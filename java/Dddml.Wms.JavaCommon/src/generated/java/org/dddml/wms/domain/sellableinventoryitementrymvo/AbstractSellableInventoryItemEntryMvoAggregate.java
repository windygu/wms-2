package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractSellableInventoryItemEntryMvoAggregate extends AbstractAggregate implements SellableInventoryItemEntryMvoAggregate
{
    private SellableInventoryItemEntryMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractSellableInventoryItemEntryMvoAggregate(SellableInventoryItemEntryMvoState state)
    {
        this.state = state;
    }

    public SellableInventoryItemEntryMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo c)
    {
        if (c.getSellableInventoryItemVersion() == null) { c.setSellableInventoryItemVersion(SellableInventoryItemEntryMvoState.VERSION_NULL); }
        SellableInventoryItemEntryMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c)
    {
        SellableInventoryItemEntryMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        SellableInventoryItemEntryMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected SellableInventoryItemEntryMvoStateEvent map(SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo c) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(c.getSellableInventoryItemEntryId(), c.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e = newSellableInventoryItemEntryMvoStateCreated(stateEventId);
        e.setSellableQuantity(c.getSellableQuantity());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setSellableInventoryItemSellableQuantity(c.getSellableInventoryItemSellableQuantity());
        e.setSellableInventoryItemCreatedBy(c.getSellableInventoryItemCreatedBy());
        e.setSellableInventoryItemCreatedAt(c.getSellableInventoryItemCreatedAt());
        e.setSellableInventoryItemUpdatedBy(c.getSellableInventoryItemUpdatedBy());
        e.setSellableInventoryItemUpdatedAt(c.getSellableInventoryItemUpdatedAt());
        ((AbstractSellableInventoryItemEntryMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoStateEvent map(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(c.getSellableInventoryItemEntryId(), c.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e = newSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
        e.setSellableQuantity(c.getSellableQuantity());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setSellableInventoryItemSellableQuantity(c.getSellableInventoryItemSellableQuantity());
        e.setSellableInventoryItemCreatedBy(c.getSellableInventoryItemCreatedBy());
        e.setSellableInventoryItemCreatedAt(c.getSellableInventoryItemCreatedAt());
        e.setSellableInventoryItemUpdatedBy(c.getSellableInventoryItemUpdatedBy());
        e.setSellableInventoryItemUpdatedAt(c.getSellableInventoryItemUpdatedAt());
        e.setIsPropertySellableQuantityRemoved(c.getIsPropertySellableQuantityRemoved());
        e.setIsPropertySourceEventIdRemoved(c.getIsPropertySourceEventIdRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertySellableInventoryItemSellableQuantityRemoved(c.getIsPropertySellableInventoryItemSellableQuantityRemoved());
        e.setIsPropertySellableInventoryItemCreatedByRemoved(c.getIsPropertySellableInventoryItemCreatedByRemoved());
        e.setIsPropertySellableInventoryItemCreatedAtRemoved(c.getIsPropertySellableInventoryItemCreatedAtRemoved());
        e.setIsPropertySellableInventoryItemUpdatedByRemoved(c.getIsPropertySellableInventoryItemUpdatedByRemoved());
        e.setIsPropertySellableInventoryItemUpdatedAtRemoved(c.getIsPropertySellableInventoryItemUpdatedAtRemoved());
        ((AbstractSellableInventoryItemEntryMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated newSellableInventoryItemEntryMvoStateCreated(Long version, String commandId, String requesterId) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(this.state.getSellableInventoryItemEntryId(), version);
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e = newSellableInventoryItemEntryMvoStateCreated(stateEventId);
        ((AbstractSellableInventoryItemEntryMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched newSellableInventoryItemEntryMvoStateMergePatched(Long version, String commandId, String requesterId) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(this.state.getSellableInventoryItemEntryId(), version);
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e = newSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemEntryMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated newSellableInventoryItemEntryMvoStateCreated(SellableInventoryItemEntryMvoEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryMvoStateEvent.SimpleSellableInventoryItemEntryMvoStateCreated(stateEventId);
    }

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched newSellableInventoryItemEntryMvoStateMergePatched(SellableInventoryItemEntryMvoEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryMvoStateEvent.SimpleSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
    }

    public static class SimpleSellableInventoryItemEntryMvoAggregate extends AbstractSellableInventoryItemEntryMvoAggregate
    {
        public SimpleSellableInventoryItemEntryMvoAggregate(SellableInventoryItemEntryMvoState state) {
            super(state);
        }

    }

}

