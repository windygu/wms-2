package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeUseMvoAggregate extends AbstractAggregate implements AttributeUseMvoAggregate
{
    private AttributeUseMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractAttributeUseMvoAggregate(AttributeUseMvoState state)
    {
        this.state = state;
    }

    public AttributeUseMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(AttributeUseMvoCommand.CreateAttributeUseMvo c)
    {
        if (c.getAttributeSetVersion() == null) { c.setAttributeSetVersion(AttributeUseMvoState.VERSION_NULL); }
        AttributeUseMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeUseMvoCommand.MergePatchAttributeUseMvo c)
    {
        AttributeUseMvoEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeUseMvoCommand.DeleteAttributeUseMvo c)
    {
        AttributeUseMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        AttributeUseMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected AttributeUseMvoEvent map(AttributeUseMvoCommand.CreateAttributeUseMvo c) {
        AttributeUseMvoEventId stateEventId = new AttributeUseMvoEventId(c.getAttributeSetAttributeUseId(), c.getAttributeSetVersion());
        AttributeUseMvoEvent.AttributeUseMvoStateCreated e = newAttributeUseMvoStateCreated(stateEventId);
        e.setSequenceNumber(c.getSequenceNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setAttributeSetAttributeSetName(c.getAttributeSetAttributeSetName());
        e.setAttributeSetOrganizationId(c.getAttributeSetOrganizationId());
        e.setAttributeSetDescription(c.getAttributeSetDescription());
        e.setAttributeSetReferenceId(c.getAttributeSetReferenceId());
        e.setAttributeSetIsInstanceAttributeSet(c.getAttributeSetIsInstanceAttributeSet());
        e.setAttributeSetIsMandatory(c.getAttributeSetIsMandatory());
        e.setAttributeSetCreatedBy(c.getAttributeSetCreatedBy());
        e.setAttributeSetCreatedAt(c.getAttributeSetCreatedAt());
        e.setAttributeSetUpdatedBy(c.getAttributeSetUpdatedBy());
        e.setAttributeSetUpdatedAt(c.getAttributeSetUpdatedAt());
        e.setAttributeSetActive(c.getAttributeSetActive());
        e.setAttributeSetDeleted(c.getAttributeSetDeleted());
        ((AbstractAttributeUseMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoEvent map(AttributeUseMvoCommand.MergePatchAttributeUseMvo c) {
        AttributeUseMvoEventId stateEventId = new AttributeUseMvoEventId(c.getAttributeSetAttributeUseId(), c.getAttributeSetVersion());
        AttributeUseMvoEvent.AttributeUseMvoStateMergePatched e = newAttributeUseMvoStateMergePatched(stateEventId);
        e.setSequenceNumber(c.getSequenceNumber());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setAttributeSetAttributeSetName(c.getAttributeSetAttributeSetName());
        e.setAttributeSetOrganizationId(c.getAttributeSetOrganizationId());
        e.setAttributeSetDescription(c.getAttributeSetDescription());
        e.setAttributeSetReferenceId(c.getAttributeSetReferenceId());
        e.setAttributeSetIsInstanceAttributeSet(c.getAttributeSetIsInstanceAttributeSet());
        e.setAttributeSetIsMandatory(c.getAttributeSetIsMandatory());
        e.setAttributeSetCreatedBy(c.getAttributeSetCreatedBy());
        e.setAttributeSetCreatedAt(c.getAttributeSetCreatedAt());
        e.setAttributeSetUpdatedBy(c.getAttributeSetUpdatedBy());
        e.setAttributeSetUpdatedAt(c.getAttributeSetUpdatedAt());
        e.setAttributeSetActive(c.getAttributeSetActive());
        e.setAttributeSetDeleted(c.getAttributeSetDeleted());
        e.setIsPropertySequenceNumberRemoved(c.getIsPropertySequenceNumberRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyAttributeSetAttributeSetNameRemoved(c.getIsPropertyAttributeSetAttributeSetNameRemoved());
        e.setIsPropertyAttributeSetOrganizationIdRemoved(c.getIsPropertyAttributeSetOrganizationIdRemoved());
        e.setIsPropertyAttributeSetDescriptionRemoved(c.getIsPropertyAttributeSetDescriptionRemoved());
        e.setIsPropertyAttributeSetReferenceIdRemoved(c.getIsPropertyAttributeSetReferenceIdRemoved());
        e.setIsPropertyAttributeSetIsInstanceAttributeSetRemoved(c.getIsPropertyAttributeSetIsInstanceAttributeSetRemoved());
        e.setIsPropertyAttributeSetIsMandatoryRemoved(c.getIsPropertyAttributeSetIsMandatoryRemoved());
        e.setIsPropertyAttributeSetCreatedByRemoved(c.getIsPropertyAttributeSetCreatedByRemoved());
        e.setIsPropertyAttributeSetCreatedAtRemoved(c.getIsPropertyAttributeSetCreatedAtRemoved());
        e.setIsPropertyAttributeSetUpdatedByRemoved(c.getIsPropertyAttributeSetUpdatedByRemoved());
        e.setIsPropertyAttributeSetUpdatedAtRemoved(c.getIsPropertyAttributeSetUpdatedAtRemoved());
        e.setIsPropertyAttributeSetActiveRemoved(c.getIsPropertyAttributeSetActiveRemoved());
        e.setIsPropertyAttributeSetDeletedRemoved(c.getIsPropertyAttributeSetDeletedRemoved());
        ((AbstractAttributeUseMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoEvent map(AttributeUseMvoCommand.DeleteAttributeUseMvo c) {
        AttributeUseMvoEventId stateEventId = new AttributeUseMvoEventId(c.getAttributeSetAttributeUseId(), c.getAttributeSetVersion());
        AttributeUseMvoEvent.AttributeUseMvoStateDeleted e = newAttributeUseMvoStateDeleted(stateEventId);
        ((AbstractAttributeUseMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeUseMvoEvent.AttributeUseMvoStateCreated newAttributeUseMvoStateCreated(Long version, String commandId, String requesterId) {
        AttributeUseMvoEventId stateEventId = new AttributeUseMvoEventId(this.state.getAttributeSetAttributeUseId(), version);
        AttributeUseMvoEvent.AttributeUseMvoStateCreated e = newAttributeUseMvoStateCreated(stateEventId);
        ((AbstractAttributeUseMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoEvent.AttributeUseMvoStateMergePatched newAttributeUseMvoStateMergePatched(Long version, String commandId, String requesterId) {
        AttributeUseMvoEventId stateEventId = new AttributeUseMvoEventId(this.state.getAttributeSetAttributeUseId(), version);
        AttributeUseMvoEvent.AttributeUseMvoStateMergePatched e = newAttributeUseMvoStateMergePatched(stateEventId);
        ((AbstractAttributeUseMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoEvent.AttributeUseMvoStateDeleted newAttributeUseMvoStateDeleted(Long version, String commandId, String requesterId) {
        AttributeUseMvoEventId stateEventId = new AttributeUseMvoEventId(this.state.getAttributeSetAttributeUseId(), version);
        AttributeUseMvoEvent.AttributeUseMvoStateDeleted e = newAttributeUseMvoStateDeleted(stateEventId);
        ((AbstractAttributeUseMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoEvent.AttributeUseMvoStateCreated newAttributeUseMvoStateCreated(AttributeUseMvoEventId stateEventId) {
        return new AbstractAttributeUseMvoEvent.SimpleAttributeUseMvoStateCreated(stateEventId);
    }

    protected AttributeUseMvoEvent.AttributeUseMvoStateMergePatched newAttributeUseMvoStateMergePatched(AttributeUseMvoEventId stateEventId) {
        return new AbstractAttributeUseMvoEvent.SimpleAttributeUseMvoStateMergePatched(stateEventId);
    }

    protected AttributeUseMvoEvent.AttributeUseMvoStateDeleted newAttributeUseMvoStateDeleted(AttributeUseMvoEventId stateEventId)
    {
        return new AbstractAttributeUseMvoEvent.SimpleAttributeUseMvoStateDeleted(stateEventId);
    }

    public static class SimpleAttributeUseMvoAggregate extends AbstractAttributeUseMvoAggregate
    {
        public SimpleAttributeUseMvoAggregate(AttributeUseMvoState state) {
            super(state);
        }

    }

}

