package org.dddml.wms.domain;


public class RemoveUserClaimDto extends CreateOrMergePatchUserClaimDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_REMOVE;
    }

    public UserClaimCommand.RemoveUserClaim toRemoveUserClaim()
    {
        AbstractUserClaimCommand.SimpleRemoveUserClaim command = new AbstractUserClaimCommand.SimpleRemoveUserClaim();
        ((AbstractUserClaimCommandDto)this).copyTo(command);
        return command;
    }
}

