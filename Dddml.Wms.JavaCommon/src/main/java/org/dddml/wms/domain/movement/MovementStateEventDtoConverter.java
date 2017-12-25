package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementStateEventDtoConverter {

    public MovementStateEventDto toMovementStateEventDto(AbstractMovementStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementStateEvent.AbstractMovementStateCreated) {
            MovementStateEvent.MovementStateCreated e = (MovementStateEvent.MovementStateCreated) stateEvent;
            return toMovementStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementStateEvent.AbstractMovementStateMergePatched) {
            MovementStateEvent.MovementStateMergePatched e = (MovementStateEvent.MovementStateMergePatched) stateEvent;
            return toMovementStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementStateEvent.AbstractMovementStateDeleted) {
            MovementStateEvent.MovementStateDeleted e = (MovementStateEvent.MovementStateDeleted) stateEvent;
            return toMovementStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementStateEventDto.MovementStateCreatedDto toMovementStateCreatedDto(MovementStateEvent.MovementStateCreated e) {
        MovementStateEventDto.MovementStateCreatedDto dto = new MovementStateEventDto.MovementStateCreatedDto();
        dto.setStateEventId(new MovementStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setMovementDate(e.getMovementDate());
        dto.setPosted(e.getPosted());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
        dto.setDateReceived(e.getDateReceived());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setIsApproved(e.getIsApproved());
        dto.setApprovalAmount(e.getApprovalAmount());
        dto.setShipperId(e.getShipperId());
        dto.setSalesRepresentativeId(e.getSalesRepresentativeId());
        dto.setBusinessPartnerId(e.getBusinessPartnerId());
        dto.setChargeAmount(e.getChargeAmount());
        dto.setCreateFrom(e.getCreateFrom());
        dto.setFreightAmount(e.getFreightAmount());
        dto.setReversalDocumentNumber(e.getReversalDocumentNumber());
        dto.setWarehouseIdFrom(e.getWarehouseIdFrom());
        dto.setWarehouseIdTo(e.getWarehouseIdTo());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        List<MovementLineStateEventDto.MovementLineStateCreatedDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent.MovementLineStateCreated ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto.MovementLineStateCreatedDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateCreatedDto(ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto.MovementLineStateCreatedDto[0]));

        return dto;
    }

    public MovementStateEventDto.MovementStateMergePatchedDto toMovementStateMergePatchedDto(MovementStateEvent.MovementStateMergePatched e) {
        MovementStateEventDto.MovementStateMergePatchedDto dto = new MovementStateEventDto.MovementStateMergePatchedDto();
        dto.setStateEventId(new MovementStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setMovementDate(e.getMovementDate());
        dto.setPosted(e.getPosted());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
        dto.setDateReceived(e.getDateReceived());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setIsApproved(e.getIsApproved());
        dto.setApprovalAmount(e.getApprovalAmount());
        dto.setShipperId(e.getShipperId());
        dto.setSalesRepresentativeId(e.getSalesRepresentativeId());
        dto.setBusinessPartnerId(e.getBusinessPartnerId());
        dto.setChargeAmount(e.getChargeAmount());
        dto.setCreateFrom(e.getCreateFrom());
        dto.setFreightAmount(e.getFreightAmount());
        dto.setReversalDocumentNumber(e.getReversalDocumentNumber());
        dto.setWarehouseIdFrom(e.getWarehouseIdFrom());
        dto.setWarehouseIdTo(e.getWarehouseIdTo());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentStatusIdRemoved(e.getIsPropertyDocumentStatusIdRemoved());
        dto.setIsPropertyMovementDateRemoved(e.getIsPropertyMovementDateRemoved());
        dto.setIsPropertyPostedRemoved(e.getIsPropertyPostedRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyProcessingRemoved(e.getIsPropertyProcessingRemoved());
        dto.setIsPropertyDateReceivedRemoved(e.getIsPropertyDateReceivedRemoved());
        dto.setIsPropertyDocumentTypeIdRemoved(e.getIsPropertyDocumentTypeIdRemoved());
        dto.setIsPropertyIsInTransitRemoved(e.getIsPropertyIsInTransitRemoved());
        dto.setIsPropertyIsApprovedRemoved(e.getIsPropertyIsApprovedRemoved());
        dto.setIsPropertyApprovalAmountRemoved(e.getIsPropertyApprovalAmountRemoved());
        dto.setIsPropertyShipperIdRemoved(e.getIsPropertyShipperIdRemoved());
        dto.setIsPropertySalesRepresentativeIdRemoved(e.getIsPropertySalesRepresentativeIdRemoved());
        dto.setIsPropertyBusinessPartnerIdRemoved(e.getIsPropertyBusinessPartnerIdRemoved());
        dto.setIsPropertyChargeAmountRemoved(e.getIsPropertyChargeAmountRemoved());
        dto.setIsPropertyCreateFromRemoved(e.getIsPropertyCreateFromRemoved());
        dto.setIsPropertyFreightAmountRemoved(e.getIsPropertyFreightAmountRemoved());
        dto.setIsPropertyReversalDocumentNumberRemoved(e.getIsPropertyReversalDocumentNumberRemoved());
        dto.setIsPropertyWarehouseIdFromRemoved(e.getIsPropertyWarehouseIdFromRemoved());
        dto.setIsPropertyWarehouseIdToRemoved(e.getIsPropertyWarehouseIdToRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<MovementLineStateEventDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateEventDto((AbstractMovementLineStateEvent) ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto[0]));

        return dto;
    }


    public MovementStateEventDto.MovementStateDeletedDto toMovementStateDeletedDto(MovementStateEvent.MovementStateDeleted e) {
        MovementStateEventDto.MovementStateDeletedDto dto = new MovementStateEventDto.MovementStateDeletedDto();
        dto.setStateEventId(new MovementStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<MovementLineStateEventDto.MovementLineStateRemovedDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent.MovementLineStateRemoved ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto.MovementLineStateRemovedDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateRemovedDto(ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto.MovementLineStateRemovedDto[0]));

        return dto;
    }

    protected MovementLineStateEventDtoConverter getMovementLineStateEventDtoConverter() {
        return new MovementLineStateEventDtoConverter();
    }

}

