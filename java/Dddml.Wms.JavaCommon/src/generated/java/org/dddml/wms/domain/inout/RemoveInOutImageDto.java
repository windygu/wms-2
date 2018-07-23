package org.dddml.wms.domain.inout;


public class RemoveInOutImageDto extends CreateOrMergePatchInOutImageDto
{

    public RemoveInOutImageDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public InOutImageCommand.RemoveInOutImage toRemoveInOutImage()
    {
        AbstractInOutImageCommand.SimpleRemoveInOutImage command = new AbstractInOutImageCommand.SimpleRemoveInOutImage();
        ((AbstractInOutImageCommandDto)this).copyTo(command);
        return command;
    }
}

