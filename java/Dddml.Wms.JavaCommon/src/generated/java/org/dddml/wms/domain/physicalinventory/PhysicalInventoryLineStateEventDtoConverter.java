package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineStateEventDtoConverter {

    public PhysicalInventoryLineStateEventDto toPhysicalInventoryLineStateEventDto(AbstractPhysicalInventoryLineEvent stateEvent) {
        if (stateEvent instanceof AbstractPhysicalInventoryLineEvent.AbstractPhysicalInventoryLineStateCreated) {
            PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e = (PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated) stateEvent;
            return toPhysicalInventoryLineStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineEvent.AbstractPhysicalInventoryLineStateMergePatched) {
            PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched e = (PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched) stateEvent;
            return toPhysicalInventoryLineStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineEvent.AbstractPhysicalInventoryLineStateRemoved) {
            PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved e = (PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved) stateEvent;
            return toPhysicalInventoryLineStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto toPhysicalInventoryLineStateCreatedDto(PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e) {
        PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto dto = new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto();
        dto.setPhysicalInventoryLineEventId(e.getPhysicalInventoryLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setLineNumber(e.getLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        return dto;
    }

    public PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateMergePatchedDto toPhysicalInventoryLineStateMergePatchedDto(PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched e) {
        PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateMergePatchedDto dto = new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateMergePatchedDto();
        dto.setPhysicalInventoryLineEventId(e.getPhysicalInventoryLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setLineNumber(e.getLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setIsPropertyBookQuantityRemoved(e.getIsPropertyBookQuantityRemoved());
        dto.setIsPropertyCountedQuantityRemoved(e.getIsPropertyCountedQuantityRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyLineNumberRemoved(e.getIsPropertyLineNumberRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        return dto;
    }


    public PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto toPhysicalInventoryLineStateRemovedDto(PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved e) {
        PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto dto = new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto();
        dto.setPhysicalInventoryLineEventId(e.getPhysicalInventoryLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

