package org.dddml.wms.domain.locatortype;


public class DeleteLocatorTypeDto extends AbstractLocatorTypeCommandDto
{

    public DeleteLocatorTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

