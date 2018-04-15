package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryStateEventDtoConverter {

    public PhysicalInventoryStateEventDto toPhysicalInventoryStateEventDto(AbstractPhysicalInventoryEvent stateEvent) {
        if (stateEvent instanceof AbstractPhysicalInventoryEvent.AbstractPhysicalInventoryStateCreated) {
            PhysicalInventoryEvent.PhysicalInventoryStateCreated e = (PhysicalInventoryEvent.PhysicalInventoryStateCreated) stateEvent;
            return toPhysicalInventoryStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryEvent.AbstractPhysicalInventoryStateMergePatched) {
            PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = (PhysicalInventoryEvent.PhysicalInventoryStateMergePatched) stateEvent;
            return toPhysicalInventoryStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PhysicalInventoryStateEventDto.PhysicalInventoryStateCreatedDto toPhysicalInventoryStateCreatedDto(PhysicalInventoryEvent.PhysicalInventoryStateCreated e) {
        PhysicalInventoryStateEventDto.PhysicalInventoryStateCreatedDto dto = new PhysicalInventoryStateEventDto.PhysicalInventoryStateCreatedDto();
        dto.setPhysicalInventoryEventId(e.getPhysicalInventoryEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setWarehouseId(e.getWarehouseId());
        dto.setLocatorIdPattern(e.getLocatorIdPattern());
        dto.setProductIdPattern(e.getProductIdPattern());
        dto.setPosted(e.getPosted());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setMovementDate(e.getMovementDate());
        dto.setDescription(e.getDescription());
        dto.setIsApproved(e.getIsApproved());
        dto.setApprovalAmount(e.getApprovalAmount());
        dto.setIsQuantityUpdated(e.getIsQuantityUpdated());
        dto.setReversalDocumentNumber(e.getReversalDocumentNumber());
        dto.setActive(e.getActive());
        List<PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto> physicalInventoryLineEvents = new ArrayList<>();
        for (PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated ee : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto eeDto = getPhysicalInventoryLineStateEventDtoConverter().toPhysicalInventoryLineStateCreatedDto(ee);
            physicalInventoryLineEvents.add(eeDto);
        }
        dto.setPhysicalInventoryLineEvents(physicalInventoryLineEvents.toArray(new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto[0]));

        return dto;
    }

    public PhysicalInventoryStateEventDto.PhysicalInventoryStateMergePatchedDto toPhysicalInventoryStateMergePatchedDto(PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e) {
        PhysicalInventoryStateEventDto.PhysicalInventoryStateMergePatchedDto dto = new PhysicalInventoryStateEventDto.PhysicalInventoryStateMergePatchedDto();
        dto.setPhysicalInventoryEventId(e.getPhysicalInventoryEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setWarehouseId(e.getWarehouseId());
        dto.setLocatorIdPattern(e.getLocatorIdPattern());
        dto.setProductIdPattern(e.getProductIdPattern());
        dto.setPosted(e.getPosted());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setMovementDate(e.getMovementDate());
        dto.setDescription(e.getDescription());
        dto.setIsApproved(e.getIsApproved());
        dto.setApprovalAmount(e.getApprovalAmount());
        dto.setIsQuantityUpdated(e.getIsQuantityUpdated());
        dto.setReversalDocumentNumber(e.getReversalDocumentNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentStatusIdRemoved(e.getIsPropertyDocumentStatusIdRemoved());
        dto.setIsPropertyWarehouseIdRemoved(e.getIsPropertyWarehouseIdRemoved());
        dto.setIsPropertyLocatorIdPatternRemoved(e.getIsPropertyLocatorIdPatternRemoved());
        dto.setIsPropertyProductIdPatternRemoved(e.getIsPropertyProductIdPatternRemoved());
        dto.setIsPropertyPostedRemoved(e.getIsPropertyPostedRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyProcessingRemoved(e.getIsPropertyProcessingRemoved());
        dto.setIsPropertyDocumentTypeIdRemoved(e.getIsPropertyDocumentTypeIdRemoved());
        dto.setIsPropertyMovementDateRemoved(e.getIsPropertyMovementDateRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyIsApprovedRemoved(e.getIsPropertyIsApprovedRemoved());
        dto.setIsPropertyApprovalAmountRemoved(e.getIsPropertyApprovalAmountRemoved());
        dto.setIsPropertyIsQuantityUpdatedRemoved(e.getIsPropertyIsQuantityUpdatedRemoved());
        dto.setIsPropertyReversalDocumentNumberRemoved(e.getIsPropertyReversalDocumentNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<PhysicalInventoryLineStateEventDto> physicalInventoryLineEvents = new ArrayList<>();
        for (PhysicalInventoryLineEvent ee : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineStateEventDto eeDto = getPhysicalInventoryLineStateEventDtoConverter().toPhysicalInventoryLineStateEventDto((AbstractPhysicalInventoryLineEvent) ee);
            physicalInventoryLineEvents.add(eeDto);
        }
        dto.setPhysicalInventoryLineEvents(physicalInventoryLineEvents.toArray(new PhysicalInventoryLineStateEventDto[0]));

        return dto;
    }


    protected PhysicalInventoryLineStateEventDtoConverter getPhysicalInventoryLineStateEventDtoConverter() {
        return new PhysicalInventoryLineStateEventDtoConverter();
    }

}

