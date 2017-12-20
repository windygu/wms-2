package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineStateEventDao
{
    void save(MovementConfirmationLineStateEvent e);

    Iterable<MovementConfirmationLineStateEvent> findByMovementStateEventId(MovementStateEventId movementStateEventId);

}

