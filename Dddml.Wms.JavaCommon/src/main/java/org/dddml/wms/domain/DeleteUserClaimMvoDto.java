package org.dddml.wms.domain;


public class DeleteUserClaimMvoDto extends AbstractUserClaimMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UserClaimMvoCommand.DeleteUserClaimMvo toDeleteUserClaimMvo()
    {
        AbstractUserClaimMvoCommand.SimpleDeleteUserClaimMvo command = new AbstractUserClaimMvoCommand.SimpleDeleteUserClaimMvo();
        ((AbstractUserClaimMvoCommandDto)this).copyTo(command);
        return command;
    }
}

