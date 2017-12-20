package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementLineStateDao
{
    MovementLineState get(MovementLineId id, boolean nullAllowed);

    void save(MovementLineState state);

    Iterable<MovementLineState> findByMovementDocumentNumber(String movementDocumentNumber);

    void delete(MovementLineState state);
}


