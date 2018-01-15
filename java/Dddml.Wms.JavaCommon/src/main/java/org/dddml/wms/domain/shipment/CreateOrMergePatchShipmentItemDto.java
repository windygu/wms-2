package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentItemDto extends AbstractShipmentItemCommandDto
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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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

    private java.math.BigDecimal targetQuantity;

    public java.math.BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(java.math.BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
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

    public void copyTo(AbstractShipmentItemCommand.AbstractCreateOrMergePatchShipmentItem command)
    {
        ((AbstractShipmentItemCommandDto) this).copyTo(command);
        command.setProductId(this.getProductId());
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setQuantity(this.getQuantity());
        command.setTargetQuantity(this.getTargetQuantity());
        command.setShipmentContentDescription(this.getShipmentContentDescription());
        command.setActive(this.getActive());
    }

    public ShipmentItemCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentItemCommand.SimpleCreateShipmentItem command = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
            copyTo((AbstractShipmentItemCommand.AbstractCreateShipmentItem) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentItemCommand.SimpleMergePatchShipmentItem command = new AbstractShipmentItemCommand.SimpleMergePatchShipmentItem();
            copyTo((AbstractShipmentItemCommand.SimpleMergePatchShipmentItem) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractShipmentItemCommand.SimpleRemoveShipmentItem command = new AbstractShipmentItemCommand.SimpleRemoveShipmentItem();
            ((AbstractShipmentItemCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentItemCommand.AbstractCreateShipmentItem command)
    {
        copyTo((AbstractShipmentItemCommand.AbstractCreateOrMergePatchShipmentItem) command);
    }

    public void copyTo(AbstractShipmentItemCommand.AbstractMergePatchShipmentItem command)
    {
        copyTo((AbstractShipmentItemCommand.AbstractCreateOrMergePatchShipmentItem) command);
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyTargetQuantityRemoved(this.getIsPropertyTargetQuantityRemoved());
        command.setIsPropertyShipmentContentDescriptionRemoved(this.getIsPropertyShipmentContentDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentItemDto extends CreateOrMergePatchShipmentItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentItemCommand.CreateShipmentItem toCreateShipmentItem()
        {
            return (ShipmentItemCommand.CreateShipmentItem) toCommand();
        }

    }

    public static class MergePatchShipmentItemDto extends CreateOrMergePatchShipmentItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentItemCommand.MergePatchShipmentItem toMergePatchShipmentItem()
        {
            return (ShipmentItemCommand.MergePatchShipmentItem) toCommand();
        }

    }

}

