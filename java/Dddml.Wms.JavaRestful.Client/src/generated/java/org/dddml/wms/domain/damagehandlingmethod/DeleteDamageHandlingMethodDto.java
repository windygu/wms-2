package org.dddml.wms.domain.damagehandlingmethod;


public class DeleteDamageHandlingMethodDto extends AbstractDamageHandlingMethodCommandDto
{

    public DeleteDamageHandlingMethodDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

