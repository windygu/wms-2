package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldGroupAggregate extends AbstractAggregate implements AttributeSetInstanceExtensionFieldGroupAggregate
{
    private AttributeSetInstanceExtensionFieldGroupState.MutableAttributeSetInstanceExtensionFieldGroupState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeSetInstanceExtensionFieldGroupAggregate(AttributeSetInstanceExtensionFieldGroupState state)
    {
        this.state = (AttributeSetInstanceExtensionFieldGroupState.MutableAttributeSetInstanceExtensionFieldGroupState)state;
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
        AttributeSetInstanceExtensionFieldGroupEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup c)
    {
        AttributeSetInstanceExtensionFieldGroupEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup c)
    {
        AttributeSetInstanceExtensionFieldGroupEvent e = map(c);
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

    protected AttributeSetInstanceExtensionFieldGroupEvent map(AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup c) {
        AttributeSetInstanceExtensionFieldGroupEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupEventId(c.getId(), c.getVersion());
        AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = newAttributeSetInstanceExtensionFieldGroupStateCreated(stateEventId);
        e.setFieldType(c.getFieldType());
        e.setFieldLength(c.getFieldLength());
        e.setFieldCount(c.getFieldCount());
        e.setNameFormat(c.getNameFormat());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractAttributeSetInstanceExtensionFieldGroupEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent map(AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup c) {
        AttributeSetInstanceExtensionFieldGroupEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupEventId(c.getId(), c.getVersion());
        AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = newAttributeSetInstanceExtensionFieldGroupStateMergePatched(stateEventId);
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
        ((AbstractAttributeSetInstanceExtensionFieldGroupEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent map(AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup c) {
        AttributeSetInstanceExtensionFieldGroupEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupEventId(c.getId(), c.getVersion());
        AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = newAttributeSetInstanceExtensionFieldGroupStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated newAttributeSetInstanceExtensionFieldGroupStateCreated(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldGroupEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupEventId(this.state.getId(), version);
        AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = newAttributeSetInstanceExtensionFieldGroupStateCreated(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched newAttributeSetInstanceExtensionFieldGroupStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldGroupEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupEventId(this.state.getId(), version);
        AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = newAttributeSetInstanceExtensionFieldGroupStateMergePatched(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted newAttributeSetInstanceExtensionFieldGroupStateDeleted(Long version, String commandId, String requesterId) {
        AttributeSetInstanceExtensionFieldGroupEventId stateEventId = new AttributeSetInstanceExtensionFieldGroupEventId(this.state.getId(), version);
        AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = newAttributeSetInstanceExtensionFieldGroupStateDeleted(stateEventId);
        ((AbstractAttributeSetInstanceExtensionFieldGroupEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated newAttributeSetInstanceExtensionFieldGroupStateCreated(AttributeSetInstanceExtensionFieldGroupEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldGroupEvent.SimpleAttributeSetInstanceExtensionFieldGroupStateCreated(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched newAttributeSetInstanceExtensionFieldGroupStateMergePatched(AttributeSetInstanceExtensionFieldGroupEventId stateEventId) {
        return new AbstractAttributeSetInstanceExtensionFieldGroupEvent.SimpleAttributeSetInstanceExtensionFieldGroupStateMergePatched(stateEventId);
    }

    protected AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted newAttributeSetInstanceExtensionFieldGroupStateDeleted(AttributeSetInstanceExtensionFieldGroupEventId stateEventId)
    {
        return new AbstractAttributeSetInstanceExtensionFieldGroupEvent.SimpleAttributeSetInstanceExtensionFieldGroupStateDeleted(stateEventId);
    }

    public static class SimpleAttributeSetInstanceExtensionFieldGroupAggregate extends AbstractAttributeSetInstanceExtensionFieldGroupAggregate
    {
        public SimpleAttributeSetInstanceExtensionFieldGroupAggregate(AttributeSetInstanceExtensionFieldGroupState state) {
            super(state);
        }

    }

}

