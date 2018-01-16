package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface DamageTypeCommand extends Command
{
    String getDamageTypeId();

    void setDamageTypeId(String damageTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(DamageTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((DamageTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((DamageTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(DamageTypeCommand c) {
        return ((c instanceof DamageTypeCommand.CreateDamageType) 
            && c.getVersion().equals(DamageTypeState.VERSION_NULL));
    }

    interface CreateOrMergePatchDamageType extends DamageTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        String getSequenceId();

        void setSequenceId(String sequenceId);

        String getDefaultHandlingMethodId();

        void setDefaultHandlingMethodId(String defaultHandlingMethodId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateDamageType extends CreateOrMergePatchDamageType
    {
    }

    interface MergePatchDamageType extends CreateOrMergePatchDamageType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyDefaultHandlingMethodIdRemoved();

        void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteDamageType extends DamageTypeCommand
	{
	}

}

