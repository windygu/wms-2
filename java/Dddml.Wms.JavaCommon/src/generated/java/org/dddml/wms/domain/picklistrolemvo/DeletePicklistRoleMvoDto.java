package org.dddml.wms.domain.picklistrolemvo;


public class DeletePicklistRoleMvoDto extends AbstractPicklistRoleMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PicklistRoleMvoCommand.DeletePicklistRoleMvo toDeletePicklistRoleMvo()
    {
        AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo command = new AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo();
        ((AbstractPicklistRoleMvoCommandDto)this).copyTo(command);
        return command;
    }
}

