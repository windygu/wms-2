package org.dddml.wms.domain.inout;


public class DeleteInOutDto extends AbstractInOutCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public InOutCommand.DeleteInOut toDeleteInOut()
    {
        AbstractInOutCommand.SimpleDeleteInOut command = new AbstractInOutCommand.SimpleDeleteInOut();
        ((AbstractInOutCommandDto)this).copyTo(command);
        return command;
    }
}

