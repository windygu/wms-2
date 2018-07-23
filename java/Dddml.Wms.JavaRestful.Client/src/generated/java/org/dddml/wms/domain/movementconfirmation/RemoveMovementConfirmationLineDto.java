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

}

