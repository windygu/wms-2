package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementStateEventDtoConverter {

    public InventoryItemRequirementStateEventDto toInventoryItemRequirementStateEventDto(AbstractInventoryItemRequirementEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemRequirementEvent.AbstractInventoryItemRequirementStateCreated) {
            InventoryItemRequirementEvent.InventoryItemRequirementStateCreated e = (InventoryItemRequirementEvent.InventoryItemRequirementStateCreated) stateEvent;
            return toInventoryItemRequirementStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemRequirementEvent.AbstractInventoryItemRequirementStateMergePatched) {
            InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched e = (InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched) stateEvent;
            return toInventoryItemRequirementStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InventoryItemRequirementStateEventDto.InventoryItemRequirementStateCreatedDto toInventoryItemRequirementStateCreatedDto(InventoryItemRequirementEvent.InventoryItemRequirementStateCreated e) {
        InventoryItemRequirementStateEventDto.InventoryItemRequirementStateCreatedDto dto = new InventoryItemRequirementStateEventDto.InventoryItemRequirementStateCreatedDto();
        dto.setInventoryItemRequirementEventId(e.getInventoryItemRequirementEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        List<InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto> inventoryItemRequirementEntryEvents = new ArrayList<>();
        for (InventoryItemRequirementEntryEvent.InventoryItemRequirementEntryStateCreated ee : e.getInventoryItemRequirementEntryEvents()) {
            InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto eeDto = getInventoryItemRequirementEntryStateEventDtoConverter().toInventoryItemRequirementEntryStateCreatedDto(ee);
            inventoryItemRequirementEntryEvents.add(eeDto);
        }
        dto.setInventoryItemRequirementEntryEvents(inventoryItemRequirementEntryEvents.toArray(new InventoryItemRequirementEntryStateEventDto.InventoryItemRequirementEntryStateCreatedDto[0]));

        return dto;
    }

    public InventoryItemRequirementStateEventDto.InventoryItemRequirementStateMergePatchedDto toInventoryItemRequirementStateMergePatchedDto(InventoryItemRequirementEvent.InventoryItemRequirementStateMergePatched e) {
        InventoryItemRequirementStateEventDto.InventoryItemRequirementStateMergePatchedDto dto = new InventoryItemRequirementStateEventDto.InventoryItemRequirementStateMergePatchedDto();
        dto.setInventoryItemRequirementEventId(e.getInventoryItemRequirementEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        List<InventoryItemRequirementEntryStateEventDto> inventoryItemRequirementEntryEvents = new ArrayList<>();
        for (InventoryItemRequirementEntryEvent ee : e.getInventoryItemRequirementEntryEvents()) {
            InventoryItemRequirementEntryStateEventDto eeDto = getInventoryItemRequirementEntryStateEventDtoConverter().toInventoryItemRequirementEntryStateEventDto((AbstractInventoryItemRequirementEntryEvent) ee);
            inventoryItemRequirementEntryEvents.add(eeDto);
        }
        dto.setInventoryItemRequirementEntryEvents(inventoryItemRequirementEntryEvents.toArray(new InventoryItemRequirementEntryStateEventDto[0]));

        return dto;
    }


    protected InventoryItemRequirementEntryStateEventDtoConverter getInventoryItemRequirementEntryStateEventDtoConverter() {
        return new InventoryItemRequirementEntryStateEventDtoConverter();
    }

}

