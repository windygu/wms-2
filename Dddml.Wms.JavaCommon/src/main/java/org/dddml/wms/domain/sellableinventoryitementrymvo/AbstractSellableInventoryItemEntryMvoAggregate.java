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
        SellableInventoryItemEntryMvoStateEventId stateEventId = new SellableInventoryItemEntryMvoStateEventId(c.getSellableInventoryItemEntryId(), c.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e = newSellableInventoryItemEntryMvoStateCreated(stateEventId);
        e.setQuantitySellable(c.getQuantitySellable());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setSellableInventoryItemQuantitySellable(c.getSellableInventoryItemQuantitySellable());
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
        SellableInventoryItemEntryMvoStateEventId stateEventId = new SellableInventoryItemEntryMvoStateEventId(c.getSellableInventoryItemEntryId(), c.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e = newSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
        e.setQuantitySellable(c.getQuantitySellable());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setSellableInventoryItemQuantitySellable(c.getSellableInventoryItemQuantitySellable());
        e.setSellableInventoryItemCreatedBy(c.getSellableInventoryItemCreatedBy());
        e.setSellableInventoryItemCreatedAt(c.getSellableInventoryItemCreatedAt());
        e.setSellableInventoryItemUpdatedBy(c.getSellableInventoryItemUpdatedBy());
        e.setSellableInventoryItemUpdatedAt(c.getSellableInventoryItemUpdatedAt());
        e.setIsPropertyQuantitySellableRemoved(c.getIsPropertyQuantitySellableRemoved());
        e.setIsPropertySourceEventIdRemoved(c.getIsPropertySourceEventIdRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertySellableInventoryItemQuantitySellableRemoved(c.getIsPropertySellableInventoryItemQuantitySellableRemoved());
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

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated newSellableInventoryItemEntryMvoStateCreated(String commandId, String requesterId) {
        SellableInventoryItemEntryMvoStateEventId stateEventId = new SellableInventoryItemEntryMvoStateEventId(this.state.getSellableInventoryItemEntryId(), this.state.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e = newSellableInventoryItemEntryMvoStateCreated(stateEventId);
        ((AbstractSellableInventoryItemEntryMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched newSellableInventoryItemEntryMvoStateMergePatched(String commandId, String requesterId) {
        SellableInventoryItemEntryMvoStateEventId stateEventId = new SellableInventoryItemEntryMvoStateEventId(this.state.getSellableInventoryItemEntryId(), this.state.getSellableInventoryItemVersion());
        SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e = newSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
        ((AbstractSellableInventoryItemEntryMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated newSellableInventoryItemEntryMvoStateCreated(SellableInventoryItemEntryMvoStateEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryMvoStateEvent.SimpleSellableInventoryItemEntryMvoStateCreated(stateEventId);
    }

    protected SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched newSellableInventoryItemEntryMvoStateMergePatched(SellableInventoryItemEntryMvoStateEventId stateEventId) {
        return new AbstractSellableInventoryItemEntryMvoStateEvent.SimpleSellableInventoryItemEntryMvoStateMergePatched(stateEventId);
    }


    public static class SimpleSellableInventoryItemEntryMvoAggregate extends AbstractSellableInventoryItemEntryMvoAggregate
    {
        public SimpleSellableInventoryItemEntryMvoAggregate(SellableInventoryItemEntryMvoState state) {
            super(state);
        }

    }

}

