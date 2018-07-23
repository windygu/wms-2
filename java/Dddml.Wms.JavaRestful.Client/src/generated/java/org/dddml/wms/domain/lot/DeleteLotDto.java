package org.dddml.wms.domain.lot;


public class DeleteLotDto extends AbstractLotCommandDto
{

    public DeleteLotDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

