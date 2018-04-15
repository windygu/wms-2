package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureStateEventDtoConverter {

    public OrganizationStructureStateEventDto toOrganizationStructureStateEventDto(AbstractOrganizationStructureEvent stateEvent) {
        if (stateEvent instanceof AbstractOrganizationStructureEvent.AbstractOrganizationStructureStateCreated) {
            OrganizationStructureEvent.OrganizationStructureStateCreated e = (OrganizationStructureEvent.OrganizationStructureStateCreated) stateEvent;
            return toOrganizationStructureStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureEvent.AbstractOrganizationStructureStateMergePatched) {
            OrganizationStructureEvent.OrganizationStructureStateMergePatched e = (OrganizationStructureEvent.OrganizationStructureStateMergePatched) stateEvent;
            return toOrganizationStructureStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureEvent.AbstractOrganizationStructureStateDeleted) {
            OrganizationStructureEvent.OrganizationStructureStateDeleted e = (OrganizationStructureEvent.OrganizationStructureStateDeleted) stateEvent;
            return toOrganizationStructureStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto toOrganizationStructureStateCreatedDto(OrganizationStructureEvent.OrganizationStructureStateCreated e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto();
        dto.setOrganizationStructureEventId(e.getOrganizationStructureEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto toOrganizationStructureStateMergePatchedDto(OrganizationStructureEvent.OrganizationStructureStateMergePatched e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto();
        dto.setOrganizationStructureEventId(e.getOrganizationStructureEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto toOrganizationStructureStateDeletedDto(OrganizationStructureEvent.OrganizationStructureStateDeleted e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto();
        dto.setOrganizationStructureEventId(e.getOrganizationStructureEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

