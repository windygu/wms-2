package org.dddml.wms.domain.physicalinventory;


public class DeletePhysicalInventoryDto extends AbstractPhysicalInventoryCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

