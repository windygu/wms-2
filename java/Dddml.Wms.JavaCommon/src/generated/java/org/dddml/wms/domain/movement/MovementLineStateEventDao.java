package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementLineStateEventDao
{
    void save(MovementLineStateEvent e);

    Iterable<MovementLineStateEvent> findByMovementEventId(MovementEventId movementEventId);

}

