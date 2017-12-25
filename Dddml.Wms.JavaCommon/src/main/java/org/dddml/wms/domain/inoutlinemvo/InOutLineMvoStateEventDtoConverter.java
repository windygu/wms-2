package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutLineMvoStateEventDtoConverter {

    public InOutLineMvoStateEventDto toInOutLineMvoStateEventDto(AbstractInOutLineMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInOutLineMvoStateEvent.AbstractInOutLineMvoStateCreated) {
            InOutLineMvoStateEvent.InOutLineMvoStateCreated e = (InOutLineMvoStateEvent.InOutLineMvoStateCreated) stateEvent;
            return toInOutLineMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineMvoStateEvent.AbstractInOutLineMvoStateMergePatched) {
            InOutLineMvoStateEvent.InOutLineMvoStateMergePatched e = (InOutLineMvoStateEvent.InOutLineMvoStateMergePatched) stateEvent;
            return toInOutLineMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineMvoStateEvent.AbstractInOutLineMvoStateDeleted) {
            InOutLineMvoStateEvent.InOutLineMvoStateDeleted e = (InOutLineMvoStateEvent.InOutLineMvoStateDeleted) stateEvent;
            return toInOutLineMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InOutLineMvoStateEventDto.InOutLineMvoStateCreatedDto toInOutLineMvoStateCreatedDto(InOutLineMvoStateEvent.InOutLineMvoStateCreated e) {
        InOutLineMvoStateEventDto.InOutLineMvoStateCreatedDto dto = new InOutLineMvoStateEventDto.InOutLineMvoStateCreatedDto();
        dto.setStateEventId(new InOutLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setDescription(e.getDescription());
        dto.setUomId(e.getUomId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setPickedQuantity(e.getPickedQuantity());
        dto.setIsInvoiced(e.getIsInvoiced());
        dto.setProcessed(e.getProcessed());
        dto.setQuantityEntered(e.getQuantityEntered());
        dto.setRmaLineNumber(e.getRmaLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setInOutDocumentStatusId(e.getInOutDocumentStatusId());
        dto.setInOutPosted(e.getInOutPosted());
        dto.setInOutProcessed(e.getInOutProcessed());
        dto.setInOutProcessing(e.getInOutProcessing());
        dto.setInOutDocumentTypeId(e.getInOutDocumentTypeId());
        dto.setInOutDescription(e.getInOutDescription());
        dto.setInOutOrderId(e.getInOutOrderId());
        dto.setInOutDateOrdered(e.getInOutDateOrdered());
        dto.setInOutIsPrinted(e.getInOutIsPrinted());
        dto.setInOutMovementTypeId(e.getInOutMovementTypeId());
        dto.setInOutMovementDate(e.getInOutMovementDate());
        dto.setInOutBusinessPartnerId(e.getInOutBusinessPartnerId());
        dto.setInOutWarehouseId(e.getInOutWarehouseId());
        dto.setInOutPOReference(e.getInOutPOReference());
        dto.setInOutShipperId(e.getInOutShipperId());
        dto.setInOutDatePrinted(e.getInOutDatePrinted());
        dto.setInOutSalesRepresentative(e.getInOutSalesRepresentative());
        dto.setInOutNumberOfPackages(e.getInOutNumberOfPackages());
        dto.setInOutPickDate(e.getInOutPickDate());
        dto.setInOutShipDate(e.getInOutShipDate());
        dto.setInOutTrackingNumber(e.getInOutTrackingNumber());
        dto.setInOutDateReceived(e.getInOutDateReceived());
        dto.setInOutIsInTransit(e.getInOutIsInTransit());
        dto.setInOutIsApproved(e.getInOutIsApproved());
        dto.setInOutIsInDispute(e.getInOutIsInDispute());
        dto.setInOutRmaNumber(e.getInOutRmaNumber());
        dto.setInOutReversalNumber(e.getInOutReversalNumber());
        dto.setInOutCreatedBy(e.getInOutCreatedBy());
        dto.setInOutCreatedAt(e.getInOutCreatedAt());
        dto.setInOutUpdatedBy(e.getInOutUpdatedBy());
        dto.setInOutUpdatedAt(e.getInOutUpdatedAt());
        dto.setInOutActive(e.getInOutActive());
        dto.setInOutDeleted(e.getInOutDeleted());
        return dto;
    }

    public InOutLineMvoStateEventDto.InOutLineMvoStateMergePatchedDto toInOutLineMvoStateMergePatchedDto(InOutLineMvoStateEvent.InOutLineMvoStateMergePatched e) {
        InOutLineMvoStateEventDto.InOutLineMvoStateMergePatchedDto dto = new InOutLineMvoStateEventDto.InOutLineMvoStateMergePatchedDto();
        dto.setStateEventId(new InOutLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setDescription(e.getDescription());
        dto.setUomId(e.getUomId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setPickedQuantity(e.getPickedQuantity());
        dto.setIsInvoiced(e.getIsInvoiced());
        dto.setProcessed(e.getProcessed());
        dto.setQuantityEntered(e.getQuantityEntered());
        dto.setRmaLineNumber(e.getRmaLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setInOutDocumentStatusId(e.getInOutDocumentStatusId());
        dto.setInOutPosted(e.getInOutPosted());
        dto.setInOutProcessed(e.getInOutProcessed());
        dto.setInOutProcessing(e.getInOutProcessing());
        dto.setInOutDocumentTypeId(e.getInOutDocumentTypeId());
        dto.setInOutDescription(e.getInOutDescription());
        dto.setInOutOrderId(e.getInOutOrderId());
        dto.setInOutDateOrdered(e.getInOutDateOrdered());
        dto.setInOutIsPrinted(e.getInOutIsPrinted());
        dto.setInOutMovementTypeId(e.getInOutMovementTypeId());
        dto.setInOutMovementDate(e.getInOutMovementDate());
        dto.setInOutBusinessPartnerId(e.getInOutBusinessPartnerId());
        dto.setInOutWarehouseId(e.getInOutWarehouseId());
        dto.setInOutPOReference(e.getInOutPOReference());
        dto.setInOutShipperId(e.getInOutShipperId());
        dto.setInOutDatePrinted(e.getInOutDatePrinted());
        dto.setInOutSalesRepresentative(e.getInOutSalesRepresentative());
        dto.setInOutNumberOfPackages(e.getInOutNumberOfPackages());
        dto.setInOutPickDate(e.getInOutPickDate());
        dto.setInOutShipDate(e.getInOutShipDate());
        dto.setInOutTrackingNumber(e.getInOutTrackingNumber());
        dto.setInOutDateReceived(e.getInOutDateReceived());
        dto.setInOutIsInTransit(e.getInOutIsInTransit());
        dto.setInOutIsApproved(e.getInOutIsApproved());
        dto.setInOutIsInDispute(e.getInOutIsInDispute());
        dto.setInOutRmaNumber(e.getInOutRmaNumber());
        dto.setInOutReversalNumber(e.getInOutReversalNumber());
        dto.setInOutCreatedBy(e.getInOutCreatedBy());
        dto.setInOutCreatedAt(e.getInOutCreatedAt());
        dto.setInOutUpdatedBy(e.getInOutUpdatedBy());
        dto.setInOutUpdatedAt(e.getInOutUpdatedAt());
        dto.setInOutActive(e.getInOutActive());
        dto.setInOutDeleted(e.getInOutDeleted());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyUomIdRemoved(e.getIsPropertyUomIdRemoved());
        dto.setIsPropertyMovementQuantityRemoved(e.getIsPropertyMovementQuantityRemoved());
        dto.setIsPropertyConfirmedQuantityRemoved(e.getIsPropertyConfirmedQuantityRemoved());
        dto.setIsPropertyScrappedQuantityRemoved(e.getIsPropertyScrappedQuantityRemoved());
        dto.setIsPropertyTargetQuantityRemoved(e.getIsPropertyTargetQuantityRemoved());
        dto.setIsPropertyPickedQuantityRemoved(e.getIsPropertyPickedQuantityRemoved());
        dto.setIsPropertyIsInvoicedRemoved(e.getIsPropertyIsInvoicedRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyQuantityEnteredRemoved(e.getIsPropertyQuantityEnteredRemoved());
        dto.setIsPropertyRmaLineNumberRemoved(e.getIsPropertyRmaLineNumberRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyInOutDocumentStatusIdRemoved(e.getIsPropertyInOutDocumentStatusIdRemoved());
        dto.setIsPropertyInOutPostedRemoved(e.getIsPropertyInOutPostedRemoved());
        dto.setIsPropertyInOutProcessedRemoved(e.getIsPropertyInOutProcessedRemoved());
        dto.setIsPropertyInOutProcessingRemoved(e.getIsPropertyInOutProcessingRemoved());
        dto.setIsPropertyInOutDocumentTypeIdRemoved(e.getIsPropertyInOutDocumentTypeIdRemoved());
        dto.setIsPropertyInOutDescriptionRemoved(e.getIsPropertyInOutDescriptionRemoved());
        dto.setIsPropertyInOutOrderIdRemoved(e.getIsPropertyInOutOrderIdRemoved());
        dto.setIsPropertyInOutDateOrderedRemoved(e.getIsPropertyInOutDateOrderedRemoved());
        dto.setIsPropertyInOutIsPrintedRemoved(e.getIsPropertyInOutIsPrintedRemoved());
        dto.setIsPropertyInOutMovementTypeIdRemoved(e.getIsPropertyInOutMovementTypeIdRemoved());
        dto.setIsPropertyInOutMovementDateRemoved(e.getIsPropertyInOutMovementDateRemoved());
        dto.setIsPropertyInOutBusinessPartnerIdRemoved(e.getIsPropertyInOutBusinessPartnerIdRemoved());
        dto.setIsPropertyInOutWarehouseIdRemoved(e.getIsPropertyInOutWarehouseIdRemoved());
        dto.setIsPropertyInOutPOReferenceRemoved(e.getIsPropertyInOutPOReferenceRemoved());
        dto.setIsPropertyInOutShipperIdRemoved(e.getIsPropertyInOutShipperIdRemoved());
        dto.setIsPropertyInOutDatePrintedRemoved(e.getIsPropertyInOutDatePrintedRemoved());
        dto.setIsPropertyInOutSalesRepresentativeRemoved(e.getIsPropertyInOutSalesRepresentativeRemoved());
        dto.setIsPropertyInOutNumberOfPackagesRemoved(e.getIsPropertyInOutNumberOfPackagesRemoved());
        dto.setIsPropertyInOutPickDateRemoved(e.getIsPropertyInOutPickDateRemoved());
        dto.setIsPropertyInOutShipDateRemoved(e.getIsPropertyInOutShipDateRemoved());
        dto.setIsPropertyInOutTrackingNumberRemoved(e.getIsPropertyInOutTrackingNumberRemoved());
        dto.setIsPropertyInOutDateReceivedRemoved(e.getIsPropertyInOutDateReceivedRemoved());
        dto.setIsPropertyInOutIsInTransitRemoved(e.getIsPropertyInOutIsInTransitRemoved());
        dto.setIsPropertyInOutIsApprovedRemoved(e.getIsPropertyInOutIsApprovedRemoved());
        dto.setIsPropertyInOutIsInDisputeRemoved(e.getIsPropertyInOutIsInDisputeRemoved());
        dto.setIsPropertyInOutRmaNumberRemoved(e.getIsPropertyInOutRmaNumberRemoved());
        dto.setIsPropertyInOutReversalNumberRemoved(e.getIsPropertyInOutReversalNumberRemoved());
        dto.setIsPropertyInOutCreatedByRemoved(e.getIsPropertyInOutCreatedByRemoved());
        dto.setIsPropertyInOutCreatedAtRemoved(e.getIsPropertyInOutCreatedAtRemoved());
        dto.setIsPropertyInOutUpdatedByRemoved(e.getIsPropertyInOutUpdatedByRemoved());
        dto.setIsPropertyInOutUpdatedAtRemoved(e.getIsPropertyInOutUpdatedAtRemoved());
        dto.setIsPropertyInOutActiveRemoved(e.getIsPropertyInOutActiveRemoved());
        dto.setIsPropertyInOutDeletedRemoved(e.getIsPropertyInOutDeletedRemoved());
        return dto;
    }


    public InOutLineMvoStateEventDto.InOutLineMvoStateDeletedDto toInOutLineMvoStateDeletedDto(InOutLineMvoStateEvent.InOutLineMvoStateDeleted e) {
        InOutLineMvoStateEventDto.InOutLineMvoStateDeletedDto dto = new InOutLineMvoStateEventDto.InOutLineMvoStateDeletedDto();
        dto.setStateEventId(new InOutLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

