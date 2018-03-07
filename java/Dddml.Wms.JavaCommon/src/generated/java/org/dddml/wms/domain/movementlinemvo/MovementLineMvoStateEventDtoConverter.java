package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementLineMvoStateEventDtoConverter {

    public MovementLineMvoStateEventDto toMovementLineMvoStateEventDto(AbstractMovementLineMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementLineMvoStateEvent.AbstractMovementLineMvoStateCreated) {
            MovementLineMvoStateEvent.MovementLineMvoStateCreated e = (MovementLineMvoStateEvent.MovementLineMvoStateCreated) stateEvent;
            return toMovementLineMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementLineMvoStateEvent.AbstractMovementLineMvoStateMergePatched) {
            MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e = (MovementLineMvoStateEvent.MovementLineMvoStateMergePatched) stateEvent;
            return toMovementLineMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementLineMvoStateEvent.AbstractMovementLineMvoStateDeleted) {
            MovementLineMvoStateEvent.MovementLineMvoStateDeleted e = (MovementLineMvoStateEvent.MovementLineMvoStateDeleted) stateEvent;
            return toMovementLineMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementLineMvoStateEventDto.MovementLineMvoStateCreatedDto toMovementLineMvoStateCreatedDto(MovementLineMvoStateEvent.MovementLineMvoStateCreated e) {
        MovementLineMvoStateEventDto.MovementLineMvoStateCreatedDto dto = new MovementLineMvoStateEventDto.MovementLineMvoStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setProductId(e.getProductId());
        dto.setLocatorIdFrom(e.getLocatorIdFrom());
        dto.setLocatorIdTo(e.getLocatorIdTo());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        dto.setMovementMovementDate(e.getMovementMovementDate());
        dto.setMovementPosted(e.getMovementPosted());
        dto.setMovementProcessed(e.getMovementProcessed());
        dto.setMovementProcessing(e.getMovementProcessing());
        dto.setMovementDateReceived(e.getMovementDateReceived());
        dto.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        dto.setMovementIsInTransit(e.getMovementIsInTransit());
        dto.setMovementIsApproved(e.getMovementIsApproved());
        dto.setMovementApprovalAmount(e.getMovementApprovalAmount());
        dto.setMovementShipperId(e.getMovementShipperId());
        dto.setMovementSalesRepresentativeId(e.getMovementSalesRepresentativeId());
        dto.setMovementBusinessPartnerId(e.getMovementBusinessPartnerId());
        dto.setMovementChargeAmount(e.getMovementChargeAmount());
        dto.setMovementCreateFrom(e.getMovementCreateFrom());
        dto.setMovementFreightAmount(e.getMovementFreightAmount());
        dto.setMovementReversalDocumentNumber(e.getMovementReversalDocumentNumber());
        dto.setMovementWarehouseIdFrom(e.getMovementWarehouseIdFrom());
        dto.setMovementWarehouseIdTo(e.getMovementWarehouseIdTo());
        dto.setMovementDescription(e.getMovementDescription());
        dto.setMovementCreatedBy(e.getMovementCreatedBy());
        dto.setMovementCreatedAt(e.getMovementCreatedAt());
        dto.setMovementUpdatedBy(e.getMovementUpdatedBy());
        dto.setMovementUpdatedAt(e.getMovementUpdatedAt());
        dto.setMovementActive(e.getMovementActive());
        dto.setMovementDeleted(e.getMovementDeleted());
        return dto;
    }

    public MovementLineMvoStateEventDto.MovementLineMvoStateMergePatchedDto toMovementLineMvoStateMergePatchedDto(MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e) {
        MovementLineMvoStateEventDto.MovementLineMvoStateMergePatchedDto dto = new MovementLineMvoStateEventDto.MovementLineMvoStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setProductId(e.getProductId());
        dto.setLocatorIdFrom(e.getLocatorIdFrom());
        dto.setLocatorIdTo(e.getLocatorIdTo());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        dto.setMovementMovementDate(e.getMovementMovementDate());
        dto.setMovementPosted(e.getMovementPosted());
        dto.setMovementProcessed(e.getMovementProcessed());
        dto.setMovementProcessing(e.getMovementProcessing());
        dto.setMovementDateReceived(e.getMovementDateReceived());
        dto.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        dto.setMovementIsInTransit(e.getMovementIsInTransit());
        dto.setMovementIsApproved(e.getMovementIsApproved());
        dto.setMovementApprovalAmount(e.getMovementApprovalAmount());
        dto.setMovementShipperId(e.getMovementShipperId());
        dto.setMovementSalesRepresentativeId(e.getMovementSalesRepresentativeId());
        dto.setMovementBusinessPartnerId(e.getMovementBusinessPartnerId());
        dto.setMovementChargeAmount(e.getMovementChargeAmount());
        dto.setMovementCreateFrom(e.getMovementCreateFrom());
        dto.setMovementFreightAmount(e.getMovementFreightAmount());
        dto.setMovementReversalDocumentNumber(e.getMovementReversalDocumentNumber());
        dto.setMovementWarehouseIdFrom(e.getMovementWarehouseIdFrom());
        dto.setMovementWarehouseIdTo(e.getMovementWarehouseIdTo());
        dto.setMovementDescription(e.getMovementDescription());
        dto.setMovementCreatedBy(e.getMovementCreatedBy());
        dto.setMovementCreatedAt(e.getMovementCreatedAt());
        dto.setMovementUpdatedBy(e.getMovementUpdatedBy());
        dto.setMovementUpdatedAt(e.getMovementUpdatedAt());
        dto.setMovementActive(e.getMovementActive());
        dto.setMovementDeleted(e.getMovementDeleted());
        dto.setIsPropertyMovementQuantityRemoved(e.getIsPropertyMovementQuantityRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyLocatorIdFromRemoved(e.getIsPropertyLocatorIdFromRemoved());
        dto.setIsPropertyLocatorIdToRemoved(e.getIsPropertyLocatorIdToRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyMovementDocumentStatusIdRemoved(e.getIsPropertyMovementDocumentStatusIdRemoved());
        dto.setIsPropertyMovementMovementDateRemoved(e.getIsPropertyMovementMovementDateRemoved());
        dto.setIsPropertyMovementPostedRemoved(e.getIsPropertyMovementPostedRemoved());
        dto.setIsPropertyMovementProcessedRemoved(e.getIsPropertyMovementProcessedRemoved());
        dto.setIsPropertyMovementProcessingRemoved(e.getIsPropertyMovementProcessingRemoved());
        dto.setIsPropertyMovementDateReceivedRemoved(e.getIsPropertyMovementDateReceivedRemoved());
        dto.setIsPropertyMovementDocumentTypeIdRemoved(e.getIsPropertyMovementDocumentTypeIdRemoved());
        dto.setIsPropertyMovementIsInTransitRemoved(e.getIsPropertyMovementIsInTransitRemoved());
        dto.setIsPropertyMovementIsApprovedRemoved(e.getIsPropertyMovementIsApprovedRemoved());
        dto.setIsPropertyMovementApprovalAmountRemoved(e.getIsPropertyMovementApprovalAmountRemoved());
        dto.setIsPropertyMovementShipperIdRemoved(e.getIsPropertyMovementShipperIdRemoved());
        dto.setIsPropertyMovementSalesRepresentativeIdRemoved(e.getIsPropertyMovementSalesRepresentativeIdRemoved());
        dto.setIsPropertyMovementBusinessPartnerIdRemoved(e.getIsPropertyMovementBusinessPartnerIdRemoved());
        dto.setIsPropertyMovementChargeAmountRemoved(e.getIsPropertyMovementChargeAmountRemoved());
        dto.setIsPropertyMovementCreateFromRemoved(e.getIsPropertyMovementCreateFromRemoved());
        dto.setIsPropertyMovementFreightAmountRemoved(e.getIsPropertyMovementFreightAmountRemoved());
        dto.setIsPropertyMovementReversalDocumentNumberRemoved(e.getIsPropertyMovementReversalDocumentNumberRemoved());
        dto.setIsPropertyMovementWarehouseIdFromRemoved(e.getIsPropertyMovementWarehouseIdFromRemoved());
        dto.setIsPropertyMovementWarehouseIdToRemoved(e.getIsPropertyMovementWarehouseIdToRemoved());
        dto.setIsPropertyMovementDescriptionRemoved(e.getIsPropertyMovementDescriptionRemoved());
        dto.setIsPropertyMovementCreatedByRemoved(e.getIsPropertyMovementCreatedByRemoved());
        dto.setIsPropertyMovementCreatedAtRemoved(e.getIsPropertyMovementCreatedAtRemoved());
        dto.setIsPropertyMovementUpdatedByRemoved(e.getIsPropertyMovementUpdatedByRemoved());
        dto.setIsPropertyMovementUpdatedAtRemoved(e.getIsPropertyMovementUpdatedAtRemoved());
        dto.setIsPropertyMovementActiveRemoved(e.getIsPropertyMovementActiveRemoved());
        dto.setIsPropertyMovementDeletedRemoved(e.getIsPropertyMovementDeletedRemoved());
        return dto;
    }


    public MovementLineMvoStateEventDto.MovementLineMvoStateDeletedDto toMovementLineMvoStateDeletedDto(MovementLineMvoStateEvent.MovementLineMvoStateDeleted e) {
        MovementLineMvoStateEventDto.MovementLineMvoStateDeletedDto dto = new MovementLineMvoStateEventDto.MovementLineMvoStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

