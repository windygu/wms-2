package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementLineDto extends AbstractMovementLineCommandDto
{
    /**
     * The Movement Quantity indicates the quantity of a product that has been moved.
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
     * Locator Id From
     */
    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    /**
     * Locator Id To
     */
    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
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

    private Boolean isPropertyMovementQuantityRemoved;

    public Boolean getIsPropertyMovementQuantityRemoved()
    {
        return this.isPropertyMovementQuantityRemoved;
    }

    public void setIsPropertyMovementQuantityRemoved(Boolean removed)
    {
        this.isPropertyMovementQuantityRemoved = removed;
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

    private Boolean isPropertyLocatorIdFromRemoved;

    public Boolean getIsPropertyLocatorIdFromRemoved()
    {
        return this.isPropertyLocatorIdFromRemoved;
    }

    public void setIsPropertyLocatorIdFromRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdFromRemoved = removed;
    }

    private Boolean isPropertyLocatorIdToRemoved;

    public Boolean getIsPropertyLocatorIdToRemoved()
    {
        return this.isPropertyLocatorIdToRemoved;
    }

    public void setIsPropertyLocatorIdToRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdToRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateMovementLineDto extends CreateOrMergePatchMovementLineDto
    {
        public CreateMovementLineDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchMovementLineDto extends CreateOrMergePatchMovementLineDto
    {
        public MergePatchMovementLineDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

