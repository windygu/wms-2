package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureStateEventDtoConverter {

    public OrganizationStructureStateEventDto toOrganizationStructureStateEventDto(AbstractOrganizationStructureStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrganizationStructureStateEvent.AbstractOrganizationStructureStateCreated) {
            OrganizationStructureStateEvent.OrganizationStructureStateCreated e = (OrganizationStructureStateEvent.OrganizationStructureStateCreated) stateEvent;
            return toOrganizationStructureStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureStateEvent.AbstractOrganizationStructureStateMergePatched) {
            OrganizationStructureStateEvent.OrganizationStructureStateMergePatched e = (OrganizationStructureStateEvent.OrganizationStructureStateMergePatched) stateEvent;
            return toOrganizationStructureStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrganizationStructureStateEvent.AbstractOrganizationStructureStateDeleted) {
            OrganizationStructureStateEvent.OrganizationStructureStateDeleted e = (OrganizationStructureStateEvent.OrganizationStructureStateDeleted) stateEvent;
            return toOrganizationStructureStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto toOrganizationStructureStateCreatedDto(OrganizationStructureStateEvent.OrganizationStructureStateCreated e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto();
        dto.setOrganizationStructureEventId(e.getOrganizationStructureEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto toOrganizationStructureStateMergePatchedDto(OrganizationStructureStateEvent.OrganizationStructureStateMergePatched e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto();
        dto.setOrganizationStructureEventId(e.getOrganizationStructureEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto toOrganizationStructureStateDeletedDto(OrganizationStructureStateEvent.OrganizationStructureStateDeleted e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto();
        dto.setOrganizationStructureEventId(e.getOrganizationStructureEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

