package org.dddml.wms.domain.movement;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementAggregate
{
    MovementState getState();

    List<Event> getChanges();

    void create(MovementCommand.CreateMovement c);

    void mergePatch(MovementCommand.MergePatchMovement c);

    void delete(MovementCommand.DeleteMovement c);

    void documentAction(String value, Long version, String commandId, String requesterId);

    void throwOnInvalidStateTransition(Command c);
}

