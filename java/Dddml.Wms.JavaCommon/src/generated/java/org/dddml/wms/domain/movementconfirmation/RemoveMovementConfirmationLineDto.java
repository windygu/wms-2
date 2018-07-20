package org.dddml.wms.domain.movementconfirmation;


public class RemoveMovementConfirmationLineDto extends CreateOrMergePatchMovementConfirmationLineDto
{

    public RemoveMovementConfirmationLineDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public MovementConfirmationLineCommand.RemoveMovementConfirmationLine toRemoveMovementConfirmationLine()
    {
        AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine command = new AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine();
        ((AbstractMovementConfirmationLineCommandDto)this).copyTo(command);
        return command;
    }
}

