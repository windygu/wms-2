package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeAggregate extends AbstractAggregate implements AttributeAggregate
{
    private AttributeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeAggregate(AttributeState state)
    {
        this.state = state;
    }

    public AttributeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeCommand.CreateAttribute c)
    {
        if (c.getVersion() == null) { c.setVersion(AttributeState.VERSION_NULL); }
        AttributeEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeCommand.MergePatchAttribute c)
    {
        AttributeEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeCommand.DeleteAttribute c)
    {
        AttributeEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeEvent map(AttributeCommand.CreateAttribute c) {
        AttributeEventId stateEventId = new AttributeEventId(c.getAttributeId(), c.getVersion());
        AttributeEvent.AttributeStateCreated e = newAttributeStateCreated(stateEventId);
        e.setAttributeName(c.getAttributeName());
        e.setOrganizationId(c.getOrganizationId());
        e.setDescription(c.getDescription());
        e.setIsMandatory(c.getIsMandatory());
        e.setAttributeValueType(c.getAttributeValueType());
        e.setAttributeValueLength(c.getAttributeValueLength());
        e.setIsList(c.getIsList());
        e.setFieldName(c.getFieldName());
        e.setReferenceId(c.getReferenceId());
        e.setActive(c.getActive());
        ((AbstractAttributeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (AttributeValueCommand.CreateAttributeValue innerCommand : c.getAttributeValues())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeValueEvent.AttributeValueStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addAttributeValueEvent(innerEvent);
        }

        for (AttributeAliasCommand.CreateAttributeAlias innerCommand : c.getAliases())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeAliasEvent.AttributeAliasStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addAttributeAliasEvent(innerEvent);
        }

        return e;
    }

    protected AttributeEvent map(AttributeCommand.MergePatchAttribute c) {
        AttributeEventId stateEventId = new AttributeEventId(c.getAttributeId(), c.getVersion());
        AttributeEvent.AttributeStateMergePatched e = newAttributeStateMergePatched(stateEventId);
        e.setAttributeName(c.getAttributeName());
        e.setOrganizationId(c.getOrganizationId());
        e.setDescription(c.getDescription());
        e.setIsMandatory(c.getIsMandatory());
        e.setAttributeValueType(c.getAttributeValueType());
        e.setAttributeValueLength(c.getAttributeValueLength());
        e.setIsList(c.getIsList());
        e.setFieldName(c.getFieldName());
        e.setReferenceId(c.getReferenceId());
        e.setActive(c.getActive());
        e.setIsPropertyAttributeNameRemoved(c.getIsPropertyAttributeNameRemoved());
        e.setIsPropertyOrganizationIdRemoved(c.getIsPropertyOrganizationIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyIsMandatoryRemoved(c.getIsPropertyIsMandatoryRemoved());
        e.setIsPropertyAttributeValueTypeRemoved(c.getIsPropertyAttributeValueTypeRemoved());
        e.setIsPropertyAttributeValueLengthRemoved(c.getIsPropertyAttributeValueLengthRemoved());
        e.setIsPropertyIsListRemoved(c.getIsPropertyIsListRemoved());
        e.setIsPropertyFieldNameRemoved(c.getIsPropertyFieldNameRemoved());
        e.setIsPropertyReferenceIdRemoved(c.getIsPropertyReferenceIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractAttributeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (AttributeValueCommand innerCommand : c.getAttributeValueCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeValueEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addAttributeValueEvent(innerEvent);
        }

        for (AttributeAliasCommand innerCommand : c.getAttributeAliasCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            AttributeAliasEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addAttributeAliasEvent(innerEvent);
        }

        return e;
    }

    protected AttributeEvent map(AttributeCommand.DeleteAttribute c) {
        AttributeEventId stateEventId = new AttributeEventId(c.getAttributeId(), c.getVersion());
        AttributeEvent.AttributeStateDeleted e = newAttributeStateDeleted(stateEventId);
        ((AbstractAttributeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected AttributeValueEvent map(AttributeValueCommand c, AttributeCommand outerCommand, Long version, AttributeState outerState)
    {
        AttributeValueCommand.CreateAttributeValue create = (c.getCommandType().equals(CommandType.CREATE)) ? ((AttributeValueCommand.CreateAttributeValue)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        AttributeValueCommand.MergePatchAttributeValue merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((AttributeValueCommand.MergePatchAttributeValue)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        AttributeValueCommand.RemoveAttributeValue remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((AttributeValueCommand.RemoveAttributeValue)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected AttributeValueEvent.AttributeValueStateCreated mapCreate(AttributeValueCommand.CreateAttributeValue c, AttributeCommand outerCommand, Long version, AttributeState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeValueEventId stateEventId = new AttributeValueEventId(c.getAttributeId(), c.getValue(), version);
        AttributeValueEvent.AttributeValueStateCreated e = newAttributeValueStateCreated(stateEventId);
        AttributeValueState s = outerState.getAttributeValues().get(c.getValue());

        e.setAttributeValueName(c.getAttributeValueName());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected AttributeValueEvent.AttributeValueStateMergePatched mapMergePatch(AttributeValueCommand.MergePatchAttributeValue c, AttributeCommand outerCommand, Long version, AttributeState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeValueEventId stateEventId = new AttributeValueEventId(c.getAttributeId(), c.getValue(), version);
        AttributeValueEvent.AttributeValueStateMergePatched e = newAttributeValueStateMergePatched(stateEventId);
        AttributeValueState s = outerState.getAttributeValues().get(c.getValue());

        e.setAttributeValueName(c.getAttributeValueName());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
        e.setActive(c.getActive());
        e.setIsPropertyAttributeValueNameRemoved(c.getIsPropertyAttributeValueNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyReferenceIdRemoved(c.getIsPropertyReferenceIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected AttributeValueEvent.AttributeValueStateRemoved mapRemove(AttributeValueCommand.RemoveAttributeValue c, AttributeCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeValueEventId stateEventId = new AttributeValueEventId(c.getAttributeId(), c.getValue(), version);
        AttributeValueEvent.AttributeValueStateRemoved e = newAttributeValueStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


    protected AttributeAliasEvent map(AttributeAliasCommand c, AttributeCommand outerCommand, Long version, AttributeState outerState)
    {
        AttributeAliasCommand.CreateAttributeAlias create = (c.getCommandType().equals(CommandType.CREATE)) ? ((AttributeAliasCommand.CreateAttributeAlias)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        AttributeAliasCommand.MergePatchAttributeAlias merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((AttributeAliasCommand.MergePatchAttributeAlias)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        AttributeAliasCommand.RemoveAttributeAlias remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((AttributeAliasCommand.RemoveAttributeAlias)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected AttributeAliasEvent.AttributeAliasStateCreated mapCreate(AttributeAliasCommand.CreateAttributeAlias c, AttributeCommand outerCommand, Long version, AttributeState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeAliasEventId stateEventId = new AttributeAliasEventId(c.getAttributeId(), c.getCode(), version);
        AttributeAliasEvent.AttributeAliasStateCreated e = newAttributeAliasStateCreated(stateEventId);
        AttributeAliasState s = outerState.getAliases().get(c.getCode());

        e.setName(c.getName());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected AttributeAliasEvent.AttributeAliasStateMergePatched mapMergePatch(AttributeAliasCommand.MergePatchAttributeAlias c, AttributeCommand outerCommand, Long version, AttributeState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeAliasEventId stateEventId = new AttributeAliasEventId(c.getAttributeId(), c.getCode(), version);
        AttributeAliasEvent.AttributeAliasStateMergePatched e = newAttributeAliasStateMergePatched(stateEventId);
        AttributeAliasState s = outerState.getAliases().get(c.getCode());

        e.setName(c.getName());
        e.setActive(c.getActive());
        e.setIsPropertyNameRemoved(c.getIsPropertyNameRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected AttributeAliasEvent.AttributeAliasStateRemoved mapRemove(AttributeAliasCommand.RemoveAttributeAlias c, AttributeCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        AttributeAliasEventId stateEventId = new AttributeAliasEventId(c.getAttributeId(), c.getCode(), version);
        AttributeAliasEvent.AttributeAliasStateRemoved e = newAttributeAliasStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(AttributeCommand command, AttributeValueCommand innerCommand)
    {
        AbstractAttributeCommand properties = command instanceof AbstractAttributeCommand ? (AbstractAttributeCommand) command : null;
        AbstractAttributeValueCommand innerProperties = innerCommand instanceof AbstractAttributeValueCommand ? (AbstractAttributeValueCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerAttributeIdName = "AttributeId";
        String outerAttributeIdValue = properties.getAttributeId();
        String innerAttributeIdName = "AttributeId";
        String innerAttributeIdValue = innerProperties.getAttributeId();
        if (innerAttributeIdValue == null) {
            innerProperties.setAttributeId(outerAttributeIdValue);
        }
        else if (innerAttributeIdValue != outerAttributeIdValue 
            && (innerAttributeIdValue == null || innerAttributeIdValue != null && !innerAttributeIdValue.equals(outerAttributeIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerAttributeIdName, outerAttributeIdValue, innerAttributeIdName, innerAttributeIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////

    protected void throwOnInconsistentCommands(AttributeCommand command, AttributeAliasCommand innerCommand)
    {
        AbstractAttributeCommand properties = command instanceof AbstractAttributeCommand ? (AbstractAttributeCommand) command : null;
        AbstractAttributeAliasCommand innerProperties = innerCommand instanceof AbstractAttributeAliasCommand ? (AbstractAttributeAliasCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerAttributeIdName = "AttributeId";
        String outerAttributeIdValue = properties.getAttributeId();
        String innerAttributeIdName = "AttributeId";
        String innerAttributeIdValue = innerProperties.getAttributeId();
        if (innerAttributeIdValue == null) {
            innerProperties.setAttributeId(outerAttributeIdValue);
        }
        else if (innerAttributeIdValue != outerAttributeIdValue 
            && (innerAttributeIdValue == null || innerAttributeIdValue != null && !innerAttributeIdValue.equals(outerAttributeIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerAttributeIdName, outerAttributeIdValue, innerAttributeIdName, innerAttributeIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected AttributeEvent.AttributeStateCreated newAttributeStateCreated(Long version, String commandId, String requesterId) {
        AttributeEventId stateEventId = new AttributeEventId(this.state.getAttributeId(), version);
        AttributeEvent.AttributeStateCreated e = newAttributeStateCreated(stateEventId);
        ((AbstractAttributeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeEvent.AttributeStateMergePatched newAttributeStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeEventId stateEventId = new AttributeEventId(this.state.getAttributeId(), version);
        AttributeEvent.AttributeStateMergePatched e = newAttributeStateMergePatched(stateEventId);
        ((AbstractAttributeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeEvent.AttributeStateDeleted newAttributeStateDeleted(Long version, String commandId, String requesterId) {
        AttributeEventId stateEventId = new AttributeEventId(this.state.getAttributeId(), version);
        AttributeEvent.AttributeStateDeleted e = newAttributeStateDeleted(stateEventId);
        ((AbstractAttributeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeEvent.AttributeStateCreated newAttributeStateCreated(AttributeEventId stateEventId) {
        return new AbstractAttributeEvent.SimpleAttributeStateCreated(stateEventId);
    }

    protected AttributeEvent.AttributeStateMergePatched newAttributeStateMergePatched(AttributeEventId stateEventId) {
        return new AbstractAttributeEvent.SimpleAttributeStateMergePatched(stateEventId);
    }

    protected AttributeEvent.AttributeStateDeleted newAttributeStateDeleted(AttributeEventId stateEventId)
    {
        return new AbstractAttributeEvent.SimpleAttributeStateDeleted(stateEventId);
    }

    protected AttributeValueEvent.AttributeValueStateCreated newAttributeValueStateCreated(AttributeValueEventId stateEventId) {
        return new AbstractAttributeValueEvent.SimpleAttributeValueStateCreated(stateEventId);
    }

    protected AttributeValueEvent.AttributeValueStateMergePatched newAttributeValueStateMergePatched(AttributeValueEventId stateEventId) {
        return new AbstractAttributeValueEvent.SimpleAttributeValueStateMergePatched(stateEventId);
    }

    protected AttributeValueEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(AttributeValueEventId stateEventId)
    {
        return new AbstractAttributeValueEvent.SimpleAttributeValueStateRemoved(stateEventId);
    }

    protected AttributeAliasEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(AttributeAliasEventId stateEventId) {
        return new AbstractAttributeAliasEvent.SimpleAttributeAliasStateCreated(stateEventId);
    }

    protected AttributeAliasEvent.AttributeAliasStateMergePatched newAttributeAliasStateMergePatched(AttributeAliasEventId stateEventId) {
        return new AbstractAttributeAliasEvent.SimpleAttributeAliasStateMergePatched(stateEventId);
    }

    protected AttributeAliasEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(AttributeAliasEventId stateEventId)
    {
        return new AbstractAttributeAliasEvent.SimpleAttributeAliasStateRemoved(stateEventId);
    }

    public static class SimpleAttributeAggregate extends AbstractAttributeAggregate
    {
        public SimpleAttributeAggregate(AttributeState state) {
            super(state);
        }

    }

}

