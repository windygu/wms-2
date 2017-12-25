package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPhysicalInventoryCommand extends AbstractCommand implements PhysicalInventoryCommand
{
    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
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


    public static abstract class AbstractCreateOrMergePatchPhysicalInventory extends AbstractPhysicalInventoryCommand implements CreateOrMergePatchPhysicalInventory
    {
        private String documentAction;

        public String getDocumentAction()
        {
            return this.documentAction;
        }

        public void setDocumentAction(String documentAction)
        {
            this.documentAction = documentAction;
        }

        private String warehouseId;

        public String getWarehouseId()
        {
            return this.warehouseId;
        }

        public void setWarehouseId(String warehouseId)
        {
            this.warehouseId = warehouseId;
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

        public PhysicalInventoryLineCommand.CreatePhysicalInventoryLine newCreatePhysicalInventoryLine()
        {
            AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine c = new AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine();
            c.setPhysicalInventoryDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine newMergePatchPhysicalInventoryLine()
        {
            AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine c = new AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine();
            c.setPhysicalInventoryDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public PhysicalInventoryLineCommand.RemovePhysicalInventoryLine newRemovePhysicalInventoryLine()
        {
            AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine c = new AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine();
            c.setPhysicalInventoryDocumentNumber(this.getDocumentNumber());

            return c;
        }

    }

    public static abstract class AbstractCreatePhysicalInventory extends AbstractCreateOrMergePatchPhysicalInventory implements CreatePhysicalInventory
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreatePhysicalInventoryLineCommands physicalInventoryLines = new SimpleCreatePhysicalInventoryLineCommands();

        public CreatePhysicalInventoryLineCommands getPhysicalInventoryLines()
        {
            return this.physicalInventoryLines;
        }

    }

    public static abstract class AbstractMergePatchPhysicalInventory extends AbstractCreateOrMergePatchPhysicalInventory implements MergePatchPhysicalInventory
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private PhysicalInventoryLineCommands physicalInventoryLineCommands = new SimplePhysicalInventoryLineCommands();

        public PhysicalInventoryLineCommands getPhysicalInventoryLineCommands()
        {
            return this.physicalInventoryLineCommands;
        }

    }

    public static class SimpleCreatePhysicalInventory extends AbstractCreatePhysicalInventory
    {
    }

    
    public static class SimpleMergePatchPhysicalInventory extends AbstractMergePatchPhysicalInventory
    {
    }

    
	public static class SimpleDeletePhysicalInventory extends AbstractPhysicalInventoryCommand implements DeletePhysicalInventory
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreatePhysicalInventoryLineCommands implements CreatePhysicalInventoryLineCommands
    {
        private List<PhysicalInventoryLineCommand.CreatePhysicalInventoryLine> innerCommands = new ArrayList<PhysicalInventoryLineCommand.CreatePhysicalInventoryLine>();

        public void add(PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c)
        {
            innerCommands.add(c);
        }

        public void remove(PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<PhysicalInventoryLineCommand.CreatePhysicalInventoryLine> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimplePhysicalInventoryLineCommands implements PhysicalInventoryLineCommands
    {
        private List<PhysicalInventoryLineCommand> innerCommands = new ArrayList<PhysicalInventoryLineCommand>();

        public void add(PhysicalInventoryLineCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(PhysicalInventoryLineCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<PhysicalInventoryLineCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

