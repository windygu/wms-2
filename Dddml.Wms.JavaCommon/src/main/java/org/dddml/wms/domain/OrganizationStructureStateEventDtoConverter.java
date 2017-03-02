package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureStateEventDtoConverter {

    public OrganizationStructureStateEventDto toOrganizationStructureStateEventDto(AbstractOrganizationStructureStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            OrganizationStructureStateEvent.OrganizationStructureStateCreated e = (OrganizationStructureStateEvent.OrganizationStructureStateCreated) stateEvent;
            return toOrganizationStructureStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            OrganizationStructureStateEvent.OrganizationStructureStateMergePatched e = (OrganizationStructureStateEvent.OrganizationStructureStateMergePatched) stateEvent;
            return toOrganizationStructureStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            OrganizationStructureStateEvent.OrganizationStructureStateDeleted e = (OrganizationStructureStateEvent.OrganizationStructureStateDeleted) stateEvent;
            return toOrganizationStructureStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto toOrganizationStructureStateCreatedDto(OrganizationStructureStateEvent.OrganizationStructureStateCreated e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateCreatedDto();
        dto.setStateEventId(new OrganizationStructureStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto toOrganizationStructureStateMergePatchedDto(OrganizationStructureStateEvent.OrganizationStructureStateMergePatched e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateMergePatchedDto();
        dto.setStateEventId(new OrganizationStructureStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto toOrganizationStructureStateDeletedDto(OrganizationStructureStateEvent.OrganizationStructureStateDeleted e) {
        OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto dto = new OrganizationStructureStateEventDto.OrganizationStructureStateDeletedDto();
        dto.setStateEventId(new OrganizationStructureStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

