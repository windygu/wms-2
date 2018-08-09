package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface GoodIdentificationTypeCommand extends Command
{
    String getGoodIdentificationTypeId();

    void setGoodIdentificationTypeId(String goodIdentificationTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(GoodIdentificationTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((GoodIdentificationTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((GoodIdentificationTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(GoodIdentificationTypeCommand c) {
        return ((c instanceof GoodIdentificationTypeCommand.CreateGoodIdentificationType) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(GoodIdentificationTypeState.VERSION_NULL)));
    }

    interface CreateOrMergePatchGoodIdentificationType extends GoodIdentificationTypeCommand
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

    interface CreateGoodIdentificationType extends CreateOrMergePatchGoodIdentificationType
    {
    }

    interface MergePatchGoodIdentificationType extends CreateOrMergePatchGoodIdentificationType
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

	interface DeleteGoodIdentificationType extends GoodIdentificationTypeCommand
	{
	}

}

