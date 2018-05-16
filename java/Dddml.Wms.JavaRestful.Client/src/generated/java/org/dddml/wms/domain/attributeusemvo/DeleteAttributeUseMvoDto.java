package org.dddml.wms.domain.attributeusemvo;


public class DeleteAttributeUseMvoDto extends AbstractAttributeUseMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

