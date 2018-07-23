package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface RejectionReasonCommand extends Command
{
    String getRejectionReasonId();

    void setRejectionReasonId(String rejectionReasonId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(RejectionReasonState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((RejectionReasonCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((RejectionReasonCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(RejectionReasonCommand c) {
        return ((c instanceof RejectionReasonCommand.CreateRejectionReason) 
            && c.getVersion().equals(RejectionReasonState.VERSION_NULL));
    }

    interface CreateOrMergePatchRejectionReason extends RejectionReasonCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateRejectionReason extends CreateOrMergePatchRejectionReason
    {
    }

    interface MergePatchRejectionReason extends CreateOrMergePatchRejectionReason
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteRejectionReason extends RejectionReasonCommand
	{
	}

}

