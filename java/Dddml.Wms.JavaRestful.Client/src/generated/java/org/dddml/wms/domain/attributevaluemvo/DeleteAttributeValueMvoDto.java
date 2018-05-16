package org.dddml.wms.domain.attributevaluemvo;


public class DeleteAttributeValueMvoDto extends AbstractAttributeValueMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

