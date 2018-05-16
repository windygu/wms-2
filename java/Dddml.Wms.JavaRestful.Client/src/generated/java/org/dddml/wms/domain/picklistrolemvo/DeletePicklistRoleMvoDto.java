package org.dddml.wms.domain.picklistrolemvo;


public class DeletePicklistRoleMvoDto extends AbstractPicklistRoleMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

