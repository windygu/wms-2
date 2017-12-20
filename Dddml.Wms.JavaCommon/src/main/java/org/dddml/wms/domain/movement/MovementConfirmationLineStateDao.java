package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineStateDao
{
    MovementConfirmationLineState get(MovementConfirmationLineId id, boolean nullAllowed);

    void save(MovementConfirmationLineState state);

    Iterable<MovementConfirmationLineState> findByMovementDocumentNumber(String movementDocumentNumber);

    void delete(MovementConfirmationLineState state);
}


