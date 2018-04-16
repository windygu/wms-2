package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureTypeStateEventDtoConverter {

    public OrganizationStructureTypeStateEventDto toOrganizationStructureTypeStateEventDto(AbstractOrganizationStructureTypeEvent stateEvent) {
        if (stateEvent instanceof AbstractOrganizationStructureTypeEvent.AbstractOrganizationStructureTypeStateCreated) {
            OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated e = (OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated) stateEvent;
            return toOrganizationStructureTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureTypeEvent.AbstractOrganizationStructureTypeStateMergePatched) {
            OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched e = (OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched) stateEvent;
            return toOrganizationStructureTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureTypeEvent.AbstractOrganizationStructureTypeStateDeleted) {
            OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted e = (OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted) stateEvent;
            return toOrganizationStructureTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateCreatedDto toOrganizationStructureTypeStateCreatedDto(OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated e) {
        OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateCreatedDto dto = new OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateCreatedDto();
        dto.setOrganizationStructureTypeEventId(e.getOrganizationStructureTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateMergePatchedDto toOrganizationStructureTypeStateMergePatchedDto(OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched e) {
        OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateMergePatchedDto dto = new OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateMergePatchedDto();
        dto.setOrganizationStructureTypeEventId(e.getOrganizationStructureTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateDeletedDto toOrganizationStructureTypeStateDeletedDto(OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted e) {
        OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateDeletedDto dto = new OrganizationStructureTypeStateEventDto.OrganizationStructureTypeStateDeletedDto();
        dto.setOrganizationStructureTypeEventId(e.getOrganizationStructureTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

