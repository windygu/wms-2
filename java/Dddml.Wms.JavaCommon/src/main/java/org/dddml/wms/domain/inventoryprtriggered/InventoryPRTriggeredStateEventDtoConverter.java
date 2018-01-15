package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryPRTriggeredStateEventDtoConverter {

    public InventoryPRTriggeredStateEventDto toInventoryPRTriggeredStateEventDto(AbstractInventoryPRTriggeredStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryPRTriggeredStateEvent.AbstractInventoryPRTriggeredStateCreated) {
            InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated e = (InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated) stateEvent;
            return toInventoryPRTriggeredStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryPRTriggeredStateEvent.AbstractInventoryPRTriggeredStateMergePatched) {
            InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched e = (InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched) stateEvent;
            return toInventoryPRTriggeredStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateCreatedDto toInventoryPRTriggeredStateCreatedDto(InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateCreated e) {
        InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateCreatedDto dto = new InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateCreatedDto();
        dto.setStateEventId(new InventoryPRTriggeredStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setIsProcessed(e.getIsProcessed());
        return dto;
    }

    public InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateMergePatchedDto toInventoryPRTriggeredStateMergePatchedDto(InventoryPRTriggeredStateEvent.InventoryPRTriggeredStateMergePatched e) {
        InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateMergePatchedDto dto = new InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateMergePatchedDto();
        dto.setStateEventId(new InventoryPRTriggeredStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setIsProcessed(e.getIsProcessed());
        dto.setIsPropertyIsProcessedRemoved(e.getIsPropertyIsProcessedRemoved());
        return dto;
    }


}

