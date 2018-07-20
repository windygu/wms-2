package org.dddml.wms.domain.documenttype;


public class DeleteDocumentTypeDto extends AbstractDocumentTypeCommandDto
{

    public DeleteDocumentTypeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DocumentTypeCommand.DeleteDocumentType toDeleteDocumentType()
    {
        return new DocumentTypeCommand.DeleteDocumentType() {
            @Override
            public String getDocumentTypeId() {
                return DeleteDocumentTypeDto.this.getDocumentTypeId();
            }

            @Override
            public void setDocumentTypeId(String p) {
                DeleteDocumentTypeDto.this.setDocumentTypeId(p);
            }

            @Override
            public Long getVersion() {
                return DeleteDocumentTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                DeleteDocumentTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return DeleteDocumentTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 DeleteDocumentTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return DeleteDocumentTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                DeleteDocumentTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return DeleteDocumentTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                DeleteDocumentTypeDto.this.setRequesterId(requesterId);
            }


        };
    }
}

