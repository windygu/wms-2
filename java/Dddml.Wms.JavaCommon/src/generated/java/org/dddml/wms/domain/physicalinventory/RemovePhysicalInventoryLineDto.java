package org.dddml.wms.domain.physicalinventory;


public class RemovePhysicalInventoryLineDto extends CreateOrMergePatchPhysicalInventoryLineDto
{

    public RemovePhysicalInventoryLineDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public PhysicalInventoryLineCommand.RemovePhysicalInventoryLine toRemovePhysicalInventoryLine()
    {
        AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine command = new AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine();
        ((AbstractPhysicalInventoryLineCommandDto)this).copyTo(command);
        return command;
    }
}

