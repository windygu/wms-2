package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPartyAggregate extends AbstractAggregate implements PartyAggregate
{
    private PartyState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPartyAggregate(PartyState state)
    {
        this.state = state;
    }

    public PartyState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PartyCommand.CreateParty c)
    {
        if (c.getVersion() == null) { c.setVersion(PartyState.VERSION_NULL); }
        PartyStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PartyCommand.MergePatchParty c)
    {
        PartyStateEvent e = map(c);
        apply(e);
    }

    public void delete(PartyCommand.DeleteParty c)
    {
        PartyStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PartyCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PartyStateEvent map(PartyCommand.CreateParty c) {
        if(c.getPartyTypeId().equals(PartyTypeIds.PARTY)) {
            return mapToPartyEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.ORGANIZATION)) {
            return mapToOrganizationEvent(c);
        }
        return mapToPartyEvent(c);
    }

    protected PartyStateEvent mapToPartyEvent(PartyCommand.CreateParty c) {
        PartyStateEventId stateEventId = new PartyStateEventId(c.getPartyId(), c.getVersion());
        PartyStateEvent.PartyStateCreated e = newPartyStateCreated(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setActive(c.getActive());
        ((AbstractPartyStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent mapToOrganizationEvent(PartyCommand.CreateParty c) {
        PartyStateEventId stateEventId = new PartyStateEventId(c.getPartyId(), c.getVersion());
        OrganizationStateEvent.OrganizationStateCreated e = newOrganizationStateCreated(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setActive(c.getActive());
        e.setOrganizationName(c.getOrganizationName());
        e.setDescription(c.getDescription());
        e.setType(c.getType());
        e.setIsSummary(c.getIsSummary());
        ((AbstractOrganizationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyStateEvent map(PartyCommand.MergePatchParty c) {
        if(c.getPartyTypeId().equals(PartyTypeIds.PARTY)) {
            return mapToPartyEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.ORGANIZATION)) {
            return mapToOrganizationEvent(c);
        }
        return mapToPartyEvent(c);
    }

    protected PartyStateEvent mapToPartyEvent(PartyCommand.MergePatchParty c) {
        PartyStateEventId stateEventId = new PartyStateEventId(c.getPartyId(), c.getVersion());
        PartyStateEvent.PartyStateMergePatched e = newPartyStateMergePatched(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setActive(c.getActive());
        e.setIsPropertyPartyTypeIdRemoved(c.getIsPropertyPartyTypeIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPartyStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent mapToOrganizationEvent(PartyCommand.MergePatchParty c) {
        PartyStateEventId stateEventId = new PartyStateEventId(c.getPartyId(), c.getVersion());
        OrganizationStateEvent.OrganizationStateMergePatched e = newOrganizationStateMergePatched(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setActive(c.getActive());
        e.setOrganizationName(c.getOrganizationName());
        e.setDescription(c.getDescription());
        e.setType(c.getType());
        e.setIsSummary(c.getIsSummary());
        e.setIsPropertyOrganizationNameRemoved(c.getIsPropertyOrganizationNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyTypeRemoved(c.getIsPropertyTypeRemoved());
        e.setIsPropertyIsSummaryRemoved(c.getIsPropertyIsSummaryRemoved());
        e.setIsPropertyPartyTypeIdRemoved(c.getIsPropertyPartyTypeIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrganizationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyStateEvent map(PartyCommand.DeleteParty c) {
        if(c.getPartyTypeId().equals(PartyTypeIds.PARTY)) {
            return mapToPartyEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.ORGANIZATION)) {
            return mapToOrganizationEvent(c);
        }
        return mapToPartyEvent(c);
    }

    protected PartyStateEvent mapToPartyEvent(PartyCommand.DeleteParty c) {
        PartyStateEventId stateEventId = new PartyStateEventId(c.getPartyId(), c.getVersion());
        PartyStateEvent.PartyStateDeleted e = newPartyStateDeleted(stateEventId);
        ((AbstractPartyStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationStateEvent mapToOrganizationEvent(PartyCommand.DeleteParty c) {
        PartyStateEventId stateEventId = new PartyStateEventId(c.getPartyId(), c.getVersion());
        OrganizationStateEvent.OrganizationStateDeleted e = newOrganizationStateDeleted(stateEventId);
        ((AbstractOrganizationStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PartyStateEvent.PartyStateCreated newPartyStateCreated(Long version, String commandId, String requesterId) {
        PartyStateEventId stateEventId = new PartyStateEventId(this.state.getPartyId(), version);
        PartyStateEvent.PartyStateCreated e = newPartyStateCreated(stateEventId);
        ((AbstractPartyStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyStateEvent.PartyStateMergePatched newPartyStateMergePatched(Long version, String commandId, String requesterId) {
        PartyStateEventId stateEventId = new PartyStateEventId(this.state.getPartyId(), version);
        PartyStateEvent.PartyStateMergePatched e = newPartyStateMergePatched(stateEventId);
        ((AbstractPartyStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyStateEvent.PartyStateDeleted newPartyStateDeleted(Long version, String commandId, String requesterId) {
        PartyStateEventId stateEventId = new PartyStateEventId(this.state.getPartyId(), version);
        PartyStateEvent.PartyStateDeleted e = newPartyStateDeleted(stateEventId);
        ((AbstractPartyStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyStateEvent.PartyStateCreated newPartyStateCreated(PartyStateEventId stateEventId) {
        return new AbstractPartyStateEvent.SimplePartyStateCreated(stateEventId);
    }

    protected PartyStateEvent.PartyStateMergePatched newPartyStateMergePatched(PartyStateEventId stateEventId) {
        return new AbstractPartyStateEvent.SimplePartyStateMergePatched(stateEventId);
    }

    protected OrganizationStateEvent.OrganizationStateCreated newOrganizationStateCreated(PartyStateEventId stateEventId) {
        return new AbstractOrganizationStateEvent.SimpleOrganizationStateCreated(stateEventId);
    }

    protected OrganizationStateEvent.OrganizationStateMergePatched newOrganizationStateMergePatched(PartyStateEventId stateEventId) {
        return new AbstractOrganizationStateEvent.SimpleOrganizationStateMergePatched(stateEventId);
    }

    protected PartyStateEvent.PartyStateDeleted newPartyStateDeleted(PartyStateEventId stateEventId)
    {
        return new AbstractPartyStateEvent.SimplePartyStateDeleted(stateEventId);
    }

    protected OrganizationStateEvent.OrganizationStateDeleted newOrganizationStateDeleted(PartyStateEventId stateEventId)
    {
        return new AbstractOrganizationStateEvent.SimpleOrganizationStateDeleted(stateEventId);
    }

    public static class SimplePartyAggregate extends AbstractPartyAggregate
    {
        public SimplePartyAggregate(PartyState state) {
            super(state);
        }

    }

}

