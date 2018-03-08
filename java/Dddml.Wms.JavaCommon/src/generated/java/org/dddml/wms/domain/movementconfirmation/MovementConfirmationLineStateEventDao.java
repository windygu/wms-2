package org.dddml.wms.domain.movementconfirmation;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineStateEventDao
{
    void save(MovementConfirmationLineStateEvent e);

    Iterable<MovementConfirmationLineStateEvent> findByMovementConfirmationEventId(MovementConfirmationEventId movementConfirmationEventId);

}

