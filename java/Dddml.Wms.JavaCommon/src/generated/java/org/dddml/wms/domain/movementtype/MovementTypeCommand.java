package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementTypeCommand extends Command
{
    String getMovementTypeId();

    void setMovementTypeId(String movementTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(MovementTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((MovementTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((MovementTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(MovementTypeCommand c) {
        return ((c instanceof MovementTypeCommand.CreateMovementType) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(MovementTypeState.VERSION_NULL)));
    }

    interface CreateOrMergePatchMovementType extends MovementTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovementType extends CreateOrMergePatchMovementType
    {
    }

    interface MergePatchMovementType extends CreateOrMergePatchMovementType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteMovementType extends MovementTypeCommand
	{
	}

}

