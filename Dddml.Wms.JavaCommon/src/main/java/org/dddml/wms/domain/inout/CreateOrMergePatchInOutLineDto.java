package org.dddml.wms.domain.inout;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInOutLineDto extends AbstractInOutLineCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

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

    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
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

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    private BigDecimal scrappedQuantity;

    public BigDecimal getScrappedQuantity()
    {
        return this.scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity)
    {
        this.scrappedQuantity = scrappedQuantity;
    }

    private BigDecimal targetQuantity;

    public BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private Boolean isDescription;

    public Boolean getIsDescription()
    {
        return this.isDescription;
    }

    public void setIsDescription(Boolean isDescription)
    {
        this.isDescription = isDescription;
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

    private BigDecimal quantityEntered;

    public BigDecimal getQuantityEntered()
    {
        return this.quantityEntered;
    }

    public void setQuantityEntered(BigDecimal quantityEntered)
    {
        this.quantityEntered = quantityEntered;
    }

    private Long rmaLineNumber;

    public Long getRmaLineNumber()
    {
        return this.rmaLineNumber;
    }

    public void setRmaLineNumber(Long rmaLineNumber)
    {
        this.rmaLineNumber = rmaLineNumber;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private Boolean isPropertyUomIdRemoved;

    public Boolean getIsPropertyUomIdRemoved()
    {
        return this.isPropertyUomIdRemoved;
    }

    public void setIsPropertyUomIdRemoved(Boolean removed)
    {
        this.isPropertyUomIdRemoved = removed;
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

    private Boolean isPropertyConfirmedQuantityRemoved;

    public Boolean getIsPropertyConfirmedQuantityRemoved()
    {
        return this.isPropertyConfirmedQuantityRemoved;
    }

    public void setIsPropertyConfirmedQuantityRemoved(Boolean removed)
    {
        this.isPropertyConfirmedQuantityRemoved = removed;
    }

    private Boolean isPropertyScrappedQuantityRemoved;

    public Boolean getIsPropertyScrappedQuantityRemoved()
    {
        return this.isPropertyScrappedQuantityRemoved;
    }

    public void setIsPropertyScrappedQuantityRemoved(Boolean removed)
    {
        this.isPropertyScrappedQuantityRemoved = removed;
    }

    private Boolean isPropertyTargetQuantityRemoved;

    public Boolean getIsPropertyTargetQuantityRemoved()
    {
        return this.isPropertyTargetQuantityRemoved;
    }

    public void setIsPropertyTargetQuantityRemoved(Boolean removed)
    {
        this.isPropertyTargetQuantityRemoved = removed;
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

    private Boolean isPropertyAttributeSetInstanceIdRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdRemoved()
    {
        return this.isPropertyAttributeSetInstanceIdRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetInstanceIdRemoved = removed;
    }

    private Boolean isPropertyIsDescriptionRemoved;

    public Boolean getIsPropertyIsDescriptionRemoved()
    {
        return this.isPropertyIsDescriptionRemoved;
    }

    public void setIsPropertyIsDescriptionRemoved(Boolean removed)
    {
        this.isPropertyIsDescriptionRemoved = removed;
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

    private Boolean isPropertyQuantityEnteredRemoved;

    public Boolean getIsPropertyQuantityEnteredRemoved()
    {
        return this.isPropertyQuantityEnteredRemoved;
    }

    public void setIsPropertyQuantityEnteredRemoved(Boolean removed)
    {
        this.isPropertyQuantityEnteredRemoved = removed;
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
        command.setDescription(this.getDescription());
        command.setLocatorId(this.getLocatorId());
        command.setProductId(this.getProductId());
        command.setUomId(this.getUomId());
        command.setMovementQuantity(this.getMovementQuantity());
        command.setConfirmedQuantity(this.getConfirmedQuantity());
        command.setScrappedQuantity(this.getScrappedQuantity());
        command.setTargetQuantity(this.getTargetQuantity());
        command.setPickedQuantity(this.getPickedQuantity());
        command.setIsInvoiced(this.getIsInvoiced());
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setIsDescription(this.getIsDescription());
        command.setProcessed(this.getProcessed());
        command.setQuantityEntered(this.getQuantityEntered());
        command.setRmaLineNumber(this.getRmaLineNumber());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setActive(this.getActive());
    }

    public InOutLineCommand toCommand()
    {
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
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyLocatorIdRemoved(this.getIsPropertyLocatorIdRemoved());
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyUomIdRemoved(this.getIsPropertyUomIdRemoved());
        command.setIsPropertyMovementQuantityRemoved(this.getIsPropertyMovementQuantityRemoved());
        command.setIsPropertyConfirmedQuantityRemoved(this.getIsPropertyConfirmedQuantityRemoved());
        command.setIsPropertyScrappedQuantityRemoved(this.getIsPropertyScrappedQuantityRemoved());
        command.setIsPropertyTargetQuantityRemoved(this.getIsPropertyTargetQuantityRemoved());
        command.setIsPropertyPickedQuantityRemoved(this.getIsPropertyPickedQuantityRemoved());
        command.setIsPropertyIsInvoicedRemoved(this.getIsPropertyIsInvoicedRemoved());
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyIsDescriptionRemoved(this.getIsPropertyIsDescriptionRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyQuantityEnteredRemoved(this.getIsPropertyQuantityEnteredRemoved());
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

