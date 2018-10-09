package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistAggregate extends AbstractAggregate implements PicklistAggregate
{
    private PicklistState.MutablePicklistState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPicklistAggregate(PicklistState state)
    {
        this.state = (PicklistState.MutablePicklistState)state;
    }

    public PicklistState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PicklistCommand.CreatePicklist c)
    {
        if (c.getVersion() == null) { c.setVersion(PicklistState.VERSION_NULL); }
        PicklistEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistCommand.MergePatchPicklist c)
    {
        PicklistEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistCommand.DeletePicklist c)
    {
        PicklistEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PicklistCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PicklistEvent map(PicklistCommand.CreatePicklist c) {
        PicklistEventId stateEventId = new PicklistEventId(c.getPicklistId(), c.getVersion());
        PicklistEvent.PicklistStateCreated e = newPicklistStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setFacilityId(c.getFacilityId());
        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setStatusId(c.getStatusId());
        e.setPicklistDate(c.getPicklistDate());
        e.setPickwaveId(c.getPickwaveId());
        e.setActive(c.getActive());
        ((AbstractPicklistEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PicklistRoleCommand.CreatePicklistRole innerCommand : c.getCreatePicklistRoleCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PicklistRoleEvent.PicklistRoleStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addPicklistRoleEvent(innerEvent);
        }

        return e;
    }

    protected PicklistEvent map(PicklistCommand.MergePatchPicklist c) {
        PicklistEventId stateEventId = new PicklistEventId(c.getPicklistId(), c.getVersion());
        PicklistEvent.PicklistStateMergePatched e = newPicklistStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setFacilityId(c.getFacilityId());
        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setStatusId(c.getStatusId());
        e.setPicklistDate(c.getPicklistDate());
        e.setPickwaveId(c.getPickwaveId());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyFacilityIdRemoved(c.getIsPropertyFacilityIdRemoved());
        e.setIsPropertyShipmentMethodTypeIdRemoved(c.getIsPropertyShipmentMethodTypeIdRemoved());
        e.setIsPropertyStatusIdRemoved(c.getIsPropertyStatusIdRemoved());
        e.setIsPropertyPicklistDateRemoved(c.getIsPropertyPicklistDateRemoved());
        e.setIsPropertyPickwaveIdRemoved(c.getIsPropertyPickwaveIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPicklistEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PicklistRoleCommand innerCommand : c.getPicklistRoleCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PicklistRoleEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addPicklistRoleEvent(innerEvent);
        }

        return e;
    }

    protected PicklistEvent map(PicklistCommand.DeletePicklist c) {
        PicklistEventId stateEventId = new PicklistEventId(c.getPicklistId(), c.getVersion());
        PicklistEvent.PicklistStateDeleted e = newPicklistStateDeleted(stateEventId);
        ((AbstractPicklistEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected PicklistRoleEvent map(PicklistRoleCommand c, PicklistCommand outerCommand, Long version, PicklistState outerState)
    {
        PicklistRoleCommand.CreatePicklistRole create = (c.getCommandType().equals(CommandType.CREATE)) ? ((PicklistRoleCommand.CreatePicklistRole)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        PicklistRoleCommand.MergePatchPicklistRole merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((PicklistRoleCommand.MergePatchPicklistRole)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        PicklistRoleCommand.RemovePicklistRole remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((PicklistRoleCommand.RemovePicklistRole)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected PicklistRoleEvent.PicklistRoleStateCreated mapCreate(PicklistRoleCommand.CreatePicklistRole c, PicklistCommand outerCommand, Long version, PicklistState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistRoleEventId stateEventId = new PicklistRoleEventId(c.getPicklistId(), c.getPartyRoleId(), version);
        PicklistRoleEvent.PicklistRoleStateCreated e = newPicklistRoleStateCreated(stateEventId);
        PicklistRoleState s = outerState.getPicklistRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected PicklistRoleEvent.PicklistRoleStateMergePatched mapMergePatch(PicklistRoleCommand.MergePatchPicklistRole c, PicklistCommand outerCommand, Long version, PicklistState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistRoleEventId stateEventId = new PicklistRoleEventId(c.getPicklistId(), c.getPartyRoleId(), version);
        PicklistRoleEvent.PicklistRoleStateMergePatched e = newPicklistRoleStateMergePatched(stateEventId);
        PicklistRoleState s = outerState.getPicklistRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected PicklistRoleEvent.PicklistRoleStateRemoved mapRemove(PicklistRoleCommand.RemovePicklistRole c, PicklistCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistRoleEventId stateEventId = new PicklistRoleEventId(c.getPicklistId(), c.getPartyRoleId(), version);
        PicklistRoleEvent.PicklistRoleStateRemoved e = newPicklistRoleStateRemoved(stateEventId);

        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(PicklistCommand command, PicklistRoleCommand innerCommand)
    {
        AbstractPicklistCommand properties = command instanceof AbstractPicklistCommand ? (AbstractPicklistCommand) command : null;
        AbstractPicklistRoleCommand innerProperties = innerCommand instanceof AbstractPicklistRoleCommand ? (AbstractPicklistRoleCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerPicklistIdName = "PicklistId";
        String outerPicklistIdValue = properties.getPicklistId();
        String innerPicklistIdName = "PicklistId";
        String innerPicklistIdValue = innerProperties.getPicklistId();
        if (innerPicklistIdValue == null) {
            innerProperties.setPicklistId(outerPicklistIdValue);
        }
        else if (innerPicklistIdValue != outerPicklistIdValue 
            && (innerPicklistIdValue == null || innerPicklistIdValue != null && !innerPicklistIdValue.equals(outerPicklistIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerPicklistIdName, outerPicklistIdValue, innerPicklistIdName, innerPicklistIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected PicklistEvent.PicklistStateCreated newPicklistStateCreated(Long version, String commandId, String requesterId) {
        PicklistEventId stateEventId = new PicklistEventId(this.state.getPicklistId(), version);
        PicklistEvent.PicklistStateCreated e = newPicklistStateCreated(stateEventId);
        ((AbstractPicklistEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistEvent.PicklistStateMergePatched newPicklistStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistEventId stateEventId = new PicklistEventId(this.state.getPicklistId(), version);
        PicklistEvent.PicklistStateMergePatched e = newPicklistStateMergePatched(stateEventId);
        ((AbstractPicklistEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistEvent.PicklistStateDeleted newPicklistStateDeleted(Long version, String commandId, String requesterId) {
        PicklistEventId stateEventId = new PicklistEventId(this.state.getPicklistId(), version);
        PicklistEvent.PicklistStateDeleted e = newPicklistStateDeleted(stateEventId);
        ((AbstractPicklistEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistEvent.PicklistStateCreated newPicklistStateCreated(PicklistEventId stateEventId) {
        return new AbstractPicklistEvent.SimplePicklistStateCreated(stateEventId);
    }

    protected PicklistEvent.PicklistStateMergePatched newPicklistStateMergePatched(PicklistEventId stateEventId) {
        return new AbstractPicklistEvent.SimplePicklistStateMergePatched(stateEventId);
    }

    protected PicklistEvent.PicklistStateDeleted newPicklistStateDeleted(PicklistEventId stateEventId)
    {
        return new AbstractPicklistEvent.SimplePicklistStateDeleted(stateEventId);
    }

    protected PicklistRoleEvent.PicklistRoleStateCreated newPicklistRoleStateCreated(PicklistRoleEventId stateEventId) {
        return new AbstractPicklistRoleEvent.SimplePicklistRoleStateCreated(stateEventId);
    }

    protected PicklistRoleEvent.PicklistRoleStateMergePatched newPicklistRoleStateMergePatched(PicklistRoleEventId stateEventId) {
        return new AbstractPicklistRoleEvent.SimplePicklistRoleStateMergePatched(stateEventId);
    }

    protected PicklistRoleEvent.PicklistRoleStateRemoved newPicklistRoleStateRemoved(PicklistRoleEventId stateEventId)
    {
        return new AbstractPicklistRoleEvent.SimplePicklistRoleStateRemoved(stateEventId);
    }

    public static class SimplePicklistAggregate extends AbstractPicklistAggregate
    {
        public SimplePicklistAggregate(PicklistState state) {
            super(state);
        }

    }

}

