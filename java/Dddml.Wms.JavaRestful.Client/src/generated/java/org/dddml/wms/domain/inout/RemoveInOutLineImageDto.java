package org.dddml.wms.domain.inout;


public class RemoveInOutLineImageDto extends CreateOrMergePatchInOutLineImageDto
{

    public RemoveInOutLineImageDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

