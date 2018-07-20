package org.dddml.wms.domain.damagetype;


public class DeleteDamageTypeDto extends AbstractDamageTypeCommandDto
{

    public DeleteDamageTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DamageTypeCommand.DeleteDamageType toDeleteDamageType()
    {
        return new DamageTypeCommand.DeleteDamageType() {
            @Override
            public String getDamageTypeId() {
                return DeleteDamageTypeDto.this.getDamageTypeId();
            }

            @Override
            public void setDamageTypeId(String p) {
                DeleteDamageTypeDto.this.setDamageTypeId(p);
            }

            @Override
            public Long getVersion() {
                return DeleteDamageTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                DeleteDamageTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return DeleteDamageTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 DeleteDamageTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return DeleteDamageTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                DeleteDamageTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return DeleteDamageTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                DeleteDamageTypeDto.this.setRequesterId(requesterId);
            }


        };
    }
}

