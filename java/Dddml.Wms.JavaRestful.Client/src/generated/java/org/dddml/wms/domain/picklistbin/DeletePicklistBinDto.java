package org.dddml.wms.domain.picklistbin;


public class DeletePicklistBinDto extends AbstractPicklistBinCommandDto
{

    public DeletePicklistBinDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

