package org.dddml.wms.domain.movementtype;


public class DeleteMovementTypeDto extends AbstractMovementTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MovementTypeCommand.DeleteMovementType toDeleteMovementType()
    {
        AbstractMovementTypeCommand.SimpleDeleteMovementType command = new AbstractMovementTypeCommand.SimpleDeleteMovementType();
        ((AbstractMovementTypeCommandDto)this).copyTo(command);
        return command;
    }
}

