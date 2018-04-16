package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PartyStateEventDtoConverter {

    public PartyStateEventDto toPartyStateEventDto(AbstractPartyEvent stateEvent) {
        if (stateEvent instanceof AbstractOrganizationEvent.AbstractOrganizationStateCreated) {
            OrganizationEvent.OrganizationStateCreated e = (OrganizationEvent.OrganizationStateCreated) stateEvent;
            return toPartyStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationEvent.AbstractOrganizationStateMergePatched) {
            OrganizationEvent.OrganizationStateMergePatched e = (OrganizationEvent.OrganizationStateMergePatched) stateEvent;
            return toPartyStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationEvent.AbstractOrganizationStateDeleted) {
            OrganizationEvent.OrganizationStateDeleted e = (OrganizationEvent.OrganizationStateDeleted) stateEvent;
            return toPartyStateDeletedDto(e);
        } else if (stateEvent instanceof AbstractPartyEvent.AbstractPartyStateCreated) {
            PartyEvent.PartyStateCreated e = (PartyEvent.PartyStateCreated) stateEvent;
            return toPartyStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPartyEvent.AbstractPartyStateMergePatched) {
            PartyEvent.PartyStateMergePatched e = (PartyEvent.PartyStateMergePatched) stateEvent;
            return toPartyStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPartyEvent.AbstractPartyStateDeleted) {
            PartyEvent.PartyStateDeleted e = (PartyEvent.PartyStateDeleted) stateEvent;
            return toPartyStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PartyStateEventDto.PartyStateCreatedDto toPartyStateCreatedDto(PartyEvent.PartyStateCreated e) {
        PartyStateEventDto.PartyStateCreatedDto dto = new PartyStateEventDto.PartyStateCreatedDto();
        dto.setPartyEventId(e.getPartyEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        dto.setActive(e.getActive());
        return dto;
    }

    public PartyStateEventDto.PartyStateMergePatchedDto toPartyStateMergePatchedDto(PartyEvent.PartyStateMergePatched e) {
        PartyStateEventDto.PartyStateMergePatchedDto dto = new PartyStateEventDto.PartyStateMergePatchedDto();
        dto.setPartyEventId(e.getPartyEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        dto.setActive(e.getActive());
        dto.setIsPropertyPartyTypeIdRemoved(e.getIsPropertyPartyTypeIdRemoved());
        dto.setIsPropertyPrimaryRoleTypeIdRemoved(e.getIsPropertyPrimaryRoleTypeIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PartyStateEventDto.PartyStateDeletedDto toPartyStateDeletedDto(PartyEvent.PartyStateDeleted e) {
        PartyStateEventDto.PartyStateDeletedDto dto = new PartyStateEventDto.PartyStateDeletedDto();
        dto.setPartyEventId(e.getPartyEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

    public PartyStateEventDto.PartyStateCreatedDto toPartyStateCreatedDto(OrganizationEvent.OrganizationStateCreated e) {
        PartyStateEventDto.PartyStateCreatedDto dto = new PartyStateEventDto.PartyStateCreatedDto();
        dto.setPartyEventId(e.getPartyEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        dto.setActive(e.getActive());
        dto.setOrganizationName(e.getOrganizationName());
        dto.setDescription(e.getDescription());
        dto.setType(e.getType());
        dto.setIsSummary(e.getIsSummary());
        return dto;
    }

    public PartyStateEventDto.PartyStateMergePatchedDto toPartyStateMergePatchedDto(OrganizationEvent.OrganizationStateMergePatched e) {
        PartyStateEventDto.PartyStateMergePatchedDto dto = new PartyStateEventDto.PartyStateMergePatchedDto();
        dto.setPartyEventId(e.getPartyEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        dto.setActive(e.getActive());
        dto.setOrganizationName(e.getOrganizationName());
        dto.setDescription(e.getDescription());
        dto.setType(e.getType());
        dto.setIsSummary(e.getIsSummary());
        dto.setIsPropertyPartyTypeIdRemoved(e.getIsPropertyPartyTypeIdRemoved());
        dto.setIsPropertyPrimaryRoleTypeIdRemoved(e.getIsPropertyPrimaryRoleTypeIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyOrganizationNameRemoved(e.getIsPropertyOrganizationNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyTypeRemoved(e.getIsPropertyTypeRemoved());
        dto.setIsPropertyIsSummaryRemoved(e.getIsPropertyIsSummaryRemoved());
        return dto;
    }


    public PartyStateEventDto.PartyStateDeletedDto toPartyStateDeletedDto(OrganizationEvent.OrganizationStateDeleted e) {
        PartyStateEventDto.PartyStateDeletedDto dto = new PartyStateEventDto.PartyStateDeletedDto();
        dto.setPartyEventId(e.getPartyEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

