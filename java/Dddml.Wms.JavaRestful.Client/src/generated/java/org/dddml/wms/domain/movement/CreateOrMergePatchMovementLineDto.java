package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementLineDto extends AbstractMovementLineCommandDto
{
    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
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

    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
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

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
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
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchMovementLineDto extends CreateOrMergePatchMovementLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

