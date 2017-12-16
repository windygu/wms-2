package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutStateEventDtoConverter {

    public InOutStateEventDto toInOutStateEventDto(AbstractInOutStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInOutStateEvent.AbstractInOutStateCreated) {
            InOutStateEvent.InOutStateCreated e = (InOutStateEvent.InOutStateCreated) stateEvent;
            return toInOutStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInOutStateEvent.AbstractInOutStateMergePatched) {
            InOutStateEvent.InOutStateMergePatched e = (InOutStateEvent.InOutStateMergePatched) stateEvent;
            return toInOutStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInOutStateEvent.AbstractInOutStateDeleted) {
            InOutStateEvent.InOutStateDeleted e = (InOutStateEvent.InOutStateDeleted) stateEvent;
            return toInOutStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InOutStateEventDto.InOutStateCreatedDto toInOutStateCreatedDto(InOutStateEvent.InOutStateCreated e) {
        InOutStateEventDto.InOutStateCreatedDto dto = new InOutStateEventDto.InOutStateCreatedDto();
        dto.setStateEventId(new InOutStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatus(e.getDocumentStatus());
        dto.setPosted(e.getPosted());
        dto.setProcessing(e.getProcessing());
        dto.setProcessed(e.getProcessed());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setDescription(e.getDescription());
        dto.setOrderId(e.getOrderId());
        dto.setDateOrdered(e.getDateOrdered());
        dto.setIsPrinted(e.getIsPrinted());
        dto.setMovementTypeId(e.getMovementTypeId());
        dto.setMovementDate(e.getMovementDate());
        dto.setBusinessPartnerId(e.getBusinessPartnerId());
        dto.setWarehouseId(e.getWarehouseId());
        dto.setPOReference(e.getPOReference());
        dto.setShipperId(e.getShipperId());
        dto.setDatePrinted(e.getDatePrinted());
        dto.setSalesRepresentative(e.getSalesRepresentative());
        dto.setNumberOfPackages(e.getNumberOfPackages());
        dto.setPickDate(e.getPickDate());
        dto.setShipDate(e.getShipDate());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setDateReceived(e.getDateReceived());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setIsApproved(e.getIsApproved());
        dto.setIsInDispute(e.getIsInDispute());
        dto.setRmaNumber(e.getRmaNumber());
        dto.setReversalNumber(e.getReversalNumber());
        dto.setActive(e.getActive());
        List<InOutLineStateEventDto.InOutLineStateCreatedDto> inOutLineEvents = new ArrayList<>();
        for (InOutLineStateEvent.InOutLineStateCreated ee : e.getInOutLineEvents()) {
            InOutLineStateEventDto.InOutLineStateCreatedDto eeDto = getInOutLineStateEventDtoConverter().toInOutLineStateCreatedDto(ee);
            inOutLineEvents.add(eeDto);
        }
        dto.setInOutLineEvents(inOutLineEvents.toArray(new InOutLineStateEventDto.InOutLineStateCreatedDto[0]));

        return dto;
    }

    public InOutStateEventDto.InOutStateMergePatchedDto toInOutStateMergePatchedDto(InOutStateEvent.InOutStateMergePatched e) {
        InOutStateEventDto.InOutStateMergePatchedDto dto = new InOutStateEventDto.InOutStateMergePatchedDto();
        dto.setStateEventId(new InOutStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatus(e.getDocumentStatus());
        dto.setPosted(e.getPosted());
        dto.setProcessing(e.getProcessing());
        dto.setProcessed(e.getProcessed());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setDescription(e.getDescription());
        dto.setOrderId(e.getOrderId());
        dto.setDateOrdered(e.getDateOrdered());
        dto.setIsPrinted(e.getIsPrinted());
        dto.setMovementTypeId(e.getMovementTypeId());
        dto.setMovementDate(e.getMovementDate());
        dto.setBusinessPartnerId(e.getBusinessPartnerId());
        dto.setWarehouseId(e.getWarehouseId());
        dto.setPOReference(e.getPOReference());
        dto.setShipperId(e.getShipperId());
        dto.setDatePrinted(e.getDatePrinted());
        dto.setSalesRepresentative(e.getSalesRepresentative());
        dto.setNumberOfPackages(e.getNumberOfPackages());
        dto.setPickDate(e.getPickDate());
        dto.setShipDate(e.getShipDate());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setDateReceived(e.getDateReceived());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setIsApproved(e.getIsApproved());
        dto.setIsInDispute(e.getIsInDispute());
        dto.setRmaNumber(e.getRmaNumber());
        dto.setReversalNumber(e.getReversalNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentStatusRemoved(e.getIsPropertyDocumentStatusRemoved());
        dto.setIsPropertyPostedRemoved(e.getIsPropertyPostedRemoved());
        dto.setIsPropertyProcessingRemoved(e.getIsPropertyProcessingRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyDocumentTypeIdRemoved(e.getIsPropertyDocumentTypeIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyOrderIdRemoved(e.getIsPropertyOrderIdRemoved());
        dto.setIsPropertyDateOrderedRemoved(e.getIsPropertyDateOrderedRemoved());
        dto.setIsPropertyIsPrintedRemoved(e.getIsPropertyIsPrintedRemoved());
        dto.setIsPropertyMovementTypeIdRemoved(e.getIsPropertyMovementTypeIdRemoved());
        dto.setIsPropertyMovementDateRemoved(e.getIsPropertyMovementDateRemoved());
        dto.setIsPropertyBusinessPartnerIdRemoved(e.getIsPropertyBusinessPartnerIdRemoved());
        dto.setIsPropertyWarehouseIdRemoved(e.getIsPropertyWarehouseIdRemoved());
        dto.setIsPropertyPOReferenceRemoved(e.getIsPropertyPOReferenceRemoved());
        dto.setIsPropertyShipperIdRemoved(e.getIsPropertyShipperIdRemoved());
        dto.setIsPropertyDatePrintedRemoved(e.getIsPropertyDatePrintedRemoved());
        dto.setIsPropertySalesRepresentativeRemoved(e.getIsPropertySalesRepresentativeRemoved());
        dto.setIsPropertyNumberOfPackagesRemoved(e.getIsPropertyNumberOfPackagesRemoved());
        dto.setIsPropertyPickDateRemoved(e.getIsPropertyPickDateRemoved());
        dto.setIsPropertyShipDateRemoved(e.getIsPropertyShipDateRemoved());
        dto.setIsPropertyTrackingNumberRemoved(e.getIsPropertyTrackingNumberRemoved());
        dto.setIsPropertyDateReceivedRemoved(e.getIsPropertyDateReceivedRemoved());
        dto.setIsPropertyIsInTransitRemoved(e.getIsPropertyIsInTransitRemoved());
        dto.setIsPropertyIsApprovedRemoved(e.getIsPropertyIsApprovedRemoved());
        dto.setIsPropertyIsInDisputeRemoved(e.getIsPropertyIsInDisputeRemoved());
        dto.setIsPropertyRmaNumberRemoved(e.getIsPropertyRmaNumberRemoved());
        dto.setIsPropertyReversalNumberRemoved(e.getIsPropertyReversalNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<InOutLineStateEventDto> inOutLineEvents = new ArrayList<>();
        for (InOutLineStateEvent ee : e.getInOutLineEvents()) {
            InOutLineStateEventDto eeDto = getInOutLineStateEventDtoConverter().toInOutLineStateEventDto((AbstractInOutLineStateEvent) ee);
            inOutLineEvents.add(eeDto);
        }
        dto.setInOutLineEvents(inOutLineEvents.toArray(new InOutLineStateEventDto[0]));

        return dto;
    }


    public InOutStateEventDto.InOutStateDeletedDto toInOutStateDeletedDto(InOutStateEvent.InOutStateDeleted e) {
        InOutStateEventDto.InOutStateDeletedDto dto = new InOutStateEventDto.InOutStateDeletedDto();
        dto.setStateEventId(new InOutStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<InOutLineStateEventDto.InOutLineStateRemovedDto> inOutLineEvents = new ArrayList<>();
        for (InOutLineStateEvent.InOutLineStateRemoved ee : e.getInOutLineEvents()) {
            InOutLineStateEventDto.InOutLineStateRemovedDto eeDto = getInOutLineStateEventDtoConverter().toInOutLineStateRemovedDto(ee);
            inOutLineEvents.add(eeDto);
        }
        dto.setInOutLineEvents(inOutLineEvents.toArray(new InOutLineStateEventDto.InOutLineStateRemovedDto[0]));

        return dto;
    }

    protected InOutLineStateEventDtoConverter getInOutLineStateEventDtoConverter() {
        return new InOutLineStateEventDtoConverter();
    }

}

