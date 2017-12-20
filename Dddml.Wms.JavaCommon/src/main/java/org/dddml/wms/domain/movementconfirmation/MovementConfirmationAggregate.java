package org.dddml.wms.domain.movementconfirmation;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementConfirmationAggregate
{
    MovementConfirmationState getState();

    List<Event> getChanges();

    void create(MovementConfirmationCommand.CreateMovementConfirmation c);

    void mergePatch(MovementConfirmationCommand.MergePatchMovementConfirmation c);

    void delete(MovementConfirmationCommand.DeleteMovementConfirmation c);

    void throwOnInvalidStateTransition(Command c);
}

