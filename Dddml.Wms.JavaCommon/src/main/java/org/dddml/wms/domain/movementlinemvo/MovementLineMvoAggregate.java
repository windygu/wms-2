package org.dddml.wms.domain.movementlinemvo;

import java.util.List;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementLineMvoAggregate
{
    MovementLineMvoState getState();

    List<Event> getChanges();

    void create(MovementLineMvoCommand.CreateMovementLineMvo c);

    void mergePatch(MovementLineMvoCommand.MergePatchMovementLineMvo c);

    void delete(MovementLineMvoCommand.DeleteMovementLineMvo c);

    void throwOnInvalidStateTransition(Command c);
}

