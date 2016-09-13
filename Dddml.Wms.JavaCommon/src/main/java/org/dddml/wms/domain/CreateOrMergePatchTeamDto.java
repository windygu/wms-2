package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchTeamDto extends AbstractTeamCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private PersonalNameDto[] players;

    public PersonalNameDto[] getPlayers() {
        return this.players;
    }

    public void setPlayers(PersonalNameDto[] players) {
        this.players = players;
    }

    private String[] mascots;

    public String[] getMascots() {
        return this.mascots;
    }

    public void setMascots(String[] mascots) {
        this.mascots = mascots;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyPlayersRemoved;

    public Boolean getIsPropertyPlayersRemoved()
    {
        return this.isPropertyPlayersRemoved;
    }

    public void setIsPropertyPlayersRemoved(Boolean removed)
    {
        this.isPropertyPlayersRemoved = removed;
    }

    private Boolean isPropertyMascotsRemoved;

    public Boolean getIsPropertyMascotsRemoved()
    {
        return this.isPropertyMascotsRemoved;
    }

    public void setIsPropertyMascotsRemoved(Boolean removed)
    {
        this.isPropertyMascotsRemoved = removed;
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

    public void copyTo(AbstractTeamCommand.AbstractCreateOrMergePatchTeam command)
    {
        ((AbstractTeamCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public TeamCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractTeamCommand.SimpleCreateTeam command = new AbstractTeamCommand.SimpleCreateTeam();
            copyTo((AbstractTeamCommand.AbstractCreateTeam) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractTeamCommand.SimpleMergePatchTeam command = new AbstractTeamCommand.SimpleMergePatchTeam();
            copyTo((AbstractTeamCommand.SimpleMergePatchTeam) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractTeamCommand.AbstractCreateTeam command)
    {
        copyTo((AbstractTeamCommand.AbstractCreateOrMergePatchTeam) command);
    }

    public void copyTo(AbstractTeamCommand.AbstractMergePatchTeam command)
    {
        copyTo((AbstractTeamCommand.AbstractCreateOrMergePatchTeam) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyPlayersRemoved(this.getIsPropertyPlayersRemoved());
        command.setIsPropertyMascotsRemoved(this.getIsPropertyMascotsRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateTeamDto extends CreateOrMergePatchTeamDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public TeamCommand.CreateTeam toCreateTeam()
        {
            return (TeamCommand.CreateTeam) toCommand();
        }

    }

    public static class MergePatchTeamDto extends CreateOrMergePatchTeamDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public TeamCommand.MergePatchTeam toMergePatchTeam()
        {
            return (TeamCommand.MergePatchTeam) toCommand();
        }

    }

}

