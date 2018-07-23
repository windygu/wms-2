package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentMethodTypeDto extends AbstractShipmentMethodTypeCommandDto
{
    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Sequence Num
     */
    private Long sequenceNum;

    public Long getSequenceNum()
    {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum)
    {
        this.sequenceNum = sequenceNum;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertySequenceNumRemoved;

    public Boolean getIsPropertySequenceNumRemoved()
    {
        return this.isPropertySequenceNumRemoved;
    }

    public void setIsPropertySequenceNumRemoved(Boolean removed)
    {
        this.isPropertySequenceNumRemoved = removed;
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

    public void copyTo(AbstractShipmentMethodTypeCommand.AbstractCreateOrMergePatchShipmentMethodType command)
    {
        ((AbstractShipmentMethodTypeCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setSequenceNum(this.getSequenceNum());
        command.setActive(this.getActive());
    }

    public ShipmentMethodTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentMethodTypeCommand.SimpleCreateShipmentMethodType command = new AbstractShipmentMethodTypeCommand.SimpleCreateShipmentMethodType();
            copyTo((AbstractShipmentMethodTypeCommand.AbstractCreateShipmentMethodType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentMethodTypeCommand.SimpleMergePatchShipmentMethodType command = new AbstractShipmentMethodTypeCommand.SimpleMergePatchShipmentMethodType();
            copyTo((AbstractShipmentMethodTypeCommand.SimpleMergePatchShipmentMethodType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentMethodTypeCommand.AbstractCreateShipmentMethodType command)
    {
        copyTo((AbstractShipmentMethodTypeCommand.AbstractCreateOrMergePatchShipmentMethodType) command);
    }

    public void copyTo(AbstractShipmentMethodTypeCommand.AbstractMergePatchShipmentMethodType command)
    {
        copyTo((AbstractShipmentMethodTypeCommand.AbstractCreateOrMergePatchShipmentMethodType) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertySequenceNumRemoved(this.getIsPropertySequenceNumRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentMethodTypeDto extends CreateOrMergePatchShipmentMethodTypeDto
    {
        public CreateShipmentMethodTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentMethodTypeCommand.CreateShipmentMethodType toCreateShipmentMethodType()
        {
            return (ShipmentMethodTypeCommand.CreateShipmentMethodType) toCommand();
        }

    }

    public static class MergePatchShipmentMethodTypeDto extends CreateOrMergePatchShipmentMethodTypeDto
    {
        public MergePatchShipmentMethodTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentMethodTypeCommand.MergePatchShipmentMethodType toMergePatchShipmentMethodType()
        {
            return (ShipmentMethodTypeCommand.MergePatchShipmentMethodType) toCommand();
        }

    }

}

