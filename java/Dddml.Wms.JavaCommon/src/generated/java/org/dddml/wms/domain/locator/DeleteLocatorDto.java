package org.dddml.wms.domain.locator;


public class DeleteLocatorDto extends AbstractLocatorCommandDto
{

    public DeleteLocatorDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public LocatorCommand.DeleteLocator toDeleteLocator()
    {
        AbstractLocatorCommand.SimpleDeleteLocator command = new AbstractLocatorCommand.SimpleDeleteLocator();
        ((AbstractLocatorCommandDto)this).copyTo(command);
        return command;
    }
}

