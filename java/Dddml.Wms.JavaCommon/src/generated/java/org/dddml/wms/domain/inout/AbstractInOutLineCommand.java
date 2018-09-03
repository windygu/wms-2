package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutLineCommand extends AbstractCommand implements InOutLineCommand
{
    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    private String inOutDocumentNumber;

    public String getInOutDocumentNumber()
    {
        return this.inOutDocumentNumber;
    }

    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
    }


    public static abstract class AbstractCreateOrMergePatchInOutLine extends AbstractInOutLineCommand implements CreateOrMergePatchInOutLine
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

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private String quantityUomId;

        public String getQuantityUomId()
        {
            return this.quantityUomId;
        }

        public void setQuantityUomId(String quantityUomId)
        {
            this.quantityUomId = quantityUomId;
        }

        private BigDecimal movementQuantity;

        public BigDecimal getMovementQuantity()
        {
            return this.movementQuantity;
        }

        public void setMovementQuantity(BigDecimal movementQuantity)
        {
            this.movementQuantity = movementQuantity;
        }

        private BigDecimal pickedQuantity;

        public BigDecimal getPickedQuantity()
        {
            return this.pickedQuantity;
        }

        public void setPickedQuantity(BigDecimal pickedQuantity)
        {
            this.pickedQuantity = pickedQuantity;
        }

        private Boolean isInvoiced;

        public Boolean getIsInvoiced()
        {
            return this.isInvoiced;
        }

        public void setIsInvoiced(Boolean isInvoiced)
        {
            this.isInvoiced = isInvoiced;
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

        private String rmaLineNumber;

        public String getRmaLineNumber()
        {
            return this.rmaLineNumber;
        }

        public void setRmaLineNumber(String rmaLineNumber)
        {
            this.rmaLineNumber = rmaLineNumber;
        }

        private String reversalLineNumber;

        public String getReversalLineNumber()
        {
            return this.reversalLineNumber;
        }

        public void setReversalLineNumber(String reversalLineNumber)
        {
            this.reversalLineNumber = reversalLineNumber;
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

        private Set<String> damageStatusIds;

        public Set<String> getDamageStatusIds() {
            return this.damageStatusIds;
        }

        public void setDamageStatusIds(Set<String> damageStatusIds) {
            this.damageStatusIds = damageStatusIds;
        }

        public InOutLineImageCommand.CreateInOutLineImage newCreateInOutLineImage()
        {
            AbstractInOutLineImageCommand.SimpleCreateInOutLineImage c = new AbstractInOutLineImageCommand.SimpleCreateInOutLineImage();
            c.setInOutDocumentNumber(this.getInOutDocumentNumber());

            c.setInOutLineLineNumber(this.getLineNumber());

            return c;
        }

        public InOutLineImageCommand.MergePatchInOutLineImage newMergePatchInOutLineImage()
        {
            AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage c = new AbstractInOutLineImageCommand.SimpleMergePatchInOutLineImage();
            c.setInOutDocumentNumber(this.getInOutDocumentNumber());

            c.setInOutLineLineNumber(this.getLineNumber());

            return c;
        }

        public InOutLineImageCommand.RemoveInOutLineImage newRemoveInOutLineImage()
        {
            AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage c = new AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage();
            c.setInOutDocumentNumber(this.getInOutDocumentNumber());

            c.setInOutLineLineNumber(this.getLineNumber());

            return c;
        }

    }

    public static abstract class AbstractCreateInOutLine extends AbstractCreateOrMergePatchInOutLine implements CreateInOutLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateInOutLineImageCommands inOutLineImages = new SimpleCreateInOutLineImageCommands();

        public CreateInOutLineImageCommands getInOutLineImages()
        {
            return this.inOutLineImages;
        }

    }

    public static abstract class AbstractMergePatchInOutLine extends AbstractCreateOrMergePatchInOutLine implements MergePatchInOutLine
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

        private Boolean isPropertyDamageStatusIdsRemoved;

        public Boolean getIsPropertyDamageStatusIdsRemoved()
        {
            return this.isPropertyDamageStatusIdsRemoved;
        }

        public void setIsPropertyDamageStatusIdsRemoved(Boolean removed)
        {
            this.isPropertyDamageStatusIdsRemoved = removed;
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

        private Boolean isPropertyQuantityUomIdRemoved;

        public Boolean getIsPropertyQuantityUomIdRemoved()
        {
            return this.isPropertyQuantityUomIdRemoved;
        }

        public void setIsPropertyQuantityUomIdRemoved(Boolean removed)
        {
            this.isPropertyQuantityUomIdRemoved = removed;
        }

        private Boolean isPropertyMovementQuantityRemoved;

        public Boolean getIsPropertyMovementQuantityRemoved()
        {
            return this.isPropertyMovementQuantityRemoved;
        }

        public void setIsPropertyMovementQuantityRemoved(Boolean removed)
        {
            this.isPropertyMovementQuantityRemoved = removed;
        }

        private Boolean isPropertyPickedQuantityRemoved;

        public Boolean getIsPropertyPickedQuantityRemoved()
        {
            return this.isPropertyPickedQuantityRemoved;
        }

        public void setIsPropertyPickedQuantityRemoved(Boolean removed)
        {
            this.isPropertyPickedQuantityRemoved = removed;
        }

        private Boolean isPropertyIsInvoicedRemoved;

        public Boolean getIsPropertyIsInvoicedRemoved()
        {
            return this.isPropertyIsInvoicedRemoved;
        }

        public void setIsPropertyIsInvoicedRemoved(Boolean removed)
        {
            this.isPropertyIsInvoicedRemoved = removed;
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

        private Boolean isPropertyRmaLineNumberRemoved;

        public Boolean getIsPropertyRmaLineNumberRemoved()
        {
            return this.isPropertyRmaLineNumberRemoved;
        }

        public void setIsPropertyRmaLineNumberRemoved(Boolean removed)
        {
            this.isPropertyRmaLineNumberRemoved = removed;
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private InOutLineImageCommands inOutLineImageCommands = new SimpleInOutLineImageCommands();

        public InOutLineImageCommands getInOutLineImageCommands()
        {
            return this.inOutLineImageCommands;
        }

    }

    public static class SimpleCreateInOutLine extends AbstractCreateInOutLine
    {
    }

    
    public static class SimpleMergePatchInOutLine extends AbstractMergePatchInOutLine
    {
    }

    
	public static class SimpleRemoveInOutLine extends AbstractInOutLineCommand implements RemoveInOutLine
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    
    public static class SimpleCreateInOutLineImageCommands implements CreateInOutLineImageCommands
    {
        private List<InOutLineImageCommand.CreateInOutLineImage> innerCommands = new ArrayList<InOutLineImageCommand.CreateInOutLineImage>();

        public void add(InOutLineImageCommand.CreateInOutLineImage c)
        {
            innerCommands.add(c);
        }

        public void remove(InOutLineImageCommand.CreateInOutLineImage c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<InOutLineImageCommand.CreateInOutLineImage> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleInOutLineImageCommands implements InOutLineImageCommands
    {
        private List<InOutLineImageCommand> innerCommands = new ArrayList<InOutLineImageCommand>();

        public void add(InOutLineImageCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(InOutLineImageCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<InOutLineImageCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

