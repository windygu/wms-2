package org.dddml.wms.domain.movementtype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementTypeAggregate
{
    MovementTypeState getState();

    List<Event> getChanges();

    void create(MovementTypeCommand.CreateMovementType c);

    void mergePatch(MovementTypeCommand.MergePatchMovementType c);

    void delete(MovementTypeCommand.DeleteMovementType c);

    void throwOnInvalidStateTransition(Command c);
}

