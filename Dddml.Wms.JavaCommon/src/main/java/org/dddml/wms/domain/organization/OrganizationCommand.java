package org.dddml.wms.domain.organization;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrganizationCommand extends Command
{
    String getPartyId();

    void setPartyId(String partyId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(OrganizationState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((OrganizationCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((OrganizationCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrganizationCommand c) {
        return ((c instanceof OrganizationCommand.CreateOrganization) 
            && c.getVersion().equals(OrganizationState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrganization extends OrganizationCommand
    {
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

    interface CreateOrganization extends CreateOrMergePatchOrganization
    {
    }

    interface MergePatchOrganization extends CreateOrMergePatchOrganization
    {
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

	interface DeleteOrganization extends OrganizationCommand
	{
	}

}

