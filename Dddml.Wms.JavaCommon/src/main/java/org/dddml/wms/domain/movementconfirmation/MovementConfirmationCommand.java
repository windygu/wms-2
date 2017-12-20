package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementConfirmationCommand extends Command
{
    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(MovementConfirmationState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((MovementConfirmationCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((MovementConfirmationCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(MovementConfirmationCommand c) {
        return ((c instanceof MovementConfirmationCommand.CreateMovementConfirmation) 
            && c.getVersion().equals(MovementConfirmationState.VERSION_NULL));
    }

    interface CreateOrMergePatchMovementConfirmation extends MovementConfirmationCommand
    {
        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        String getDocumentAction();

        void setDocumentAction(String documentAction);

        String getMovementDocumentNumber();

        void setMovementDocumentNumber(String movementDocumentNumber);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        BigDecimal getApprovalAmount();

        void setApprovalAmount(BigDecimal approvalAmount);

        String getProcessing();

        void setProcessing(String processing);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovementConfirmation extends CreateOrMergePatchMovementConfirmation
    {
        CreateMovementConfirmationLineCommands getMovementConfirmationLines();

        MovementConfirmationLineCommand.CreateMovementConfirmationLine newCreateMovementConfirmationLine();

    }

    interface MergePatchMovementConfirmation extends CreateOrMergePatchMovementConfirmation
    {
        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDocumentNumberRemoved();

        void setIsPropertyMovementDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyApprovalAmountRemoved();

        void setIsPropertyApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        MovementConfirmationLineCommands getMovementConfirmationLineCommands();

        MovementConfirmationLineCommand.CreateMovementConfirmationLine newCreateMovementConfirmationLine();

        MovementConfirmationLineCommand.MergePatchMovementConfirmationLine newMergePatchMovementConfirmationLine();

        MovementConfirmationLineCommand.RemoveMovementConfirmationLine newRemoveMovementConfirmationLine();

    }

	interface DeleteMovementConfirmation extends MovementConfirmationCommand
	{
	}

    interface CreateMovementConfirmationLineCommands extends Iterable<MovementConfirmationLineCommand.CreateMovementConfirmationLine>
    {
        void add(MovementConfirmationLineCommand.CreateMovementConfirmationLine c);

        void remove(MovementConfirmationLineCommand.CreateMovementConfirmationLine c);

        void clear();
    }

    interface MovementConfirmationLineCommands extends Iterable<MovementConfirmationLineCommand>
    {
        void add(MovementConfirmationLineCommand c);

        void remove(MovementConfirmationLineCommand c);

        void clear();
    }

}

