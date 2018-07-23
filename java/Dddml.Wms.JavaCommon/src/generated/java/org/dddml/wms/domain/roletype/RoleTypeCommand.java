package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface RoleTypeCommand extends Command
{
    String getRoleTypeId();

    void setRoleTypeId(String roleTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(RoleTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((RoleTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((RoleTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(RoleTypeCommand c) {
        return ((c instanceof RoleTypeCommand.CreateRoleType) 
            && c.getVersion().equals(RoleTypeState.VERSION_NULL));
    }

    interface CreateOrMergePatchRoleType extends RoleTypeCommand
    {
        String getParentTypeId();

        void setParentTypeId(String parentTypeId);

        String getHasTable();

        void setHasTable(String hasTable);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateRoleType extends CreateOrMergePatchRoleType
    {
    }

    interface MergePatchRoleType extends CreateOrMergePatchRoleType
    {
        Boolean getIsPropertyParentTypeIdRemoved();

        void setIsPropertyParentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyHasTableRemoved();

        void setIsPropertyHasTableRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteRoleType extends RoleTypeCommand
	{
	}

}

