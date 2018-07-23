package org.dddml.wms.domain.inoutlinemvo;


public class DeleteInOutLineMvoDto extends AbstractInOutLineMvoCommandDto
{

    public DeleteInOutLineMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InOutLineMvoCommand.DeleteInOutLineMvo toDeleteInOutLineMvo()
    {
        AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo command = new AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo();
        ((AbstractInOutLineMvoCommandDto)this).copyTo(command);
        return command;
    }
}

