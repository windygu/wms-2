package org.dddml.wms.domain.movementlinemvo;


public class DeleteMovementLineMvoDto extends AbstractMovementLineMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MovementLineMvoCommand.DeleteMovementLineMvo toDeleteMovementLineMvo()
    {
        AbstractMovementLineMvoCommand.SimpleDeleteMovementLineMvo command = new AbstractMovementLineMvoCommand.SimpleDeleteMovementLineMvo();
        ((AbstractMovementLineMvoCommandDto)this).copyTo(command);
        return command;
    }
}

