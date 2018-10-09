package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPartyAggregate extends AbstractAggregate implements PartyAggregate
{
    private PartyState.MutablePartyState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPartyAggregate(PartyState state)
    {
        this.state = (PartyState.MutablePartyState)state;
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
        PartyEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PartyCommand.MergePatchParty c)
    {
        PartyEvent e = map(c);
        apply(e);
    }

    public void delete(PartyCommand.DeleteParty c)
    {
        PartyEvent e = map(c);
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

    protected PartyEvent map(PartyCommand.CreateParty c) {
        if(PartyTypeIds.PARTY.equals(c.getPartyTypeId())) {
            return mapToPartyEvent(c);
        }
        if(PartyTypeIds.ORGANIZATION.equals(c.getPartyTypeId())) {
            return mapToOrganizationEvent(c);
        }
        if(PartyTypeIds.PERSON.equals(c.getPartyTypeId())) {
            return mapToPersonEvent(c);
        }
        return mapToPartyEvent(c);
    }

    protected PartyEvent mapToPartyEvent(PartyCommand.CreateParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        PartyEvent.PartyStateCreated e = newPartyStateCreated(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setPrimaryRoleTypeId(c.getPrimaryRoleTypeId());
        e.setExternalId(c.getExternalId());
        e.setPreferredCurrencyUomId(c.getPreferredCurrencyUomId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationEvent mapToOrganizationEvent(PartyCommand.CreateParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        OrganizationEvent.OrganizationStateCreated e = newOrganizationStateCreated(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setPrimaryRoleTypeId(c.getPrimaryRoleTypeId());
        e.setExternalId(c.getExternalId());
        e.setPreferredCurrencyUomId(c.getPreferredCurrencyUomId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setOrganizationName(c.getOrganizationName());
        e.setIsSummary(c.getIsSummary());
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PersonEvent mapToPersonEvent(PartyCommand.CreateParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        PersonEvent.PersonStateCreated e = newPersonStateCreated(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setPrimaryRoleTypeId(c.getPrimaryRoleTypeId());
        e.setExternalId(c.getExternalId());
        e.setPreferredCurrencyUomId(c.getPreferredCurrencyUomId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setSalutation(c.getSalutation());
        e.setFirstName(c.getFirstName());
        e.setMiddleName(c.getMiddleName());
        e.setLastName(c.getLastName());
        e.setPersonalTitle(c.getPersonalTitle());
        e.setNickname(c.getNickname());
        e.setCardId(c.getCardId());
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyEvent map(PartyCommand.MergePatchParty c) {
        if(c.getPartyTypeId().equals(PartyTypeIds.PARTY)) {
            return mapToPartyEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.ORGANIZATION)) {
            return mapToOrganizationEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.PERSON)) {
            return mapToPersonEvent(c);
        }
        return mapToPartyEvent(c);
    }

    protected PartyEvent mapToPartyEvent(PartyCommand.MergePatchParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        PartyEvent.PartyStateMergePatched e = newPartyStateMergePatched(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setPrimaryRoleTypeId(c.getPrimaryRoleTypeId());
        e.setExternalId(c.getExternalId());
        e.setPreferredCurrencyUomId(c.getPreferredCurrencyUomId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setIsPropertyPartyTypeIdRemoved(c.getIsPropertyPartyTypeIdRemoved());
        e.setIsPropertyPrimaryRoleTypeIdRemoved(c.getIsPropertyPrimaryRoleTypeIdRemoved());
        e.setIsPropertyExternalIdRemoved(c.getIsPropertyExternalIdRemoved());
        e.setIsPropertyPreferredCurrencyUomIdRemoved(c.getIsPropertyPreferredCurrencyUomIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationEvent mapToOrganizationEvent(PartyCommand.MergePatchParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        OrganizationEvent.OrganizationStateMergePatched e = newOrganizationStateMergePatched(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setPrimaryRoleTypeId(c.getPrimaryRoleTypeId());
        e.setExternalId(c.getExternalId());
        e.setPreferredCurrencyUomId(c.getPreferredCurrencyUomId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setOrganizationName(c.getOrganizationName());
        e.setIsSummary(c.getIsSummary());
        e.setIsPropertyOrganizationNameRemoved(c.getIsPropertyOrganizationNameRemoved());
        e.setIsPropertyIsSummaryRemoved(c.getIsPropertyIsSummaryRemoved());
        e.setIsPropertyPartyTypeIdRemoved(c.getIsPropertyPartyTypeIdRemoved());
        e.setIsPropertyPrimaryRoleTypeIdRemoved(c.getIsPropertyPrimaryRoleTypeIdRemoved());
        e.setIsPropertyExternalIdRemoved(c.getIsPropertyExternalIdRemoved());
        e.setIsPropertyPreferredCurrencyUomIdRemoved(c.getIsPropertyPreferredCurrencyUomIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PersonEvent mapToPersonEvent(PartyCommand.MergePatchParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        PersonEvent.PersonStateMergePatched e = newPersonStateMergePatched(stateEventId);
        e.setPartyTypeId(c.getPartyTypeId());
        e.setPrimaryRoleTypeId(c.getPrimaryRoleTypeId());
        e.setExternalId(c.getExternalId());
        e.setPreferredCurrencyUomId(c.getPreferredCurrencyUomId());
        e.setDescription(c.getDescription());
        e.setActive(c.getActive());
        e.setSalutation(c.getSalutation());
        e.setFirstName(c.getFirstName());
        e.setMiddleName(c.getMiddleName());
        e.setLastName(c.getLastName());
        e.setPersonalTitle(c.getPersonalTitle());
        e.setNickname(c.getNickname());
        e.setCardId(c.getCardId());
        e.setIsPropertySalutationRemoved(c.getIsPropertySalutationRemoved());
        e.setIsPropertyFirstNameRemoved(c.getIsPropertyFirstNameRemoved());
        e.setIsPropertyMiddleNameRemoved(c.getIsPropertyMiddleNameRemoved());
        e.setIsPropertyLastNameRemoved(c.getIsPropertyLastNameRemoved());
        e.setIsPropertyPersonalTitleRemoved(c.getIsPropertyPersonalTitleRemoved());
        e.setIsPropertyNicknameRemoved(c.getIsPropertyNicknameRemoved());
        e.setIsPropertyCardIdRemoved(c.getIsPropertyCardIdRemoved());
        e.setIsPropertyPartyTypeIdRemoved(c.getIsPropertyPartyTypeIdRemoved());
        e.setIsPropertyPrimaryRoleTypeIdRemoved(c.getIsPropertyPrimaryRoleTypeIdRemoved());
        e.setIsPropertyExternalIdRemoved(c.getIsPropertyExternalIdRemoved());
        e.setIsPropertyPreferredCurrencyUomIdRemoved(c.getIsPropertyPreferredCurrencyUomIdRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyEvent map(PartyCommand.DeleteParty c) {
        if(c.getPartyTypeId().equals(PartyTypeIds.PARTY)) {
            return mapToPartyEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.ORGANIZATION)) {
            return mapToOrganizationEvent(c);
        }
        if(c.getPartyTypeId().equals(PartyTypeIds.PERSON)) {
            return mapToPersonEvent(c);
        }
        return mapToPartyEvent(c);
    }

    protected PartyEvent mapToPartyEvent(PartyCommand.DeleteParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        PartyEvent.PartyStateDeleted e = newPartyStateDeleted(stateEventId);
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrganizationEvent mapToOrganizationEvent(PartyCommand.DeleteParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        OrganizationEvent.OrganizationStateDeleted e = newOrganizationStateDeleted(stateEventId);
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PersonEvent mapToPersonEvent(PartyCommand.DeleteParty c) {
        PartyEventId stateEventId = new PartyEventId(c.getPartyId(), c.getVersion());
        PersonEvent.PersonStateDeleted e = newPersonStateDeleted(stateEventId);
        ((AbstractPartyEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PartyEvent.PartyStateCreated newPartyStateCreated(Long version, String commandId, String requesterId) {
        PartyEventId stateEventId = new PartyEventId(this.state.getPartyId(), version);
        PartyEvent.PartyStateCreated e = newPartyStateCreated(stateEventId);
        ((AbstractPartyEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyEvent.PartyStateMergePatched newPartyStateMergePatched(Long version, String commandId, String requesterId) {
        PartyEventId stateEventId = new PartyEventId(this.state.getPartyId(), version);
        PartyEvent.PartyStateMergePatched e = newPartyStateMergePatched(stateEventId);
        ((AbstractPartyEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyEvent.PartyStateDeleted newPartyStateDeleted(Long version, String commandId, String requesterId) {
        PartyEventId stateEventId = new PartyEventId(this.state.getPartyId(), version);
        PartyEvent.PartyStateDeleted e = newPartyStateDeleted(stateEventId);
        ((AbstractPartyEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyEvent.PartyStateCreated newPartyStateCreated(PartyEventId stateEventId) {
        return new AbstractPartyEvent.SimplePartyStateCreated(stateEventId);
    }

    protected PartyEvent.PartyStateMergePatched newPartyStateMergePatched(PartyEventId stateEventId) {
        return new AbstractPartyEvent.SimplePartyStateMergePatched(stateEventId);
    }

    protected OrganizationEvent.OrganizationStateCreated newOrganizationStateCreated(PartyEventId stateEventId) {
        return new AbstractOrganizationEvent.SimpleOrganizationStateCreated(stateEventId);
    }

    protected OrganizationEvent.OrganizationStateMergePatched newOrganizationStateMergePatched(PartyEventId stateEventId) {
        return new AbstractOrganizationEvent.SimpleOrganizationStateMergePatched(stateEventId);
    }

    protected PersonEvent.PersonStateCreated newPersonStateCreated(PartyEventId stateEventId) {
        return new AbstractPersonEvent.SimplePersonStateCreated(stateEventId);
    }

    protected PersonEvent.PersonStateMergePatched newPersonStateMergePatched(PartyEventId stateEventId) {
        return new AbstractPersonEvent.SimplePersonStateMergePatched(stateEventId);
    }

    protected PartyEvent.PartyStateDeleted newPartyStateDeleted(PartyEventId stateEventId)
    {
        return new AbstractPartyEvent.SimplePartyStateDeleted(stateEventId);
    }

    protected OrganizationEvent.OrganizationStateDeleted newOrganizationStateDeleted(PartyEventId stateEventId)
    {
        return new AbstractOrganizationEvent.SimpleOrganizationStateDeleted(stateEventId);
    }

    protected PersonEvent.PersonStateDeleted newPersonStateDeleted(PartyEventId stateEventId)
    {
        return new AbstractPersonEvent.SimplePersonStateDeleted(stateEventId);
    }

    public static class SimplePartyAggregate extends AbstractPartyAggregate
    {
        public SimplePartyAggregate(PartyState state) {
            super(state);
        }

    }

}

