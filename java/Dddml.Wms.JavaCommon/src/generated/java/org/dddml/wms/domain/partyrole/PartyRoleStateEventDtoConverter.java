package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PartyRoleStateEventDtoConverter {

    public PartyRoleStateEventDto toPartyRoleStateEventDto(AbstractPartyRoleEvent stateEvent) {
        if (stateEvent instanceof AbstractPartyRoleEvent.AbstractPartyRoleStateCreated) {
            PartyRoleEvent.PartyRoleStateCreated e = (PartyRoleEvent.PartyRoleStateCreated) stateEvent;
            return toPartyRoleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPartyRoleEvent.AbstractPartyRoleStateMergePatched) {
            PartyRoleEvent.PartyRoleStateMergePatched e = (PartyRoleEvent.PartyRoleStateMergePatched) stateEvent;
            return toPartyRoleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPartyRoleEvent.AbstractPartyRoleStateDeleted) {
            PartyRoleEvent.PartyRoleStateDeleted e = (PartyRoleEvent.PartyRoleStateDeleted) stateEvent;
            return toPartyRoleStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PartyRoleStateEventDto.PartyRoleStateCreatedDto toPartyRoleStateCreatedDto(PartyRoleEvent.PartyRoleStateCreated e) {
        PartyRoleStateEventDto.PartyRoleStateCreatedDto dto = new PartyRoleStateEventDto.PartyRoleStateCreatedDto();
        dto.setPartyRoleEventId(e.getPartyRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public PartyRoleStateEventDto.PartyRoleStateMergePatchedDto toPartyRoleStateMergePatchedDto(PartyRoleEvent.PartyRoleStateMergePatched e) {
        PartyRoleStateEventDto.PartyRoleStateMergePatchedDto dto = new PartyRoleStateEventDto.PartyRoleStateMergePatchedDto();
        dto.setPartyRoleEventId(e.getPartyRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PartyRoleStateEventDto.PartyRoleStateDeletedDto toPartyRoleStateDeletedDto(PartyRoleEvent.PartyRoleStateDeleted e) {
        PartyRoleStateEventDto.PartyRoleStateDeletedDto dto = new PartyRoleStateEventDto.PartyRoleStateDeletedDto();
        dto.setPartyRoleEventId(e.getPartyRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

