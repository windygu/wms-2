package org.dddml.wms.domain;


public class DeleteLocatorDto extends AbstractLocatorCommandDto
{

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

