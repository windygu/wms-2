package org.dddml.wms.domain.locatortype;


public class DeleteLocatorTypeDto extends AbstractLocatorTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

