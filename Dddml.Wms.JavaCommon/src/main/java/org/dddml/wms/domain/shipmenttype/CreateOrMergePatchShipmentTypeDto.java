package org.dddml.wms.domain.shipmenttype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentTypeDto extends AbstractShipmentTypeCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
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

    public void copyTo(AbstractShipmentTypeCommand.AbstractCreateOrMergePatchShipmentType command)
    {
        ((AbstractShipmentTypeCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public ShipmentTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentTypeCommand.SimpleCreateShipmentType command = new AbstractShipmentTypeCommand.SimpleCreateShipmentType();
            copyTo((AbstractShipmentTypeCommand.AbstractCreateShipmentType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentTypeCommand.SimpleMergePatchShipmentType command = new AbstractShipmentTypeCommand.SimpleMergePatchShipmentType();
            copyTo((AbstractShipmentTypeCommand.SimpleMergePatchShipmentType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentTypeCommand.AbstractCreateShipmentType command)
    {
        copyTo((AbstractShipmentTypeCommand.AbstractCreateOrMergePatchShipmentType) command);
    }

    public void copyTo(AbstractShipmentTypeCommand.AbstractMergePatchShipmentType command)
    {
        copyTo((AbstractShipmentTypeCommand.AbstractCreateOrMergePatchShipmentType) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentTypeDto extends CreateOrMergePatchShipmentTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentTypeCommand.CreateShipmentType toCreateShipmentType()
        {
            return (ShipmentTypeCommand.CreateShipmentType) toCommand();
        }

    }

    public static class MergePatchShipmentTypeDto extends CreateOrMergePatchShipmentTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentTypeCommand.MergePatchShipmentType toMergePatchShipmentType()
        {
            return (ShipmentTypeCommand.MergePatchShipmentType) toCommand();
        }

    }

}

