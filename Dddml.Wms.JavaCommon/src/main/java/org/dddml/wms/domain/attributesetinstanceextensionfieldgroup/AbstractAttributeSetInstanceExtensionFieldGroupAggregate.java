package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldGroupAggregate extends AbstractAggregate implements AttributeSetInstanceExtensionFieldGroupAggregate
{
    private AttributeSetInstanceExtensionFieldGroupState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetInstanceExtensionFieldGroupAggregate(AttributeSetInstanceExtensionFieldGroupState state)
    {
        this.state = state;
    }

    public AttributeSetInstanceExtensionFieldGroupState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup c)
    {
        if (c.getVersion() == null) { c.setVersion(AttributeSetInstanceExtensionFieldGroupState.VERSION_NULL); }
        AttributeSetInstanceExtensionFieldGroupStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup c)
    {
        AttributeSetInstanceExtensionFieldGroupStateEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup c)
    {
        AttributeSetInstanceExtensionFieldGroupStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeSetInstanceExtensionFieldGroupCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent map(AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup c) {
        AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupStateEventId(c.getId(), c.getVersion());
        AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = newAttributeSetInstanceExtensionFieldGroupStateCreated(stateEventId);
        e.setFieldType(c.getFieldType());
        e.setFieldLength(c.getFieldLength());
        e.setFieldCount(c.getFieldCount());
        e.setNameFormat(c.getNameFormat());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractAttributeSetInstanceExtensionFieldGroupStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent map(AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup c) {
        AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupStateEventId(c.getId(), c.getVersion());
        AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = newAttributeSetInstanceExtensionFieldGroupStateMergePatched(stateEventId);
        e.setFieldType(c.getFieldType());
        e.setFieldLength(c.getFieldLength());
        e.setFieldCount(c.getFieldCount());
        e.setNameFormat(c.getNameFormat());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyFieldTypeRemoved(c.getIsPropertyFieldTypeRemoved());
        e.setIsPropertyFieldLengthRemoved(c.getIsPropertyFieldLengthRemoved());
        e.setIsPropertyFieldCountRemoved(c.getIsPropertyFieldCountRemoved());
        e.setIsPropertyNameFormatRemoved(c.getIsPropertyNameFormatRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractAttributeSetInstanceExtensionFieldGroupStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent map(AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup c) {
        AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupStateEventId(c.getId(), c.getVersion());
        AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = newAttributeSetInstanceExtensionFieldGroupStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated newAttributeSetInstanceExtensionFieldGroupStateCreated(String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupStateEventId(this.state.getId(), this.state.getVersion());
        AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = newAttributeSetInstanceExtensionFieldGroupStateCreated(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched newAttributeSetInstanceExtensionFieldGroupStateMergePatched(String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupStateEventId(this.state.getId(), this.state.getVersion());
        AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = newAttributeSetInstanceExtensionFieldGroupStateMergePatched(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted newAttributeSetInstanceExtensionFieldGroupStateDeleted(String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupStateEventId(this.state.getId(), this.state.getVersion());
        AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = newAttributeSetInstanceExtensionFieldGroupStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated newAttributeSetInstanceExtensionFieldGroupStateCreated(AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldGroupStateEvent.SimpleAttributeSetInstanceExtensionFieldGroupStateCreated(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched newAttributeSetInstanceExtensionFieldGroupStateMergePatched(AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldGroupStateEvent.SimpleAttributeSetInstanceExtensionFieldGroupStateMergePatched(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted newAttributeSetInstanceExtensionFieldGroupStateDeleted(AttributeSetInstanceExtensionFieldGroupStateEventId stateEventId)
    {
        return new AbstractAttributeSetInstanceExtensionFieldGroupStateEvent.SimpleAttributeSetInstanceExtensionFieldGroupStateDeleted(stateEventId);
    }


    public static class SimpleAttributeSetInstanceExtensionFieldGroupAggregate extends AbstractAttributeSetInstanceExtensionFieldGroupAggregate
    {
        public SimpleAttributeSetInstanceExtensionFieldGroupAggregate(AttributeSetInstanceExtensionFieldGroupState state) {
            super(state);
        }

    }

}

