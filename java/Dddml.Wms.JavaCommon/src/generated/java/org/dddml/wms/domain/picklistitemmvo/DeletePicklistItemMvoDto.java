package org.dddml.wms.domain.picklistitemmvo;


public class DeletePicklistItemMvoDto extends AbstractPicklistItemMvoCommandDto
{

    public DeletePicklistItemMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PicklistItemMvoCommand.DeletePicklistItemMvo toDeletePicklistItemMvo()
    {
        AbstractPicklistItemMvoCommand.SimpleDeletePicklistItemMvo command = new AbstractPicklistItemMvoCommand.SimpleDeletePicklistItemMvo();
        ((AbstractPicklistItemMvoCommandDto)this).copyTo(command);
        return command;
    }
}

