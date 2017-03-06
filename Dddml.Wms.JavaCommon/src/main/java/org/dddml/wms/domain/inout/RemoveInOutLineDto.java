package org.dddml.wms.domain.inout;


public class RemoveInOutLineDto extends CreateOrMergePatchInOutLineDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public InOutLineCommand.RemoveInOutLine toRemoveInOutLine()
    {
        AbstractInOutLineCommand.SimpleRemoveInOutLine command = new AbstractInOutLineCommand.SimpleRemoveInOutLine();
        ((AbstractInOutLineCommandDto)this).copyTo(command);
        return command;
    }
}

