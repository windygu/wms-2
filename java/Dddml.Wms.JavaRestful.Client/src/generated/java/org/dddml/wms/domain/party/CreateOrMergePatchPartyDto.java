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

    public static class CreatePartyDto extends CreateOrMergePatchPartyDto
    {
        public CreatePartyDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
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

    }

}

