package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
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
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InOutStateEventDto.InOutStateCreatedDto toInOutStateCreatedDto(InOutStateEvent.InOutStateCreated e) {
        InOutStateEventDto.InOutStateCreatedDto dto = new InOutStateEventDto.InOutStateCreatedDto();
        dto.setStateEventId(new InOutStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setPosted(e.getPosted());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
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
        dto.setFreightAmount(e.getFreightAmount());
        dto.setShipperId(e.getShipperId());
        dto.setChargeAmount(e.getChargeAmount());
        dto.setDatePrinted(e.getDatePrinted());
        dto.setCreatedFrom(e.getCreatedFrom());
        dto.setSalesRepresentativeId(e.getSalesRepresentativeId());
        dto.setNumberOfPackages(e.getNumberOfPackages());
        dto.setPickDate(e.getPickDate());
        dto.setShipDate(e.getShipDate());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setDateReceived(e.getDateReceived());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setIsApproved(e.getIsApproved());
        dto.setIsInDispute(e.getIsInDispute());
        dto.setRmaDocumentNumber(e.getRmaDocumentNumber());
        dto.setReversalDocumentNumber(e.getReversalDocumentNumber());
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
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setPosted(e.getPosted());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
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
        dto.setFreightAmount(e.getFreightAmount());
        dto.setShipperId(e.getShipperId());
        dto.setChargeAmount(e.getChargeAmount());
        dto.setDatePrinted(e.getDatePrinted());
        dto.setCreatedFrom(e.getCreatedFrom());
        dto.setSalesRepresentativeId(e.getSalesRepresentativeId());
        dto.setNumberOfPackages(e.getNumberOfPackages());
        dto.setPickDate(e.getPickDate());
        dto.setShipDate(e.getShipDate());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setDateReceived(e.getDateReceived());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setIsApproved(e.getIsApproved());
        dto.setIsInDispute(e.getIsInDispute());
        dto.setRmaDocumentNumber(e.getRmaDocumentNumber());
        dto.setReversalDocumentNumber(e.getReversalDocumentNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentStatusIdRemoved(e.getIsPropertyDocumentStatusIdRemoved());
        dto.setIsPropertyPostedRemoved(e.getIsPropertyPostedRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyProcessingRemoved(e.getIsPropertyProcessingRemoved());
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
        dto.setIsPropertyFreightAmountRemoved(e.getIsPropertyFreightAmountRemoved());
        dto.setIsPropertyShipperIdRemoved(e.getIsPropertyShipperIdRemoved());
        dto.setIsPropertyChargeAmountRemoved(e.getIsPropertyChargeAmountRemoved());
        dto.setIsPropertyDatePrintedRemoved(e.getIsPropertyDatePrintedRemoved());
        dto.setIsPropertyCreatedFromRemoved(e.getIsPropertyCreatedFromRemoved());
        dto.setIsPropertySalesRepresentativeIdRemoved(e.getIsPropertySalesRepresentativeIdRemoved());
        dto.setIsPropertyNumberOfPackagesRemoved(e.getIsPropertyNumberOfPackagesRemoved());
        dto.setIsPropertyPickDateRemoved(e.getIsPropertyPickDateRemoved());
        dto.setIsPropertyShipDateRemoved(e.getIsPropertyShipDateRemoved());
        dto.setIsPropertyTrackingNumberRemoved(e.getIsPropertyTrackingNumberRemoved());
        dto.setIsPropertyDateReceivedRemoved(e.getIsPropertyDateReceivedRemoved());
        dto.setIsPropertyIsInTransitRemoved(e.getIsPropertyIsInTransitRemoved());
        dto.setIsPropertyIsApprovedRemoved(e.getIsPropertyIsApprovedRemoved());
        dto.setIsPropertyIsInDisputeRemoved(e.getIsPropertyIsInDisputeRemoved());
        dto.setIsPropertyRmaDocumentNumberRemoved(e.getIsPropertyRmaDocumentNumberRemoved());
        dto.setIsPropertyReversalDocumentNumberRemoved(e.getIsPropertyReversalDocumentNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<InOutLineStateEventDto> inOutLineEvents = new ArrayList<>();
        for (InOutLineStateEvent ee : e.getInOutLineEvents()) {
            InOutLineStateEventDto eeDto = getInOutLineStateEventDtoConverter().toInOutLineStateEventDto((AbstractInOutLineStateEvent) ee);
            inOutLineEvents.add(eeDto);
        }
        dto.setInOutLineEvents(inOutLineEvents.toArray(new InOutLineStateEventDto[0]));

        return dto;
    }


    protected InOutLineStateEventDtoConverter getInOutLineStateEventDtoConverter() {
        return new InOutLineStateEventDtoConverter();
    }

}

