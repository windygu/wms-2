package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentPackageContentDto extends AbstractShipmentPackageContentCommandDto
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

    public void copyTo(AbstractShipmentPackageContentCommand.AbstractCreateOrMergePatchShipmentPackageContent command)
    {
        ((AbstractShipmentPackageContentCommandDto) this).copyTo(command);
        command.setQuantity(this.getQuantity());
        command.setSubProductId(this.getSubProductId());
        command.setSubProductQuantity(this.getSubProductQuantity());
        command.setActive(this.getActive());
    }

    public ShipmentPackageContentCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent command = new AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent();
            copyTo((AbstractShipmentPackageContentCommand.AbstractCreateShipmentPackageContent) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent command = new AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent();
            copyTo((AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent command = new AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent();
            ((AbstractShipmentPackageContentCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentPackageContentCommand.AbstractCreateShipmentPackageContent command)
    {
        copyTo((AbstractShipmentPackageContentCommand.AbstractCreateOrMergePatchShipmentPackageContent) command);
    }

    public void copyTo(AbstractShipmentPackageContentCommand.AbstractMergePatchShipmentPackageContent command)
    {
        copyTo((AbstractShipmentPackageContentCommand.AbstractCreateOrMergePatchShipmentPackageContent) command);
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertySubProductIdRemoved(this.getIsPropertySubProductIdRemoved());
        command.setIsPropertySubProductQuantityRemoved(this.getIsPropertySubProductQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentPackageContentCommand.CreateShipmentPackageContent toCreateShipmentPackageContent()
        {
            return (ShipmentPackageContentCommand.CreateShipmentPackageContent) toCommand();
        }

    }

    public static class MergePatchShipmentPackageContentDto extends CreateOrMergePatchShipmentPackageContentDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentPackageContentCommand.MergePatchShipmentPackageContent toMergePatchShipmentPackageContent()
        {
            return (ShipmentPackageContentCommand.MergePatchShipmentPackageContent) toCommand();
        }

    }

}

