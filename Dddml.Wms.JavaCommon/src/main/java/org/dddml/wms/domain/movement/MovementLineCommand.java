package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementLineCommand extends Command
{
    String getLineNumber();

    void setLineNumber(String lineNumber);

    String getMovementDocumentNumber();

    void setMovementDocumentNumber(String movementDocumentNumber);

    interface CreateOrMergePatchMovementLine extends MovementLineCommand
    {
        BigDecimal getMovementQuantity();

        void setMovementQuantity(BigDecimal movementQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovementLine extends CreateOrMergePatchMovementLine
    {
    }

    interface MergePatchMovementLine extends CreateOrMergePatchMovementLine
    {
        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveMovementLine extends MovementLineCommand
	{
	}

}

