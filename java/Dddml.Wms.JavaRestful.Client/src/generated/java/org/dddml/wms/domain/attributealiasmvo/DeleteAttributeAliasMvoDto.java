package org.dddml.wms.domain.attributealiasmvo;


public class DeleteAttributeAliasMvoDto extends AbstractAttributeAliasMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

