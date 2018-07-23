package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface UomCommand extends Command
{
    String getUomId();

    void setUomId(String uomId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(UomState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((UomCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((UomCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(UomCommand c) {
        return ((c instanceof UomCommand.CreateUom) 
            && c.getVersion().equals(UomState.VERSION_NULL));
    }

    interface CreateOrMergePatchUom extends UomCommand
    {
        String getUomTypeId();

        void setUomTypeId(String uomTypeId);

        String getAbbreviation();

        void setAbbreviation(String abbreviation);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateUom extends CreateOrMergePatchUom
    {
    }

    interface MergePatchUom extends CreateOrMergePatchUom
    {
        Boolean getIsPropertyUomTypeIdRemoved();

        void setIsPropertyUomTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyAbbreviationRemoved();

        void setIsPropertyAbbreviationRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteUom extends UomCommand
	{
	}

}

