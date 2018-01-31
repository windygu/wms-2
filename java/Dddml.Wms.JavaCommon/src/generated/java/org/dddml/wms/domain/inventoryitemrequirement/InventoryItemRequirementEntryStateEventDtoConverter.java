package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementEntryStateEventDtoConverter {

    public InventoryItemRequirementEntryStateEventDto toInventoryItemRequirementEntryStateEventDto(AbstractInventoryItemRequirementEntryStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemRequirementEntryStateEvent.AbstractInventoryItemRequirementEntryStateCreated) {
            InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated e = (InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated) stateEvent;
            return toInventoryItemRequirementEntryStateCreatedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto toInventoryItemRequirementEntryStateCreatedDto(InventoryItemRequirementEntryStateEvent.InventoryItemRequirementEntryStateCreated e) {
        InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto dto = new InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto();
        dto.setStateEventId(new InventoryItemRequirementEntryStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setSourceEventId((e.getSourceEventId() == null) ? null : new InventoryPRTriggeredIdDtoWrapper(e.getSourceEventId()));
        return dto;
    }

}

