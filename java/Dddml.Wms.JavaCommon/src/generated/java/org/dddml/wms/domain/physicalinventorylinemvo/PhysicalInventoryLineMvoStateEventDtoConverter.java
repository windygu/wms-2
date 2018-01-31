package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineMvoStateEventDtoConverter {

    public PhysicalInventoryLineMvoStateEventDto toPhysicalInventoryLineMvoStateEventDto(AbstractPhysicalInventoryLineMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPhysicalInventoryLineMvoStateEvent.AbstractPhysicalInventoryLineMvoStateCreated) {
            PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated e = (PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated) stateEvent;
            return toPhysicalInventoryLineMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineMvoStateEvent.AbstractPhysicalInventoryLineMvoStateMergePatched) {
            PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched e = (PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched) stateEvent;
            return toPhysicalInventoryLineMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPhysicalInventoryLineMvoStateEvent.AbstractPhysicalInventoryLineMvoStateDeleted) {
            PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted e = (PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted) stateEvent;
            return toPhysicalInventoryLineMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateCreatedDto toPhysicalInventoryLineMvoStateCreatedDto(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated e) {
        PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateCreatedDto dto = new PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateCreatedDto();
        dto.setStateEventId(new PhysicalInventoryLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setPhysicalInventoryDocumentStatusId(e.getPhysicalInventoryDocumentStatusId());
        dto.setPhysicalInventoryWarehouseId(e.getPhysicalInventoryWarehouseId());
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
        dto.setPhysicalInventoryDeleted(e.getPhysicalInventoryDeleted());
        return dto;
    }

    public PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateMergePatchedDto toPhysicalInventoryLineMvoStateMergePatchedDto(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched e) {
        PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateMergePatchedDto dto = new PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateMergePatchedDto();
        dto.setStateEventId(new PhysicalInventoryLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setBookQuantity(e.getBookQuantity());
        dto.setCountedQuantity(e.getCountedQuantity());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setDescription(e.getDescription());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setPhysicalInventoryDocumentStatusId(e.getPhysicalInventoryDocumentStatusId());
        dto.setPhysicalInventoryWarehouseId(e.getPhysicalInventoryWarehouseId());
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
        dto.setPhysicalInventoryDeleted(e.getPhysicalInventoryDeleted());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyBookQuantityRemoved(e.getIsPropertyBookQuantityRemoved());
        dto.setIsPropertyCountedQuantityRemoved(e.getIsPropertyCountedQuantityRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(e.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved());
        dto.setIsPropertyPhysicalInventoryWarehouseIdRemoved(e.getIsPropertyPhysicalInventoryWarehouseIdRemoved());
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
        dto.setIsPropertyPhysicalInventoryDeletedRemoved(e.getIsPropertyPhysicalInventoryDeletedRemoved());
        return dto;
    }


    public PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateDeletedDto toPhysicalInventoryLineMvoStateDeletedDto(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted e) {
        PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateDeletedDto dto = new PhysicalInventoryLineMvoStateEventDto.PhysicalInventoryLineMvoStateDeletedDto();
        dto.setStateEventId(new PhysicalInventoryLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

