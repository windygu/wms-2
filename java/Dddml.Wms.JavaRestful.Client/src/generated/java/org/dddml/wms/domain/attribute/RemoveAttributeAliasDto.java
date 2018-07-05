package org.dddml.wms.domain.attribute;


public class RemoveAttributeAliasDto extends CreateOrMergePatchAttributeAliasDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

