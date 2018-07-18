package org.dddml.wms.domain.inout;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInOutLineDto extends AbstractInOutLineCommandDto
{
    /**
     * Locator Id
     */
    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    /**
     * Product Id
     */
    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    /**
     * Attribute Set Instance Id
     */
    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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
     * Quantity Uom Id
     */
    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
    }

    /**
     * Movement Quantity
     */
    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
    }

    /**
     * Picked Quantity
     */
    private BigDecimal pickedQuantity;

    public BigDecimal getPickedQuantity()
    {
        return this.pickedQuantity;
    }

    public void setPickedQuantity(BigDecimal pickedQuantity)
    {
        this.pickedQuantity = pickedQuantity;
    }

    /**
     * Is Invoiced
     */
    private Boolean isInvoiced;

    public Boolean getIsInvoiced()
    {
        return this.isInvoiced;
    }

    public void setIsInvoiced(Boolean isInvoiced)
    {
        this.isInvoiced = isInvoiced;
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
     * Rma Line Number
     */
    private String rmaLineNumber;

    public String getRmaLineNumber()
    {
        return this.rmaLineNumber;
    }

    public void setRmaLineNumber(String rmaLineNumber)
    {
        this.rmaLineNumber = rmaLineNumber;
    }

    /**
     * Reversal Line Number
     */
    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    public void copyTo(AbstractInOutLineCommand.AbstractCreateOrMergePatchInOutLine command)
    {
        ((AbstractInOutLineCommandDto) this).copyTo(command);
        command.setLocatorId(this.getLocatorId());
        command.setProductId(this.getProductId());
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setDescription(this.getDescription());
        command.setQuantityUomId(this.getQuantityUomId());
        command.setMovementQuantity(this.getMovementQuantity());
        command.setPickedQuantity(this.getPickedQuantity());
        command.setIsInvoiced(this.getIsInvoiced());
        command.setProcessed(this.getProcessed());
        command.setRmaLineNumber(this.getRmaLineNumber());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setActive(this.getActive());
    }

    public InOutLineCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInOutLineCommand.SimpleCreateInOutLine command = new AbstractInOutLineCommand.SimpleCreateInOutLine();
            copyTo((AbstractInOutLineCommand.AbstractCreateInOutLine) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInOutLineCommand.SimpleMergePatchInOutLine command = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            copyTo((AbstractInOutLineCommand.SimpleMergePatchInOutLine) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractInOutLineCommand.SimpleRemoveInOutLine command = new AbstractInOutLineCommand.SimpleRemoveInOutLine();
            ((AbstractInOutLineCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInOutLineCommand.AbstractCreateInOutLine command)
    {
        copyTo((AbstractInOutLineCommand.AbstractCreateOrMergePatchInOutLine) command);
    }

    public void copyTo(AbstractInOutLineCommand.AbstractMergePatchInOutLine command)
    {
        copyTo((AbstractInOutLineCommand.AbstractCreateOrMergePatchInOutLine) command);
        command.setIsPropertyLocatorIdRemoved(this.getIsPropertyLocatorIdRemoved());
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyQuantityUomIdRemoved(this.getIsPropertyQuantityUomIdRemoved());
        command.setIsPropertyMovementQuantityRemoved(this.getIsPropertyMovementQuantityRemoved());
        command.setIsPropertyPickedQuantityRemoved(this.getIsPropertyPickedQuantityRemoved());
        command.setIsPropertyIsInvoicedRemoved(this.getIsPropertyIsInvoicedRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyRmaLineNumberRemoved(this.getIsPropertyRmaLineNumberRemoved());
        command.setIsPropertyReversalLineNumberRemoved(this.getIsPropertyReversalLineNumberRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInOutLineDto extends CreateOrMergePatchInOutLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InOutLineCommand.CreateInOutLine toCreateInOutLine()
        {
            return (InOutLineCommand.CreateInOutLine) toCommand();
        }

    }

    public static class MergePatchInOutLineDto extends CreateOrMergePatchInOutLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InOutLineCommand.MergePatchInOutLine toMergePatchInOutLine()
        {
            return (InOutLineCommand.MergePatchInOutLine) toCommand();
        }

    }

}

