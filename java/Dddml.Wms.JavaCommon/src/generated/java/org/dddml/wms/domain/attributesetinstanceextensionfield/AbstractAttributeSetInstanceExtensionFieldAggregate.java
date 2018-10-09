package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldAggregate extends AbstractAggregate implements AttributeSetInstanceExtensionFieldAggregate
{
    private AttributeSetInstanceExtensionFieldState.MutableAttributeSetInstanceExtensionFieldState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetInstanceExtensionFieldAggregate(AttributeSetInstanceExtensionFieldState state)
    {
        this.state = (AttributeSetInstanceExtensionFieldState.MutableAttributeSetInstanceExtensionFieldState)state;
    }

    public AttributeSetInstanceExtensionFieldState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField c)
    {
        if (c.getVersion() == null) { c.setVersion(AttributeSetInstanceExtensionFieldState.VERSION_NULL); }
        AttributeSetInstanceExtensionFieldEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c)
    {
        AttributeSetInstanceExtensionFieldEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c)
    {
        AttributeSetInstanceExtensionFieldEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeSetInstanceExtensionFieldCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeSetInstanceExtensionFieldEvent map(AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField c) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(c.getName(), c.getVersion());
        AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated e = newAttributeSetInstanceExtensionFieldStateCreated(stateEventId);
        e.setType(c.getType());
        e.setLength(c.getLength());
        e.setAlias(c.getAlias());
        e.setDescription(c.getDescription());
        e.setGroupId(c.getGroupId());
        e.setActive(c.getActive());
        ((AbstractAttributeSetInstanceExtensionFieldEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldEvent map(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(c.getName(), c.getVersion());
        AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = newAttributeSetInstanceExtensionFieldStateMergePatched(stateEventId);
        e.setType(c.getType());
        e.setLength(c.getLength());
        e.setAlias(c.getAlias());
        e.setDescription(c.getDescription());
        e.setGroupId(c.getGroupId());
        e.setActive(c.getActive());
        e.setIsPropertyTypeRemoved(c.getIsPropertyTypeRemoved());
        e.setIsPropertyLengthRemoved(c.getIsPropertyLengthRemoved());
        e.setIsPropertyAliasRemoved(c.getIsPropertyAliasRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyGroupIdRemoved(c.getIsPropertyGroupIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractAttributeSetInstanceExtensionFieldEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldEvent map(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(c.getName(), c.getVersion());
        AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted e = newAttributeSetInstanceExtensionFieldStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated newAttributeSetInstanceExtensionFieldStateCreated(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(this.state.getName(), version);
        AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated e = newAttributeSetInstanceExtensionFieldStateCreated(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched newAttributeSetInstanceExtensionFieldStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(this.state.getName(), version);
        AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = newAttributeSetInstanceExtensionFieldStateMergePatched(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted newAttributeSetInstanceExtensionFieldStateDeleted(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(this.state.getName(), version);
        AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted e = newAttributeSetInstanceExtensionFieldStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated newAttributeSetInstanceExtensionFieldStateCreated(AttributeSetInstanceExtensionFieldEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldEvent.SimpleAttributeSetInstanceExtensionFieldStateCreated(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched newAttributeSetInstanceExtensionFieldStateMergePatched(AttributeSetInstanceExtensionFieldEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldEvent.SimpleAttributeSetInstanceExtensionFieldStateMergePatched(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted newAttributeSetInstanceExtensionFieldStateDeleted(AttributeSetInstanceExtensionFieldEventId stateEventId)
    {
        return new AbstractAttributeSetInstanceExtensionFieldEvent.SimpleAttributeSetInstanceExtensionFieldStateDeleted(stateEventId);
    }

    public static class SimpleAttributeSetInstanceExtensionFieldAggregate extends AbstractAttributeSetInstanceExtensionFieldAggregate
    {
        public SimpleAttributeSetInstanceExtensionFieldAggregate(AttributeSetInstanceExtensionFieldState state) {
            super(state);
        }

    }

}

