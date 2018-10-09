package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationStructureAggregate extends AbstractAggregate implements OrganizationStructureAggregate
{
    private OrganizationStructureState.MutableOrganizationStructureState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrganizationStructureAggregate(OrganizationStructureState state)
    {
        this.state = (OrganizationStructureState.MutableOrganizationStructureState)state;
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
        OrganizationStructureEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrganizationStructureCommand.MergePatchOrganizationStructure c)
    {
        OrganizationStructureEvent e = map(c);
        apply(e);
    }

    public void delete(OrganizationStructureCommand.DeleteOrganizationStructure c)
    {
        OrganizationStructureEvent e = map(c);
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

    protected OrganizationStructureEvent map(OrganizationStructureCommand.CreateOrganizationStructure c) {
        OrganizationStructureEventId stateEventId = new OrganizationStructureEventId(c.getId(), c.getVersion());
        OrganizationStructureEvent.OrganizationStructureStateCreated e = newOrganizationStructureStateCreated(stateEventId);
        e.setActive(c.getActive());
        ((AbstractOrganizationStructureEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureEvent map(OrganizationStructureCommand.MergePatchOrganizationStructure c) {
        OrganizationStructureEventId stateEventId = new OrganizationStructureEventId(c.getId(), c.getVersion());
        OrganizationStructureEvent.OrganizationStructureStateMergePatched e = newOrganizationStructureStateMergePatched(stateEventId);
        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrganizationStructureEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureEvent map(OrganizationStructureCommand.DeleteOrganizationStructure c) {
        OrganizationStructureEventId stateEventId = new OrganizationStructureEventId(c.getId(), c.getVersion());
        OrganizationStructureEvent.OrganizationStructureStateDeleted e = newOrganizationStructureStateDeleted(stateEventId);
        ((AbstractOrganizationStructureEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrganizationStructureEvent.OrganizationStructureStateCreated newOrganizationStructureStateCreated(Long version, String commandId, String requesterId) {
        OrganizationStructureEventId stateEventId = new OrganizationStructureEventId(this.state.getId(), version);
        OrganizationStructureEvent.OrganizationStructureStateCreated e = newOrganizationStructureStateCreated(stateEventId);
        ((AbstractOrganizationStructureEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureEvent.OrganizationStructureStateMergePatched newOrganizationStructureStateMergePatched(Long version, String commandId, String requesterId) {
        OrganizationStructureEventId stateEventId = new OrganizationStructureEventId(this.state.getId(), version);
        OrganizationStructureEvent.OrganizationStructureStateMergePatched e = newOrganizationStructureStateMergePatched(stateEventId);
        ((AbstractOrganizationStructureEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureEvent.OrganizationStructureStateDeleted newOrganizationStructureStateDeleted(Long version, String commandId, String requesterId) {
        OrganizationStructureEventId stateEventId = new OrganizationStructureEventId(this.state.getId(), version);
        OrganizationStructureEvent.OrganizationStructureStateDeleted e = newOrganizationStructureStateDeleted(stateEventId);
        ((AbstractOrganizationStructureEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureEvent.OrganizationStructureStateCreated newOrganizationStructureStateCreated(OrganizationStructureEventId stateEventId) {
        return new AbstractOrganizationStructureEvent.SimpleOrganizationStructureStateCreated(stateEventId);
    }

    protected OrganizationStructureEvent.OrganizationStructureStateMergePatched newOrganizationStructureStateMergePatched(OrganizationStructureEventId stateEventId) {
        return new AbstractOrganizationStructureEvent.SimpleOrganizationStructureStateMergePatched(stateEventId);
    }

    protected OrganizationStructureEvent.OrganizationStructureStateDeleted newOrganizationStructureStateDeleted(OrganizationStructureEventId stateEventId)
    {
        return new AbstractOrganizationStructureEvent.SimpleOrganizationStructureStateDeleted(stateEventId);
    }

    public static class SimpleOrganizationStructureAggregate extends AbstractOrganizationStructureAggregate
    {
        public SimpleOrganizationStructureAggregate(OrganizationStructureState state) {
            super(state);
        }

    }

}

