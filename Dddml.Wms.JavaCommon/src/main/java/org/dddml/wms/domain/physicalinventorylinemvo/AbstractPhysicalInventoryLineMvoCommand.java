package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPhysicalInventoryLineMvoCommand extends AbstractCommand implements PhysicalInventoryLineMvoCommand
{
    private PhysicalInventoryLineId physicalInventoryLineId;

    public PhysicalInventoryLineId getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
    }


    public static abstract class AbstractCreateOrMergePatchPhysicalInventoryLineMvo extends AbstractPhysicalInventoryLineMvoCommand implements CreateOrMergePatchPhysicalInventoryLineMvo
    {
        private String locatorId;

        public String getLocatorId()
        {
            return this.locatorId;
        }

        public void setLocatorId(String locatorId)
        {
            this.locatorId = locatorId;
        }

        private String productId;

        public String getProductId()
        {
            return this.productId;
        }

        public void setProductId(String productId)
        {
            this.productId = productId;
        }

        private String attributeSetInstanceId;

        public String getAttributeSetInstanceId()
        {
            return this.attributeSetInstanceId;
        }

        public void setAttributeSetInstanceId(String attributeSetInstanceId)
        {
            this.attributeSetInstanceId = attributeSetInstanceId;
        }

        private BigDecimal bookQuantity;

        public BigDecimal getBookQuantity()
        {
            return this.bookQuantity;
        }

        public void setBookQuantity(BigDecimal bookQuantity)
        {
            this.bookQuantity = bookQuantity;
        }

        private BigDecimal countedQuantity;

        public BigDecimal getCountedQuantity()
        {
            return this.countedQuantity;
        }

        public void setCountedQuantity(BigDecimal countedQuantity)
        {
            this.countedQuantity = countedQuantity;
        }

        private Boolean processed;

        public Boolean getProcessed()
        {
            return this.processed;
        }

        public void setProcessed(Boolean processed)
        {
            this.processed = processed;
        }

        private Long reversalLineNumber;

        public Long getReversalLineNumber()
        {
            return this.reversalLineNumber;
        }

        public void setReversalLineNumber(Long reversalLineNumber)
        {
            this.reversalLineNumber = reversalLineNumber;
        }

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        private String documentAction;

        public String getDocumentAction()
        {
            return this.documentAction;
        }

        public void setDocumentAction(String documentAction)
        {
            this.documentAction = documentAction;
        }

        private String physicalInventoryWarehouseId;

        public String getPhysicalInventoryWarehouseId()
        {
            return this.physicalInventoryWarehouseId;
        }

        public void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId)
        {
            this.physicalInventoryWarehouseId = physicalInventoryWarehouseId;
        }

        private Boolean physicalInventoryPosted;

        public Boolean getPhysicalInventoryPosted()
        {
            return this.physicalInventoryPosted;
        }

        public void setPhysicalInventoryPosted(Boolean physicalInventoryPosted)
        {
            this.physicalInventoryPosted = physicalInventoryPosted;
        }

        private Boolean physicalInventoryProcessed;

        public Boolean getPhysicalInventoryProcessed()
        {
            return this.physicalInventoryProcessed;
        }

        public void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed)
        {
            this.physicalInventoryProcessed = physicalInventoryProcessed;
        }

        private String physicalInventoryProcessing;

        public String getPhysicalInventoryProcessing()
        {
            return this.physicalInventoryProcessing;
        }

        public void setPhysicalInventoryProcessing(String physicalInventoryProcessing)
        {
            this.physicalInventoryProcessing = physicalInventoryProcessing;
        }

        private String physicalInventoryDocumentTypeId;

        public String getPhysicalInventoryDocumentTypeId()
        {
            return this.physicalInventoryDocumentTypeId;
        }

        public void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId)
        {
            this.physicalInventoryDocumentTypeId = physicalInventoryDocumentTypeId;
        }

        private Date physicalInventoryMovementDate;

        public Date getPhysicalInventoryMovementDate()
        {
            return this.physicalInventoryMovementDate;
        }

        public void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate)
        {
            this.physicalInventoryMovementDate = physicalInventoryMovementDate;
        }

        private String physicalInventoryDescription;

        public String getPhysicalInventoryDescription()
        {
            return this.physicalInventoryDescription;
        }

        public void setPhysicalInventoryDescription(String physicalInventoryDescription)
        {
            this.physicalInventoryDescription = physicalInventoryDescription;
        }

        private Boolean physicalInventoryIsApproved;

        public Boolean getPhysicalInventoryIsApproved()
        {
            return this.physicalInventoryIsApproved;
        }

        public void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved)
        {
            this.physicalInventoryIsApproved = physicalInventoryIsApproved;
        }

        private BigDecimal physicalInventoryApprovalAmount;

        public BigDecimal getPhysicalInventoryApprovalAmount()
        {
            return this.physicalInventoryApprovalAmount;
        }

        public void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount)
        {
            this.physicalInventoryApprovalAmount = physicalInventoryApprovalAmount;
        }

        private Boolean physicalInventoryIsQuantityUpdated;

        public Boolean getPhysicalInventoryIsQuantityUpdated()
        {
            return this.physicalInventoryIsQuantityUpdated;
        }

        public void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated)
        {
            this.physicalInventoryIsQuantityUpdated = physicalInventoryIsQuantityUpdated;
        }

        private String physicalInventoryReversalDocumentNumber;

        public String getPhysicalInventoryReversalDocumentNumber()
        {
            return this.physicalInventoryReversalDocumentNumber;
        }

        public void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber)
        {
            this.physicalInventoryReversalDocumentNumber = physicalInventoryReversalDocumentNumber;
        }

        private String physicalInventoryCreatedBy;

        public String getPhysicalInventoryCreatedBy()
        {
            return this.physicalInventoryCreatedBy;
        }

        public void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy)
        {
            this.physicalInventoryCreatedBy = physicalInventoryCreatedBy;
        }

        private Date physicalInventoryCreatedAt;

        public Date getPhysicalInventoryCreatedAt()
        {
            return this.physicalInventoryCreatedAt;
        }

        public void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt)
        {
            this.physicalInventoryCreatedAt = physicalInventoryCreatedAt;
        }

        private String physicalInventoryUpdatedBy;

        public String getPhysicalInventoryUpdatedBy()
        {
            return this.physicalInventoryUpdatedBy;
        }

        public void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy)
        {
            this.physicalInventoryUpdatedBy = physicalInventoryUpdatedBy;
        }

        private Date physicalInventoryUpdatedAt;

        public Date getPhysicalInventoryUpdatedAt()
        {
            return this.physicalInventoryUpdatedAt;
        }

        public void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt)
        {
            this.physicalInventoryUpdatedAt = physicalInventoryUpdatedAt;
        }

        private Boolean physicalInventoryActive;

        public Boolean getPhysicalInventoryActive()
        {
            return this.physicalInventoryActive;
        }

        public void setPhysicalInventoryActive(Boolean physicalInventoryActive)
        {
            this.physicalInventoryActive = physicalInventoryActive;
        }

        private Boolean physicalInventoryDeleted;

        public Boolean getPhysicalInventoryDeleted()
        {
            return this.physicalInventoryDeleted;
        }

        public void setPhysicalInventoryDeleted(Boolean physicalInventoryDeleted)
        {
            this.physicalInventoryDeleted = physicalInventoryDeleted;
        }

    }

    public static abstract class AbstractCreatePhysicalInventoryLineMvo extends AbstractCreateOrMergePatchPhysicalInventoryLineMvo implements CreatePhysicalInventoryLineMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchPhysicalInventoryLineMvo extends AbstractCreateOrMergePatchPhysicalInventoryLineMvo implements MergePatchPhysicalInventoryLineMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyLocatorIdRemoved;

        public Boolean getIsPropertyLocatorIdRemoved()
        {
            return this.isPropertyLocatorIdRemoved;
        }

        public void setIsPropertyLocatorIdRemoved(Boolean removed)
        {
            this.isPropertyLocatorIdRemoved = removed;
        }

        private Boolean isPropertyProductIdRemoved;

        public Boolean getIsPropertyProductIdRemoved()
        {
            return this.isPropertyProductIdRemoved;
        }

        public void setIsPropertyProductIdRemoved(Boolean removed)
        {
            this.isPropertyProductIdRemoved = removed;
        }

        private Boolean isPropertyAttributeSetInstanceIdRemoved;

        public Boolean getIsPropertyAttributeSetInstanceIdRemoved()
        {
            return this.isPropertyAttributeSetInstanceIdRemoved;
        }

        public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed)
        {
            this.isPropertyAttributeSetInstanceIdRemoved = removed;
        }

        private Boolean isPropertyBookQuantityRemoved;

        public Boolean getIsPropertyBookQuantityRemoved()
        {
            return this.isPropertyBookQuantityRemoved;
        }

        public void setIsPropertyBookQuantityRemoved(Boolean removed)
        {
            this.isPropertyBookQuantityRemoved = removed;
        }

        private Boolean isPropertyCountedQuantityRemoved;

        public Boolean getIsPropertyCountedQuantityRemoved()
        {
            return this.isPropertyCountedQuantityRemoved;
        }

        public void setIsPropertyCountedQuantityRemoved(Boolean removed)
        {
            this.isPropertyCountedQuantityRemoved = removed;
        }

        private Boolean isPropertyProcessedRemoved;

        public Boolean getIsPropertyProcessedRemoved()
        {
            return this.isPropertyProcessedRemoved;
        }

        public void setIsPropertyProcessedRemoved(Boolean removed)
        {
            this.isPropertyProcessedRemoved = removed;
        }

        private Boolean isPropertyReversalLineNumberRemoved;

        public Boolean getIsPropertyReversalLineNumberRemoved()
        {
            return this.isPropertyReversalLineNumberRemoved;
        }

        public void setIsPropertyReversalLineNumberRemoved(Boolean removed)
        {
            this.isPropertyReversalLineNumberRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved()
        {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed)
        {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved()
        {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed)
        {
            this.isPropertyVersionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryWarehouseIdRemoved;

        public Boolean getIsPropertyPhysicalInventoryWarehouseIdRemoved()
        {
            return this.isPropertyPhysicalInventoryWarehouseIdRemoved;
        }

        public void setIsPropertyPhysicalInventoryWarehouseIdRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryWarehouseIdRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryPostedRemoved;

        public Boolean getIsPropertyPhysicalInventoryPostedRemoved()
        {
            return this.isPropertyPhysicalInventoryPostedRemoved;
        }

        public void setIsPropertyPhysicalInventoryPostedRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryPostedRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryProcessedRemoved;

        public Boolean getIsPropertyPhysicalInventoryProcessedRemoved()
        {
            return this.isPropertyPhysicalInventoryProcessedRemoved;
        }

        public void setIsPropertyPhysicalInventoryProcessedRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryProcessedRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryProcessingRemoved;

        public Boolean getIsPropertyPhysicalInventoryProcessingRemoved()
        {
            return this.isPropertyPhysicalInventoryProcessingRemoved;
        }

        public void setIsPropertyPhysicalInventoryProcessingRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryProcessingRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryDocumentTypeIdRemoved;

        public Boolean getIsPropertyPhysicalInventoryDocumentTypeIdRemoved()
        {
            return this.isPropertyPhysicalInventoryDocumentTypeIdRemoved;
        }

        public void setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryDocumentTypeIdRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryMovementDateRemoved;

        public Boolean getIsPropertyPhysicalInventoryMovementDateRemoved()
        {
            return this.isPropertyPhysicalInventoryMovementDateRemoved;
        }

        public void setIsPropertyPhysicalInventoryMovementDateRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryMovementDateRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryDescriptionRemoved;

        public Boolean getIsPropertyPhysicalInventoryDescriptionRemoved()
        {
            return this.isPropertyPhysicalInventoryDescriptionRemoved;
        }

        public void setIsPropertyPhysicalInventoryDescriptionRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryDescriptionRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryIsApprovedRemoved;

        public Boolean getIsPropertyPhysicalInventoryIsApprovedRemoved()
        {
            return this.isPropertyPhysicalInventoryIsApprovedRemoved;
        }

        public void setIsPropertyPhysicalInventoryIsApprovedRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryIsApprovedRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryApprovalAmountRemoved;

        public Boolean getIsPropertyPhysicalInventoryApprovalAmountRemoved()
        {
            return this.isPropertyPhysicalInventoryApprovalAmountRemoved;
        }

        public void setIsPropertyPhysicalInventoryApprovalAmountRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryApprovalAmountRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryIsQuantityUpdatedRemoved;

        public Boolean getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved()
        {
            return this.isPropertyPhysicalInventoryIsQuantityUpdatedRemoved;
        }

        public void setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryIsQuantityUpdatedRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryReversalDocumentNumberRemoved;

        public Boolean getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved()
        {
            return this.isPropertyPhysicalInventoryReversalDocumentNumberRemoved;
        }

        public void setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryReversalDocumentNumberRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryCreatedByRemoved;

        public Boolean getIsPropertyPhysicalInventoryCreatedByRemoved()
        {
            return this.isPropertyPhysicalInventoryCreatedByRemoved;
        }

        public void setIsPropertyPhysicalInventoryCreatedByRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryCreatedByRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryCreatedAtRemoved;

        public Boolean getIsPropertyPhysicalInventoryCreatedAtRemoved()
        {
            return this.isPropertyPhysicalInventoryCreatedAtRemoved;
        }

        public void setIsPropertyPhysicalInventoryCreatedAtRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryCreatedAtRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryUpdatedByRemoved;

        public Boolean getIsPropertyPhysicalInventoryUpdatedByRemoved()
        {
            return this.isPropertyPhysicalInventoryUpdatedByRemoved;
        }

        public void setIsPropertyPhysicalInventoryUpdatedByRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryUpdatedByRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryUpdatedAtRemoved;

        public Boolean getIsPropertyPhysicalInventoryUpdatedAtRemoved()
        {
            return this.isPropertyPhysicalInventoryUpdatedAtRemoved;
        }

        public void setIsPropertyPhysicalInventoryUpdatedAtRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryActiveRemoved;

        public Boolean getIsPropertyPhysicalInventoryActiveRemoved()
        {
            return this.isPropertyPhysicalInventoryActiveRemoved;
        }

        public void setIsPropertyPhysicalInventoryActiveRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryActiveRemoved = removed;
        }

        private Boolean isPropertyPhysicalInventoryDeletedRemoved;

        public Boolean getIsPropertyPhysicalInventoryDeletedRemoved()
        {
            return this.isPropertyPhysicalInventoryDeletedRemoved;
        }

        public void setIsPropertyPhysicalInventoryDeletedRemoved(Boolean removed)
        {
            this.isPropertyPhysicalInventoryDeletedRemoved = removed;
        }

    }

    public static class SimpleCreatePhysicalInventoryLineMvo extends AbstractCreatePhysicalInventoryLineMvo
    {
    }

    
    public static class SimpleMergePatchPhysicalInventoryLineMvo extends AbstractMergePatchPhysicalInventoryLineMvo
    {
    }

    
	public static class SimpleDeletePhysicalInventoryLineMvo extends AbstractPhysicalInventoryLineMvoCommand implements DeletePhysicalInventoryLineMvo
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

