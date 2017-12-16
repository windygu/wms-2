package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface StatusItemCommand extends Command
{
    String getStatusId();

    void setStatusId(String statusId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(StatusItemState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((StatusItemCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((StatusItemCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(StatusItemCommand c) {
        return ((c instanceof StatusItemCommand.CreateStatusItem) 
            && c.getVersion().equals(StatusItemState.VERSION_NULL));
    }

    interface CreateOrMergePatchStatusItem extends StatusItemCommand
    {
        String getStatusTypeId();

        void setStatusTypeId(String statusTypeId);

        String getStatusCode();

        void setStatusCode(String statusCode);

        String getSequenceId();

        void setSequenceId(String sequenceId);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateStatusItem extends CreateOrMergePatchStatusItem
    {
    }

    interface MergePatchStatusItem extends CreateOrMergePatchStatusItem
    {
        Boolean getIsPropertyStatusTypeIdRemoved();

        void setIsPropertyStatusTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyStatusCodeRemoved();

        void setIsPropertyStatusCodeRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteStatusItem extends StatusItemCommand
	{
	}

}

