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

    public LotCommand.DeleteLot toDeleteLot()
    {
        AbstractLotCommand.SimpleDeleteLot command = new AbstractLotCommand.SimpleDeleteLot();
        ((AbstractLotCommandDto)this).copyTo(command);
        return command;
    }
}

