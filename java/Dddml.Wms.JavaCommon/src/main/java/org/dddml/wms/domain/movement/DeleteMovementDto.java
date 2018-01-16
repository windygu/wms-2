package org.dddml.wms.domain.movement;


public class DeleteMovementDto extends AbstractMovementCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MovementCommand.DeleteMovement toDeleteMovement()
    {
        AbstractMovementCommand.SimpleDeleteMovement command = new AbstractMovementCommand.SimpleDeleteMovement();
        ((AbstractMovementCommandDto)this).copyTo(command);
        return command;
    }
}

