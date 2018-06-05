package org.dddml.wms.domain.goodidentificationtype;


public class DeleteGoodIdentificationTypeDto extends AbstractGoodIdentificationTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

