package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPartyCommand extends AbstractCommand implements PartyCommand
{
    private String partyId;

    public String getPartyId()
    {
        return this.partyId;
    }

    public void setPartyId(String partyId)
    {
        this.partyId = partyId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchParty extends AbstractPartyCommand implements CreateOrMergePatchParty
    {
        private String partyTypeId;

        public String getPartyTypeId()
        {
            return this.partyTypeId;
        }

        public void setPartyTypeId(String partyTypeId)
        {
            this.partyTypeId = partyTypeId;
        }

        private String organizationName;

        public String getOrganizationName()
        {
            return this.organizationName;
        }

        public void setOrganizationName(String organizationName)
        {
            this.organizationName = organizationName;
        }

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private String type;

        public String getType()
        {
            return this.type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        private Boolean isSummary;

        public Boolean getIsSummary()
        {
            return this.isSummary;
        }

        public void setIsSummary(Boolean isSummary)
        {
            this.isSummary = isSummary;
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

    }

    public static abstract class AbstractCreateParty extends AbstractCreateOrMergePatchParty implements CreateParty
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchParty extends AbstractCreateOrMergePatchParty implements MergePatchParty
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

    }

    public static class SimpleCreateParty extends AbstractCreateParty
    {
    }

	public static class SimpleCreateOrganization extends SimpleCreateParty {
        public SimpleCreateOrganization() {
            super.setPartyTypeId(PartyTypeIds.ORGANIZATION);
        }
    }

    
    public static class SimpleMergePatchParty extends AbstractMergePatchParty
    {
    }

	public static class SimpleMergePatchOrganization extends SimpleMergePatchParty {
        public SimpleMergePatchOrganization() {
            super.setPartyTypeId(PartyTypeIds.ORGANIZATION);
        }
    }

    
	public static class SimpleDeleteParty extends AbstractPartyCommand implements DeleteParty
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }

        private String partyTypeId;

        public String getPartyTypeId() {
            return this.partyTypeId;
        }

        public void setPartyTypeId(String partyTypeId) {
            this.partyTypeId = partyTypeId;
        }
	}

	public static class SimpleDeleteOrganization extends SimpleDeleteParty {
        public SimpleDeleteOrganization() {
            super.setPartyTypeId(PartyTypeIds.ORGANIZATION);
        }
    }

    

}

