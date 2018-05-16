package org.dddml.wms.domain.physicalinventorylinemvo;


public class DeletePhysicalInventoryLineMvoDto extends AbstractPhysicalInventoryLineMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

