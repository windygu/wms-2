package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PhysicalInventoryLineMvoEvent extends Event
{
    PhysicalInventoryLineMvoEventId getPhysicalInventoryLineMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PhysicalInventoryLineMvoStateEvent extends PhysicalInventoryLineMvoEvent {
        BigDecimal getBookQuantity();

        void setBookQuantity(BigDecimal bookQuantity);

        BigDecimal getCountedQuantity();

        void setCountedQuantity(BigDecimal countedQuantity);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getLineNumber();

        void setLineNumber(String lineNumber);

        Long getReversalLineNumber();

        void setReversalLineNumber(Long reversalLineNumber);

        String getDescription();

        void setDescription(String description);

        Long getVersion();

        void setVersion(Long version);

        String getPhysicalInventoryDocumentStatusId();

        void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId);

        String getPhysicalInventoryWarehouseId();

        void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId);

        String getPhysicalInventoryLocatorIdPattern();

        void setPhysicalInventoryLocatorIdPattern(String physicalInventoryLocatorIdPattern);

        String getPhysicalInventoryProductIdPattern();

        void setPhysicalInventoryProductIdPattern(String physicalInventoryProductIdPattern);

        Boolean getPhysicalInventoryPosted();

        void setPhysicalInventoryPosted(Boolean physicalInventoryPosted);

        Boolean getPhysicalInventoryProcessed();

        void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed);

        String getPhysicalInventoryProcessing();

        void setPhysicalInventoryProcessing(String physicalInventoryProcessing);

        String getPhysicalInventoryDocumentTypeId();

        void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId);

        Date getPhysicalInventoryMovementDate();

        void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate);

        String getPhysicalInventoryDescription();

        void setPhysicalInventoryDescription(String physicalInventoryDescription);

        Boolean getPhysicalInventoryIsApproved();

        void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved);

        BigDecimal getPhysicalInventoryApprovalAmount();

        void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount);

        Boolean getPhysicalInventoryIsQuantityUpdated();

        void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated);

        String getPhysicalInventoryReversalDocumentNumber();

        void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber);

        String getPhysicalInventoryCreatedBy();

        void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy);

        Date getPhysicalInventoryCreatedAt();

        void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt);

        String getPhysicalInventoryUpdatedBy();

        void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy);

        Date getPhysicalInventoryUpdatedAt();

        void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt);

        Boolean getPhysicalInventoryActive();

        void setPhysicalInventoryActive(Boolean physicalInventoryActive);

    }

    interface PhysicalInventoryLineMvoStateCreated extends PhysicalInventoryLineMvoStateEvent
    {
    
    }


    interface PhysicalInventoryLineMvoStateMergePatched extends PhysicalInventoryLineMvoStateEvent
    {
        Boolean getIsPropertyBookQuantityRemoved();

        void setIsPropertyBookQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCountedQuantityRemoved();

        void setIsPropertyCountedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyLineNumberRemoved();

        void setIsPropertyLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryDocumentStatusIdRemoved();

        void setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryWarehouseIdRemoved();

        void setIsPropertyPhysicalInventoryWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryLocatorIdPatternRemoved();

        void setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryProductIdPatternRemoved();

        void setIsPropertyPhysicalInventoryProductIdPatternRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryPostedRemoved();

        void setIsPropertyPhysicalInventoryPostedRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryProcessedRemoved();

        void setIsPropertyPhysicalInventoryProcessedRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryProcessingRemoved();

        void setIsPropertyPhysicalInventoryProcessingRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryDocumentTypeIdRemoved();

        void setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryMovementDateRemoved();

        void setIsPropertyPhysicalInventoryMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryDescriptionRemoved();

        void setIsPropertyPhysicalInventoryDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryIsApprovedRemoved();

        void setIsPropertyPhysicalInventoryIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryApprovalAmountRemoved();

        void setIsPropertyPhysicalInventoryApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved();

        void setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved();

        void setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryCreatedByRemoved();

        void setIsPropertyPhysicalInventoryCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryCreatedAtRemoved();

        void setIsPropertyPhysicalInventoryCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryUpdatedByRemoved();

        void setIsPropertyPhysicalInventoryUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryUpdatedAtRemoved();

        void setIsPropertyPhysicalInventoryUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryActiveRemoved();

        void setIsPropertyPhysicalInventoryActiveRemoved(Boolean removed);


    }

    interface PhysicalInventoryLineMvoStateDeleted extends PhysicalInventoryLineMvoStateEvent
    {
    }


}

