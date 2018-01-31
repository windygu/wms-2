package org.dddml.wms.domain.movementtype;


public class DeleteMovementTypeDto extends AbstractMovementTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public MovementTypeCommand.DeleteMovementType toDeleteMovementType()
    {
        return new MovementTypeCommand.DeleteMovementType() {
            @Override
            public String getMovementTypeId() {
                return DeleteMovementTypeDto.this.getMovementTypeId();
            }

            @Override
            public void setMovementTypeId(String p) {
                DeleteMovementTypeDto.this.setMovementTypeId(p);
            }

            @Override
            public Long getVersion() {
                return DeleteMovementTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                DeleteMovementTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return DeleteMovementTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 DeleteMovementTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return DeleteMovementTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                DeleteMovementTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return DeleteMovementTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                DeleteMovementTypeDto.this.setRequesterId(requesterId);
            }


        };
    }
}

