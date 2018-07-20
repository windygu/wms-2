package org.dddml.wms.domain.movement;


public class DeleteMovementDto extends AbstractMovementCommandDto
{

    public DeleteMovementDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

