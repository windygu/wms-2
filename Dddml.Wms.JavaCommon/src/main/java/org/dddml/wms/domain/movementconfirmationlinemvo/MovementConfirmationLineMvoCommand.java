package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementConfirmationLineMvoCommand extends Command
{
    MovementConfirmationLineId getMovementConfirmationLineId();

    void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId);

    Long getMovementVersion();

    void setMovementVersion(Long movementVersion);

    static void throwOnInvalidStateTransition(MovementConfirmationLineMvoState state, Command c) {
        if (state.getMovementVersion() == null)
        {
            if (isCommandCreate((MovementConfirmationLineMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((MovementConfirmationLineMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(MovementConfirmationLineMvoCommand c) {
        return ((c instanceof MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo) 
            && c.getMovementVersion().equals(MovementConfirmationLineMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand
    {
        BigDecimal getTargetQuantity();

        void setTargetQuantity(BigDecimal targetQuantity);

        BigDecimal getConfirmedQuantity();

        void setConfirmedQuantity(BigDecimal confirmedQuantity);

        BigDecimal getDifferenceQuantity();

        void setDifferenceQuantity(BigDecimal differenceQuantity);

        BigDecimal getScrappedQuantity();

        void setScrappedQuantity(BigDecimal scrappedQuantity);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getMovementDocumentTypeId();

        void setMovementDocumentTypeId(String movementDocumentTypeId);

        String getDocumentAction();

        void setDocumentAction(String documentAction);

        String getMovementMovementTypeId();

        void setMovementMovementTypeId(String movementMovementTypeId);

        String getMovementDescription();

        void setMovementDescription(String movementDescription);

        String getMovementCreatedBy();

        void setMovementCreatedBy(String movementCreatedBy);

        Date getMovementCreatedAt();

        void setMovementCreatedAt(Date movementCreatedAt);

        String getMovementUpdatedBy();

        void setMovementUpdatedBy(String movementUpdatedBy);

        Date getMovementUpdatedAt();

        void setMovementUpdatedAt(Date movementUpdatedAt);

        Boolean getMovementActive();

        void setMovementActive(Boolean movementActive);

        Boolean getMovementDeleted();

        void setMovementDeleted(Boolean movementDeleted);

    }

    interface CreateMovementConfirmationLineMvo extends CreateOrMergePatchMovementConfirmationLineMvo
    {
    }

    interface MergePatchMovementConfirmationLineMvo extends CreateOrMergePatchMovementConfirmationLineMvo
    {
        Boolean getIsPropertyTargetQuantityRemoved();

        void setIsPropertyTargetQuantityRemoved(Boolean removed);

        Boolean getIsPropertyConfirmedQuantityRemoved();

        void setIsPropertyConfirmedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDifferenceQuantityRemoved();

        void setIsPropertyDifferenceQuantityRemoved(Boolean removed);

        Boolean getIsPropertyScrappedQuantityRemoved();

        void setIsPropertyScrappedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementDocumentTypeIdRemoved();

        void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementMovementTypeIdRemoved();

        void setIsPropertyMovementMovementTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDescriptionRemoved();

        void setIsPropertyMovementDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyMovementCreatedByRemoved();

        void setIsPropertyMovementCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementCreatedAtRemoved();

        void setIsPropertyMovementCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementUpdatedByRemoved();

        void setIsPropertyMovementUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementUpdatedAtRemoved();

        void setIsPropertyMovementUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementActiveRemoved();

        void setIsPropertyMovementActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementDeletedRemoved();

        void setIsPropertyMovementDeletedRemoved(Boolean removed);

    }

	interface DeleteMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand
	{
	}

}

