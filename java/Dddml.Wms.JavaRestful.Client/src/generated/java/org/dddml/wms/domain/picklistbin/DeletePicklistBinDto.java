package org.dddml.wms.domain.picklistbin;


public class DeletePicklistBinDto extends AbstractPicklistBinCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

