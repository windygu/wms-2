package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemRequirementAggregate extends AbstractAggregate implements InventoryItemRequirementAggregate
{
    private InventoryItemRequirementState.MutableInventoryItemRequirementState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInventoryItemRequirementAggregate(InventoryItemRequirementState state)
    {
        this.state = (InventoryItemRequirementState.MutableInventoryItemRequirementState)state;
    }

    public InventoryItemRequirementState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InventoryItemRequirementCommand.CreateInventoryItemRequirement c)
    {
        if (c.getVersion() == null) { c.setVersion(InventoryItemRequirementState.VERSION_NULL); }
        InventoryItemRequirementEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InventoryItemRequirementCommand.MergePatchInventoryItemRequirement c)
    {
        InventoryItemRequirementEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InventoryItemRequirementCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InventoryItemRequirementEvent map(InventoryItemRequirementCommand.CreateInventoryItemRequirement c) {
        InventoryItemRequirementEventId stateEventId = new InventoryItemRequirementEventId(c.getInventoryItemRequirementId(), c.getVersion());
        InventoryItemRequirementEvent.InventoryItemRequirementStateCreated e = newInventoryItemRequirementStateCreated(stateEventId);
        ((AbstractInventoryItemRequirementEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal quantity = BigDecimal.ZERO;
        Long version = c.getVersion();
        for (InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry innerCommand : c.getCreateInventoryItemRequirementEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addInventoryItemRequirementEntryEvent(innerEvent);
            quantity = quantity.add(innerEvent.getQuantity() != null ? innerEvent.getQuantity() : BigDecimal.ZERO);
        }

        e.setQuantity(quantity);
        return e;
    }

    protected InventoryItemRequirementEvent map(InventoryItemRequirementCommand.MergePatchInventoryItemRequirement c) {
        InventoryItemRequirementEventId stateEventId = new InventoryItemRequirementEventId(c.getInventoryItemRequirementId(), c.getVersion());
        InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched e = newInventoryItemRequirementStateMergePatched(stateEventId);
        ((AbstractInventoryItemRequirementEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        BigDecimal quantity = this.state.getQuantity();
        Long version = c.getVersion();
        for (InventoryItemRequirementEntryCommand innerCommand : c.getInventoryItemRequirementEntryCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            InventoryItemRequirementEntryEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addInventoryItemRequirementEntryEvent(innerEvent);
            // ////////////////
            if (!(innerEvent instanceof InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated)) { continue; }
            InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated entryCreated = (InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated)innerEvent;
            quantity = quantity.add(entryCreated.getQuantity() != null ? entryCreated.getQuantity() : BigDecimal.ZERO);
            // ////////////////
        }

        e.setQuantity(quantity);
        return e;
    }


    protected InventoryItemRequirementEntryEvent map(InventoryItemRequirementEntryCommand c, InventoryItemRequirementCommand outerCommand, Long version, InventoryItemRequirementState outerState)
    {
        InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry create = (c.getCommandType().equals(CommandType.CREATE)) ? ((InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated mapCreate(InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry c, InventoryItemRequirementCommand outerCommand, Long version, InventoryItemRequirementState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        InventoryItemRequirementEntryEventId stateEventId = new InventoryItemRequirementEntryEventId(c.getInventoryItemRequirementId(), c.getEntrySeqId(), version);
        InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e = newInventoryItemRequirementEntryStateCreated(stateEventId);
        InventoryItemRequirementEntryState s = outerState.getEntries().get(c.getEntrySeqId());

        e.setQuantity(c.getQuantity());
        e.setSourceEventId(c.getSourceEventId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected void throwOnInconsistentCommands(InventoryItemRequirementCommand command, InventoryItemRequirementEntryCommand innerCommand)
    {
        AbstractInventoryItemRequirementCommand properties = command instanceof AbstractInventoryItemRequirementCommand ? (AbstractInventoryItemRequirementCommand) command : null;
        AbstractInventoryItemRequirementEntryCommand innerProperties = innerCommand instanceof AbstractInventoryItemRequirementEntryCommand ? (AbstractInventoryItemRequirementEntryCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerInventoryItemRequirementIdName = "InventoryItemRequirementId";
        InventoryItemId outerInventoryItemRequirementIdValue = properties.getInventoryItemRequirementId();
        String innerInventoryItemRequirementIdName = "InventoryItemRequirementId";
        InventoryItemId innerInventoryItemRequirementIdValue = innerProperties.getInventoryItemRequirementId();
        if (innerInventoryItemRequirementIdValue == null) {
            innerProperties.setInventoryItemRequirementId(outerInventoryItemRequirementIdValue);
        }
        else if (innerInventoryItemRequirementIdValue != outerInventoryItemRequirementIdValue 
            && (innerInventoryItemRequirementIdValue == null || innerInventoryItemRequirementIdValue != null && !innerInventoryItemRequirementIdValue.equals(outerInventoryItemRequirementIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerInventoryItemRequirementIdName, outerInventoryItemRequirementIdValue, innerInventoryItemRequirementIdName, innerInventoryItemRequirementIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected InventoryItemRequirementEvent.InventoryItemRequirementStateCreated newInventoryItemRequirementStateCreated(Long version, String commandId, String requesterId) {
        InventoryItemRequirementEventId stateEventId = new InventoryItemRequirementEventId(this.state.getInventoryItemRequirementId(), version);
        InventoryItemRequirementEvent.InventoryItemRequirementStateCreated e = newInventoryItemRequirementStateCreated(stateEventId);
        ((AbstractInventoryItemRequirementEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched newInventoryItemRequirementStateMergePatched(Long version, String commandId, String requesterId) {
        InventoryItemRequirementEventId stateEventId = new InventoryItemRequirementEventId(this.state.getInventoryItemRequirementId(), version);
        InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched e = newInventoryItemRequirementStateMergePatched(stateEventId);
        ((AbstractInventoryItemRequirementEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InventoryItemRequirementEvent.InventoryItemRequirementStateCreated newInventoryItemRequirementStateCreated(InventoryItemRequirementEventId stateEventId) {
        return new AbstractInventoryItemRequirementEvent.SimpleInventoryItemRequirementStateCreated(stateEventId);
    }

    protected InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched newInventoryItemRequirementStateMergePatched(InventoryItemRequirementEventId stateEventId) {
        return new AbstractInventoryItemRequirementEvent.SimpleInventoryItemRequirementStateMergePatched(stateEventId);
    }

    protected InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated newInventoryItemRequirementEntryStateCreated(InventoryItemRequirementEntryEventId stateEventId) {
        return new AbstractInventoryItemRequirementEntryEvent.SimpleInventoryItemRequirementEntryStateCreated(stateEventId);
    }

    public static class SimpleInventoryItemRequirementAggregate extends AbstractInventoryItemRequirementAggregate
    {
        public SimpleInventoryItemRequirementAggregate(InventoryItemRequirementState state) {
            super(state);
        }

    }

}

