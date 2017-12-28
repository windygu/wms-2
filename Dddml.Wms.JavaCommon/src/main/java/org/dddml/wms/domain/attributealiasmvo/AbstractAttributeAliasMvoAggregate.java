package org.dddml.wms.domain.attributealiasmvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeAliasMvoAggregate extends AbstractAggregate implements AttributeAliasMvoAggregate
{
    private AttributeAliasMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeAliasMvoAggregate(AttributeAliasMvoState state)
    {
        this.state = state;
    }

    public AttributeAliasMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeAliasMvoCommand.CreateAttributeAliasMvo c)
    {
        if (c.getAttributeVersion() == null) { c.setAttributeVersion(AttributeAliasMvoState.VERSION_NULL); }
        AttributeAliasMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c)
    {
        AttributeAliasMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c)
    {
        AttributeAliasMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeAliasMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeAliasMvoStateEvent map(AttributeAliasMvoCommand.CreateAttributeAliasMvo c) {
        AttributeAliasMvoStateEventId stateEventId = new AttributeAliasMvoStateEventId(c.getAttributeAliasId(), c.getAttributeVersion());
        AttributeAliasMvoStateEvent.AttributeAliasMvoStateCreated e = newAttributeAliasMvoStateCreated(stateEventId);
        e.setName(c.getName());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setAttributeAttributeName(c.getAttributeAttributeName());
        e.setAttributeOrganizationId(c.getAttributeOrganizationId());
        e.setAttributeDescription(c.getAttributeDescription());
        e.setAttributeIsMandatory(c.getAttributeIsMandatory());
        e.setAttributeIsInstanceAttribute(c.getAttributeIsInstanceAttribute());
        e.setAttributeAttributeValueType(c.getAttributeAttributeValueType());
        e.setAttributeAttributeValueLength(c.getAttributeAttributeValueLength());
        e.setAttributeIsList(c.getAttributeIsList());
        e.setAttributeFieldName(c.getAttributeFieldName());
        e.setAttributeReferenceId(c.getAttributeReferenceId());
        e.setAttributeCreatedBy(c.getAttributeCreatedBy());
        e.setAttributeCreatedAt(c.getAttributeCreatedAt());
        e.setAttributeUpdatedBy(c.getAttributeUpdatedBy());
        e.setAttributeUpdatedAt(c.getAttributeUpdatedAt());
        e.setAttributeActive(c.getAttributeActive());
        e.setAttributeDeleted(c.getAttributeDeleted());
        ((AbstractAttributeAliasMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoStateEvent map(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c) {
        AttributeAliasMvoStateEventId stateEventId = new AttributeAliasMvoStateEventId(c.getAttributeAliasId(), c.getAttributeVersion());
        AttributeAliasMvoStateEvent.AttributeAliasMvoStateMergePatched e = newAttributeAliasMvoStateMergePatched(stateEventId);
        e.setName(c.getName());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setAttributeAttributeName(c.getAttributeAttributeName());
        e.setAttributeOrganizationId(c.getAttributeOrganizationId());
        e.setAttributeDescription(c.getAttributeDescription());
        e.setAttributeIsMandatory(c.getAttributeIsMandatory());
        e.setAttributeIsInstanceAttribute(c.getAttributeIsInstanceAttribute());
        e.setAttributeAttributeValueType(c.getAttributeAttributeValueType());
        e.setAttributeAttributeValueLength(c.getAttributeAttributeValueLength());
        e.setAttributeIsList(c.getAttributeIsList());
        e.setAttributeFieldName(c.getAttributeFieldName());
        e.setAttributeReferenceId(c.getAttributeReferenceId());
        e.setAttributeCreatedBy(c.getAttributeCreatedBy());
        e.setAttributeCreatedAt(c.getAttributeCreatedAt());
        e.setAttributeUpdatedBy(c.getAttributeUpdatedBy());
        e.setAttributeUpdatedAt(c.getAttributeUpdatedAt());
        e.setAttributeActive(c.getAttributeActive());
        e.setAttributeDeleted(c.getAttributeDeleted());
        e.setIsPropertyNameRemoved(c.getIsPropertyNameRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyAttributeAttributeNameRemoved(c.getIsPropertyAttributeAttributeNameRemoved());
        e.setIsPropertyAttributeOrganizationIdRemoved(c.getIsPropertyAttributeOrganizationIdRemoved());
        e.setIsPropertyAttributeDescriptionRemoved(c.getIsPropertyAttributeDescriptionRemoved());
        e.setIsPropertyAttributeIsMandatoryRemoved(c.getIsPropertyAttributeIsMandatoryRemoved());
        e.setIsPropertyAttributeIsInstanceAttributeRemoved(c.getIsPropertyAttributeIsInstanceAttributeRemoved());
        e.setIsPropertyAttributeAttributeValueTypeRemoved(c.getIsPropertyAttributeAttributeValueTypeRemoved());
        e.setIsPropertyAttributeAttributeValueLengthRemoved(c.getIsPropertyAttributeAttributeValueLengthRemoved());
        e.setIsPropertyAttributeIsListRemoved(c.getIsPropertyAttributeIsListRemoved());
        e.setIsPropertyAttributeFieldNameRemoved(c.getIsPropertyAttributeFieldNameRemoved());
        e.setIsPropertyAttributeReferenceIdRemoved(c.getIsPropertyAttributeReferenceIdRemoved());
        e.setIsPropertyAttributeCreatedByRemoved(c.getIsPropertyAttributeCreatedByRemoved());
        e.setIsPropertyAttributeCreatedAtRemoved(c.getIsPropertyAttributeCreatedAtRemoved());
        e.setIsPropertyAttributeUpdatedByRemoved(c.getIsPropertyAttributeUpdatedByRemoved());
        e.setIsPropertyAttributeUpdatedAtRemoved(c.getIsPropertyAttributeUpdatedAtRemoved());
        e.setIsPropertyAttributeActiveRemoved(c.getIsPropertyAttributeActiveRemoved());
        e.setIsPropertyAttributeDeletedRemoved(c.getIsPropertyAttributeDeletedRemoved());
        ((AbstractAttributeAliasMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoStateEvent map(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c) {
        AttributeAliasMvoStateEventId stateEventId = new AttributeAliasMvoStateEventId(c.getAttributeAliasId(), c.getAttributeVersion());
        AttributeAliasMvoStateEvent.AttributeAliasMvoStateDeleted e = newAttributeAliasMvoStateDeleted(stateEventId);
        ((AbstractAttributeAliasMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeAliasMvoStateEvent.AttributeAliasMvoStateCreated newAttributeAliasMvoStateCreated(String commandId, String requesterId) {
        AttributeAliasMvoStateEventId stateEventId = new AttributeAliasMvoStateEventId(this.state.getAttributeAliasId(), this.state.getAttributeVersion());
        AttributeAliasMvoStateEvent.AttributeAliasMvoStateCreated e = newAttributeAliasMvoStateCreated(stateEventId);
        ((AbstractAttributeAliasMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoStateEvent.AttributeAliasMvoStateMergePatched newAttributeAliasMvoStateMergePatched(String commandId, String requesterId) {
        AttributeAliasMvoStateEventId stateEventId = new AttributeAliasMvoStateEventId(this.state.getAttributeAliasId(), this.state.getAttributeVersion());
        AttributeAliasMvoStateEvent.AttributeAliasMvoStateMergePatched e = newAttributeAliasMvoStateMergePatched(stateEventId);
        ((AbstractAttributeAliasMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoStateEvent.AttributeAliasMvoStateDeleted newAttributeAliasMvoStateDeleted(String commandId, String requesterId) {
        AttributeAliasMvoStateEventId stateEventId = new AttributeAliasMvoStateEventId(this.state.getAttributeAliasId(), this.state.getAttributeVersion());
        AttributeAliasMvoStateEvent.AttributeAliasMvoStateDeleted e = newAttributeAliasMvoStateDeleted(stateEventId);
        ((AbstractAttributeAliasMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoStateEvent.AttributeAliasMvoStateCreated newAttributeAliasMvoStateCreated(AttributeAliasMvoStateEventId stateEventId) {
        return new AbstractAttributeAliasMvoStateEvent.SimpleAttributeAliasMvoStateCreated(stateEventId);
    }

    protected AttributeAliasMvoStateEvent.AttributeAliasMvoStateMergePatched newAttributeAliasMvoStateMergePatched(AttributeAliasMvoStateEventId stateEventId) {
        return new AbstractAttributeAliasMvoStateEvent.SimpleAttributeAliasMvoStateMergePatched(stateEventId);
    }

    protected AttributeAliasMvoStateEvent.AttributeAliasMvoStateDeleted newAttributeAliasMvoStateDeleted(AttributeAliasMvoStateEventId stateEventId)
    {
        return new AbstractAttributeAliasMvoStateEvent.SimpleAttributeAliasMvoStateDeleted(stateEventId);
    }


    public static class SimpleAttributeAliasMvoAggregate extends AbstractAttributeAliasMvoAggregate
    {
        public SimpleAttributeAliasMvoAggregate(AttributeAliasMvoState state) {
            super(state);
        }

    }

}

