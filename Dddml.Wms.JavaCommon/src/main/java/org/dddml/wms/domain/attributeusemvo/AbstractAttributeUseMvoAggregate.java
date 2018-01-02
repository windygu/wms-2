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
        AttributeUseMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(AttributeUseMvoCommand.MergePatchAttributeUseMvo c)
    {
        AttributeUseMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(AttributeUseMvoCommand.DeleteAttributeUseMvo c)
    {
        AttributeUseMvoStateEvent e = map(c);
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

    protected AttributeUseMvoStateEvent map(AttributeUseMvoCommand.CreateAttributeUseMvo c) {
        AttributeUseMvoStateEventId stateEventId = new AttributeUseMvoStateEventId(c.getAttributeSetAttributeUseId(), c.getAttributeSetVersion());
        AttributeUseMvoStateEvent.AttributeUseMvoStateCreated e = newAttributeUseMvoStateCreated(stateEventId);
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
        ((AbstractAttributeUseMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoStateEvent map(AttributeUseMvoCommand.MergePatchAttributeUseMvo c) {
        AttributeUseMvoStateEventId stateEventId = new AttributeUseMvoStateEventId(c.getAttributeSetAttributeUseId(), c.getAttributeSetVersion());
        AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched e = newAttributeUseMvoStateMergePatched(stateEventId);
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
        ((AbstractAttributeUseMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoStateEvent map(AttributeUseMvoCommand.DeleteAttributeUseMvo c) {
        AttributeUseMvoStateEventId stateEventId = new AttributeUseMvoStateEventId(c.getAttributeSetAttributeUseId(), c.getAttributeSetVersion());
        AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted e = newAttributeUseMvoStateDeleted(stateEventId);
        ((AbstractAttributeUseMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected AttributeUseMvoStateEvent.AttributeUseMvoStateCreated newAttributeUseMvoStateCreated(String commandId, String requesterId) {
        AttributeUseMvoStateEventId stateEventId = new AttributeUseMvoStateEventId(this.state.getAttributeSetAttributeUseId(), this.state.getAttributeSetVersion());
        AttributeUseMvoStateEvent.AttributeUseMvoStateCreated e = newAttributeUseMvoStateCreated(stateEventId);
        ((AbstractAttributeUseMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched newAttributeUseMvoStateMergePatched(String commandId, String requesterId) {
        AttributeUseMvoStateEventId stateEventId = new AttributeUseMvoStateEventId(this.state.getAttributeSetAttributeUseId(), this.state.getAttributeSetVersion());
        AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched e = newAttributeUseMvoStateMergePatched(stateEventId);
        ((AbstractAttributeUseMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted newAttributeUseMvoStateDeleted(String commandId, String requesterId) {
        AttributeUseMvoStateEventId stateEventId = new AttributeUseMvoStateEventId(this.state.getAttributeSetAttributeUseId(), this.state.getAttributeSetVersion());
        AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted e = newAttributeUseMvoStateDeleted(stateEventId);
        ((AbstractAttributeUseMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected AttributeUseMvoStateEvent.AttributeUseMvoStateCreated newAttributeUseMvoStateCreated(AttributeUseMvoStateEventId stateEventId) {
        return new AbstractAttributeUseMvoStateEvent.SimpleAttributeUseMvoStateCreated(stateEventId);
    }

    protected AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched newAttributeUseMvoStateMergePatched(AttributeUseMvoStateEventId stateEventId) {
        return new AbstractAttributeUseMvoStateEvent.SimpleAttributeUseMvoStateMergePatched(stateEventId);
    }

    protected AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted newAttributeUseMvoStateDeleted(AttributeUseMvoStateEventId stateEventId)
    {
        return new AbstractAttributeUseMvoStateEvent.SimpleAttributeUseMvoStateDeleted(stateEventId);
    }


    public static class SimpleAttributeUseMvoAggregate extends AbstractAttributeUseMvoAggregate
    {
        public SimpleAttributeUseMvoAggregate(AttributeUseMvoState state) {
            super(state);
        }

    }

}

