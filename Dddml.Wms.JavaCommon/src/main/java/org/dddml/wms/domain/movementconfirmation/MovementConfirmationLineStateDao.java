package org.dddml.wms.domain.movementconfirmation;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineStateDao
{
    MovementConfirmationLineState get(MovementConfirmationLineId id, boolean nullAllowed);

    void save(MovementConfirmationLineState state);

    Iterable<MovementConfirmationLineState> findByMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber);

    void delete(MovementConfirmationLineState state);
}


