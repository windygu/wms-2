package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementEntryStateEventDtoConverter {

    public InventoryItemRequirementEntryStateEventDto toInventoryItemRequirementEntryStateEventDto(AbstractInventoryItemRequirementEntryEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemRequirementEntryEvent.AbstractInventoryItemRequirementEntryStateCreated) {
            InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e = (InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated) stateEvent;
            return toInventoryItemRequirementEntryStateCreatedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto toInventoryItemRequirementEntryStateCreatedDto(InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated e) {
        InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto dto = new InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto();
        dto.setInventoryItemRequirementEntryEventId(e.getInventoryItemRequirementEntryEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setSourceEventId(e.getSourceEventId());
        return dto;
    }

}

