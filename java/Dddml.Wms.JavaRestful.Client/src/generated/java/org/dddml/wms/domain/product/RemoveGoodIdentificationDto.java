package org.dddml.wms.domain.product;


public class RemoveGoodIdentificationDto extends CreateOrMergePatchGoodIdentificationDto
{

    public RemoveGoodIdentificationDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

