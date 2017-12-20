package org.dddml.wms.domain.movementconfirmation;


public class DeleteMovementConfirmationDto extends AbstractMovementConfirmationCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MovementConfirmationCommand.DeleteMovementConfirmation toDeleteMovementConfirmation()
    {
        AbstractMovementConfirmationCommand.SimpleDeleteMovementConfirmation command = new AbstractMovementConfirmationCommand.SimpleDeleteMovementConfirmation();
        ((AbstractMovementConfirmationCommandDto)this).copyTo(command);
        return command;
    }
}

