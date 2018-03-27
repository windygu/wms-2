package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface LocatorTypeCommand extends Command
{
    String getLocatorTypeId();

    void setLocatorTypeId(String locatorTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(LocatorTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((LocatorTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((LocatorTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(LocatorTypeCommand c) {
        return ((c instanceof LocatorTypeCommand.CreateLocatorType) 
            && c.getVersion().equals(LocatorTypeState.VERSION_NULL));
    }

    interface CreateOrMergePatchLocatorType extends LocatorTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateLocatorType extends CreateOrMergePatchLocatorType
    {
    }

    interface MergePatchLocatorType extends CreateOrMergePatchLocatorType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteLocatorType extends LocatorTypeCommand
	{
	}

}

