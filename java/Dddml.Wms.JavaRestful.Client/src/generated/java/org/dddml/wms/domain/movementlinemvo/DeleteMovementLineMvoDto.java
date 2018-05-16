package org.dddml.wms.domain.movementlinemvo;


public class DeleteMovementLineMvoDto extends AbstractMovementLineMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

