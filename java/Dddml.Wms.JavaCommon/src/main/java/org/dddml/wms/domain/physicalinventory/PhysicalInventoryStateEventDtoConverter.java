package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryStateEventDtoConverter {

    public PhysicalInventoryStateEventDto toPhysicalInventoryStateEventDto(AbstractPhysicalInventoryStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPhysicalInventoryStateEvent.AbstractPhysicalInventoryStateCreated) {
            PhysicalInventoryStateEvent.PhysicalInventoryStateCreated e = (PhysicalInventoryStateEvent.PhysicalInventoryStateCreated) stateEvent;
            return toPhysicalInventoryStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryStateEvent.AbstractPhysicalInventoryStateMergePatched) {
            PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched e = (PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched) stateEvent;
            return toPhysicalInventoryStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryStateEvent.AbstractPhysicalInventoryStateDeleted) {
            PhysicalInventoryStateEvent.PhysicalInventoryStateDeleted e = (PhysicalInventoryStateEvent.PhysicalInventoryStateDeleted) stateEvent;
            return toPhysicalInventoryStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PhysicalInventoryStateEventDto.PhysicalInventoryStateCreatedDto toPhysicalInventoryStateCreatedDto(PhysicalInventoryStateEvent.PhysicalInventoryStateCreated e) {
        PhysicalInventoryStateEventDto.PhysicalInventoryStateCreatedDto dto = new PhysicalInventoryStateEventDto.PhysicalInventoryStateCreatedDto();
        dto.setStateEventId(new PhysicalInventoryStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setWarehouseId(e.getWarehouseId());
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
        for (PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated ee : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto eeDto = getPhysicalInventoryLineStateEventDtoConverter().toPhysicalInventoryLineStateCreatedDto(ee);
            physicalInventoryLineEvents.add(eeDto);
        }
        dto.setPhysicalInventoryLineEvents(physicalInventoryLineEvents.toArray(new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateCreatedDto[0]));

        return dto;
    }

    public PhysicalInventoryStateEventDto.PhysicalInventoryStateMergePatchedDto toPhysicalInventoryStateMergePatchedDto(PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched e) {
        PhysicalInventoryStateEventDto.PhysicalInventoryStateMergePatchedDto dto = new PhysicalInventoryStateEventDto.PhysicalInventoryStateMergePatchedDto();
        dto.setStateEventId(new PhysicalInventoryStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setWarehouseId(e.getWarehouseId());
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
        for (PhysicalInventoryLineStateEvent ee : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineStateEventDto eeDto = getPhysicalInventoryLineStateEventDtoConverter().toPhysicalInventoryLineStateEventDto((AbstractPhysicalInventoryLineStateEvent) ee);
            physicalInventoryLineEvents.add(eeDto);
        }
        dto.setPhysicalInventoryLineEvents(physicalInventoryLineEvents.toArray(new PhysicalInventoryLineStateEventDto[0]));

        return dto;
    }


    public PhysicalInventoryStateEventDto.PhysicalInventoryStateDeletedDto toPhysicalInventoryStateDeletedDto(PhysicalInventoryStateEvent.PhysicalInventoryStateDeleted e) {
        PhysicalInventoryStateEventDto.PhysicalInventoryStateDeletedDto dto = new PhysicalInventoryStateEventDto.PhysicalInventoryStateDeletedDto();
        dto.setStateEventId(new PhysicalInventoryStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto> physicalInventoryLineEvents = new ArrayList<>();
        for (PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved ee : e.getPhysicalInventoryLineEvents()) {
            PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto eeDto = getPhysicalInventoryLineStateEventDtoConverter().toPhysicalInventoryLineStateRemovedDto(ee);
            physicalInventoryLineEvents.add(eeDto);
        }
        dto.setPhysicalInventoryLineEvents(physicalInventoryLineEvents.toArray(new PhysicalInventoryLineStateEventDto.PhysicalInventoryLineStateRemovedDto[0]));

        return dto;
    }

    protected PhysicalInventoryLineStateEventDtoConverter getPhysicalInventoryLineStateEventDtoConverter() {
        return new PhysicalInventoryLineStateEventDtoConverter();
    }

}

