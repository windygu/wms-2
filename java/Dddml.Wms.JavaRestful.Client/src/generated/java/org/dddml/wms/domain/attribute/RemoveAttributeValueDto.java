package org.dddml.wms.domain.attribute;


public class RemoveAttributeValueDto extends CreateOrMergePatchAttributeValueDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

