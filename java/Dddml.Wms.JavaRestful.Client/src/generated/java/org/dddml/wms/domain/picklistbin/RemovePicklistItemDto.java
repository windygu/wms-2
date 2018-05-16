package org.dddml.wms.domain.picklistbin;


public class RemovePicklistItemDto extends CreateOrMergePatchPicklistItemDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

