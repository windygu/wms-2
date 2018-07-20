package org.dddml.wms.domain.damagetype;


public class DeleteDamageTypeDto extends AbstractDamageTypeCommandDto
{

    public DeleteDamageTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

