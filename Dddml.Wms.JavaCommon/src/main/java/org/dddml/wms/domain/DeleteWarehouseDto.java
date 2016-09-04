package org.dddml.wms.domain;


public class DeleteWarehouseDto extends AbstractWarehouseCommandDto
{

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

