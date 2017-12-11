package org.dddml.wms.domain.organization;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationAggregate extends AbstractAggregate implements OrganizationAggregate
{
    private OrganizationState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrganizationAggregate(OrganizationState state)
    {
        this.state = state;
    }

    public OrganizationState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrganizationCommand.CreateOrganization c)
    {
        if (c.getVersion() == null) { c.setVersion(OrganizationState.VERSION_NULL); }
        OrganizationStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrganizationCommand.MergePatchOrganization c)
    {
        OrganizationStateEvent e = map(c);
        apply(e);
    }

    public void delete(OrganizationCommand.DeleteOrganization c)
    {
        OrganizationStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrganizationCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrganizationStateEvent map(OrganizationCommand.CreateOrganization c) {
        OrganizationStateEventId stateEventId = new OrganizationStateEventId(c.getOrganizationId(), c.getVersion());
        OrganizationStateEvent.OrganizationStateCreated e = newOrganizationStateCreated(stateEventId);
        e.setName(c.getName());
        e.setDescription(c.getDescription());
        e.setType(c.getType());
        e.setIsSummary(c.getIsSummary());
        e.setActive(c.getActive());
        ((AbstractOrganizationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent map(OrganizationCommand.MergePatchOrganization c) {
        OrganizationStateEventId stateEventId = new OrganizationStateEventId(c.getOrganizationId(), c.getVersion());
        OrganizationStateEvent.OrganizationStateMergePatched e = newOrganizationStateMergePatched(stateEventId);
        e.setName(c.getName());
        e.setDescription(c.getDescription());
        e.setType(c.getType());
        e.setIsSummary(c.getIsSummary());
        e.setActive(c.getActive());
        e.setIsPropertyNameRemoved(c.getIsPropertyNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyTypeRemoved(c.getIsPropertyTypeRemoved());
        e.setIsPropertyIsSummaryRemoved(c.getIsPropertyIsSummaryRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrganizationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent map(OrganizationCommand.DeleteOrganization c) {
        OrganizationStateEventId stateEventId = new OrganizationStateEventId(c.getOrganizationId(), c.getVersion());
        OrganizationStateEvent.OrganizationStateDeleted e = newOrganizationStateDeleted(stateEventId);
        ((AbstractOrganizationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrganizationStateEvent.OrganizationStateCreated newOrganizationStateCreated(String commandId, String requesterId) {
        OrganizationStateEventId stateEventId = new OrganizationStateEventId(this.state.getOrganizationId(), this.state.getVersion());
        OrganizationStateEvent.OrganizationStateCreated e = newOrganizationStateCreated(stateEventId);
        ((AbstractOrganizationStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent.OrganizationStateMergePatched newOrganizationStateMergePatched(String commandId, String requesterId) {
        OrganizationStateEventId stateEventId = new OrganizationStateEventId(this.state.getOrganizationId(), this.state.getVersion());
        OrganizationStateEvent.OrganizationStateMergePatched e = newOrganizationStateMergePatched(stateEventId);
        ((AbstractOrganizationStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent.OrganizationStateDeleted newOrganizationStateDeleted(String commandId, String requesterId) {
        OrganizationStateEventId stateEventId = new OrganizationStateEventId(this.state.getOrganizationId(), this.state.getVersion());
        OrganizationStateEvent.OrganizationStateDeleted e = newOrganizationStateDeleted(stateEventId);
        ((AbstractOrganizationStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent.OrganizationStateCreated newOrganizationStateCreated(OrganizationStateEventId stateEventId) {
        return new AbstractOrganizationStateEvent.SimpleOrganizationStateCreated(stateEventId);
    }

    protected OrganizationStateEvent.OrganizationStateMergePatched newOrganizationStateMergePatched(OrganizationStateEventId stateEventId) {
        return new AbstractOrganizationStateEvent.SimpleOrganizationStateMergePatched(stateEventId);
    }

    protected OrganizationStateEvent.OrganizationStateDeleted newOrganizationStateDeleted(OrganizationStateEventId stateEventId)
    {
        return new AbstractOrganizationStateEvent.SimpleOrganizationStateDeleted(stateEventId);
    }


    public static class SimpleOrganizationAggregate extends AbstractOrganizationAggregate
    {
        public SimpleOrganizationAggregate(OrganizationState state) {
            super(state);
        }

    }

}

