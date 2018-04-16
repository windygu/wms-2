package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryPRTriggeredStateEventDtoConverter {

    public InventoryPRTriggeredStateEventDto toInventoryPRTriggeredStateEventDto(AbstractInventoryPRTriggeredEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryPRTriggeredEvent.AbstractInventoryPRTriggeredStateCreated) {
            InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated e = (InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated) stateEvent;
            return toInventoryPRTriggeredStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryPRTriggeredEvent.AbstractInventoryPRTriggeredStateMergePatched) {
            InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched e = (InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched) stateEvent;
            return toInventoryPRTriggeredStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateCreatedDto toInventoryPRTriggeredStateCreatedDto(InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated e) {
        InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateCreatedDto dto = new InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateCreatedDto();
        dto.setInventoryPRTriggeredEventId(e.getInventoryPRTriggeredEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setIsProcessed(e.getIsProcessed());
        return dto;
    }

    public InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateMergePatchedDto toInventoryPRTriggeredStateMergePatchedDto(InventoryPRTriggeredEvent.InventoryPRTriggeredStateMergePatched e) {
        InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateMergePatchedDto dto = new InventoryPRTriggeredStateEventDto.InventoryPRTriggeredStateMergePatchedDto();
        dto.setInventoryPRTriggeredEventId(e.getInventoryPRTriggeredEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setIsProcessed(e.getIsProcessed());
        dto.setIsPropertyIsProcessedRemoved(e.getIsPropertyIsProcessedRemoved());
        return dto;
    }


}

