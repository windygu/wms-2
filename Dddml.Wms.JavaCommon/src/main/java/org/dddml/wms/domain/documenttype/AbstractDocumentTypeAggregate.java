package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDocumentTypeAggregate extends AbstractAggregate implements DocumentTypeAggregate
{
    private DocumentTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractDocumentTypeAggregate(DocumentTypeState state)
    {
        this.state = state;
    }

    public DocumentTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(DocumentTypeCommand.CreateDocumentType c)
    {
        if (c.getVersion() == null) { c.setVersion(DocumentTypeState.VERSION_NULL); }
        DocumentTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(DocumentTypeCommand.MergePatchDocumentType c)
    {
        DocumentTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(DocumentTypeCommand.DeleteDocumentType c)
    {
        DocumentTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        DocumentTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected DocumentTypeStateEvent map(DocumentTypeCommand.CreateDocumentType c) {
        DocumentTypeStateEventId stateEventId = new DocumentTypeStateEventId(c.getDocumentTypeId(), c.getVersion());
        DocumentTypeStateEvent.DocumentTypeStateCreated e = newDocumentTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setParentDocumentTypeId(c.getParentDocumentTypeId());
        e.setActive(c.getActive());
        ((AbstractDocumentTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DocumentTypeStateEvent map(DocumentTypeCommand.MergePatchDocumentType c) {
        DocumentTypeStateEventId stateEventId = new DocumentTypeStateEventId(c.getDocumentTypeId(), c.getVersion());
        DocumentTypeStateEvent.DocumentTypeStateMergePatched e = newDocumentTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setParentDocumentTypeId(c.getParentDocumentTypeId());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyParentDocumentTypeIdRemoved(c.getIsPropertyParentDocumentTypeIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractDocumentTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DocumentTypeStateEvent map(DocumentTypeCommand.DeleteDocumentType c) {
        DocumentTypeStateEventId stateEventId = new DocumentTypeStateEventId(c.getDocumentTypeId(), c.getVersion());
        DocumentTypeStateEvent.DocumentTypeStateDeleted e = newDocumentTypeStateDeleted(stateEventId);
        ((AbstractDocumentTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected DocumentTypeStateEvent.DocumentTypeStateCreated newDocumentTypeStateCreated(String commandId, String requesterId) {
        DocumentTypeStateEventId stateEventId = new DocumentTypeStateEventId(this.state.getDocumentTypeId(), this.state.getVersion());
        DocumentTypeStateEvent.DocumentTypeStateCreated e = newDocumentTypeStateCreated(stateEventId);
        ((AbstractDocumentTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DocumentTypeStateEvent.DocumentTypeStateMergePatched newDocumentTypeStateMergePatched(String commandId, String requesterId) {
        DocumentTypeStateEventId stateEventId = new DocumentTypeStateEventId(this.state.getDocumentTypeId(), this.state.getVersion());
        DocumentTypeStateEvent.DocumentTypeStateMergePatched e = newDocumentTypeStateMergePatched(stateEventId);
        ((AbstractDocumentTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DocumentTypeStateEvent.DocumentTypeStateDeleted newDocumentTypeStateDeleted(String commandId, String requesterId) {
        DocumentTypeStateEventId stateEventId = new DocumentTypeStateEventId(this.state.getDocumentTypeId(), this.state.getVersion());
        DocumentTypeStateEvent.DocumentTypeStateDeleted e = newDocumentTypeStateDeleted(stateEventId);
        ((AbstractDocumentTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected DocumentTypeStateEvent.DocumentTypeStateCreated newDocumentTypeStateCreated(DocumentTypeStateEventId stateEventId) {
        return new AbstractDocumentTypeStateEvent.SimpleDocumentTypeStateCreated(stateEventId);
    }

    protected DocumentTypeStateEvent.DocumentTypeStateMergePatched newDocumentTypeStateMergePatched(DocumentTypeStateEventId stateEventId) {
        return new AbstractDocumentTypeStateEvent.SimpleDocumentTypeStateMergePatched(stateEventId);
    }

    protected DocumentTypeStateEvent.DocumentTypeStateDeleted newDocumentTypeStateDeleted(DocumentTypeStateEventId stateEventId)
    {
        return new AbstractDocumentTypeStateEvent.SimpleDocumentTypeStateDeleted(stateEventId);
    }


    public static class SimpleDocumentTypeAggregate extends AbstractDocumentTypeAggregate
    {
        public SimpleDocumentTypeAggregate(DocumentTypeState state) {
            super(state);
        }

    }

}

