package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetAggregate extends AbstractAggregate implements AttributeSetAggregate
{
    private AttributeSetState.MutableAttributeSetState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetAggregate(AttributeSetState state)
    {
        this.state = (AttributeSetState.MutableAttributeSetState)state;
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
        AttributeSetEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeSetCommand.MergePatchAttributeSet c)
    {
        AttributeSetEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeSetCommand.DeleteAttributeSet c)
    {
        AttributeSetEvent e = map(c);
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

    protected AttributeSetEvent map(AttributeSetCommand.CreateAttributeSet c) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(c.getAttributeSetId(), c.getVersion());
        AttributeSetEvent.AttributeSetStateCreated e = newAttributeSetStateCreated(stateEventId);
        e.setAttributeSetName(c.getAttributeSetName());
        e.setOrganizationId(c.getOrganizationId());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
        e.setIsInstanceAttributeSet(c.getIsInstanceAttributeSet());
        e.setIsMandatory(c.getIsMandatory());
        e.setActive(c.getActive());
        ((AbstractAttributeSetEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (AttributeUseCommand.CreateAttributeUse innerCommand : c.getCreateAttributeUseCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeUseEvent.AttributeUseStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addAttributeUseEvent(innerEvent);
        }

        return e;
    }

    protected AttributeSetEvent map(AttributeSetCommand.MergePatchAttributeSet c) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(c.getAttributeSetId(), c.getVersion());
        AttributeSetEvent.AttributeSetStateMergePatched e = newAttributeSetStateMergePatched(stateEventId);
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
        ((AbstractAttributeSetEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (AttributeUseCommand innerCommand : c.getAttributeUseCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeUseEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addAttributeUseEvent(innerEvent);
        }

        return e;
    }

    protected AttributeSetEvent map(AttributeSetCommand.DeleteAttributeSet c) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(c.getAttributeSetId(), c.getVersion());
        AttributeSetEvent.AttributeSetStateDeleted e = newAttributeSetStateDeleted(stateEventId);
        ((AbstractAttributeSetEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected AttributeUseEvent map(AttributeUseCommand c, AttributeSetCommand outerCommand, Long version, AttributeSetState outerState)
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

    protected AttributeUseEvent.AttributeUseStateCreated mapCreate(AttributeUseCommand.CreateAttributeUse c, AttributeSetCommand outerCommand, Long version, AttributeSetState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeUseEventId stateEventId = new AttributeUseEventId(c.getAttributeSetId(), c.getAttributeId(), version);
        AttributeUseEvent.AttributeUseStateCreated e = newAttributeUseStateCreated(stateEventId);
        AttributeUseState s = outerState.getAttributeUses().get(c.getAttributeId());

        e.setSequenceNumber(c.getSequenceNumber());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected AttributeUseEvent.AttributeUseStateMergePatched mapMergePatch(AttributeUseCommand.MergePatchAttributeUse c, AttributeSetCommand outerCommand, Long version, AttributeSetState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeUseEventId stateEventId = new AttributeUseEventId(c.getAttributeSetId(), c.getAttributeId(), version);
        AttributeUseEvent.AttributeUseStateMergePatched e = newAttributeUseStateMergePatched(stateEventId);
        AttributeUseState s = outerState.getAttributeUses().get(c.getAttributeId());

        e.setSequenceNumber(c.getSequenceNumber());
        e.setActive(c.getActive());
        e.setIsPropertySequenceNumberRemoved(c.getIsPropertySequenceNumberRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected AttributeUseEvent.AttributeUseStateRemoved mapRemove(AttributeUseCommand.RemoveAttributeUse c, AttributeSetCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeUseEventId stateEventId = new AttributeUseEventId(c.getAttributeSetId(), c.getAttributeId(), version);
        AttributeUseEvent.AttributeUseStateRemoved e = newAttributeUseStateRemoved(stateEventId);

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

    protected AttributeSetEvent.AttributeSetStateCreated newAttributeSetStateCreated(Long version, String commandId, String requesterId) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(this.state.getAttributeSetId(), version);
        AttributeSetEvent.AttributeSetStateCreated e = newAttributeSetStateCreated(stateEventId);
        ((AbstractAttributeSetEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetEvent.AttributeSetStateMergePatched newAttributeSetStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(this.state.getAttributeSetId(), version);
        AttributeSetEvent.AttributeSetStateMergePatched e = newAttributeSetStateMergePatched(stateEventId);
        ((AbstractAttributeSetEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetEvent.AttributeSetStateDeleted newAttributeSetStateDeleted(Long version, String commandId, String requesterId) {
        AttributeSetEventId stateEventId = new AttributeSetEventId(this.state.getAttributeSetId(), version);
        AttributeSetEvent.AttributeSetStateDeleted e = newAttributeSetStateDeleted(stateEventId);
        ((AbstractAttributeSetEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetEvent.AttributeSetStateCreated newAttributeSetStateCreated(AttributeSetEventId stateEventId) {
        return new AbstractAttributeSetEvent.SimpleAttributeSetStateCreated(stateEventId);
    }

    protected AttributeSetEvent.AttributeSetStateMergePatched newAttributeSetStateMergePatched(AttributeSetEventId stateEventId) {
        return new AbstractAttributeSetEvent.SimpleAttributeSetStateMergePatched(stateEventId);
    }

    protected AttributeSetEvent.AttributeSetStateDeleted newAttributeSetStateDeleted(AttributeSetEventId stateEventId)
    {
        return new AbstractAttributeSetEvent.SimpleAttributeSetStateDeleted(stateEventId);
    }

    protected AttributeUseEvent.AttributeUseStateCreated newAttributeUseStateCreated(AttributeUseEventId stateEventId) {
        return new AbstractAttributeUseEvent.SimpleAttributeUseStateCreated(stateEventId);
    }

    protected AttributeUseEvent.AttributeUseStateMergePatched newAttributeUseStateMergePatched(AttributeUseEventId stateEventId) {
        return new AbstractAttributeUseEvent.SimpleAttributeUseStateMergePatched(stateEventId);
    }

    protected AttributeUseEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(AttributeUseEventId stateEventId)
    {
        return new AbstractAttributeUseEvent.SimpleAttributeUseStateRemoved(stateEventId);
    }

    public static class SimpleAttributeSetAggregate extends AbstractAttributeSetAggregate
    {
        public SimpleAttributeSetAggregate(AttributeSetState state) {
            super(state);
        }

    }

}

