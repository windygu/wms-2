package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class RoleTypeStateEventDtoConverter {

    public RoleTypeStateEventDto toRoleTypeStateEventDto(AbstractRoleTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractRoleTypeStateEvent.AbstractRoleTypeStateCreated) {
            RoleTypeStateEvent.RoleTypeStateCreated e = (RoleTypeStateEvent.RoleTypeStateCreated) stateEvent;
            return toRoleTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractRoleTypeStateEvent.AbstractRoleTypeStateMergePatched) {
            RoleTypeStateEvent.RoleTypeStateMergePatched e = (RoleTypeStateEvent.RoleTypeStateMergePatched) stateEvent;
            return toRoleTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractRoleTypeStateEvent.AbstractRoleTypeStateDeleted) {
            RoleTypeStateEvent.RoleTypeStateDeleted e = (RoleTypeStateEvent.RoleTypeStateDeleted) stateEvent;
            return toRoleTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public RoleTypeStateEventDto.RoleTypeStateCreatedDto toRoleTypeStateCreatedDto(RoleTypeStateEvent.RoleTypeStateCreated e) {
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

    public RoleTypeStateEventDto.RoleTypeStateMergePatchedDto toRoleTypeStateMergePatchedDto(RoleTypeStateEvent.RoleTypeStateMergePatched e) {
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


    public RoleTypeStateEventDto.RoleTypeStateDeletedDto toRoleTypeStateDeletedDto(RoleTypeStateEvent.RoleTypeStateDeleted e) {
        RoleTypeStateEventDto.RoleTypeStateDeletedDto dto = new RoleTypeStateEventDto.RoleTypeStateDeletedDto();
        dto.setRoleTypeEventId(e.getRoleTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

