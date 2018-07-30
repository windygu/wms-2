package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentImageDto extends AbstractShipmentImageCommandDto
{
    /**
     * Url
     */
    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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

    private Boolean isPropertyUrlRemoved;

    public Boolean getIsPropertyUrlRemoved()
    {
        return this.isPropertyUrlRemoved;
    }

    public void setIsPropertyUrlRemoved(Boolean removed)
    {
        this.isPropertyUrlRemoved = removed;
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

    public void copyTo(AbstractShipmentImageCommand.AbstractCreateOrMergePatchShipmentImage command)
    {
        ((AbstractShipmentImageCommandDto) this).copyTo(command);
        command.setUrl(this.getUrl());
        command.setActive(this.getActive());
    }

    public ShipmentImageCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentImageCommand.SimpleCreateShipmentImage command = new AbstractShipmentImageCommand.SimpleCreateShipmentImage();
            copyTo((AbstractShipmentImageCommand.AbstractCreateShipmentImage) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentImageCommand.SimpleMergePatchShipmentImage command = new AbstractShipmentImageCommand.SimpleMergePatchShipmentImage();
            copyTo((AbstractShipmentImageCommand.SimpleMergePatchShipmentImage) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractShipmentImageCommand.SimpleRemoveShipmentImage command = new AbstractShipmentImageCommand.SimpleRemoveShipmentImage();
            ((AbstractShipmentImageCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentImageCommand.AbstractCreateShipmentImage command)
    {
        copyTo((AbstractShipmentImageCommand.AbstractCreateOrMergePatchShipmentImage) command);
    }

    public void copyTo(AbstractShipmentImageCommand.AbstractMergePatchShipmentImage command)
    {
        copyTo((AbstractShipmentImageCommand.AbstractCreateOrMergePatchShipmentImage) command);
        command.setIsPropertyUrlRemoved(this.getIsPropertyUrlRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentImageDto extends CreateOrMergePatchShipmentImageDto
    {
        public CreateShipmentImageDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentImageCommand.CreateShipmentImage toCreateShipmentImage()
        {
            return (ShipmentImageCommand.CreateShipmentImage) toCommand();
        }

    }

    public static class MergePatchShipmentImageDto extends CreateOrMergePatchShipmentImageDto
    {
        public MergePatchShipmentImageDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentImageCommand.MergePatchShipmentImage toMergePatchShipmentImage()
        {
            return (ShipmentImageCommand.MergePatchShipmentImage) toCommand();
        }

    }

}

