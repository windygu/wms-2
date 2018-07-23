package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderItemShipGroupAssociationDto extends AbstractOrderItemShipGroupAssociationCommandDto
{
    /**
     * Quantity
     */
    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Cancel Quantity
     */
    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyCancelQuantityRemoved;

    public Boolean getIsPropertyCancelQuantityRemoved()
    {
        return this.isPropertyCancelQuantityRemoved;
    }

    public void setIsPropertyCancelQuantityRemoved(Boolean removed)
    {
        this.isPropertyCancelQuantityRemoved = removed;
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

    public static class CreateOrderItemShipGroupAssociationDto extends CreateOrMergePatchOrderItemShipGroupAssociationDto
    {
        public CreateOrderItemShipGroupAssociationDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchOrderItemShipGroupAssociationDto extends CreateOrMergePatchOrderItemShipGroupAssociationDto
    {
        public MergePatchOrderItemShipGroupAssociationDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

