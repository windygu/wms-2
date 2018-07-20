package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPhysicalInventoryLineMvoDto extends AbstractPhysicalInventoryLineMvoCommandDto
{
    /**
     * Book Quantity
     */
    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity()
    {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity)
    {
        this.bookQuantity = bookQuantity;
    }

    /**
     * Counted Quantity
     */
    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity()
    {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity)
    {
        this.countedQuantity = countedQuantity;
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
     * Line Number
     */
    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    /**
     * Reversal Line Number
     */
    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    /**
     * Physical Inventory Document Status Id
     */
    private String physicalInventoryDocumentStatusId;

    public String getPhysicalInventoryDocumentStatusId()
    {
        return this.physicalInventoryDocumentStatusId;
    }

    public void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId)
    {
        this.physicalInventoryDocumentStatusId = physicalInventoryDocumentStatusId;
    }

    /**
     * Physical Inventory Warehouse Id
     */
    private String physicalInventoryWarehouseId;

    public String getPhysicalInventoryWarehouseId()
    {
        return this.physicalInventoryWarehouseId;
    }

    public void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId)
    {
        this.physicalInventoryWarehouseId = physicalInventoryWarehouseId;
    }

    /**
     * Physical Inventory Locator Id Pattern
     */
    private String physicalInventoryLocatorIdPattern;

    public String getPhysicalInventoryLocatorIdPattern()
    {
        return this.physicalInventoryLocatorIdPattern;
    }

    public void setPhysicalInventoryLocatorIdPattern(String physicalInventoryLocatorIdPattern)
    {
        this.physicalInventoryLocatorIdPattern = physicalInventoryLocatorIdPattern;
    }

    /**
     * Physical Inventory Product Id Pattern
     */
    private String physicalInventoryProductIdPattern;

    public String getPhysicalInventoryProductIdPattern()
    {
        return this.physicalInventoryProductIdPattern;
    }

    public void setPhysicalInventoryProductIdPattern(String physicalInventoryProductIdPattern)
    {
        this.physicalInventoryProductIdPattern = physicalInventoryProductIdPattern;
    }

    /**
     * Physical Inventory Posted
     */
    private Boolean physicalInventoryPosted;

    public Boolean getPhysicalInventoryPosted()
    {
        return this.physicalInventoryPosted;
    }

    public void setPhysicalInventoryPosted(Boolean physicalInventoryPosted)
    {
        this.physicalInventoryPosted = physicalInventoryPosted;
    }

    /**
     * Physical Inventory Processed
     */
    private Boolean physicalInventoryProcessed;

    public Boolean getPhysicalInventoryProcessed()
    {
        return this.physicalInventoryProcessed;
    }

    public void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed)
    {
        this.physicalInventoryProcessed = physicalInventoryProcessed;
    }

    /**
     * Physical Inventory Processing
     */
    private String physicalInventoryProcessing;

    public String getPhysicalInventoryProcessing()
    {
        return this.physicalInventoryProcessing;
    }

    public void setPhysicalInventoryProcessing(String physicalInventoryProcessing)
    {
        this.physicalInventoryProcessing = physicalInventoryProcessing;
    }

    /**
     * Physical Inventory Document Type Id
     */
    private String physicalInventoryDocumentTypeId;

    public String getPhysicalInventoryDocumentTypeId()
    {
        return this.physicalInventoryDocumentTypeId;
    }

    public void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId)
    {
        this.physicalInventoryDocumentTypeId = physicalInventoryDocumentTypeId;
    }

    /**
     * Physical Inventory Movement Date
     */
    private Date physicalInventoryMovementDate;

    public Date getPhysicalInventoryMovementDate()
    {
        return this.physicalInventoryMovementDate;
    }

    public void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate)
    {
        this.physicalInventoryMovementDate = physicalInventoryMovementDate;
    }

    /**
     * Physical Inventory Description
     */
    private String physicalInventoryDescription;

    public String getPhysicalInventoryDescription()
    {
        return this.physicalInventoryDescription;
    }

    public void setPhysicalInventoryDescription(String physicalInventoryDescription)
    {
        this.physicalInventoryDescription = physicalInventoryDescription;
    }

    /**
     * Physical Inventory Is Approved
     */
    private Boolean physicalInventoryIsApproved;

    public Boolean getPhysicalInventoryIsApproved()
    {
        return this.physicalInventoryIsApproved;
    }

    public void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved)
    {
        this.physicalInventoryIsApproved = physicalInventoryIsApproved;
    }

    /**
     * Physical Inventory Approval Amount
     */
    private BigDecimal physicalInventoryApprovalAmount;

    public BigDecimal getPhysicalInventoryApprovalAmount()
    {
        return this.physicalInventoryApprovalAmount;
    }

    public void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount)
    {
        this.physicalInventoryApprovalAmount = physicalInventoryApprovalAmount;
    }

    /**
     * Physical Inventory Is Quantity Updated
     */
    private Boolean physicalInventoryIsQuantityUpdated;

    public Boolean getPhysicalInventoryIsQuantityUpdated()
    {
        return this.physicalInventoryIsQuantityUpdated;
    }

    public void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated)
    {
        this.physicalInventoryIsQuantityUpdated = physicalInventoryIsQuantityUpdated;
    }

    /**
     * Physical Inventory Reversal Document Number
     */
    private String physicalInventoryReversalDocumentNumber;

    public String getPhysicalInventoryReversalDocumentNumber()
    {
        return this.physicalInventoryReversalDocumentNumber;
    }

    public void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber)
    {
        this.physicalInventoryReversalDocumentNumber = physicalInventoryReversalDocumentNumber;
    }

    /**
     * Physical Inventory Created By
     */
    private String physicalInventoryCreatedBy;

    public String getPhysicalInventoryCreatedBy()
    {
        return this.physicalInventoryCreatedBy;
    }

    public void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy)
    {
        this.physicalInventoryCreatedBy = physicalInventoryCreatedBy;
    }

    /**
     * Physical Inventory Created At
     */
    private Date physicalInventoryCreatedAt;

    public Date getPhysicalInventoryCreatedAt()
    {
        return this.physicalInventoryCreatedAt;
    }

    public void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt)
    {
        this.physicalInventoryCreatedAt = physicalInventoryCreatedAt;
    }

    /**
     * Physical Inventory Updated By
     */
    private String physicalInventoryUpdatedBy;

    public String getPhysicalInventoryUpdatedBy()
    {
        return this.physicalInventoryUpdatedBy;
    }

    public void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy)
    {
        this.physicalInventoryUpdatedBy = physicalInventoryUpdatedBy;
    }

    /**
     * Physical Inventory Updated At
     */
    private Date physicalInventoryUpdatedAt;

    public Date getPhysicalInventoryUpdatedAt()
    {
        return this.physicalInventoryUpdatedAt;
    }

    public void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt)
    {
        this.physicalInventoryUpdatedAt = physicalInventoryUpdatedAt;
    }

    /**
     * Physical Inventory Active
     */
    private Boolean physicalInventoryActive;

    public Boolean getPhysicalInventoryActive()
    {
        return this.physicalInventoryActive;
    }

    public void setPhysicalInventoryActive(Boolean physicalInventoryActive)
    {
        this.physicalInventoryActive = physicalInventoryActive;
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

    private Boolean isPropertyLineNumberRemoved;

    public Boolean getIsPropertyLineNumberRemoved()
    {
        return this.isPropertyLineNumberRemoved;
    }

    public void setIsPropertyLineNumberRemoved(Boolean removed)
    {
        this.isPropertyLineNumberRemoved = removed;
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

    private Boolean isPropertyPhysicalInventoryDocumentStatusIdRemoved;

    public Boolean getIsPropertyPhysicalInventoryDocumentStatusIdRemoved()
    {
        return this.isPropertyPhysicalInventoryDocumentStatusIdRemoved;
    }

    public void setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(Boolean removed)
    {
        this.isPropertyPhysicalInventoryDocumentStatusIdRemoved = removed;
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

    private Boolean isPropertyPhysicalInventoryLocatorIdPatternRemoved;

    public Boolean getIsPropertyPhysicalInventoryLocatorIdPatternRemoved()
    {
        return this.isPropertyPhysicalInventoryLocatorIdPatternRemoved;
    }

    public void setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(Boolean removed)
    {
        this.isPropertyPhysicalInventoryLocatorIdPatternRemoved = removed;
    }

    private Boolean isPropertyPhysicalInventoryProductIdPatternRemoved;

    public Boolean getIsPropertyPhysicalInventoryProductIdPatternRemoved()
    {
        return this.isPropertyPhysicalInventoryProductIdPatternRemoved;
    }

    public void setIsPropertyPhysicalInventoryProductIdPatternRemoved(Boolean removed)
    {
        this.isPropertyPhysicalInventoryProductIdPatternRemoved = removed;
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

    public void copyTo(AbstractPhysicalInventoryLineMvoCommand.AbstractCreateOrMergePatchPhysicalInventoryLineMvo command)
    {
        ((AbstractPhysicalInventoryLineMvoCommandDto) this).copyTo(command);
        command.setBookQuantity(this.getBookQuantity());
        command.setCountedQuantity(this.getCountedQuantity());
        command.setProcessed(this.getProcessed());
        command.setLineNumber(this.getLineNumber());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setDescription(this.getDescription());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setPhysicalInventoryDocumentStatusId(this.getPhysicalInventoryDocumentStatusId());
        command.setPhysicalInventoryWarehouseId(this.getPhysicalInventoryWarehouseId());
        command.setPhysicalInventoryLocatorIdPattern(this.getPhysicalInventoryLocatorIdPattern());
        command.setPhysicalInventoryProductIdPattern(this.getPhysicalInventoryProductIdPattern());
        command.setPhysicalInventoryPosted(this.getPhysicalInventoryPosted());
        command.setPhysicalInventoryProcessed(this.getPhysicalInventoryProcessed());
        command.setPhysicalInventoryProcessing(this.getPhysicalInventoryProcessing());
        command.setPhysicalInventoryDocumentTypeId(this.getPhysicalInventoryDocumentTypeId());
        command.setPhysicalInventoryMovementDate(this.getPhysicalInventoryMovementDate());
        command.setPhysicalInventoryDescription(this.getPhysicalInventoryDescription());
        command.setPhysicalInventoryIsApproved(this.getPhysicalInventoryIsApproved());
        command.setPhysicalInventoryApprovalAmount(this.getPhysicalInventoryApprovalAmount());
        command.setPhysicalInventoryIsQuantityUpdated(this.getPhysicalInventoryIsQuantityUpdated());
        command.setPhysicalInventoryReversalDocumentNumber(this.getPhysicalInventoryReversalDocumentNumber());
        command.setPhysicalInventoryCreatedBy(this.getPhysicalInventoryCreatedBy());
        command.setPhysicalInventoryCreatedAt(this.getPhysicalInventoryCreatedAt());
        command.setPhysicalInventoryUpdatedBy(this.getPhysicalInventoryUpdatedBy());
        command.setPhysicalInventoryUpdatedAt(this.getPhysicalInventoryUpdatedAt());
        command.setPhysicalInventoryActive(this.getPhysicalInventoryActive());
    }

    public PhysicalInventoryLineMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPhysicalInventoryLineMvoCommand.SimpleCreatePhysicalInventoryLineMvo command = new AbstractPhysicalInventoryLineMvoCommand.SimpleCreatePhysicalInventoryLineMvo();
            copyTo((AbstractPhysicalInventoryLineMvoCommand.AbstractCreatePhysicalInventoryLineMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPhysicalInventoryLineMvoCommand.SimpleMergePatchPhysicalInventoryLineMvo command = new AbstractPhysicalInventoryLineMvoCommand.SimpleMergePatchPhysicalInventoryLineMvo();
            copyTo((AbstractPhysicalInventoryLineMvoCommand.SimpleMergePatchPhysicalInventoryLineMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPhysicalInventoryLineMvoCommand.AbstractCreatePhysicalInventoryLineMvo command)
    {
        copyTo((AbstractPhysicalInventoryLineMvoCommand.AbstractCreateOrMergePatchPhysicalInventoryLineMvo) command);
    }

    public void copyTo(AbstractPhysicalInventoryLineMvoCommand.AbstractMergePatchPhysicalInventoryLineMvo command)
    {
        copyTo((AbstractPhysicalInventoryLineMvoCommand.AbstractCreateOrMergePatchPhysicalInventoryLineMvo) command);
        command.setIsPropertyBookQuantityRemoved(this.getIsPropertyBookQuantityRemoved());
        command.setIsPropertyCountedQuantityRemoved(this.getIsPropertyCountedQuantityRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyLineNumberRemoved(this.getIsPropertyLineNumberRemoved());
        command.setIsPropertyReversalLineNumberRemoved(this.getIsPropertyReversalLineNumberRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(this.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved());
        command.setIsPropertyPhysicalInventoryWarehouseIdRemoved(this.getIsPropertyPhysicalInventoryWarehouseIdRemoved());
        command.setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(this.getIsPropertyPhysicalInventoryLocatorIdPatternRemoved());
        command.setIsPropertyPhysicalInventoryProductIdPatternRemoved(this.getIsPropertyPhysicalInventoryProductIdPatternRemoved());
        command.setIsPropertyPhysicalInventoryPostedRemoved(this.getIsPropertyPhysicalInventoryPostedRemoved());
        command.setIsPropertyPhysicalInventoryProcessedRemoved(this.getIsPropertyPhysicalInventoryProcessedRemoved());
        command.setIsPropertyPhysicalInventoryProcessingRemoved(this.getIsPropertyPhysicalInventoryProcessingRemoved());
        command.setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(this.getIsPropertyPhysicalInventoryDocumentTypeIdRemoved());
        command.setIsPropertyPhysicalInventoryMovementDateRemoved(this.getIsPropertyPhysicalInventoryMovementDateRemoved());
        command.setIsPropertyPhysicalInventoryDescriptionRemoved(this.getIsPropertyPhysicalInventoryDescriptionRemoved());
        command.setIsPropertyPhysicalInventoryIsApprovedRemoved(this.getIsPropertyPhysicalInventoryIsApprovedRemoved());
        command.setIsPropertyPhysicalInventoryApprovalAmountRemoved(this.getIsPropertyPhysicalInventoryApprovalAmountRemoved());
        command.setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(this.getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved());
        command.setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(this.getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved());
        command.setIsPropertyPhysicalInventoryCreatedByRemoved(this.getIsPropertyPhysicalInventoryCreatedByRemoved());
        command.setIsPropertyPhysicalInventoryCreatedAtRemoved(this.getIsPropertyPhysicalInventoryCreatedAtRemoved());
        command.setIsPropertyPhysicalInventoryUpdatedByRemoved(this.getIsPropertyPhysicalInventoryUpdatedByRemoved());
        command.setIsPropertyPhysicalInventoryUpdatedAtRemoved(this.getIsPropertyPhysicalInventoryUpdatedAtRemoved());
        command.setIsPropertyPhysicalInventoryActiveRemoved(this.getIsPropertyPhysicalInventoryActiveRemoved());
    }

    public static class CreatePhysicalInventoryLineMvoDto extends CreateOrMergePatchPhysicalInventoryLineMvoDto
    {
        public CreatePhysicalInventoryLineMvoDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo toCreatePhysicalInventoryLineMvo()
        {
            return (PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo) toCommand();
        }

    }

    public static class MergePatchPhysicalInventoryLineMvoDto extends CreateOrMergePatchPhysicalInventoryLineMvoDto
    {
        public MergePatchPhysicalInventoryLineMvoDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo toMergePatchPhysicalInventoryLineMvo()
        {
            return (PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo) toCommand();
        }

    }

}

