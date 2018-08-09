package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PickwaveCommand extends Command
{
    Long getPickwaveId();

    void setPickwaveId(Long pickwaveId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PickwaveState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PickwaveCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PickwaveCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PickwaveCommand c) {
        return ((c instanceof PickwaveCommand.CreatePickwave) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(PickwaveState.VERSION_NULL)));
    }

    interface CreateOrMergePatchPickwave extends PickwaveCommand
    {
        String getStatusId();

        void setStatusId(String statusId);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePickwave extends CreateOrMergePatchPickwave
    {
    }

    interface MergePatchPickwave extends CreateOrMergePatchPickwave
    {
        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeletePickwave extends PickwaveCommand
	{
	}

}

