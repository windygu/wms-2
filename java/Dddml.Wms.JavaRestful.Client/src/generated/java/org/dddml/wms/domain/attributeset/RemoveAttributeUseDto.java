package org.dddml.wms.domain.attributeset;


public class RemoveAttributeUseDto extends CreateOrMergePatchAttributeUseDto
{

    public RemoveAttributeUseDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

