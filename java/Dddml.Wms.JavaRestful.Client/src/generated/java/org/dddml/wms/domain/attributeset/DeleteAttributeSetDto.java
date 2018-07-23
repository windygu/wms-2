package org.dddml.wms.domain.attributeset;


public class DeleteAttributeSetDto extends AbstractAttributeSetCommandDto
{

    public DeleteAttributeSetDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

