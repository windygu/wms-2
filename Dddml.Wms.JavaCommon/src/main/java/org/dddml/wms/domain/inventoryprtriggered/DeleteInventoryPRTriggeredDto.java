package org.dddml.wms.domain.inventoryprtriggered;


public class DeleteInventoryPRTriggeredDto extends AbstractInventoryPRTriggeredCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InventoryPRTriggeredCommand.DeleteInventoryPRTriggered toDeleteInventoryPRTriggered()
    {
        AbstractInventoryPRTriggeredCommand.SimpleDeleteInventoryPRTriggered command = new AbstractInventoryPRTriggeredCommand.SimpleDeleteInventoryPRTriggered();
        ((AbstractInventoryPRTriggeredCommandDto)this).copyTo(command);
        return command;
    }
}

