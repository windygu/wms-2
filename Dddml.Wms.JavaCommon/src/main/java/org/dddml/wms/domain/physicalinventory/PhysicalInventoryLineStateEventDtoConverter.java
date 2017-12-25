package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineStateEventDtoConverter {

    public PhysicalInventoryLineStateEventDto toPhysicalInventoryLineStateEventDto(AbstractPhysicalInventoryLineStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPhysicalInventoryLineStateEvent.AbstractPhysicalInventoryLineStateCreated) {
            PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated e = (PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated) stateEvent;
            return toPhysicalInventoryLineStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineStateEvent.AbstractPhysicalInventoryLineStateMergePatched) {
            PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched e = (PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched) stateEvent;
            return toPhysicalInventoryLineStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineStateEvent.AbstractPhysicalInventoryLineStateRemoved) {
            PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved e = (PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved) stateEvent;
            return toPhysicalInventoryLineStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto toPhysicalInventoryLineStateCreatedDto(PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated e) {
        PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto dto = new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto();
        dto.setStateEventId(new PhysicalInventoryLineStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateMergePatchedDto toPhysicalInventoryLineStateMergePatchedDto(PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched e) {
        PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateMergePatchedDto dto = new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateMergePatchedDto();
        dto.setStateEventId(new PhysicalInventoryLineStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyBookQuantityRemoved(e.getIsPropertyBookQuantityRemoved());
        dto.setIsPropertyCountedQuantityRemoved(e.getIsPropertyCountedQuantityRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto toPhysicalInventoryLineStateRemovedDto(PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved e) {
        PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto dto = new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto();
        dto.setStateEventId(new PhysicalInventoryLineStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

