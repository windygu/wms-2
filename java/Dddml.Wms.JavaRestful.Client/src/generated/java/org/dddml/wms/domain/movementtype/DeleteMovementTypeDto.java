package org.dddml.wms.domain.movementtype;


public class DeleteMovementTypeDto extends AbstractMovementTypeCommandDto
{

    public DeleteMovementTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

