package org.dddml.wms.domain.damagehandlingmethod;


public class DeleteDamageHandlingMethodDto extends AbstractDamageHandlingMethodCommandDto
{

    public DeleteDamageHandlingMethodDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DamageHandlingMethodCommand.DeleteDamageHandlingMethod toDeleteDamageHandlingMethod()
    {
        return new DamageHandlingMethodCommand.DeleteDamageHandlingMethod() {
            @Override
            public String getDamageHandlingMethodId() {
                return DeleteDamageHandlingMethodDto.this.getDamageHandlingMethodId();
            }

            @Override
            public void setDamageHandlingMethodId(String p) {
                DeleteDamageHandlingMethodDto.this.setDamageHandlingMethodId(p);
            }

            @Override
            public Long getVersion() {
                return DeleteDamageHandlingMethodDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                DeleteDamageHandlingMethodDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return DeleteDamageHandlingMethodDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 DeleteDamageHandlingMethodDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return DeleteDamageHandlingMethodDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                DeleteDamageHandlingMethodDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return DeleteDamageHandlingMethodDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                DeleteDamageHandlingMethodDto.this.setRequesterId(requesterId);
            }

            private java.util.Map<String, Object> commandContext;

            @Override
            public java.util.Map<String, Object> getCommandContext() {
                return commandContext;
            }

            public void setCommandContext(java.util.Map<String, Object> commandContext) {
                this.commandContext = commandContext;
            }


        };
    }
}

