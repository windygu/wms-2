package org.dddml.wms.domain.statusitem;


public class DeleteStatusItemDto extends AbstractStatusItemCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

