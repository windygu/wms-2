package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrganizationStructureTypeCommand extends Command
{
    String getId();

    void setId(String id);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(OrganizationStructureTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((OrganizationStructureTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((OrganizationStructureTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrganizationStructureTypeCommand c) {
        return ((c instanceof OrganizationStructureTypeCommand.CreateOrganizationStructureType) 
            && c.getVersion().equals(OrganizationStructureTypeState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrganizationStructureType extends OrganizationStructureTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrganizationStructureType extends CreateOrMergePatchOrganizationStructureType
    {
    }

    interface MergePatchOrganizationStructureType extends CreateOrMergePatchOrganizationStructureType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteOrganizationStructureType extends OrganizationStructureTypeCommand
	{
	}

}

