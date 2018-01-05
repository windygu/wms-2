package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PhysicalInventoryLineMvoCommand extends Command
{
    PhysicalInventoryLineId getPhysicalInventoryLineId();

    void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId);

    Long getPhysicalInventoryVersion();

    void setPhysicalInventoryVersion(Long physicalInventoryVersion);

    static void throwOnInvalidStateTransition(PhysicalInventoryLineMvoState state, Command c) {
        if (state.getPhysicalInventoryVersion() == null)
        {
            if (isCommandCreate((PhysicalInventoryLineMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PhysicalInventoryLineMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PhysicalInventoryLineMvoCommand c) {
        return ((c instanceof PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo) 
            && c.getPhysicalInventoryVersion().equals(PhysicalInventoryLineMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchPhysicalInventoryLineMvo extends PhysicalInventoryLineMvoCommand
    {
        String getLocatorId();

        void setLocatorId(String locatorId);

        String getProductId();

        void setProductId(String productId);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        BigDecimal getBookQuantity();

        void setBookQuantity(BigDecimal bookQuantity);

        BigDecimal getCountedQuantity();

        void setCountedQuantity(BigDecimal countedQuantity);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        Long getReversalLineNumber();

        void setReversalLineNumber(Long reversalLineNumber);

        String getDescription();

        void setDescription(String description);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getPhysicalInventoryDocumentStatusId();

        void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId);

        String getPhysicalInventoryWarehouseId();

        void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId);

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

        Boolean getPhysicalInventoryDeleted();

        void setPhysicalInventoryDeleted(Boolean physicalInventoryDeleted);

    }

    interface CreatePhysicalInventoryLineMvo extends CreateOrMergePatchPhysicalInventoryLineMvo
    {
    }

    interface MergePatchPhysicalInventoryLineMvo extends CreateOrMergePatchPhysicalInventoryLineMvo
    {
        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyBookQuantityRemoved();

        void setIsPropertyBookQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCountedQuantityRemoved();

        void setIsPropertyCountedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryDocumentStatusIdRemoved();

        void setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPhysicalInventoryWarehouseIdRemoved();

        void setIsPropertyPhysicalInventoryWarehouseIdRemoved(Boolean removed);

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

        Boolean getIsPropertyPhysicalInventoryDeletedRemoved();

        void setIsPropertyPhysicalInventoryDeletedRemoved(Boolean removed);

    }

	interface DeletePhysicalInventoryLineMvo extends PhysicalInventoryLineMvoCommand
	{
	}

}

