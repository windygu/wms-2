package org.dddml.wms.domain.statusitem;


public class DeleteStatusItemDto extends AbstractStatusItemCommandDto
{

    public DeleteStatusItemDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

