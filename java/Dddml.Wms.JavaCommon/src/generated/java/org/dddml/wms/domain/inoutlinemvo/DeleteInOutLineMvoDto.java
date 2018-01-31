package org.dddml.wms.domain.inoutlinemvo;


public class DeleteInOutLineMvoDto extends AbstractInOutLineMvoCommandDto
{

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

