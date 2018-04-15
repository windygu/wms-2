package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementLineEventDao
{
    void save(MovementLineEvent e);

    Iterable<MovementLineEvent> findByMovementEventId(MovementEventId movementEventId);

}

