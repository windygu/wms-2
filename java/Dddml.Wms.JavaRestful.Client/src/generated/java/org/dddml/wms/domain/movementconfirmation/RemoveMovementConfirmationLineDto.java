package org.dddml.wms.domain.movementconfirmation;


public class RemoveMovementConfirmationLineDto extends CreateOrMergePatchMovementConfirmationLineDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

}

