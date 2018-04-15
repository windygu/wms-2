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
        SellableInventoryItemEntryMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c)
    {
        SellableInventoryItemEntryMvoEvent e = map(c);
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

    protected SellableInventoryItemEntryMvoEvent map(SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo c) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(c.getSellableInventoryItemEntryId(), c.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated e = newSellableInventoryItemEntryMvoStateCreated(stateEventId);
        e.setSellableQuantity(c.getSellableQuantity());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setSellableInventoryItemSellableQuantity(c.getSellableInventoryItemSellableQuantity());
        e.setSellableInventoryItemCreatedBy(c.getSellableInventoryItemCreatedBy());
        e.setSellableInventoryItemCreatedAt(c.getSellableInventoryItemCreatedAt());
        e.setSellableInventoryItemUpdatedBy(c.getSellableInventoryItemUpdatedBy());
        e.setSellableInventoryItemUpdatedAt(c.getSellableInventoryItemUpdatedAt());
        ((AbstractSellableInventoryItemEntryMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoEvent map(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(c.getSellableInventoryItemEntryId(), c.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched e = newSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
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
        ((AbstractSellableInventoryItemEntryMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated newSellableInventoryItemEntryMvoStateCreated(Long version, String commandId, String requesterId) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(this.state.getSellableInventoryItemEntryId(), version);
        SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated e = newSellableInventoryItemEntryMvoStateCreated(stateEventId);
        ((AbstractSellableInventoryItemEntryMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched newSellableInventoryItemEntryMvoStateMergePatched(Long version, String commandId, String requesterId) {
        SellableInventoryItemEntryMvoEventId stateEventId = new SellableInventoryItemEntryMvoEventId(this.state.getSellableInventoryItemEntryId(), version);
        SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched e = newSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemEntryMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated newSellableInventoryItemEntryMvoStateCreated(SellableInventoryItemEntryMvoEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryMvoEvent.SimpleSellableInventoryItemEntryMvoStateCreated(stateEventId);
    }

    protected SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched newSellableInventoryItemEntryMvoStateMergePatched(SellableInventoryItemEntryMvoEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryMvoEvent.SimpleSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
    }

    public static class SimpleSellableInventoryItemEntryMvoAggregate extends AbstractSellableInventoryItemEntryMvoAggregate
    {
        public SimpleSellableInventoryItemEntryMvoAggregate(SellableInventoryItemEntryMvoState state) {
            super(state);
        }

    }

}

