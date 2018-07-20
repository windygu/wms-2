package org.dddml.wms.domain.physicalinventory;


public class DeletePhysicalInventoryDto extends AbstractPhysicalInventoryCommandDto
{

    public DeletePhysicalInventoryDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PhysicalInventoryCommand.DeletePhysicalInventory toDeletePhysicalInventory()
    {
        AbstractPhysicalInventoryCommand.SimpleDeletePhysicalInventory command = new AbstractPhysicalInventoryCommand.SimpleDeletePhysicalInventory();
        ((AbstractPhysicalInventoryCommandDto)this).copyTo(command);
        return command;
    }
}

