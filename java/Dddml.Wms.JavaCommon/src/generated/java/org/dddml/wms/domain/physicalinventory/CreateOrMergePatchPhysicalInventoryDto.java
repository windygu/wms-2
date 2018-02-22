package org.dddml.wms.domain.physicalinventory;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPhysicalInventoryDto extends AbstractPhysicalInventoryCommandDto
{
    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String locatorIdPattern;

    public String getLocatorIdPattern()
    {
        return this.locatorIdPattern;
    }

    public void setLocatorIdPattern(String locatorIdPattern)
    {
        this.locatorIdPattern = locatorIdPattern;
    }

    private String productIdPattern;

    public String getProductIdPattern()
    {
        return this.productIdPattern;
    }

    public void setProductIdPattern(String productIdPattern)
    {
        this.productIdPattern = productIdPattern;
    }

    private Boolean posted;

    public Boolean getPosted()
    {
        return this.posted;
    }

    public void setPosted(Boolean posted)
    {
        this.posted = posted;
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

    private String processing;

    public String getProcessing()
    {
        return this.processing;
    }

    public void setProcessing(String processing)
    {
        this.processing = processing;
    }

    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
    }

    private Date movementDate;

    public Date getMovementDate()
    {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate)
    {
        this.movementDate = movementDate;
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

    private Boolean isApproved;

    public Boolean getIsApproved()
    {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved)
    {
        this.isApproved = isApproved;
    }

    private BigDecimal approvalAmount;

    public BigDecimal getApprovalAmount()
    {
        return this.approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount)
    {
        this.approvalAmount = approvalAmount;
    }

    private Boolean isQuantityUpdated;

    public Boolean getIsQuantityUpdated()
    {
        return this.isQuantityUpdated;
    }

    public void setIsQuantityUpdated(Boolean isQuantityUpdated)
    {
        this.isQuantityUpdated = isQuantityUpdated;
    }

    private String reversalDocumentNumber;

    public String getReversalDocumentNumber()
    {
        return this.reversalDocumentNumber;
    }

    public void setReversalDocumentNumber(String reversalDocumentNumber)
    {
        this.reversalDocumentNumber = reversalDocumentNumber;
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

    public void copyTo(AbstractPhysicalInventoryCommand.AbstractCreateOrMergePatchPhysicalInventory command)
    {
        ((AbstractPhysicalInventoryCommandDto) this).copyTo(command);
        command.setWarehouseId(this.getWarehouseId());
        command.setLocatorIdPattern(this.getLocatorIdPattern());
        command.setProductIdPattern(this.getProductIdPattern());
        command.setPosted(this.getPosted());
        command.setProcessed(this.getProcessed());
        command.setProcessing(this.getProcessing());
        command.setDocumentTypeId(this.getDocumentTypeId());
        command.setMovementDate(this.getMovementDate());
        command.setDescription(this.getDescription());
        command.setIsApproved(this.getIsApproved());
        command.setApprovalAmount(this.getApprovalAmount());
        command.setIsQuantityUpdated(this.getIsQuantityUpdated());
        command.setReversalDocumentNumber(this.getReversalDocumentNumber());
        command.setActive(this.getActive());
    }

    public PhysicalInventoryCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory command = new AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory();
            copyTo((AbstractPhysicalInventoryCommand.AbstractCreatePhysicalInventory) command);
            if (this.getPhysicalInventoryLines() != null) {
                for (CreateOrMergePatchPhysicalInventoryLineDto cmd : this.getPhysicalInventoryLines()) {
                    command.getPhysicalInventoryLines().add((PhysicalInventoryLineCommand.CreatePhysicalInventoryLine) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory command = new AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory();
            copyTo((AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory) command);
            if (this.getPhysicalInventoryLines() != null) {
                for (CreateOrMergePatchPhysicalInventoryLineDto cmd : this.getPhysicalInventoryLines()) {
                    command.getPhysicalInventoryLineCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPhysicalInventoryCommand.AbstractCreatePhysicalInventory command)
    {
        copyTo((AbstractPhysicalInventoryCommand.AbstractCreateOrMergePatchPhysicalInventory) command);
    }

    public void copyTo(AbstractPhysicalInventoryCommand.AbstractMergePatchPhysicalInventory command)
    {
        copyTo((AbstractPhysicalInventoryCommand.AbstractCreateOrMergePatchPhysicalInventory) command);
        command.setIsPropertyWarehouseIdRemoved(this.getIsPropertyWarehouseIdRemoved());
        command.setIsPropertyLocatorIdPatternRemoved(this.getIsPropertyLocatorIdPatternRemoved());
        command.setIsPropertyProductIdPatternRemoved(this.getIsPropertyProductIdPatternRemoved());
        command.setIsPropertyPostedRemoved(this.getIsPropertyPostedRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyProcessingRemoved(this.getIsPropertyProcessingRemoved());
        command.setIsPropertyDocumentTypeIdRemoved(this.getIsPropertyDocumentTypeIdRemoved());
        command.setIsPropertyMovementDateRemoved(this.getIsPropertyMovementDateRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyIsApprovedRemoved(this.getIsPropertyIsApprovedRemoved());
        command.setIsPropertyApprovalAmountRemoved(this.getIsPropertyApprovalAmountRemoved());
        command.setIsPropertyIsQuantityUpdatedRemoved(this.getIsPropertyIsQuantityUpdatedRemoved());
        command.setIsPropertyReversalDocumentNumberRemoved(this.getIsPropertyReversalDocumentNumberRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePhysicalInventoryDto extends CreateOrMergePatchPhysicalInventoryDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PhysicalInventoryCommand.CreatePhysicalInventory toCreatePhysicalInventory()
        {
            return (PhysicalInventoryCommand.CreatePhysicalInventory) toCommand();
        }

    }

    public static class MergePatchPhysicalInventoryDto extends CreateOrMergePatchPhysicalInventoryDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PhysicalInventoryCommand.MergePatchPhysicalInventory toMergePatchPhysicalInventory()
        {
            return (PhysicalInventoryCommand.MergePatchPhysicalInventory) toCommand();
        }

    }

}

