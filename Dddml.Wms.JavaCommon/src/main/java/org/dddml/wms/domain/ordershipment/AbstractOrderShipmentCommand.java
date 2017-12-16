package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipmentCommand extends AbstractCommand implements OrderShipmentCommand
{
    private OrderShipmentId orderShipmentId;

    public OrderShipmentId getOrderShipmentId()
    {
        return this.orderShipmentId;
    }

    public void setOrderShipmentId(OrderShipmentId orderShipmentId)
    {
        this.orderShipmentId = orderShipmentId;
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


    public static abstract class AbstractCreateOrMergePatchOrderShipment extends AbstractOrderShipmentCommand implements CreateOrMergePatchOrderShipment
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

    public static abstract class AbstractCreateOrderShipment extends AbstractCreateOrMergePatchOrderShipment implements CreateOrderShipment
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchOrderShipment extends AbstractCreateOrMergePatchOrderShipment implements MergePatchOrderShipment
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

    public static class SimpleCreateOrderShipment extends AbstractCreateOrderShipment
    {
    }

    
    public static class SimpleMergePatchOrderShipment extends AbstractMergePatchOrderShipment
    {
    }

    
	public static class SimpleDeleteOrderShipment extends AbstractOrderShipmentCommand implements DeleteOrderShipment
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

