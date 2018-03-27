package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PartyRoleStateEventDtoConverter {

    public PartyRoleStateEventDto toPartyRoleStateEventDto(AbstractPartyRoleStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPartyRoleStateEvent.AbstractPartyRoleStateCreated) {
            PartyRoleStateEvent.PartyRoleStateCreated e = (PartyRoleStateEvent.PartyRoleStateCreated) stateEvent;
            return toPartyRoleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPartyRoleStateEvent.AbstractPartyRoleStateMergePatched) {
            PartyRoleStateEvent.PartyRoleStateMergePatched e = (PartyRoleStateEvent.PartyRoleStateMergePatched) stateEvent;
            return toPartyRoleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPartyRoleStateEvent.AbstractPartyRoleStateDeleted) {
            PartyRoleStateEvent.PartyRoleStateDeleted e = (PartyRoleStateEvent.PartyRoleStateDeleted) stateEvent;
            return toPartyRoleStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PartyRoleStateEventDto.PartyRoleStateCreatedDto toPartyRoleStateCreatedDto(PartyRoleStateEvent.PartyRoleStateCreated e) {
        PartyRoleStateEventDto.PartyRoleStateCreatedDto dto = new PartyRoleStateEventDto.PartyRoleStateCreatedDto();
        dto.setPartyRoleEventId(e.getPartyRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public PartyRoleStateEventDto.PartyRoleStateMergePatchedDto toPartyRoleStateMergePatchedDto(PartyRoleStateEvent.PartyRoleStateMergePatched e) {
        PartyRoleStateEventDto.PartyRoleStateMergePatchedDto dto = new PartyRoleStateEventDto.PartyRoleStateMergePatchedDto();
        dto.setPartyRoleEventId(e.getPartyRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PartyRoleStateEventDto.PartyRoleStateDeletedDto toPartyRoleStateDeletedDto(PartyRoleStateEvent.PartyRoleStateDeleted e) {
        PartyRoleStateEventDto.PartyRoleStateDeletedDto dto = new PartyRoleStateEventDto.PartyRoleStateDeletedDto();
        dto.setPartyRoleEventId(e.getPartyRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

