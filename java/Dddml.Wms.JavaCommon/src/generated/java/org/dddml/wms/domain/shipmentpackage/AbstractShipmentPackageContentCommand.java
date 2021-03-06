package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentPackageContentCommand extends AbstractCommand implements ShipmentPackageContentCommand
{
    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private ShipmentPackageId shipmentPackageId;

    public ShipmentPackageId getShipmentPackageId()
    {
        return this.shipmentPackageId;
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        this.shipmentPackageId = shipmentPackageId;
    }


    public static abstract class AbstractCreateOrMergePatchShipmentPackageContent extends AbstractShipmentPackageContentCommand implements CreateOrMergePatchShipmentPackageContent
    {
        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
        }

        private String subProductId;

        public String getSubProductId()
        {
            return this.subProductId;
        }

        public void setSubProductId(String subProductId)
        {
            this.subProductId = subProductId;
        }

        private java.math.BigDecimal subProductQuantity;

        public java.math.BigDecimal getSubProductQuantity()
        {
            return this.subProductQuantity;
        }

        public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
        {
            this.subProductQuantity = subProductQuantity;
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

    public static abstract class AbstractCreateShipmentPackageContent extends AbstractCreateOrMergePatchShipmentPackageContent implements CreateShipmentPackageContent
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchShipmentPackageContent extends AbstractCreateOrMergePatchShipmentPackageContent implements MergePatchShipmentPackageContent
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

    }

    public static class SimpleCreateShipmentPackageContent extends AbstractCreateShipmentPackageContent
    {
    }

    
    public static class SimpleMergePatchShipmentPackageContent extends AbstractMergePatchShipmentPackageContent
    {
    }

    
	public static class SimpleRemoveShipmentPackageContent extends AbstractShipmentPackageContentCommand implements RemoveShipmentPackageContent
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

