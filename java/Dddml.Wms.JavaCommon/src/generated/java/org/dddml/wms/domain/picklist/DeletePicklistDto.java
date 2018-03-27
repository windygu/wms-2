package org.dddml.wms.domain.picklist;


public class DeletePicklistDto extends AbstractPicklistCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public PicklistCommand.DeletePicklist toDeletePicklist()
    {
        AbstractPicklistCommand.SimpleDeletePicklist command = new AbstractPicklistCommand.SimpleDeletePicklist();
        ((AbstractPicklistCommandDto)this).copyTo(command);
        return command;
    }
}

