package org.dddml.wms.domain.movement;


public class DeleteMovementDto extends AbstractMovementCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

