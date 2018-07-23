package org.dddml.wms.domain.movementconfirmationlinemvo;


public class DeleteMovementConfirmationLineMvoDto extends AbstractMovementConfirmationLineMvoCommandDto
{

    public DeleteMovementConfirmationLineMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo toDeleteMovementConfirmationLineMvo()
    {
        AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo command = new AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo();
        ((AbstractMovementConfirmationLineMvoCommandDto)this).copyTo(command);
        return command;
    }
}

