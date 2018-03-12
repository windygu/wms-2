package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPhysicalInventoryLineCommand extends AbstractCommand implements PhysicalInventoryLineCommand
{
    private InventoryItemId inventoryItemId;

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    private String physicalInventoryDocumentNumber;

    public String getPhysicalInventoryDocumentNumber()
    {
        return this.physicalInventoryDocumentNumber;
    }

    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
    }


    public static abstract class AbstractCreateOrMergePatchPhysicalInventoryLine extends AbstractPhysicalInventoryLineCommand implements CreateOrMergePatchPhysicalInventoryLine
    {
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

        private String lineNumber;

        public String getLineNumber()
        {
            return this.lineNumber;
        }

        public void setLineNumber(String lineNumber)
        {
            this.lineNumber = lineNumber;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

    }

    public static abstract class AbstractCreatePhysicalInventoryLine extends AbstractCreateOrMergePatchPhysicalInventoryLine implements CreatePhysicalInventoryLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchPhysicalInventoryLine extends AbstractCreateOrMergePatchPhysicalInventoryLine implements MergePatchPhysicalInventoryLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

    }

    public static class SimpleCreatePhysicalInventoryLine extends AbstractCreatePhysicalInventoryLine
    {
    }

    
    public static class SimpleMergePatchPhysicalInventoryLine extends AbstractMergePatchPhysicalInventoryLine
    {
    }

    
	public static class SimpleRemovePhysicalInventoryLine extends AbstractPhysicalInventoryLineCommand implements RemovePhysicalInventoryLine
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

