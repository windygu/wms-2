package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineMvoStateEventDtoConverter {

    public PhysicalInventoryLineMvoStateEventDto toPhysicalInventoryLineMvoStateEventDto(AbstractPhysicalInventoryLineMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractPhysicalInventoryLineMvoEvent.AbstractPhysicalInventoryLineMvoStateCreated) {
            PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated e = (PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated) stateEvent;
            return toPhysicalInventoryLineMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineMvoEvent.AbstractPhysicalInventoryLineMvoStateMergePatched) {
            PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched e = (PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched) stateEvent;
            return toPhysicalInventoryLineMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineMvoEvent.AbstractPhysicalInventoryLineMvoStateDeleted) {
            PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted e = (PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted) stateEvent;
            return toPhysicalInventoryLineMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateCreatedDto toPhysicalInventoryLineMvoStateCreatedDto(PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated e) {
        PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateCreatedDto dto = new PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateCreatedDto();
        dto.setPhysicalInventoryLineMvoEventId(e.getPhysicalInventoryLineMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setLineNumber(e.getLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setVersion(e.getVersion());
        dto.setPhysicalInventoryDocumentStatusId(e.getPhysicalInventoryDocumentStatusId());
        dto.setPhysicalInventoryWarehouseId(e.getPhysicalInventoryWarehouseId());
        dto.setPhysicalInventoryLocatorIdPattern(e.getPhysicalInventoryLocatorIdPattern());
        dto.setPhysicalInventoryProductIdPattern(e.getPhysicalInventoryProductIdPattern());
        dto.setPhysicalInventoryPosted(e.getPhysicalInventoryPosted());
        dto.setPhysicalInventoryProcessed(e.getPhysicalInventoryProcessed());
        dto.setPhysicalInventoryProcessing(e.getPhysicalInventoryProcessing());
        dto.setPhysicalInventoryDocumentTypeId(e.getPhysicalInventoryDocumentTypeId());
        dto.setPhysicalInventoryMovementDate(e.getPhysicalInventoryMovementDate());
        dto.setPhysicalInventoryDescription(e.getPhysicalInventoryDescription());
        dto.setPhysicalInventoryIsApproved(e.getPhysicalInventoryIsApproved());
        dto.setPhysicalInventoryApprovalAmount(e.getPhysicalInventoryApprovalAmount());
        dto.setPhysicalInventoryIsQuantityUpdated(e.getPhysicalInventoryIsQuantityUpdated());
        dto.setPhysicalInventoryReversalDocumentNumber(e.getPhysicalInventoryReversalDocumentNumber());
        dto.setPhysicalInventoryCreatedBy(e.getPhysicalInventoryCreatedBy());
        dto.setPhysicalInventoryCreatedAt(e.getPhysicalInventoryCreatedAt());
        dto.setPhysicalInventoryUpdatedBy(e.getPhysicalInventoryUpdatedBy());
        dto.setPhysicalInventoryUpdatedAt(e.getPhysicalInventoryUpdatedAt());
        dto.setPhysicalInventoryActive(e.getPhysicalInventoryActive());
        return dto;
    }

    public PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateMergePatchedDto toPhysicalInventoryLineMvoStateMergePatchedDto(PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched e) {
        PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateMergePatchedDto dto = new PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateMergePatchedDto();
        dto.setPhysicalInventoryLineMvoEventId(e.getPhysicalInventoryLineMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setLineNumber(e.getLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setVersion(e.getVersion());
        dto.setPhysicalInventoryDocumentStatusId(e.getPhysicalInventoryDocumentStatusId());
        dto.setPhysicalInventoryWarehouseId(e.getPhysicalInventoryWarehouseId());
        dto.setPhysicalInventoryLocatorIdPattern(e.getPhysicalInventoryLocatorIdPattern());
        dto.setPhysicalInventoryProductIdPattern(e.getPhysicalInventoryProductIdPattern());
        dto.setPhysicalInventoryPosted(e.getPhysicalInventoryPosted());
        dto.setPhysicalInventoryProcessed(e.getPhysicalInventoryProcessed());
        dto.setPhysicalInventoryProcessing(e.getPhysicalInventoryProcessing());
        dto.setPhysicalInventoryDocumentTypeId(e.getPhysicalInventoryDocumentTypeId());
        dto.setPhysicalInventoryMovementDate(e.getPhysicalInventoryMovementDate());
        dto.setPhysicalInventoryDescription(e.getPhysicalInventoryDescription());
        dto.setPhysicalInventoryIsApproved(e.getPhysicalInventoryIsApproved());
        dto.setPhysicalInventoryApprovalAmount(e.getPhysicalInventoryApprovalAmount());
        dto.setPhysicalInventoryIsQuantityUpdated(e.getPhysicalInventoryIsQuantityUpdated());
        dto.setPhysicalInventoryReversalDocumentNumber(e.getPhysicalInventoryReversalDocumentNumber());
        dto.setPhysicalInventoryCreatedBy(e.getPhysicalInventoryCreatedBy());
        dto.setPhysicalInventoryCreatedAt(e.getPhysicalInventoryCreatedAt());
        dto.setPhysicalInventoryUpdatedBy(e.getPhysicalInventoryUpdatedBy());
        dto.setPhysicalInventoryUpdatedAt(e.getPhysicalInventoryUpdatedAt());
        dto.setPhysicalInventoryActive(e.getPhysicalInventoryActive());
        dto.setIsPropertyBookQuantityRemoved(e.getIsPropertyBookQuantityRemoved());
        dto.setIsPropertyCountedQuantityRemoved(e.getIsPropertyCountedQuantityRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyLineNumberRemoved(e.getIsPropertyLineNumberRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(e.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved());
        dto.setIsPropertyPhysicalInventoryWarehouseIdRemoved(e.getIsPropertyPhysicalInventoryWarehouseIdRemoved());
        dto.setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(e.getIsPropertyPhysicalInventoryLocatorIdPatternRemoved());
        dto.setIsPropertyPhysicalInventoryProductIdPatternRemoved(e.getIsPropertyPhysicalInventoryProductIdPatternRemoved());
        dto.setIsPropertyPhysicalInventoryPostedRemoved(e.getIsPropertyPhysicalInventoryPostedRemoved());
        dto.setIsPropertyPhysicalInventoryProcessedRemoved(e.getIsPropertyPhysicalInventoryProcessedRemoved());
        dto.setIsPropertyPhysicalInventoryProcessingRemoved(e.getIsPropertyPhysicalInventoryProcessingRemoved());
        dto.setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(e.getIsPropertyPhysicalInventoryDocumentTypeIdRemoved());
        dto.setIsPropertyPhysicalInventoryMovementDateRemoved(e.getIsPropertyPhysicalInventoryMovementDateRemoved());
        dto.setIsPropertyPhysicalInventoryDescriptionRemoved(e.getIsPropertyPhysicalInventoryDescriptionRemoved());
        dto.setIsPropertyPhysicalInventoryIsApprovedRemoved(e.getIsPropertyPhysicalInventoryIsApprovedRemoved());
        dto.setIsPropertyPhysicalInventoryApprovalAmountRemoved(e.getIsPropertyPhysicalInventoryApprovalAmountRemoved());
        dto.setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(e.getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved());
        dto.setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(e.getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved());
        dto.setIsPropertyPhysicalInventoryCreatedByRemoved(e.getIsPropertyPhysicalInventoryCreatedByRemoved());
        dto.setIsPropertyPhysicalInventoryCreatedAtRemoved(e.getIsPropertyPhysicalInventoryCreatedAtRemoved());
        dto.setIsPropertyPhysicalInventoryUpdatedByRemoved(e.getIsPropertyPhysicalInventoryUpdatedByRemoved());
        dto.setIsPropertyPhysicalInventoryUpdatedAtRemoved(e.getIsPropertyPhysicalInventoryUpdatedAtRemoved());
        dto.setIsPropertyPhysicalInventoryActiveRemoved(e.getIsPropertyPhysicalInventoryActiveRemoved());
        return dto;
    }


    public PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateDeletedDto toPhysicalInventoryLineMvoStateDeletedDto(PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted e) {
        PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateDeletedDto dto = new PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateDeletedDto();
        dto.setPhysicalInventoryLineMvoEventId(e.getPhysicalInventoryLineMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

