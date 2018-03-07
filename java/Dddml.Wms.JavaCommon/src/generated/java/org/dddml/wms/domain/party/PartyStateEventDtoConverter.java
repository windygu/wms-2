package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PartyStateEventDtoConverter {

    public PartyStateEventDto toPartyStateEventDto(AbstractPartyStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrganizationStateEvent.AbstractOrganizationStateCreated) {
            OrganizationStateEvent.OrganizationStateCreated e = (OrganizationStateEvent.OrganizationStateCreated) stateEvent;
            return toPartyStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStateEvent.AbstractOrganizationStateMergePatched) {
            OrganizationStateEvent.OrganizationStateMergePatched e = (OrganizationStateEvent.OrganizationStateMergePatched) stateEvent;
            return toPartyStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStateEvent.AbstractOrganizationStateDeleted) {
            OrganizationStateEvent.OrganizationStateDeleted e = (OrganizationStateEvent.OrganizationStateDeleted) stateEvent;
            return toPartyStateDeletedDto(e);
        } else if (stateEvent instanceof AbstractPartyStateEvent.AbstractPartyStateCreated) {
            PartyStateEvent.PartyStateCreated e = (PartyStateEvent.PartyStateCreated) stateEvent;
            return toPartyStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPartyStateEvent.AbstractPartyStateMergePatched) {
            PartyStateEvent.PartyStateMergePatched e = (PartyStateEvent.PartyStateMergePatched) stateEvent;
            return toPartyStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPartyStateEvent.AbstractPartyStateDeleted) {
            PartyStateEvent.PartyStateDeleted e = (PartyStateEvent.PartyStateDeleted) stateEvent;
            return toPartyStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PartyStateEventDto.PartyStateCreatedDto toPartyStateCreatedDto(PartyStateEvent.PartyStateCreated e) {
        PartyStateEventDto.PartyStateCreatedDto dto = new PartyStateEventDto.PartyStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setActive(e.getActive());
        return dto;
    }

    public PartyStateEventDto.PartyStateMergePatchedDto toPartyStateMergePatchedDto(PartyStateEvent.PartyStateMergePatched e) {
        PartyStateEventDto.PartyStateMergePatchedDto dto = new PartyStateEventDto.PartyStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setActive(e.getActive());
        dto.setIsPropertyPartyTypeIdRemoved(e.getIsPropertyPartyTypeIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PartyStateEventDto.PartyStateDeletedDto toPartyStateDeletedDto(PartyStateEvent.PartyStateDeleted e) {
        PartyStateEventDto.PartyStateDeletedDto dto = new PartyStateEventDto.PartyStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

    public PartyStateEventDto.PartyStateCreatedDto toPartyStateCreatedDto(OrganizationStateEvent.OrganizationStateCreated e) {
        PartyStateEventDto.PartyStateCreatedDto dto = new PartyStateEventDto.PartyStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setActive(e.getActive());
        dto.setOrganizationName(e.getOrganizationName());
        dto.setDescription(e.getDescription());
        dto.setType(e.getType());
        dto.setIsSummary(e.getIsSummary());
        return dto;
    }

    public PartyStateEventDto.PartyStateMergePatchedDto toPartyStateMergePatchedDto(OrganizationStateEvent.OrganizationStateMergePatched e) {
        PartyStateEventDto.PartyStateMergePatchedDto dto = new PartyStateEventDto.PartyStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPartyTypeId(e.getPartyTypeId());
        dto.setActive(e.getActive());
        dto.setOrganizationName(e.getOrganizationName());
        dto.setDescription(e.getDescription());
        dto.setType(e.getType());
        dto.setIsSummary(e.getIsSummary());
        dto.setIsPropertyPartyTypeIdRemoved(e.getIsPropertyPartyTypeIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyOrganizationNameRemoved(e.getIsPropertyOrganizationNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyTypeRemoved(e.getIsPropertyTypeRemoved());
        dto.setIsPropertyIsSummaryRemoved(e.getIsPropertyIsSummaryRemoved());
        return dto;
    }


    public PartyStateEventDto.PartyStateDeletedDto toPartyStateDeletedDto(OrganizationStateEvent.OrganizationStateDeleted e) {
        PartyStateEventDto.PartyStateDeletedDto dto = new PartyStateEventDto.PartyStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

