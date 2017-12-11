package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import org.dddml.wms.domain.*;
import java.util.Date;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrganizationStructureCommand extends Command
{
    OrganizationStructureId getId();

    void setId(OrganizationStructureId id);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(OrganizationStructureState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((OrganizationStructureCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((OrganizationStructureCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrganizationStructureCommand c) {
        return ((c instanceof OrganizationStructureCommand.CreateOrganizationStructure) 
            && c.getVersion().equals(OrganizationStructureState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrganizationStructure extends OrganizationStructureCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrganizationStructure extends CreateOrMergePatchOrganizationStructure
    {
    }

    interface MergePatchOrganizationStructure extends CreateOrMergePatchOrganizationStructure
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteOrganizationStructure extends OrganizationStructureCommand
	{
	}

}

