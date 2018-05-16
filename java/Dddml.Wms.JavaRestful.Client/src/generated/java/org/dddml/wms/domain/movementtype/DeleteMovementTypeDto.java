package org.dddml.wms.domain.movementtype;


public class DeleteMovementTypeDto extends AbstractMovementTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

