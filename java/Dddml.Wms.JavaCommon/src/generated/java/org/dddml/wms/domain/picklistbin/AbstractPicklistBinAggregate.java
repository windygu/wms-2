package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistBinAggregate extends AbstractAggregate implements PicklistBinAggregate
{
    private PicklistBinState.MutablePicklistBinState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPicklistBinAggregate(PicklistBinState state)
    {
        this.state = (PicklistBinState.MutablePicklistBinState)state;
    }

    public PicklistBinState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PicklistBinCommand.CreatePicklistBin c)
    {
        if (c.getVersion() == null) { c.setVersion(PicklistBinState.VERSION_NULL); }
        PicklistBinEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistBinCommand.MergePatchPicklistBin c)
    {
        PicklistBinEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistBinCommand.DeletePicklistBin c)
    {
        PicklistBinEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PicklistBinCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PicklistBinEvent map(PicklistBinCommand.CreatePicklistBin c) {
        PicklistBinEventId stateEventId = new PicklistBinEventId(c.getPicklistBinId(), c.getVersion());
        PicklistBinEvent.PicklistBinStateCreated e = newPicklistBinStateCreated(stateEventId);
        e.setPicklistId(c.getPicklistId());
        e.setBinLocationNumber(c.getBinLocationNumber());
        e.setPrimaryOrderId(c.getPrimaryOrderId());
        e.setPrimaryShipGroupSeqId(c.getPrimaryShipGroupSeqId());
        e.setActive(c.getActive());
        ((AbstractPicklistBinEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PicklistItemCommand.CreatePicklistItem innerCommand : c.getCreatePicklistItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PicklistItemEvent.PicklistItemStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addPicklistItemEvent(innerEvent);
        }

        return e;
    }

    protected PicklistBinEvent map(PicklistBinCommand.MergePatchPicklistBin c) {
        PicklistBinEventId stateEventId = new PicklistBinEventId(c.getPicklistBinId(), c.getVersion());
        PicklistBinEvent.PicklistBinStateMergePatched e = newPicklistBinStateMergePatched(stateEventId);
        e.setPicklistId(c.getPicklistId());
        e.setBinLocationNumber(c.getBinLocationNumber());
        e.setPrimaryOrderId(c.getPrimaryOrderId());
        e.setPrimaryShipGroupSeqId(c.getPrimaryShipGroupSeqId());
        e.setActive(c.getActive());
        e.setIsPropertyPicklistIdRemoved(c.getIsPropertyPicklistIdRemoved());
        e.setIsPropertyBinLocationNumberRemoved(c.getIsPropertyBinLocationNumberRemoved());
        e.setIsPropertyPrimaryOrderIdRemoved(c.getIsPropertyPrimaryOrderIdRemoved());
        e.setIsPropertyPrimaryShipGroupSeqIdRemoved(c.getIsPropertyPrimaryShipGroupSeqIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPicklistBinEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PicklistItemCommand innerCommand : c.getPicklistItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PicklistItemEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addPicklistItemEvent(innerEvent);
        }

        return e;
    }

    protected PicklistBinEvent map(PicklistBinCommand.DeletePicklistBin c) {
        PicklistBinEventId stateEventId = new PicklistBinEventId(c.getPicklistBinId(), c.getVersion());
        PicklistBinEvent.PicklistBinStateDeleted e = newPicklistBinStateDeleted(stateEventId);
        ((AbstractPicklistBinEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected PicklistItemEvent map(PicklistItemCommand c, PicklistBinCommand outerCommand, Long version, PicklistBinState outerState)
    {
        PicklistItemCommand.CreatePicklistItem create = (c.getCommandType().equals(CommandType.CREATE)) ? ((PicklistItemCommand.CreatePicklistItem)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        PicklistItemCommand.MergePatchPicklistItem merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((PicklistItemCommand.MergePatchPicklistItem)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        PicklistItemCommand.RemovePicklistItem remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((PicklistItemCommand.RemovePicklistItem)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected PicklistItemEvent.PicklistItemStateCreated mapCreate(PicklistItemCommand.CreatePicklistItem c, PicklistBinCommand outerCommand, Long version, PicklistBinState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistItemEventId stateEventId = new PicklistItemEventId(c.getPicklistBinId(), c.getPicklistItemOrderShipGrpInvId(), version);
        PicklistItemEvent.PicklistItemStateCreated e = newPicklistItemStateCreated(stateEventId);
        PicklistItemState s = outerState.getPicklistItems().get(c.getPicklistItemOrderShipGrpInvId());

        e.setItemStatusId(c.getItemStatusId());
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected PicklistItemEvent.PicklistItemStateMergePatched mapMergePatch(PicklistItemCommand.MergePatchPicklistItem c, PicklistBinCommand outerCommand, Long version, PicklistBinState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistItemEventId stateEventId = new PicklistItemEventId(c.getPicklistBinId(), c.getPicklistItemOrderShipGrpInvId(), version);
        PicklistItemEvent.PicklistItemStateMergePatched e = newPicklistItemStateMergePatched(stateEventId);
        PicklistItemState s = outerState.getPicklistItems().get(c.getPicklistItemOrderShipGrpInvId());

        e.setItemStatusId(c.getItemStatusId());
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        e.setIsPropertyItemStatusIdRemoved(c.getIsPropertyItemStatusIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected PicklistItemEvent.PicklistItemStateRemoved mapRemove(PicklistItemCommand.RemovePicklistItem c, PicklistBinCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistItemEventId stateEventId = new PicklistItemEventId(c.getPicklistBinId(), c.getPicklistItemOrderShipGrpInvId(), version);
        PicklistItemEvent.PicklistItemStateRemoved e = newPicklistItemStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(PicklistBinCommand command, PicklistItemCommand innerCommand)
    {
        AbstractPicklistBinCommand properties = command instanceof AbstractPicklistBinCommand ? (AbstractPicklistBinCommand) command : null;
        AbstractPicklistItemCommand innerProperties = innerCommand instanceof AbstractPicklistItemCommand ? (AbstractPicklistItemCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerPicklistBinIdName = "PicklistBinId";
        String outerPicklistBinIdValue = properties.getPicklistBinId();
        String innerPicklistBinIdName = "PicklistBinId";
        String innerPicklistBinIdValue = innerProperties.getPicklistBinId();
        if (innerPicklistBinIdValue == null) {
            innerProperties.setPicklistBinId(outerPicklistBinIdValue);
        }
        else if (innerPicklistBinIdValue != outerPicklistBinIdValue 
            && (innerPicklistBinIdValue == null || innerPicklistBinIdValue != null && !innerPicklistBinIdValue.equals(outerPicklistBinIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerPicklistBinIdName, outerPicklistBinIdValue, innerPicklistBinIdName, innerPicklistBinIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected PicklistBinEvent.PicklistBinStateCreated newPicklistBinStateCreated(Long version, String commandId, String requesterId) {
        PicklistBinEventId stateEventId = new PicklistBinEventId(this.state.getPicklistBinId(), version);
        PicklistBinEvent.PicklistBinStateCreated e = newPicklistBinStateCreated(stateEventId);
        ((AbstractPicklistBinEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistBinEvent.PicklistBinStateMergePatched newPicklistBinStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistBinEventId stateEventId = new PicklistBinEventId(this.state.getPicklistBinId(), version);
        PicklistBinEvent.PicklistBinStateMergePatched e = newPicklistBinStateMergePatched(stateEventId);
        ((AbstractPicklistBinEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistBinEvent.PicklistBinStateDeleted newPicklistBinStateDeleted(Long version, String commandId, String requesterId) {
        PicklistBinEventId stateEventId = new PicklistBinEventId(this.state.getPicklistBinId(), version);
        PicklistBinEvent.PicklistBinStateDeleted e = newPicklistBinStateDeleted(stateEventId);
        ((AbstractPicklistBinEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistBinEvent.PicklistBinStateCreated newPicklistBinStateCreated(PicklistBinEventId stateEventId) {
        return new AbstractPicklistBinEvent.SimplePicklistBinStateCreated(stateEventId);
    }

    protected PicklistBinEvent.PicklistBinStateMergePatched newPicklistBinStateMergePatched(PicklistBinEventId stateEventId) {
        return new AbstractPicklistBinEvent.SimplePicklistBinStateMergePatched(stateEventId);
    }

    protected PicklistBinEvent.PicklistBinStateDeleted newPicklistBinStateDeleted(PicklistBinEventId stateEventId)
    {
        return new AbstractPicklistBinEvent.SimplePicklistBinStateDeleted(stateEventId);
    }

    protected PicklistItemEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemEventId stateEventId) {
        return new AbstractPicklistItemEvent.SimplePicklistItemStateCreated(stateEventId);
    }

    protected PicklistItemEvent.PicklistItemStateMergePatched newPicklistItemStateMergePatched(PicklistItemEventId stateEventId) {
        return new AbstractPicklistItemEvent.SimplePicklistItemStateMergePatched(stateEventId);
    }

    protected PicklistItemEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemEventId stateEventId)
    {
        return new AbstractPicklistItemEvent.SimplePicklistItemStateRemoved(stateEventId);
    }

    public static class SimplePicklistBinAggregate extends AbstractPicklistBinAggregate
    {
        public SimplePicklistBinAggregate(PicklistBinState state) {
            super(state);
        }

    }

}

