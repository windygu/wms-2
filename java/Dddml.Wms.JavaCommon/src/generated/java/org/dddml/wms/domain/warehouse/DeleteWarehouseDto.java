package org.dddml.wms.domain.warehouse;


public class DeleteWarehouseDto extends AbstractWarehouseCommandDto
{

    public DeleteWarehouseDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public WarehouseCommand.DeleteWarehouse toDeleteWarehouse()
    {
        AbstractWarehouseCommand.SimpleDeleteWarehouse command = new AbstractWarehouseCommand.SimpleDeleteWarehouse();
        ((AbstractWarehouseCommandDto)this).copyTo(command);
        return command;
    }
}

