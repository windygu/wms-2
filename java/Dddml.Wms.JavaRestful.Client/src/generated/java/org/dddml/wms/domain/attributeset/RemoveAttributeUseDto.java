package org.dddml.wms.domain.attributeset;


public class RemoveAttributeUseDto extends CreateOrMergePatchAttributeUseDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

