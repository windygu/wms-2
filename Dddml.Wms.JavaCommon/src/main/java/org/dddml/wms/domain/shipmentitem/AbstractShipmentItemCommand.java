package org.dddml.wms.domain.shipmentitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentItemCommand extends AbstractCommand implements ShipmentItemCommand
{
    private ShipmentItemId shipmentItemId;

    public ShipmentItemId getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemId shipmentItemId)
    {
        this.shipmentItemId = shipmentItemId;
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


    public static abstract class AbstractCreateOrMergePatchShipmentItem extends AbstractShipmentItemCommand implements CreateOrMergePatchShipmentItem
    {
        private String productId;

        public String getProductId()
        {
            return this.productId;
        }

        public void setProductId(String productId)
        {
            this.productId = productId;
        }

        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
        }

        private String shipmentContentDescription;

        public String getShipmentContentDescription()
        {
            return this.shipmentContentDescription;
        }

        public void setShipmentContentDescription(String shipmentContentDescription)
        {
            this.shipmentContentDescription = shipmentContentDescription;
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

    public static abstract class AbstractCreateShipmentItem extends AbstractCreateOrMergePatchShipmentItem implements CreateShipmentItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchShipmentItem extends AbstractCreateOrMergePatchShipmentItem implements MergePatchShipmentItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved()
        {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed)
        {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyShipmentContentDescriptionRemoved;

        public Boolean getIsPropertyShipmentContentDescriptionRemoved()
        {
            return this.isPropertyShipmentContentDescriptionRemoved;
        }

        public void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed)
        {
            this.isPropertyShipmentContentDescriptionRemoved = removed;
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

    public static class SimpleCreateShipmentItem extends AbstractCreateShipmentItem
    {
    }

    
    public static class SimpleMergePatchShipmentItem extends AbstractMergePatchShipmentItem
    {
    }

    
	public static class SimpleDeleteShipmentItem extends AbstractShipmentItemCommand implements DeleteShipmentItem
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

