package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PartyCommand extends Command
{
    String getPartyId();

    void setPartyId(String partyId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PartyState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PartyCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PartyCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PartyCommand c) {
        return ((c instanceof PartyCommand.CreateParty) 
            && c.getVersion().equals(PartyState.VERSION_NULL));
    }

    interface CreateOrMergePatchParty extends PartyCommand
    {
        String getPartyTypeId();

        void setPartyTypeId(String partyTypeId);

        String getPrimaryRoleTypeId();

        void setPrimaryRoleTypeId(String primaryRoleTypeId);

        String getOrganizationName();

        void setOrganizationName(String organizationName);

        String getDescription();

        void setDescription(String description);

        String getType();

        void setType(String type);

        Boolean getIsSummary();

        void setIsSummary(Boolean isSummary);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateParty extends CreateOrMergePatchParty
    {
    }

    interface MergePatchParty extends CreateOrMergePatchParty
    {
        Boolean getIsPropertyPartyTypeIdRemoved();

        void setIsPropertyPartyTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryRoleTypeIdRemoved();

        void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrganizationNameRemoved();

        void setIsPropertyOrganizationNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyTypeRemoved();

        void setIsPropertyTypeRemoved(Boolean removed);

        Boolean getIsPropertyIsSummaryRemoved();

        void setIsPropertyIsSummaryRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteParty extends PartyCommand
	{

        String getPartyTypeId();

        void setPartyTypeId(String partyTypeId);
	}

}

