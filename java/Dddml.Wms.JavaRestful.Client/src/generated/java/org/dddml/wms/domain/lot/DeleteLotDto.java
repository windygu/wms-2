package org.dddml.wms.domain.lot;


public class DeleteLotDto extends AbstractLotCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

