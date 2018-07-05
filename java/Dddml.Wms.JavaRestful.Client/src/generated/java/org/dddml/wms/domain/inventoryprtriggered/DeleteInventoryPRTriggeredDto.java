package org.dddml.wms.domain.inventoryprtriggered;


public class DeleteInventoryPRTriggeredDto extends AbstractInventoryPRTriggeredCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

