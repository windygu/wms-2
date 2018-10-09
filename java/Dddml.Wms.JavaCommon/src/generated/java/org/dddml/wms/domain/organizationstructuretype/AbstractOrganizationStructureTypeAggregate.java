package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationStructureTypeAggregate extends AbstractAggregate implements OrganizationStructureTypeAggregate
{
    private OrganizationStructureTypeState.MutableOrganizationStructureTypeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrganizationStructureTypeAggregate(OrganizationStructureTypeState state)
    {
        this.state = (OrganizationStructureTypeState.MutableOrganizationStructureTypeState)state;
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
        OrganizationStructureTypeEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrganizationStructureTypeCommand.MergePatchOrganizationStructureType c)
    {
        OrganizationStructureTypeEvent e = map(c);
        apply(e);
    }

    public void delete(OrganizationStructureTypeCommand.DeleteOrganizationStructureType c)
    {
        OrganizationStructureTypeEvent e = map(c);
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

    protected OrganizationStructureTypeEvent map(OrganizationStructureTypeCommand.CreateOrganizationStructureType c) {
        OrganizationStructureTypeEventId stateEventId = new OrganizationStructureTypeEventId(c.getId(), c.getVersion());
        OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated e = newOrganizationStructureTypeStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractOrganizationStructureTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeEvent map(OrganizationStructureTypeCommand.MergePatchOrganizationStructureType c) {
        OrganizationStructureTypeEventId stateEventId = new OrganizationStructureTypeEventId(c.getId(), c.getVersion());
        OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched e = newOrganizationStructureTypeStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrganizationStructureTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeEvent map(OrganizationStructureTypeCommand.DeleteOrganizationStructureType c) {
        OrganizationStructureTypeEventId stateEventId = new OrganizationStructureTypeEventId(c.getId(), c.getVersion());
        OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted e = newOrganizationStructureTypeStateDeleted(stateEventId);
        ((AbstractOrganizationStructureTypeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated newOrganizationStructureTypeStateCreated(Long version, String commandId, String requesterId) {
        OrganizationStructureTypeEventId stateEventId = new OrganizationStructureTypeEventId(this.state.getId(), version);
        OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated e = newOrganizationStructureTypeStateCreated(stateEventId);
        ((AbstractOrganizationStructureTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched newOrganizationStructureTypeStateMergePatched(Long version, String commandId, String requesterId) {
        OrganizationStructureTypeEventId stateEventId = new OrganizationStructureTypeEventId(this.state.getId(), version);
        OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched e = newOrganizationStructureTypeStateMergePatched(stateEventId);
        ((AbstractOrganizationStructureTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted newOrganizationStructureTypeStateDeleted(Long version, String commandId, String requesterId) {
        OrganizationStructureTypeEventId stateEventId = new OrganizationStructureTypeEventId(this.state.getId(), version);
        OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted e = newOrganizationStructureTypeStateDeleted(stateEventId);
        ((AbstractOrganizationStructureTypeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated newOrganizationStructureTypeStateCreated(OrganizationStructureTypeEventId stateEventId) {
        return new AbstractOrganizationStructureTypeEvent.SimpleOrganizationStructureTypeStateCreated(stateEventId);
    }

    protected OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched newOrganizationStructureTypeStateMergePatched(OrganizationStructureTypeEventId stateEventId) {
        return new AbstractOrganizationStructureTypeEvent.SimpleOrganizationStructureTypeStateMergePatched(stateEventId);
    }

    protected OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted newOrganizationStructureTypeStateDeleted(OrganizationStructureTypeEventId stateEventId)
    {
        return new AbstractOrganizationStructureTypeEvent.SimpleOrganizationStructureTypeStateDeleted(stateEventId);
    }

    public static class SimpleOrganizationStructureTypeAggregate extends AbstractOrganizationStructureTypeAggregate
    {
        public SimpleOrganizationStructureTypeAggregate(OrganizationStructureTypeState state) {
            super(state);
        }

    }

}

