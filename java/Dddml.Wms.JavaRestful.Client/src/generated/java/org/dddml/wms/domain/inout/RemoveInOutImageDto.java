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

}

