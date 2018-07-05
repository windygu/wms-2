package org.dddml.wms.domain.physicalinventory;


public class RemovePhysicalInventoryLineDto extends CreateOrMergePatchPhysicalInventoryLineDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

