package org.dddml.wms.domain.documenttype;


public class DeleteDocumentTypeDto extends AbstractDocumentTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

