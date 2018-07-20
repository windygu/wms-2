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

}

