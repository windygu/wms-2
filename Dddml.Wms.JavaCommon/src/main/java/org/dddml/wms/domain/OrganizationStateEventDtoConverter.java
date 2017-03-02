package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrganizationStateEventDtoConverter {

    public OrganizationStateEventDto toOrganizationStateEventDto(AbstractOrganizationStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            OrganizationStateEvent.OrganizationStateCreated e = (OrganizationStateEvent.OrganizationStateCreated) stateEvent;
            return toOrganizationStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            OrganizationStateEvent.OrganizationStateMergePatched e = (OrganizationStateEvent.OrganizationStateMergePatched) stateEvent;
            return toOrganizationStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            OrganizationStateEvent.OrganizationStateDeleted e = (OrganizationStateEvent.OrganizationStateDeleted) stateEvent;
            return toOrganizationStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrganizationStateEventDto.OrganizationStateCreatedDto toOrganizationStateCreatedDto(OrganizationStateEvent.OrganizationStateCreated e) {
        OrganizationStateEventDto.OrganizationStateCreatedDto dto = new OrganizationStateEventDto.OrganizationStateCreatedDto();
        dto.setStateEventId(new OrganizationStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setType(e.getType());
        dto.setIsSummary(e.getIsSummary());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrganizationStateEventDto.OrganizationStateMergePatchedDto toOrganizationStateMergePatchedDto(OrganizationStateEvent.OrganizationStateMergePatched e) {
        OrganizationStateEventDto.OrganizationStateMergePatchedDto dto = new OrganizationStateEventDto.OrganizationStateMergePatchedDto();
        dto.setStateEventId(new OrganizationStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setType(e.getType());
        dto.setIsSummary(e.getIsSummary());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyTypeRemoved(e.getIsPropertyTypeRemoved());
        dto.setIsPropertyIsSummaryRemoved(e.getIsPropertyIsSummaryRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrganizationStateEventDto.OrganizationStateDeletedDto toOrganizationStateDeletedDto(OrganizationStateEvent.OrganizationStateDeleted e) {
        OrganizationStateEventDto.OrganizationStateDeletedDto dto = new OrganizationStateEventDto.OrganizationStateDeletedDto();
        dto.setStateEventId(new OrganizationStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

