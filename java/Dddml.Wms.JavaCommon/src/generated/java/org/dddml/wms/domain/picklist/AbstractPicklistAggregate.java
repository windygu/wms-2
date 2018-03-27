package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistAggregate extends AbstractAggregate implements PicklistAggregate
{
    private PicklistState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPicklistAggregate(PicklistState state)
    {
        this.state = state;
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
        PicklistStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistCommand.MergePatchPicklist c)
    {
        PicklistStateEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistCommand.DeletePicklist c)
    {
        PicklistStateEvent e = map(c);
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

    protected PicklistStateEvent map(PicklistCommand.CreatePicklist c) {
        PicklistEventId stateEventId = new PicklistEventId(c.getPicklistId(), c.getVersion());
        PicklistStateEvent.PicklistStateCreated e = newPicklistStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setFacilityId(c.getFacilityId());
        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setStatusId(c.getStatusId());
        e.setPicklistDate(c.getPicklistDate());
        e.setPickwaveId(c.getPickwaveId());
        e.setActive(c.getActive());
        ((AbstractPicklistStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PicklistRoleCommand.CreatePicklistRole innerCommand : c.getPicklistRoles())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PicklistRoleStateEvent.PicklistRoleStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addPicklistRoleEvent(innerEvent);
        }

        return e;
    }

    protected PicklistStateEvent map(PicklistCommand.MergePatchPicklist c) {
        PicklistEventId stateEventId = new PicklistEventId(c.getPicklistId(), c.getVersion());
        PicklistStateEvent.PicklistStateMergePatched e = newPicklistStateMergePatched(stateEventId);
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
        ((AbstractPicklistStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (PicklistRoleCommand innerCommand : c.getPicklistRoleCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            PicklistRoleStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addPicklistRoleEvent(innerEvent);
        }

        return e;
    }

    protected PicklistStateEvent map(PicklistCommand.DeletePicklist c) {
        PicklistEventId stateEventId = new PicklistEventId(c.getPicklistId(), c.getVersion());
        PicklistStateEvent.PicklistStateDeleted e = newPicklistStateDeleted(stateEventId);
        ((AbstractPicklistStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected PicklistRoleStateEvent map(PicklistRoleCommand c, PicklistCommand outerCommand, long version, PicklistState outerState)
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

    protected PicklistRoleStateEvent.PicklistRoleStateCreated mapCreate(PicklistRoleCommand.CreatePicklistRole c, PicklistCommand outerCommand, Long version, PicklistState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistRoleEventId stateEventId = new PicklistRoleEventId(c.getPicklistId(), c.getPartyRoleId(), version);
        PicklistRoleStateEvent.PicklistRoleStateCreated e = newPicklistRoleStateCreated(stateEventId);
        PicklistRoleState s = outerState.getPicklistRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected PicklistRoleStateEvent.PicklistRoleStateMergePatched mapMergePatch(PicklistRoleCommand.MergePatchPicklistRole c, PicklistCommand outerCommand, Long version, PicklistState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistRoleEventId stateEventId = new PicklistRoleEventId(c.getPicklistId(), c.getPartyRoleId(), version);
        PicklistRoleStateEvent.PicklistRoleStateMergePatched e = newPicklistRoleStateMergePatched(stateEventId);
        PicklistRoleState s = outerState.getPicklistRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected PicklistRoleStateEvent.PicklistRoleStateRemoved mapRemove(PicklistRoleCommand.RemovePicklistRole c, PicklistCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        PicklistRoleEventId stateEventId = new PicklistRoleEventId(c.getPicklistId(), c.getPartyRoleId(), version);
        PicklistRoleStateEvent.PicklistRoleStateRemoved e = newPicklistRoleStateRemoved(stateEventId);

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

    protected PicklistStateEvent.PicklistStateCreated newPicklistStateCreated(Long version, String commandId, String requesterId) {
        PicklistEventId stateEventId = new PicklistEventId(this.state.getPicklistId(), version);
        PicklistStateEvent.PicklistStateCreated e = newPicklistStateCreated(stateEventId);
        ((AbstractPicklistStateEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistStateEvent.PicklistStateMergePatched newPicklistStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistEventId stateEventId = new PicklistEventId(this.state.getPicklistId(), version);
        PicklistStateEvent.PicklistStateMergePatched e = newPicklistStateMergePatched(stateEventId);
        ((AbstractPicklistStateEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistStateEvent.PicklistStateDeleted newPicklistStateDeleted(Long version, String commandId, String requesterId) {
        PicklistEventId stateEventId = new PicklistEventId(this.state.getPicklistId(), version);
        PicklistStateEvent.PicklistStateDeleted e = newPicklistStateDeleted(stateEventId);
        ((AbstractPicklistStateEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistStateEvent.PicklistStateCreated newPicklistStateCreated(PicklistEventId stateEventId) {
        return new AbstractPicklistStateEvent.SimplePicklistStateCreated(stateEventId);
    }

    protected PicklistStateEvent.PicklistStateMergePatched newPicklistStateMergePatched(PicklistEventId stateEventId) {
        return new AbstractPicklistStateEvent.SimplePicklistStateMergePatched(stateEventId);
    }

    protected PicklistStateEvent.PicklistStateDeleted newPicklistStateDeleted(PicklistEventId stateEventId)
    {
        return new AbstractPicklistStateEvent.SimplePicklistStateDeleted(stateEventId);
    }

    protected PicklistRoleStateEvent.PicklistRoleStateCreated newPicklistRoleStateCreated(PicklistRoleEventId stateEventId) {
        return new AbstractPicklistRoleStateEvent.SimplePicklistRoleStateCreated(stateEventId);
    }

    protected PicklistRoleStateEvent.PicklistRoleStateMergePatched newPicklistRoleStateMergePatched(PicklistRoleEventId stateEventId) {
        return new AbstractPicklistRoleStateEvent.SimplePicklistRoleStateMergePatched(stateEventId);
    }

    protected PicklistRoleStateEvent.PicklistRoleStateRemoved newPicklistRoleStateRemoved(PicklistRoleEventId stateEventId)
    {
        return new AbstractPicklistRoleStateEvent.SimplePicklistRoleStateRemoved(stateEventId);
    }

    public static class SimplePicklistAggregate extends AbstractPicklistAggregate
    {
        public SimplePicklistAggregate(PicklistState state) {
            super(state);
        }

    }

}

