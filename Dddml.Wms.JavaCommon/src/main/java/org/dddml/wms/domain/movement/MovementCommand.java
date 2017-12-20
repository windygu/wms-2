package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementCommand extends Command
{
    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(MovementState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((MovementCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((MovementCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(MovementCommand c) {
        return ((c instanceof MovementCommand.CreateMovement) 
            && c.getVersion().equals(MovementState.VERSION_NULL));
    }

    interface CreateOrMergePatchMovement extends MovementCommand
    {
        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        String getDocumentAction();

        void setDocumentAction(String documentAction);

        String getMovementTypeId();

        void setMovementTypeId(String movementTypeId);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovement extends CreateOrMergePatchMovement
    {
        CreateMovementLineCommands getMovementLines();

        MovementLineCommand.CreateMovementLine newCreateMovementLine();

        CreateMovementConfirmationLineCommands getMovementConfirmationLines();

        MovementConfirmationLineCommand.CreateMovementConfirmationLine newCreateMovementConfirmationLine();

    }

    interface MergePatchMovement extends CreateOrMergePatchMovement
    {
        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementTypeIdRemoved();

        void setIsPropertyMovementTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        MovementLineCommands getMovementLineCommands();

        MovementLineCommand.CreateMovementLine newCreateMovementLine();

        MovementLineCommand.MergePatchMovementLine newMergePatchMovementLine();

        MovementLineCommand.RemoveMovementLine newRemoveMovementLine();

        MovementConfirmationLineCommands getMovementConfirmationLineCommands();

        MovementConfirmationLineCommand.CreateMovementConfirmationLine newCreateMovementConfirmationLine();

        MovementConfirmationLineCommand.MergePatchMovementConfirmationLine newMergePatchMovementConfirmationLine();

        MovementConfirmationLineCommand.RemoveMovementConfirmationLine newRemoveMovementConfirmationLine();

    }

	interface DeleteMovement extends MovementCommand
	{
	}

    interface CreateMovementLineCommands extends Iterable<MovementLineCommand.CreateMovementLine>
    {
        void add(MovementLineCommand.CreateMovementLine c);

        void remove(MovementLineCommand.CreateMovementLine c);

        void clear();
    }

    interface MovementLineCommands extends Iterable<MovementLineCommand>
    {
        void add(MovementLineCommand c);

        void remove(MovementLineCommand c);

        void clear();
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

