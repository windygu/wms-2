package org.dddml.wms.domain.inout;


public class RemoveInOutLineDto extends CreateOrMergePatchInOutLineDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

