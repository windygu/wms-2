package org.dddml.wms.domain.movementconfirmation;


public class DeleteMovementConfirmationDto extends AbstractMovementConfirmationCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

