package org.dddml.wms.domain.movementconfirmation;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineEventDao
{
    void save(MovementConfirmationLineEvent e);

    Iterable<MovementConfirmationLineEvent> findByMovementConfirmationEventId(MovementConfirmationEventId movementConfirmationEventId);

}

