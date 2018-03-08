package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetAggregate extends AbstractAggregate implements AttributeSetAggregate
{
    private AttributeSetState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetAggregate(AttributeSetState state)
    {
        this.state = state;
    }

    public AttributeSetState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeSetCommand.CreateAttributeSet c)
    {
        if (c.getVersion() == null) { c.setVersion(AttributeSetState.VERSION_NULL); }
        AttributeSetStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeSetCommand.MergePatchAttributeSet c)
    {
        AttributeSetStateEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeSetCommand.DeleteAttributeSet c)
    {
        AttributeSetStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeSetCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeSetStateEvent map(AttributeSetCommand.CreateAttributeSet c) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(c.getAttributeSetId(), c.getVersion());
        AttributeSetStateEvent.AttributeSetStateCreated e = newAttributeSetStateCreated(stateEventId);
        e.setAttributeSetName(c.getAttributeSetName());
        e.setOrganizationId(c.getOrganizationId());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
        e.setIsInstanceAttributeSet(c.getIsInstanceAttributeSet());
        e.setIsMandatory(c.getIsMandatory());
        e.setActive(c.getActive());
        ((AbstractAttributeSetStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (AttributeUseCommand.CreateAttributeUse innerCommand : c.getAttributeUses())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeUseStateEvent.AttributeUseStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addAttributeUseEvent(innerEvent);
        }

        return e;
    }

    protected AttributeSetStateEvent map(AttributeSetCommand.MergePatchAttributeSet c) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(c.getAttributeSetId(), c.getVersion());
        AttributeSetStateEvent.AttributeSetStateMergePatched e = newAttributeSetStateMergePatched(stateEventId);
        e.setAttributeSetName(c.getAttributeSetName());
        e.setOrganizationId(c.getOrganizationId());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
        e.setIsInstanceAttributeSet(c.getIsInstanceAttributeSet());
        e.setIsMandatory(c.getIsMandatory());
        e.setActive(c.getActive());
        e.setIsPropertyAttributeSetNameRemoved(c.getIsPropertyAttributeSetNameRemoved());
        e.setIsPropertyOrganizationIdRemoved(c.getIsPropertyOrganizationIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyReferenceIdRemoved(c.getIsPropertyReferenceIdRemoved());
        e.setIsPropertyIsInstanceAttributeSetRemoved(c.getIsPropertyIsInstanceAttributeSetRemoved());
        e.setIsPropertyIsMandatoryRemoved(c.getIsPropertyIsMandatoryRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractAttributeSetStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (AttributeUseCommand innerCommand : c.getAttributeUseCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeUseStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addAttributeUseEvent(innerEvent);
        }

        return e;
    }

    protected AttributeSetStateEvent map(AttributeSetCommand.DeleteAttributeSet c) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(c.getAttributeSetId(), c.getVersion());
        AttributeSetStateEvent.AttributeSetStateDeleted e = newAttributeSetStateDeleted(stateEventId);
        ((AbstractAttributeSetStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected AttributeUseStateEvent map(AttributeUseCommand c, AttributeSetCommand outerCommand, long version, AttributeSetState outerState)
    {
        AttributeUseCommand.CreateAttributeUse create = (c.getCommandType().equals(CommandType.CREATE)) ? ((AttributeUseCommand.CreateAttributeUse)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        AttributeUseCommand.MergePatchAttributeUse merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((AttributeUseCommand.MergePatchAttributeUse)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        AttributeUseCommand.RemoveAttributeUse remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((AttributeUseCommand.RemoveAttributeUse)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected AttributeUseStateEvent.AttributeUseStateCreated mapCreate(AttributeUseCommand.CreateAttributeUse c, AttributeSetCommand outerCommand, Long version, AttributeSetState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeUseEventId stateEventId = new AttributeUseEventId(c.getAttributeSetId(), c.getAttributeId(), version);
        AttributeUseStateEvent.AttributeUseStateCreated e = newAttributeUseStateCreated(stateEventId);
        AttributeUseState s = outerState.getAttributeUses().get(c.getAttributeId());

        e.setSequenceNumber(c.getSequenceNumber());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected AttributeUseStateEvent.AttributeUseStateMergePatched mapMergePatch(AttributeUseCommand.MergePatchAttributeUse c, AttributeSetCommand outerCommand, Long version, AttributeSetState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeUseEventId stateEventId = new AttributeUseEventId(c.getAttributeSetId(), c.getAttributeId(), version);
        AttributeUseStateEvent.AttributeUseStateMergePatched e = newAttributeUseStateMergePatched(stateEventId);
        AttributeUseState s = outerState.getAttributeUses().get(c.getAttributeId());

        e.setSequenceNumber(c.getSequenceNumber());
        e.setActive(c.getActive());
        e.setIsPropertySequenceNumberRemoved(c.getIsPropertySequenceNumberRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected AttributeUseStateEvent.AttributeUseStateRemoved mapRemove(AttributeUseCommand.RemoveAttributeUse c, AttributeSetCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeUseEventId stateEventId = new AttributeUseEventId(c.getAttributeSetId(), c.getAttributeId(), version);
        AttributeUseStateEvent.AttributeUseStateRemoved e = newAttributeUseStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(AttributeSetCommand command, AttributeUseCommand innerCommand)
    {
        AbstractAttributeSetCommand properties = command instanceof AbstractAttributeSetCommand ? (AbstractAttributeSetCommand) command : null;
        AbstractAttributeUseCommand innerProperties = innerCommand instanceof AbstractAttributeUseCommand ? (AbstractAttributeUseCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerAttributeSetIdName = "AttributeSetId";
        String outerAttributeSetIdValue = properties.getAttributeSetId();
        String innerAttributeSetIdName = "AttributeSetId";
        String innerAttributeSetIdValue = innerProperties.getAttributeSetId();
        if (innerAttributeSetIdValue == null) {
            innerProperties.setAttributeSetId(outerAttributeSetIdValue);
        }
        else if (innerAttributeSetIdValue != outerAttributeSetIdValue 
            && (innerAttributeSetIdValue == null || innerAttributeSetIdValue != null && !innerAttributeSetIdValue.equals(outerAttributeSetIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerAttributeSetIdName, outerAttributeSetIdValue, innerAttributeSetIdName, innerAttributeSetIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected AttributeSetStateEvent.AttributeSetStateCreated newAttributeSetStateCreated(Long version, String commandId, String requesterId) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(this.state.getAttributeSetId(), version);
        AttributeSetStateEvent.AttributeSetStateCreated e = newAttributeSetStateCreated(stateEventId);
        ((AbstractAttributeSetStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetStateEvent.AttributeSetStateMergePatched newAttributeSetStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(this.state.getAttributeSetId(), version);
        AttributeSetStateEvent.AttributeSetStateMergePatched e = newAttributeSetStateMergePatched(stateEventId);
        ((AbstractAttributeSetStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetStateEvent.AttributeSetStateDeleted newAttributeSetStateDeleted(Long version, String commandId, String requesterId) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(this.state.getAttributeSetId(), version);
        AttributeSetStateEvent.AttributeSetStateDeleted e = newAttributeSetStateDeleted(stateEventId);
        ((AbstractAttributeSetStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetStateEvent.AttributeSetStateCreated newAttributeSetStateCreated(AttributeSetEventId stateEventId) {
        return new AbstractAttributeSetStateEvent.SimpleAttributeSetStateCreated(stateEventId);
    }

    protected AttributeSetStateEvent.AttributeSetStateMergePatched newAttributeSetStateMergePatched(AttributeSetEventId stateEventId) {
        return new AbstractAttributeSetStateEvent.SimpleAttributeSetStateMergePatched(stateEventId);
    }

    protected AttributeSetStateEvent.AttributeSetStateDeleted newAttributeSetStateDeleted(AttributeSetEventId stateEventId)
    {
        return new AbstractAttributeSetStateEvent.SimpleAttributeSetStateDeleted(stateEventId);
    }

    protected AttributeUseStateEvent.AttributeUseStateCreated newAttributeUseStateCreated(AttributeUseEventId stateEventId) {
        return new AbstractAttributeUseStateEvent.SimpleAttributeUseStateCreated(stateEventId);
    }

    protected AttributeUseStateEvent.AttributeUseStateMergePatched newAttributeUseStateMergePatched(AttributeUseEventId stateEventId) {
        return new AbstractAttributeUseStateEvent.SimpleAttributeUseStateMergePatched(stateEventId);
    }

    protected AttributeUseStateEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(AttributeUseEventId stateEventId)
    {
        return new AbstractAttributeUseStateEvent.SimpleAttributeUseStateRemoved(stateEventId);
    }

    public static class SimpleAttributeSetAggregate extends AbstractAttributeSetAggregate
    {
        public SimpleAttributeSetAggregate(AttributeSetState state) {
            super(state);
        }

    }

}

