package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemRequirementEntryMvoAggregate extends AbstractAggregate implements InventoryItemRequirementEntryMvoAggregate
{
    private InventoryItemRequirementEntryMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryItemRequirementEntryMvoAggregate(InventoryItemRequirementEntryMvoState state)
    {
        this.state = state;
    }

    public InventoryItemRequirementEntryMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo c)
    {
        if (c.getInventoryItemRequirementVersion() == null) { c.setInventoryItemRequirementVersion(InventoryItemRequirementEntryMvoState.VERSION_NULL); }
        InventoryItemRequirementEntryMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo c)
    {
        InventoryItemRequirementEntryMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InventoryItemRequirementEntryMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryItemRequirementEntryMvoEvent map(InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo c) {
        InventoryItemRequirementEntryMvoEventId stateEventId = new InventoryItemRequirementEntryMvoEventId(c.getInventoryItemRequirementEntryId(), c.getInventoryItemRequirementVersion());
        InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateCreated e = newInventoryItemRequirementEntryMvoStateCreated(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setInventoryItemRequirementQuantity(c.getInventoryItemRequirementQuantity());
        e.setInventoryItemRequirementCreatedBy(c.getInventoryItemRequirementCreatedBy());
        e.setInventoryItemRequirementCreatedAt(c.getInventoryItemRequirementCreatedAt());
        e.setInventoryItemRequirementUpdatedBy(c.getInventoryItemRequirementUpdatedBy());
        e.setInventoryItemRequirementUpdatedAt(c.getInventoryItemRequirementUpdatedAt());
        ((AbstractInventoryItemRequirementEntryMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemRequirementEntryMvoEvent map(InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo c) {
        InventoryItemRequirementEntryMvoEventId stateEventId = new InventoryItemRequirementEntryMvoEventId(c.getInventoryItemRequirementEntryId(), c.getInventoryItemRequirementVersion());
        InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateMergePatched e = newInventoryItemRequirementEntryMvoStateMergePatched(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setSourceEventId(c.getSourceEventId());
        e.setVersion(c.getVersion());
        e.setInventoryItemRequirementQuantity(c.getInventoryItemRequirementQuantity());
        e.setInventoryItemRequirementCreatedBy(c.getInventoryItemRequirementCreatedBy());
        e.setInventoryItemRequirementCreatedAt(c.getInventoryItemRequirementCreatedAt());
        e.setInventoryItemRequirementUpdatedBy(c.getInventoryItemRequirementUpdatedBy());
        e.setInventoryItemRequirementUpdatedAt(c.getInventoryItemRequirementUpdatedAt());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertySourceEventIdRemoved(c.getIsPropertySourceEventIdRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyInventoryItemRequirementQuantityRemoved(c.getIsPropertyInventoryItemRequirementQuantityRemoved());
        e.setIsPropertyInventoryItemRequirementCreatedByRemoved(c.getIsPropertyInventoryItemRequirementCreatedByRemoved());
        e.setIsPropertyInventoryItemRequirementCreatedAtRemoved(c.getIsPropertyInventoryItemRequirementCreatedAtRemoved());
        e.setIsPropertyInventoryItemRequirementUpdatedByRemoved(c.getIsPropertyInventoryItemRequirementUpdatedByRemoved());
        e.setIsPropertyInventoryItemRequirementUpdatedAtRemoved(c.getIsPropertyInventoryItemRequirementUpdatedAtRemoved());
        ((AbstractInventoryItemRequirementEntryMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateCreated newInventoryItemRequirementEntryMvoStateCreated(Long version, String commandId, String requesterId) {
        InventoryItemRequirementEntryMvoEventId stateEventId = new InventoryItemRequirementEntryMvoEventId(this.state.getInventoryItemRequirementEntryId(), version);
        InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateCreated e = newInventoryItemRequirementEntryMvoStateCreated(stateEventId);
        ((AbstractInventoryItemRequirementEntryMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateMergePatched newInventoryItemRequirementEntryMvoStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryItemRequirementEntryMvoEventId stateEventId = new InventoryItemRequirementEntryMvoEventId(this.state.getInventoryItemRequirementEntryId(), version);
        InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateMergePatched e = newInventoryItemRequirementEntryMvoStateMergePatched(stateEventId);
        ((AbstractInventoryItemRequirementEntryMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateCreated newInventoryItemRequirementEntryMvoStateCreated(InventoryItemRequirementEntryMvoEventId stateEventId) {
        return new AbstractInventoryItemRequirementEntryMvoEvent.SimpleInventoryItemRequirementEntryMvoStateCreated(stateEventId);
    }

    protected InventoryItemRequirementEntryMvoEvent.InventoryItemRequirementEntryMvoStateMergePatched newInventoryItemRequirementEntryMvoStateMergePatched(InventoryItemRequirementEntryMvoEventId stateEventId) {
        return new AbstractInventoryItemRequirementEntryMvoEvent.SimpleInventoryItemRequirementEntryMvoStateMergePatched(stateEventId);
    }

    public static class SimpleInventoryItemRequirementEntryMvoAggregate extends AbstractInventoryItemRequirementEntryMvoAggregate
    {
        public SimpleInventoryItemRequirementEntryMvoAggregate(InventoryItemRequirementEntryMvoState state) {
            super(state);
        }

    }

}

