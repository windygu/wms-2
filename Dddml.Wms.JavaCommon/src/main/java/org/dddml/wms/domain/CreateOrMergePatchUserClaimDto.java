package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchUserClaimDto extends AbstractUserClaimCommandDto
{
    private String claimType;

    public String getClaimType()
    {
        return this.claimType;
    }

    public void setClaimType(String claimType)
    {
        this.claimType = claimType;
    }

    private String claimValue;

    public String getClaimValue()
    {
        return this.claimValue;
    }

    public void setClaimValue(String claimValue)
    {
        this.claimValue = claimValue;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyClaimTypeRemoved;

    public Boolean getIsPropertyClaimTypeRemoved()
    {
        return this.isPropertyClaimTypeRemoved;
    }

    public void setIsPropertyClaimTypeRemoved(Boolean removed)
    {
        this.isPropertyClaimTypeRemoved = removed;
    }

    private Boolean isPropertyClaimValueRemoved;

    public Boolean getIsPropertyClaimValueRemoved()
    {
        return this.isPropertyClaimValueRemoved;
    }

    public void setIsPropertyClaimValueRemoved(Boolean removed)
    {
        this.isPropertyClaimValueRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractUserClaimCommand.AbstractCreateOrMergePatchUserClaim command)
    {
        ((AbstractUserClaimCommandDto) this).copyTo(command);
        command.setClaimType(this.getClaimType());
        command.setClaimValue(this.getClaimValue());
        command.setActive(this.getActive());
    }

    public UserClaimCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUserClaimCommand.SimpleCreateUserClaim command = new AbstractUserClaimCommand.SimpleCreateUserClaim();
            copyTo((AbstractUserClaimCommand.AbstractCreateUserClaim) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUserClaimCommand.SimpleMergePatchUserClaim command = new AbstractUserClaimCommand.SimpleMergePatchUserClaim();
            copyTo((AbstractUserClaimCommand.SimpleMergePatchUserClaim) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractUserClaimCommand.SimpleRemoveUserClaim command = new AbstractUserClaimCommand.SimpleRemoveUserClaim();
            ((AbstractUserClaimCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUserClaimCommand.AbstractCreateUserClaim command)
    {
        copyTo((AbstractUserClaimCommand.AbstractCreateOrMergePatchUserClaim) command);
    }

    public void copyTo(AbstractUserClaimCommand.AbstractMergePatchUserClaim command)
    {
        copyTo((AbstractUserClaimCommand.AbstractCreateOrMergePatchUserClaim) command);
        command.setIsPropertyClaimTypeRemoved(this.getIsPropertyClaimTypeRemoved());
        command.setIsPropertyClaimValueRemoved(this.getIsPropertyClaimValueRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUserClaimDto extends CreateOrMergePatchUserClaimDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UserClaimCommand.CreateUserClaim toCreateUserClaim()
        {
            return (UserClaimCommand.CreateUserClaim) toCommand();
        }

    }

    public static class MergePatchUserClaimDto extends CreateOrMergePatchUserClaimDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UserClaimCommand.MergePatchUserClaim toMergePatchUserClaim()
        {
            return (UserClaimCommand.MergePatchUserClaim) toCommand();
        }

    }

}

