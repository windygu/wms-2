package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class RoleTypeStateEventDtoConverter {

    public RoleTypeStateEventDto toRoleTypeStateEventDto(AbstractRoleTypeEvent stateEvent) {
        if (stateEvent instanceof AbstractRoleTypeEvent.AbstractRoleTypeStateCreated) {
            RoleTypeEvent.RoleTypeStateCreated e = (RoleTypeEvent.RoleTypeStateCreated) stateEvent;
            return toRoleTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractRoleTypeEvent.AbstractRoleTypeStateMergePatched) {
            RoleTypeEvent.RoleTypeStateMergePatched e = (RoleTypeEvent.RoleTypeStateMergePatched) stateEvent;
            return toRoleTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractRoleTypeEvent.AbstractRoleTypeStateDeleted) {
            RoleTypeEvent.RoleTypeStateDeleted e = (RoleTypeEvent.RoleTypeStateDeleted) stateEvent;
            return toRoleTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public RoleTypeStateEventDto.RoleTypeStateCreatedDto toRoleTypeStateCreatedDto(RoleTypeEvent.RoleTypeStateCreated e) {
        RoleTypeStateEventDto.RoleTypeStateCreatedDto dto = new RoleTypeStateEventDto.RoleTypeStateCreatedDto();
        dto.setRoleTypeEventId(e.getRoleTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public RoleTypeStateEventDto.RoleTypeStateMergePatchedDto toRoleTypeStateMergePatchedDto(RoleTypeEvent.RoleTypeStateMergePatched e) {
        RoleTypeStateEventDto.RoleTypeStateMergePatchedDto dto = new RoleTypeStateEventDto.RoleTypeStateMergePatchedDto();
        dto.setRoleTypeEventId(e.getRoleTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyParentTypeIdRemoved(e.getIsPropertyParentTypeIdRemoved());
        dto.setIsPropertyHasTableRemoved(e.getIsPropertyHasTableRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public RoleTypeStateEventDto.RoleTypeStateDeletedDto toRoleTypeStateDeletedDto(RoleTypeEvent.RoleTypeStateDeleted e) {
        RoleTypeStateEventDto.RoleTypeStateDeletedDto dto = new RoleTypeStateEventDto.RoleTypeStateDeletedDto();
        dto.setRoleTypeEventId(e.getRoleTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

