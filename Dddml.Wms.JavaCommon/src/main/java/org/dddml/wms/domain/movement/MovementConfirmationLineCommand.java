package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementConfirmationLineCommand extends Command
{
    String getLineNumber();

    void setLineNumber(String lineNumber);

    String getMovementDocumentNumber();

    void setMovementDocumentNumber(String movementDocumentNumber);

    interface CreateOrMergePatchMovementConfirmationLine extends MovementConfirmationLineCommand
    {
        BigDecimal getTargetQuantity();

        void setTargetQuantity(BigDecimal targetQuantity);

        BigDecimal getConfirmedQuantity();

        void setConfirmedQuantity(BigDecimal confirmedQuantity);

        BigDecimal getDifferenceQuantity();

        void setDifferenceQuantity(BigDecimal differenceQuantity);

        BigDecimal getScrappedQuantity();

        void setScrappedQuantity(BigDecimal scrappedQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovementConfirmationLine extends CreateOrMergePatchMovementConfirmationLine
    {
    }

    interface MergePatchMovementConfirmationLine extends CreateOrMergePatchMovementConfirmationLine
    {
        Boolean getIsPropertyTargetQuantityRemoved();

        void setIsPropertyTargetQuantityRemoved(Boolean removed);

        Boolean getIsPropertyConfirmedQuantityRemoved();

        void setIsPropertyConfirmedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDifferenceQuantityRemoved();

        void setIsPropertyDifferenceQuantityRemoved(Boolean removed);

        Boolean getIsPropertyScrappedQuantityRemoved();

        void setIsPropertyScrappedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveMovementConfirmationLine extends MovementConfirmationLineCommand
	{
	}

}

