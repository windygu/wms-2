package org.dddml.wms.domain.physicalinventory;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPhysicalInventoryDto extends AbstractPhysicalInventoryCommandDto
{
    /**
     * Warehouse Id
     */
    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    /**
     * Locator Id Pattern
     */
    private String locatorIdPattern;

    public String getLocatorIdPattern()
    {
        return this.locatorIdPattern;
    }

    public void setLocatorIdPattern(String locatorIdPattern)
    {
        this.locatorIdPattern = locatorIdPattern;
    }

    /**
     * Product Id Pattern
     */
    private String productIdPattern;

    public String getProductIdPattern()
    {
        return this.productIdPattern;
    }

    public void setProductIdPattern(String productIdPattern)
    {
        this.productIdPattern = productIdPattern;
    }

    /**
     * Posted
     */
    private Boolean posted;

    public Boolean getPosted()
    {
        return this.posted;
    }

    public void setPosted(Boolean posted)
    {
        this.posted = posted;
    }

    /**
     * Processed
     */
    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    /**
     * Processing
     */
    private String processing;

    public String getProcessing()
    {
        return this.processing;
    }

    public void setProcessing(String processing)
    {
        this.processing = processing;
    }

    /**
     * Document Type Id
     */
    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
    }

    /**
     * Movement Date
     */
    private Date movementDate;

    public Date getMovementDate()
    {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate)
    {
        this.movementDate = movementDate;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Is Approved
     */
    private Boolean isApproved;

    public Boolean getIsApproved()
    {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved)
    {
        this.isApproved = isApproved;
    }

    /**
     * Approval Amount
     */
    private BigDecimal approvalAmount;

    public BigDecimal getApprovalAmount()
    {
        return this.approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount)
    {
        this.approvalAmount = approvalAmount;
    }

    /**
     * Is Quantity Updated
     */
    private Boolean isQuantityUpdated;

    public Boolean getIsQuantityUpdated()
    {
        return this.isQuantityUpdated;
    }

    public void setIsQuantityUpdated(Boolean isQuantityUpdated)
    {
        this.isQuantityUpdated = isQuantityUpdated;
    }

    /**
     * Reversal Document Number
     */
    private String reversalDocumentNumber;

    public String getReversalDocumentNumber()
    {
        return this.reversalDocumentNumber;
    }

    public void setReversalDocumentNumber(String reversalDocumentNumber)
    {
        this.reversalDocumentNumber = reversalDocumentNumber;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private CreateOrMergePatchPhysicalInventoryLineDto[] physicalInventoryLines;

    public CreateOrMergePatchPhysicalInventoryLineDto[] getPhysicalInventoryLines()
    {
        return this.physicalInventoryLines;
    }

    public void setPhysicalInventoryLines(CreateOrMergePatchPhysicalInventoryLineDto[] physicalInventoryLines)
    {
        this.physicalInventoryLines = physicalInventoryLines;
    }

    private Boolean isPropertyWarehouseIdRemoved;

    public Boolean getIsPropertyWarehouseIdRemoved()
    {
        return this.isPropertyWarehouseIdRemoved;
    }

    public void setIsPropertyWarehouseIdRemoved(Boolean removed)
    {
        this.isPropertyWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyLocatorIdPatternRemoved;

    public Boolean getIsPropertyLocatorIdPatternRemoved()
    {
        return this.isPropertyLocatorIdPatternRemoved;
    }

    public void setIsPropertyLocatorIdPatternRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdPatternRemoved = removed;
    }

    private Boolean isPropertyProductIdPatternRemoved;

    public Boolean getIsPropertyProductIdPatternRemoved()
    {
        return this.isPropertyProductIdPatternRemoved;
    }

    public void setIsPropertyProductIdPatternRemoved(Boolean removed)
    {
        this.isPropertyProductIdPatternRemoved = removed;
    }

    private Boolean isPropertyPostedRemoved;

    public Boolean getIsPropertyPostedRemoved()
    {
        return this.isPropertyPostedRemoved;
    }

    public void setIsPropertyPostedRemoved(Boolean removed)
    {
        this.isPropertyPostedRemoved = removed;
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

    private Boolean isPropertyProcessingRemoved;

    public Boolean getIsPropertyProcessingRemoved()
    {
        return this.isPropertyProcessingRemoved;
    }

    public void setIsPropertyProcessingRemoved(Boolean removed)
    {
        this.isPropertyProcessingRemoved = removed;
    }

    private Boolean isPropertyDocumentTypeIdRemoved;

    public Boolean getIsPropertyDocumentTypeIdRemoved()
    {
        return this.isPropertyDocumentTypeIdRemoved;
    }

    public void setIsPropertyDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementDateRemoved;

    public Boolean getIsPropertyMovementDateRemoved()
    {
        return this.isPropertyMovementDateRemoved;
    }

    public void setIsPropertyMovementDateRemoved(Boolean removed)
    {
        this.isPropertyMovementDateRemoved = removed;
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

    private Boolean isPropertyIsApprovedRemoved;

    public Boolean getIsPropertyIsApprovedRemoved()
    {
        return this.isPropertyIsApprovedRemoved;
    }

    public void setIsPropertyIsApprovedRemoved(Boolean removed)
    {
        this.isPropertyIsApprovedRemoved = removed;
    }

    private Boolean isPropertyApprovalAmountRemoved;

    public Boolean getIsPropertyApprovalAmountRemoved()
    {
        return this.isPropertyApprovalAmountRemoved;
    }

    public void setIsPropertyApprovalAmountRemoved(Boolean removed)
    {
        this.isPropertyApprovalAmountRemoved = removed;
    }

    private Boolean isPropertyIsQuantityUpdatedRemoved;

    public Boolean getIsPropertyIsQuantityUpdatedRemoved()
    {
        return this.isPropertyIsQuantityUpdatedRemoved;
    }

    public void setIsPropertyIsQuantityUpdatedRemoved(Boolean removed)
    {
        this.isPropertyIsQuantityUpdatedRemoved = removed;
    }

    private Boolean isPropertyReversalDocumentNumberRemoved;

    public Boolean getIsPropertyReversalDocumentNumberRemoved()
    {
        return this.isPropertyReversalDocumentNumberRemoved;
    }

    public void setIsPropertyReversalDocumentNumberRemoved(Boolean removed)
    {
        this.isPropertyReversalDocumentNumberRemoved = removed;
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

    public static class CreatePhysicalInventoryDto extends CreateOrMergePatchPhysicalInventoryDto
    {
        public CreatePhysicalInventoryDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchPhysicalInventoryDto extends CreateOrMergePatchPhysicalInventoryDto
    {
        public MergePatchPhysicalInventoryDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

