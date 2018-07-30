package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentReceiptImageDto extends AbstractShipmentReceiptImageCommandDto
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

    public void copyTo(AbstractShipmentReceiptImageCommand.AbstractCreateOrMergePatchShipmentReceiptImage command)
    {
        ((AbstractShipmentReceiptImageCommandDto) this).copyTo(command);
        command.setUrl(this.getUrl());
        command.setActive(this.getActive());
    }

    public ShipmentReceiptImageCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentReceiptImageCommand.SimpleCreateShipmentReceiptImage command = new AbstractShipmentReceiptImageCommand.SimpleCreateShipmentReceiptImage();
            copyTo((AbstractShipmentReceiptImageCommand.AbstractCreateShipmentReceiptImage) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentReceiptImageCommand.SimpleMergePatchShipmentReceiptImage command = new AbstractShipmentReceiptImageCommand.SimpleMergePatchShipmentReceiptImage();
            copyTo((AbstractShipmentReceiptImageCommand.SimpleMergePatchShipmentReceiptImage) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractShipmentReceiptImageCommand.SimpleRemoveShipmentReceiptImage command = new AbstractShipmentReceiptImageCommand.SimpleRemoveShipmentReceiptImage();
            ((AbstractShipmentReceiptImageCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentReceiptImageCommand.AbstractCreateShipmentReceiptImage command)
    {
        copyTo((AbstractShipmentReceiptImageCommand.AbstractCreateOrMergePatchShipmentReceiptImage) command);
    }

    public void copyTo(AbstractShipmentReceiptImageCommand.AbstractMergePatchShipmentReceiptImage command)
    {
        copyTo((AbstractShipmentReceiptImageCommand.AbstractCreateOrMergePatchShipmentReceiptImage) command);
        command.setIsPropertyUrlRemoved(this.getIsPropertyUrlRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentReceiptImageDto extends CreateOrMergePatchShipmentReceiptImageDto
    {
        public CreateShipmentReceiptImageDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentReceiptImageCommand.CreateShipmentReceiptImage toCreateShipmentReceiptImage()
        {
            return (ShipmentReceiptImageCommand.CreateShipmentReceiptImage) toCommand();
        }

    }

    public static class MergePatchShipmentReceiptImageDto extends CreateOrMergePatchShipmentReceiptImageDto
    {
        public MergePatchShipmentReceiptImageDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentReceiptImageCommand.MergePatchShipmentReceiptImage toMergePatchShipmentReceiptImage()
        {
            return (ShipmentReceiptImageCommand.MergePatchShipmentReceiptImage) toCommand();
        }

    }

}

