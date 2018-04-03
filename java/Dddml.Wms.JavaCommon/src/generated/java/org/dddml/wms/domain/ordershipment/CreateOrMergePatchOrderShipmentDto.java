package org.dddml.wms.domain.ordershipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderShipmentDto extends AbstractOrderShipmentCommandDto
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

    public void copyTo(AbstractOrderShipmentCommand.AbstractCreateOrMergePatchOrderShipment command)
    {
        ((AbstractOrderShipmentCommandDto) this).copyTo(command);
        command.setQuantity(this.getQuantity());
        command.setActive(this.getActive());
    }

    public OrderShipmentCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderShipmentCommand.SimpleCreateOrderShipment command = new AbstractOrderShipmentCommand.SimpleCreateOrderShipment();
            copyTo((AbstractOrderShipmentCommand.AbstractCreateOrderShipment) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderShipmentCommand.SimpleMergePatchOrderShipment command = new AbstractOrderShipmentCommand.SimpleMergePatchOrderShipment();
            copyTo((AbstractOrderShipmentCommand.SimpleMergePatchOrderShipment) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderShipmentCommand.AbstractCreateOrderShipment command)
    {
        copyTo((AbstractOrderShipmentCommand.AbstractCreateOrMergePatchOrderShipment) command);
    }

    public void copyTo(AbstractOrderShipmentCommand.AbstractMergePatchOrderShipment command)
    {
        copyTo((AbstractOrderShipmentCommand.AbstractCreateOrMergePatchOrderShipment) command);
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrderShipmentDto extends CreateOrMergePatchOrderShipmentDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderShipmentCommand.CreateOrderShipment toCreateOrderShipment()
        {
            return (OrderShipmentCommand.CreateOrderShipment) toCommand();
        }

    }

    public static class MergePatchOrderShipmentDto extends CreateOrMergePatchOrderShipmentDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderShipmentCommand.MergePatchOrderShipment toMergePatchOrderShipment()
        {
            return (OrderShipmentCommand.MergePatchOrderShipment) toCommand();
        }

    }

}

