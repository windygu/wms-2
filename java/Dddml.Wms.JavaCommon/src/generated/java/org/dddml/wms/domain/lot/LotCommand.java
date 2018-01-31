package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface LotCommand extends Command
{
    String getLotId();

    void setLotId(String lotId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(LotState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((LotCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((LotCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(LotCommand c) {
        return ((c instanceof LotCommand.CreateLot) 
            && c.getVersion().equals(LotState.VERSION_NULL));
    }

    interface CreateOrMergePatchLot extends LotCommand
    {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.sql.Timestamp getExpirationDate();

        void setExpirationDate(java.sql.Timestamp expirationDate);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateLot extends CreateOrMergePatchLot
    {
    }

    interface MergePatchLot extends CreateOrMergePatchLot
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyExpirationDateRemoved();

        void setIsPropertyExpirationDateRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteLot extends LotCommand
	{
	}

}

