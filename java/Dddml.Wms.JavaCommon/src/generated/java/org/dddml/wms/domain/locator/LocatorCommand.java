package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface LocatorCommand extends Command
{
    String getLocatorId();

    void setLocatorId(String locatorId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(LocatorState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((LocatorCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((LocatorCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(LocatorCommand c) {
        return ((c instanceof LocatorCommand.CreateLocator) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(LocatorState.VERSION_NULL)));
    }

    interface CreateOrMergePatchLocator extends LocatorCommand
    {
        String getWarehouseId();

        void setWarehouseId(String warehouseId);

        String getParentLocatorId();

        void setParentLocatorId(String parentLocatorId);

        String getLocatorType();

        void setLocatorType(String locatorType);

        String getPriorityNumber();

        void setPriorityNumber(String priorityNumber);

        Boolean getIsDefault();

        void setIsDefault(Boolean isDefault);

        String getX();

        void setX(String x);

        String getY();

        void setY(String y);

        String getZ();

        void setZ(String z);

        String getDescription();

        void setDescription(String description);

        String getLocatorTypeId();

        void setLocatorTypeId(String locatorTypeId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateLocator extends CreateOrMergePatchLocator
    {
    }

    interface MergePatchLocator extends CreateOrMergePatchLocator
    {
        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyParentLocatorIdRemoved();

        void setIsPropertyParentLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorTypeRemoved();

        void setIsPropertyLocatorTypeRemoved(Boolean removed);

        Boolean getIsPropertyPriorityNumberRemoved();

        void setIsPropertyPriorityNumberRemoved(Boolean removed);

        Boolean getIsPropertyIsDefaultRemoved();

        void setIsPropertyIsDefaultRemoved(Boolean removed);

        Boolean getIsPropertyXRemoved();

        void setIsPropertyXRemoved(Boolean removed);

        Boolean getIsPropertyYRemoved();

        void setIsPropertyYRemoved(Boolean removed);

        Boolean getIsPropertyZRemoved();

        void setIsPropertyZRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyLocatorTypeIdRemoved();

        void setIsPropertyLocatorTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteLocator extends LocatorCommand
	{
	}

}

