package org.dddml.wms.domain.movementconfirmation;

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

    String getMovementConfirmationDocumentNumber();

    void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber);

    interface CreateOrMergePatchMovementConfirmationLine extends MovementConfirmationLineCommand
    {
        String getMovementLineNumber();

        void setMovementLineNumber(String movementLineNumber);

        BigDecimal getTargetQuantity();

        void setTargetQuantity(BigDecimal targetQuantity);

        BigDecimal getConfirmedQuantity();

        void setConfirmedQuantity(BigDecimal confirmedQuantity);

        BigDecimal getDifferenceQuantity();

        void setDifferenceQuantity(BigDecimal differenceQuantity);

        BigDecimal getScrappedQuantity();

        void setScrappedQuantity(BigDecimal scrappedQuantity);

        String getDescription();

        void setDescription(String description);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovementConfirmationLine extends CreateOrMergePatchMovementConfirmationLine
    {
    }

    interface MergePatchMovementConfirmationLine extends CreateOrMergePatchMovementConfirmationLine
    {
        Boolean getIsPropertyMovementLineNumberRemoved();

        void setIsPropertyMovementLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyTargetQuantityRemoved();

        void setIsPropertyTargetQuantityRemoved(Boolean removed);

        Boolean getIsPropertyConfirmedQuantityRemoved();

        void setIsPropertyConfirmedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDifferenceQuantityRemoved();

        void setIsPropertyDifferenceQuantityRemoved(Boolean removed);

        Boolean getIsPropertyScrappedQuantityRemoved();

        void setIsPropertyScrappedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveMovementConfirmationLine extends MovementConfirmationLineCommand
	{
	}

}

