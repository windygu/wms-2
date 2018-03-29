package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistRoleMvoStateEventDtoConverter {

    public PicklistRoleMvoStateEventDto toPicklistRoleMvoStateEventDto(AbstractPicklistRoleMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistRoleMvoStateEvent.AbstractPicklistRoleMvoStateCreated) {
            PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated e = (PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated) stateEvent;
            return toPicklistRoleMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistRoleMvoStateEvent.AbstractPicklistRoleMvoStateMergePatched) {
            PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched e = (PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched) stateEvent;
            return toPicklistRoleMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistRoleMvoStateEvent.AbstractPicklistRoleMvoStateDeleted) {
            PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted e = (PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted) stateEvent;
            return toPicklistRoleMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PicklistRoleMvoStateEventDto.PicklistRoleMvoStateCreatedDto toPicklistRoleMvoStateCreatedDto(PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated e) {
        PicklistRoleMvoStateEventDto.PicklistRoleMvoStateCreatedDto dto = new PicklistRoleMvoStateEventDto.PicklistRoleMvoStateCreatedDto();
        dto.setPicklistRoleMvoEventId(e.getPicklistRoleMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setCommandId(e.getCommandId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setPicklistDescription(e.getPicklistDescription());
        dto.setPicklistFacilityId(e.getPicklistFacilityId());
        dto.setPicklistShipmentMethodTypeId(e.getPicklistShipmentMethodTypeId());
        dto.setPicklistStatusId(e.getPicklistStatusId());
        dto.setPicklistPicklistDate(e.getPicklistPicklistDate());
        dto.setPicklistPickwaveId(e.getPicklistPickwaveId());
        dto.setPicklistCreatedBy(e.getPicklistCreatedBy());
        dto.setPicklistCreatedAt(e.getPicklistCreatedAt());
        dto.setPicklistUpdatedBy(e.getPicklistUpdatedBy());
        dto.setPicklistUpdatedAt(e.getPicklistUpdatedAt());
        dto.setPicklistActive(e.getPicklistActive());
        dto.setPicklistDeleted(e.getPicklistDeleted());
        return dto;
    }

    public PicklistRoleMvoStateEventDto.PicklistRoleMvoStateMergePatchedDto toPicklistRoleMvoStateMergePatchedDto(PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched e) {
        PicklistRoleMvoStateEventDto.PicklistRoleMvoStateMergePatchedDto dto = new PicklistRoleMvoStateEventDto.PicklistRoleMvoStateMergePatchedDto();
        dto.setPicklistRoleMvoEventId(e.getPicklistRoleMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setCommandId(e.getCommandId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setPicklistDescription(e.getPicklistDescription());
        dto.setPicklistFacilityId(e.getPicklistFacilityId());
        dto.setPicklistShipmentMethodTypeId(e.getPicklistShipmentMethodTypeId());
        dto.setPicklistStatusId(e.getPicklistStatusId());
        dto.setPicklistPicklistDate(e.getPicklistPicklistDate());
        dto.setPicklistPickwaveId(e.getPicklistPickwaveId());
        dto.setPicklistCreatedBy(e.getPicklistCreatedBy());
        dto.setPicklistCreatedAt(e.getPicklistCreatedAt());
        dto.setPicklistUpdatedBy(e.getPicklistUpdatedBy());
        dto.setPicklistUpdatedAt(e.getPicklistUpdatedAt());
        dto.setPicklistActive(e.getPicklistActive());
        dto.setPicklistDeleted(e.getPicklistDeleted());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyPicklistDescriptionRemoved(e.getIsPropertyPicklistDescriptionRemoved());
        dto.setIsPropertyPicklistFacilityIdRemoved(e.getIsPropertyPicklistFacilityIdRemoved());
        dto.setIsPropertyPicklistShipmentMethodTypeIdRemoved(e.getIsPropertyPicklistShipmentMethodTypeIdRemoved());
        dto.setIsPropertyPicklistStatusIdRemoved(e.getIsPropertyPicklistStatusIdRemoved());
        dto.setIsPropertyPicklistPicklistDateRemoved(e.getIsPropertyPicklistPicklistDateRemoved());
        dto.setIsPropertyPicklistPickwaveIdRemoved(e.getIsPropertyPicklistPickwaveIdRemoved());
        dto.setIsPropertyPicklistCreatedByRemoved(e.getIsPropertyPicklistCreatedByRemoved());
        dto.setIsPropertyPicklistCreatedAtRemoved(e.getIsPropertyPicklistCreatedAtRemoved());
        dto.setIsPropertyPicklistUpdatedByRemoved(e.getIsPropertyPicklistUpdatedByRemoved());
        dto.setIsPropertyPicklistUpdatedAtRemoved(e.getIsPropertyPicklistUpdatedAtRemoved());
        dto.setIsPropertyPicklistActiveRemoved(e.getIsPropertyPicklistActiveRemoved());
        dto.setIsPropertyPicklistDeletedRemoved(e.getIsPropertyPicklistDeletedRemoved());
        return dto;
    }


    public PicklistRoleMvoStateEventDto.PicklistRoleMvoStateDeletedDto toPicklistRoleMvoStateDeletedDto(PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted e) {
        PicklistRoleMvoStateEventDto.PicklistRoleMvoStateDeletedDto dto = new PicklistRoleMvoStateEventDto.PicklistRoleMvoStateDeletedDto();
        dto.setPicklistRoleMvoEventId(e.getPicklistRoleMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

