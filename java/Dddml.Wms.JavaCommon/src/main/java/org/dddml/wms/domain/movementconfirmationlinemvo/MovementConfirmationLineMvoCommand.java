package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementConfirmationLineMvoCommand extends Command
{
    MovementConfirmationLineId getMovementConfirmationLineId();

    void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId);

    Long getMovementConfirmationVersion();

    void setMovementConfirmationVersion(Long movementConfirmationVersion);

    static void throwOnInvalidStateTransition(MovementConfirmationLineMvoState state, Command c) {
        if (state.getMovementConfirmationVersion() == null)
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
            && c.getMovementConfirmationVersion().equals(MovementConfirmationLineMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand
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

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getMovementConfirmationDocumentStatusId();

        void setMovementConfirmationDocumentStatusId(String movementConfirmationDocumentStatusId);

        String getMovementConfirmationMovementDocumentNumber();

        void setMovementConfirmationMovementDocumentNumber(String movementConfirmationMovementDocumentNumber);

        Boolean getMovementConfirmationIsApproved();

        void setMovementConfirmationIsApproved(Boolean movementConfirmationIsApproved);

        BigDecimal getMovementConfirmationApprovalAmount();

        void setMovementConfirmationApprovalAmount(BigDecimal movementConfirmationApprovalAmount);

        Boolean getMovementConfirmationProcessed();

        void setMovementConfirmationProcessed(Boolean movementConfirmationProcessed);

        String getMovementConfirmationProcessing();

        void setMovementConfirmationProcessing(String movementConfirmationProcessing);

        String getMovementConfirmationDocumentTypeId();

        void setMovementConfirmationDocumentTypeId(String movementConfirmationDocumentTypeId);

        String getMovementConfirmationDescription();

        void setMovementConfirmationDescription(String movementConfirmationDescription);

        String getMovementConfirmationCreatedBy();

        void setMovementConfirmationCreatedBy(String movementConfirmationCreatedBy);

        Date getMovementConfirmationCreatedAt();

        void setMovementConfirmationCreatedAt(Date movementConfirmationCreatedAt);

        String getMovementConfirmationUpdatedBy();

        void setMovementConfirmationUpdatedBy(String movementConfirmationUpdatedBy);

        Date getMovementConfirmationUpdatedAt();

        void setMovementConfirmationUpdatedAt(Date movementConfirmationUpdatedAt);

        Boolean getMovementConfirmationActive();

        void setMovementConfirmationActive(Boolean movementConfirmationActive);

        Boolean getMovementConfirmationDeleted();

        void setMovementConfirmationDeleted(Boolean movementConfirmationDeleted);

    }

    interface CreateMovementConfirmationLineMvo extends CreateOrMergePatchMovementConfirmationLineMvo
    {
    }

    interface MergePatchMovementConfirmationLineMvo extends CreateOrMergePatchMovementConfirmationLineMvo
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

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationDocumentStatusIdRemoved();

        void setIsPropertyMovementConfirmationDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationMovementDocumentNumberRemoved();

        void setIsPropertyMovementConfirmationMovementDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationIsApprovedRemoved();

        void setIsPropertyMovementConfirmationIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationApprovalAmountRemoved();

        void setIsPropertyMovementConfirmationApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationProcessedRemoved();

        void setIsPropertyMovementConfirmationProcessedRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationProcessingRemoved();

        void setIsPropertyMovementConfirmationProcessingRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationDocumentTypeIdRemoved();

        void setIsPropertyMovementConfirmationDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationDescriptionRemoved();

        void setIsPropertyMovementConfirmationDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationCreatedByRemoved();

        void setIsPropertyMovementConfirmationCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationCreatedAtRemoved();

        void setIsPropertyMovementConfirmationCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationUpdatedByRemoved();

        void setIsPropertyMovementConfirmationUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationUpdatedAtRemoved();

        void setIsPropertyMovementConfirmationUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationActiveRemoved();

        void setIsPropertyMovementConfirmationActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementConfirmationDeletedRemoved();

        void setIsPropertyMovementConfirmationDeletedRemoved(Boolean removed);

    }

	interface DeleteMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand
	{
	}

}

