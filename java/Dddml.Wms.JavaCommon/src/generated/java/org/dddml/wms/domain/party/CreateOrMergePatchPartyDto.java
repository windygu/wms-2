package org.dddml.wms.domain.party;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPartyDto extends AbstractPartyCommandDto
{
    /**
     * Party Type Id
     */
    private String partyTypeId;

    public String getPartyTypeId()
    {
        return this.partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId)
    {
        this.partyTypeId = partyTypeId;
    }

    /**
     * Primary Role Type Id
     */
    private String primaryRoleTypeId;

    public String getPrimaryRoleTypeId()
    {
        return this.primaryRoleTypeId;
    }

    public void setPrimaryRoleTypeId(String primaryRoleTypeId)
    {
        this.primaryRoleTypeId = primaryRoleTypeId;
    }

    /**
     * Organization Name
     */
    private String organizationName;

    public String getOrganizationName()
    {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Type
     */
    private String type;

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Is Summary
     */
    private Boolean isSummary;

    public Boolean getIsSummary()
    {
        return this.isSummary;
    }

    public void setIsSummary(Boolean isSummary)
    {
        this.isSummary = isSummary;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyPartyTypeIdRemoved;

    public Boolean getIsPropertyPartyTypeIdRemoved()
    {
        return this.isPropertyPartyTypeIdRemoved;
    }

    public void setIsPropertyPartyTypeIdRemoved(Boolean removed)
    {
        this.isPropertyPartyTypeIdRemoved = removed;
    }

    private Boolean isPropertyPrimaryRoleTypeIdRemoved;

    public Boolean getIsPropertyPrimaryRoleTypeIdRemoved()
    {
        return this.isPropertyPrimaryRoleTypeIdRemoved;
    }

    public void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed)
    {
        this.isPropertyPrimaryRoleTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrganizationNameRemoved;

    public Boolean getIsPropertyOrganizationNameRemoved()
    {
        return this.isPropertyOrganizationNameRemoved;
    }

    public void setIsPropertyOrganizationNameRemoved(Boolean removed)
    {
        this.isPropertyOrganizationNameRemoved = removed;
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

    private Boolean isPropertyTypeRemoved;

    public Boolean getIsPropertyTypeRemoved()
    {
        return this.isPropertyTypeRemoved;
    }

    public void setIsPropertyTypeRemoved(Boolean removed)
    {
        this.isPropertyTypeRemoved = removed;
    }

    private Boolean isPropertyIsSummaryRemoved;

    public Boolean getIsPropertyIsSummaryRemoved()
    {
        return this.isPropertyIsSummaryRemoved;
    }

    public void setIsPropertyIsSummaryRemoved(Boolean removed)
    {
        this.isPropertyIsSummaryRemoved = removed;
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

    public void copyTo(AbstractPartyCommand.AbstractCreateOrMergePatchParty command)
    {
        ((AbstractPartyCommandDto) this).copyTo(command);
        command.setPartyTypeId(this.getPartyTypeId());
        command.setPrimaryRoleTypeId(this.getPrimaryRoleTypeId());
        command.setOrganizationName(this.getOrganizationName());
        command.setDescription(this.getDescription());
        command.setType(this.getType());
        command.setIsSummary(this.getIsSummary());
        command.setActive(this.getActive());
    }

    public PartyCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPartyCommand.SimpleCreateParty command = new AbstractPartyCommand.SimpleCreateParty();
            copyTo((AbstractPartyCommand.AbstractCreateParty) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPartyCommand.SimpleMergePatchParty command = new AbstractPartyCommand.SimpleMergePatchParty();
            copyTo((AbstractPartyCommand.SimpleMergePatchParty) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPartyCommand.AbstractCreateParty command)
    {
        copyTo((AbstractPartyCommand.AbstractCreateOrMergePatchParty) command);
    }

    public void copyTo(AbstractPartyCommand.AbstractMergePatchParty command)
    {
        copyTo((AbstractPartyCommand.AbstractCreateOrMergePatchParty) command);
        command.setIsPropertyPartyTypeIdRemoved(this.getIsPropertyPartyTypeIdRemoved());
        command.setIsPropertyPrimaryRoleTypeIdRemoved(this.getIsPropertyPrimaryRoleTypeIdRemoved());
        command.setIsPropertyOrganizationNameRemoved(this.getIsPropertyOrganizationNameRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyTypeRemoved(this.getIsPropertyTypeRemoved());
        command.setIsPropertyIsSummaryRemoved(this.getIsPropertyIsSummaryRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePartyDto extends CreateOrMergePatchPartyDto
    {
        public CreatePartyDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PartyCommand.CreateParty toCreateParty()
        {
            return (PartyCommand.CreateParty) toCommand();
        }

    }

    public static class MergePatchPartyDto extends CreateOrMergePatchPartyDto
    {
        public MergePatchPartyDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PartyCommand.MergePatchParty toMergePatchParty()
        {
            return (PartyCommand.MergePatchParty) toCommand();
        }

    }

}

