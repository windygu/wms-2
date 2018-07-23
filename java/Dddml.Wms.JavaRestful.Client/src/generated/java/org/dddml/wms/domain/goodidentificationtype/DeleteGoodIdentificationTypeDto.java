package org.dddml.wms.domain.goodidentificationtype;


public class DeleteGoodIdentificationTypeDto extends AbstractGoodIdentificationTypeCommandDto
{

    public DeleteGoodIdentificationTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

