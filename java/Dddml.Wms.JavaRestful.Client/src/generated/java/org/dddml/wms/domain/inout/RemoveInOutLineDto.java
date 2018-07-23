package org.dddml.wms.domain.inout;


public class RemoveInOutLineDto extends CreateOrMergePatchInOutLineDto
{

    public RemoveInOutLineDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

