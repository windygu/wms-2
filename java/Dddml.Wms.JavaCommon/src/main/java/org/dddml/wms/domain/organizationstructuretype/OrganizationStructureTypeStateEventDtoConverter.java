package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureTypeStateEventDtoConverter {

    public OrganizationStructureTypeStateEventDto toOrganizationStructureTypeStateEventDto(AbstractOrganizationStructureTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrganizationStructureTypeStateEvent.AbstractOrganizationStructureTypeStateCreated) {
            OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated e = (OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated) stateEvent;
            return toOrganizationStructureTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureTypeStateEvent.AbstractOrganizationStructureTypeStateMergePatched) {
            OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched e = (OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched) stateEvent;
            return toOrganizationStructureTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureTypeStateEvent.AbstractOrganizationStructureTypeStateDeleted) {
            OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted e = (OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted) stateEvent;
            return toOrganizationStructureTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateCreatedDto toOrganizationStructureTypeStateCreatedDto(OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated e) {
        OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateCreatedDto dto = new OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateCreatedDto();
        dto.setStateEventId(new OrganizationStructureTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateMergePatchedDto toOrganizationStructureTypeStateMergePatchedDto(OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateMergePatched e) {
        OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateMergePatchedDto dto = new OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateMergePatchedDto();
        dto.setStateEventId(new OrganizationStructureTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateDeletedDto toOrganizationStructureTypeStateDeletedDto(OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateDeleted e) {
        OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateDeletedDto dto = new OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateDeletedDto();
        dto.setStateEventId(new OrganizationStructureTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

