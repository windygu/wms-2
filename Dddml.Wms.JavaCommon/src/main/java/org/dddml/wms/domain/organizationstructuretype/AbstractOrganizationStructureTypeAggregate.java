package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationStructureTypeAggregate extends AbstractAggregate implements OrganizationStructureTypeAggregate
{
    private OrganizationStructureTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrganizationStructureTypeAggregate(OrganizationStructureTypeState state)
    {
        this.state = state;
    }

    public OrganizationStructureTypeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrganizationStructureTypeCommand.CreateOrganizationStructureType c)
    {
        if (c.getVersion() == null) { c.setVersion(OrganizationStructureTypeState.VERSION_NULL); }
        OrganizationStructureTypeStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrganizationStructureTypeCommand.MergePatchOrganizationStructureType c)
    {
        OrganizationStructureTypeStateEvent e = map(c);
        apply(e);
    }

    public void delete(OrganizationStructureTypeCommand.DeleteOrganizationStructureType c)
    {
        OrganizationStructureTypeStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrganizationStructureTypeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrganizationStructureTypeStateEvent map(OrganizationStructureTypeCommand.CreateOrganizationStructureType c) {
        OrganizationStructureTypeStateEventId stateEventId = new OrganizationStructureTypeStateEventId(c.getId(), c.getVersion());
        OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated e = newOrganizationStructureTypeStateCreated(stateEventId);
        e.setActive(c.getActive());
        ((AbstractOrganizationStructureTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeStateEvent map(OrganizationStructureTypeCommand.MergePatchOrganizationStructureType c) {
        OrganizationStructureTypeStateEventId stateEventId = new OrganizationStructureTypeStateEventId(c.getId(), c.getVersion());
        OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched e = newOrganizationStructureTypeStateMergePatched(stateEventId);
        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrganizationStructureTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeStateEvent map(OrganizationStructureTypeCommand.DeleteOrganizationStructureType c) {
        OrganizationStructureTypeStateEventId stateEventId = new OrganizationStructureTypeStateEventId(c.getId(), c.getVersion());
        OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted e = newOrganizationStructureTypeStateDeleted(stateEventId);
        ((AbstractOrganizationStructureTypeStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated newOrganizationStructureTypeStateCreated(String commandId, String requesterId) {
        OrganizationStructureTypeStateEventId stateEventId = new OrganizationStructureTypeStateEventId(this.state.getId(), this.state.getVersion());
        OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated e = newOrganizationStructureTypeStateCreated(stateEventId);
        ((AbstractOrganizationStructureTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched newOrganizationStructureTypeStateMergePatched(String commandId, String requesterId) {
        OrganizationStructureTypeStateEventId stateEventId = new OrganizationStructureTypeStateEventId(this.state.getId(), this.state.getVersion());
        OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched e = newOrganizationStructureTypeStateMergePatched(stateEventId);
        ((AbstractOrganizationStructureTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted newOrganizationStructureTypeStateDeleted(String commandId, String requesterId) {
        OrganizationStructureTypeStateEventId stateEventId = new OrganizationStructureTypeStateEventId(this.state.getId(), this.state.getVersion());
        OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted e = newOrganizationStructureTypeStateDeleted(stateEventId);
        ((AbstractOrganizationStructureTypeStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated newOrganizationStructureTypeStateCreated(OrganizationStructureTypeStateEventId stateEventId) {
        return new AbstractOrganizationStructureTypeStateEvent.SimpleOrganizationStructureTypeStateCreated(stateEventId);
    }

    protected OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched newOrganizationStructureTypeStateMergePatched(OrganizationStructureTypeStateEventId stateEventId) {
        return new AbstractOrganizationStructureTypeStateEvent.SimpleOrganizationStructureTypeStateMergePatched(stateEventId);
    }

    protected OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted newOrganizationStructureTypeStateDeleted(OrganizationStructureTypeStateEventId stateEventId)
    {
        return new AbstractOrganizationStructureTypeStateEvent.SimpleOrganizationStructureTypeStateDeleted(stateEventId);
    }


    public static class SimpleOrganizationStructureTypeAggregate extends AbstractOrganizationStructureTypeAggregate
    {
        public SimpleOrganizationStructureTypeAggregate(OrganizationStructureTypeState state) {
            super(state);
        }

    }

}

