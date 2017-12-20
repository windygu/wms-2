package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.List;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementConfirmationLineMvoAggregate
{
    MovementConfirmationLineMvoState getState();

    List<Event> getChanges();

    void create(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c);

    void mergePatch(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c);

    void delete(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c);

    void throwOnInvalidStateTransition(Command c);
}

