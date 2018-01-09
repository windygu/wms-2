package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationStructureAggregate extends AbstractAggregate implements OrganizationStructureAggregate
{
    private OrganizationStructureState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrganizationStructureAggregate(OrganizationStructureState state)
    {
        this.state = state;
    }

    public OrganizationStructureState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrganizationStructureCommand.CreateOrganizationStructure c)
    {
        if (c.getVersion() == null) { c.setVersion(OrganizationStructureState.VERSION_NULL); }
        OrganizationStructureStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrganizationStructureCommand.MergePatchOrganizationStructure c)
    {
        OrganizationStructureStateEvent e = map(c);
        apply(e);
    }

    public void delete(OrganizationStructureCommand.DeleteOrganizationStructure c)
    {
        OrganizationStructureStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrganizationStructureCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrganizationStructureStateEvent map(OrganizationStructureCommand.CreateOrganizationStructure c) {
        OrganizationStructureStateEventId stateEventId = new OrganizationStructureStateEventId(c.getId(), c.getVersion());
        OrganizationStructureStateEvent.OrganizationStructureStateCreated e = newOrganizationStructureStateCreated(stateEventId);
        e.setActive(c.getActive());
        ((AbstractOrganizationStructureStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureStateEvent map(OrganizationStructureCommand.MergePatchOrganizationStructure c) {
        OrganizationStructureStateEventId stateEventId = new OrganizationStructureStateEventId(c.getId(), c.getVersion());
        OrganizationStructureStateEvent.OrganizationStructureStateMergePatched e = newOrganizationStructureStateMergePatched(stateEventId);
        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrganizationStructureStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureStateEvent map(OrganizationStructureCommand.DeleteOrganizationStructure c) {
        OrganizationStructureStateEventId stateEventId = new OrganizationStructureStateEventId(c.getId(), c.getVersion());
        OrganizationStructureStateEvent.OrganizationStructureStateDeleted e = newOrganizationStructureStateDeleted(stateEventId);
        ((AbstractOrganizationStructureStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrganizationStructureStateEvent.OrganizationStructureStateCreated newOrganizationStructureStateCreated(Long version, String commandId, String requesterId) {
        OrganizationStructureStateEventId stateEventId = new OrganizationStructureStateEventId(this.state.getId(), version);
        OrganizationStructureStateEvent.OrganizationStructureStateCreated e = newOrganizationStructureStateCreated(stateEventId);
        ((AbstractOrganizationStructureStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureStateEvent.OrganizationStructureStateMergePatched newOrganizationStructureStateMergePatched(Long version, String commandId, String requesterId) {
        OrganizationStructureStateEventId stateEventId = new OrganizationStructureStateEventId(this.state.getId(), version);
        OrganizationStructureStateEvent.OrganizationStructureStateMergePatched e = newOrganizationStructureStateMergePatched(stateEventId);
        ((AbstractOrganizationStructureStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureStateEvent.OrganizationStructureStateDeleted newOrganizationStructureStateDeleted(Long version, String commandId, String requesterId) {
        OrganizationStructureStateEventId stateEventId = new OrganizationStructureStateEventId(this.state.getId(), version);
        OrganizationStructureStateEvent.OrganizationStructureStateDeleted e = newOrganizationStructureStateDeleted(stateEventId);
        ((AbstractOrganizationStructureStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureStateEvent.OrganizationStructureStateCreated newOrganizationStructureStateCreated(OrganizationStructureStateEventId stateEventId) {
        return new AbstractOrganizationStructureStateEvent.SimpleOrganizationStructureStateCreated(stateEventId);
    }

    protected OrganizationStructureStateEvent.OrganizationStructureStateMergePatched newOrganizationStructureStateMergePatched(OrganizationStructureStateEventId stateEventId) {
        return new AbstractOrganizationStructureStateEvent.SimpleOrganizationStructureStateMergePatched(stateEventId);
    }

    protected OrganizationStructureStateEvent.OrganizationStructureStateDeleted newOrganizationStructureStateDeleted(OrganizationStructureStateEventId stateEventId)
    {
        return new AbstractOrganizationStructureStateEvent.SimpleOrganizationStructureStateDeleted(stateEventId);
    }

    public static class SimpleOrganizationStructureAggregate extends AbstractOrganizationStructureAggregate
    {
        public SimpleOrganizationStructureAggregate(OrganizationStructureState state) {
            super(state);
        }

    }

}

