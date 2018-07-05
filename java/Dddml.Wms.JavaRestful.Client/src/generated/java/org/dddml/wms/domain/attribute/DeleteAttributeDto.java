package org.dddml.wms.domain.attribute;


public class DeleteAttributeDto extends AbstractAttributeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

