package org.dddml.wms.domain;


public class DeleteTeamDto extends AbstractTeamCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public TeamCommand.DeleteTeam toDeleteTeam()
    {
        AbstractTeamCommand.SimpleDeleteTeam command = new AbstractTeamCommand.SimpleDeleteTeam();
        ((AbstractTeamCommandDto)this).copyTo(command);
        return command;
    }
}

