package org.dddml.wms.domain.picklist;


public class DeletePicklistDto extends AbstractPicklistCommandDto
{

    public DeletePicklistDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

