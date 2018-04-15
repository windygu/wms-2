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
        AttributeAliasMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c)
    {
        AttributeAliasMvoEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c)
    {
        AttributeAliasMvoEvent e = map(c);
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

    protected AttributeAliasMvoEvent map(AttributeAliasMvoCommand.CreateAttributeAliasMvo c) {
        AttributeAliasMvoEventId stateEventId = new AttributeAliasMvoEventId(c.getAttributeAliasId(), c.getAttributeVersion());
        AttributeAliasMvoEvent.AttributeAliasMvoStateCreated e = newAttributeAliasMvoStateCreated(stateEventId);
        e.setName(c.getName());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setAttributeAttributeName(c.getAttributeAttributeName());
        e.setAttributeOrganizationId(c.getAttributeOrganizationId());
        e.setAttributeDescription(c.getAttributeDescription());
        e.setAttributeIsMandatory(c.getAttributeIsMandatory());
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
        ((AbstractAttributeAliasMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoEvent map(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c) {
        AttributeAliasMvoEventId stateEventId = new AttributeAliasMvoEventId(c.getAttributeAliasId(), c.getAttributeVersion());
        AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched e = newAttributeAliasMvoStateMergePatched(stateEventId);
        e.setName(c.getName());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setAttributeAttributeName(c.getAttributeAttributeName());
        e.setAttributeOrganizationId(c.getAttributeOrganizationId());
        e.setAttributeDescription(c.getAttributeDescription());
        e.setAttributeIsMandatory(c.getAttributeIsMandatory());
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
        ((AbstractAttributeAliasMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoEvent map(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c) {
        AttributeAliasMvoEventId stateEventId = new AttributeAliasMvoEventId(c.getAttributeAliasId(), c.getAttributeVersion());
        AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted e = newAttributeAliasMvoStateDeleted(stateEventId);
        ((AbstractAttributeAliasMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeAliasMvoEvent.AttributeAliasMvoStateCreated newAttributeAliasMvoStateCreated(Long version, String commandId, String requesterId) {
        AttributeAliasMvoEventId stateEventId = new AttributeAliasMvoEventId(this.state.getAttributeAliasId(), version);
        AttributeAliasMvoEvent.AttributeAliasMvoStateCreated e = newAttributeAliasMvoStateCreated(stateEventId);
        ((AbstractAttributeAliasMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched newAttributeAliasMvoStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeAliasMvoEventId stateEventId = new AttributeAliasMvoEventId(this.state.getAttributeAliasId(), version);
        AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched e = newAttributeAliasMvoStateMergePatched(stateEventId);
        ((AbstractAttributeAliasMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted newAttributeAliasMvoStateDeleted(Long version, String commandId, String requesterId) {
        AttributeAliasMvoEventId stateEventId = new AttributeAliasMvoEventId(this.state.getAttributeAliasId(), version);
        AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted e = newAttributeAliasMvoStateDeleted(stateEventId);
        ((AbstractAttributeAliasMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeAliasMvoEvent.AttributeAliasMvoStateCreated newAttributeAliasMvoStateCreated(AttributeAliasMvoEventId stateEventId) {
        return new AbstractAttributeAliasMvoEvent.SimpleAttributeAliasMvoStateCreated(stateEventId);
    }

    protected AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched newAttributeAliasMvoStateMergePatched(AttributeAliasMvoEventId stateEventId) {
        return new AbstractAttributeAliasMvoEvent.SimpleAttributeAliasMvoStateMergePatched(stateEventId);
    }

    protected AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted newAttributeAliasMvoStateDeleted(AttributeAliasMvoEventId stateEventId)
    {
        return new AbstractAttributeAliasMvoEvent.SimpleAttributeAliasMvoStateDeleted(stateEventId);
    }

    public static class SimpleAttributeAliasMvoAggregate extends AbstractAttributeAliasMvoAggregate
    {
        public SimpleAttributeAliasMvoAggregate(AttributeAliasMvoState state) {
            super(state);
        }

    }

}

