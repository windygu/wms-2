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
     * External Id
     */
    private String externalId;

    public String getExternalId()
    {
        return this.externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    /**
     * Preferred Currency Uom Id
     */
    private String preferredCurrencyUomId;

    public String getPreferredCurrencyUomId()
    {
        return this.preferredCurrencyUomId;
    }

    public void setPreferredCurrencyUomId(String preferredCurrencyUomId)
    {
        this.preferredCurrencyUomId = preferredCurrencyUomId;
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
     * Salutation
     */
    private String salutation;

    public String getSalutation()
    {
        return this.salutation;
    }

    public void setSalutation(String salutation)
    {
        this.salutation = salutation;
    }

    /**
     * First Name
     */
    private String firstName;

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Middle Name
     */
    private String middleName;

    public String getMiddleName()
    {
        return this.middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /**
     * Last Name
     */
    private String lastName;

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Personal Title
     */
    private String personalTitle;

    public String getPersonalTitle()
    {
        return this.personalTitle;
    }

    public void setPersonalTitle(String personalTitle)
    {
        this.personalTitle = personalTitle;
    }

    /**
     * Nickname
     */
    private String nickname;

    public String getNickname()
    {
        return this.nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    /**
     * Card Id
     */
    private String cardId;

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
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

    private Boolean isPropertyExternalIdRemoved;

    public Boolean getIsPropertyExternalIdRemoved()
    {
        return this.isPropertyExternalIdRemoved;
    }

    public void setIsPropertyExternalIdRemoved(Boolean removed)
    {
        this.isPropertyExternalIdRemoved = removed;
    }

    private Boolean isPropertyPreferredCurrencyUomIdRemoved;

    public Boolean getIsPropertyPreferredCurrencyUomIdRemoved()
    {
        return this.isPropertyPreferredCurrencyUomIdRemoved;
    }

    public void setIsPropertyPreferredCurrencyUomIdRemoved(Boolean removed)
    {
        this.isPropertyPreferredCurrencyUomIdRemoved = removed;
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

    private Boolean isPropertyOrganizationNameRemoved;

    public Boolean getIsPropertyOrganizationNameRemoved()
    {
        return this.isPropertyOrganizationNameRemoved;
    }

    public void setIsPropertyOrganizationNameRemoved(Boolean removed)
    {
        this.isPropertyOrganizationNameRemoved = removed;
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

    private Boolean isPropertySalutationRemoved;

    public Boolean getIsPropertySalutationRemoved()
    {
        return this.isPropertySalutationRemoved;
    }

    public void setIsPropertySalutationRemoved(Boolean removed)
    {
        this.isPropertySalutationRemoved = removed;
    }

    private Boolean isPropertyFirstNameRemoved;

    public Boolean getIsPropertyFirstNameRemoved()
    {
        return this.isPropertyFirstNameRemoved;
    }

    public void setIsPropertyFirstNameRemoved(Boolean removed)
    {
        this.isPropertyFirstNameRemoved = removed;
    }

    private Boolean isPropertyMiddleNameRemoved;

    public Boolean getIsPropertyMiddleNameRemoved()
    {
        return this.isPropertyMiddleNameRemoved;
    }

    public void setIsPropertyMiddleNameRemoved(Boolean removed)
    {
        this.isPropertyMiddleNameRemoved = removed;
    }

    private Boolean isPropertyLastNameRemoved;

    public Boolean getIsPropertyLastNameRemoved()
    {
        return this.isPropertyLastNameRemoved;
    }

    public void setIsPropertyLastNameRemoved(Boolean removed)
    {
        this.isPropertyLastNameRemoved = removed;
    }

    private Boolean isPropertyPersonalTitleRemoved;

    public Boolean getIsPropertyPersonalTitleRemoved()
    {
        return this.isPropertyPersonalTitleRemoved;
    }

    public void setIsPropertyPersonalTitleRemoved(Boolean removed)
    {
        this.isPropertyPersonalTitleRemoved = removed;
    }

    private Boolean isPropertyNicknameRemoved;

    public Boolean getIsPropertyNicknameRemoved()
    {
        return this.isPropertyNicknameRemoved;
    }

    public void setIsPropertyNicknameRemoved(Boolean removed)
    {
        this.isPropertyNicknameRemoved = removed;
    }

    private Boolean isPropertyCardIdRemoved;

    public Boolean getIsPropertyCardIdRemoved()
    {
        return this.isPropertyCardIdRemoved;
    }

    public void setIsPropertyCardIdRemoved(Boolean removed)
    {
        this.isPropertyCardIdRemoved = removed;
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
        command.setExternalId(this.getExternalId());
        command.setPreferredCurrencyUomId(this.getPreferredCurrencyUomId());
        command.setDescription(this.getDescription());
        command.setOrganizationName(this.getOrganizationName());
        command.setIsSummary(this.getIsSummary());
        command.setSalutation(this.getSalutation());
        command.setFirstName(this.getFirstName());
        command.setMiddleName(this.getMiddleName());
        command.setLastName(this.getLastName());
        command.setPersonalTitle(this.getPersonalTitle());
        command.setNickname(this.getNickname());
        command.setCardId(this.getCardId());
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
        command.setIsPropertyExternalIdRemoved(this.getIsPropertyExternalIdRemoved());
        command.setIsPropertyPreferredCurrencyUomIdRemoved(this.getIsPropertyPreferredCurrencyUomIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyOrganizationNameRemoved(this.getIsPropertyOrganizationNameRemoved());
        command.setIsPropertyIsSummaryRemoved(this.getIsPropertyIsSummaryRemoved());
        command.setIsPropertySalutationRemoved(this.getIsPropertySalutationRemoved());
        command.setIsPropertyFirstNameRemoved(this.getIsPropertyFirstNameRemoved());
        command.setIsPropertyMiddleNameRemoved(this.getIsPropertyMiddleNameRemoved());
        command.setIsPropertyLastNameRemoved(this.getIsPropertyLastNameRemoved());
        command.setIsPropertyPersonalTitleRemoved(this.getIsPropertyPersonalTitleRemoved());
        command.setIsPropertyNicknameRemoved(this.getIsPropertyNicknameRemoved());
        command.setIsPropertyCardIdRemoved(this.getIsPropertyCardIdRemoved());
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

