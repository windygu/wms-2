package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface DamageHandlingMethodCommand extends Command
{
    String getDamageHandlingMethodId();

    void setDamageHandlingMethodId(String damageHandlingMethodId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(DamageHandlingMethodState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((DamageHandlingMethodCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((DamageHandlingMethodCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(DamageHandlingMethodCommand c) {
        return ((c instanceof DamageHandlingMethodCommand.CreateDamageHandlingMethod) 
            && c.getVersion().equals(DamageHandlingMethodState.VERSION_NULL));
    }

    interface CreateOrMergePatchDamageHandlingMethod extends DamageHandlingMethodCommand
    {
        String getDescription();

        void setDescription(String description);

        String getSequenceId();

        void setSequenceId(String sequenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateDamageHandlingMethod extends CreateOrMergePatchDamageHandlingMethod
    {
    }

    interface MergePatchDamageHandlingMethod extends CreateOrMergePatchDamageHandlingMethod
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteDamageHandlingMethod extends DamageHandlingMethodCommand
	{
	}

}

