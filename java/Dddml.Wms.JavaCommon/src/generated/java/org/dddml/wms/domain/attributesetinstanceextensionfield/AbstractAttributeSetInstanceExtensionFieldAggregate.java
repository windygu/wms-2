package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldAggregate extends AbstractAggregate implements AttributeSetInstanceExtensionFieldAggregate
{
    private AttributeSetInstanceExtensionFieldState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetInstanceExtensionFieldAggregate(AttributeSetInstanceExtensionFieldState state)
    {
        this.state = state;
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
        AttributeSetInstanceExtensionFieldStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c)
    {
        AttributeSetInstanceExtensionFieldStateEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c)
    {
        AttributeSetInstanceExtensionFieldStateEvent e = map(c);
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

    protected AttributeSetInstanceExtensionFieldStateEvent map(AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField c) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(c.getName(), c.getVersion());
        AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e = newAttributeSetInstanceExtensionFieldStateCreated(stateEventId);
        e.setType(c.getType());
        e.setLength(c.getLength());
        e.setAlias(c.getAlias());
        e.setDescription(c.getDescription());
        e.setGroupId(c.getGroupId());
        e.setActive(c.getActive());
        ((AbstractAttributeSetInstanceExtensionFieldStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldStateEvent map(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(c.getName(), c.getVersion());
        AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = newAttributeSetInstanceExtensionFieldStateMergePatched(stateEventId);
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
        ((AbstractAttributeSetInstanceExtensionFieldStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldStateEvent map(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(c.getName(), c.getVersion());
        AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted e = newAttributeSetInstanceExtensionFieldStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated newAttributeSetInstanceExtensionFieldStateCreated(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(this.state.getName(), version);
        AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e = newAttributeSetInstanceExtensionFieldStateCreated(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched newAttributeSetInstanceExtensionFieldStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(this.state.getName(), version);
        AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = newAttributeSetInstanceExtensionFieldStateMergePatched(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted newAttributeSetInstanceExtensionFieldStateDeleted(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldEventId stateEventId = new AttributeSetInstanceExtensionFieldEventId(this.state.getName(), version);
        AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted e = newAttributeSetInstanceExtensionFieldStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated newAttributeSetInstanceExtensionFieldStateCreated(AttributeSetInstanceExtensionFieldEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldStateEvent.SimpleAttributeSetInstanceExtensionFieldStateCreated(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched newAttributeSetInstanceExtensionFieldStateMergePatched(AttributeSetInstanceExtensionFieldEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldStateEvent.SimpleAttributeSetInstanceExtensionFieldStateMergePatched(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted newAttributeSetInstanceExtensionFieldStateDeleted(AttributeSetInstanceExtensionFieldEventId stateEventId)
    {
        return new AbstractAttributeSetInstanceExtensionFieldStateEvent.SimpleAttributeSetInstanceExtensionFieldStateDeleted(stateEventId);
    }

    public static class SimpleAttributeSetInstanceExtensionFieldAggregate extends AbstractAttributeSetInstanceExtensionFieldAggregate
    {
        public SimpleAttributeSetInstanceExtensionFieldAggregate(AttributeSetInstanceExtensionFieldState state) {
            super(state);
        }

    }

}

