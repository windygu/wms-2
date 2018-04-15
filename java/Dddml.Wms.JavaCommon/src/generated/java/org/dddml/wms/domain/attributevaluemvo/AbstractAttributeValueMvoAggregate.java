package org.dddml.wms.domain.attributevaluemvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeValueMvoAggregate extends AbstractAggregate implements AttributeValueMvoAggregate
{
    private AttributeValueMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeValueMvoAggregate(AttributeValueMvoState state)
    {
        this.state = state;
    }

    public AttributeValueMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeValueMvoCommand.CreateAttributeValueMvo c)
    {
        if (c.getAttributeVersion() == null) { c.setAttributeVersion(AttributeValueMvoState.VERSION_NULL); }
        AttributeValueMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeValueMvoCommand.MergePatchAttributeValueMvo c)
    {
        AttributeValueMvoEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeValueMvoCommand.DeleteAttributeValueMvo c)
    {
        AttributeValueMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeValueMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeValueMvoEvent map(AttributeValueMvoCommand.CreateAttributeValueMvo c) {
        AttributeValueMvoEventId stateEventId = new AttributeValueMvoEventId(c.getAttributeValueId(), c.getAttributeVersion());
        AttributeValueMvoEvent.AttributeValueMvoStateCreated e = newAttributeValueMvoStateCreated(stateEventId);
        e.setAttributeValueName(c.getAttributeValueName());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
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
        ((AbstractAttributeValueMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeValueMvoEvent map(AttributeValueMvoCommand.MergePatchAttributeValueMvo c) {
        AttributeValueMvoEventId stateEventId = new AttributeValueMvoEventId(c.getAttributeValueId(), c.getAttributeVersion());
        AttributeValueMvoEvent.AttributeValueMvoStateMergePatched e = newAttributeValueMvoStateMergePatched(stateEventId);
        e.setAttributeValueName(c.getAttributeValueName());
        e.setDescription(c.getDescription());
        e.setReferenceId(c.getReferenceId());
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
        e.setIsPropertyAttributeValueNameRemoved(c.getIsPropertyAttributeValueNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyReferenceIdRemoved(c.getIsPropertyReferenceIdRemoved());
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
        ((AbstractAttributeValueMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeValueMvoEvent map(AttributeValueMvoCommand.DeleteAttributeValueMvo c) {
        AttributeValueMvoEventId stateEventId = new AttributeValueMvoEventId(c.getAttributeValueId(), c.getAttributeVersion());
        AttributeValueMvoEvent.AttributeValueMvoStateDeleted e = newAttributeValueMvoStateDeleted(stateEventId);
        ((AbstractAttributeValueMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeValueMvoEvent.AttributeValueMvoStateCreated newAttributeValueMvoStateCreated(Long version, String commandId, String requesterId) {
        AttributeValueMvoEventId stateEventId = new AttributeValueMvoEventId(this.state.getAttributeValueId(), version);
        AttributeValueMvoEvent.AttributeValueMvoStateCreated e = newAttributeValueMvoStateCreated(stateEventId);
        ((AbstractAttributeValueMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeValueMvoEvent.AttributeValueMvoStateMergePatched newAttributeValueMvoStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeValueMvoEventId stateEventId = new AttributeValueMvoEventId(this.state.getAttributeValueId(), version);
        AttributeValueMvoEvent.AttributeValueMvoStateMergePatched e = newAttributeValueMvoStateMergePatched(stateEventId);
        ((AbstractAttributeValueMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeValueMvoEvent.AttributeValueMvoStateDeleted newAttributeValueMvoStateDeleted(Long version, String commandId, String requesterId) {
        AttributeValueMvoEventId stateEventId = new AttributeValueMvoEventId(this.state.getAttributeValueId(), version);
        AttributeValueMvoEvent.AttributeValueMvoStateDeleted e = newAttributeValueMvoStateDeleted(stateEventId);
        ((AbstractAttributeValueMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeValueMvoEvent.AttributeValueMvoStateCreated newAttributeValueMvoStateCreated(AttributeValueMvoEventId stateEventId) {
        return new AbstractAttributeValueMvoEvent.SimpleAttributeValueMvoStateCreated(stateEventId);
    }

    protected AttributeValueMvoEvent.AttributeValueMvoStateMergePatched newAttributeValueMvoStateMergePatched(AttributeValueMvoEventId stateEventId) {
        return new AbstractAttributeValueMvoEvent.SimpleAttributeValueMvoStateMergePatched(stateEventId);
    }

    protected AttributeValueMvoEvent.AttributeValueMvoStateDeleted newAttributeValueMvoStateDeleted(AttributeValueMvoEventId stateEventId)
    {
        return new AbstractAttributeValueMvoEvent.SimpleAttributeValueMvoStateDeleted(stateEventId);
    }

    public static class SimpleAttributeValueMvoAggregate extends AbstractAttributeValueMvoAggregate
    {
        public SimpleAttributeValueMvoAggregate(AttributeValueMvoState state) {
            super(state);
        }

    }

}

