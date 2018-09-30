package org.dddml.wms.domain.uomtype;


public class DeleteUomTypeDto extends AbstractUomTypeCommandDto
{

    public DeleteUomTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UomTypeCommand.DeleteUomType toDeleteUomType()
    {
        return new UomTypeCommand.DeleteUomType() {
            @Override
            public String getUomTypeId() {
                return DeleteUomTypeDto.this.getUomTypeId();
            }

            @Override
            public void setUomTypeId(String p) {
                DeleteUomTypeDto.this.setUomTypeId(p);
            }

            @Override
            public Long getVersion() {
                return DeleteUomTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                DeleteUomTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return DeleteUomTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 DeleteUomTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return DeleteUomTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                DeleteUomTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return DeleteUomTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                DeleteUomTypeDto.this.setRequesterId(requesterId);
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

