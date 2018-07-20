package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentPackageContentDto extends AbstractShipmentPackageContentCommandDto
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
     * Sub Product Id
     */
    private String subProductId;

    public String getSubProductId()
    {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId)
    {
        this.subProductId = subProductId;
    }

    /**
     * Sub Product Quantity
     */
    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity()
    {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
    {
        this.subProductQuantity = subProductQuantity;
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

    private Boolean isPropertySubProductIdRemoved;

    public Boolean getIsPropertySubProductIdRemoved()
    {
        return this.isPropertySubProductIdRemoved;
    }

    public void setIsPropertySubProductIdRemoved(Boolean removed)
    {
        this.isPropertySubProductIdRemoved = removed;
    }

    private Boolean isPropertySubProductQuantityRemoved;

    public Boolean getIsPropertySubProductQuantityRemoved()
    {
        return this.isPropertySubProductQuantityRemoved;
    }

    public void setIsPropertySubProductQuantityRemoved(Boolean removed)
    {
        this.isPropertySubProductQuantityRemoved = removed;
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

    public static class CreateShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
    {
        public CreateShipmentPackageContentDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
    {
        public MergePatchShipmentPackageContentDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

