package org.dddml.wms.domain.locator;


public class DeleteLocatorDto extends AbstractLocatorCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

