package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface DamageReasonCommand extends Command
{
    String getDamageReasonId();

    void setDamageReasonId(String damageReasonId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(DamageReasonState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((DamageReasonCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((DamageReasonCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(DamageReasonCommand c) {
        return ((c instanceof DamageReasonCommand.CreateDamageReason) 
            && c.getVersion().equals(DamageReasonState.VERSION_NULL));
    }

    interface CreateOrMergePatchDamageReason extends DamageReasonCommand
    {
        String getDescription();

        void setDescription(String description);

        String getSequenceId();

        void setSequenceId(String sequenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateDamageReason extends CreateOrMergePatchDamageReason
    {
    }

    interface MergePatchDamageReason extends CreateOrMergePatchDamageReason
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteDamageReason extends DamageReasonCommand
	{
	}

}

