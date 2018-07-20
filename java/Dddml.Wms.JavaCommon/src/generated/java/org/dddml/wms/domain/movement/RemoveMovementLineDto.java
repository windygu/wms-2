package org.dddml.wms.domain.movement;


public class RemoveMovementLineDto extends CreateOrMergePatchMovementLineDto
{

    public RemoveMovementLineDto() {
        this.commandType = COMMAND_TYPE_REMOVE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public MovementLineCommand.RemoveMovementLine toRemoveMovementLine()
    {
        AbstractMovementLineCommand.SimpleRemoveMovementLine command = new AbstractMovementLineCommand.SimpleRemoveMovementLine();
        ((AbstractMovementLineCommandDto)this).copyTo(command);
        return command;
    }
}

