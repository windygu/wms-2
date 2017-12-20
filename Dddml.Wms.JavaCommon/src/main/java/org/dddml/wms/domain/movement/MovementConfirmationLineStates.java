package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface MovementConfirmationLineStates extends Iterable<MovementConfirmationLineState>, Saveable
{
    MovementConfirmationLineState get(String lineNumber);

    MovementConfirmationLineState get(String lineNumber, boolean forCreation);

    MovementConfirmationLineState get(String lineNumber, boolean forCreation, boolean nullAllowed);

    void remove(MovementConfirmationLineState state);

    void addToSave(MovementConfirmationLineState state);

}


