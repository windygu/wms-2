package org.dddml.wms.domain.picklistbin;


public class RemovePicklistItemDto extends CreateOrMergePatchPicklistItemDto
{

    public RemovePicklistItemDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

